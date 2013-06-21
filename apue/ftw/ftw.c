#include "../apue.h"
#include <dirent.h>
#include <limits.h>
#include <unistd.h>
#include <malloc.h>
#include <sys/stat.h>

typedef int Myfunc(const char *, const struct stat *, int);

static Myfunc myfunc;
static int myftw(char *, Myfunc *);
static int dopath(Myfunc *);
static long nreg, ndir, nblk, nchr, nfifo, nslink, nsock, ntot;

#define FTW_F 1
#define FTW_D 2
#define FTW_DNR 3
#define FTW_NS 4

#define PATH_MAX_GUESS 1023
#define DIR_MAX_NAME 255

char buff[] = "abcdefghij";
char cwd[80];
char wholepath[1024];
char * ptr2 = wholepath;
static char * fullpath;

static int myftw(char *pathname, Myfunc  *func)
{
     int len;
//     fullpath = (char *)path_alloc(&len);
     fullpath = (char *) malloc(sizeof (char) * PATH_MAX_GUESS);
     len = PATH_MAX_GUESS;

     strncpy(fullpath, pathname, len);
     fullpath[len-1] = 0;
     
     return dopath(func);
}

static int dopath(Myfunc * func)
{
     struct stat statbuf;
     struct dirent *dirp;
     DIR *dp;
     int ret;
     char * ptr;


     printf("%s\n", fullpath);
     if (lstat(fullpath, &statbuf) < 0)
     {
	  return (func(fullpath, &statbuf, FTW_NS));
     }

     if (S_ISDIR(statbuf.st_mode) == 0)
     {
	  return (func(fullpath, &statbuf, FTW_F));
     }

     if ((ret = func(fullpath, &statbuf, FTW_D)) != 0)
	  return ret;
     ptr = fullpath + strlen(fullpath);
     *ptr++ = '/';
     *ptr = 0;

     if ((dp = opendir(fullpath)) == NULL)
     {
	  return (func(fullpath, &statbuf, FTW_DNR));	  
     }

     while((dirp = readdir(dp)) != NULL)
     {
	  if ((strcmp(dirp->d_name, ".") == 0) || (strcmp(dirp->d_name, "..") == 0))
	       continue;
	  strcpy(ptr, dirp->d_name);
	  if (ret = dopath(func) != 0)
	       break;
     }

     ptr[-1] = 0;
     if (closedir(dp) < 0)
	  printf("can't close directory %s\n", fullpath);
     return ret;
}

static int myfunc(const char *pathname, const struct stat * statptr, int type)
{
     switch(type)
     {
     case FTW_F:
     {
	  switch(statptr->st_mode & S_IFMT)
	  {
	  case S_IFREG:nreg++;break;
	  case S_IFBLK:nblk++;break;
	  case S_IFCHR:nchr++;break;
	  case S_IFIFO:nfifo++;break;
	  case S_IFLNK:nslink++;break;
	  case S_IFSOCK:nsock++;break;
	  case S_IFDIR:
	       printf("for S_IFDIR for %s\n", pathname);
	  }
	  break;
     }
     case FTW_D:
	  ndir++;
	  break;
     case FTW_DNR:
	  printf("can't read directory: %s\n", pathname);
	  break;
     case FTW_NS:
	  printf("stat error for %s\n", pathname);
	  break;
     default:
	  printf("unknow type %d for pathname %s\n", type, pathname);
     }

     return 0;
}

int printpath(char *path)
{
     DIR *dp ;
     struct dirent *dirp;

     if ((dp = opendir(path)) == NULL)
     {
	  printf("open dir %s error \n", path);
	  goto back2;
     }

     while((dirp = readdir(dp)) != NULL)
     {
	  printf("%s\n", dirp->d_name);
     }
back2:
     if (dp)
	  closedir(dp);
     return;
}
int creatLongNameDir()
{
     char * dirname;
     int nameLen = 0;
     int copycount = 10;

     dirname = (char *)malloc(DIR_MAX_NAME);

     while (nameLen < DIR_MAX_NAME)
     {
	  strncpy((dirname + nameLen), buff, copycount);
	  nameLen += 10;
	  if ((DIR_MAX_NAME - nameLen) < copycount)
	  {
	       copycount = DIR_MAX_NAME - nameLen - 1;
	  }
     }
     dirname[DIR_MAX_NAME - 1] = 0;
//     printf("dirname length = %d\t dirname = %s\n", strlen(dirname), dirname);

     mkdir(dirname, RWXRWXRWX);
     if (dirname)
	  free(dirname);
     return ;
}

int walkpath(char *path)
{
     struct stat statbuf;
     struct dirent *dirp;
     DIR *dp;
     int ret;

     if ((PATH_MAX_GUESS - strlen(wholepath)) <= (DIR_MAX_NAME * 2))
	  return ;

//     printf("%s\n", wholepath);
     if (lstat(path, &statbuf) < 0)
     {
	  printf("lstat %s error, return!\n", wholepath);
	  goto back3;
     }

     if (S_ISDIR(statbuf.st_mode) == 0)
     {
	  return ;
     }
     strncpy(ptr2, path, strlen(path));
     ptr2[strlen(path)] = 0;

     chdir(path);
//     chroot(path);
     getcwd(cwd,sizeof(cwd));
     printf("%s\n", cwd);

     creatLongNameDir();

     ptr2 = ptr2 + strlen(path);
     *ptr2++ = '/';
     *ptr2 = 0;

     if ((dp = opendir(".")) == NULL)
     {
	  printf("opendir %s error, return!\n", path);
	  goto back3;
     }

     while((dirp = readdir(dp)) != NULL)
     {
//	  printf("%s\n", dirp->d_name);
	  if ((strcmp(dirp->d_name, ".") == 0) || (strcmp(dirp->d_name,"..") == 0))
	       continue;

//	  strcpy(ptr, dirp->d_name);
	  walkpath(dirp->d_name);
     }

back3:
     if (dp)
	  closedir(dp);
     chdir("..");
     return;
}
int main(int argc, char *argv[])
{
     int ret = 0;
     if (argc != 2)
     {
	  printf("usage: myftw <starting-pathname>\n");
	  goto back;
     }
//     printpath(argv[1]);
     walkpath(argv[1]);
//     chdir(argv[1]);
     chdir("ftw");
     ret = myftw(argv[1], myfunc);
     ntot = nreg + ndir + nchr + nfifo + nslink + nsock;
     if (ntot == 0)
	  ntot = 1;
     printf("regular files  = %7ld, %5.2f%%\n", nreg, nreg*100.00/ntot);
     printf("directories    = %7ld, %5.2f%%\n", ndir, ndir*100.0/ntot);
     printf("block special  = %7ld, %5.2f%%\n", nblk, nblk*100.0/ntot);
     printf("char special   = %7ld, %5.2f%%\n", nchr, nchr*100.0/ntot);
     printf("FIFOS          = %7ld, %5.2f%%\n", nfifo, nfifo*100.0/ntot);
     printf("symbolic links = %7ld, %5.2f%%\n", nslink, nslink*100.0/ntot);
     printf("sockets        = %7ld, %5.2f%%\n", nsock, nsock*100.0/ntot);

back:
     exit(ret);
}
