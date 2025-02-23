package aspire.compiler.ast.expr;

import aspire.compiler.ast.SpyroNodeVisitor;

/**
 * Class for constant null pointer expression
 *
 * @author Kanghee Park &lt;khpark@cs.wisc.edu&gt;
 */
public class ConstNull extends Constant {

    public ConstNull() {
        super();
    }

    @Override
    public Object accept(SpyroNodeVisitor v) {
        return v.visitConstNull(this);
    }

    public String toString() { return "null"; }
}
