package com.jackson.app;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) {
        int[] v = {1, 1, 3, 4};
        DensePolynomial p = new DensePolynomial(v);
        DensePolynomial p2 = new DensePolynomial("4x^3 + 3x^2 + x + 1");
        // System.out.println(p.degree());
        // System.out.println(p.getCoefficient(1));
        // int[] v2 = { 1 };
        // DensePolynomial p2 = new DensePolynomial(v2);
        // System.out.println(p2.degree());
        // System.out.println(p2.getCoefficient(0));

        // System.out.println("----");
        // System.out.println(p.add(p2).degree());
        // System.out.println("----");
        // System.out.println(p.getCoefficient(0));
        // System.out.println(p.add(p2).getCoefficient(0));
        // int[] test = new DensePolynomial("x^4 + 5x^2 + -2x + -5").getValues();
        // int[] test2 = {-5, -2, 5, 0, 1};
        // for (int i = 0; i < 5; i++) {
        //     System.out.print(test[i] + " ");
        // }
        // System.out.println();
        // for (int i = 0; i < 5; i++) {
        //     System.out.print(test2[i] + " ");
        // }
        // System.out.println();
        // System.out.println(p);
        Map<Integer, Integer> m = new TreeMap<>(Collections.reverseOrder());
        m.put(0, -5);
        m.put(1, -2);
        m.put(2, 5);
        m.put(3, 0);
        m.put(4, 1);
        Polynomial sp = new SparsePolynomial(m);
        Polynomial sp2 = new SparsePolynomial("-x^10");
        Polynomial sp3 = new SparsePolynomial("x^10");
        System.out.println(sp2.add(sp3));
    }
}
