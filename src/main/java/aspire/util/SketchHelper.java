package aspire.util;

import sketch.compiler.ast.core.Program;
import sketch.compiler.main.cmdline.SketchOptions;
import sketch.compiler.main.passes.CleanupFinalCode;
import sketch.compiler.main.passes.SubstituteSolution;
import sketch.compiler.main.seq.SequentialSketchMain;
import sketch.util.exceptions.SketchNotResolvedException;

import java.io.OutputStream;
import java.io.PrintStream;

public class SketchHelper extends SequentialSketchMain {

    boolean isVerbose;
    boolean isSketchVerbose;
    final private PrintStream oldErr = System.err;
    final private PrintStream oldOut = System.out;
    public SketchHelper(SketchOptions options) {
        super(options);
        this.isVerbose = this.options.debugOpts.verbosity > 1;
        this.isSketchVerbose = this.options.debugOpts.verbosity > 2;
        if (isSketchVerbose)
            this.options.debugOpts.verbosity = this.options.debugOpts.verbosity - 1;
    }
    void redirectStderrToNull() {
        System.setErr(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                // DO NOTHING
            }
        }));
    }

    void redirectStdoutToNull() {
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                // DO NOTHING
            }
        }));
    }

    void restoreStderr() {
        System.setErr(oldErr);
    }

    void restoreStdout() {
        System.setOut(oldOut);
    }

    public Program parseProg() {
        return this.parseProgram();
    }


    public SequentialSketchMain.SynthesisResult runSketchSolver(Program prog) {
//        if (options.debugOpts.dumpSketch) {
//            File path = new File(getNewTempFilePath());
//            prog.debugDump(path);
//        }

        prog = preprocAndSemanticCheck(prog);

        // Redirect error message to null from sketch-backend
        if (!isVerbose)
            redirectStderrToNull();

        if (!isSketchVerbose)
            redirectStdoutToNull();

        SequentialSketchMain.SynthesisResult result;
        try {
            result = partialEvalAndSolve(prog);
        } catch (SketchNotResolvedException e) {
            result = null;
        }

        // Restore stderr so that user can see spyro error message
        if (!isVerbose)
            restoreStderr();

        if (!isSketchVerbose)
            restoreStdout();

//        innerIterator++;

        return result;
    }

    public Program simplifySynthResult(SynthesisResult synthResult) {
        Program finalCleaned = synthResult.lowered.highLevelC;
        Program substituted = (new SubstituteSolution(varGen, options, synthResult.solution))
                .visitProgram(finalCleaned);
        return (new CleanupFinalCode(varGen, options, visibleRControl(finalCleaned)))
                .visitProgram(substituted);
    }

    public Program runAndSimplify(Program sketchCode) {
        SynthesisResult synthResult = runSketchSolver(sketchCode);
        if (synthResult != null && synthResult.solution != null) {
            return simplifySynthResult(synthResult);
        } else return null;
    }

}
