#include "../apue.h"
#include <fcntl.h>
#include <unistd.h>
#include <malloc.h>

#define BUFFSIZE 4096

char buff[] = "ABCDEFGHIJ";

typedef struct holePos
{
     int holeNum;
     int holeStartPos;
     int holeFinishPos;
} holePos, *holePosPtr;

int usage1()
{
     printf("please select copy type:\n");
     printf("\t[s] read stdin and write stdout\n");
     printf("\t[b] read buffer and write buffer to copy\n");
     printf("\t[c] read char and write char to copy\n");
     printf("\t[r] write input size of data into the file\n");
     printf("\t[i] not ignore holes copy in the read file\n");
     printf("\t[h] create hole in input file\n");
     return getchar();
}

void holeCopy(char read2[], char write2[])
{
     int fdread, fdwrite;
     int c;
     int i;

     if ((fdread = open(read2, O_RDONLY)) < 0)
     {
	  printf("open read file %s error!\n", read2);
	  goto back4;
     }

     if ((fdwrite = open(write2, O_WRONLY|O_CREAT, RWRWRW)) < 0)
     {
	  printf("open write file %s error\n", write2);
	  goto back4;
     }


     i = 0;
     while((read(fdread, &c, 1)) > 0)
     {
	  i++;
	  if (c == 0)
	  {
	       if (lseek(fdwrite,1,SEEK_CUR) == -1)
	       {
		    printf("write error!\n");
		    goto back4;
	       }
	  } else 
	  {
	       if (write(fdwrite, &c, 1) != 1)
	       {
		    printf("write error!\n");
		    goto back4;
	       }
	  }
     }


back4:
     if (fdread)
	  close(fdread);
     if (fdwrite)
	  close(fdwrite);
     return ;
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
     if ((fdwrite = open(write1, O_WRONLY|O_CREAT, RWRWRW)) < 0)
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

void write2File(char file[], int startPos, int finishPos)
{
     int fd;
     int len = 0;
     int writeNo = 10;
     int leftLen = 0;
     int totalLen = finishPos - startPos;

     printf("write2File: startPos = %d\t finishPos = %d\n", startPos, finishPos);
     if (startPos < 0 || finishPos < startPos)
	  return;

     if ((fd = open(file, O_WRONLY | O_CREAT, RWRWRW)) < 0)
     {
	  printf("open %s error!\n", file);
	  goto back3;
     }

     if (lseek(fd, startPos, SEEK_SET) == -1)
     {
	  printf("seek %s error!\n", file);
	  goto back3;
     }

     leftLen = finishPos - startPos;
     while((leftLen <= totalLen) && (leftLen > 0))
     {
	  if (write(fd, &buff, writeNo) == writeNo)
	  {
	       len += writeNo;
	       leftLen = totalLen - len;
	       if (leftLen < writeNo)
	       {
		    writeNo = leftLen;
	       }
	  } else {
	       printf("wirte error!\n");
	       goto back3;
	  }
     }

back3:
     if (fd)
	  close(fd);
     return;
}

void holeCreatInFile(char file[])
{
     int holeNum;
     holePos *hole;
     int i;
     int defaultStart = 0;
     printf("how many holes do you want to create in the file:\n");
     scanf("%d", &holeNum);
     printf("holeNum = %d\n", holeNum);

     if (holeNum <= 0)
	  return;
     hole = (struct holePos *)malloc(sizeof (struct holePos) * holeNum);
     for (i = 0; i < holeNum; i++)
     {
	  hole[i].holeNum = i + 1;
	  printf("input %d hole start point and finish point\n", i);
	  scanf("%d,%d", &hole[i].holeStartPos, &hole[i].holeFinishPos);
	  printf("%d hole start:%d\tfinish:%d\n", hole[i].holeNum, 
		 hole[i].holeStartPos, hole[i].holeFinishPos);
     }

     for (i = 0; i < holeNum; i++)
     {
	  defaultStart = (i == 0)?0:hole[i-1].holeFinishPos;
	  write2File(file, defaultStart, hole[i].holeStartPos);
     }
     write2File(file, hole[i - 1].holeFinishPos, (hole[i - 1].holeFinishPos + 10));

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
	  holeCopy(argv[1], argv[2]);
	  break;
     case 'c':
	  charCopy(argv[1], argv[2]);
	  break;
     case 'r':
	  printf("input file size:\n");
	  scanf("%d", &n);
	  inputSizeWrite(argv[1], n);
	  break;
     case 'h':
	  holeCreatInFile(argv[1]);
	  break;
     default:
	  break;
     }

     exit(0);
}
