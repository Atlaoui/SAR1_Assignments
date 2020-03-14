//
// Created by adrien on 06/10/2019.
//

#ifndef PR_WORDCOUNTPAIR_H
#define PR_WORDCOUNTPAIR_H
#include <utility>
#include <vector>
#include <string>
#include <iostream>
#include <fstream>
using namespace std;
class WordCountPair {
private:
    vector<pair<string,int>>wordV;
    int is_in(string s);
public:
    WordCountPair();
    virtual ~WordCountPair();
    int count_word(string s);
    void add_word(string s);
    void print_all();
};

#endif //PR_WORDCOUNTPAIR_H
