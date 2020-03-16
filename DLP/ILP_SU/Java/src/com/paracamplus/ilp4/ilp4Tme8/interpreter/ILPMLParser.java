package com.paracamplus.ilp4.ilp4Tme8.interpreter;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.paracamplus.ilp1.parser.ParseException;
import com.paracamplus.ilp4.ilp4Tme8.interfaces.IASTfactory;
import com.paracamplus.ilp4.interfaces.IASTprogram;

import antlr4.ILPMLgrammar4Tme8Lexer;
import antlr4.ILPMLgrammar4Tme8Parser;

public class ILPMLParser extends com.paracamplus.ilp4.parser.ilpml.ILPMLParser{

	public ILPMLParser(IASTfactory factory) {
		super(factory);
		
	}		
	@Override
    public IASTprogram getProgram() throws ParseException {
		try {
			ANTLRInputStream in = new ANTLRInputStream(input.getText());
			
			ILPMLgrammar4Tme8Lexer lexer = new ILPMLgrammar4Tme8Lexer(in);
			
			CommonTokenStream tokens =	new CommonTokenStream(lexer);
			
			ILPMLgrammar4Tme8Parser parser = new ILPMLgrammar4Tme8Parser(tokens);
			
			ILPMLgrammar4Tme8Parser.ProgContext tree = parser.prog();		
			
			ParseTreeWalker walker = new ParseTreeWalker();
			
			ILPMLListener extractor = new ILPMLListener((IASTfactory)factory);
			walker.walk(extractor, tree);	
			return tree.node;
		} catch (Exception e) {
			throw new ParseException(e);
		}
    }

}

