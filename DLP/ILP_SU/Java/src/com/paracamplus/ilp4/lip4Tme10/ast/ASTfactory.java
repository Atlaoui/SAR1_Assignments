package com.paracamplus.ilp4.lip4Tme10.ast;

import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp4.lip4Tme10.interfaces.IASTdefined;
import com.paracamplus.ilp4.lip4Tme10.interfaces.IASTexists;
import com.paracamplus.ilp4.lip4Tme10.interfaces.IASTfactory;

public class ASTfactory extends com.paracamplus.ilp4.ast.ASTfactory implements IASTfactory{

	@Override
	public IASTdefined newDefined(IASTvariable var) {
		// TODO Auto-generated method stub
		return new ASTdefined(var);
	}

	@Override
	public IASTexists newExists(IASTvariable var) {
		// TODO Auto-generated method stub
		return new ASTexists(var);
	}

}
