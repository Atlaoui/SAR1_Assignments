package com.paracamplus.ilp2.lip2tme4.exo3.interfaces;

import com.paracamplus.ilp1.interfaces.IASTexpression;

public interface IASTfactory extends com.paracamplus.ilp2.interfaces.IASTfactory {
	IASTunless newUnless(IASTexpression condition, IASTexpression body);

}
