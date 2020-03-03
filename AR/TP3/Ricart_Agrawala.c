#include <mpi.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

/* Nb req */
#define MAX_CS 5

/* Les différent type de demande */
#define REQUEST 0
#define REPLY 1
#define END 2

/* Les etat du process*/
#define ENDED 0
#define WORKING 1
//rank et le nombre de process
int rank;
int nb_proc;
int *file;
int nb_entrer=0;
int clock = 0;
int clock_req = 0;
int nb_proc_end =0;
int nb_reply = 0;
int nb_request=0;
/**
    ajute l'heur du process ont fonction de l'heur recus
*/
void message(int dest,int tag){
    clock++;
	MPI_Send(&clock, 1, MPI_INT, dest, tag, MPI_COMM_WORLD);
}
void  my_clockHandler(int other_clock)
{
    clock = clock > other_clock ? clock+1 : other_clock+1;
}

void my_bcast(int req)
{
    clock++;// je suis pas sur si il faut pas la metre dans la boucle
    int i;
    for(i=0;i<nb_proc;i++)
        if(i!=rank)
            MPI_Send(&clock, 1, MPI_INT, i, req, MPI_COMM_WORLD);
    printf("%d a envoyer a tlm ça demande\n", rank);
}

void request_cs()
{
    printf("%d fait une demande d'entrer ont cs\n",rank);
    my_bcast(REQUEST);
}

void release_cs(){
    int i;
    printf("%d va relacher %d a %d\n", rank, nb_request, clock);
    for(i =0;i<nb_request;i++){
        if(file[i]!=-1)
        message(file[i],REPLY);
    }
    nb_reply=0;
}



void my_respHandler()
{
    MPI_Status status;
    MPI_Recv(&clock_req, 1, MPI_INT, MPI_ANY_SOURCE, MPI_ANY_TAG, MPI_COMM_WORLD, &status);
    my_clockHandler(clock_req);
    switch (status.MPI_TAG) {
        case END:
            nb_proc_end++;
            break;
        case REPLY:
            nb_reply++;
            break;
        case REQUEST:
            //si il a demander avant ou que il a une plus grande pri ont sed la main
            if(clock_req < clock || (clock_req == clock && status.MPI_SOURCE < rank))
                message(status.MPI_SOURCE, REPLY);
            //sinon j'ajoute une demande
            else{
                nb_request++;
                file[nb_request] = status.MPI_SOURCE;
            }
            break;
    }

}

void remove_my_request(){
    int i;
    for(i=0;i<nb_request;i++){
        if(file[i]==rank)
            file[i]=-1;
    }
}

int main(int argc, char  *argv[]) {
    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &nb_proc);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    file = (int *) malloc(sizeof(int) * nb_proc);
    while (nb_entrer < MAX_CS) {
        request_cs();
        //ont att de pouvoir entrer dans la section critique
        while (nb_reply < nb_proc-1)
            my_respHandler();

        printf("%d est ont  CS et il est seul a  %d !!!!\n", rank, clock);
        sleep(10);
        nb_entrer++;
        release_cs();
    }
    //ont dit a tlm que j'ai fini
    my_bcast(END);
    remove_my_request();
    free(file);
    while(nb_proc_end < nb_proc - 1)
        my_respHandler();

    MPI_Finalize();
    return 0;
}
