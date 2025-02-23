package aspire.compiler.ast.grammar;

import aspire.compiler.ast.SpyroNodeVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for function call expressions
 *
 * @author Kanghee Park &lt;khpark@cs.wisc.edu&gt;
 */
public class RHSFuncCall extends RHSTerm {

    private String functionID;
    private List<RHSTerm> args;

    public RHSFuncCall(String functionID, List<RHSTerm> args) {
        super();
        this.functionID = String.valueOf(functionID);
        this.args = new ArrayList<>(args);
    }

    public String getFunctionID() {
        return functionID;
    }

    public List<RHSTerm> getArgs() {
        return args;
    }

    public int size() {
        return 1 + args.stream().mapToInt(RHSTerm::size).sum();
    }
    @Override
    public Object accept(SpyroNodeVisitor v) {
        return v.visitRHSFuncCall(this);
    }

    public String toString() {
        String argsString = args.stream().map(RHSTerm::toString)
                .collect(Collectors.joining(","));
        return String.format("%s(%s)", functionID, argsString);
    }
}
 