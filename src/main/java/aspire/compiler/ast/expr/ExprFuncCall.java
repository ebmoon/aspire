package aspire.compiler.ast.expr;

import aspire.compiler.ast.SpyroNodeVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for function call expressions
 *
 * @author Kanghee Park &lt;khpark@cs.wisc.edu&gt;
 */
public class ExprFuncCall extends Expression {

    private String functionID;
    private List<Expression> args;

    public ExprFuncCall(String functionID, List<Expression> args) {
        super();
        this.functionID = String.valueOf(functionID);
        this.args = new ArrayList<>(args);
    }

    public String getFunctionID() {
        return functionID;
    }

    public List<Expression> getArgs() {
        return args;
    }

    @Override
    public Object accept(SpyroNodeVisitor v) {
        return v.visitExprFuncCall(this);
    }

    public String toString() {
        String argsString = args.stream().map(Expression::toString)
                .collect(Collectors.joining(","));
        return String.format("%s(%s)", functionID, argsString);
    }
}
 