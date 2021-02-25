package com.paracamplus.ilp2.lip2tme4.exo3.normalizer;


import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.normalizer.INormalizationEnvironment;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.lip2tme4.exo3.interfaces.IASTunless;
import com.paracamplus.ilp2.lip2tme4.exo3.interfaces.INormalizationFactory;

public class Normalizer extends com.paracamplus.ilp2.compiler.normalizer.Normalizer
implements com.paracamplus.ilp2.lip2tme4.exo3.interfaces.IASTvisitor<IASTexpression, INormalizationEnvironment, CompilationException>{

	public Normalizer(INormalizationFactory factory) {
		super(factory);		
	}

	@Override
	public IASTexpression visit(IASTunless iast, INormalizationEnvironment data) throws CompilationException {
		return ((INormalizationFactory)factory).newUnless(iast.getCondition(), iast.getBody());
	}
}
