#include "../apue.h"
#include <pthread.h>

void cleanup(void *arg)
{
     printf("cleanup: %s\n", (char *)arg);
}

void * thr_fn1(void *arg)
{
     printf("thread1 start\n");
     pthread_cleanup_push(cleanup, "thread1 first handler");
     pthread_cleanup_push(cleanup, "thread1 second handler");
     printf("thread1 push complete\n");
     if (arg)
	  return ((void *)1);

     pthread_cleanup_pop(0);
     pthread_cleanup_pop(0);
}

void * thr_fn2(void *arg)
{
     printf("thread2 start\n");
     pthread_cleanup_push(cleanup, "thread2 first handler");
     pthread_cleanup_push(cleanup, "thread2 second handler");
     printf("thread2 push complete\n");
     if (arg)
	  pthread_exit((void *)2);
     pthread_cleanup_pop(1);
     pthread_cleanup_pop(1);
     pthread_exit((void *)2);
}

int main(void)
{
     int err, i = 17;
     pthread_t tid1, tid2;
     void *tret = &i;

     err = pthread_create(&tid1, NULL, thr_fn1, (void *)1);
     if (err != 0) {
	  printf("can't create thread1: %s\n", strerror(err));
	  goto back;
     }

     err = pthread_create(&tid2, NULL, thr_fn2, (void *)2);
     if (err != 0) {
	  printf("can't create thread2: %s\n", strerror(err));
	  goto back;
     }

     err = pthread_join(tid1, &tret);
     if (err !=0 ) {
	  printf("can't join with thread1 :%s\n", strerror(err));
	  goto back;
     }
     printf("thread 1 exit code :%d\n", (int) tret);

     err = pthread_join(tid2, &tret);
     if (err != 0) {
	  printf("can't join with thread2 :%s\n", strerror(err));
	  goto back;
     }
     printf("thread 2 exit code: %d\n", (int) tret);

back:
     exit(0);
}
