#include "../apue.h"
#include <fcntl.h>
#include <unistd.h>

#define BUFFSIZE 4096

char buff[] = "ABCDEFGHIJ";

int usage1()
{
     printf("please select copy type:\n");
     printf("\t[s] read stdin and write stdout\n");
     printf("\t[b] read buffer and write buffer to copy\n");
     printf("\t[c] read char and write char to copy\n");
     printf("\t[r] write input size of data into the file\n");
     printf("\t[i] ignore holes in the read file\n");
     printf("\t[h] create hole in input file\n");
     return getchar();
}

void ignoreHoleCopy(char read[], char write[])
{

}

void charCopy(char read1[], char write1[])
{
     int fdread = 0, fdwrite = 0;
     int c;
     int n;

     if ((fdread = open(read1, O_RDONLY)) < 0)
     {
	  printf("fdread open fail! quit!\n");
	  goto back;
     }
     if ((fdwrite = open(write1, O_WRONLY|O_CREAT|O_TRUNC, RWRWRW)) < 0)
     {
	  printf("fdwrite open fail! quit!\n");
	  goto back;
     }

     while ((n = read(fdread, &c, 1)) > 0)
	  if (write(fdwrite, &c, 1) != n)
	       printf("write to fdwrite error!\n");
back:
     if (fdread)
	  close(fdread);
     if (fdwrite)
	  close(fdwrite);
     return;
}

void stdin2out()
{
     int n;
     char buff[BUFFSIZE];

     while ((n = read(STDIN_FILENO, buff, BUFFSIZE)) > 0)
	  if (write(STDOUT_FILENO, buff, n) != n)
	       printf("write error!\n");

     if (n < 0)
	  printf("read error\n");
}

int inputSizeWrite(char write1[], int n)
{
     int fdwrite;
     int len = 0;
     int writeNo = 10;
     int leftLen = n - len;

     if (n < 0)
	  return -1;
     printf("file size = %d\n", n);

     if ((fdwrite = open(write1, O_WRONLY|O_CREAT|O_TRUNC, RWRWRW)) < 0)
     {
	  printf("write error!\n");
	  goto back2;
     }

     while ((leftLen <= n) && (leftLen > 0))
     {
	  if(write(fdwrite,&buff, writeNo) == writeNo)
	  {
	       len += writeNo;
	       leftLen = n - len;
	       if (leftLen < writeNo)
	       {
		    writeNo = leftLen;
	       }
	  } else {
	       printf("write error\n");
	       goto back2;
	  }
     }
back2:
     if (fdwrite)
	  close(fdwrite);
     return ;
}
int main(int argc, char *argv[])
{
     char i;
     int n;

     printf("argc = %d\n", argc);
     for (i = 0; i < argc; i++)
     {
	  printf("argv[%d] = %s\n", i, argv[i]);
     }

     i = usage1();
     printf("i = %c\n", i);

     switch(i)
     {
     case 's':
	  stdin2out();
	  break;
     case 'i':
	  ignoreHoleCopy(argv[1], argv[2]);
	  break;
     case 'c':
	  charCopy(argv[1], argv[2]);
	  break;
     case 'r':
	  printf("input file size:\n");
	  scanf("%d", &n);
	  inputSizeWrite(argv[1], n);
	  break;
     default:
	  break;
     }

     exit(0);
}
