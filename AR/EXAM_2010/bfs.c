#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#define TAGINIT 0
#define TAGMSG 1
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
    int i,ret_val;
    
    MPI_Recv(&voisins, 3, MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);
     printf("%d: recois sont init\n",myRank);
    //fin d'initialiation
    printf("%d ",myRank);
    for(i=0;i<2;i++){
     printf("envois au voisin %d",voisins[i]);
     MPI_Send(&myRank,1, MPI_INT, voisins[i], TAGMSG, MPI_COMM_WORLD);
     MPI_Recv(&ret_val, 1, MPI_INT, MPI_ANY_SOURCE, TAGMSG, MPI_COMM_WORLD, &status);
     printf("%d init a recus une réponse de %d",myRank,ret_val);
    }
}
void Recpction_msg(int myRank){
    //printf(":: %d  :: %d :: \n",myRank,voisins[2]);
    int i,ret_val;
    MPI_Status status;
    for(i=0;i<2;i++)
        if(voisins[i]!=-1){
            printf("envois au voisin %d",voisins[i]);
            MPI_Send(&myRank,1, MPI_INT, voisins[i], TAGMSG, MPI_COMM_WORLD);
            MPI_Recv(&ret_val, 1, MPI_INT, MPI_ANY_SOURCE, TAGMSG, MPI_COMM_WORLD, &status);
            printf("%d a recus une réponse de %d",myRank,ret_val);
        }
    MPI_Send(&myRank,1,MPI_INT,voisins[2],TAGMSG,MPI_COMM_WORLD);
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
    //printf(":: %d :: \n",myRank);
    if (myRank == 0) {
        //ont Construit l'arbre
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
        MPI_Recv(&voisins, 3, MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);
        printf("%d: recois sont init\n",myRank);
       
        //recp du message
        Recpction_msg(myRank);
    }
    MPI_Finalize();
    return 0;
}
