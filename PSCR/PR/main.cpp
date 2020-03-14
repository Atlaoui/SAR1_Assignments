#include <iostream>
#include <fstream>
#include <regex>
#include <chrono>
//#include "WordCountPair.h"
#include "HashMap.h"




int main () {
    using namespace std;
    using namespace std::chrono;

    //WordCountPair wc;
    //
    HashMap<string,int> map(300);


   //map.put("DD",12);
    //cout << map.get("DD") << endl;

    ifstream input = ifstream("/home/adrien/CLionProjects/PR/WAP.txt");

    auto start = steady_clock::now();
    cout << "Parsing War and Peace" << endl;

    size_t nombre_lu = 0;
    // prochain mot lu
    string word;
    // une regex qui reconnait les caractères anormaux (négation des lettres)
    regex re(R"([^a-zA-Z])");
    while (input >> word) {
        // élimine la ponctuation et les caractères spéciaux
        word = regex_replace(word, re, "");
        // passe en lowercase
        transform(word.begin(), word.end(), word.begin(), ::tolower);
      //  wc.add_word(word);
        map.put(word,1);
        // word est maintenant "tout propre"
      //  if (nombre_lu % 100 == 0)
            // on affiche un mot "propre" sur 100
       //     cout << nombre_lu << ": " << word << endl;
        nombre_lu++;
    }
    cout << "taille :";
    cout << map.size() << endl;
    cout << map.get("BLA") << endl;
    map.printAll();
    input.close();

    // cout << wc.count_word("war") << endl;

  //  wc.print_all();

    cout << "Finished Parsing War and Peace" << endl;

    auto end = steady_clock::now();
    cout << "Parsing took "
         << duration_cast<milliseconds>(end - start).count()
         << "ms.\n";
    return 0;
}