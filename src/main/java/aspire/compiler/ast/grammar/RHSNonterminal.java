package aspire.compiler.ast.grammar;

import aspire.compiler.ast.SpyroNodeVisitor;
import aspire.compiler.ast.expr.Nonterminal;

import java.util.List;

/**
 * A Spyro variable.
 * Each variable could be either visible or hidden.
 *
 * @author Kanghee Park &lt;khpark@cs.wisc.edu&gt;
 */
public class RHSNonterminal extends RHSTerm {

    private String id;
    private List<RHSTerm> args;

    private Nonterminal ref;

    public RHSNonterminal(String id, Nonterminal ref) {
        super();
        this.id = String.valueOf(id);
        this.ref = ref;
    }

    public RHSNonterminal(String id, Nonterminal ref, List<RHSTerm> args) {
        super();
        this.id = String.valueOf(id);
        this.ref = ref;
        this.args = args;
    }

    @Override
    public Object accept(SpyroNodeVisitor visitor) {
        return visitor.visitRHSNonterminal(this);
    }

    public int size() { return 0; }

    public String getID() {
        return id;
    }

    public Nonterminal getRef() {
        return ref;
    }

    public String toString() {
        return id;
    }

    public String toFullString() {
        return String.format("%s[%s]", id, args.toString());
    }
}
