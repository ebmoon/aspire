package aspire.synthesis;

import sketch.compiler.ast.core.Function;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Map;

public class RunningResults implements Comparable<RunningResults>{
    PropertySet properties;
    Map<String, Function> lambdaFunctions;
    BigInteger grammarSize;
    long runningTime;
    boolean isUnder;
    long timeSoundness;
    int numSoundness;
    long timePrecision;
    int numPrecision;
    long timeSynthesis;
    int numSynthesis;
    int numHiddenWitness;


    public BigInteger getGrammarSize() {
        return grammarSize;
    }

    public long getRunningTime() {
        return runningTime;
    }

    public RunningResults(boolean isUnder, PropertySet properties, Map<String, Function> lambdaFunctions, BigInteger grammarSize, long runningTime, long timeSoundness, int numSoundness, long timePrecision, int numPrecision, long timeSynthesis, int numSynthesis, int numHiddenWitness) {
        this.isUnder = isUnder;
        this.properties = properties;
        this.lambdaFunctions = lambdaFunctions;
        this.grammarSize = grammarSize;
        this.runningTime = runningTime;
        this.timeSoundness = timeSoundness;
        this.numSoundness = numSoundness;
        this.timePrecision = timePrecision;
        this.numPrecision = numPrecision;
        this.timeSynthesis = timeSynthesis;
        this.numSynthesis = numSynthesis;
        this.numHiddenWitness = numHiddenWitness;
    }

    @Override
    public int compareTo(RunningResults other) {
        return Long.compare(this.runningTime, other.runningTime);
    }

    public String toString() {
        String str = "";
        int idx = 0;
        for (Property prop : properties.getProperties()) {
            String code = prop.toSketchCode().getBody().toString();

            str += "Property " + idx++ + "\n" + code + "\n";

            for (Map.Entry<String, Function> entry : lambdaFunctions.entrySet()) {
                String key = entry.getKey();
                if (code.contains(key)) {
                    str += entry.getValue() + "\n";
                    str += entry.getValue().getBody().toString() + "\n";
                }
            }
        }

        str += "Total time = " + runningTime + "\n";
        str += "Grammar Size = " + grammarSize + "\n";
        str += "Soundness Number = " + numSoundness + "\n";
        str += "Soundness Time = " + timeSoundness + "\n";
        str += "Precision Number = " + numPrecision + "\n";
        str += "Precision Time = " + timePrecision + "\n";
        str += "Synthesis Number = " + numSynthesis + "\n";
        str += "Synthesis Time = " + timeSynthesis + "\n";
        str += "Max Number of Hidden Witness = " + numHiddenWitness + "\n";
        return str;
    }
    public String toCSV(boolean verbose) {
        if (verbose) {
            BigDecimal sizeDecimal = new BigDecimal(grammarSize);
            DecimalFormat df = new DecimalFormat("0.##E0");
            return String.format("%s,%d,%d,%.2f,%d,%.2f,%d,%.2f,%.2f", df.format(sizeDecimal), properties.getProperties().size(), numSoundness, timeSoundness/1000.0, numPrecision, timePrecision/1000.0, numSynthesis, timeSynthesis/1000.0, runningTime/1000.0);
        }
        return String.format("%d,%d", properties.getProperties().size(), runningTime);
    }

    static public String toCSVHead(boolean verbose) {
        if (verbose) {
            return "|Grammar|,#Props,CINum,CITime,CPNum,CPTime,SynNum,SynTime,Total";
        }
        return "#Props,Time";
    }


}