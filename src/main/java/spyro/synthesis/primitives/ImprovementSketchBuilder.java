package spyro.synthesis.primitives;

import sketch.compiler.ast.core.Package;
import sketch.compiler.ast.core.*;
import sketch.compiler.ast.core.exprs.ExprFunCall;
import sketch.compiler.ast.core.exprs.ExprUnary;
import sketch.compiler.ast.core.exprs.ExprVar;
import sketch.compiler.ast.core.stmts.*;
import sketch.compiler.ast.core.typs.StructDef;
import spyro.synthesis.Property;
import spyro.synthesis.PropertySet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Class to build sketch AST for checking improvement in over-approx problem.
 *
 * @author Kanghee Park &lt;khpark@cs.wisc.edu&gt;
 */
public class ImprovementSketchBuilder {

    final CommonSketchBuilder commonBuilder;
    public final static String improvementFunctionID = "improvement";
    Function improvementBody = null;

    public ImprovementSketchBuilder(CommonSketchBuilder commonBuilder) {
        this.commonBuilder = commonBuilder;
    }

    private Function getImprovementUnderBody() {
        if (improvementBody == null) {
            Function.FunctionCreator fc = Function.creator((FENode) null, improvementFunctionID, Function.FcnType.Harness);

            List<Statement> stmts = new ArrayList<>();
            stmts.add(commonBuilder.getVariableDecls(CommonSketchBuilder.ALL_VAR, CommonSketchBuilder.W_INIT));

            final String tempVarID = "out";
            ExprVar tempVar1 = new ExprVar((FENode) null, tempVarID + "1");
            ExprVar tempVar2 = new ExprVar((FENode) null, tempVarID + "2");

            // boolean out1;
            stmts.add(new StmtVarDecl((FENode) null, sketch.compiler.ast.core.typs.TypePrimitive.bittype, tempVar1.getName(), null));
            // synthesized_property(..., out);
            stmts.add(new StmtExpr(new ExprFunCall((FENode) null, Property.phiID,
                    commonBuilder.getVariableAsExprs(CommonSketchBuilder.ONLY_VISIBLE, tempVar1.getName()))));
            // assert out;
            stmts.add(new StmtAssert(tempVar1, false));

            // boolean out2
            stmts.add(new StmtVarDecl((FENode) null, sketch.compiler.ast.core.typs.TypePrimitive.bittype, tempVar2.getName(), null));
            // property_disj(..., out2);
            stmts.add(new StmtExpr(new ExprFunCall((FENode) null,
                    PropertySet.disjunctionID,
                    commonBuilder.getVariableAsExprs(CommonSketchBuilder.ONLY_VISIBLE, tempVar2.getName()))));
            // assert !out2;
            stmts.add(new StmtAssert(new ExprUnary((FENode) null, ExprUnary.UNOP_NOT, tempVar2), false));

            Statement body = new StmtBlock((FENode) null, stmts);

            fc.params(new ArrayList<>());
            fc.body(body);

            improvementBody = fc.create();
        }

        return improvementBody;
    }

    private Function getImprovementOverBody() {
        if (improvementBody == null) {
            Function.FunctionCreator fc = Function.creator((FENode) null, improvementFunctionID, Function.FcnType.Harness);

            List<Statement> stmts = new ArrayList<>();
            stmts.add(commonBuilder.getVariableDecls(CommonSketchBuilder.ALL_VAR, CommonSketchBuilder.W_INIT));

            final String tempVarID = "out";
            ExprVar tempVar1 = new ExprVar((FENode) null, tempVarID + "1");
            ExprVar tempVar2 = new ExprVar((FENode) null, tempVarID + "2");

            // boolean out1;
            stmts.add(new StmtVarDecl((FENode) null, sketch.compiler.ast.core.typs.TypePrimitive.bittype, tempVar1.getName(), null));
            // synthesized_property(..., out);
            stmts.add(new StmtExpr(new ExprFunCall((FENode) null, Property.phiID,
                    commonBuilder.getVariableAsExprs(CommonSketchBuilder.ONLY_VISIBLE, tempVar1.getName()))));
            // assert !out;
            stmts.add(new StmtAssert(new ExprUnary((FENode) null, ExprUnary.UNOP_NOT, tempVar1), false));

            // boolean out2
            stmts.add(new StmtVarDecl((FENode) null, sketch.compiler.ast.core.typs.TypePrimitive.bittype, tempVar2.getName(), null));
            // property_conj(..., out2);
            stmts.add(new StmtExpr(new ExprFunCall((FENode) null,
                    PropertySet.conjunctionID,
                    commonBuilder.getVariableAsExprs(CommonSketchBuilder.ONLY_VISIBLE, tempVar2.getName()))));
            // assert out2;
            stmts.add(new StmtAssert(tempVar2, false));

            Statement body = new StmtBlock((FENode) null, stmts);

            fc.params(new ArrayList<>());
            fc.body(body);

            improvementBody = fc.create();
        }

        return improvementBody;
    }

    private Function getImprovementBody() {
        return commonBuilder.isUnderProblem ? getImprovementUnderBody() : getImprovementOverBody();
    }

    public Program improvementSketchCode(PropertySet psi, Property phi, Collection<Function> lambdaFunctions) {
        final String pkgName = CommonSketchBuilder.pkgName;
        List<ExprVar> vars = new ArrayList<ExprVar>();
        List<StmtSpAssert> specialAsserts = new ArrayList<StmtSpAssert>();
        List<sketch.compiler.ast.core.Package> namespaces = new ArrayList<sketch.compiler.ast.core.Package>();

        Program prog = Program.emptyProgram();

        List<StructDef> structs = commonBuilder.getStructDefinitions();
        List<Function> funcs = new ArrayList<Function>(commonBuilder.getFunctions());

        funcs.addAll(commonBuilder.getExampleGenerators());
        funcs.addAll(psi.toSketchCode());
        funcs.add(phi.toSketchCode());
        funcs.add(getImprovementBody());
        funcs.addAll(lambdaFunctions);

        funcs.forEach(func -> func.setPkg(pkgName));
        structs.forEach(struct -> struct.setPkg(pkgName));

        sketch.compiler.ast.core.Package pkg = new Package((FENode) null, pkgName, structs, vars, funcs, specialAsserts);
        namespaces.add(pkg);

        return prog.creator().streams(namespaces).create();
    }
}
