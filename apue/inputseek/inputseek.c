#include "../apue.h"

int main(int argc, char *argv[])
{
     if (-1 == lseek(STDIN_FILENO, 0, SEEK_CUR))
	  printf("can not seek\n");
     else
	  printf("seek OK\n");

     exit(0);
}
