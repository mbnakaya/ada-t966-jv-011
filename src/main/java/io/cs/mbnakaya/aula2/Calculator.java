package io.cs.mbnakaya.aula2;

import java.util.List;

class Calculator {

    protected Integer fibonacci(Integer index) {
        int n1 = 0, n2 = 1, n3 = 0;

        for(int i = 0; i < index; i++) {
            n3=n1+n2;
            n1=n2;
            n2=n3;
        }
        return n3;
    }

    protected Double squareArea(Double side) {
        return Math.pow(side, 2);
    }

    protected List<Double> bhaskara(Integer a, Integer b, Integer c) {
        double delta, x1, x2;
        delta = (b * b) + (-4 * (a * c));

        if (delta >= 0) {

            x1 = ((-(b) + Math.sqrt(delta)) / 2 * a);
            x2 = ((-(b) - Math.sqrt(delta)) / 2 * a);

            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);

        } else {
            throw new DeltaHasNoSqrtException();
        }
        return List.of(x1, x2);
    }
}
