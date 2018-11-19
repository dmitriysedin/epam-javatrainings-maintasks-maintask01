package by.epam.training.dmitriysedin.tasks.maintask01.model.logic;

import by.epam.training.dmitriysedin.tasks.maintask01.model.entity.DoubleVector;
import by.epam.training.dmitriysedin.tasks.maintask01.model.exceptions.VectorElementsNegativeValueException;
import by.epam.training.dmitriysedin.tasks.maintask01.model.exceptions.VectorSizeLessThenThreeException;
import by.epam.training.dmitriysedin.tasks.maintask01.model.exceptions.VectorZeroSizeException;
import org.apache.log4j.Logger;

public class DoubleVectorFinder {

    public static final Logger logger = Logger.getLogger(DoubleVectorFinder.class);

    /**
     * This method returns the maximum element of given array
     */

    public static double findMaxElement(DoubleVector dv) throws VectorZeroSizeException {

        double max = Double.MIN_VALUE;

        double[] arr = dv.getArray();

        if(arr.length == 0){
            throw new VectorZeroSizeException("The array's size is 0");
        }

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        logger.trace("findMaxElement");
        return max;
    }

    /**
     * This method returns the minimum element of given array
     */

    public static double findMinElement(DoubleVector dv) throws VectorZeroSizeException {

        double min = Double.MAX_VALUE;

        double[] arr = dv.getArray();

        if(arr.length == 0){
            throw new VectorZeroSizeException("The array's size is 0");
        }

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        logger.trace("findMinElement");
        return min;
    }

    /**
     * This method returns the arithmetic mean of elements of given array
     */

    public static double findAverage(DoubleVector dv) throws VectorZeroSizeException{

        double[] arr = dv.getArray();

        if(arr.length == 0){
            throw new VectorZeroSizeException("The array's size is 0");
        }

        double sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        logger.trace("findAverage");
        return sum / arr.length;
    }

    /**
     * This method returns the geometric mean of elements of given array
     */

    public  static double findGeometricMean(DoubleVector dv) throws VectorZeroSizeException, VectorElementsNegativeValueException {

        double[] arr = dv.getArray();

        if(arr.length == 0){
            throw new VectorZeroSizeException("The array's size is 0");
        }

        double multiple = 1;

        for (int i = 0; i < arr.length; i++) {

            if(arr[i] == 0) {
                return 0;
            }

            if (arr[i] > 0) {
                multiple *= arr[i];
            } else {
                throw new VectorElementsNegativeValueException("The value of element must be greater or even then 0");
            }
        }
        logger.trace("findGeometricMean");
        return Math.pow(multiple, (1.0 / arr.length));
    }

    /**
     * This method returns the index within given array of doubles of the first occurrence of the local maximum;
     * otherwise, (- 1).
     */

    public static int findIndexOfFirstLocalMax(DoubleVector dv) throws VectorSizeLessThenThreeException {

        double[] arr = dv.getArray();

        if(dv.getArray().length < 3){
            throw new VectorSizeLessThenThreeException("The array's size is less then three");
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i; // local maximum found
            }
        }
        logger.trace("findIndexOfFirstLocalMax");
        return -1; // local maximum not found
    }

    /**
     * This method returns the index within given array of doubles of the first occurrence of the local minimum;
     * otherwise, (- 1).
     */

    public static int findIndexOfFirstLocalMin(DoubleVector dv) throws VectorZeroSizeException{

        double[] arr = dv.getArray();

        if(dv.getArray().length == 0){
            throw new VectorZeroSizeException("The array's size is 0");
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                return i; // local minimum found
            }
        }
        logger.trace("findIndexOfFirstLocalMin");
        return -1; // local minimum not found
    }
}
