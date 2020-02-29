#include "mpi_server.h"
static server the_server;
//ICI CODE THREAD SERVEUR A COMPLETER
void start_server(void (*callback)(int tag, int source)){
    //A COMPLETER
}
void destroy_server(){
    
}
//caca
pthread_mutex_t* getMutex(){
    return &the_server.mutex;
}
