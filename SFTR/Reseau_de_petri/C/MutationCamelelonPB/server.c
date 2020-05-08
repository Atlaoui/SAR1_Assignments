/* =========================================================== */
/* file server.c
C /POSIX
*/
/* =========================================================== */
#include <semaphore.h>
#include "filetypes.h"
sem_t Mutex;
sem_t SemPriv;
int FirstCall = 1;
Color AColor;
Color BColor;
/* =========================================================== */
Color Server(IdCameleon id, Color c)
{
    Color otherColor;
    int val;
    sem_wait(&Mutex);
    // user programmed mutual exclusion = setting the lock
    if (FirstCall)
    {
        AColor = c;
        FirstCall = 0;
        // the next call will be considered as a second one
        sem_post(&Mutex);
        sem_wait(&SemPriv); // waiting for the lock
        otherColor = BColor;
        sem_post(&Mutex); // releases the lock since the rendez-vous ends
    }
    else
    { //this is the second caméléons of the pair
        FirstCall = 1;
        BColor = c;
        otherColor = AColor;
        // the next call will start a new meeting
        sem_post(&SemPriv); // passes the lock to its mate
    }
    return otherColor;
}
/* =========================================================== */
void initServer(void)
{
    sem_init(&Mutex, 0, 1);
    sem_init(&SemPriv, 0, 0);
}