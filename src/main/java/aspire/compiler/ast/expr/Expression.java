package aspire.compiler.ast.expr;

import aspire.compiler.ast.SpyroNode;

/**
 * An abstract class for Spyro expression.
 *
 * @author Kanghee Park &lt;khpark@cs.wisc.edu&gt;
 */
public abstract class Expression extends SpyroNode {
    public boolean isConstant() {
        return false;
    }
}
