#include "../apue.h"
#include "fcntl.h"

int err = 0;
int main(int argc, char * argv[])
{
     if (argc != 2) {
	  printf("usage: fileaccess <pathname>\n");
	  goto back;
     }

     if ((err = access(argv[1], R_OK)) < 0) {
	  printf("access error for %s %s\n", argv[1], strerror(err));
	  err = 0;
     } else {
	  printf("read access OK!\n");
     }

     if ((err = open(argv[1], O_RDONLY)) < 0) {
	  printf("open error for %s %s\n", argv[1], strerror(err));
     } else {
	  printf("open for reading OK\n");
     }

back:
     exit(0);
}
