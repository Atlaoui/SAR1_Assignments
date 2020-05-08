#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#define __USE_UNIX98
#include <pthread.h>
#include <sched.h>
#include <errno.h>

#include "threads_dispatch.h"
#include "threads_ports.h"

void T1_body();
void T2_body();
void T3_body();

unsigned int get_time_ns();
void simulate_exec_time(unsigned int exec_time_ns);

char reached_barrier=0;
#define NB_THREADS 2

// Initialization of data for task T1 (periodic, period = 1000 ms)
thread_config_t T1_info = {1000, 0};

// Initialization of data for task T2 (periodic, period = 2000 ms)
thread_config_t T2_info = {2000, 0};

// Initialization of data for task T3 (sporadic, period = 6000 ms)
// one message queue of size 5, each message is a char
pthread_mutex_t T3_q_rez;
pthread_cond_t T3_q_event;
extern sporadic_thread_config_t T3_info;
char T3_q_waiting=1;
int T3_q_msg_nb=0;

char T3_q_port1_content[5]={0,0,0,0,0};
port_queue_t T3_q_port1 = {5, -1, -1, -1, sizeof(char), T3_q_port1_content};

thread_queue_t T3_q = {&T3_q_rez, 
		       &T3_q_event, 
		       (union thread_config *) &T3_info,
		       0,
		       0,
		       {&T3_q_port1}};

struct timespec T3_timespec;
sporadic_thread_config_t T3_info = {6000, 
				    &T3_timespec,
				    &T3_q,
				    0};

pthread_mutex_t start_barrier_mutex;
pthread_cond_t start_barrier_cond;
pthread_cond_t main_barrier_cond;


pthread_mutex_t lock1;
pthread_mutex_t lock2;

int main(int argc, char* argv[])
{
  int max_prio = sched_get_priority_max(SCHED_FIFO);
  int min_prio = sched_get_priority_min(SCHED_FIFO);
  pthread_t thId = pthread_self();
  pthread_setschedprio(thId, min_prio); // we put the main thread at
					// the min prio to make sure
					// other threads start as soon
					// as they are ready (no
					// preemtion of T1, T2, and T3
					// by the main thread).

  pthread_mutex_init(&start_barrier_mutex, NULL);
  pthread_cond_init(&start_barrier_cond, NULL);
  pthread_cond_init(&main_barrier_cond, NULL);
  
  //Ajout perso
  pthread_mutex_init(&lock1, NULL);
  pthread_mutex_init(&lock2, NULL);
  


  /* Q2_b: to be completed, make sure there is no deadlock
   * when using lock1 and lock2
   */
  pthread_mutexattr_t lock_attr;
  pthread_mutexattr_setprotocol(&lock_attr, PTHREAD_PRIO_PROTECT);
  pthread_mutexattr_setprioceiling(&lock_attr, max_prio - 1);
  pthread_mutex_init(&lock1, &lock_attr);
  pthread_mutex_init(&lock2, &lock_attr);

  init_periodic_config(&T1_info);
  init_periodic_config(&T2_info);
  init_sporadic_config((thread_config_t*)&T3_info);


  /* Q1: to be completed, complete function create_fp_thread (in file
   * threads_dispatch.c) to create threads T1, and T2
   */
  pthread_t T1_tid;
  create_fp_thread(max_prio-1, 40960, (void*) T1_body, &T1_tid, SCHED_FIFO);


  pthread_t T2_tid;
  create_fp_thread(max_prio-2, 40960, (void*) T2_body, &T2_tid, SCHED_FIFO);

  /* Q3: to be completed, use function create_fp_thread to create
     thread T3
   */

  pthread_mutex_lock(&start_barrier_mutex);
  while(reached_barrier<NB_THREADS)
  {
    pthread_cond_wait(&main_barrier_cond, &start_barrier_mutex);
  }
  pthread_mutex_unlock(&start_barrier_mutex);
  
  set_start_time();

  pthread_cond_broadcast(&start_barrier_cond);

  /* Q1-Ok: to be completed. Make sure the main does not abort threads.
   */
  pthread_join(T1_tid,NULL);
  pthread_join(T2_tid,NULL);

}


void T1_body()
{
  simulate_exec_time(500000000); // 500 ms; simulate initialization time
  pthread_mutex_lock(&start_barrier_mutex);
  reached_barrier++;
  pthread_cond_signal(&main_barrier_cond);
  pthread_cond_wait(&start_barrier_cond, &start_barrier_mutex);
  pthread_mutex_unlock(&start_barrier_mutex);
  while(1)
  {
    display_relative_date("Start thread T1", (T1_info.periodic_config).iteration_counter);
    /*Q2_a: acquire lock2*/
    pthread_mutex_lock(&lock2);
    simulate_exec_time(200000000); // 200 ms;
    /*Q2_a: acquire lock1*/
    pthread_mutex_lock(&lock1);
    simulate_exec_time(100000000); // 100 ms;
    /*Q2_a: release lock1*/
    pthread_mutex_unlock(&lock1);
    /*Q2_a: release lock2*/
    pthread_mutex_unlock(&lock2);
    simulate_exec_time(100000000); // 100 ms;
    //pthread_mutex_unlock(&lock1);

    static char c = 0;
    c++;
    if(c%3==0)
      SendOutput_runtime(&T3_q, 0, &c);
    printf("Finish thread T1\n");
    
    /*Q1: to be completed, complete function await_periodic_dispatch
      (threads_dispatch.c) */
    await_periodic_dispatch(&T1_info);
  }
}

void T2_body()
{
  pthread_mutex_lock(&start_barrier_mutex);
  reached_barrier++;
  pthread_cond_signal(&main_barrier_cond);
  pthread_cond_wait(&start_barrier_cond, &start_barrier_mutex);
  pthread_mutex_unlock(&start_barrier_mutex);
  while(1)
  {
    display_relative_date("Start thread T2", (T2_info.periodic_config).iteration_counter);
    /*Q2_a: acquire lock1*/
    pthread_mutex_lock(&lock1);
    simulate_exec_time(600000000); // 600 ms;
    /*Q2_a: acquire lock2*/
    pthread_mutex_lock(&lock2);
    simulate_exec_time(100000000); // 100 ms;
    /*Q2_a: release lock2*/
    /*Q2_a: release lock1*/
    pthread_mutex_unlock(&lock2);
    pthread_mutex_unlock(&lock1);
    simulate_exec_time(100000000); // 100 ms;
   // pthread_mutex_unlock(&lock1);
    
    printf("Finish thread T2\n");

    /*Q1: to be completed, complete function await_periodic_dispatch
      (threads_dispatch.c) */
    await_periodic_dispatch(&T2_info);

  }
}

void T3_body()
{
  pthread_mutex_lock(&start_barrier_mutex);
  reached_barrier++;
  pthread_cond_signal(&main_barrier_cond);
  pthread_cond_wait(&start_barrier_cond, &start_barrier_mutex);
  pthread_mutex_unlock(&start_barrier_mutex);
  while(1)
  {
    StatusType status = await_sporadic_dispatch(T3_info.global_q);
    ReceiveInputs_runtime(T3_info.global_q, 0);
    printf("Start thread T3\n");

    char c;
    NextValue_runtime(T3_info.global_q, 0, &c);
    printf("T3, received data: %d\n", c);

    simulate_exec_time(2000000000); // 200 ms;
    printf("Finish thread T3\n");
  }
}

void simulate_exec_time(unsigned int exec_time_ns)
{
  unsigned int start_time_ns = get_time_ns();
  char reached = 0;
  while(!reached)
  {
    unsigned int current_time_ns = get_time_ns();
    if(current_time_ns - start_time_ns > exec_time_ns)
      reached = 1;
  }
}

unsigned int get_time_ns()
{
  struct timespec current_time;
  clock_gettime(CLOCK_MONOTONIC, &current_time);
  unsigned int current_time_ns = (current_time.tv_sec*1000000000)+current_time.tv_nsec;
  return current_time_ns;
}
