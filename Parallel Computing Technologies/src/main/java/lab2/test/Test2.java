package main.java.lab2.test;

import main.java.lab2.Algorithms.Fox.Fox;
import main.java.lab2.Algorithms.Parallel.Parallel;
import main.java.lab2.Algorithms.Sequential.Sequential;
import main.java.lab2.Tools.Matrix;
import main.java.lab2.Tools.MatrixGenerator;

public class Test2 {

    public static void main(String[] args)
    {

        var MATRIX_SIZE = 1500;
        var THREADS_COUNT = 16;

        var startTime = System.currentTimeMillis();
        var endTime = System.currentTimeMillis();


        MatrixGenerator generator = new MatrixGenerator();

        var matrixA = generator.generateMatrix(MATRIX_SIZE, MATRIX_SIZE);
        var matrixB = generator.generateMatrix(MATRIX_SIZE, MATRIX_SIZE);

        var parallelCalculator = new Parallel();
        var foxCalculator = new Fox(matrixA, matrixB, THREADS_COUNT);

        // Parallel test
        startTime = System.currentTimeMillis();
        var parRes = new Matrix(parallelCalculator.MatrixMultiplication(matrixA, matrixB, THREADS_COUNT).getMatrix());
        endTime = System.currentTimeMillis();
        System.out.println("Parallel: " + (endTime - startTime) + " ms " + "with " + THREADS_COUNT + " threads" );

        // Fox test
        startTime = System.currentTimeMillis();
        var foxRes = new Matrix(foxCalculator.multiplyMatrix().getMatrix());
        endTime = System.currentTimeMillis();
        System.out.println("Fox: " + (endTime - startTime) + " ms " + "with " + THREADS_COUNT + " threads" );

        // Check results
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                if (parRes.get(i, j) != foxRes.get(i, j)) {
                    System.out.println("Error");
                    return;
                }
            }
        }
    }
}