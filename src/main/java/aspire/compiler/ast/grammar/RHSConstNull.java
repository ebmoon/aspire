package aspire.compiler.ast.grammar;

import aspire.compiler.ast.SpyroNodeVisitor;

/**
 * Class for constant null pointer expression
 *
 * @author Kanghee Park &lt;khpark@cs.wisc.edu&gt;
 */
public class RHSConstNull extends RHSConstant {

    public RHSConstNull() {
        super();
    }

    @Override
    public Object accept(SpyroNodeVisitor v) {
        return v.visitRHSConstNull(this);
    }

    public String toString() { return "null"; }
}
