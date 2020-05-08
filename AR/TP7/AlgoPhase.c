#include <mpi.h>
#include <stdlib.h>
#include <stdio.h>
#define TAGINIT 0
#define TAGMIN 1
#define NB_SITE 6

#define DIAMETRE 5 /* !!!!! valeur a initialiser !!!!! */
#define DEG_IN_MAX 2 /* le max des degres entrants des noeuds */
#define DEG_OUT_MAX 2 /* le max des degres sortants des noeuds */
/*************************************Simulateur*********************************************/
void simulateur(void){
int i;
/* nb_voisins_in[i] est le nombre de voisins entrants du site i */
int nb_voisins_in[NB_SITE+1] = {-1, 2, 1, 1, 2, 1, 1};
/* nb_voisins_out[i] est le nombre de voisins sortants du site i */
int nb_voisins_out[NB_SITE+1] = {-1, 2, 1, 1, 1, 2, 1};

int min_local[NB_SITE+1] = {-1, 4, 7, 1, 6, 2, 9};
/* liste des voisins entrants */
int voisins_in[NB_SITE+1][2] = {{-1, -1},{4, 5}, {1, -1}, {1, -1},{3, 5}, {6, -1}, {2, -1}};

/* liste des voisins sortants*/
int voisins_out[NB_SITE+1][2] = {{-1, -1},{2, 3}, {6, -1} , {4, -1},{1, -1} , {1, 4} ,{5,-1}};

    for(i=1; i<=NB_SITE; i++){
        MPI_Send(&nb_voisins_in[i], 1, MPI_INT, i, TAGINIT, MPI_COMM_WORLD);
        MPI_Send(&nb_voisins_out[i], 1, MPI_INT, i, TAGINIT, MPI_COMM_WORLD);
        MPI_Send(voisins_in[i], nb_voisins_in[i], MPI_INT, i, TAGINIT,MPI_COMM_WORLD);
        MPI_Send(voisins_out[i], nb_voisins_out[i], MPI_INT, i, TAGINIT,MPI_COMM_WORLD);
        MPI_Send(&min_local[i], 1, MPI_INT, i, TAGINIT, MPI_COMM_WORLD);
    }
}
/*************************************Simulateur*********************************************/

void send_Min(int *voisins , int nb_voisins,int tag,int min){
    int i;
    for (i = 0; i < nb_voisins; i++)
            MPI_Send(&min, 1, MPI_INT, voisins[i], tag, MPI_COMM_WORLD);
}

int min(int a, int b) {return (a<b?a:b);}

int calcul_min(int rang){
    MPI_Status status;
    int nb_voisins_in,nb_voisins_out,my_min,nei_min,i;
    /*Nombre de message recus/envoyer*/
    int Rcpt=0,Scpt=0;
    int voisins_in[DEG_IN_MAX],voisins_out[DEG_OUT_MAX],Rcount[DEG_IN_MAX];
    
    
    /* Faux des que ont a recus D message de touts c'est voisin */
    int is_end=1;

    /* Compteur de message  */

    /*                                  INIT                                 */
    MPI_Recv(&nb_voisins_in, 1, MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);
    MPI_Recv(&nb_voisins_out, 1, MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);
    MPI_Recv(&voisins_in, nb_voisins_in, MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);
    MPI_Recv(&voisins_out, nb_voisins_out , MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);
    MPI_Recv(&my_min, 1 , MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);
    for(i=0; i<nb_voisins_in; i++) Rcount[i] = 0;
    /*                                  INIT                                 */

    printf("%d: A fini son Ini\n", rang);
    while(is_end!=-1)
        for(i = 0;(is_end!=-1) && i<nb_voisins_in;i++){
             //Phase d'envois
            if(Rcount[i]>=Scpt && Scpt<DIAMETRE){
                printf("%d: Envoie sont min\n", rang);
                send_Min(voisins_out,nb_voisins_out,TAGMIN,my_min);
                Scpt++;
            }
            printf("%d: Attend une réponse de c'est voisins\n", rang);
            //traitement de recption
            MPI_Recv(&nei_min, 1, MPI_INT, voisins_in[i], TAGMIN, MPI_COMM_WORLD, &status);
            my_min = min(my_min,nei_min);
            Rcount[i]++;
            if(Rcount[i]==DIAMETRE) 
                Rcpt++;
            printf("%d a recus cpt:%d\n", rang, Rcpt);
            if(Rcpt==nb_voisins_in){
                printf("%d Tout mes voisins ont envoyé D msg\n", rang);
                is_end=-1;
            }
        }

     printf("Decision %d Le minimum est: %d\n",rang, my_min);
    
    return 0;
}


/*********************************************************************************************/

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
        simulateur();
    } else {
        calcul_min(myRank);
    }

    MPI_Finalize();
    return 0;
}