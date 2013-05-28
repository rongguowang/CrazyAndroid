#include "../apue.h"
#include <fcntl.h>

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


     if (chmod("bar", RWRWRW) < 0)
     {
	  printf("chmod error for bar!\n");
	  goto back2;
     }
back2:
     return;
}

int main(int argc, char **argv)
{
     mode_t mode;
     mode = umask(0);
     printf("umask(0) = %o\n", mode);
     if (creat("foo2",RWXRWXRWX) < 0)
     {
	  printf("create error for foo2\n");
	  goto back;
     }


     mode = umask(S_IRGRP|S_IWGRP|S_IROTH|S_IWOTH);
     printf("umask(0) = %o\n", mode);
     if (creat("bar", RWXRWXRWX) < 0)
     {
	  printf("create error for bar\n");
	  goto back;
     }
     mode = umask(044);
     printf("umask(0) = %o\n", mode);
     mode = umask(055);
     printf("umask(0) = %o\n", mode);
     changemode();
back:
     exit(0);
}
