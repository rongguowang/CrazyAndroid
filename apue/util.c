#include "util.h"


char * path_alloc(int * sizep)
{
     char  * ptr;
     int size;

     if (posix_version == 0)
	  posix_version = sysconf(_SC_VERSION);

     if (pathmax == 0)
     {
	  errno = 0;
	  if ((pathmax = pathconf("/", _PC_PATH_MAX)) < 0) 
	  {
	       if (errno == 0) {
		    pathmax = PATH_MAX_GUESS;
	       }
	       else 
	       {
		    printf("pathconf error for _PC_PATH_MAX\n");
		    goto back;
	       }
	  } else {
	       pathmax++;
	  }
     }

     if (posix_version < SUSV3)
	  size = pathmax + 1;
     else
	  size = pathmax;

     if ((ptr = malloc(size)) == NULL)
     {	  
	  printf("malloc error for pathname\n");
	  goto back;
     }

     if (sizep != NULL)
	  *sizep = size;
     return (ptr);
back:
     return NULL;
}


long open_max(void)
{
     if (0 == openmax) {
	  errno = 0;
	  if ((openmax = sysconf(_SC_OPEN_MAX)) < 0){
	       if (errno == 0){
		    openmax = OPEN_MAX_GUESS;
	       } else {
		    printf("sysconf error for _SC_OPEN_MAX\n");
		    goto back1;
	       }
	  }
     }
     return openmax;
back1:
     return 0;
}
