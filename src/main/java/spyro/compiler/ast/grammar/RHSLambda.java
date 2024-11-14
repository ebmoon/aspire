package spyro.compiler.ast.grammar;

import spyro.compiler.ast.SpyroNodeVisitor;

/**
 * A class for anonymous function
 *
 * @author Kanghee Park &lt;khpark@cs.wisc.edu&gt;
 */
public class RHSLambda extends RHSTerm {
    List<String> param;
    RHSTerm body;

    public RHSLambda(List<String> param, RHSTerm body) {
        this.param = param;
        this.body = body;
    }

    public List<String> getParam() {
        return param;
    }

    public RHSTerm getBody() {
        return body;
    }

    public String toString() {
        String paramString = String.join(",", param);
        return String.format("(%s) -> %s", paramString, body.toString());
    }

    public int size() {
        return 2 + body.size();
    }

    @Override
    public Object accept(SpyroNodeVisitor v) {
        return v.visitRHSAnonFunc(this);
    }
}
