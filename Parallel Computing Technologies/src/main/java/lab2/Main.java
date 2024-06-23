package main.java.lab2;

import main.java.lab2.Algorithms.Fox.Fox;
import main.java.lab2.Algorithms.Parallel.Parallel;
import main.java.lab2.Algorithms.Sequential.Sequential;
import main.java.lab2.Tools.MatrixGenerator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args)
    {
        var rows = 4;
        var columns = 4;

        MatrixGenerator generator = new MatrixGenerator();

        var matrixA = generator.generateMatrix(rows, columns);
        matrixA.print2D();

        var matrixB = generator.generateMatrix(rows, columns);
        matrixB.print2D();

        System.out.println("Sequential:");
        var sequential = new Sequential();
        var matrixC = sequential.multiplyMatrix(matrixA, matrixB);
        matrixC.print2D();

        System.out.println("Parallel:");
        var parallel = new Parallel();
        var matrixD = parallel.MatrixMultiplication(matrixA, matrixB, 4);
        matrixD.print2D();

        System.out.println("Fox:");
        var fox = new Fox(matrixA, matrixB, 4);
        var matrixE = fox.multiplyMatrix();
        matrixE.print2D();
    }
}