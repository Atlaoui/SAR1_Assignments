//
// Created by adrien on 06/10/2019.
//

#include "WordCountPair.h"



WordCountPair::WordCountPair() {
    // TODO Auto-generated constructor stub

}

WordCountPair::~WordCountPair() {
    // TODO Auto-generated destructor stub
}


int WordCountPair::count_word(string s){
    for(int i=0,len = wordV.size();i<len;i++){
        if(s.compare(wordV[i].first)==0){
            return wordV[i].second;
        }
    }
    return 0;
}

int WordCountPair::is_in(string s){
    for(int i=0,len = wordV.size();i<len;i++){
        if(s.compare(wordV[i].first)==0){
            return i;
        }
    }
    return -1;
}


void WordCountPair::add_word(string s){
    int index = is_in(s);
    if(index==-1){
        wordV.push_back(std::make_pair(s,1));
    }else{
        wordV[index].second=wordV[index].second+1;
    }
}

void WordCountPair::print_all(){
    for(int i=0,len = wordV.size();i<len;i++){
        std::cout << wordV[i].first << wordV[i].second << std::endl;
    }
}