package by.epam.training.dmitriysedin.tasks.maintask01.model.logic;

import by.epam.training.dmitriysedin.tasks.maintask01.model.entity.DoubleVector;
import by.epam.training.dmitriysedin.tasks.maintask01.model.exceptions.VectorZeroSizeException;
import org.apache.log4j.Logger;

public class DoubleVectorChecker {

    public static final Logger logger = Logger.getLogger(DoubleVectorChecker.class);

    /**
     * This method returns true if the specified array is sorted by ascending
     */

    public static boolean isAscendingSorted(DoubleVector dv) throws VectorZeroSizeException {

        boolean isAscendingSorted = true;

        double[] arr = dv.getArray();

        if(dv.getArray().length == 0){
            throw new VectorZeroSizeException("The array's size is 0");
        }

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] <= arr[i + 1]) {
            } else {
                isAscendingSorted = false;
                break;
            }
        }
        logger.trace("isAscendingSorted");
        return isAscendingSorted;
    }

    /**
     * This method returns true if the specified array is sorted by descending
     */

    public static boolean isDescendingSorted(DoubleVector dv) throws VectorZeroSizeException{

        boolean isDescendingSorted = true;

        double[] arr = dv.getArray();

        if(dv.getArray().length == 0){
            throw new VectorZeroSizeException("The array's size is 0");
        }

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] >= arr[i + 1]) {
            } else {
                isDescendingSorted = false;
                break;
            }
        }
        logger.trace("isDescendingSorted");
        return isDescendingSorted;
    }
}
