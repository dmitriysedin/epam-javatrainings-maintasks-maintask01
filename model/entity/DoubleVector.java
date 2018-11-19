package by.epam.training.dmitriysedin.tasks.maintask01.model.entity;

import by.epam.training.dmitriysedin.tasks.maintask01.model.exceptions.VectorNegativeSizeException;

import org.apache.log4j.Logger;

/**
 * Created by Dmitriy Sedin on 05.11.2018.
 */
public class DoubleVector {

    public static final Logger logger = Logger.getLogger(DoubleVector.class);

    public static final int DEFAULT_SIZE = 10;

    private double[] array;

    public DoubleVector() {
        array = new double[DEFAULT_SIZE];
        logger.trace("Default constructor");
    }

    public DoubleVector(double[] array) {
            this.array = array;
            logger.trace("Constructor with parameter <double[] array>");
        }

    public DoubleVector(int size) throws VectorNegativeSizeException {
        if (size >= 0) {
            this.array = new double[size];
            logger.trace("Constructor with parameter <int size>");
        } else {
            logger.trace("Exception <VectorSizeException>");
            throw new VectorNegativeSizeException("The <int size> is negative");
        }
    }

    public double[] getArray() {
        logger.trace("GetArray");
        return array;
    }

    public void setArray(double[] array) {
        logger.trace("SetArray");
        this.array = array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DoubleVector array = \n");
        for (double d : array) {
            sb.append(d).append("\n");
        }
        logger.trace("ToString");
        return sb + "";
    }
}
