node cde_clignot_cor
  (reset: bool;
  up: bool;
  down: bool)
returns
  (left: bool;
  right: bool);

var
  V13_state: int;

let
  assert (not (left and right));
  left = (V13_state = 1);
  right = (V13_state = -1);
  V13_state = (0 -> (if reset then 0 else (if (up and ((pre V13_state) < 1)) 
  then ((pre V13_state) + 1) else (if (down and ((pre V13_state) > -1)) then (
  (pre V13_state) - 1) else (pre V13_state)))));
tel

