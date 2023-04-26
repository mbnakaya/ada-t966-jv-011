package io.cs.mbnakaya.aula2;

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

    // calcula baschara

    // calcula raiz quadrada

    // calcula area
}
