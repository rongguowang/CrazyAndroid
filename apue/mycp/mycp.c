#include "../apue.h"

#include <unistd.h>

#define BUFFSIZE 4096

int main(void)
{
     int n;
     char buff[BUFFSIZE];

     while ((n = read(STDIN_FILENO, buff, BUFFSIZE)) > 0)
	  if (write(STDOUT_FILENO, buff, n) != n)
	       printf("write error!\n");

     if (n < 0)
	  printf("read error\n");
     exit(0);
}
