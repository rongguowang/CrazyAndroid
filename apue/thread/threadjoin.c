#include "../apue.h"
#include <pthread.h>

void * thr_fn1(void *arg)
{
     printf("thread 1 returning!\n");

     return ((void*)1);
}

void * thr_fn2(void *arg)
{
     printf("thread 2 exiting!\n");
     pthread_exit((void *)2);
}

int main(void)
{
     int err ,i = 17;
     pthread_t tid1, tid2;
     void * tret = &i;

     printf("tret = %d\n", (int)tret);
     err = pthread_create(&tid1, NULL, thr_fn1, NULL);
     if (err != 0) {
	  printf("can't create thread1 : %s\n", strerror(err));
	  goto back;
     }

     err = pthread_create(&tid2, NULL, thr_fn2, NULL);
     if (err != 0) {
	  printf("can't create thread2 : %s\n", strerror(err));
	  goto back;
     }

     err = pthread_join(tid1, NULL);
     if (err != 0) {
	  printf("can't join with thread1: %s\n", strerror(err));
	  goto back;
     }
     printf("thread1 exit code %d\n", (int)tret);

     err = pthread_join(tid2, &tret);
     if (err != 0) {
	  printf("can't join with thread2: %s\n", strerror(err));
	  goto back;
     }
     printf("thread2 exit code %d\n", (int)tret);

back:
     exit(0);
}
