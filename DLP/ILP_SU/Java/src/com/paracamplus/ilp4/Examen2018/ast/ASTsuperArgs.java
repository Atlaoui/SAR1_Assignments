package com.paracamplus.ilp4.Examen2018.ast;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp4.Examen2018.interfaces.IASTsuperArgs;
import com.paracamplus.ilp4.Examen2018.interfaces.IASTvisitor;

public class ASTsuperArgs extends ASTexpression implements IASTsuperArgs {

	
	private final IASTexpression args;

	public ASTsuperArgs(IASTexpression args ) {
		this.args  = args;
	}
	
	@Override
	public <Result, Data, Anomaly extends Throwable> Result accept(com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor,
			Data data) throws Anomaly {
		// TODO Auto-generated method stub
		return ((IASTvisitor<Result, Data, Anomaly>) visitor).visit(this, data);
	}

	@Override
	public IASTexpression getArgs() {
		// TODO Auto-generated method stub
		return args;
	}

}
