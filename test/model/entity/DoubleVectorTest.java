package by.epam.training.dmitriysedin.tasks.maintask01.model.entity;

import by.epam.training.dmitriysedin.tasks.maintask01.model.exceptions.VectorNegativeSizeException;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;


/**
 * Created by Dmitriy Sedin on 06.11.2018.
 */
public class DoubleVectorTest{

    private static final double[] simpleArray = {1, 2, 3};

    private static final int testArraySize = 1000;

    private static double[] testRandomArray = createRandomArray(testArraySize);

    private static double[] createRandomArray(int size){

        double[] arr = new double[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextDouble() * size * 10 - (size *10) / 2;
        }
        return arr;
    }

    @Test
    public void testDefaultConstructor() throws Exception {

        int expectedSize = DoubleVector.DEFAULT_SIZE;

        DoubleVector dvDefault = new DoubleVector();

        assertEquals(expectedSize, dvDefault.getArray().length);
    }

    @Test()
    public void testConstructorParamIntSize() throws Exception {

        DoubleVector dvSize1000 = new DoubleVector(testArraySize);
        assertEquals(testArraySize, dvSize1000.getArray().length);

        try {
            DoubleVector dv = new DoubleVector(-1);
        } catch (VectorNegativeSizeException ex){
            assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void testConstructorParamDoubleArray() throws Exception {

        int testIndexOfArrayElement = 500;

        double[] expectedArray = testRandomArray;

        double expectedElement = testRandomArray[testIndexOfArrayElement];

        DoubleVector dvConstructorParamArray = new DoubleVector(testRandomArray);

        assertArrayEquals(expectedArray, dvConstructorParamArray.getArray(), .0);

        assertEquals(expectedElement, dvConstructorParamArray.getArray()[testIndexOfArrayElement], .0);

    }

    @Test
    public void testGetArray() throws Exception {

        double[] expectedArray = testRandomArray;

        DoubleVector dv = new DoubleVector(testRandomArray);
        assertArrayEquals(expectedArray, dv.getArray(), .0);
    }

    @Test
    public void testSetArray() throws Exception {

        double[] expectedArray = testRandomArray;
        DoubleVector dv = new DoubleVector(0);
        dv.setArray(testRandomArray);

        assertArrayEquals(expectedArray, dv.getArray(), .0);
    }

    @Test
    public void tesTtoString() throws Exception {

        String testArrayToString = "DoubleVector array = \\n" +
                "1.0\\n" + "2.0\\n" + "3.0\\n";

        DoubleVector dv = new DoubleVector(simpleArray);

        assertEquals(testArrayToString, dv.toString());

    }

}