#include "../apue.h"
#include <sys/wait.h>
#include <unistd.h>

static void sig_int(int);

#define MAXLINE 127

int main(int argc, char *argv[])
{
     char buf[MAXLINE];
     pid_t pid;
     int status;

     if (signal(SIGINT, sig_int) == SIG_ERR)
	  printf("signal error!\n");

     printf("%% ");
     while (fgets(buf, MAXLINE, stdin) != NULL)
     {
	  if (buf[strlen(buf) - 1] == '\n')
	  {
	       buf[strlen(buf) - 1] = 0;
	  }

	  if ((pid = fork()) < 0)
	  {
	       printf("fork error!\n");
	  } else if( pid == 0)
	  {
	       execlp(buf, buf, (char *) 0);
	       printf("could not execute: %s\n", buf);
	       exit(127);
	  }
	   
	  if (pid = waitpid(pid, &status, 0) < 0)
	  {
	       printf("waitpid, error\n");
	  }

	  printf("%% ");
     }

     exit(0);
}

void sig_int(int signo)
{
     printf("interrupt\n%% ");
}
