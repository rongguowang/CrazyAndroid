#include "../apue.h"
#include <fcntl.h>

#define BUFFSIZE 4096

int main(int argc, char * argv[])
{
     int n;
     char buff[BUFFSIZE];
     int fdread, fdwrite;

     if (argc != 3) {
	  printf("usage: mycp3 inputfile outputfile\n");
	  goto back;
     }
     printf("argc == 3 fine, next\n");
     if ((fdwrite = open(argv[2], O_WRONLY | O_CREAT | O_TRUNC, FILE_MODE)) < 0) {
	  printf("create output file error. exit!\n");
	  goto back;
     }
     printf("create fdwrite fine, next\n");
     if ((fdread = open(argv[1], O_RDONLY)) < 0) {
	  printf("read input file error. exit!\n");
	  goto back;
     }
     printf("open fdread fine, next fdread = %d\n", fdread);
     while ((n = read(fdread, buff, BUFFSIZE)) > 0) {
	  printf("read fine, now write!\n");
	  if (write(fdwrite, buff, n) != n) {
	       printf("write error!\n");
	       goto  back;
	  }
     }
     printf("write processed!\n");
     if (n < 0) {
	  printf("read error!\n");
	  goto back;
     }

back:
     close(fdread);
     close(fdwrite);
     exit(0);
}
