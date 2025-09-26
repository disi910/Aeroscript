// Generated from /Users/didriksivertsen/Downloads/precode/src/main/antlr/AeroScript.g4 by ANTLR 4.13.1

package no.uio.aeroscript.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AeroScriptParser}.
 */
public interface AeroScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AeroScriptParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(AeroScriptParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link AeroScriptParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(AeroScriptParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link AeroScriptParser#execution}.
	 * @param ctx the parse tree
	 */
	void enterExecution(AeroScriptParser.ExecutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AeroScriptParser#execution}.
	 * @param ctx the parse tree
	 */
	void exitExecution(AeroScriptParser.ExecutionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PlusExp}
	 * labeled alternative in {@link AeroScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPlusExp(AeroScriptParser.PlusExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PlusExp}
	 * labeled alternative in {@link AeroScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPlusExp(AeroScriptParser.PlusExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TimesExp}
	 * labeled alternative in {@link AeroScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTimesExp(AeroScriptParser.TimesExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TimesExp}
	 * labeled alternative in {@link AeroScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTimesExp(AeroScriptParser.TimesExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegExp}
	 * labeled alternative in {@link AeroScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegExp(AeroScriptParser.NegExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegExp}
	 * labeled alternative in {@link AeroScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegExp(AeroScriptParser.NegExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumExp}
	 * labeled alternative in {@link AeroScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumExp(AeroScriptParser.NumExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumExp}
	 * labeled alternative in {@link AeroScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumExp(AeroScriptParser.NumExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParentExp}
	 * labeled alternative in {@link AeroScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParentExp(AeroScriptParser.ParentExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParentExp}
	 * labeled alternative in {@link AeroScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParentExp(AeroScriptParser.ParentExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RangeExp}
	 * labeled alternative in {@link AeroScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRangeExp(AeroScriptParser.RangeExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RangeExp}
	 * labeled alternative in {@link AeroScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRangeExp(AeroScriptParser.RangeExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MinusExp}
	 * labeled alternative in {@link AeroScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMinusExp(AeroScriptParser.MinusExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MinusExp}
	 * labeled alternative in {@link AeroScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMinusExp(AeroScriptParser.MinusExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PointExp}
	 * labeled alternative in {@link AeroScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPointExp(AeroScriptParser.PointExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PointExp}
	 * labeled alternative in {@link AeroScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPointExp(AeroScriptParser.PointExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AeroScriptParser#point}.
	 * @param ctx the parse tree
	 */
	void enterPoint(AeroScriptParser.PointContext ctx);
	/**
	 * Exit a parse tree produced by {@link AeroScriptParser#point}.
	 * @param ctx the parse tree
	 */
	void exitPoint(AeroScriptParser.PointContext ctx);
	/**
	 * Enter a parse tree produced by {@link AeroScriptParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(AeroScriptParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AeroScriptParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(AeroScriptParser.RangeContext ctx);
}