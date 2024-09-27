package spacetime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;

/**
 * CSV Writing Functions for lists of Calculations
 */

public class STObjectCalculationsCsv {

    public static void writeToCsvFile(File csvFile, LinkedList<STObjectCalculationsAtTime> calculations ) throws IOException {

        PrintStream printStream = new PrintStream(new FileOutputStream(csvFile));

        // Header Row
        LinkedList<String> headers = new LinkedList();
        headers.add("scenarioFilename");
        headers.add("objectName");
        headers.add("objectLabel");
        headers.add("animationTime");
        headers.add("objectTimeReading");
        headers.add("objectXPosition");
        headers.add("objectBeta");
        headers.add("objectGamma");

        printStream.println( String.join(",", headers));

        // Value Rows.
        for ( int i = 0 ; i < calculations.size(); i++ ) {
            STObjectCalculationsAtTime calc = calculations.get(i);
            LinkedList<String> values = new LinkedList();
            values.add(calc.scenarioFilename);
            values.add(calc.objectName);
            values.add(calc.objectLabel);
            values.add(formatDoubleToString(calc.animationTime));
            values.add(formatDoubleToString(calc.objectTimeReading));
            values.add(formatDoubleToString(calc.objectXPosition));
            values.add(formatDoubleToString(calc.objectBeta));
            values.add(formatDoubleToString(calc.objectGamma));
            printStream.println( String.join(",", values));
        }

        printStream.close();
    }

    public static String formatDoubleToString(double d) {
        return d+"";
    }
}
