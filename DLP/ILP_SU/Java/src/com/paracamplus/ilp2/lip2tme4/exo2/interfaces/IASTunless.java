package com.paracamplus.ilp2.lip2tme4.exo2.interfaces;

import com.paracamplus.ilp1.interfaces.IASTexpression;

public interface IASTunless extends IASTexpression {
	IASTexpression getCondition();
	IASTexpression getBody();
}
