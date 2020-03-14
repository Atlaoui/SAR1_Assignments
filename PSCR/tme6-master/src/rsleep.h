#ifndef __RSLEEP_H__
#define __RSLEEP_H__

void randsleep();

void sigalarm_handler(int);

int wait_till_pid(pid_t pid);

int wait_till_pid (pid_t pid, int sec);

#endif
