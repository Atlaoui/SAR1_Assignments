package com.paracamplus.ilp2.lip2tme4.exo3.compiler;

import java.util.Set;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.interfaces.IASTClocalVariable;
import com.paracamplus.ilp2.compiler.interfaces.IASTCprogram;
import com.paracamplus.ilp2.lip2tme4.exo3.interfaces.IASTunless;
import com.paracamplus.ilp2.lip2tme4.exo3.interfaces.IASTvisitor;

public class FreeVariableCollector extends com.paracamplus.ilp2.compiler.FreeVariableCollector 
implements IASTvisitor<Void, Set<IASTClocalVariable>, CompilationException>{

	public FreeVariableCollector(IASTCprogram program) {
		super(program);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Void visit(IASTunless iast, Set<IASTClocalVariable> data) throws CompilationException {
		iast.getCondition().accept(this, data);
        iast.getBody().accept(this, data);
		return null;
	}
	

}
