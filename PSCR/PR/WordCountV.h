//
// Created by adrien on 06/10/2019.
//

#ifndef PR_WORDCOUNTV_H
#define PR_WORDCOUNTV_H
#include <vector>
#include <string>
using namespace std;
class WordCountV {
private:
    int wcout=0;
    vector<string> wordV;
    bool is_in(string s);
public:
    WordCountV();
    ~WordCountV();

    void add_word(string s);
    int count_word();

};
#endif //PR_WORDCOUNTV_H
