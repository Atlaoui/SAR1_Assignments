package com.paracamplus.ilp2.lip2tme4.exo3.interfaces;

import com.paracamplus.ilp1.interfaces.IASTexpression;

public interface INormalizationFactory extends com.paracamplus.ilp2.compiler.normalizer.INormalizationFactory {
	 IASTexpression newUnless(IASTexpression condition, IASTexpression body);
}
