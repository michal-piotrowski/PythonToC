package pl.edu.agh.compilers;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link simpleParser}.
 */
public interface simpleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link simpleParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(simpleParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(simpleParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#funcDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFuncDefinition(simpleParser.FuncDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#funcDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFuncDefinition(simpleParser.FuncDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(simpleParser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(simpleParser.ClassDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(simpleParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(simpleParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(simpleParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(simpleParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#compoundAssignment}.
	 * @param ctx the parse tree
	 */
	void enterCompoundAssignment(simpleParser.CompoundAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#compoundAssignment}.
	 * @param ctx the parse tree
	 */
	void exitCompoundAssignment(simpleParser.CompoundAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#compAssign_op}.
	 * @param ctx the parse tree
	 */
	void enterCompAssign_op(simpleParser.CompAssign_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#compAssign_op}.
	 * @param ctx the parse tree
	 */
	void exitCompAssign_op(simpleParser.CompAssign_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void enterConditionalStatement(simpleParser.ConditionalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void exitConditionalStatement(simpleParser.ConditionalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#test}.
	 * @param ctx the parse tree
	 */
	void enterTest(simpleParser.TestContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#test}.
	 * @param ctx the parse tree
	 */
	void exitTest(simpleParser.TestContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#test_op}.
	 * @param ctx the parse tree
	 */
	void enterTest_op(simpleParser.Test_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#test_op}.
	 * @param ctx the parse tree
	 */
	void exitTest_op(simpleParser.Test_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(simpleParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(simpleParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(simpleParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(simpleParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#addition}.
	 * @param ctx the parse tree
	 */
	void enterAddition(simpleParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#addition}.
	 * @param ctx the parse tree
	 */
	void exitAddition(simpleParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#multiplication}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(simpleParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#multiplication}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(simpleParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(simpleParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(simpleParser.AtomContext ctx);
}