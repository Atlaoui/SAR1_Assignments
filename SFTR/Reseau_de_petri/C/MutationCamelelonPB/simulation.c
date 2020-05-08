/* =========================================================== */
/* file simulation.c
/* =========================================================== */
#include <stdio.h>
#include <pthread.h>
#include "filetypes.h"

/* =========================================================== */
Color complementaryColor(Color c1, Color c2)
{
    if (c1 == c2)
        return c1;
    else
        return (3 - c1 - c2);
}
/* =========================================================== */
extern Color Server(IdCameleon id, Color c);
extern void initServer(void);
/* =========================================================== */
void chameneosCode(void *args)
{
    IdCameleon myId;
    Color myColor, oldColor, otherColor;
    sscanf((char *)args, "%d %d", &myId, &myColor);
    printf("(%d) I am (%d) and I am running\n", myId, myColor);
    while (1)
    {
        printf("(%d) I am (%d) and I am eating honey suckle and training\n",
               myId, myColor);
        printf("(%d) I am (%d) and I am going to the server \n",
               myId, myColor);
        otherColor = Server(myId, myColor);
        oldColor = myColor;
        myColor = complementaryColor(myColor, otherColor);
        printf("(%d) I am (%d) and I was %d before\n",
               myId, myColor, oldColor);
    }
}
/* =========================================================== */
int main(void)
{
    Color tabColor[NB_CAMELEON] = {Yellow, Blue, Red, Blue};
    char theArgs[255][NB_CAMELEON];
    pthread_t tabPid[NB_CAMELEON];
    int i;
    initServer();
    for (i = 0; i < NB_CAMELEON; i++)
    {
        sprintf(theArgs[i], "%d %d", i, tabColor[i]);
        pthread_create(&tabPid[i], NULL, (void *(*)())chameneosCode, theArgs[i]);
    }
    // waiting the end of children (that will never come)
    for (i = 0; i < NB_CAMELEON; i++)
    {
        pthread_join(tabPid[i], NULL);
    }
    return 0;
}