#include "../apue.h"

#define MAXLINE 127

void pr_stdio(const char * name, FILE *fp)
{
     printf("stream = %s, ", name);

     if (fp->_IO_file_flags & _IO_UNBUFFERED)
	  printf("unbuffered");
     else if (fp->_IO_file_flags & _IO_LINE_BUF)
	  printf("line buffered");
     else
	  printf("fully buffered");

     printf(", buffer size = %ld\n", (fp->_IO_buf_end - fp->_IO_buf_base));
}

void buffState()
{
     FILE * fp;
     int p;
     fputs("enter any character\n", stdout);

     if ((p = getchar()) == EOF)
     {
	  printf("getchar error!\n");
	  goto back1;
     }
     putchar(p);
     printf("\n");
     fputs("one line to standard error\n", stderr);

     pr_stdio("stdin", stdin);
     pr_stdio("stdout", stdout);
     pr_stdio("stderr", stderr);

     if ((fp = fopen("/etc/motd", "r")) == NULL)
     {
	  printf("fopen error!\n");
	  goto back1;
     }
     if (getc(fp) == EOF)
     {
	  printf("getc error!\n");
	  goto back1;
     }

     pr_stdio("/etc/motd", fp);
back1:
     exit(0);
}

void in2outC()
{
     int c;
     while ((c = getc(stdin)) != EOF)
     {
	  if (putc(c, stdout) == EOF)
	  {
	       printf("output erro!\n");
	       goto back2;
	  }
     }

     if (ferror(stdin))
     {
	  printf("input error!\n");
	  goto back2;
     }

back2:
     exit(0);
}

void in2outL()
{
     char buf[MAXLINE];
     while (fgets(buf, MAXLINE, stdin) != NULL)
     {
//	  printf("%s\n", buf);
//	  fputs(buf, stderr);
	  if (fputs(buf, stdout) == EOF)
	  {
	       printf("out put error!\n");
	       goto back3;
	  }
     }

     if (ferror(stdin))
     {
	  printf("input error!\n");
	  goto back3;
     }

back3:
     exit(0);
}

void tmpCheck()
{
     char name[L_tmpnam], line[MAXLINE];
     FILE *fp;

     printf("L_tmpname = %d\n", L_tmpnam);
     printf("%s\n", tmpnam(NULL));

     tmpnam(name);
     printf("%s\n", name);

     if ((fp = tmpfile()) == NULL)
     {
	  printf("tmp file error!\n");
	  goto back4;
     }
     fputs("one line of ouput\n", fp);
     rewind(fp);

     if (fgets(line, sizeof(line), fp) == NULL)
     {
	  printf("fgets error!\n");
	  goto back4;
     }
     fputs(line, stdout);

back4:
     exit(0);
}

void tmpNameCheck2(int argc, char * argv[])
{
     if (argc != 3)
     {
	  printf("usage: a.out <directory> <prefix>\n");
	  goto back5;
     }

     printf("%s\n", P_tmpdir);
     printf("%s\n", tempnam((argv[1][0] != ' '?argv[1] : NULL), (argv[2][0] != ' '?argv[2] : NULL)));
back5:
     exit(0);
}

int main(int argc, char * argv[])
{
     printf("helloworld\n");
//     buffState();
//     in2outC();
//     in2outL();
//     tmpCheck();
//     tmpNameCheck2(argc, argv);
}
