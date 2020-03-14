#include<stdlib.h>
#include<stdio.h>
#include "list.h"
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
    h->commit_list=new_commit(0,0,"First !");
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
    /*si il n'y a que un element dans la liste */
    return(struct commit * ) list_last_entry(&h->commit_list->list,struct commit,list);
}

/**
  * display_history - affiche tout l'historique, i.e. l'ensemble des commits de
  *                   la liste
  *
  * @h: pointeur vers l'historique a afficher
  */
void display_history(struct history *h)
{
    if(h!=NULL && h->commit_list !=NULL) {
        printf("Historique de 'Tout une histoire' \n");
        struct list_head  *next;
        struct list_head *last = &h->commit_list->list;
        struct commit * tmp;
        int cpt = 0;
        printf("1' \n");
        list_for_each(next, last) {
            tmp =(struct commit * ) container_of(next,struct commit,list);
            printf("%d: %2u.%lu: '%s' \n", cpt, tmp->version.major, tmp->version.minor, tmp->comment);
            printf("1' \n");
            cpt++;
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
    if(h!=NULL) {
        struct list_head * next;
        struct list_head *last =&h->commit_list->list;
        struct commit * tmp;
        int cpt = 0;
        list_for_each(next ,last) {
             tmp =(struct commit * )  container_of(next,struct commit,list);
            if(tmp->version.minor==minor && tmp->version.major==major) {
                printf("%d: %2u.%lu: '%s' \n", cpt, tmp->version.major, tmp->version.minor, tmp->comment);
                return;
            }
        }
    }
        printf("s'il n'y a pas de commit correspondant\n");
}

void freeHistory(struct commit *from){
    struct list_head *last =&from->list;
    struct commit * tmp;
    struct commit *next;
    list_for_each_entry_safe( next,tmp, last, list){
        del_commit(next);
        //free(next->comment);
        free(next);
    }
}

struct commit *get(struct history *h ,int maj,int min){
    struct list_head *last =&h->commit_list->list;
    struct commit * tmp;
    struct list_head *next;
    list_for_each(next ,last) {
        tmp =(struct commit * )  container_of(next,struct commit,list);
        if(tmp->version.major==maj && tmp->version.minor==min) {
            return tmp;
        }
    }
    return NULL;
}