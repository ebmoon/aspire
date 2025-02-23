package aspire.util.cli;

import sketch.util.cli.SketchCliParser;

/**
 * CLI parser for Spyro.
 * It extends SketchCliParser with additional options.
 *
 * @author Kanghee Park &lt;khpark@cs.wisc.edu&gt;
 */
public class SpyroCliParser extends SketchCliParser {
    public SpyroCliParser(String[] args, String usage, boolean errorOnUnknown) {
        super(args, usage, errorOnUnknown);
    }

    public SpyroCliParser(String[] inArgs) {
        super(inArgs);
    }

    public SpyroCliParser(String[] array, boolean errorOnUnknown) {
        super(array, errorOnUnknown);
    }

    @Override
    public void printHelpAndExit(String error_msg) {
        System.out.println("\n\n[ERROR] [SPYRO] " + error_msg);
        super.printHelpAndExit("");
    }
}
