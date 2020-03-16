package com.paracamplus.ilp4.ilp4Tme8.interpreter;

import java.util.List;
import java.util.Vector;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp4.ilp4Tme8.interfaces.IASThasProperty;
import com.paracamplus.ilp4.ilp4Tme8.interfaces.IASTreadProperty;
import com.paracamplus.ilp4.ilp4Tme8.interfaces.IASTvisitor;
import com.paracamplus.ilp4.ilp4Tme8.interfaces.IASTwriteProperty;
import com.paracamplus.ilp4.interfaces.IASTinstantiation;
import com.paracamplus.ilp4.interpreter.interfaces.IClass;
import com.paracamplus.ilp4.interpreter.interfaces.IClassEnvironment;

public class Interpreter extends com.paracamplus.ilp4.interpreter.Interpreter
implements IASTvisitor<Object, ILexicalEnvironment, EvaluationException>  {

	public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment, IOperatorEnvironment operatorEnvironment,
			IClassEnvironment classEnvironment) {
		super(globalVariableEnvironment, operatorEnvironment, classEnvironment);
	}


	@Override
	public Object visit(IASTinstantiation iast, ILexicalEnvironment lexenv) throws EvaluationException {
		IClass clazz = getClassEnvironment().getILP9Class(iast.getClassName());
		List<Object> args = new Vector<Object>();
		for ( IASTexpression arg : iast.getArguments() ) {
			Object value = arg.accept(this, lexenv);
			args.add(value);
		}
		return new ILP10Instance(clazz, args.toArray());
	}


	@Override
	public Object visit(IASTreadProperty iast, ILexicalEnvironment data) throws EvaluationException {
		Object ret = iast.getProperty().accept(this, data);
		if (!(ret instanceof String)) 
			throw new EvaluationException("ERROR TYPE");
		String prop = (String) ret;

		Object ob = iast.getTarget().accept(this, data);
		if(ob instanceof ILP10Instance) {
			ILP10Instance inst = (ILP10Instance) ob;
			return inst.read(prop);
		}

		return null;
	}

	@Override
	public Object visit(IASTwriteProperty iast, ILexicalEnvironment data) throws EvaluationException {
		Object ret = iast.getProperty().accept(this, data);
		if (!(ret instanceof String)) 
			throw new EvaluationException("ERROR TYPE");
		String prop = (String) ret;
		Object ob = iast.getTarget().accept(this, data);

		if(ob instanceof ILP10Instance) {
			ILP10Instance inst = (ILP10Instance) ob;
			return inst.write(prop, iast.getValue().accept(this, data));
		}

		return null;
	}

	@Override
	public Object visit(IASThasProperty iast, ILexicalEnvironment data) throws EvaluationException {
		Object ret = iast.getProperty().accept(this, data);
		if (!(ret instanceof String)) 
			throw new EvaluationException("ERROR TYPE");
		String prop = (String) ret;
		Object ob = iast.getTarget().accept(this, data);
		if(ob instanceof ILP10Instance) {
			ILP10Instance inst = (ILP10Instance) ob;
			return inst.hasPropreties(prop);
		}
		return null;
	}

}
