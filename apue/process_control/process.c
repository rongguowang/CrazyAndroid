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

void pr_exit(int status)
{
     if (WIFEXITED(status))
     {
	  printf("normal termination, exit status = %d\n", WEXITSTATUS(status));
     }else if (WIFSIGNALED(status))
     {
	  printf("abnormal termination, singal number = %d%s\n", WTERMSIG(status),
#ifdef WCOREDUMP
		 WCOREDUMP(status) ? "(core file generated)": "");
#else
		 "");
#endif
} else if (WIFSTOPPED(status))
  {
       printf("child stopped, signal number = %d\n", WSTOPSIG(status));
  }
}

int exit_number(int argc, char ** argv)
{
     pid_t pid;
     int status;

     if ((pid = fork()) < 0)
     {
	  printf("fork error!\n");
	  goto back2;
     } else if (pid == 0)
     {
	  exit(7);
     }

     if (wait(&status) != pid)
     {
	  printf("wait_error!\n");
     }
     pr_exit(status);

     if ((pid = fork()) < 0)
     {
	  printf("fork2 error!\n");
	  goto back2;
     } else if (pid == 0)
     {
	  abort();
     }

     if (wait(&status) != pid)
     {
	  printf("wait 2 error!\n");
     }
     pr_exit(status);

     if ((pid = fork()) < 0)
     {
	  printf("fork 3 error!\n");
	  goto back2;
     } else if (pid == 0)
     {
	  status /= 0;
     }

     if (wait(&status) != pid)
     {
	  printf("wait 3 error!\n");
     }
     pr_exit(status);
back2:
     return 0;
}
int main(int argc, char ** argv)
{
//     fork_call(argc, argv);
//     vfork_call(argc, argv);
     exit_number(argc, argv);
}
