/*
 * advanced unix programming codes head file
 * will include all the function prototypes
 * here.
 */

#ifndef _APUE_H
#define _APUE_H
#include <stdio.h>
#include <stdlib.h>
#include <stddef.h>
#include <string.h>
#include <malloc.h>
#include <unistd.h>
#include <errno.h>
#include <unistd.h>
#include <ctype.h>
#include <sys/wait.h>

#define FILE_MODE (S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH)
#define RWRWRW (S_IRUSR|S_IWUSR|S_IRGRP|S_IWGRP|S_IROTH|S_IWOTH)
#define RWXRWXRWX (S_IRUSR|S_IWUSR|S_IXUSR|S_IRGRP|S_IWGRP|S_IXGRP|S_IROTH|S_IWOTH|S_IXOTH)

#endif
