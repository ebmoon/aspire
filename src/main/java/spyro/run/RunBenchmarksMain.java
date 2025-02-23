package spyro.run;

import sketch.compiler.main.other.ErrorHandling;
import sketch.util.exceptions.SketchException;
import spyro.synthesis.RunningResults;
import spyro.synthesis.main.Spyro;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RunBenchmarksMain {

    static List<BenchmarkInfo> specOver = new ArrayList<>(
            Arrays.asList(
                    new BenchmarkInfo("max2", "examples/spec/sygus/max2.sp", "examples/spec/sygus/max2.sk", BenchmarkInfo.OVER),
                    new BenchmarkInfo("max3", "examples/spec/sygus/max3.sp", "examples/spec/sygus/max3.sk", BenchmarkInfo.OVER),
//                    new BenchmarkInfo("max4", "examples/spec/sygus/max4.sp", "examples/spec/sygus/max4.sk", BenchmarkInfo.OVER),
//                    new BenchmarkInfo("max5", "examples/spec/sygus/max5.sp", "examples/spec/sygus/max5.sk", BenchmarkInfo.OVER),
                    new BenchmarkInfo("array_search_2", "examples/spec/sygus/array_search_2.sp", "examples/spec/sygus/array_search_2.sk", BenchmarkInfo.OVER),
//                    new BenchmarkInfo("array_search_3", "examples/spec/sygus/array_search_3.sp", "examples/spec/sygus/array_search_3.sk", BenchmarkInfo.OLD_OVER),
                    new BenchmarkInfo("diff", "examples/spec/sygus/diff.sp", "examples/spec/sygus/diff.sk", BenchmarkInfo.OVER),
                    new BenchmarkInfo("abs1", "examples/spec/LIA/abs1.sp", "examples/spec/LIA/abs1.sk", BenchmarkInfo.OVER),
                    new BenchmarkInfo("abs2", "examples/spec/LIA/abs2.sp", "examples/spec/LIA/abs2.sk", BenchmarkInfo.OVER, 5, 5,10),
                    new BenchmarkInfo("linearSum1", "examples/spec/arithmetic/linearSum1.sp", "examples/spec/arithmetic/linearSum.sk", BenchmarkInfo.OVER),
                    new BenchmarkInfo("linearSum2", "examples/spec/arithmetic/linearSum2.sp", "examples/spec/arithmetic/linearSum.sk", BenchmarkInfo.OVER,5,7,5),
                    new BenchmarkInfo("nonLinearSum1", "examples/spec/arithmetic/nonLinearSum1.sp", "examples/spec/arithmetic/nonLinearSum.sk", BenchmarkInfo.OVER),
                    new BenchmarkInfo("nonLinearSum2", "examples/spec/arithmetic/nonLinearSum2.sp", "examples/spec/arithmetic/nonLinearSum.sk", BenchmarkInfo.OVER, 5, 10,5)
            )
    );

    static List<BenchmarkInfo> specOverOld = new ArrayList<>(
            Arrays.asList(
                    new BenchmarkInfo("max2", "examples/spec/sygus/max2.sp", "examples/spec/sygus/max2.sk", BenchmarkInfo.OLD_OVER),
                    new BenchmarkInfo("max3", "examples/spec/sygus/max3.sp", "examples/spec/sygus/max3.sk", BenchmarkInfo.OLD_OVER),
//                    new BenchmarkInfo("max4", "examples/spec/sygus/max4.sp", "examples/spec/sygus/max4.sk", BenchmarkInfo.OVER),
//                    new BenchmarkInfo("max5", "examples/spec/sygus/max5.sp", "examples/spec/sygus/max5.sk", BenchmarkInfo.OVER)
                    new BenchmarkInfo("array_search_2", "examples/spec/sygus/array_search_2.sp", "examples/spec/sygus/array_search_2.sk", BenchmarkInfo.OLD_OVER),
//                    new BenchmarkInfo("array_search_3", "examples/spec/sygus/array_search_3.sp", "examples/spec/sygus/array_search_3.sk", BenchmarkInfo.OLD_OVER),
                    new BenchmarkInfo("diff", "examples/spec/sygus/diff.sp", "examples/spec/sygus/diff.sk", BenchmarkInfo.OLD_OVER),
                    new BenchmarkInfo("abs1", "examples/spec/LIA/abs1.sp", "examples/spec/LIA/abs1.sk", BenchmarkInfo.OLD_OVER),
                    new BenchmarkInfo("abs2", "examples/spec/LIA/abs2.sp", "examples/spec/LIA/abs2.sk", BenchmarkInfo.OLD_OVER, 5, 5, 10),
                    new BenchmarkInfo("linearSum1", "examples/spec/arithmetic/linearSum1.sp", "examples/spec/arithmetic/linearSum.sk", BenchmarkInfo.OLD_OVER),
                    new BenchmarkInfo("linearSum2", "examples/spec/arithmetic/linearSum2.sp", "examples/spec/arithmetic/linearSum.sk", BenchmarkInfo.OLD_OVER, 5, 5, 7),
                    new BenchmarkInfo("nonLinearSum1", "examples/spec/arithmetic/nonLinearSum1.sp", "examples/spec/arithmetic/nonLinearSum.sk", BenchmarkInfo.OLD_OVER),
                    new BenchmarkInfo("nonLinearSum2", "examples/spec/arithmetic/nonLinearSum2.sp", "examples/spec/arithmetic/nonLinearSum.sk", BenchmarkInfo.OLD_OVER, 5, 5, 10)
            )
    );

    static List<BenchmarkInfo> specUnder = new ArrayList<>(
            Arrays.asList(
//                    new BenchmarkInfo("max2", "examples/spec/sygus/max2-under.sp", "examples/spec/sygus/max2.sk", BenchmarkInfo.UNDER),
//                    new BenchmarkInfo("max3", "examples/spec/sygus/max3-under.sp", "examples/spec/sygus/max3.sk", BenchmarkInfo.UNDER),
//                    new BenchmarkInfo("max4", "examples/spec/sygus/max4-under.sp", "examples/spec/sygus/max4.sk", BenchmarkInfo.UNDER),
//                    new BenchmarkInfo("max5", "examples/spec/sygus/max5-under.sp", "examples/spec/sygus/max5.sk", BenchmarkInfo.UNDER),
//                    new BenchmarkInfo("array_search_2", "examples/spec/sygus/array_search_2-under.sp", "examples/spec/sygus/array_search_2.sk", BenchmarkInfo.UNDER),
//                    new BenchmarkInfo("array_search_3", "examples/spec/sygus/array_search_3-under.sp", "examples/spec/sygus/array_search_3.sk", BenchmarkInfo.UNDER),
//                    new BenchmarkInfo("diff", "examples/spec/sygus/diff-under.sp", "examples/spec/sygus/diff.sk", BenchmarkInfo.UNDER),
                    new BenchmarkInfo("abs1", "examples/spec/LIA/abs1-under.sp", "examples/spec/LIA/abs1.sk", BenchmarkInfo.UNDER),
                    new BenchmarkInfo("abs2", "examples/spec/LIA/abs2-under.sp", "examples/spec/LIA/abs2.sk", BenchmarkInfo.UNDER, 5, 5,10),
                    new BenchmarkInfo("linearSum1", "examples/spec/arithmetic/linearSum1-under.sp", "examples/spec/arithmetic/linearSum.sk", BenchmarkInfo.UNDER),
                    new BenchmarkInfo("linearSum2", "examples/spec/arithmetic/linearSum2-under.sp", "examples/spec/arithmetic/linearSum.sk", BenchmarkInfo.UNDER, 5, 7,10),
                    new BenchmarkInfo("nonLinearSum1", "examples/spec/arithmetic/nonLinearSum1-under.sp", "examples/spec/arithmetic/nonLinearSum.sk", BenchmarkInfo.UNDER),
                    new BenchmarkInfo("nonLinearSum2", "examples/spec/arithmetic/nonLinearSum2-under.sp", "examples/spec/arithmetic/nonLinearSum.sk", BenchmarkInfo.UNDER, 5, 8,10)
            )
    );
    ;
    static List<BenchmarkInfo> specOldOver = new ArrayList<>(
            Arrays.asList(
                    new BenchmarkInfo("max2", "examples/spec/sygus/max2.sp", "examples/spec/sygus/max2.sk", BenchmarkInfo.OLD_OVER),
                    new BenchmarkInfo("max3", "examples/spec/sygus/max3.sp", "examples/spec/sygus/max3.sk", BenchmarkInfo.OLD_OVER),
//                    new BenchmarkInfo("max4", "examples/spec/sygus/max4.sp", "examples/spec/sygus/max4.sk", BenchmarkInfo.OLD_OVER)
//                        new BenchmarkInfo("max5", "examples/spec/sygus/max5.sp", "examples/spec/sygus/max5.sk", BenchmarkInfo.OLD_OVER), // timeout
                    new BenchmarkInfo("array_search_2", "examples/spec/sygus/array_search_2.sp", "examples/spec/sygus/array_search_2.sk", BenchmarkInfo.OLD_OVER),
                    new BenchmarkInfo("diff", "examples/spec/sygus/diff.sp", "examples/spec/sygus/diff.sk", BenchmarkInfo.OLD_OVER),
                    new BenchmarkInfo("abs1", "examples/spec/LIA/abs1.sp", "examples/spec/LIA/abs1.sk", BenchmarkInfo.OLD_OVER),
                    new BenchmarkInfo("abs2", "examples/spec/LIA/abs2.sp", "examples/spec/LIA/abs2.sk", BenchmarkInfo.OLD_OVER, 5, 5, 7),
                    new BenchmarkInfo("linearSum1", "examples/spec/arithmetic/linearSum1.sp", "examples/spec/arithmetic/linearSum.sk", BenchmarkInfo.OLD_OVER),
                    new BenchmarkInfo("linearSum2", "examples/spec/arithmetic/linearSum2.sp", "examples/spec/arithmetic/linearSum.sk", BenchmarkInfo.OLD_OVER, 5, 5, 7),
                    new BenchmarkInfo("nonLinearSum1", "examples/spec/arithmetic/nonLinearSum1.sp", "examples/spec/arithmetic/nonLinearSum.sk", BenchmarkInfo.OLD_OVER),
                    new BenchmarkInfo("nonLinearSum2", "examples/spec/arithmetic/nonLinearSum2.sp", "examples/spec/arithmetic/nonLinearSum.sk", BenchmarkInfo.OLD_OVER, 5, 5, 8)
            )
    );

    static List<BenchmarkInfo> nondeterOver = new ArrayList<>(
            Arrays.asList(
                    new BenchmarkInfo("shuffle3", "examples/new/nondeter/shuffle3.sp", "examples/new/nondeter/shuffle3.sk", BenchmarkInfo.OVER, 5, 10, 7),
                    new BenchmarkInfo("shuffle4", "examples/new/nondeter/shuffle4.sp", "examples/new/nondeter/shuffle4.sk", BenchmarkInfo.OVER, 5, 12, 7),
                    new BenchmarkInfo("shuffle5", "examples/new/nondeter/shuffle5.sp", "examples/new/nondeter/shuffle5.sk", BenchmarkInfo.OVER, 5, 16, 7)
//                    new BenchmarkInfo("rsum", "examples/new/nondeter/rsum-over.sp", "examples/new/nondeter/rsum.sk", BenchmarkInfo.OVER, 10, 5, 7),
//                    new BenchmarkInfo("rsquaresum", "examples/new/nondeter/rsquaresum-over.sp", "examples/new/nondeter/rsquaresum.sk", BenchmarkInfo.OVER, 10, 5, 7),
//                    new BenchmarkInfo("rcubicsum", "examples/new/nondeter/rcubicsum-over.sp", "examples/new/nondeter/rcubicsum.sk", BenchmarkInfo.OVER, 10, 5, 7),
//                    new BenchmarkInfo("jain1", "examples/new/nondeter/jain1-over.sp", "examples/new/nondeter/jain1.sk", BenchmarkInfo.OVER,5, 10, 7),
//                    new BenchmarkInfo("jain2", "examples/new/nondeter/jain2-over.sp", "examples/new/nondeter/jain2.sk", BenchmarkInfo.OVER,5, 10, 7),
//                    new BenchmarkInfo("jain4", "examples/new/nondeter/jain4-over.sp", "examples/new/nondeter/jain4.sk", BenchmarkInfo.OVER,5, 10, 7),
//                    new BenchmarkInfo("jain6", "examples/new/nondeter/jain6-over.sp", "examples/new/nondeter/jain6.sk", BenchmarkInfo.OVER,5, 10, 7),
//                    new BenchmarkInfo("bubble3", "examples/new/nondeter/bubble3-over.sp", "examples/new/nondeter/bubble3.sk", BenchmarkInfo.OVER, 5, 10, 7),
//                    new BenchmarkInfo("bubble4", "examples/new/nondeter/bubble4-over.sp", "examples/new/nondeter/bubble4.sk", BenchmarkInfo.OVER, 5, 10, 7),
//                    new BenchmarkInfo("swap3", "examples/new/nondeter/swap3-over.sp", "examples/new/nondeter/swap3.sk", BenchmarkInfo.OVER, 5, 10, 7),
//                    new BenchmarkInfo("swap4", "examples/new/nondeter/swap4-over.sp", "examples/new/nondeter/swap4.sk", BenchmarkInfo.OVER, 5, 10, 7)
//
//                    new BenchmarkInfo("math1", "examples/new/nondeter/math1-over.sp", "examples/new/nondeter/math.sk", BenchmarkInfo.OVER,5, 5, 7),
//                    new BenchmarkInfo("math2", "examples/new/nondeter/math2-over.sp", "examples/new/nondeter/math.sk", BenchmarkInfo.OVER, 5, 5, 7),
//                    new BenchmarkInfo("math3", "examples/new/nondeter/math3-over.sp", "examples/new/nondeter/math.sk", BenchmarkInfo.OVER, 5, 5, 7),
//                    new BenchmarkInfo("math4", "examples/new/nondeter/math4-over.sp", "examples/new/nondeter/math.sk", BenchmarkInfo.OVER, 5, 5, 7),
//                    new BenchmarkInfo("bv1", "examples/new/nondeter/bv1-over.sp", "examples/new/nondeter/bv.sk", BenchmarkInfo.OVER),
//                    new BenchmarkInfo("bv2", "examples/new/nondeter/bv2-over.sp", "examples/new/nondeter/bv.sk", BenchmarkInfo.OVER),
//                    new BenchmarkInfo("bv3-1", "examples/new/nondeter/bv3-1-over.sp", "examples/new/nondeter/bv.sk", BenchmarkInfo.OVER),
//                    new BenchmarkInfo("bv3-2", "examples/new/nondeter/bv3-2-over.sp", "examples/new/nondeter/bv.sk", BenchmarkInfo.OVER),
//                    new BenchmarkInfo("bv4", "examples/new/nondeter/bv4-over.sp", "examples/new/nondeter/bv.sk", BenchmarkInfo.OVER)
            )

    );

    static List<BenchmarkInfo> nondeterOverOld = new ArrayList<>(
            Arrays.asList(
                    new BenchmarkInfo("bubble3", "examples/new/nondeter/bubble3-over.sp", "examples/new/nondeter/bubble3.sk",BenchmarkInfo.OLD_OVER,5,10,7),
                    new BenchmarkInfo("bubble4", "examples/new/nondeter/bubble4-over.sp", "examples/new/nondeter/bubble4.sk",BenchmarkInfo.OLD_OVER,5,10,7),
                    new BenchmarkInfo("swap3", "examples/new/nondeter/swap3-over.sp", "examples/new/nondeter/swap3.sk", BenchmarkInfo.OLD_OVER, 5, 10, 7),
                    new BenchmarkInfo("swap4", "examples/new/nondeter/swap4-over.sp", "examples/new/nondeter/swap4.sk", BenchmarkInfo.OLD_OVER, 5, 10, 7),
                    new BenchmarkInfo("math1", "examples/new/nondeter/math1-over.sp", "examples/new/nondeter/math.sk", BenchmarkInfo.OVER,5, 5, 7),
                    new BenchmarkInfo("math2", "examples/new/nondeter/math2-over.sp", "examples/new/nondeter/math.sk", BenchmarkInfo.OVER, 5, 5, 7),
                    new BenchmarkInfo("math3", "examples/new/nondeter/math3-over.sp", "examples/new/nondeter/math.sk", BenchmarkInfo.OVER, 5, 5, 7),
                    new BenchmarkInfo("math4", "examples/new/nondeter/math4-over.sp", "examples/new/nondeter/math.sk", BenchmarkInfo.OVER, 5, 5, 7),
                    new BenchmarkInfo("bv1", "examples/new/nondeter/bv1-over.sp", "examples/new/nondeter/bv.sk", BenchmarkInfo.OVER),
                    new BenchmarkInfo("bv2", "examples/new/nondeter/bv2-over.sp", "examples/new/nondeter/bv.sk", BenchmarkInfo.OVER),
                    new BenchmarkInfo("bv3-1", "examples/new/nondeter/bv3-1-over.sp", "examples/new/nondeter/bv.sk", BenchmarkInfo.OVER),
                    new BenchmarkInfo("bv3-2", "examples/new/nondeter/bv3-2-over.sp", "examples/new/nondeter/bv.sk", BenchmarkInfo.OVER)
//                    new BenchmarkInfo("bv4", "examples/new/nondeter/bv4-over.sp", "examples/new/nondeter/bv.sk", BenchmarkInfo.OVER)
            )
    );

    static List<BenchmarkInfo> nondeterUnder = new ArrayList<>(
            Arrays.asList(
                    new BenchmarkInfo("shuffle3", "examples/new/nondeter/shuffle3.sp", "examples/new/nondeter/shuffle3.sk", BenchmarkInfo.UNDER, 5, 10, 7),
                    new BenchmarkInfo("shuffle4", "examples/new/nondeter/shuffle4.sp", "examples/new/nondeter/shuffle4.sk", BenchmarkInfo.UNDER, 5, 12, 7),
                    new BenchmarkInfo("shuffle5", "examples/new/nondeter/shuffle5.sp", "examples/new/nondeter/shuffle5.sk", BenchmarkInfo.UNDER, 5, 16, 7)
//                    new BenchmarkInfo("rsum", "examples/new/nondeter/rsum-under.sp", "examples/new/nondeter/rsum.sk", BenchmarkInfo.UNDER, 10, 5, 7),
//                    new BenchmarkInfo("rsquaresum", "examples/new/nondeter/rsquaresum-under.sp", "examples/new/nondeter/rsquaresum.sk", BenchmarkInfo.UNDER, 10, 5, 7),
//                    new BenchmarkInfo("rcubicsum", "examples/new/nondeter/rcubicsum-under.sp", "examples/new/nondeter/rcubicsum.sk", BenchmarkInfo.UNDER, 10, 5, 7),
//                    new BenchmarkInfo("jain1", "examples/new/nondeter/jain1-under.sp", "examples/new/nondeter/jain1.sk", BenchmarkInfo.UNDER,5, 10, 7),
//                    new BenchmarkInfo("jain2", "examples/new/nondeter/jain2-under.sp", "examples/new/nondeter/jain2.sk", BenchmarkInfo.UNDER,5, 10, 7),
//                    new BenchmarkInfo("jain4", "examples/new/nondeter/jain4-under.sp", "examples/new/nondeter/jain4.sk", BenchmarkInfo.UNDER,5, 10, 7),
//                    new BenchmarkInfo("jain6", "examples/new/nondeter/jain6-under.sp", "examples/new/nondeter/jain6.sk", BenchmarkInfo.UNDER,5, 10, 7),
//                    new BenchmarkInfo("bubble3", "examples/new/nondeter/bubble3-under.sp", "examples/new/nondeter/bubble3.sk", BenchmarkInfo.UNDER, 5, 10, 7),
//                    new BenchmarkInfo("bubble4", "examples/new/nondeter/bubble4-under.sp", "examples/new/nondeter/bubble4.sk", BenchmarkInfo.UNDER, 5, 10, 7),
//                    new BenchmarkInfo("swap3", "examples/new/nondeter/swap3-under.sp", "examples/new/nondeter/swap3.sk", BenchmarkInfo.UNDER, 5, 10, 7),
//                    new BenchmarkInfo("swap4", "examples/new/nondeter/swap4-under.sp", "examples/new/nondeter/swap4.sk", BenchmarkInfo.UNDER, 5, 10, 7)
//                    new BenchmarkInfo("hashfunc", "examples/new/inclogic/hashfunc.sp", "examples/new/inclogic/hashfunc.sk", BenchmarkInfo.UNDER, 5, 10, 7),
//                    new BenchmarkInfo("coin", "examples/new/inclogic/coin.sp", "examples/new/inclogic/coin.sk", BenchmarkInfo.UNDER, 10, 10, 7),
//                    new BenchmarkInfo("inc-logic-wpp1", "examples/new/inclogic/inc-logic-wpp1.sp", "examples/new/inclogic/inc-logic-wpp1.sk", BenchmarkInfo.UNDER),
//                    new BenchmarkInfo("inc-logic-wpp2", "examples/new/inclogic/inc-logic-wpp2.sp", "examples/new/inclogic/inc-logic-wpp2.sk", BenchmarkInfo.UNDER),
//                    new BenchmarkInfo("inc-logic-wpp3", "examples/new/inclogic/inc-logic-wpp3.sp", "examples/new/inclogic/inc-logic-wpp3.sk", BenchmarkInfo.UNDER)
//                    new BenchmarkInfo("math1", "examples/new/nondeter/math1-under.sp", "examples/new/nondeter/math.sk", BenchmarkInfo.UNDER,5,  5, 7),
//                    new BenchmarkInfo("math2", "examples/new/nondeter/math2-under.sp", "examples/new/nondeter/math.sk", BenchmarkInfo.UNDER,5,  5, 7),
//                    new BenchmarkInfo("math3", "examples/new/nondeter/math3-under.sp", "examples/new/nondeter/math.sk", BenchmarkInfo.UNDER, 5, 5, 7),
//                    new BenchmarkInfo("math4", "examples/new/nondeter/math4-under.sp", "examples/new/nondeter/math.sk", BenchmarkInfo.UNDER, 5, 5, 7),
//                    new BenchmarkInfo("bv1", "examples/new/nondeter/bv1-under.sp", "examples/new/nondeter/bv.sk", BenchmarkInfo.UNDER),
//                    new BenchmarkInfo("bv2", "examples/new/nondeter/bv2-under.sp", "examples/new/nondeter/bv.sk", BenchmarkInfo.UNDER),
//                    new BenchmarkInfo("bv3-1", "examples/new/nondeter/bv3-1-under.sp", "examples/new/nondeter/bv.sk", BenchmarkInfo.UNDER),
//                    new BenchmarkInfo("bv3-2", "examples/new/nondeter/bv3-2-under.sp", "examples/new/nondeter/bv.sk", BenchmarkInfo.UNDER),
//                    new BenchmarkInfo("bv4", "examples/new/nondeter/bv4-under.sp", "examples/new/nondeter/bv.sk", BenchmarkInfo.UNDER)
            )
    );
    static List<BenchmarkInfo> concurrencyOver = new ArrayList<>(
            Arrays.asList(
                    new BenchmarkInfo("philosopher", "examples/new/concurrency/philosopher1-over.sp", "examples/new/concurrency/philosopher1.sk", BenchmarkInfo.OVER, 5, 15, 5),
                    new BenchmarkInfo("race1", "examples/new/concurrency/race1-over.sp", "examples/new/concurrency/race1.sk", BenchmarkInfo.OVER, 5, 10, 5),
                    new BenchmarkInfo("race2", "examples/new/concurrency/race2-over.sp", "examples/new/concurrency/race2.sk", BenchmarkInfo.OVER, 5, 15, 5),
                    new BenchmarkInfo("race3", "examples/new/concurrency/race3-over.sp", "examples/new/concurrency/race3.sk", BenchmarkInfo.OVER, 5, 20, 5),
                    new BenchmarkInfo("resource1", "examples/new/concurrency/resource1-over.sp", "examples/new/concurrency/resource1.sk", BenchmarkInfo.OVER, 5, 5, 5),
                    new BenchmarkInfo("resource2", "examples/new/concurrency/resource2-over.sp", "examples/new/concurrency/resource2.sk", BenchmarkInfo.OVER, 5, 10, 5),
                    new BenchmarkInfo("resource3", "examples/new/concurrency/resource3-over.sp", "examples/new/concurrency/resource3.sk", BenchmarkInfo.OVER, 5, 20, 5),
                    new BenchmarkInfo("resource4", "examples/new/concurrency/resource4-over.sp", "examples/new/concurrency/resource4.sk", BenchmarkInfo.OVER, 5, 20, 5)
            )
    );

    static List<BenchmarkInfo> concurrencyUnder = new ArrayList<>(
            Arrays.asList(
                    new BenchmarkInfo("philosopher", "examples/new/concurrency/philosopher1-under.sp", "examples/new/concurrency/philosopher1.sk", BenchmarkInfo.UNDER, 5, 15, 5),
                    new BenchmarkInfo("race1", "examples/new/concurrency/race1-under.sp", "examples/new/concurrency/race1.sk", BenchmarkInfo.UNDER, 5, 10, 5),
                    new BenchmarkInfo("race2", "examples/new/concurrency/race2-under.sp", "examples/new/concurrency/race2.sk", BenchmarkInfo.UNDER, 5, 15, 5),
                    new BenchmarkInfo("race3", "examples/new/concurrency/race3-under.sp", "examples/new/concurrency/race3.sk", BenchmarkInfo.UNDER, 5, 20, 5),
                    new BenchmarkInfo("resource1", "examples/new/concurrency/resource1-under.sp", "examples/new/concurrency/resource1.sk", BenchmarkInfo.UNDER, 5, 5, 5),
                    new BenchmarkInfo("resource2", "examples/new/concurrency/resource2-under.sp", "examples/new/concurrency/resource2.sk", BenchmarkInfo.UNDER, 5, 10, 5),
                    new BenchmarkInfo("resource3", "examples/new/concurrency/resource3-under.sp", "examples/new/concurrency/resource3.sk", BenchmarkInfo.UNDER, 5, 20, 5),
                    new BenchmarkInfo("resource4", "examples/new/concurrency/resource4-under.sp", "examples/new/concurrency/resource4.sk", BenchmarkInfo.UNDER, 5, 20, 5)
            )
    );
    static List<BenchmarkInfo> incLogic = new ArrayList<>(
            Arrays.asList(
                    new BenchmarkInfo("inc-logic1", "examples/new/inclogic/inc-logic1.sp", "examples/new/inclogic/inc-logic1.sk", BenchmarkInfo.UNDER),
                    new BenchmarkInfo("inc-logic2", "examples/new/inclogic/inc-logic2.sp", "examples/new/inclogic/inc-logic2.sk", BenchmarkInfo.UNDER),
//                    new BenchmarkInfo("inc-logic3-0", "examples/new/inclogic/inc-logic3-0.sp", "examples/new/inclogic/inc-logic3.sk", BenchmarkInfo.UNDER),
                    new BenchmarkInfo("inc-logic3-1", "examples/new/inclogic/inc-logic3-1.sp", "examples/new/inclogic/inc-logic3.sk", BenchmarkInfo.UNDER),
//                    new BenchmarkInfo("inc-logic4-0", "examples/new/inclogic/inc-logic4-0.sp", "examples/new/inclogic/inc-logic4.sk", BenchmarkInfo.UNDER),
//                    new BenchmarkInfo("inc-logic4-1", "examples/new/inclogic/inc-logic4-1.sp", "examples/new/inclogic/inc-logic4.sk", BenchmarkInfo.UNDER),
                    new BenchmarkInfo("inc-logic-wpp1", "examples/new/inclogic/inc-logic-wpp1.sp", "examples/new/inclogic/inc-logic-wpp1.sk", BenchmarkInfo.UNDER),
                    new BenchmarkInfo("inc-logic-wpp2", "examples/new/inclogic/inc-logic-wpp2.sp", "examples/new/inclogic/inc-logic-wpp2.sk", BenchmarkInfo.UNDER),
                    new BenchmarkInfo("inc-logic-wpp3", "examples/new/inclogic/inc-logic-wpp3.sp", "examples/new/inclogic/inc-logic-wpp3.sk", BenchmarkInfo.UNDER),
                    new BenchmarkInfo("arith1-wr", "examples/new/inclogic/arith1-wr.sp", "examples/new/inclogic/arith1-wr.sk", BenchmarkInfo.UNDER),
                    new BenchmarkInfo("arith2-wr", "examples/new/inclogic/arith2-wr.sp", "examples/new/inclogic/arith2-wr.sk", BenchmarkInfo.UNDER),
                    new BenchmarkInfo("arith1-wpp", "examples/new/inclogic/arith1-wpp.sp", "examples/new/inclogic/arith1-wpp.sk", BenchmarkInfo.UNDER),
                    new BenchmarkInfo("arith2-wpp", "examples/new/inclogic/arith2-wpp.sp", "examples/new/inclogic/arith2-wpp.sk", BenchmarkInfo.UNDER),
                    new BenchmarkInfo("hashfunc", "examples/new/inclogic/hashfunc.sp", "examples/new/inclogic/hashfunc.sk", BenchmarkInfo.UNDER, 5, 10, 7),
                    new BenchmarkInfo("coin", "examples/new/inclogic/coin.sp", "examples/new/inclogic/coin.sk", BenchmarkInfo.UNDER, 10, 10, 7)

                    )
    );
    static List<BenchmarkInfo> gameOver = new ArrayList<>(
            Arrays.asList(
//                    new BenchmarkInfo("num1p", "examples/new/game/num1p-over.sp", "examples/new/game/num1p.sk", BenchmarkInfo.OVER, 5, 10, 7),
//                    new BenchmarkInfo("num2", "examples/new/game/num2-over.sp", "examples/new/game/num2.sk", BenchmarkInfo.OVER, 5, 10, 7),
//                    new BenchmarkInfo("rg", "examples/new/game/rg-over.sp", "examples/new/game/rg.sk", BenchmarkInfo.OVER, 5, 10, 7),
//                    new BenchmarkInfo("nim2", "examples/new/game/nim2-over.sp", "examples/new/game/nim2.sk", BenchmarkInfo.OVER, 5, 15  , 7),
                    new BenchmarkInfo("temp", "examples/new/game/temp-over.sp", "examples/new/game/temp.sk", BenchmarkInfo.OVER, 5, 20, 7)

            )
    );
    static List<BenchmarkInfo> gameUnder = new ArrayList<>(
            Arrays.asList(
                    new BenchmarkInfo("num1p", "examples/new/game/num1p-under.sp", "examples/new/game/num1p.sk", BenchmarkInfo.UNDER, 5, 10, 7),
                    new BenchmarkInfo("num2", "examples/new/game/num2-under.sp", "examples/new/game/num2.sk", BenchmarkInfo.UNDER, 5, 10, 7),
                    new BenchmarkInfo("rg", "examples/new/game/rg-under.sp", "examples/new/game/rg.sk", BenchmarkInfo.UNDER, 5, 10, 7),
                    new BenchmarkInfo("nim2", "examples/new/game/nim2-under.sp", "examples/new/game/nim2.sk", BenchmarkInfo.UNDER, 5, 15  , 7),
                    new BenchmarkInfo("temp", "examples/new/game/temp-under.sp", "examples/new/game/temp.sk", BenchmarkInfo.UNDER, 5, 20, 7)
            )
    );


    static List<BenchmarkInfo> listOver = new ArrayList<>(
            Arrays.asList(
                    new BenchmarkInfo("append", "examples/spec/list/append.sp", "examples/spec/list/append.sk", BenchmarkInfo.OVER, 10, 5, 7),
                    new BenchmarkInfo("delete", "examples/spec/list/delete.sp", "examples/spec/list/delete.sk", BenchmarkInfo.OVER, 10, 5, 7),
                    new BenchmarkInfo("deleteFirst", "examples/spec/list/deleteFirst.sp", "examples/spec/list/deleteFirst.sk", BenchmarkInfo.OVER, 10, 5, 7),
                    new BenchmarkInfo("drop", "examples/spec/list/drop.sp", "examples/spec/list/drop.sk", BenchmarkInfo.OVER, 10, 5, 7),
                    new BenchmarkInfo("elem", "examples/spec/list/elem.sp", "examples/spec/list/elem.sk", BenchmarkInfo.OVER, 10, 5, 7),
                    new BenchmarkInfo("elemIndex", "examples/spec/list/elemIndex.sp", "examples/spec/list/elemIndex.sk", BenchmarkInfo.OVER, 10, 5, 7),
                    new BenchmarkInfo("ith", "examples/spec/list/ith.sp", "examples/spec/list/ith.sk", BenchmarkInfo.OVER, 10, 5, 7),
                    new BenchmarkInfo("min", "examples/spec/list/min.sp", "examples/spec/list/min.sk", BenchmarkInfo.OVER, 10, 5, 7),
                    new BenchmarkInfo("replicate", "examples/spec/list/replicate.sp", "examples/spec/list/replicate.sk", BenchmarkInfo.OVER, 10, 5, 7),
                    new BenchmarkInfo("reverse", "examples/spec/list/reverse.sp", "examples/spec/list/reverse.sk", BenchmarkInfo.OVER, 10, 5, 7),
                    new BenchmarkInfo("reverse2", "examples/spec/list/reverse2.sp", "examples/spec/list/reverse.sk", BenchmarkInfo.OVER, 10, 5, 7),
                    new BenchmarkInfo("snoc", "examples/spec/list/snoc.sp", "examples/spec/list/snoc.sk", BenchmarkInfo.OVER, 10, 5, 7),
                    new BenchmarkInfo("shutter", "examples/spec/list/shutter.sp", "examples/spec/list/shutter.sk", BenchmarkInfo.OVER, 10, 5, 7),
                    new BenchmarkInfo("take", "examples/spec/list/take.sp", "examples/spec/list/take.sk", BenchmarkInfo.OVER, 10, 5, 7)
            )
    );

    static List<BenchmarkInfo> listUnder = new ArrayList<>(
            Arrays.asList(
                    new BenchmarkInfo("append", "examples/spec/list/append-under.sp", "examples/spec/list/append.sk", BenchmarkInfo.UNDER, 10,5, 7),
                    new BenchmarkInfo("delete", "examples/spec/list/delete-under.sp", "examples/spec/list/delete.sk", BenchmarkInfo.UNDER, 10,5, 7),
                    new BenchmarkInfo("deleteFirst", "examples/spec/list/deleteFirst-under.sp", "examples/spec/list/deleteFirst.sk", BenchmarkInfo.UNDER, 10,5, 7),
                    new BenchmarkInfo("drop", "examples/spec/list/drop-under.sp", "examples/spec/list/drop.sk", BenchmarkInfo.UNDER, 10,5, 7),
                    new BenchmarkInfo("elem", "examples/spec/list/elem-under.sp", "examples/spec/list/elem.sk", BenchmarkInfo.UNDER, 10,5, 7),
                    new BenchmarkInfo("elemIndex", "examples/spec/list/elemIndex-under.sp", "examples/spec/list/elemIndex.sk", BenchmarkInfo.UNDER, 10,5, 7),
                    new BenchmarkInfo("ith", "examples/spec/list/ith-under.sp", "examples/spec/list/ith.sk", BenchmarkInfo.UNDER, 10,5, 7),
                    new BenchmarkInfo("min", "examples/spec/list/min-under.sp", "examples/spec/list/min.sk", BenchmarkInfo.UNDER, 10, 5,7),
                    new BenchmarkInfo("replicate", "examples/spec/list/replicate-under.sp", "examples/spec/list/replicate.sk", BenchmarkInfo.UNDER, 10,5, 7),
                    new BenchmarkInfo("reverse", "examples/spec/list/reverse-under.sp", "examples/spec/list/reverse.sk", BenchmarkInfo.UNDER, 10, 5, 7),
                    new BenchmarkInfo("reverse2", "examples/spec/list/reverse2-under.sp", "examples/spec/list/reverse.sk", BenchmarkInfo.UNDER, 10,5,  7),
                    new BenchmarkInfo("snoc", "examples/spec/list/snoc-under.sp", "examples/spec/list/snoc.sk", BenchmarkInfo.UNDER, 10, 5, 7),
                    new BenchmarkInfo("shutter", "examples/spec/list/stutter-under.sp", "examples/spec/list/stutter.sk", BenchmarkInfo.UNDER, 10, 5, 7),
                    new BenchmarkInfo("take", "examples/spec/list/take-under.sp", "examples/spec/list/take.sk", BenchmarkInfo.UNDER, 10, 5, 7)
            )
    );

    static List<BenchmarkInfo> listOldOver = new ArrayList<>(
            Arrays.asList(
                    new BenchmarkInfo("append", "examples/spec/list/append.sp", "examples/spec/list/append.sk", BenchmarkInfo.OLD_OVER, 10, 5, 7),
                    new BenchmarkInfo("delete", "examples/spec/list/delete.sp", "examples/spec/list/delete.sk", BenchmarkInfo.OLD_OVER, 10, 5,7),
                    new BenchmarkInfo("deleteFirst", "examples/spec/list/deleteFirst.sp", "examples/spec/list/deleteFirst.sk", BenchmarkInfo.OLD_OVER, 10, 5,7),
                    new BenchmarkInfo("drop", "examples/spec/list/drop.sp", "examples/spec/list/drop.sk", BenchmarkInfo.OLD_OVER, 10, 5,7),
                    new BenchmarkInfo("elem", "examples/spec/list/elem.sp", "examples/spec/list/elem.sk", BenchmarkInfo.OLD_OVER, 10,5, 7),
                    new BenchmarkInfo("elemIndex", "examples/spec/list/elemIndex.sp", "examples/spec/list/elemIndex.sk", BenchmarkInfo.OLD_OVER, 10,5, 7),
                    new BenchmarkInfo("ith", "examples/spec/list/ith.sp", "examples/spec/list/ith.sk", BenchmarkInfo.OLD_OVER, 10,5, 7),
                    new BenchmarkInfo("min", "examples/spec/list/min.sp", "examples/spec/list/min.sk", BenchmarkInfo.OLD_OVER, 10,5, 7),
                    new BenchmarkInfo("replicate", "examples/spec/list/replicate.sp", "examples/spec/list/replicate.sk", BenchmarkInfo.OLD_OVER, 10, 5,7),
                    new BenchmarkInfo("reverse", "examples/spec/list/reverse.sp", "examples/spec/list/reverse.sk", BenchmarkInfo.OLD_OVER, 10,5, 7),
                    new BenchmarkInfo("reverse2", "examples/spec/list/reverse2.sp", "examples/spec/list/reverse.sk", BenchmarkInfo.OLD_OVER, 10,5, 7),
                    new BenchmarkInfo("snoc", "examples/spec/list/snoc.sp", "examples/spec/list/snoc.sk", BenchmarkInfo.OLD_OVER, 10, 5,7),
                    new BenchmarkInfo("shutter", "examples/spec/list/shutter.sp", "examples/spec/list/shutter.sk", BenchmarkInfo.OLD_OVER, 10, 5,7),
                    new BenchmarkInfo("take", "examples/spec/list/take.sp", "examples/spec/list/take.sk", BenchmarkInfo.OLD_OVER, 10,5, 7)
            )
    );

    static List<BenchmarkInfo> queueOver = new ArrayList<>(
            Arrays.asList(
                    new BenchmarkInfo("empty", "examples/spec/queue/empty.sp", "examples/spec/queue/queue.sk", BenchmarkInfo.OVER),
                    new BenchmarkInfo("enqueue", "examples/spec/queue/enqueue.sp", "examples/spec/queue/queue.sk", BenchmarkInfo.OVER),
                    new BenchmarkInfo("dequeue", "examples/spec/queue/dequeue.sp", "examples/spec/queue/queue.sk", BenchmarkInfo.OVER)
            )
    );

    static List<BenchmarkInfo> queueUnder = new ArrayList<>(
            Arrays.asList(
                    new BenchmarkInfo("empty", "examples/spec/queue/empty-under.sp", "examples/spec/queue/queue.sk", BenchmarkInfo.UNDER),
                    new BenchmarkInfo("enqueue", "examples/spec/queue/enqueue-under.sp", "examples/spec/queue/queue.sk", BenchmarkInfo.UNDER),
                    new BenchmarkInfo("dequeue", "examples/spec/queue/dequeue-under.sp", "examples/spec/queue/queue.sk", BenchmarkInfo.UNDER)
            )
    );

    static List<BenchmarkInfo> stackOver = new ArrayList<>(
            Arrays.asList(
                    new BenchmarkInfo("empty", "examples/spec/stack/empty.sp", "examples/spec/stack/stack.sk", BenchmarkInfo.OVER, 10, 5, 7),
                    new BenchmarkInfo("pop", "examples/spec/stack/pop.sp", "examples/spec/stack/stack.sk", BenchmarkInfo.OVER, 10, 5, 7),
                    new BenchmarkInfo("push", "examples/spec/stack/push.sp", "examples/spec/stack/stack.sk", BenchmarkInfo.OVER, 10, 5, 7),
                    new BenchmarkInfo("push_pop", "examples/spec/stack/push_pop.sp", "examples/spec/stack/stack.sk", BenchmarkInfo.OVER, 10, 5, 7)
            )
    );

    static List<BenchmarkInfo> stackUnder = new ArrayList<>(
            Arrays.asList(
                    new BenchmarkInfo("empty", "examples/spec/stack/empty-under.sp", "examples/spec/stack/stack.sk", BenchmarkInfo.OVER, 10, 5, 7),
                    new BenchmarkInfo("pop", "examples/spec/stack/pop-under.sp", "examples/spec/stack/stack.sk", BenchmarkInfo.OVER, 10, 5, 7),
                    new BenchmarkInfo("push", "examples/spec/stack/push-under.sp", "examples/spec/stack/stack.sk", BenchmarkInfo.OVER, 10, 5, 7),
                    new BenchmarkInfo("push_pop", "examples/spec/stack/push_pop-under.sp", "examples/spec/stack/stack.sk", BenchmarkInfo.OVER, 10, 5, 7)
            )
    );


    final static String resultDir = "./result/";

    final static int[] seed = new int[]{2333, 6666, 89805};

    public RunBenchmarksMain() {
    }

    public static void main(String[] arguments) {
        final RunBenchmarksMain runBenchmarksMain = new RunBenchmarksMain();

        boolean run1 = false, run2 = false, run3 = false, run4 = false;
        if (arguments.length == 0) {
            run1 = true;
            run2 = true;
            run3 = true;
            run4 = true;
        }
        else {
            assert arguments.length == 1;
            for (String arg : arguments) {
                switch (arguments[0]) {
                    case "-1":
                        run1 = true;
                        break;
                    case "-2":
                        run2 = true;
                        break;
                    case "-3":
                        run3 =true;
                        break;
                    case "-4":
                        run4 = true;
                        break;
                    default:
                        System.out.println("Unknown argument:" + arg);
                        break;
                }
            }
        }


        if (run1) {
            // 1 - 1
            runBenchmarksMain.writeCSV("specOver", specOver, true);
            runBenchmarksMain.writeCSV("specUnder", specUnder, true);

            runBenchmarksMain.writeCSV("listOver", listOver, true);
            runBenchmarksMain.writeCSV("listUnder", listUnder, true);
            runBenchmarksMain.writeCSV("queueOver", queueOver, true);
            runBenchmarksMain.writeCSV("queueUnder", queueUnder, true);
            runBenchmarksMain.writeCSV("stackOver", stackOver, true);
            runBenchmarksMain.writeCSV("stackUnder", stackUnder, true);


            // 1 - 2
            runBenchmarksMain.writeCSV("NondeterUnder", nondeterUnder, true);
            runBenchmarksMain.writeCSV("NondeterOver", nondeterOver, true);
//        runBenchmarksMain.writeCSV("NondeterUnder-noReuse", nondeterUnder, false);
//        runBenchmarksMain.writeCSV("ShffuleUnder", nondeterUnder, true);
//        runBenchmarksMain.writeCSV("ShuffleOver", nondeterOver, true);
        }


        if(run2) {  // 2
            runBenchmarksMain.writeCSV("IncLogic", incLogic, true);
        }

        if(run3){ // 3
            runBenchmarksMain.writeCSV("ConcurrencyUnder", concurrencyUnder, true);
            runBenchmarksMain.writeCSV("ConcurrencyOver", concurrencyOver,true);
        }

        if(run4) {
            // 4
            runBenchmarksMain.writeCSV("GameOver", gameOver, true);
//        runBenchmarksMain.writeCSV("GameOver-noReuse", gameOver,false);
            runBenchmarksMain.writeCSV("GameUnder", gameUnder, true);
//        runBenchmarksMain.writeCSV("GameUnder-noReuse", gameUnder,false);
        }
    }


    public void writeCSV(String fileName, List<BenchmarkInfo> info, boolean reuse) {
        final RunBenchmarksMain runBenchmarksMain = new RunBenchmarksMain();

        try (FileWriter fwCSV = new FileWriter(resultDir + fileName + ".csv");
             FileWriter fwProperties = new FileWriter(resultDir + fileName + ".txt")) {

//            fwCSV.write("Name, GrammarSize, Time, SoundnessNum, SoundnessTime, PrecisionNum, PrecisionTime, SynthesisNum, SynthesisTime, numHiddenWitness\n");
            fwCSV.write("Name, LoC, #Props, Time\n");

            for (BenchmarkInfo args : info) {
                System.out.println("Running " + args.getName());
//                RunningResults results = runBenchmarksMain.runWithinTime(args, reuse, 5);
                RunningResults results = runBenchmarksMain.run(args.toStringArray(reuse));
//                RunningResults results = runBenchmarksMain.runMedian(args.toStringArray(reuse), 3);

                Path filePath = Paths.get(args.sketchFile);
                long lineCount = Files.lines(filePath).count();

                if (results != null) {
                    fwCSV.write(String.format("%s, %d, %s\n", args.getName(), lineCount, results.toCSV()));
                    fwCSV.flush();
                    fwProperties.write(String.format("Benchmark %s:\n %s \n\n", args.getName(), results));
                    fwProperties.flush();
                    System.out.println(results.toCSV());
                } else {
                    fwCSV.write(String.format("%s, Timeout\n", args.getName()));
                    fwCSV.flush();
                    System.out.println("Timeout");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //        public RunningResults runWithinTime(BenchmarkInfo args, boolean reuse, long time) {
//            ExecutorService executor = Executors.newCachedThreadPool();
//            Callable<RunningResults> task = runTask(args.toStringArray(reuse));
//            Future<RunningResults> future = executor.submit(task);
//            RunningResults results = null;
//            try {
//                results = future.get(time, TimeUnit.SECONDS);
//            } catch (TimeoutException e) {
//                boolean cancelled = future.cancel(true);
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                executor.shutdown();
//            }
//            return results;
//        }
//
//    public Callable<RunningResults> runTask(String[] args) {
//        return new Callable<RunningResults>() {
//            @Override
//            public RunningResults call() throws Exception {
//                final Spyro spyroMain = new Spyro(args);
//                RunningResults results;
//                try {
//                    results = spyroMain.solve();
//                } catch (SketchException e) {
//                    e.print();
//                    throw e;
//
//                } catch (Error | RuntimeException e) {
//                    throw e;
//                }
//                return results;
//            }
//        };
//
//    }
    public RunningResults run(String[] args) throws Exception {
        final Spyro spyroMain = new Spyro(args);
        RunningResults results;
        try {
            results = spyroMain.solve();
        } catch (SketchException e) {
            e.print();
            throw e;
        } catch (Error | RuntimeException e) {
            ErrorHandling.handleErr(e);
            throw e;
        }
        return results;
    }

    public RunningResults runMedian(String[] args, int N) throws Exception {
        RunningResults[] results = new RunningResults[N];
        for (int i = 0; i < N; i++) {
            String[] newArgs = Arrays.copyOf(args, args.length + 2);
            newArgs[newArgs.length - 2] = "--slv-seed";
            newArgs[newArgs.length - 1] = String.valueOf(seed[i]);
            results[i] = run(newArgs);
        }
        Arrays.sort(results);
        return results[N / 2];
    }

}
