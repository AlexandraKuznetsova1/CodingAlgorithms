package Encode;

import Encode.Segment;

public class ArithmeticCoding {

    Segment[] defineSegments(char[] letters, double[] probability) {
        Segment[] segment = new Segment[10000];
        double l = 0;
        for (int i = 0; i < letters.length; i++) {
            segment[letters[i]] = new Segment(l,l + probability[i]);
            l = segment[letters[i]].right;
        }
        return segment;
    }

    double arithmeticCoding(char[] letters, double[] probability, String s) {
        Segment[] segments = defineSegments(letters, probability);
        double left = 0;
        double right = 1;
        for (int i = 0; i < letters.length; i++) {
            char symb = s.charAt(i);
            double newRight = left + (right - left) * segments[symb].right;
            double newLeft = left + (right - left) * segments[symb].left;
            right = newRight;
            left = newLeft;
        }
        return (left + right) / 2;

    }
}
