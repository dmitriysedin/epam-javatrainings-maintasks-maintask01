package by.epam.training.dmitriysedin.tasks.maintask01.model.logic;

import by.epam.training.dmitriysedin.tasks.maintask01.model.entity.DoubleVector;
import by.epam.training.dmitriysedin.tasks.maintask01.model.exceptions.VectorZeroSizeException;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class DoubleVectorSearcher {

    public static final Logger logger = Logger.getLogger(DoubleVectorSearcher.class);

    /**
     * This method searches the given array of doubles for the specified value using the linear search algorithm.
     * Returns index of the first occurrence of the search key, if it is contained in the array; otherwise, (- 1).
     */

    public static int linearSearch(DoubleVector dv, double key) throws VectorZeroSizeException {

        double[] arr = dv.getArray();

        if(arr.length == 0){
            throw new VectorZeroSizeException("The array's size is 0");
        }

        for (int i = 0; i < arr.length; i++) {
            if (key == arr[i]) {
                return i; // key found
            }
        }
        logger.trace("linearSearch");
        return -1; // key not found
    }

    /**
     * This method searches the given sorted by ascending array of doubles
     * for the specified value using the binary search algorithm.
     * Returns index of the any occurrence of the search key,
     * if it is contained in the array; otherwise, (- 1).
     */

    public static int binarySearch(DoubleVector dv, double key) throws VectorZeroSizeException {

        double[] arr = dv.getArray();

        if(arr.length == 0){
            throw new VectorZeroSizeException("The array's size is 0");
        }

        Arrays.sort(arr);

        int middle;
        int right = arr.length - 1;
        int left = 0;
        double middleValue;

        while (right >= left) {

            middle = left + ((right - left) / 2);
            middleValue = arr[middle];

            if (key == middleValue) {
                return middle; // key found
            } else {
                if (key < middleValue) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        logger.trace("binarySearch");
        return -1; // key not found
    }
}
