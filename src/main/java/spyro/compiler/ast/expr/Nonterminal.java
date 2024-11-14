package spyro.compiler.ast.expr;

import spyro.compiler.ast.SpyroNodeVisitor;
import spyro.compiler.ast.type.Type;

import java.util.List;

/**
 * A Spyro Nonterminal, which can be parameterized.
 *
 * @author Kanghee Park &lt;khpark@cs.wisc.edu&gt;
 */
public class Nonterminal  {

    private String id;
    private Type type;
    private List<String> params;

    public Nonterminal(Type type, String id) {
        super();
        this.type = type;
        this.id = String.valueOf(id);
    }

    public Nonterminal(Type type, String id, List<String> params) {
        super();
        this.type = type;
        this.id = String.valueOf(id);
        this.params = params;
    }

    // todo : fix it
//    @Override
//    public Object accept(SpyroNodeVisitor visitor) {
//        return visitor.visitNonterminal(this);
//    }


    public int size() { return 0; }

    public String getID() {
        return id;
    }

    public Type getType() {
        return type;
    }
    public List<String> getParams() {return params; }

    public String toString() {
        return id;
    }

    public String toFullString() {
        return String.format("%s %s", type.toString(), id);
    }
}
