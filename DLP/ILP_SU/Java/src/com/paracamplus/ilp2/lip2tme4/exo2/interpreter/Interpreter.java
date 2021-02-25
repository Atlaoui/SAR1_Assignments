package com.paracamplus.ilp2.lip2tme4.exo2.interpreter;

import java.util.List;
import java.util.Vector;

import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp1.interfaces.IASTbinaryOperation;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTboolean;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTfloat;
import com.paracamplus.ilp1.interfaces.IASTinteger;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp1.interfaces.IASToperator;
import com.paracamplus.ilp1.interfaces.IASTprogram;
import com.paracamplus.ilp1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTstring;
import com.paracamplus.ilp1.interfaces.IASTunaryOperation;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperator;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.Invocable;
import com.paracamplus.ilp2.interfaces.IASTassignment;
import com.paracamplus.ilp2.interfaces.IASTloop;
import com.paracamplus.ilp2.lip2tme4.exo2.interfaces.IASTunless;
import com.paracamplus.ilp2.lip2tme4.exo2.interfaces.IASTvisitor;

public class Interpreter extends com.paracamplus.ilp1.interpreter.Interpreter implements IASTvisitor<Object, ILexicalEnvironment, EvaluationException> {

	public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment, IOperatorEnvironment operatorEnvironment) {
		super(globalVariableEnvironment, operatorEnvironment);
		// TODO Auto-generated constructor stub
	}

	public Object visit(IASTprogram iast, ILexicalEnvironment lexenv) 
			throws EvaluationException {
		try {
			return iast.getBody().accept(this, lexenv);
		} catch (Exception exc) {
			return exc;
		}
	}

	// 

	private static Object whatever = "whatever";

	@Override
	public Object visit(IASTalternative iast, ILexicalEnvironment lexenv) 
			throws EvaluationException {
		Object c = iast.getCondition().accept(this, lexenv);
		if ( c != null && c instanceof Boolean ) {
			Boolean b = (Boolean) c;
			if ( b.booleanValue() ) {
				return iast.getConsequence().accept(this, lexenv);
			} else if ( iast.isTernary() ) {
				return iast.getAlternant().accept(this, lexenv);                
			} else {
				return whatever;
			}
		} else {
			return iast.getConsequence().accept(this, lexenv);
		}
	}



	@Override
	public Object visit(IASTunaryOperation iast, ILexicalEnvironment lexenv) 
			throws EvaluationException {
		Object operand = iast.getOperand().accept(this, lexenv);
		IASToperator operator = iast.getOperator();
		IOperator op = getOperatorEnvironment().getUnaryOperator(operator);
		return op.apply(operand);
	}

	@Override
	public Object visit(IASTbinaryOperation iast, ILexicalEnvironment lexenv) 
			throws EvaluationException {
		Object leftOperand = iast.getLeftOperand().accept(this, lexenv);
		Object rightOperand = iast.getRightOperand().accept(this, lexenv);
		IASToperator operator = iast.getOperator();
		IOperator op = getOperatorEnvironment().getBinaryOperator(operator);
		return op.apply(leftOperand, rightOperand);
	}

	@Override
	public Object visit(IASTsequence iast, ILexicalEnvironment lexenv) 
			throws EvaluationException {
		IASTexpression[] expressions = iast.getExpressions();
		Object lastValue = null;
		for ( IASTexpression e : expressions ) {
			lastValue = e.accept(this, lexenv);
		}
		return lastValue;
	}

	@Override
	public Object visit(IASTblock iast, ILexicalEnvironment lexenv) 
			throws EvaluationException {
		ILexicalEnvironment lexenv2 = lexenv;
		for ( IASTbinding binding : iast.getBindings() ) {
			Object initialisation = 
					binding.getInitialisation().accept(this, lexenv);
			lexenv2 = lexenv2.extend(binding.getVariable(), initialisation);
		}
		return iast.getBody().accept(this, lexenv2);
	}

	@Override
	public Object visit(IASTboolean iast, ILexicalEnvironment lexenv) 
			throws EvaluationException {
		return iast.getValue();
	}

	@Override
	public Object visit(IASTinteger iast, ILexicalEnvironment lexenv) 
			throws EvaluationException {
		return iast.getValue();
	}

	@Override
	public Object visit(IASTfloat iast, ILexicalEnvironment lexenv) 
			throws EvaluationException {
		return iast.getValue();
	}

	@Override
	public Object visit(IASTstring iast, ILexicalEnvironment lexenv) 
			throws EvaluationException {
		return iast.getValue();
	}

	@Override
	public Object visit(IASTvariable iast, ILexicalEnvironment lexenv) 
			throws EvaluationException {
		try {
			return lexenv.getValue(iast);
		} catch (EvaluationException exc) {
			return getGlobalVariableEnvironment()
					.getGlobalVariableValue(iast.getName());
		}
	}

	@Override
	public Object visit(IASTinvocation iast, ILexicalEnvironment lexenv) 
			throws EvaluationException {
		Object function = iast.getFunction().accept(this, lexenv);
		if ( function instanceof Invocable ) {
			Invocable f = (Invocable)function;
			List<Object> args = new Vector<Object>();
			for ( IASTexpression arg : iast.getArguments() ) {
				Object value = arg.accept(this, lexenv);
				args.add(value);
			}
			return f.apply(this, args.toArray());
		} else {
			String msg = "Cannot apply " + function;
			throw new EvaluationException(msg);
		}
	}

	@Override
	public Object visit(IASTassignment iast, ILexicalEnvironment lexenv) 
			throws EvaluationException {
		IASTvariable variable = iast.getVariable();
		Object value = iast.getExpression().accept(this, lexenv);
		try {
			lexenv.update(variable, value);
		} catch (EvaluationException exc) {
			getGlobalVariableEnvironment()
			.updateGlobalVariableValue(variable.getName(), value);
		}
		return value;
	}

	@Override
	public Object visit(IASTloop iast, ILexicalEnvironment lexenv) 
			throws EvaluationException {
		while ( true ) {
			Object condition = iast.getCondition().accept(this, lexenv);
			if ( condition instanceof Boolean ) {
				Boolean c = (Boolean) condition;
				if ( ! c ) {
					break;
				}
			}
			iast.getBody().accept(this, lexenv);
		}
		return Boolean.FALSE;
	}
	@Override
	public Object visit(IASTunless iast, ILexicalEnvironment data) throws EvaluationException {
		Object c = iast.getCondition().accept(this, data);
		if ( c != null && c instanceof Boolean ) {
			Boolean b = (Boolean) c;
			if (! b.booleanValue() ) {
				return iast.getBody().accept(this, data);
			}
			else
				return null;
		}
		return null;
	}

}
