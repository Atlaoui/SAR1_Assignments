/*Nombre de Site */
#define N 3

mtype = {actif, passif};
mtype = {ack, agr, mes, term,confTrm};
//https://www-master.ufr-info-p6.jussieu.fr/2018/Ligne-de-commande-Spin
chan canaux [N]= [N] of {mtype, int, byte};
   /* message = <type, val_horloge, emetteur> */

bool termine = 0;
   /* positionne a vrai quand la terminaison est detectee */


/*************************************************/
inline desactivation(id) {
   etat =passif;
   do
   ::unack== 0 ->horloge++;
   last = i;
   od
}
/*************************************************/

/* VOUS POUVEZ AJOUTER D'AUTRES INLINE */

inline my_broadcast_term(){
   i=0;
   idfin++;
   do
		::(i<N && i!=id)->canaux[i]!term(horloge,id);i++
		::(i == id)->i++
		::(i==N)->break;
	od
}

inline my_broadcast_detect(){
   i=0;
	do
		::(i<N && i!=id)->canaux[i]!confTrm(horloge,id);i++
		::(i == id)->i++
		::(i==N)->break;
	od
}



/* ********************* Gestion des message applicatif ************************** */
inline send(){
   
   unack++;
	canaux[(id+1)%N]!mes(N,id);
}

inline reciv_mes(){
	printf("%d : reciv msg\n",id);
   if
		::(etat==passif)->etat=actif
		::else->skip;
	fi;
	canaux[idemet]!ack(horloge,id)
}

/******************************************************/
inline reciv_ack(){
	printf("%d : reciv ack msg\n",id);
   unack--;
	if
		::(hrec > horloge) -> horloge = hrec;
		::else -> skip;
	fi;
	if
		::(unack == 0 && etat == passif) -> horloge++; nbagr=0; my_broadcast_term()
		::else->skip
	fi
}

inline reciv_term(){
	printf("%d : reciv term msg\n",id);
   if
		::(horloge<hrec)->horloge=hrec;
			if
				::(etat == passif && unack == 0) -> canaux[idemet]!agr(horloge,id)
				::else->skip
			fi
		::else->skip
	fi
}

inline reciv_arg(){
   nbagr++;
	printf("%d : reciv Arg\n",id);
   if
		::(nbagr==N-1)->my_broadcast_detect();is_end=true;
		::else->skip
	fi
}

inline is_state_changed(){
	printf("%d : check etat\n",id);
   etat = passif;
	if
		::(unack == 0) ->my_broadcast_term();
		::else->skip;
	fi
}

/*************************************************/

proctype un_site (byte id) {
   byte i, last;
   byte sdr, dest = (id+1)%N;
   int horloge, hrec;
   byte idemet; /*id de l'emeteur du message*/
   short unack = 0; /* le nombre de messages non acquittes */
   short nbagr = 0; /* nombre d'accords sur la terminaison recus */
   bool is_end; /* si fin */
   mtype mes_tp, etat = actif;
   mtype mestype; /*type du message recu */
   int idfin;
   horloge=0;
	unack=0;
	etat=actif;
	i=0;
	idfin=0;
	is_end=false;

   do
      ::(is_end!=true && etat==actif)->send()
      ::(etat!=passif)->is_state_changed()
      ::(idfin==N)->break
      :: ( empty(canaux[id]) && (etat == actif) ) ->   
            if    
               :: (1) ->   /* on peut arreter les actions locales */
                     desactivation(id);

               :: (1) ->   /* on peut envoyer un message. A COMPLETER */
                     send();
            fi
			
      :: nempty(canaux[id]) ->   /* on recoit un message. A COMPLETER */
        //{ack, agr, mes, term,confTrm};
        canaux[id]?mestype(hrec,idemet)->
        if
            ::(mestype == mes)->reciv_mes()
				::(mestype == term)->reciv_term()
				::(mestype == ack)->reciv_ack()
				::(mestype == agr)->reciv_arg()
				::(mestype == confTrm)->idfin++;
        fi
   od
}

/*************************************************/

init {

   byte i; 
   atomic {
      i=0;
      do
         :: i <N ->
               run un_site(i); 
               i++
         :: i == N -> break 
      od
   }
}