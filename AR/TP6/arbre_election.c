#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <unistd.h>


#define NO_INIT 0
#define INIT 1
#define TAGINIT 2
#define TAG_IDENT 3
#define TAG_IDEND_RET 4
#define TAG_REVEIL 5

//Nb process
#define NB_SITE 6

int nb_proc,leader;

int isInit(int rang){
    int ret = rand() % 2;
    //int ret = rang==6 ? INIT : NO_INIT;
    //pour le debug
    //int ret = rang%2;
	if (ret){
		printf("%d: est candidat a l'élection \n", rang);
       return INIT;
	}
	printf("%d: n'est pas candidat a l'élection \n", rang);
	return NO_INIT;
}

void simulateur(void){
    int i;

    /* nb_voisins[i] est le nombre de voisins du site i */
    int nb_voisins[NB_SITE + 1] = { -1, 2, 3, 2, 1, 1, 1 };
    srand(getpid());
    /* liste des voisins */
    int voisins[NB_SITE + 1][3] = { { -1, -1, -1 },
        { 2, 3, -1 }, { 1, 4, 5 },
        { 1, 6, -1 }, { 2, -1, -1 },
        { 2, -1, -1 }, { 3, -1, -1 } };
    int val;
    for (i = 1; i <= NB_SITE; i++) {
        MPI_Send(&nb_voisins[i], 1, MPI_INT, i, TAGINIT, MPI_COMM_WORLD);
        MPI_Send(voisins[i], nb_voisins[i], MPI_INT, i, TAGINIT, MPI_COMM_WORLD);
        val = isInit(i);
        MPI_Send(&val,1, MPI_INT, i, TAGINIT, MPI_COMM_WORLD);
    }
}

//factorise le code de envois pour touts les voisin sauf la source
void send_Nei(int * voisins , int nb_voisins,int tag,int source){
    int i;
    for (i = 0; i < nb_voisins; i++)
        if(voisins[i]!=source)
            MPI_Send(&i, 1, MPI_INT, voisins[i], tag, MPI_COMM_WORLD);
}

void send_Nei_data(int * voisins , int nb_voisins,int tag,int source,int data){
    int i;
    for (i = 0; i < nb_voisins; i++)
        if(voisins[i]!=source)
            MPI_Send(&data, 1, MPI_INT, voisins[i], tag, MPI_COMM_WORLD);
    printf("%d send to all his min rank",source);
}

int min(int a, int b) {return (a<b?a:b);}

void election(int rang){
    //************************ INIT ************************
    MPI_Status status;
    int *voisins;
    int nb_voisins,last;
    int init,nb_recv=0;
    //tableau pour ce rapeler de qui a envoyer sont msg
    int recv_from[NB_SITE + 1];
    MPI_Recv(&nb_voisins, 1, MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);
    voisins = (int *) malloc(sizeof(int) * nb_voisins);
    MPI_Recv(voisins, nb_voisins, MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);
    MPI_Recv(&init, 1, MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);

    printf("%d: a fini sont initialisation\n",rang);
    //********************** END INIT **********************
    
    //si init et que ont est pas une feuille on envois a touts les voisin sauf lui meme
    if(init==INIT && nb_voisins != 1){
        send_Nei(voisins,nb_voisins,TAG_REVEIL,rang);
        send_Nei_data(voisins,nb_voisins,TAG_IDENT,rang,rang);
    }
    
    if(init==INIT && nb_voisins == 1){
        send_Nei_data(voisins,nb_voisins,TAG_IDENT,rang,rang);
    }
    int rank_recu,leader=rang;
    int first_time=0;
    int send_f;
    while (nb_recv < nb_voisins){
        //************************ R(p)
        printf("%d: va attendre un msg\n",rang);
        MPI_Recv(&rank_recu, 1, MPI_INT, MPI_ANY_SOURCE, MPI_ANY_TAG, MPI_COMM_WORLD, &status);
        
        //si je suis pas init et que je recois un réveill je réveille mes voisin
        if(status.MPI_TAG==TAG_REVEIL && init==NO_INIT){
            printf("%d: A recus un msg reveill et va envoyer a tlm sauf l'expéditeur\n",rang);
            send_Nei(voisins,nb_voisins,TAG_REVEIL,status.MPI_SOURCE);
        }else if(status.MPI_TAG==TAG_IDENT){
            printf("%d: received %d from %d\n", rang, rank_recu,status.MPI_SOURCE);
            //si c'est la 1er fois que je recois un msg et que je suis pas une feuille et que je ne suis pas un init
            if(first_time==0 && nb_voisins!=1 && init==NO_INIT){
                first_time=1;
                leader = min(leader,rank_recu);
                send_Nei_data(voisins,nb_voisins,TAG_IDENT,leader,status.MPI_SOURCE);
                send_f=status.MPI_SOURCE;  
                continue;
            }else{
                 leader = min(leader,rank_recu);
                 MPI_Send(&leader, 1, MPI_INT, status.MPI_SOURCE, TAG_IDENT, MPI_COMM_WORLD);
            }

            //************************ S(p)
            
                leader = min(leader,rank_recu);
                nb_recv++;
                recv_from[status.MPI_SOURCE] = 1;
                last = status.MPI_SOURCE;       
            printf("%d a recus %d msg \n",rang,nb_recv);
            
            //************************ D(p)
            if (nb_recv == nb_voisins-1) 
                //send_Nei_data(voisins,nb_voisins,TAG_IDENT,last,leader);
                MPI_Send(&leader, 1, MPI_INT, send_f, TAG_IDENT, MPI_COMM_WORLD);
        }
    }
    printf("\033[1;33m %d: a Elu %d \033[0m\n",rang,leader);
    //************************ END ************************
    free(voisins);
}


int main(int argc, char* argv[]){
    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &nb_proc);

    if (nb_proc != NB_SITE + 1) {
        printf("Nombre de processus incorrect !\n");
        MPI_Finalize();
        exit(2);
    }
    int  rang;
    MPI_Comm_rank(MPI_COMM_WORLD, &rang);
     if (rang == 0) {
        simulateur();
    } else {
        election(rang);
    }
    MPI_Finalize();
    return 0;
}