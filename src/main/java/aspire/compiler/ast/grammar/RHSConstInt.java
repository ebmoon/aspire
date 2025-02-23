package aspire.compiler.ast.grammar;

import aspire.compiler.ast.SpyroNodeVisitor;

/**
 * Class for constant integer expression
 *
 * @author Kanghee Park &lt;khpark@cs.wisc.edu&gt;
 */
public class RHSConstInt extends RHSConstant {

    private int value;

    public RHSConstInt(int value) {
        super();
        this.value = value;
    }

    @Override
    public Object accept(SpyroNodeVisitor v) {
        return v.visitRHSConstInt(this);
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(value);
    }
}
