//
// Created by adrien on 09/10/2019.
//

#ifndef PR_ITERGEN_H
#define PR_ITERGEN_H

#include<iterator>

using namespace std;
template<typename iterator, typename T>
iterator find (iterator begin, iterator end, const T& target){
    for (auto it=begin,e = end; it !=e; ++it) {
        if(*it==target)
            return it;
    }

    size_t count (iterator begin, iterator end){
        size_t cpt = 0;
        for (auto it=begin,e = end; it !=e; ++it) {
            cpt++;
        }
        return cpt;
    }

    size_t count_if_equal (iterator begin, iterator end, const T & val){
        size_t cpt = 0;
        for (auto it=begin,e = end; it !=e; ++it) {
            if(*it==val)
                cpt++;
        }
        return cpt;
    }

}

#endif //PR_ITERGEN_H
