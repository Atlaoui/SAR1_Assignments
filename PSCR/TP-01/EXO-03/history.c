#include<stdlib.h>
#include<stdio.h>

#include"history.h"

/**
  * new_history - alloue, initialise et retourne un historique.
  *
  * @name: nom de l'historique
  */
struct history *new_history(char *name)
{
	/* TODO : Exercice 3 - Question 2 */
    struct history *h=malloc(sizeof(struct history));
    h->commit_count=0;
    h->commit_list=NULL;
    h->name=name;
    return h;
}

/**
  * last_commit - retourne l'adresse du dernier commit de l'historique.
  *
  * @h: pointeur vers l'historique
  */
struct commit *last_commit(struct history *h)
{
	/* TODO : Exercice 3 - Question 2 */
    /*si il n'y a que un element dans la liste */
	if(  h->commit_list==NULL)
	    return h->commit_list;
    /* si il n'y a que un element dans la liste */
	if(h->commit_count==1)
	    return h->commit_list;

    return h->commit_list->prev;
}

/**
  * display_history - affiche tout l'historique, i.e. l'ensemble des commits de
  *                   la liste
  *
  * @h: pointeur vers l'historique a afficher
  */
void display_history(struct history *h)
{
	/* TODO : Exercice 3 - Question 2 */
    if(h!=NULL) {
        struct commit *tmp = h->commit_list;
        unsigned long max = h->commit_count;
        printf("1' \n");
        long cpt=0;
        printf("Historique de 'Tout une histoire' \n");
        printf("1' \n");
        while(cpt<max && tmp !=NULL){
            printf("1' \n");
            cpt++;
            printf("1' \n");
            printf("%ld: %2u.%lu: '%s' \n",cpt,tmp->version.major,tmp->version.minor,tmp->comment);
            printf("1' \n");
            tmp=tmp->next;
        }
        printf("\n");
    }
}

/**
  * infos - affiche le commit qui a pour numero de version <major>-<minor> ou
  *         'Not here !!!' s'il n'y a pas de commit correspondant.
  *
  * @major: major du commit affiche
  * @minor: minor du commit affiche
  */
void infos(struct history *h, int major, unsigned long minor)
{
	/* TODO : Exercice 3 - Question 2 */
    if(h!=NULL) {
        struct commit *tmp = h->commit_list;
        unsigned long max = h->commit_count;

        int cpt=0;

        while(cpt<max){
            cpt++;
            if(tmp->version.minor==minor && tmp->version.major==major) {
                printf("%d: %2u.%lu: '%s' \n", cpt, tmp->version.major, tmp->version.minor, tmp->comment);
                return;
            }
            tmp=tmp->next;
        }
        printf("s'il n'y a pas de commit correspondant\n");
    }
}
