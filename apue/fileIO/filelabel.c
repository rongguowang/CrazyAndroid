#include "../apue.h"
#include <fcntl.h>
#include <string.h>

void set_fl(int fd, int flags)
{
     int val;
     
     if ((val = fcntl(fd, F_GETFL, 0)) < 0) {
	  printf("fcntl F_GETFL error\n");
	  return;
     }
     val &= flags;
     printf("val & flags = %d  O_RDONLY & O_RDWR = %d\n", val, (O_RDONLY & O_RDWR));
     if ((val = fcntl(fd, F_SETFL, val)) < 0) {
	  printf("fcntl F_SETFL error\n");
	  return ;
     }
}

int get_fl(int fd)
{
     int val;
     if ((val = fcntl(fd, F_GETFL, 0)) < 0) {
	  printf("fcntl error for fd: %d\n", fd);
	  return -1;
     }

     return val;
}

void check_fl(int val)
{

     switch(val & O_ACCMODE) {
     case O_RDONLY:
	  printf("read only");
	  break;
     case O_WRONLY:
	  printf("write only");
	  break;
     case O_RDWR:
	  printf("read write");
	  break;
     default:
	  printf("unknown access mode");
     }

     if (val & O_APPEND) 
	  printf(", append");
     if (val & O_NONBLOCK)
	  printf(", nonblocking");

#if defined(O_SYNC)
     if (val & O_SYNC)
	  printf(", synchronous writes");
#endif

#if !defined(_POSIX_C_SOURCE) && defined(O_FSYNC)
     if (val & O_FSYNC)
	  printf(", synchronous writes");
#endif

     putchar('\n');
}
int main(int argc, char *argv[])
{
     int val;

     if (argc != 2) {
	  printf("usage: a.out <descriptor#>\n");
	  goto back;
     }

     val = get_fl(atoi(argv[1]));
     check_fl(val);
     
     set_fl(atoi(argv[1]), O_RDONLY);
     val = get_fl(atoi(argv[1]));
     check_fl(val);

back:
     exit(0);
}
