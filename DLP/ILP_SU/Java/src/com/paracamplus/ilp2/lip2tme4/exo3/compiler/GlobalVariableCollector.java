package com.paracamplus.ilp2.lip2tme4.exo3.compiler;

import java.util.Set;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.interfaces.IASTCglobalVariable;
import com.paracamplus.ilp2.lip2tme4.exo3.interfaces.IASTunless;
import com.paracamplus.ilp2.lip2tme4.exo3.interfaces.IASTvisitor;

public class GlobalVariableCollector extends com.paracamplus.ilp2.compiler.GlobalVariableCollector implements IASTvisitor<Set<IASTCglobalVariable>, 
Set<IASTCglobalVariable>, 
CompilationException> {



	@Override
	public Set<IASTCglobalVariable> visit(IASTunless iast, Set<IASTCglobalVariable> data) throws CompilationException {
		result = iast.getCondition().accept(this, result);
        result = iast.getBody().accept(this, result);
		return result;
	}
}