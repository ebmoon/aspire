package spyro.compiler.parser;

import java.util.List;
import java.util.HashMap;
import java.util.stream.Collectors;

import spyro.compiler.ast.*;
import spyro.compiler.ast.expr.*;
import spyro.compiler.ast.type.*;
import spyro.util.exceptions.*;

/**
 * This class provides an implementation of Spyro AST builder.
 * 
 * @author Kanghee Park &lt;khpark@cs.wisc.edu&gt;
 */
public class BuildAstVisitor extends SpyroBaseVisitor<SpyroNode> {

	HashMap<String, Variable> varContext;
	
	@Override 
	public Query visitParse(SpyroParser.ParseContext ctx) { 
		return visitProgram(ctx.program()); 
	}

	@Override 
	public Query visitProgram(SpyroParser.ProgramContext ctx) { 
		List<Variable> variables = ctx.declVariables().declVar().stream()
			.map(varCtx -> visitDeclVar(varCtx))
			.collect(Collectors.toList());
		
		List<ExprFuncCall> signatures = ctx.declSignatures().declSig().stream()
				.map(sigCtx -> visitDeclSig(sigCtx))
				.collect(Collectors.toList());

		return new Query(variables, signatures);
	}

	public Variable visitDeclVar(SpyroParser.DeclVarContext ctx) {
		if (ctx instanceof SpyroParser.DeclVisibleVarContext)
			return visitDeclVisibleVar((SpyroParser.DeclVisibleVarContext) ctx);
		else if (ctx instanceof SpyroParser.DeclHiddenVarContext)
			return visitDeclHiddenVar((SpyroParser.DeclHiddenVarContext) ctx);
		else
			throw new ParseException("Unknown variable declaration case");
	}
	
	@Override 
	public Variable visitDeclVisibleVar(SpyroParser.DeclVisibleVarContext ctx) { 
		Type type = visitType(ctx.type());
		String id = ctx.ID().getText();
		
		return new Variable(type, id); 
	}
	
	@Override 
	public Variable visitDeclHiddenVar(SpyroParser.DeclHiddenVarContext ctx) { 
		Type type = visitType(ctx.type());
		String id = ctx.ID().getText();
		
		return new Variable(type, id, true); 
	}
	
	@Override
	public Type visitType(SpyroParser.TypeContext ctx) {
		String id = ctx.ID().getText();
		if (Type.isPrimitiveId(id)) {
			return new TypePrimitive(id);
		} else {
			return new TypeStruct(id);
		}
	}
	
	@Override
	public ExprFuncCall visitDeclSig(SpyroParser.DeclSigContext ctx) {
		SpyroParser.ExprContext expr = ctx.expr();
		if (expr instanceof SpyroParser.FunctionExprContext) {
			return visitFunctionExpr((SpyroParser.FunctionExprContext) expr);
		} else  {
			throw new ParseException("Signature must be a form of function call");
		}
	}
	
	public Expression visitExpression(SpyroParser.ExprContext ctx) {
		if (ctx instanceof SpyroParser.FunctionExprContext)
			return visitFunctionExpr((SpyroParser.FunctionExprContext) ctx);
		else if (ctx instanceof SpyroParser.ParenExprContext)
			return visitExpression(((SpyroParser.ParenExprContext) ctx).expr());
		else if (ctx instanceof SpyroParser.UnaryMinusExprContext)
			return visitUnaryMinusExpr((SpyroParser.UnaryMinusExprContext) ctx);
		else if (ctx instanceof SpyroParser.NotExprContext)
			return visitNotExpr((SpyroParser.NotExprContext) ctx);
		else if (ctx instanceof SpyroParser.MultiplicationExprContext)
			return visitMultiplicationExpr((SpyroParser.MultiplicationExprContext) ctx);
		else if (ctx instanceof SpyroParser.AdditiveExprContext)
			return visitAdditiveExpr((SpyroParser.AdditiveExprContext) ctx);
		else if (ctx instanceof SpyroParser.RelationalExprContext)
			return visitRelationalExpr((SpyroParser.RelationalExprContext) ctx);
		else if (ctx instanceof SpyroParser.EqualityExprContext)
			return visitEqualityExpr((SpyroParser.EqualityExprContext) ctx);
		else if (ctx instanceof SpyroParser.AndExprContext)
			return visitAndExpr((SpyroParser.AndExprContext) ctx);
		else if (ctx instanceof SpyroParser.OrExprContext)
			return visitOrExpr((SpyroParser.OrExprContext) ctx);
		else if (ctx instanceof SpyroParser.AtomExprContext)
			return visitAtom(((SpyroParser.AtomExprContext) ctx).atom());
		else
			throw new ParseException("Unknown expression case");
	}
	
	public Expression visitAtom(SpyroParser.AtomContext ctx) {
		if (ctx instanceof SpyroParser.NumberAtomContext)
			return visitNumberAtom((SpyroParser.NumberAtomContext) ctx);
		else if (ctx instanceof SpyroParser.BooleanAtomContext)
			return visitBooleanAtom((SpyroParser.BooleanAtomContext) ctx);
		else if (ctx instanceof SpyroParser.NullAtomContext)
			return visitNullAtom((SpyroParser.NullAtomContext) ctx);
		else if (ctx instanceof SpyroParser.UnsizedHoleAtomContext)
			return visitUnsizedHoleAtom((SpyroParser.UnsizedHoleAtomContext) ctx);
		else if (ctx instanceof SpyroParser.SizedHoleAtomContext)
			return visitSizedHoleAtom((SpyroParser.SizedHoleAtomContext) ctx);
		else if (ctx instanceof SpyroParser.IdAtomContext)
			return null;	// Not implemented
		else
			throw new ParseException("Unknown atom expression");
	}
	
	@Override
	public ConstInt visitNumberAtom(SpyroParser.NumberAtomContext ctx) {
		int val = Integer.parseInt(ctx.INT().getText());
		return new ConstInt(val);
	}
	
	@Override
	public ConstBool visitBooleanAtom(SpyroParser.BooleanAtomContext ctx) {
		if (ctx.TRUE() != null)
			return new ConstBool(true);
		else if (ctx.FALSE() != null)
			return new ConstBool(false);
		else
			throw new ParseException("Unknown boolean value");
	}
	
	@Override
	public ConstNull visitNullAtom(SpyroParser.NullAtomContext ctx) {
		return new ConstNull();
	}
	
	@Override
	public Hole visitUnsizedHoleAtom(SpyroParser.UnsizedHoleAtomContext ctx) {
		return new Hole();
	}
	
	@Override
	public Hole visitSizedHoleAtom(SpyroParser.SizedHoleAtomContext ctx) {
		int size = Integer.parseInt(ctx.INT().getText());
		return new Hole(size);
	}
	
	@Override
	public ExprFuncCall visitFunctionExpr(SpyroParser.FunctionExprContext ctx) {
		String id = ctx.ID().getText();
		List<Expression> exprs = ctx.expr().stream()
				.map(exprCtx -> visitExpression(exprCtx))
				.collect(Collectors.toList());

		return new ExprFuncCall(id, exprs);
	}
	
	@Override
	public ExprUnary visitUnaryMinusExpr(SpyroParser.UnaryMinusExprContext ctx) {
		Expression expr = visitExpression(ctx.expr());
		return new ExprUnary(ExprUnary.UnaryOp.UNOP_NEG, expr);
	}
	
	@Override
	public ExprUnary visitNotExpr(SpyroParser.NotExprContext ctx) {
		Expression expr = visitExpression(ctx.expr());
		return new ExprUnary(ExprUnary.UnaryOp.UNOP_NOT, expr);
	}
	
	@Override
	public ExprBinary visitMultiplicationExpr(SpyroParser.MultiplicationExprContext ctx) {
		Expression expr1 = visitExpression(ctx.expr(0));
		Expression expr2 = visitExpression(ctx.expr(1));
		ExprBinary.BinaryOp op;
		
		if (ctx.MULT() != null) {
			op = ExprBinary.BinaryOp.BINOP_MUL;
		} else if (ctx.DIV() != null) {
			op = ExprBinary.BinaryOp.BINOP_DIV;
		} else if (ctx.MOD() != null) {
			op = ExprBinary.BinaryOp.BINOP_MOD;
		} else {
			throw new ParseException("Unknown multiplicative binary operator");
		}
		
		return new ExprBinary(op, expr1, expr2);
	}
	
	@Override
	public ExprBinary visitAdditiveExpr(SpyroParser.AdditiveExprContext ctx) {
		Expression expr1 = visitExpression(ctx.expr(0));
		Expression expr2 = visitExpression(ctx.expr(1));
		ExprBinary.BinaryOp op;
		
		if (ctx.PLUS() != null) {
			op = ExprBinary.BinaryOp.BINOP_ADD;
		} else if (ctx.MINUS() != null) {
			op = ExprBinary.BinaryOp.BINOP_SUB;
		} else {
			throw new ParseException("Unknown additive binary operator");
		}
		
		return new ExprBinary(op, expr1, expr2);
	}
	
	@Override
	public ExprBinary visitRelationalExpr(SpyroParser.RelationalExprContext ctx) {
		Expression expr1 = visitExpression(ctx.expr(0));
		Expression expr2 = visitExpression(ctx.expr(1));
		ExprBinary.BinaryOp op;
		
		if (ctx.LTEQ() != null) {
			op = ExprBinary.BinaryOp.BINOP_LE;
		} else if (ctx.GTEQ() != null) {
			op = ExprBinary.BinaryOp.BINOP_GE;
		} else if (ctx.LT() != null) {
			op = ExprBinary.BinaryOp.BINOP_LT;
		} else if (ctx.GT() != null) {
			op = ExprBinary.BinaryOp.BINOP_GT;
		} else {
			throw new ParseException("Unknown relational binary operator");
		}
		
		return new ExprBinary(op, expr1, expr2);
	}
	
	@Override
	public ExprBinary visitEqualityExpr(SpyroParser.EqualityExprContext ctx) {
		Expression expr1 = visitExpression(ctx.expr(0));
		Expression expr2 = visitExpression(ctx.expr(1));
		ExprBinary.BinaryOp op;
		
		if (ctx.EQ() != null) {
			op = ExprBinary.BinaryOp.BINOP_EQ;
		} else if (ctx.NEQ() != null) {
			op = ExprBinary.BinaryOp.BINOP_NEQ;
		} else {
			throw new ParseException("Unknown equality binary operator");
		}
		
		return new ExprBinary(op, expr1, expr2);
	}
	
	@Override
	public ExprBinary visitAndExpr(SpyroParser.AndExprContext ctx) {
		Expression expr1 = visitExpression(ctx.expr(0));
		Expression expr2 = visitExpression(ctx.expr(1));
		
		return new ExprBinary(ExprBinary.BinaryOp.BINOP_AND, expr1, expr2);
	}
	
	@Override
	public ExprBinary visitOrExpr(SpyroParser.OrExprContext ctx) {
		Expression expr1 = visitExpression(ctx.expr(0));
		Expression expr2 = visitExpression(ctx.expr(1));
		
		return new ExprBinary(ExprBinary.BinaryOp.BINOP_OR, expr1, expr2);
	}
}
