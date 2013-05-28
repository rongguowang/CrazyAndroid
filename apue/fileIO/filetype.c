#include "../apue.h"
#include <sys/stat.h>
#include <errno.h>

void checkFile(struct stat buf)
{
     char* ptr;
     if (S_ISREG(buf.st_mode)) {
	  ptr = "regular";
     } else if (S_ISDIR(buf.st_mode)) {
	  ptr = "directory";
	  printf("direcotry file length: %d\n", buf.st_size);
     } else if (S_ISCHR(buf.st_mode)) {
	  ptr = "character special";
     } else if (S_ISBLK(buf.st_mode)) {
	  ptr = "block special";
     } else if (S_ISFIFO(buf.st_mode)) {
	  ptr = "fifo";
     } else if (S_ISLNK(buf.st_mode)) {
	  ptr = "symbolic link";
	  printf("smybolic file length: %d\n", buf.st_size);
     } else if (S_ISSOCK(buf.st_mode)) {
	  ptr = "socket";
     } else {
	  ptr = "** unknow mode **";
     }
     printf("\t%s\n", ptr);
}
void lstatCheck(char argv[])
{
     struct stat buf;

     printf("   lstatCheck\n");
     if (lstat(argv, &buf) < 0) {
	  printf("lstat error\n");
	  return;
     }
     checkFile(buf);
}

void statCheck(char argv[])
{
     struct stat buf;
     printf("    statCheck\n");

     if (stat(argv, &buf) < 0)
     {
	  printf("stat error!\n");
	  return;
     }
     checkFile(buf);
}

int main(int argc, char *argv[])
{
     int i;
     struct stat buf;
     char * ptr;
     int errno;

     for(i = 1; i < argc; i++) {
	  printf("%s: \n", argv[i]);
	  lstatCheck(argv[i]);
	  statCheck(argv[i]);
	  if (lstat(argv[i], &buf) < 0)
	  {
	       printf("stat error!\n");
	       continue;
	  }
	  if (S_ISDIR(buf.st_mode)) {
	       if((errno = truncate(argv[i], 0)) < 0) {
		    printf("truncate direcotry error = %s\n", strerror(errno));
	       }
	  } else if (S_ISLNK(buf.st_mode)) {
	       printf("began truncate link file\n");
	       if ((errno = truncate(argv[i], 0)) < 0) {
		    printf("truncate link error = %s\n", strerror(errno));
	       }
	  }
	  lstat(argv[i], &buf);
	  printf("file size after truncate: %d\n", buf.st_size);

     }

     for (i = -1; i < 10 ; i++)
     {
	  printf("%d: %s\n", i, strerror(i));
     }
     exit(0);
}
