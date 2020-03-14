//
// Created by adrien on 06/10/2019.
//

#ifndef PR_HASHMAP_H
#define PR_HASHMAP_H
#include <vector>
#include <forward_list>
#include <algorithm>
#include <iostream>
#include<iterator>

using namespace std;

template <typename K,typename V>

    class HashMap {


    private:

        class Entry {
        public:
            const K key;
            V value;

            Entry(const K key, V value) : key(key), value(value) {}
        };

        vector<forward_list<Entry>> map;


    public:
        HashMap(size_t lenth) {
            for (int i = 0; i < lenth; ++i) {
                map.push_back(forward_list<Entry>());
            }
        }

        virtual ~HashMap() {

        }


        V *get(const K cle) {
            size_t pos = hash<K>()(cle);
            pos = pos % map.size();
            forward_list<Entry> elem = map[pos];
            for (Entry &n : elem) {
                if (n.key == cle)
                    return &n.value;
            }

            return nullptr;
        }

        bool put(const K cle, V valeur) {
            V *t = get(cle);
            if (t == nullptr) {
                size_t pos = std::hash<K>()(cle);
                pos = pos % map.size();
                Entry e(cle, valeur);
                map[pos].push_front(e);
                //std::cout << this->map[0] << endl;
                return true;
            }
            *t = *t + 1;
            return false;
        }


        size_t size() const {
            size_t cpt = 0;
            for (int i = 0; i < map.size(); ++i) {
                int t = 0;
                for (auto &b : map[i]) {
                    t++;
                }
                cpt += t;
            }
            return cpt;
        }

        void printAll() {

            for (int i = 0, len = map.size(); i < len; ++i) {
                cout << i + 1;
                for (Entry &e : map[i]) {
                    cout << e.key;
                    cout << e.value << endl;
                }
                cout << endl;
            }
        }




namespace pr {
        class iterator {
            iterator beg;
            iterator fin;
            iterator iterLateral;
            iterator(iterator b, iterator f) {
                beg= b;
                fin=f;
                iterLateral = *beg.begin();
            }

            /*V &operator++() {
                if(beg != nullptr){
                    return *iterLateral;
                }
            }*/

        };
}

        pr::iterator Iterator(){
        return pr::iterator(map.begin(),map.end());
    }



    };

#endif //PR_HASHMAP_H
