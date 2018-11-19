package by.epam.training.dmitriysedin.tasks.maintask01.util;

import by.epam.training.dmitriysedin.tasks.maintask01.model.entity.DoubleVector;

import java.util.Random;

/**
 * Created by Dmitriy Sedin on 09.11.2018.
 */
public class RandomInitializer {

    public static void initRandomArray(DoubleVector vector, int lowerBound, int upperBound) {

        Random random = new Random();
        double[] arr = vector.getArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextDouble() * (upperBound - lowerBound) + lowerBound;
        }
    }
}
