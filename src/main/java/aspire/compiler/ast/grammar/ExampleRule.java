package aspire.compiler.ast.grammar;

import aspire.compiler.ast.SpyroNode;
import aspire.compiler.ast.SpyroNodeVisitor;
import aspire.compiler.ast.expr.Nonterminal;

import java.util.List;

/**
 * Class for example production rule
 *
 * @author Kanghee Park &lt;khpark@cs.wisc.edu&gt;
 */
public class ExampleRule extends SpyroNode {

    Nonterminal nonterminal;
    List<RHSTerm> rules;


    public ExampleRule(Nonterminal nonterminal, List<RHSTerm> rules) {
        this.nonterminal = nonterminal;
        this.rules = rules;
    }

    @Override
    public Object accept(SpyroNodeVisitor v) {
        return v.visitExampleRule(this);
    }

    public Nonterminal getNonterminal() {
        return nonterminal;
    }

    public List<RHSTerm> getRules() {
        return rules;
    }

}
