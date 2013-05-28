#include "../apue.h"

#include <unistd.h>

int main(void)
{
     int c;

     while ((c = getc(stdin)) != EOF)
	  if (putc(c, stdout) == EOF)
	       printf("out put error!\n");
     if (ferror(stdin))
	  printf("input error");
     exit(0);
}
