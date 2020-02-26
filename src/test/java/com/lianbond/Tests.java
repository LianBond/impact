package com.lianbond;

import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    @Test
    public void testCase1() {
        Summarizer tester = new Summarizer();
        Vector<Integer> input = new Vector<>(tester.collect("1,2,3,4,5,6,8,11,-21,-20"));
        String output = tester.summarizeCollection(input);
        assertEquals("-21--20, 1-6, 8, 11", output, "Collect must remove duplicates");
    }

    @Test
    public void duplicateTest() {
        Summarizer tester = new Summarizer();
        Vector<Integer> output = new Vector<>(tester.collect("1,1,1"));
        assertEquals(1, output.size(), "Collect must remove duplicates");
    }

    @Test
    public void characterTest() {
        Summarizer tester = new Summarizer();
        Vector<Integer> output = new Vector<>(tester.collect("ads,^&,(),-+,1"));
        assertEquals(1, output.size(), "Collect must remove duplicates");
    }
}