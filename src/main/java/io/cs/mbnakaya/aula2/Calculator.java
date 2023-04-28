package io.cs.mbnakaya.aula2;

import java.util.List;

class Calculator {

    protected static Integer fibonacci(Integer index) {
        int n1 = 0, n2 = 1, n3 = 0;

        for(int i = 0; i < index; i++) {
            n3=n1+n2;
            n1=n2;
            n2=n3;
        }
        return n3;
    }

    protected static Double squareArea(Double side) {
        return Math.pow(side, 2);
    }

    protected static List<Double> bhaskara(Integer a, Integer b, Integer c) {
        double delta, x1, x2;
        delta = (b * b) + (-4 * (a * c));

        if (delta >= 0) {
            x1 = ((-(b) + Math.sqrt(delta)) / 2 * a);
            x2 = ((-(b) - Math.sqrt(delta)) / 2 * a);

            return List.of(x1, x2);
        } else {
            throw new NoPositiveSqrtFoundException();
        }
    }
}
