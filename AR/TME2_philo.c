#include <stdio.h>
#include <mpi.h>
#include <unistd.h>
//************   LES TAGS
#define WANNA_CHOPSTICK 0		// Demande de baguette
#define CHOPSTICK_YOURS 1		// Cession de baguette
#define DONE_EATING     2		// Annonce de terminaison

//************   LES ETATS D'UN NOEUD
#define THINKING 0   // N'a pas consomme tous ses repas & n'attend pas de baguette
#define HUNGRY   1   // En attente de baguette
#define DONE     2   // A consomme tous ses repas

//************   LES REPAS
#define NB_MEALS 3	// nb total de repas a consommer par noeud

//************   LES VARIABLES MPI
int NB;               // nb total de processus
int rank;             // mon identifiant
int left, right;      // les identifiants de mes voisins gauche et droit

//************   LA TEMPORISATION
int local_clock = 0;                    // horloge locale
int clock_val;                          // valeur d'horloge recue
int meal_times[NB_MEALS];        // dates de mes repas

//************   LES ETATS LOCAUX
int local_state = THINKING;		// moi
int left_state  = THINKING;		// mon voisin de gauche
int right_state = THINKING;		// mon voisin de droite

//************   LES BAGUETTES
int left_chopstick = 0;		// je n'ai pas celle de gauche
int right_chopstick = 0;	// je n'ai pas celle de droite

//************   LES REPAS
int meals_eaten = 0;		// nb de repas consommes localement

//************ POUR LES DELAIS
#define ATT 15
//************   LES FONCTIONS   ***************************
int max(int a, int b) {
    return (a>b?a:b);
}

void receive_message(MPI_Status *status) {
    MPI_Recv(NULL, 0, NULL, MPI_ANY_SOURCE, MPI_ANY_TAG, MPI_COMM_WORLD, status);
}

void send_message(int dest, int tag) {
    MPI_Send(NULL, 0, NULL, dest, tag, MPI_COMM_WORLD);
}

/* renvoie 0 si le noeud local et ses 2 voisins sont termines */
int check_termination() {
    return (right_state == DONE && left_state == DONE && local_state == DONE);
}

//************   LE PROGRAMME   ***************************
int main(int argc, char* argv[]) {

    MPI_Status status;

    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &NB);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);

    if(NB<3){
        fprintf( stderr, "Nombre de philosophe trop petit");
        // MPI_Finalize();
        return 1;
    }
    //pos du voisin droite
    left = (rank + NB - 1) % NB;
    //pos du voisin de gauche
    right = (rank + 1) % NB;
    //tant que les deux voisin non pas fini leur repat

    while(!check_termination()) {
        /* Tant qu'on n'a pas fini tous ses repas, redemander les 2 baguettes
        a chaque fin de repas */
        printf("%d boucle encore\n", rank);
        if ((meals_eaten < NB_MEALS) && (local_state == THINKING)) {
            //demande de baguette aux 2 voisins
            local_state = HUNGRY;
            send_message(left,WANNA_CHOPSTICK);
            send_message(right,WANNA_CHOPSTICK);
            printf("P%d> Asking for chopsticks at %d\n", rank, local_clock);
        }
        receive_message(&status);
        //gestiion des terminaison
        if (status.MPI_TAG == DONE_EATING) {
            //Enregistrer qu'un voisin a fini de manger
            if(status.MPI_SOURCE == left){
                left_state = DONE;
            }
            if(status.MPI_SOURCE == right){
                right_state = DONE;
            }
        } else if (status.MPI_TAG == CHOPSTICK_YOURS) {
            if(status.MPI_SOURCE == left){
                printf("[%d] prend la baguette gauche %d", rank, left);
                left_chopstick = 1;
            }
            if(status.MPI_SOURCE == right && left_chopstick == 1){
                printf("[%d] la baguette de gauche %d, je recupere la baguette droite %d\n",rank ,left, right);
                right_chopstick = 1;
                meals_eaten ++;
                local_state = THINKING;
                if(meals_eaten == NB_MEALS){
                    printf("J'AI FINI DE MANGER %d\n", rank);
                    send_message(left, DONE_EATING);
                    send_message(right, DONE_EATING);
                    local_state = DONE;
                }
            }
            if(right_chopstick && left_chopstick){
                //donne aux voisins
                printf("%d : envois a %d sont CHOPSTICK\n",rank,left);
                send_message(left, CHOPSTICK_YOURS);
                printf("%d : envois a %d sont CHOPSTICK\n",rank,right);
                send_message(right, CHOPSTICK_YOURS);
            }
        } else {
            // demande
            send_message(left, WANNA_CHOPSTICK);
            send_message(right, WANNA_CHOPSTICK);
        }
    }
    printf("%d a fini son repas\n", rank);

    MPI_Finalize();
    return 0;
}

/*
1- Cas où philosophe veut  prendre baguettte : envoie un message de demande de baguette
Variable locale à gerer: left_chopstick & right_chopstick => permet de signaler qu'il possede la baguette
Si 2 voisins font leur demande en même temps alors: problème car

2- Si tous les philosophes font leurs demandes en même temps on aura un interblocage
Pour casser cet interblocage on les ordonne et on utilise les horloges de Lamport

3- Terminaison: qd je meurs mes voisins doivent avoir finit de manger et quand personne ne peut lui envoyer des messages .
*/
