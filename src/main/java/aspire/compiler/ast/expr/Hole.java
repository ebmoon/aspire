package aspire.compiler.ast.expr;

import aspire.compiler.ast.SpyroNodeVisitor;

/**
 * Class for default hole expression
 *
 * @author Kanghee Park &lt;khpark@cs.wisc.edu&gt;
 */
public class Hole extends Expression {

    private int size;

    public Hole() {
        super();
        this.size = 0;
    }

    public Hole(int size) {
        super();
        this.size = size;
    }

    @Override
    public Object accept(SpyroNodeVisitor v) {
        return v.visitHole(this);
    }

    public int getSize() {
        return this.size;
    }

    public String toString() {
        if (size == 0) {
            return "??";
        } else {
            return String.format("??(%d)", size);
        }
    }
}
