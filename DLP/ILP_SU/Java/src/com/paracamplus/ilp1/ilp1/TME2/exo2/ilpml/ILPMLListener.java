package com.paracamplus.ilp1.ilp1.TME2.exo2.ilpml;

import com.paracamplus.ilp1.interfaces.IASTfactory;

import antlr4.ILPMLgrammar1Parser.ConstFalseContext;
import antlr4.ILPMLgrammar1Parser.ConstFloatContext;
import antlr4.ILPMLgrammar1Parser.ConstIntegerContext;
import antlr4.ILPMLgrammar1Parser.ConstStringContext;
import antlr4.ILPMLgrammar1Parser.ConstTrueContext;

public class ILPMLListener extends com.paracamplus.ilp1.parser.ilpml.ILPMLListener{
	protected static int cpt;
	
	public ILPMLListener(IASTfactory factory) {
		super(factory);
		cpt = 0;
	}
	
	@Override 
	public void exitConstFloat(ConstFloatContext ctx) { 
		super.exitConstFloat(ctx);
		cpt++;
	}
	
	@Override 
	public void	exitConstInteger(ConstIntegerContext ctx) { 
		super.exitConstInteger(ctx);
		cpt++;
	}	
	@Override 
	public void exitConstTrue(ConstTrueContext ctx) {
		super.exitConstTrue(ctx);
		cpt++;
	}

	@Override 
	public void exitConstString(ConstStringContext ctx) { 
		super.exitConstString(ctx);
		cpt++;
	}

	@Override 
	public void exitConstFalse(ConstFalseContext ctx) {
		super.exitConstFalse(ctx);
		cpt++;
	}
	
	public int getCpt() {
		return cpt;
	}
}
