package by.epam.training.dmitriysedin.tasks.maintask01.model.logic;

import by.epam.training.dmitriysedin.tasks.maintask01.model.entity.DoubleVector;
import by.epam.training.dmitriysedin.tasks.maintask01.model.exceptions.VectorSizeLessThenThreeException;
import by.epam.training.dmitriysedin.tasks.maintask01.model.exceptions.VectorElementsNegativeValueException;
import by.epam.training.dmitriysedin.tasks.maintask01.model.exceptions.VectorZeroSizeException;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Dmitriy Sedin on 06.11.2018.
 */
public class DoubleVectorLogicTest {

    private static final int testArraySize = 1000;

    private static double[] createRandomArray(int size) {//random numbers from -5000 to 5000

        double[] arr = new double[size];// size 1_000
        Random random = new Random();
        int lowerBound = -5000;
        int upperBound = 5000;

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextDouble() * (upperBound - lowerBound) + lowerBound;
        }
        return arr;
    }

    private static double[] sortedArrayByAscendingOrder(double[] arr) {

        double[] sortedArr = new double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            sortedArr[i] = arr[i];
        }

        Arrays.sort(sortedArr);

        return sortedArr;
    }

    private static double[] reverseArray(double[] arr) {

        double[] reverseArray = new double[arr.length];
        int index = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            reverseArray[index] = arr[i];
            index++;
        }
        return reverseArray;
    }

    @Test
    public void findMaxElement() throws Exception {

        DoubleVector dvRandomArray = new DoubleVector(createRandomArray(testArraySize));

        DoubleVector dvSizeZero = new DoubleVector(0);

        double testRandomArrayMaxElement = Arrays.stream(dvRandomArray.getArray()).max().getAsDouble();

        assertEquals(testRandomArrayMaxElement, DoubleVectorFinder.findMaxElement(dvRandomArray), .0);

        try {
            DoubleVectorFinder.findMaxElement(dvSizeZero);
        } catch (VectorZeroSizeException ex) {
            assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void findMinElement() throws Exception {

        DoubleVector dvRandomArray = new DoubleVector(createRandomArray(testArraySize));

        DoubleVector dvSizeZero = new DoubleVector(0);

        double testRandomArrayMinElement = Arrays.stream(dvRandomArray.getArray()).min().getAsDouble();

        assertEquals(testRandomArrayMinElement, DoubleVectorFinder.findMinElement(dvRandomArray), .0);

        try {
            DoubleVectorFinder.findMinElement(dvSizeZero);
        } catch (VectorZeroSizeException ex) {
            assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void findAverage() throws Exception {

        DoubleVector dvRandomArray = new DoubleVector(createRandomArray(testArraySize));

        DoubleVector dvSizeZero = new DoubleVector(0);

        double average = Arrays.stream(dvRandomArray.getArray()).average().getAsDouble();

        assertEquals(average, DoubleVectorFinder.findAverage(dvRandomArray), .000_000_000_1);

        try {
            DoubleVectorFinder.findAverage(dvSizeZero);
        } catch (VectorZeroSizeException ex) {
            assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void findGeometricMean() throws Exception {

        double[] simpleArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};// size = 10

        double[] simpleArrayWithZeroElement = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10};// size = 10

        double[] simpleArrayWithNegativeElement = {-1, 2, 3, 4, 5, 6, 7, 8, 9, 10};// size = 10

        double mul = 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10;

        double geometricMean = Math.pow(mul, (1.0 / 10));

        assertEquals(geometricMean, DoubleVectorFinder.findGeometricMean(new DoubleVector(simpleArray)),
                0.000_000_000_1);

        assertEquals(0, DoubleVectorFinder.findGeometricMean(new DoubleVector(simpleArrayWithZeroElement)),
                0.000_000_000_1);

        try {
            DoubleVectorFinder.findGeometricMean(new DoubleVector(0));
        } catch (VectorZeroSizeException ex) {
            assertNotEquals("", ex.getMessage());
        }

        try {
            DoubleVectorFinder.findGeometricMean(new DoubleVector(simpleArrayWithNegativeElement));
        } catch (VectorElementsNegativeValueException ex) {
            assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void isAscendingSorted() throws Exception {

        double[] randomArray = new DoubleVector(testArraySize).getArray();

        DoubleVector dvSortedByAscendingOrder = new DoubleVector(sortedArrayByAscendingOrder(randomArray));

        DoubleVector dvUnsortedVector = new DoubleVector(createRandomArray(testArraySize));

        assertTrue(DoubleVectorChecker.isAscendingSorted(dvSortedByAscendingOrder));

        assertTrue(!DoubleVectorChecker.isAscendingSorted(dvUnsortedVector));

        try {
            DoubleVectorChecker.isAscendingSorted(new DoubleVector(0));
        } catch (VectorZeroSizeException ex) {
            assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void isDescendingSorted() throws Exception {

        DoubleVector dvSortedByDescendingOrder = new DoubleVector(reverseArray(sortedArrayByAscendingOrder
                (createRandomArray(testArraySize))));

        DoubleVector dvUnsortedVector = new DoubleVector(createRandomArray(testArraySize));

        assertTrue(DoubleVectorChecker.isDescendingSorted(dvSortedByDescendingOrder));

        assertTrue(!DoubleVectorChecker.isDescendingSorted(dvUnsortedVector));

        try {
            DoubleVectorChecker.isDescendingSorted(new DoubleVector(0));
        } catch (VectorZeroSizeException ex) {
            assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void findIndexOfFirstLocalMax() throws Exception {

        double[] simpleArrayWithLocalMax = {1, 2, 3, 2, 5, 6, 7, 6, 9, 10};// index of first local max = 2

        double[] simpleArrayWithoutLocalMax = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        assertEquals(2, DoubleVectorFinder.findIndexOfFirstLocalMax
                (new DoubleVector(simpleArrayWithLocalMax)));

        assertEquals(-1, DoubleVectorFinder.findIndexOfFirstLocalMax
                (new DoubleVector(simpleArrayWithoutLocalMax)));

        try {
            DoubleVectorFinder.findIndexOfFirstLocalMax(new DoubleVector(0));
        } catch (VectorSizeLessThenThreeException ex) {
            assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void findIndexOfFirstLocalMin() throws Exception {

        double[] simpleArrayWithLocalMin = {1, 2, 1, 4, 5, 6, 7, 6, 9, 10};// index of first local min = 2

        double[] simpleArrayWithoutLocalMin = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        assertEquals(2, DoubleVectorFinder.findIndexOfFirstLocalMin
                (new DoubleVector(simpleArrayWithLocalMin)));

        assertEquals(-1, DoubleVectorFinder.findIndexOfFirstLocalMin
                (new DoubleVector(simpleArrayWithoutLocalMin)));

        try {
            DoubleVectorFinder.findIndexOfFirstLocalMax(new DoubleVector(0));
        } catch (VectorSizeLessThenThreeException ex) {
            assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void linearSearch() throws Exception {

        DoubleVector dvRandomVector = new DoubleVector(createRandomArray(testArraySize));

        int indexOfFirstOccurrenceOfTheSearchKey = 500;

        double correctKey = dvRandomVector.getArray()[indexOfFirstOccurrenceOfTheSearchKey];

        double wrongKey = 123456;

        assertEquals(indexOfFirstOccurrenceOfTheSearchKey, DoubleVectorSearcher.linearSearch
                (dvRandomVector, correctKey));

        assertEquals(-1, DoubleVectorSearcher.linearSearch(dvRandomVector, wrongKey));

        try {
            DoubleVectorSearcher.linearSearch(new DoubleVector(0), correctKey);
        } catch (VectorZeroSizeException ex) {
            assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void binarySearch() throws Exception {

        DoubleVector dvSortedRandomArray = new DoubleVector(sortedArrayByAscendingOrder
                (createRandomArray(testArraySize)));

        int indexOfFirstOccurrenceOfTheSearchKey = 500;

        double correctKey = dvSortedRandomArray.getArray()[indexOfFirstOccurrenceOfTheSearchKey];

        double wrongKey = 123456;

        assertEquals(indexOfFirstOccurrenceOfTheSearchKey, DoubleVectorSearcher.binarySearch(dvSortedRandomArray,
                correctKey));

        assertEquals(-1, DoubleVectorSearcher.binarySearch(dvSortedRandomArray, wrongKey));

        try {
            DoubleVectorSearcher.binarySearch(new DoubleVector(0), correctKey);
        } catch (VectorZeroSizeException ex) {
            assertNotEquals("", ex.getMessage());
        }

    }

    @Test
    public void reverse() throws Exception {

        DoubleVector dvRandomArray = new DoubleVector(createRandomArray(testArraySize));

        double[] reverseArray = reverseArray(dvRandomArray.getArray());

        DoubleVectorReverse.reverse(dvRandomArray);

        assertArrayEquals(reverseArray, dvRandomArray.getArray(), .000_000_000_1);

        try {
            DoubleVectorReverse.reverse(new DoubleVector(0));
        } catch (VectorZeroSizeException ex) {
            assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void insertionSortAscending() throws Exception {

        DoubleVector dvRandomArray = new DoubleVector(createRandomArray(testArraySize));

        double[] sortedArray = sortedArrayByAscendingOrder(dvRandomArray.getArray());

        DoubleVectorSorter.insertionSortAscending(dvRandomArray);

        assertArrayEquals(sortedArray, dvRandomArray.getArray(), .000_000_000_1);

        try {
            DoubleVectorSorter.insertionSortAscending(new DoubleVector(0));
        } catch (VectorZeroSizeException ex) {
            assertNotEquals("", ex.getMessage());
        }

    }

    @Test
    public void insertionSortDescending() throws Exception {

        DoubleVector dvRandomArray = new DoubleVector(createRandomArray(testArraySize));

        double[] sortedArray = reverseArray(sortedArrayByAscendingOrder(dvRandomArray.getArray()));

        DoubleVectorSorter.selectionSortDescending(dvRandomArray);

        assertArrayEquals(sortedArray, dvRandomArray.getArray(), .000_000_000_1);

        try {
            DoubleVectorSorter.insertionSortDescending(new DoubleVector(0));
        } catch (VectorZeroSizeException ex) {
            assertNotEquals("", ex.getMessage());
        }

    }

    @Test
    public void bubbleSortAscendingClassic() throws Exception {

        DoubleVector dvRandomArray = new DoubleVector(createRandomArray(testArraySize));

        double[] sortedArray = sortedArrayByAscendingOrder(dvRandomArray.getArray());

        DoubleVectorSorter.bubbleSortAscendingClassic(dvRandomArray);

        assertArrayEquals(sortedArray, dvRandomArray.getArray(),.000_000_000_1);

        try {
            DoubleVectorSorter.bubbleSortAscendingClassic(new DoubleVector(0));
        } catch (VectorZeroSizeException ex) {
            assertNotEquals("", ex.getMessage());
        }

    }

    @Test
    public void bubbleSortDescendingClassic() throws Exception {

        DoubleVector dvRandomArray = new DoubleVector(createRandomArray(testArraySize));

        double[] sortedArray = reverseArray(sortedArrayByAscendingOrder(dvRandomArray.getArray()));

        DoubleVectorSorter.selectionSortDescending(dvRandomArray);

        assertArrayEquals(sortedArray, dvRandomArray.getArray(), .000_000_000_1);

        try {
            DoubleVectorSorter.bubbleSortDescendingClassic(new DoubleVector(0));
        } catch (VectorZeroSizeException ex) {
            assertNotEquals("", ex.getMessage());
        }

    }

    @Test
    public void selectionSortAscending() throws Exception {

        DoubleVector dvRandomArray = new DoubleVector(createRandomArray(testArraySize));

        double[] sortedArray = sortedArrayByAscendingOrder(dvRandomArray.getArray());

        DoubleVectorSorter.selectionSortAscending(dvRandomArray);

        assertArrayEquals(sortedArray, dvRandomArray.getArray(), .000_000_000_1);

        try {
            DoubleVectorSorter.selectionSortAscending(new DoubleVector(0));
        } catch (VectorZeroSizeException ex) {
            assertNotEquals("", ex.getMessage());
        }

    }

    @Test
    public void selectionSortDescending() throws Exception {

        DoubleVector dvRandomArray = new DoubleVector(createRandomArray(testArraySize));

        double[] sortedArray = reverseArray(sortedArrayByAscendingOrder(dvRandomArray.getArray()));

        DoubleVectorSorter.selectionSortDescending(dvRandomArray);

        assertArrayEquals(sortedArray, dvRandomArray.getArray(), .000_000_000_1);

        try {
            DoubleVectorSorter.selectionSortDescending(new DoubleVector(0));
        } catch (VectorZeroSizeException ex) {
            assertNotEquals("", ex.getMessage());
        }
    }
}