#include "../apue.h"
#include <errno.h>
#include <linux/limits.h>
#include <limits.h>

static void pr_sysconf(char *, int);
static void pr_pathconf(char *, char *, int);

int main(int argc, char *argv[])
{	if (argc != 2)
		 printf("usage: a.out <dirname>");

#ifdef ARG_MAX
	printf("ARG_MAX defined to be %d\n", ARG_MAX+0);
#else 
	printf("no symbol for ARG_MAX \n");
#endif
#ifdef _SC_ARG_MAX
	pr_sysconf("ARG_MAX = ", _SC_ARG_MAX);
#else
	printf("no symbol for _SC_ARG_MAX\n");
#endif
#ifdef ATEXIT_MAX
	printf("ATEXIT_MAX defined to be %d\n", ATEXIT_MAX+0);
#else 
	printf("no symbol for ATEXIT_MAX \n");
#endif
#ifdef _SC_ATEXIT_MAX
	pr_sysconf("ATEXIT_MAX = ", _SC_ATEXIT_MAX);
#else
	printf("no symbol for _SC_ATEXIT_MAX\n");
#endif
#ifdef CHARCLASS_NAME_MAX
	printf("CHARCLASS_NAME_MAX defined to be %d\n", CHARCLASS_NAME_MAX+0);
#else 
	printf("no symbol for CHARCLASS_NAME_MAX \n");
#endif
#ifdef _SC_CHARCLASS_NAME_MAX
	pr_sysconf("CHARCLASS_NAME_MAX = ", _SC_CHARCLASS_NAME_MAX);
#else
	printf("no symbol for _SC_CHARCLASS_NAME_MAX\n");
#endif
#ifdef CHILD_MAX
	printf("CHILD_MAX defined to be %d\n", CHILD_MAX+0);
#else 
	printf("no symbol for CHILD_MAX \n");
#endif
#ifdef _SC_CHILD_MAX
	pr_sysconf("CHILD_MAX = ", _SC_CHILD_MAX);
#else
	printf("no symbol for _SC_CHILD_MAX\n");
#endif
#ifdef CLOCKTICKSPERSECOND /*clock ticks/second*/
	printf("CLOCKTICKSPERSECOND /*clock ticks/second*/ defined to be %d\n", CLOCKTICKSPERSECOND /*clock ticks/second*/+0);
#else 
	printf("no symbol for CLOCKTICKSPERSECOND /*clock ticks/second*/ \n");
#endif
#ifdef _SC_CLK_TCK
	pr_sysconf("CLOCKTICKSPERSECOND /*clock ticks/second*/ = ", _SC_CLK_TCK);
#else
	printf("no symbol for _SC_CLK_TCK\n");
#endif
#ifdef COLL_WEIGHTS_MAX
	printf("COLL_WEIGHTS_MAX defined to be %d\n", COLL_WEIGHTS_MAX+0);
#else 
	printf("no symbol for COLL_WEIGHTS_MAX \n");
#endif
#ifdef _SC_COLL_WEIGHTS_MAX
	pr_sysconf("COLL_WEIGHTS_MAX = ", _SC_COLL_WEIGHTS_MAX);
#else
	printf("no symbol for _SC_COLL_WEIGHTS_MAX\n");
#endif
#ifdef HOST_NAME_MAX
	printf("HOST_NAME_MAX defined to be %d\n", HOST_NAME_MAX+0);
#else 
	printf("no symbol for HOST_NAME_MAX \n");
#endif
#ifdef _SC_HOST_NAME_MAX
	pr_sysconf("HOST_NAME_MAX = ", _SC_HOST_NAME_MAX);
#else
	printf("no symbol for _SC_HOST_NAME_MAX\n");
#endif
#ifdef IOV_MAX
	printf("IOV_MAX defined to be %d\n", IOV_MAX+0);
#else 
	printf("no symbol for IOV_MAX \n");
#endif
#ifdef _SC_IOV_MAX
	pr_sysconf("IOV_MAX = ", _SC_IOV_MAX);
#else
	printf("no symbol for _SC_IOV_MAX\n");
#endif
#ifdef LINE_MAX
	printf("LINE_MAX defined to be %d\n", LINE_MAX+0);
#else 
	printf("no symbol for LINE_MAX \n");
#endif
#ifdef _SC_LINE_MAX
	pr_sysconf("LINE_MAX = ", _SC_LINE_MAX);
#else
	printf("no symbol for _SC_LINE_MAX\n");
#endif
#ifdef LOGIN_NAME_MAX
	printf("LOGIN_NAME_MAX defined to be %d\n", LOGIN_NAME_MAX+0);
#else 
	printf("no symbol for LOGIN_NAME_MAX \n");
#endif
#ifdef _SC_LOGIN_NAME_MAX
	pr_sysconf("LOGIN_NAME_MAX = ", _SC_LOGIN_NAME_MAX);
#else
	printf("no symbol for _SC_LOGIN_NAME_MAX\n");
#endif
#ifdef NGROUPS_MAX
	printf("NGROUPS_MAX defined to be %d\n", NGROUPS_MAX+0);
#else 
	printf("no symbol for NGROUPS_MAX \n");
#endif
#ifdef _SC_NGROUPS_MAX
	pr_sysconf("NGROUPS_MAX = ", _SC_NGROUPS_MAX);
#else
	printf("no symbol for _SC_NGROUPS_MAX\n");
#endif
#ifdef OPEN_MAX
	printf("OPEN_MAX defined to be %d\n", OPEN_MAX+0);
#else 
	printf("no symbol for OPEN_MAX \n");
#endif
#ifdef _SC_OPEN_MAX
	pr_sysconf("OPEN_MAX = ", _SC_OPEN_MAX);
#else
	printf("no symbol for _SC_OPEN_MAX\n");
#endif
#ifdef PAGESIZE
	printf("PAGESIZE defined to be %d\n", PAGESIZE+0);
#else 
	printf("no symbol for PAGESIZE \n");
#endif
#ifdef _SC_PAGESIZE
	pr_sysconf("PAGESIZE = ", _SC_PAGESIZE);
#else
	printf("no symbol for _SC_PAGESIZE\n");
#endif
#ifdef PAGE_SIZE
	printf("PAGE_SIZE defined to be %d\n", PAGE_SIZE+0);
#else 
	printf("no symbol for PAGE_SIZE \n");
#endif
#ifdef _SC_PAGE_SIZE
	pr_sysconf("PAGE_SIZE = ", _SC_PAGE_SIZE);
#else
	printf("no symbol for _SC_PAGE_SIZE\n");
#endif
#ifdef RE_DUP_MAX
	printf("RE_DUP_MAX defined to be %d\n", RE_DUP_MAX+0);
#else 
	printf("no symbol for RE_DUP_MAX \n");
#endif
#ifdef _SC_RE_DUP_MAX
	pr_sysconf("RE_DUP_MAX = ", _SC_RE_DUP_MAX);
#else
	printf("no symbol for _SC_RE_DUP_MAX\n");
#endif
#ifdef STREAM_MAX
	printf("STREAM_MAX defined to be %d\n", STREAM_MAX+0);
#else 
	printf("no symbol for STREAM_MAX \n");
#endif
#ifdef _SC_STREAM_MAX
	pr_sysconf("STREAM_MAX = ", _SC_STREAM_MAX);
#else
	printf("no symbol for _SC_STREAM_MAX\n");
#endif
#ifdef SYMLOOP_MAX
	printf("SYMLOOP_MAX defined to be %d\n", SYMLOOP_MAX+0);
#else 
	printf("no symbol for SYMLOOP_MAX \n");
#endif
#ifdef _SC_SYMLOOP_MAX
	pr_sysconf("SYMLOOP_MAX = ", _SC_SYMLOOP_MAX);
#else
	printf("no symbol for _SC_SYMLOOP_MAX\n");
#endif
#ifdef TTY_NAME_MAX
	printf("TTY_NAME_MAX defined to be %d\n", TTY_NAME_MAX+0);
#else 
	printf("no symbol for TTY_NAME_MAX \n");
#endif
#ifdef _SC_TTY_NAME_MAX
	pr_sysconf("TTY_NAME_MAX = ", _SC_TTY_NAME_MAX);
#else
	printf("no symbol for _SC_TTY_NAME_MAX\n");
#endif
#ifdef TZNAME_MAX
	printf("TZNAME_MAX defined to be %d\n", TZNAME_MAX+0);
#else 
	printf("no symbol for TZNAME_MAX \n");
#endif
#ifdef _SC_TZNAME_MAX
	pr_sysconf("TZNAME_MAX = ", _SC_TZNAME_MAX);
#else
	printf("no symbol for _SC_TZNAME_MAX\n");
#endif
	 exit(0);
}

static void pr_sysconf(char *mesg, int name)
{
	long val;

	fputs(mesg, stdout);
	errno = 0;
	if ((val = sysconf(name)) < 0) {
		if (errno != 0) {
			if (errno == EINVAL)
				fputs("(not supported)\n", stdout);
			else
				printf("sysconf error");
		} else {
			fputs("(no limit)\n", stdout);
		}
	} else {
		printf("%ld\n", val);
	}
}

static void pr_pathconf(char *msg, char *patch, int name)
{
	long val;

	fputs(msg, stdout);
	errno = 0;
	if ((val = pathconf(patch, name)) < 0) {
		if (errno !=0) {
			if (errno = EINVAL)
				fputs("(not supported)\n", stdout);
			else
				printf("pathconf error, path=%s", patch);
		} else {
			fputs("(no limits)\n", stdout);
		}
	} else {
		printf("%ld \n", val);
	}
}
