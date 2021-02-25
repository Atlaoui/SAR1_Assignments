package com.paracamplus.ilp1.ilp1.TME2.exo2.ast;

import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp1.interfaces.IASTbinaryOperation;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp1.interfaces.IASTboolean;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTfloat;
import com.paracamplus.ilp1.interfaces.IASTinteger;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp1.interfaces.IASTprogram;
import com.paracamplus.ilp1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTstring;
import com.paracamplus.ilp1.interfaces.IASTunaryOperation;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interfaces.IASTvisitor;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;

public class CountConstant implements  IASTvisitor<Integer, Object, EvaluationException>{
	protected IGlobalVariableEnvironment globalVariableEnvironment;
	protected IOperatorEnvironment operatorEnvironment;

	public CountConstant (IGlobalVariableEnvironment globalVariableEnvironment,
			IOperatorEnvironment operatorEnvironment ) {
		this.globalVariableEnvironment = globalVariableEnvironment;
		this.operatorEnvironment = operatorEnvironment;
	}
	
	public IOperatorEnvironment getOperatorEnvironment() {
		return operatorEnvironment;
	}

	public IGlobalVariableEnvironment getGlobalVariableEnvironment() {
		return globalVariableEnvironment;
	}
	
	  public Integer visit(IASTprogram iast, ILexicalEnvironment lexenv) 
	            throws EvaluationException {
	        try {
	            return iast.getBody().accept(this, lexenv);
	        } catch (Exception exc) {
	            return 0;
	        }
	    }

	@Override
	public Integer visit(IASTalternative iast, Object data) throws EvaluationException {
		int condition = iast.getCondition().accept(this, data);
		int consequence = iast.getConsequence().accept(this, data);
		int alternant = 0;
		if ( iast.isTernary() ) {
			alternant = iast.getAlternant().accept(this, data); 
		}
		return condition + consequence + alternant;
	}

	@Override
	public Integer visit(IASTbinaryOperation iast, Object data) throws EvaluationException {
		return iast.getLeftOperand().accept(this, data)+iast.getRightOperand().accept(this, data);
	}

	@Override
	public Integer visit(IASTblock iast, Object data) throws EvaluationException {
		int initialisation=0;
		int body=0;
		IASTbinding[] tab = iast.getBindings();
		for(int i=0,len = iast.getBindings().length;i<len;i++) {
			initialisation+= tab[i].getInitialisation().accept(this, data);
		}
		body = iast.getBody().accept(this, data);
		return initialisation + body;
	}

	@Override
	public Integer visit(IASTboolean iast, Object data) throws EvaluationException {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Integer visit(IASTfloat iast, Object data) throws EvaluationException {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Integer visit(IASTinteger iast, Object data) throws EvaluationException {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Integer visit(IASTinvocation iast, Object data) throws EvaluationException {
		int arguments=0;
		for ( IASTexpression arg : iast.getArguments() ) {
			arguments += arg.accept(this, data);
		}
		return arguments+iast.getFunction().accept(this, data);
	}

	@Override
	public Integer visit(IASTsequence iast, Object data) throws EvaluationException {
		int ret =0;
		for(int i= 0 ,len = iast.getExpressions().length;i<len;i++)
			ret += iast.getExpressions()[i].accept(this, data);
		return ret;
	}

	@Override
	public Integer visit(IASTstring iast, Object data) throws EvaluationException {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Integer visit(IASTunaryOperation iast, Object data) throws EvaluationException {

		return iast.getOperand().accept(this, data);
	}

	@Override
	public Integer visit(IASTvariable iast, Object data) throws EvaluationException {
		// TODO Auto-generated method stub
		return 1;
	}

}
