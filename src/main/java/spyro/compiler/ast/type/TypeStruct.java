package spyro.compiler.ast.type;

import spyro.compiler.ast.SpyroNodeVisitor;

/**
 * Class for struct types
 *
 * @author Kanghee Park &lt;khpark@cs.wisc.edu&gt;
 */
public class TypeStruct extends Type {

    private String id;
    public TypeStruct(String id) {
        this.id = id;
    }


    @Override
    public Object accept(SpyroNodeVisitor v) {
        return v.visitTypeStruct(this);
    }

    @Override
    public boolean isStruct() {
        return true;
    }

    @Override
    public String toString() {
        return id;
    }
}
