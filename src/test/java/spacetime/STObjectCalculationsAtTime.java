package spacetime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;

/**
 * Test Utility Class for Recording all of the calculation ticks for each object
 *
 */
public class STObjectCalculationsAtTime {

    String scenarioFilename;
    String objectName;
    String objectLabel;
    double animationTime;
    double objectTimeReading;
    double objectXPosition;
    double objectBeta;
    double objectGamma;


    public STObjectCalculationsAtTime( String _scenarioFilename,
                                       String _objectName,
                                       String _objectLabel,
                                       double _animationTime,
                                       double _objectTimeReading,
                                       double _objectXPosition,
                                       double _objectBeta,
                                       double _objectGamma ) {
        this.scenarioFilename = _scenarioFilename;
        this.objectName = _objectName;
        this.objectLabel = _objectLabel;
        this.animationTime = _animationTime;
        this.objectTimeReading = _objectTimeReading;
        this.objectXPosition = _objectXPosition;
        this.objectBeta = _objectBeta;
        this.objectGamma = _objectGamma;

    }

}
