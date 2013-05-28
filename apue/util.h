#include "apue.h"

#include <errno.h>
#include <limits.h>
#include <linux/limits.h>

#ifdef PATH_MAX
static int pathmax = PATH_MAX;
#else
static int pathmax = 0;
#endif

#define SUSV3 200112L

static long posix_version = 0;

#define PATH_MAX_GUESS 1024


#ifdef OPEN_MAX
static long openmax = OPEN_MAX;
#else
static long openmax = 0;
#endif
#define OPEN_MAX_GUESS  256

extern char * path_alloc(int * sizep);
extern long open_max(void);
