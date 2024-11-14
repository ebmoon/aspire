package spyro.compiler.ast.type;

import sketch.compiler.ast.core.exprs.ExprConstInt;
import sketch.compiler.ast.core.exprs.Expression;
import sketch.compiler.ast.cuda.typs.CudaMemoryType;
import spyro.compiler.ast.SpyroNodeVisitor;
import spyro.util.exceptions.ParseException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Collections.unmodifiableList;

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
