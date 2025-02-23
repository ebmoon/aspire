package aspire.compiler.ast.expr;

import aspire.compiler.ast.SpyroNodeVisitor;

/**
 * Class for constant integer expression
 *
 * @author Kanghee Park &lt;khpark@cs.wisc.edu&gt;
 */
public class ConstInt extends Constant {

    private int value;

    public ConstInt(int value) {
        super();
        this.value = value;
    }

    @Override
    public Object accept(SpyroNodeVisitor v) {
        return v.visitConstInt(this);
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(value);
    }
}
