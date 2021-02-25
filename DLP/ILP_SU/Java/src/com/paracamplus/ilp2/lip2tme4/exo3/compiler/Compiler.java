package com.paracamplus.ilp2.lip2tme4.exo3.compiler;

import com.paracamplus.ilp1.compiler.AssignDestination;
import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.compiler.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp2.lip2tme4.exo2.interfaces.IASTunless;
import com.paracamplus.ilp2.lip2tme4.exo2.interfaces.IASTvisitor;

public class Compiler extends com.paracamplus.ilp2.compiler.Compiler implements IASTvisitor<Void, Compiler.Context, CompilationException>{

    public Compiler(IOperatorEnvironment ioe, IGlobalVariableEnvironment igve) {
		super(ioe, igve);
		
	}


    
	public Void visit(IASTunless iast, Context context)
            throws CompilationException {
		IASTvariable tmp1 = context.newTemporaryVariable();
		emit("{ \n");
		emit(" ILP_Object " + tmp1.getMangledName() + "; \n");
		Context c = context.redirect(new AssignDestination(tmp1));
		iast.getCondition().accept(this, c); /* on met le résultat de la compilation de la condition dans la var tmp1 
		(le nom de tme1 en C est tmp1.getmangledname*/
		emit(" if ( ILP_isEquivalentToTrue(");
		emit(tmp1.getMangledName());
		emit(")) {} \n"); //si la condition est vrai on fait rien
		emit(" else { \n");
		iast.getBody().accept(this, context);
		emit("\n } \n}\n");
		return null;
    }
    
    
  


}
