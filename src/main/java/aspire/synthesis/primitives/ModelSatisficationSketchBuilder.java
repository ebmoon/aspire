package aspire.synthesis.primitives;

import sketch.compiler.ast.core.FENode;
import sketch.compiler.ast.core.Function;
import sketch.compiler.ast.core.Package;
import sketch.compiler.ast.core.Program;
import sketch.compiler.ast.core.exprs.ExprVar;
import sketch.compiler.ast.core.stmts.StmtSpAssert;
import sketch.compiler.ast.core.typs.StructDef;
import aspire.synthesis.Example;
import aspire.synthesis.Property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ModelSatisficationSketchBuilder {
    final CommonSketchBuilder commonBuilder;
    public ModelSatisficationSketchBuilder(CommonSketchBuilder commonSketchBuilder) {
        this.commonBuilder = commonSketchBuilder;
    }
//    static Statement findStatement(List<Statement> stmts, String funName) {
//        for (Statement stmt: stmts) {
//            if (stmt instanceof StmtExpr) {
//                Expression expr = ((StmtExpr) stmt).getExpression();
//                if (expr instanceof ExprFunCall) {
//                    ExprFunCall funCall = (ExprFunCall) expr;
//                    if (Objects.equals(funCall.getName(), funName))
//                        return stmt;
//                }
//            }
//        }
//        throw new ResultExtractException(String.format("Cannot find function call %s in the code", funName));
//    }
//    Function modifyExampleCode(Example ex) {
//        Function code = ex.toSketchCode("pos");
//        Statement stmt = findStatement(((StmtBlock) code.getBody()).getStmts(), Property.newPhiID);
//        stmt.
//    }

    public Program modelSatisficationCode(Property phi, Example ex, Collection<Function> lambdaFunctions) {
        final String pkgName = CommonSketchBuilder.pkgName;
        List<ExprVar> vars = new ArrayList<ExprVar>();
        List<StmtSpAssert> specialAsserts = new ArrayList<StmtSpAssert>();
        List<Package> namespaces = new ArrayList<Package>();

        Program prog = Program.emptyProgram();

        List<StructDef> structs = commonBuilder.getStructDefinitions();
        List<Function> funcs = new ArrayList<Function>(commonBuilder.getFunctions());

        funcs.add(phi.toSketchCode(Property.newPhiID));
        funcs.add(ex.toSketchCode("pos"));
        funcs.addAll(commonBuilder.getExampleGenerators());
        funcs.addAll(lambdaFunctions);

        funcs.forEach(func -> func.setPkg(pkgName));
        structs.forEach(struct -> struct.setPkg(pkgName));

        Package pkg = new Package((FENode) null, pkgName, structs, vars, funcs, specialAsserts);
        namespaces.add(pkg);

        return prog.creator().streams(namespaces).create();
    }

}
