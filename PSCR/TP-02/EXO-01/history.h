#ifndef HISTORY_H
#define HISTORY_H

#include"commit.h"

struct history {
	unsigned long commit_count;
	char *name;
	struct commit *commit_list;
};

struct history *new_history(char *name);

struct commit *last_commit(struct history *h);

struct commit *get(struct history *h , int maj, int min);

void display_history(struct history *from);

void infos(struct history *h, int major, unsigned long minor);

void freeHistory(struct commit *from);

#endif
