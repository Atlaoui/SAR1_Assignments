package com.paracamplus.ilp2.lip2tme4.exo3.normalizer;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.lip2tme4.exo3.ast.ASTunless;
import com.paracamplus.ilp2.lip2tme4.exo3.interfaces.INormalizationFactory;

public class NormalizationFactory extends com.paracamplus.ilp2.compiler.normalizer.NormalizationFactory
implements INormalizationFactory{

	@Override
	public IASTexpression newUnless(IASTexpression condition, IASTexpression body) {
		// TODO Auto-generated method stub
		return new ASTunless(condition,body);
	}
	
}
