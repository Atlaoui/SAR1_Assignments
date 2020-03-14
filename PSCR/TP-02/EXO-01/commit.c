#include<stdlib.h>
#include<stdio.h>
#include <stddef.h>
#include"commit.h"
//https://computingforgeeks.com/complete-installation-of-kvmqemu-and-virt-manager-on-arch-linux-and-manjaro/

static int nextId=0;

static struct commit * papa=NULL;

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
struct commit *new_commit(unsigned short major, unsigned long minor, char *comment)
{
    struct commit *a=malloc(sizeof(struct commit));
    a->version.minor=minor;
    a->version.major=major;
    a->comment=comment;
    a->id=nextId++;
    a->major_parent=papa;
    if(minor==0){
        a->ops.display=display_major_commit;
        a->ops.extract=extract_minor;
    } else{
        a->ops.display= display_commit;
        a->ops.extract=extract_major;
    }
    INIT_LIST_HEAD(&a->major_list);
    INIT_LIST_HEAD(&a->list);
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
    list_add_tail(&new->list,&from->list);
	return new;
}

static void insert_major_commit(struct commit *from, struct commit *new){
    list_add_tail(&new->major_list,&from->major_list);
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

	if(from->id == 0){
        struct commit * new = new_commit(1,0,comment);
        return insert_commit(from,new);
	}
    struct commit * new = new_commit(from->version.major,from->version.minor+1,comment);
	new->major_parent=papa;
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
    if(from == NULL){
        struct commit * new = new_commit(1,0,comment);
        papa=new;
        insert_major_commit(from,new);
        return insert_commit(from,new);
    }
    struct commit * new = new_commit(from->version.major+1,0,comment);
    papa=new;
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
    list_del(&victim->list);
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
void display_major_commit(struct commit *c){
    if(c==NULL)
        return;
    printf("Major :%lu: %2u.%lu (%s) '%s' \n",c->id,c->version.major,c->version.minor, is_unstable_bis(&c->version) ? "(unstable)" : "(stable)",c->comment);

}



struct commit * extract_minor (struct commit *c){
    return del_commit(c);
}


struct commit * extract_major (struct commit *c){
    struct list_head *last =&c->list;
    struct commit * tmp;
    struct commit *next;
    struct commit * toExtract = new_commit(0,0,NULL);
    list_for_each_entry_safe( next,tmp, last, list){
        if(next->version.major==c->version.major){
            del_commit(next);
            toExtract=insert_commit(toExtract,next);
        }
    }
    list_del(&c->major_list);
    return  toExtract;

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
    //return (struct commit * ) version-offsetof(struct commit ,version);
	return (struct commit *) ((void *) version - (void *) & ((struct commit *) 0 )->version);
}

void display_all(struct commit * from ){
    struct list_head * next;
    struct list_head *last =&from->list;
    struct commit * tmp;

    list_for_each(next ,last) {
        tmp =(struct commit * )  container_of(next,struct commit,list);
        display_commit(tmp);
    }
}
