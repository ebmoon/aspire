package aspire.compiler.ast.type;

import aspire.compiler.ast.SpyroNodeVisitor;

/**
 * Class for array types
 *
 * @author Xuanyu Peng &lt;xup002@ucsd.edu&gt;
 */
public class TypeArray extends Type {

//    private String id;

    private Type base;
    private int length;

    public TypeArray(Type base, int length) {
        this.base = base;
        this.length = length;
    }

    public boolean isArray () { return true; }

    public Type getBase() {
        return base;
    }

    public int getLength() {
        return length;
    }

    @Override
    public Object accept(SpyroNodeVisitor v) {
        return v.visitTypeArray(this);
    }

    @Override
    public String toString() {
        return  base + "["  + length + ']';
    }
}
