package com.paracamplus.ilp1.ilp1.TME1.ast;

import com.paracamplus.ilp1.ilp1.TME1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTexpression;

public class ASTfactory extends com.paracamplus.ilp1.ast.ASTfactory {
	@Override
	public IASTsequence newSequence(IASTexpression[] asts) {
        return new ASTsequence(asts);
    }
}
