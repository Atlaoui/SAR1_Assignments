#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
//git clone https://github.com/ScumPetard/Operator-Mono.git
#define TAGINIT 0
#define TAGMSG 1
#define TAGUP 2
#define NB_SITE 9

int voisins[3];

void simulateur(void) {
    int i;
     /* liste des voisins */
    int voisins[NB_SITE+1][3] = {{-1, -1, -1},
    {2, 3, -1}, {4, 5, 1},
    {-1, 6, 1}, {-1, -1, 2},
    {7,8, 2}, {9, -1, 3}, {-1, -1, 5}, {-1, -1, 5}, {-1, -1, 6}};
    for(i=1; i<=NB_SITE; i++)
        MPI_Send(voisins[i],3, MPI_INT, i, TAGINIT, MPI_COMM_WORLD);  
}

void Init_parcours(int myRank){
     //initialisation
    MPI_Status status;
    int i,nul;
    
    MPI_Recv(&voisins, 3, MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);
    //fin d'initialiation
    printf("%d ",myRank);
    for(i=0;i<2;i++){
     MPI_Send("Alo",4, MPI_CHAR, i, TAGMSG, MPI_COMM_WORLD);
     MPI_Recv(&nul, 1, MPI_INT, i, TAGUP, MPI_COMM_WORLD, &status);
    }

}
void Recpction_msg(int myrank, char * msg){
    int i,nul;
    MPI_Status status;
    printf("%d %s",myrank,msg);
    for(i=0;i<2;i++)
        if(i!=-1){
            MPI_Send("Ola",4, MPI_CHAR, i, TAGMSG, MPI_COMM_WORLD);
            MPI_Recv(&nul, 1, MPI_INT, i, TAGUP, MPI_COMM_WORLD, &status);
        }
    MPI_Send(&nul,1,MPI_INT,voisins[2],TAGUP,MPI_COMM_WORLD);
}

/******************************************************************************/
int main (int argc, char* argv[]) {
    int nb_proc,myRank;
    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &nb_proc);

    if (nb_proc != NB_SITE+1) {
        printf("Nombre de processus incorrect !\n");
        MPI_Finalize();
        exit(2);
    }

    MPI_Comm_rank(MPI_COMM_WORLD, &myRank);

    if (myRank == 0) {
        printf("%d: va lancer le simulateur\n",myRank);
        simulateur();
    } 
    
    if(myRank==1) {
        printf("%d: va init le parcour\n",myRank);
        Init_parcours(myRank);
    }
    else{
        MPI_Status status;
        int i;
        char *msg;
        printf("%d: recois sont init\n",myRank);
        MPI_Recv(&voisins, 3, MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);
        //recp du message
        MPI_Recv(msg, 4, MPI_CHAR, MPI_ANY_SOURCE, TAGMSG, MPI_COMM_WORLD, &status);
        Recpction_msg(myRank,msg);
    }
    MPI_Finalize();
    return 0;
}
