node tram
  (demande_porte: bool;
  porte_ouverte: bool;
  en_station: bool;
  attention_depart: bool)
returns
  (porte_ok: bool;
  fermer_porte: bool;
  ouvrir_porte: bool;
  depart: bool;
  accepter_demande: bool;
  porte_demandee: bool;
  depart_imminent: bool);

var
  V34_tic: bool;
  V35_tac: bool;
  V103_hz: int;
  V104_n: int;
  V105_first: bool;
  V106_state: bool;

let
  porte_ok = (false -> ((pre depart_imminent) and (if ((not porte_demandee) and 
  (not porte_ouverte)) then true else (not porte_ouverte))));
  fermer_porte = (false -> (depart_imminent and porte_ouverte));
  ouvrir_porte = ((demande_porte and en_station) and (not porte_ouverte));
  depart = (false -> (((not en_station) and (pre en_station)) and (not 
  depart_imminent)));
  accepter_demande = ((not en_station) and (not attention_depart));
  porte_demandee = (demande_porte and accepter_demande);
  depart_imminent = (V34_tic or V35_tac);
  V34_tic = (false -> (V106_state and (pre V105_first)));
  V35_tac = (false -> ((not V106_state) and (pre V105_first)));
  V103_hz = (0 -> (if (attention_depart or ((pre V103_hz) > 0)) then (5 - 
  V104_n) else (pre V103_hz)));
  V104_n = (0 -> (if (V34_tic or V35_tac) then ((pre V104_n) + 1) else 0));
  V105_first = (false -> (V103_hz > 0));
  V106_state = (true -> (if (pre V106_state) then false else true));
tel

