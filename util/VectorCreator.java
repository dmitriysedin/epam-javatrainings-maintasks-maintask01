package by.epam.training.dmitriysedin.tasks.maintask01.util;

import by.epam.training.dmitriysedin.tasks.maintask01.model.entity.DoubleVector;
import by.epam.training.dmitriysedin.tasks.maintask01.model.exceptions.VectorNegativeSizeException;

/**
 * Created by Dmitriy Sedin on 09.11.2018.
 */
public class VectorCreator {

    public static DoubleVector vectorCreate(){

        return new DoubleVector();
    }

    public static DoubleVector vectorCreate(int size) throws VectorNegativeSizeException{

        return new DoubleVector(size);
    }

    public static DoubleVector vectorCreate(double[] arr){

        return new DoubleVector(arr);
    }
}
