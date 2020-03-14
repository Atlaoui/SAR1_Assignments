//
// Created by adrien on 06/10/2019.
//

#include "HashMap.h"


















/*
 *
        V* get(const K & key){
            size_t h = std::hash<K>()(key);
            h = h % buckets.size();
            for(auto & ent : buckets[h]){
                if(ent.key == key){
                    return &(ent.value);
                }
            }
            return nullptr;
        }

        bool put(const K& key, const V& value){
            V * temp = get(key);
            if(temp == nullptr){
                size_t h = std::hash<K>()(key);
                h = h % buckets.size();
                Entry toAdd(key, value);
                buckets[h].push_front(toAdd);
                return false;
            }else{
                (*temp) = value;
                return true;
            }
        }


        size_t size() const {
            size_t res = 0;
            for (int i = 0; i < buckets.size(); ++i) {
                int t = 0;
                for (auto& b : buckets[i]) {
                    t++;
                }
                res += t;
            }
            return res;
        }


    }*/