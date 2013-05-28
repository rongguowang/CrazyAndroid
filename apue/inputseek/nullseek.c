#include "../apue.h"
#include <fcntl.h>

char buf1[] = "abcdefghij";
char buf2[] = "ABCDEFGHIJ";

#define FILE_LENGTH 16384

int main(int argc, char *argv[])
{
     int fdHole, fdNoHole;
     int len = 0; 
     int writeNo = 10;
     int leftLen = FILE_LENGTH - len;

     if ((fdNoHole = creat("file.nohole", FILE_MODE)) < 0) {
	  printf("fdNoHole creat error!\n");
	  goto back;
     }

     while ((len <= FILE_LENGTH) && (leftLen > 0)) {
	  if (write(fdNoHole, buf1, writeNo) == writeNo) {
	       len += writeNo;
	       leftLen = FILE_LENGTH - len;
	       if (leftLen < writeNo) {
		    writeNo = leftLen;
	       }
	  } else {
	       printf("fdNoHole write error!\n");
	       goto back;
	  }
     }

     if (write(fdNoHole, buf2, 10) != 10) {
	  printf("fdNoHole write error!\n");
	  goto back;
     }


     if ((fdHole = creat("file.Hole", FILE_MODE)) < 0) {
	  printf("file.hole creat error!\n");
	  goto back;
     }
     if (write(fdHole, buf1, 10) != 10) {
	  printf("file.hole write buf1 error!\n");
	  goto back;
     }
     if (lseek(fdHole, 16384, SEEK_SET) == -1) {
	  printf("file.hole lseek error!\n");
	  goto back;
     }
     if (write(fdHole, buf2, 10) != 10) {
	  printf("file.hole write buf2 error!\n");
	  goto back;
     }
					       
back:
     if (fdNoHole)
	  close(fdNoHole);
     if (fdHole)
	  close(fdHole);
     exit(0);
}

