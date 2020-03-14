#include<stdlib.h>
#include<stdio.h>

#include"history.h"

int main(int argc, char const *argv[])
{
	struct history *history = new_history("Tout une histoire");
	struct commit *tmp, *victim, *last , *test;

    display_commit(last_commit(history));


    display_history(history);
    tmp = add_minor_commit(last_commit(history), "Work 1");

    display_commit(tmp);
    tmp = add_minor_commit(tmp, "Work 2");
	victim = add_minor_commit(tmp, "Work 3");

	last = add_minor_commit(victim, "Work 4");

	display_history(history);

	tmp = add_major_commit(last, "Realse 1");
	tmp = add_minor_commit(tmp, "Work 1");
	tmp = add_minor_commit(tmp, "Work 2");
	tmp = add_major_commit(tmp, "Realse 2");
	tmp = add_minor_commit(tmp, "Work 1");
    printf("ixi");
	tmp->ops.display(tmp);
	display_history(history);
	printf("la taille de histoire %lu '\n'",history->commit_count);

	add_minor_commit(last, "Oversight !!!");
	display_history(history);

    test = get(history,1,0);
    test = test->ops.extract(test);
    printf("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA \n");
    display_all(test);

    printf("Recherche du commit 1.2 :   ");
	infos(history, 1, 2);
	printf("\n");

	printf("Recherche du commit 1.7 :   ");
	infos(history, 1, 7);
	printf("\n");

	printf("Recherche du commit 4.2 :   ");
	infos(history, 4, 2);
	printf("\n");

	freeHistory(history->commit_list);
	free(history->commit_list);
	free(history);

	return 0;
}
