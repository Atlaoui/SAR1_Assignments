#include<stdlib.h>
#include<stdio.h>
#include <stddef.h>
#include"commit.h"

static int nextId=0;
//redha.gouicen@lip6.fr
//julien.sopena@lip6.fr

/**
  * new_commit - alloue et initialise une structure commit correspondant aux
  *              parametres
  *
  * @major: numero de version majeure
  * @minor: numero de version mineure
  * @comment: pointeur vers une chaine de caracteres contenant un commentaire
  *
  * @return: retourne un pointeur vers la structure allouee et initialisee
  */
struct commit *new_commit(unsigned short major, unsigned long minor,
			  char *comment)
{
	/* TODO : Exercice 3 - Question 2 */
    struct commit *a=malloc(sizeof(struct commit));
    struct version *v=malloc(sizeof(struct version));
    v->minor=minor;
    v->major=major;
    a->comment=comment;
    a->version=*v;
    a->id=nextId++;
    a->prev=NULL;
    a->next=NULL;
    return a;
}

/**
  * insert_commit - insere sans le modifier un commit dans la liste doublement
  *                 chainee
  *
  * @from: commit qui deviendra le predecesseur du commit insere
  * @new: commit a inserer - seuls ses champs next et prev seront modifies
  *
  * @return: retourne un pointeur vers la structure inseree
  */
static struct commit *insert_commit(struct commit *from, struct commit *new)
{
	/* TODO : Exercice 3 - Question 3 */
    if(from==NULL) {
        from = new;
        new->next=new;
        new->prev=new;
        return from;
    }

    new->next=from->next;
    if(from->next !=NULL)
        from->next->prev=new;
    from->next=new;
    new->prev=from;

	return from;
}

/**
  * add_minor_commit - genere et insere un commit correspondant a une version
  *                    mineure
  *
  * @from: commit qui deviendra le predecesseur du commit insere
  * @comment: commentaire du commit
  *
  * @return: retourne un pointeur vers la structure inseree
  */
struct commit *add_minor_commit(struct commit *from, char *comment)
{
	/* TODO : Exercice 3 - Question 3 */

	if(from == NULL){
        struct commit * new = new_commit(1,0,comment);
        return insert_commit(from,new);
	}
    struct commit * new = new_commit(from->version.major,from->version.minor+1,comment);
    return insert_commit(from,new);
}

/**
	* add_major_commit - genere et insere un commit correspondant a une version
  *                    majeure
  *
  * @from: commit qui deviendra le predecesseur du commit insere
  * @comment: commentaire du commit
  *
  * @return: retourne un pointeur vers la structure inseree
  */
struct commit *add_major_commit(struct commit *from, char *comment)
{
	/* TODO : Exercice 3 - Question 3 */
    if(from == NULL){
        struct commit * new = new_commit(1,0,comment);
        return insert_commit(from,new);
    }
    struct commit * new = new_commit(from->version.major+1,0,comment);
    return insert_commit(from,new);
}

/**
  * del_commit - extrait le commit de l'historique
  *
  * @victim: commit qui sera sorti de la liste doublement chainee
  *
  * @return: retourne un pointeur vers la structure extraite
  */
struct commit *del_commit(struct commit *victim)
{
	/* TODO : Exercice 3 - Question 5 */
    victim->next->prev=victim->prev;
    victim->prev->next=victim->next;
	return victim;
}

/**
  * display_commit - affiche un commit : "2:  0-2 (stable) 'Work 2'"
  *
  * @c: commit qui sera affiche
  */

void display_commit(struct commit *c)
{
    /* TODO : Exercice 3 - Question 4 */
    if(c==NULL)
        return;
    printf("%lu: %2u.%lu (%s) '%s' \n",c->id,c->version.major,c->version.minor, is_unstable_bis(&c->version) ? "(unstable)" : "(stable)",c->comment);

}

void display_al_commit(struct commit *c)
{
	/* TODO : Exercice 3 - Question 4 */
	if(c==NULL)
	    return;

	struct commit * tete = c;
    struct commit * tmp = c;
    do{
        printf("%lu: %2u.%lu (%s) '%s'\n",tmp->id,tmp->version.major,tmp->version.minor, is_unstable_bis(&tmp->version) ? "(unstable)" : "(stable)",tmp->comment);
        tmp=tmp->next;
    }while(tmp !=NULL && tete!=tmp);
}



/**
  * commitOf - retourne le commit qui contient la version passee en parametre
  *
  * @version: pointeur vers la structure version dont on recherche le commit
  *
  * @return: un pointeur vers la structure commit qui contient 'version'
  *
  * Note:      cette fonction continue de fonctionner meme si l'on modifie
  *            l'ordre et le nombre des champs de la structure commit.
  */
struct commit *commitOf(struct version *version)
{
	/* TODO : Exercice 2 - Question 2 */
    ;

	return (struct commit * ) version-offsetof(struct commit ,version);
	return (struct commit *) ((void *) version - (void *) & ((struct commit *) 0 )->version);
}
