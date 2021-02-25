package com.paracamplus.ilp2.lip2tme6.interpreteur;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.normalizer.INormalizationEnvironment;
import com.paracamplus.ilp1.compiler.normalizer.NoSuchLocalVariableException;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp2.interfaces.IASTfactory;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
public class RenameTransform extends CopyTransform<INormalizationEnvironment>{
	private static int cptvar = 0 ;
	
	public RenameTransform(IASTfactory fact) {
		super(fact);
	}
	

	
	
	@Override
	public IASTexpression visit(IASTblock iast, INormalizationEnvironment lenv) throws CompilationException {
		IASTbinding[] bindings = new IASTbinding[iast.getBindings().length];		
		for (int i = 0 ; i < iast.getBindings().length; ++i) {
			IASTvariable v = iast.getBindings()[i].getVariable();
			IASTvariable var = super.fact.newVariable(v.getName()+"_"+cptvar++);

			bindings[i] = super.fact.newBinding(var, iast.getBindings()[i].getInitialisation().accept(this, lenv));
			lenv = lenv.extend(v, var);
		}
		return super.fact.newBlock(iast.getBindings(), iast.getBody().accept(this, lenv));
	}

	
	
	@Override
	public IASTexpression visit(IASTvariable iast, INormalizationEnvironment lenv) throws CompilationException {
		try {
		return lenv.renaming(iast);
		}catch(NoSuchLocalVariableException e) {
		return iast;
		}
	}
	
	
	
	public IASTfunctionDefinition visit(IASTfunctionDefinition iast, INormalizationEnvironment lexenv) throws CompilationException {
		IASTvariable[] newVariables = new IASTvariable[iast.getVariables().length];
	
		for (int i = 0 ; i < iast.getVariables().length; ++i) {
			IASTvariable v = iast.getVariables()[i];
			IASTvariable var = super.fact.newVariable(v.getName()+"_"+cptvar++);

			newVariables[i] = var;
			lexenv = lexenv.extend(v, var);
		}
		return fact.newFunctionDefinition(iast.getFunctionVariable(), newVariables,iast.getBody().accept(this, lexenv));
		
	}

}
