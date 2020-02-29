node tramway
  (demande_porte: bool;
  porte_ouverte: bool;
  en_station: bool;
  attention_depart: bool)
returns
  (porte_ok: bool;
  fermer_porte: bool;
  ouvrir_porte: bool);

var
  V23_tic: bool;
  V24_tac: bool;
  V25_On_en_station: bool;
  V66_hz: int;
  V67_n: int;
  V68_first: bool;
  V69_state: bool;

let
  porte_ok = ((demande_porte and V25_On_en_station) and (not porte_ouverte));
  fermer_porte = ((not V23_tic) and (not V24_tac));
  ouvrir_porte = (porte_ouverte -> (if (en_station and demande_porte) then true 
  else (pre ouvrir_porte)));
  V23_tic = (false -> (V69_state and (pre V68_first)));
  V24_tac = (false -> ((not V69_state) and (pre V68_first)));
  V25_On_en_station = (false -> (if en_station then true else (if ((not V23_tic
  ) and (not V24_tac)) then false else (pre V25_On_en_station))));
  V66_hz = (0 -> (if (attention_depart or ((pre V66_hz) > 0)) then (5 - V67_n) 
  else (pre V66_hz)));
  V67_n = (0 -> (if (V23_tic or V24_tac) then ((pre V67_n) + 1) else 0));
  V68_first = (false -> (V66_hz > 0));
  V69_state = (true -> (if (pre V69_state) then false else true));
tel

