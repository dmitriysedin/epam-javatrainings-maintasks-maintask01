package by.epam.training.dmitriysedin.tasks.maintask01.model.logic;

import by.epam.training.dmitriysedin.tasks.maintask01.model.entity.DoubleVector;
import by.epam.training.dmitriysedin.tasks.maintask01.model.exceptions.VectorElementsNegativeValueException;
import by.epam.training.dmitriysedin.tasks.maintask01.model.exceptions.VectorZeroSizeException;
import org.apache.log4j.Logger;

import java.util.Arrays;


/**
 * Created by Dmitriy Sedin on 06.11.2018.
 * <p>
 * This class contains various methods for manipulating arrays.
 *
 */
public class DoubleVectorReverse {

    public static final Logger logger = Logger.getLogger(DoubleVectorReverse.class);

     /**
     * This method returns the array obtained by reversing order of the elements
     * in the specified array of doubles.
     */

    public static void reverse(DoubleVector dv) throws VectorZeroSizeException {

        double[] arr = dv.getArray();

        if(arr.length == 0){
            throw new VectorZeroSizeException("The array's size is 0");
        }

        for (int i = 0; i < arr.length / 2; i++) {
            int arrLength = arr.length - 1;
            arr[i] = arr[i] + arr[arrLength - i];
            arr[arrLength - i] = arr[i] - arr[arrLength - i];
            arr[i] = arr[i] - arr[arrLength - i];
        }
        logger.trace("reverse");
    }
}

