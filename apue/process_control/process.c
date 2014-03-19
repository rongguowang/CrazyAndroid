#include "../apue.h"

int glob = 6;
char buf[] = "a write to stdout\n";

int fork_call(int argc, char ** argv)
{
     int var;
     int pid;

     var = 88;

     if (write(STDOUT_FILENO, buf, sizeof(buf)) != sizeof(buf) - 1)
     {
	  printf("write stdout error!\n");
     }

     printf("before fork\n");

     if ((pid = fork()) < 0)
     {
	  printf("fork error!\n");
     } else if (pid == 0)
     {
	  glob++;
	  var++;
     } else
     {
	  sleep(2);
     }

     printf("pid = %d, glob = %d, var = %d\n", getpid(), glob, var);

     return 0;
}

int vfork_call(int argc, char ** argv)
{
     int var;
     int pid;

     var = 88;
     printf("before vfork!\n");

     if ((pid = vfork()) < 0)
     {
	  printf("vfork error!\n");
	  goto back;
     } else if (pid == 0)
     {
	  glob++;
	  var++;
	  _exit(0);
     }
     printf("pid = %d, glob = %d, var = %d\n", getpid(), glob, var);
back:
     return 0;
}

int main(int argc, char ** argv)
{
//     fork_call(argc, argv);
     vfork_call(argc, argv);
}
