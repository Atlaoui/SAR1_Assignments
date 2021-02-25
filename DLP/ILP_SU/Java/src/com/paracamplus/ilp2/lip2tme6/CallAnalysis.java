package com.paracamplus.ilp2.lip2tme6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp2.interfaces.IASTfactory;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp2.lip2tme6.interpreteur.CopyTransform;

public class CallAnalysis extends CopyTransform<Set<String>>{

	private Map<String,Set<String>> tabl_func ;
	
	public CallAnalysis(IASTfactory fact) {
		super(fact);
		tabl_func = new HashMap<String, Set<String>>();
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean isRecursive(IASTvariable f) {
		
		return true;
	}
	
	
	@Override
	public IASTprogram visit(IASTprogram iast, Set<String> data) throws EvaluationException, CompilationException {
		for(int i=0;i<iast.getFunctionDefinitions().length;i++) {
			tabl_func.put(iast.getFunctionDefinitions()[i].getName(), new HashSet<>());
			visit(iast.getFunctionDefinitions()[i], tabl_func.get(iast.getFunctionDefinitions()[i].getName()));
		}
		return null;
    }
	
	private void visit(IASTfunctionDefinition iast, Set<String> data) throws CompilationException {
		iast.getBody().accept(this, data);
		
		for (IASTvariable v : iast.getVariables()) {
			data.remove(v.getName());
		}
	}


	@Override
	public IASTexpression visit(IASTinvocation iast, Set<String> data) throws CompilationException {
		
		return null;
	}
	
	
}
