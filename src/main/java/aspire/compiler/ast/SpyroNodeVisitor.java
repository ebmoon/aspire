package aspire.compiler.ast;

import aspire.compiler.ast.expr.*;
import aspire.compiler.ast.expr.Variable;
import aspire.compiler.ast.grammar.*;
import aspire.compiler.ast.type.*;

/**
 * Visitor interface for SpyroNode nodes.
 * This class implements visitor pattern for SpyroNode class.
 *
 * @author Kanghee Park &lt;khpark@cs.wisc.edu&gt;
 */
public interface SpyroNodeVisitor {
    public Object visitQuery(Query q);

    public Object visitVariable(Variable v);
    public Object visitHole(Hole hole);
    public Object visitExprFuncCall(ExprFuncCall fc);
    public Object visitExprUnary(ExprUnary e);
    public Object visitExprBinary(ExprBinary e);
    public Object visitConstInt(ConstInt n);
    public Object visitConstBool(ConstBool b);
    public Object visitConstNull(ConstNull nullptr);

    public Object visitTypePrimitive(TypePrimitive type);
    public Object visitTypeStruct(TypeStruct type);
    public Object visitTypeArray(TypeArray type);

    public Object visitRHSNonterminal(RHSNonterminal n);
    public Object visitRHSUnary(RHSUnary e);
    public Object visitRHSBinary(RHSBinary e);
    public Object visitRHSFuncCall(RHSFuncCall fc);
    public Object visitRHSHole(RHSHole hole);
    public Object visitRHSVariable(RHSVariable v);
    public Object visitRHSAnonFunc(RHSLambda lam);
    public Object visitRHSConstBool(RHSConstBool b);
    public Object visitRHSConstInt(RHSConstInt n);
    public Object visitRHSConstNull(RHSConstNull nullptr);
    public Object visitGrammarRule(GrammarRule rule);
    public Object visitExampleRule(ExampleRule rule);
}
