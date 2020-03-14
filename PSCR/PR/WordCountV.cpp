//
// Created by adrien on 06/10/2019.
//

#include "WordCountV.h"
using namespace std;
WordCountV::WordCountV() {
    // TODO Auto-generated constructor stub

}

WordCountV::~WordCountV() {
    // TODO Auto-generated destructor
}


bool WordCountV::is_in(string s){
    for(int i=0,len = wordV.size();i<len;i++){

        if(s.compare(wordV[i])==0){
            return false;
        }
    }
    return true;
}

void WordCountV::add_word(string s){
    if(is_in(s)){
        wcout++;
        wordV.push_back(s);
    }
}

int WordCountV::count_word(){
    return wcout;
}