#include "../apue.h"
#include <fcntl.h>
#include <dirent.h>
#include <malloc.h>
#include <utime.h>
#include <time.h>
#include <sys/stat.h>

#define MAX_NAME_LENGTH 255

char buff[] = "jklmnopqrst";
char *maxName;
int pathCount = 0;
char cwd[6000];

int prepareNameMax()
{
     int nameLen = 0;
     int buffLen = strlen(buff);
     maxName = (char *)malloc(sizeof(char) * MAX_NAME_LENGTH);
     
     while(nameLen < MAX_NAME_LENGTH)
     {
	  strncpy((maxName + nameLen), buff, buffLen);
	  nameLen += buffLen;
	  if ((MAX_NAME_LENGTH - nameLen) < buffLen)
	       buffLen = MAX_NAME_LENGTH - nameLen - 1;
     }
     maxName[nameLen] = 0;
     printf("length = %d\n", (int)strlen(maxName));
     return;
}

int pathWalk(char *path)
{
     struct stat statbuf;
     struct dirent * dirp;
     DIR *dp;

     if (pathCount > 22)
     {
	  getcwd(cwd, sizeof(cwd));
	  printf("%s\n", cwd);
	  if ((dp = opendir(cwd)) == NULL)
	  {
	       printf("opendir error, return\n");
	       return ;
	  }

	  pathCount = 0;
	  return ;
     }
/*
     if ((lstat(path, &statbuf)) < 0)
     {
	  printf("lstat error %s\n", path);
	  return ;
     }

     if (S_ISDIR(statbuf.st_mode) == 0)
     {
	  return;
     }
*/   
     mkdir(maxName, RWXRWXRWX);
     chdir(maxName);
     pathCount++;
     printf("%d\n", pathCount);
     pathWalk(maxName);
     return ;
}

int reachPathMax(int argc, char * argv[])
{
     prepareNameMax();
     pathWalk(argv[1]);

back4:
     if(maxName)
	  free(maxName);
}

int atimeChange(int argc, char *argv[])
{
     int i, fd;
     struct stat statbuf;
     struct utimbuf timebuf;
     int seconds;

     for (i = 1; i < argc; i++)
     {
	  if (stat(argv[i], &statbuf) < 0)
	  {
	       printf("error stat %s\n", argv[i]);
	       continue;
	  }

	  if ((fd = open(argv[i], O_RDWR, RWRWRW)) < 0)
	  {
	       printf("error open %s\n", argv[i]);
	       continue;
	  }

	  if (write(fd, &buff, strlen(buff)) != strlen(buff))
	  {
	       printf("error write %s\n", argv[i]);
	       if (fd)
		    close(fd);
	       continue;
	  }
	  if (fd)
	       close(fd);
	  seconds = time((time_t*)NULL);
	  timebuf.actime = seconds;
	  timebuf.modtime = statbuf.st_mtime;
	  if (utime(argv[i], &timebuf) < 0)
	  {
	       printf("error utime %s\n", argv[i]);
	       continue;
	  }
     }
     return ;
}

int truncTimeRegain(int argc, char *argv[])
{
     int i, fd;
     struct stat statbuf;
     struct utimbuf timebuf;

     for (i = 1; i < argc; i++)
     {
	  if (stat(argv[i], &statbuf) < 0)
	  {
	       printf("error stat %s\n", argv[i]);
	       continue;
	  }

	  if ((fd = open(argv[i], O_RDWR | O_TRUNC)) < 0)
	  {
	       printf("error open %s\n", argv[i]);
	       continue;
	  }
	  close(fd);
	  timebuf.actime = statbuf.st_atime;
	  timebuf.modtime = statbuf.st_mtime;
	  if (utime(argv[i], &timebuf) < 0)
	  {
	       printf("error utime %s\n", argv[i]);
	       continue;
	  }
     }

back1:
     return ;
}

int main(int argc, char *argv[])
{
//     truncTimeRegain(argc, argv);

//     atimeChange(argc, argv);
     reachPathMax(argc, argv);
}
