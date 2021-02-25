package com.paracamplus.ilp3.ilp3Tme7.interfaces;

import com.paracamplus.ilp1.interfaces.IASTexpression;

public interface IASTfactory extends com.paracamplus.ilp3.interfaces.IASTfactory {
	IASTexpression newCostart(IASTexpression cour, IASTexpression[] arguments);
}
