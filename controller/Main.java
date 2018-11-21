package by.epam.training.dmitriysedin.tasks.maintask01.controller;

import by.epam.training.dmitriysedin.tasks.maintask01.util.InitFromFile;
import by.epam.training.dmitriysedin.tasks.maintask01.util.RandomInitializer;
import by.epam.training.dmitriysedin.tasks.maintask01.util.VectorCreator;
import by.epam.training.dmitriysedin.tasks.maintask01.model.entity.DoubleVector;
import by.epam.training.dmitriysedin.tasks.maintask01.model.logic.DoubleVectorReverse;
import by.epam.training.dmitriysedin.tasks.maintask01.view.Printer;

/**
 * Created by Dmitriy Sedin on 09.11.2018.
 */
public class Main {

    public static void main(String[] args) throws Exception{

        DoubleVector defaultVector = VectorCreator.vectorCreate();
        Printer.print("defaultVector = " + defaultVector.getArray().length);

        DoubleVector doubleVectorSize25 = VectorCreator.vectorCreate(25);
        Printer.print("doubleVectorSize25 = " + doubleVectorSize25.getArray().length);

        DoubleVector doubleVectorFromArray = VectorCreator.vectorCreate(new double[0]);
        Printer.print("doubleVectorFromArray (size = 0) = " + doubleVectorFromArray.getArray().length);

        RandomInitializer.initRandomArray(defaultVector, -10, 10);
        Printer.print(defaultVector.toString());

        InitFromFile.initFromFile(doubleVectorSize25, "D:\\EPAM_maintasks\\maintasks_versions\\src\\by\\epam" +
                "\\training\\dmitriysedin\\tasks\\maintask01\\controller\\util\\testArray");
        Printer.print("initFromFile = " + doubleVectorSize25.toString());

        Printer.print("max element = " + DoubleVectorFinder.findMaxElement(defaultVector));

        Printer.print("average = " + DoubleVectorFinder.findAverage(defaultVector));

        Printer.print("isAscendingSorted = " + DoubleVectorCheker.isAscendingSorted(defaultVector));

        DoubleVectorReverse.reverse(defaultVector);
        Printer.print(defaultVector);

        DoubleVectorSorter.selectionSortAscending(defaultVector);
        Printer.print(defaultVector);
    }
}
