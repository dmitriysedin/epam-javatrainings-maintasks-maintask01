package by.epam.training.dmitriysedin.tasks.maintask01.model.logic;

import by.epam.training.dmitriysedin.tasks.maintask01.model.entity.DoubleVector;
import by.epam.training.dmitriysedin.tasks.maintask01.model.exceptions.VectorZeroSizeException;
import org.apache.log4j.Logger;

public class DoubleVectorSorter {

    public static final Logger logger = Logger.getLogger(DoubleVectorSorter.class);

    /**
     * This method returns the array obtained by sorting by ascending order of the elements
     * in the specified array of doubles.
     */

    public static void insertionSortAscending(DoubleVector dv) throws VectorZeroSizeException {

        double[] arr = dv.getArray();

        if(arr.length == 0){
            throw new VectorZeroSizeException("The array's size is 0");
        }

        for (int i = 1; i <= arr.length - 1; i++) {
            double key = arr[i];

            for (int j = i - 1; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
                arr[j] = key;
            }
        }
        logger.trace("insertionSortAscending");
    }

    /**
     * This method returns the array obtained by sorting by ascending order of the elements
     * in the specified array of doubles.
     */

    public static void insertionSortDescending(DoubleVector dv) throws VectorZeroSizeException{

        double[] arr = dv.getArray();

        if(arr.length == 0){
            throw new VectorZeroSizeException("The array's size is 0");
        }

        for (int i = 1; i <= arr.length - 1; i++) {
            double key = arr[i];

            for (int j = i - 1; j >= 0 && arr[j] < key; j--) {
                arr[j + 1] = arr[j];
                arr[j] = key;
            }
        }
        logger.trace("insertionSortDescending");
    }

    /**
     * This method returns the array obtained by sorting by ascending order of the elements
     * in the specified array of doubles.
     */

    public static void bubbleSortAscendingClassic(DoubleVector dv) throws VectorZeroSizeException {

        double[] arr = dv.getArray();

        if(arr.length == 0){
            throw new VectorZeroSizeException("The array's size is 0");
        }

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    double tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        logger.trace("bubbleSortAscendingClassic");
    }

    /**
     * This method returns the array obtained by sorting by ascending order of the elements
     * in the specified array of doubles.
     */

    public static void bubbleSortDescendingClassic(DoubleVector dv) throws VectorZeroSizeException{

        double[] arr = dv.getArray();

        if(arr.length == 0){
            throw new VectorZeroSizeException("The array's size is 0");
        }

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[j + 1]) {
                    double tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        logger.trace("bubbleSortDescendingClassic");
    }

    /**
     * This method returns the array obtained by sorting by ascending order of the elements
     * in the specified array of doubles.
     */

    public static void selectionSortAscending(DoubleVector dv) throws VectorZeroSizeException{

        double[] arr = dv.getArray();

        if(arr.length == 0){
            throw new VectorZeroSizeException("The array's size is 0");
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int least = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[least]) {
                    least = j;
                }
            }
            double tmp = arr[i];
            arr[i] = arr[least];
            arr[least] = tmp;
        }
        logger.trace("selectionSortAscending");
    }

    /**
     * This method returns the array obtained by sorting by ascending order of the elements
     * in the specified array of doubles.
     */

    public static void selectionSortDescending(DoubleVector dv) throws VectorZeroSizeException {

        double[] arr = dv.getArray();

        if(arr.length == 0){
            throw new VectorZeroSizeException("The array's size is 0");
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int least = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[least]) {
                    least = j;
                }
            }
            double tmp = arr[i];
            arr[i] = arr[least];
            arr[least] = tmp;
        }
        logger.trace("selectionSortDescending");
    }
}
