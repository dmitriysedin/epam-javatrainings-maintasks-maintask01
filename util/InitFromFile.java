package by.epam.training.dmitriysedin.tasks.maintask01.util;

import by.epam.training.dmitriysedin.tasks.maintask01.model.entity.DoubleVector;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Dmitriy Sedin on 09.11.2018.
 */
public class InitFromFile {

    public static void initFromFile(DoubleVector vector, String fileName) throws IOException, NumberFormatException{

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            double[] arr = vector.getArray();
            String s;
            int index = 0;
            while ((s = reader.readLine()) != null && index < arr.length) {
                arr[index] = Double.parseDouble(s);
                index++;
            }
        } catch (
                IOException | NumberFormatException e) {
            throw e;
        }
    }
}
