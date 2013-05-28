#include "../apue.h"
#include <pthread.h>

struct foo {
     int f_count;
     pthread_mutex_t f_lock;
};

struct foo * fp;

struct foo * foo_alloc(void)
{
     struct foo *fp;
     if ((fp = malloc(sizeof (struct foo))) != NULL) {
	  fp->f_count = 100;
	  if (pthread_mutex_init(&fp->f_lock, NULL) != 0) {
	       free(fp);
	       return NULL;
	  }
     }

     return fp;
}

void foo_hold(struct foo * fp, char * arg)
{
     pthread_mutex_lock(&fp->f_lock);
     fp->f_count++;
     printf("%s fp->f_count = %d\n", (char *)arg, fp->f_count);
     pthread_mutex_unlock(&fp->f_lock);
}

void foo_rele(struct foo * fp, char *arg)
{
     pthread_mutex_lock(&fp->f_lock);
     fp->f_count--;
     printf("%s fp->f_count = %d\n", arg, fp->f_count);
     if ((fp->f_count) == 0) {
	  pthread_mutex_unlock(&fp->f_lock);
	  pthread_mutex_destroy(&fp->f_lock);
	  free(fp);
     } else {
	  pthread_mutex_unlock(&fp->f_lock);
     }
}

void * thr_fn1(void *arg)
{
     printf("thread1 started\n");
     while(1) {
	  foo_hold(fp, "thread 1 hold fp\n");
	  sleep(30);
	  foo_rele(fp, "thread 1 rele fp\n");
     }
}

void * thr_fn2(void *arg)
{
     printf("thread2 started\n");
     while(1) {
	  foo_hold(fp, "thread 2 holde fp\n");
	  sleep(30);
	  foo_rele(fp, "thread 2 rele fp\n");
     }
}

int main(void)
{
     int err; 
     pthread_t tid1, tid2;
     
     fp = foo_alloc();
     if (!fp) {
	  printf("fp alloc error!\n");
	  goto back;
     }
     err = pthread_create(&tid1, NULL, thr_fn1, NULL);
     if (err != 0) {
	  printf("can't create thread1: %s\n", strerror(err));
	  goto back;
     }

     err = pthread_create(&tid2, NULL, thr_fn2, NULL);
     if (err != 0) {
	  printf("can't create thread2: %s\n", strerror(err));
	  goto back;
     }

     while(1) {
	  foo_hold(fp, "main thread hold fp\n");
	  sleep(30);
	  foo_rele(fp, "main thread rele fp\n");
     }
back:
     exit(0);
}
