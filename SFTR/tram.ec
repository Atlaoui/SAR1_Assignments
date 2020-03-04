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
  V108_hz: int;
  V109_n: int;
  V110_first: bool;
  V111_state: bool;
  V121_scrutating: bool;
  V122_final: bool;

let
  assert (V122_final and depart);
  porte_ok = (depart_imminent and (if ((not porte_demandee) and (not 
  porte_ouverte)) then true else porte_ouverte));
  fermer_porte = (false -> ((depart_imminent and porte_ouverte) and 
  porte_demandee));
  ouvrir_porte = ((porte_demandee and en_station) and (not porte_ouverte));
  depart = (false -> ((not en_station) and (pre en_station)));
  accepter_demande = (false -> ((demande_porte and (depart or (not 
  attention_depart))) and en_station));
  porte_demandee = (demande_porte and accepter_demande);
  depart_imminent = (V34_tic or V35_tac);
  V34_tic = (false -> (V111_state and (pre V110_first)));
  V35_tac = (false -> ((not V111_state) and (pre V110_first)));
  V108_hz = (0 -> (if (attention_depart or ((pre V108_hz) > 0)) then (5 - 
  V109_n) else (pre V108_hz)));
  V109_n = (0 -> (if (V34_tic or V35_tac) then ((pre V109_n) + 1) else 0));
  V110_first = (false -> (V108_hz > 0));
  V111_state = (true -> (if (pre V111_state) then false else true));
  V121_scrutating = (false -> ((attention_depart or (pre V121_scrutating)) and 
  (not depart)));
  V122_final = (false -> ((V121_scrutating and porte_ok) or (pre V122_final)));
tel

