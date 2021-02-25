// Generated from ILPMLgrammar4Tme8.g4 by ANTLR 4.4

    package antlr4;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ILPMLgrammar4Tme8Parser}.
 */
public interface ILPMLgrammar4Tme8Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ILPMLgrammar4Tme8Parser#globalFunDef}.
	 * @param ctx the parse tree
	 */
	void enterGlobalFunDef(@NotNull ILPMLgrammar4Tme8Parser.GlobalFunDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILPMLgrammar4Tme8Parser#globalFunDef}.
	 * @param ctx the parse tree
	 */
	void exitGlobalFunDef(@NotNull ILPMLgrammar4Tme8Parser.GlobalFunDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code New}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNew(@NotNull ILPMLgrammar4Tme8Parser.NewContext ctx);
	/**
	 * Exit a parse tree produced by the {@code New}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNew(@NotNull ILPMLgrammar4Tme8Parser.NewContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull ILPMLgrammar4Tme8Parser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull ILPMLgrammar4Tme8Parser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Invocation}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInvocation(@NotNull ILPMLgrammar4Tme8Parser.InvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Invocation}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInvocation(@NotNull ILPMLgrammar4Tme8Parser.InvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILPMLgrammar4Tme8Parser#localFunDef}.
	 * @param ctx the parse tree
	 */
	void enterLocalFunDef(@NotNull ILPMLgrammar4Tme8Parser.LocalFunDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILPMLgrammar4Tme8Parser#localFunDef}.
	 * @param ctx the parse tree
	 */
	void exitLocalFunDef(@NotNull ILPMLgrammar4Tme8Parser.LocalFunDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstFloat}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstFloat(@NotNull ILPMLgrammar4Tme8Parser.ConstFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstFloat}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstFloat(@NotNull ILPMLgrammar4Tme8Parser.ConstFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableAssign}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssign(@NotNull ILPMLgrammar4Tme8Parser.VariableAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableAssign}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssign(@NotNull ILPMLgrammar4Tme8Parser.VariableAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Self}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSelf(@NotNull ILPMLgrammar4Tme8Parser.SelfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Self}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSelf(@NotNull ILPMLgrammar4Tme8Parser.SelfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReadField}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterReadField(@NotNull ILPMLgrammar4Tme8Parser.ReadFieldContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReadField}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitReadField(@NotNull ILPMLgrammar4Tme8Parser.ReadFieldContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassDefinition}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#globalDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(@NotNull ILPMLgrammar4Tme8Parser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassDefinition}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#globalDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(@NotNull ILPMLgrammar4Tme8Parser.ClassDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Send}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSend(@NotNull ILPMLgrammar4Tme8Parser.SendContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Send}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSend(@NotNull ILPMLgrammar4Tme8Parser.SendContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstInteger}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstInteger(@NotNull ILPMLgrammar4Tme8Parser.ConstIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstInteger}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstInteger(@NotNull ILPMLgrammar4Tme8Parser.ConstIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Super}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSuper(@NotNull ILPMLgrammar4Tme8Parser.SuperContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Super}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSuper(@NotNull ILPMLgrammar4Tme8Parser.SuperContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Codefinitions}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCodefinitions(@NotNull ILPMLgrammar4Tme8Parser.CodefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Codefinitions}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCodefinitions(@NotNull ILPMLgrammar4Tme8Parser.CodefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Try}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTry(@NotNull ILPMLgrammar4Tme8Parser.TryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Try}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTry(@NotNull ILPMLgrammar4Tme8Parser.TryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Lambda}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLambda(@NotNull ILPMLgrammar4Tme8Parser.LambdaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lambda}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLambda(@NotNull ILPMLgrammar4Tme8Parser.LambdaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Binding}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinding(@NotNull ILPMLgrammar4Tme8Parser.BindingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Binding}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinding(@NotNull ILPMLgrammar4Tme8Parser.BindingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Loop}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLoop(@NotNull ILPMLgrammar4Tme8Parser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Loop}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLoop(@NotNull ILPMLgrammar4Tme8Parser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Alternative}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAlternative(@NotNull ILPMLgrammar4Tme8Parser.AlternativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Alternative}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAlternative(@NotNull ILPMLgrammar4Tme8Parser.AlternativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HasProperty}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterHasProperty(@NotNull ILPMLgrammar4Tme8Parser.HasPropertyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HasProperty}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitHasProperty(@NotNull ILPMLgrammar4Tme8Parser.HasPropertyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GlobalFunctionDefinition}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#globalDef}.
	 * @param ctx the parse tree
	 */
	void enterGlobalFunctionDefinition(@NotNull ILPMLgrammar4Tme8Parser.GlobalFunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GlobalFunctionDefinition}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#globalDef}.
	 * @param ctx the parse tree
	 */
	void exitGlobalFunctionDefinition(@NotNull ILPMLgrammar4Tme8Parser.GlobalFunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILPMLgrammar4Tme8Parser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(@NotNull ILPMLgrammar4Tme8Parser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILPMLgrammar4Tme8Parser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(@NotNull ILPMLgrammar4Tme8Parser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILPMLgrammar4Tme8Parser#methodDef}.
	 * @param ctx the parse tree
	 */
	void enterMethodDef(@NotNull ILPMLgrammar4Tme8Parser.MethodDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILPMLgrammar4Tme8Parser#methodDef}.
	 * @param ctx the parse tree
	 */
	void exitMethodDef(@NotNull ILPMLgrammar4Tme8Parser.MethodDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sequence}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSequence(@NotNull ILPMLgrammar4Tme8Parser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sequence}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSequence(@NotNull ILPMLgrammar4Tme8Parser.SequenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WriteProperty}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterWriteProperty(@NotNull ILPMLgrammar4Tme8Parser.WritePropertyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WriteProperty}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitWriteProperty(@NotNull ILPMLgrammar4Tme8Parser.WritePropertyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstFalse}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstFalse(@NotNull ILPMLgrammar4Tme8Parser.ConstFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstFalse}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstFalse(@NotNull ILPMLgrammar4Tme8Parser.ConstFalseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ILPMLgrammar4Tme8Parser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(@NotNull ILPMLgrammar4Tme8Parser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ILPMLgrammar4Tme8Parser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(@NotNull ILPMLgrammar4Tme8Parser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary(@NotNull ILPMLgrammar4Tme8Parser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary(@NotNull ILPMLgrammar4Tme8Parser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstTrue}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstTrue(@NotNull ILPMLgrammar4Tme8Parser.ConstTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstTrue}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstTrue(@NotNull ILPMLgrammar4Tme8Parser.ConstTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReadProperty}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterReadProperty(@NotNull ILPMLgrammar4Tme8Parser.ReadPropertyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReadProperty}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitReadProperty(@NotNull ILPMLgrammar4Tme8Parser.ReadPropertyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WriteField}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterWriteField(@NotNull ILPMLgrammar4Tme8Parser.WriteFieldContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WriteField}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitWriteField(@NotNull ILPMLgrammar4Tme8Parser.WriteFieldContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstString}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstString(@NotNull ILPMLgrammar4Tme8Parser.ConstStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstString}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstString(@NotNull ILPMLgrammar4Tme8Parser.ConstStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Binary}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinary(@NotNull ILPMLgrammar4Tme8Parser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Binary}
	 * labeled alternative in {@link ILPMLgrammar4Tme8Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinary(@NotNull ILPMLgrammar4Tme8Parser.BinaryContext ctx);
}