#include "../apue.h"
extern char ** environ;

#define BUFFSIZE 1024

typedef void (*Exitfunc)(void);

static void my_exit1()
{
     printf("first exit handler!\n");
}

static void my_exit2()
{
     printf("second exit handler!\n");
}

int exit_main()
{
     Exitfunc exit_handler1 = &my_exit1;
     Exitfunc exit_handler2 = &my_exit2;

     if (atexit(exit_handler2) != 0)
     {
	  printf("can't register my_exit2!\n");
	  goto back;
     }

     if (atexit(exit_handler1) != 0)
     {
	  printf("can't register my_exit1!\n");
	  goto back;
     }

     if (atexit(my_exit1) != 0)
     {
	  printf("can't register my_exit1!\n");
	  goto back;
     }

     printf("main is done!\n");
back:
     return 0;
}

int arg_main(int argc, char * argv[])
{
     int i = 0;
     char * b = (char *) malloc(sizeof(char *) * 15);
     char d[BUFFSIZE];
     int bufflen = 0;
     for (i = 0; i < argc; i++)
     {
	  printf("argv[%d]: %s\n", i, argv[i]);
	  if (bufflen < BUFFSIZE)
	  {
	       strncpy((d + bufflen), argv[i], strlen(argv[i]));
	       bufflen += strlen(argv[i]);
	       d[bufflen] = '\x20';
	       bufflen++;
	  } else 
	  {
	       printf("buff size error!\n");
	  }
     }
     d[bufflen] = '\0';
     printf("d = %s\n", d);
     setenv("argv", d, 1);

     sprintf(b, "%d", argc);
     printf("argc = %s\n", b);
     setenv("argc", b, 1);
     if (b)
	  free(b);
     return 1;
}

int print_env()
{
     char ** envPtr;
     int i;
     long * longPtr;
     long ** ptrArray;

     if (environ != NULL)
     {
	  for (i = 0; environ[i] != NULL; i++)
	  {
	    //	       printf("%s\n", environ[i]);
	  }
	  printf("enviroment varible count: %d\n", i);
	  printf("PATH = %s\n", getenv("PATH"));
	  printf("JAVA_HOME = %s\n", getenv("JAVA_HOME"));
	  printf("PWD = %s\n", getenv("PWD"));
	  printf("ANDROID_HOME = %s\n", getenv("ANDROID_HOME"));
	  printf("USER = %s\n", getenv("USER"));
	  printf("HOME = %s\n", getenv("HOME"));
	  printf("argc = %s\n", getenv("argc"));
	  printf("argv = %s\n", getenv("argv"));
     }

     longPtr = (long *)malloc(sizeof(long *) * 10);
     ptrArray = (long **)malloc(sizeof(long **) * 10);

     for ( i = 0; i < 10; i++)
     {
	  printf("long[%d] = %ld\t", i, longPtr[i]);
	  printf("ptrArray[%d] = %ld\n", i, (long int)ptrArray[i]);
     }
}
int main(int argc, char *argv[])
{
     exit_main();
     arg_main(argc, argv);
     printf("after exit_main !\n");
     print_env();
}
