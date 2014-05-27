#include "../apue.h"
#include <dirent.h>

int ls_test(int argc, char * argv[])
{
     DIR *dp;
     struct dirent *dirp;

     if (argc != 2)
     {
	  printf("usage: ls directory_name\n");
	  goto exit;
     }

     if ((dp = opendir(argv[1])) == NULL)
	  printf("can't open %s\n", argv[1]);

     while ((dirp = readdir(dp)) != NULL)
	  printf("%s\n", dirp->d_name);

     closedir(dp);
 exit:
     exit(0);
}

int func(int n, int *fp)
{
     int t, f;
     if (n <= 1)
     {
	  *fp = 1;
	  return 1;
     }
     t = func(n-1, fp);
     f = t + *fp;
     *fp = t;
     printf("n = %d, *fp = %d, f = %d\n", n,*fp, f);
     return f;
}

int iter_test(int argc, char ** argv)
{
     int x = 15;
     printf("%d\n", func(4, &x));
     return 0;
}

int main(int argc, char ** argv)
{
     //ls_test(argc, argv);
     iter_test(argc, argv);
}
