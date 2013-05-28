#include "../apue.h"
#include <fcntl.h>
#include <sys/stat.h>
void changemode()
{
     struct stat statbuf;

     if (stat("foo2", &statbuf) < 0)
     {
	  printf("stat error for foo2\n");
	  goto back2;
     }

     if (chmod("foo2", (statbuf.st_mode & ~S_IXGRP)|S_ISGID) < 0)
     {
	  printf("chmod foo2 error !\n");
	  goto back2;
     }
     getchar();

     if (chmod("bar", RWRWRW) < 0)
     {
	  printf("chmod error for bar!\n");
	  goto back2;
     }

back2:
     return;
}

void checkFile(struct stat buf)
{
     char* ptr;
     if (S_ISREG(buf.st_mode)) {
	  ptr = "regular";
     } else if (S_ISDIR(buf.st_mode)) {
	  ptr = "directory";
     } else if (S_ISCHR(buf.st_mode)) {
	  ptr = "character special";
     } else if (S_ISBLK(buf.st_mode)) {
	  ptr = "block special";
     } else if (S_ISFIFO(buf.st_mode)) {
	  ptr = "fifo";
     } else if (S_ISLNK(buf.st_mode)) {
	  ptr = "symbolic link";
     } else if (S_ISSOCK(buf.st_mode)) {
	  ptr = "socket";
     } else {
	  ptr = "** unknow mode **";
     }
     printf("\t%s\n", ptr);
}

void umask777()
{
     struct stat buf;
     int mode;
//     umask(0777);
     if (creat("foo3", RWXRWXRWX) < 0)
     {
	  printf("creat error for foo3\n");
     }
     getchar();
     if (stat("foo3", &buf) < 0)
     {
	  printf("stat error for foo3\n");
     }
     checkFile(buf);
     getchar();
     if (chmod("foo3", RWRWRW) < 0)
     {
	  printf("chmod error for foo3\n");
     }
     mode = umask(0);
     printf("umask(0) = %o\n", mode);
}

int main(int argc, char **argv)
{
     char t;
     mode_t mode;
     mode = umask(0777);
     printf("umask(0) = %o\n", mode);
     if (creat("foo2",RWXRWXRWX) < 0)
     {
	  printf("create error for foo2\n");
	  goto back;
     }
     getchar();
//     mode = umask(S_IRGRP|S_IWGRP|S_IROTH|S_IWOTH);
     printf("umask(0) = %o\n", mode);
     if (creat("bar", RWXRWXRWX) < 0)
     {
	  printf("create error for bar\n");
	  goto back;
     }
     getchar();
//     mode = umask(044);
     printf("umask(0) = %o\n", mode);
//     mode = umask(055);
     printf("umask(0) = %o\n", mode);
     changemode();
     umask777();
back:
     exit(0);
}
