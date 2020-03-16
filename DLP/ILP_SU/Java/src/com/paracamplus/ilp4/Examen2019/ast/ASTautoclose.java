package com.paracamplus.ilp4.Examen2019.ast;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp4.Examen2019.interfaces.IASTautoclose;
import com.paracamplus.ilp4.Examen2019.interfaces.IASTvisitor;

public class ASTautoclose extends ASTexpression implements IASTautoclose {
	private final IASTexpression expr1;
	private final IASTexpression expr2;
	
	public ASTautoclose(IASTexpression expr1 , IASTexpression expr2) {
		this.expr1=expr1;
		this.expr2=expr2;
	}
	
	@Override
	public <Result, Data, Anomaly extends Throwable> Result accept(com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor,
			Data data) throws Anomaly {
		return ((IASTvisitor<Result, Data, Anomaly>) visitor).visit(this, data);
	}

	@Override
	public IASTexpression getExpr1() {
		// TODO Auto-generated method stub
		return expr1;
	}

	@Override
	public IASTexpression getExpr2() {
		// TODO Auto-generated method stub
		return expr2;
	}

}
