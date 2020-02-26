package com.lianbond;

import java.util.*;

public class Summarizer implements NumberRangeSummarizer {
    //test type of collection is arraylist
    //test range with duplicates
    //test string mixed with characters etc
    //unit test that collect removes non numbers and duplicates
    //handle empty string
    // If this method returns something back to us, we want to collect the result to ensure it was correct.
    // Or, if method doesn't return anything, we want to check whether it produced the expected side effects.

    public Collection<Integer> collect(String input) {
        Vector<Integer> output = new Vector<>();
        String[] inputArray = input.split(",");
        for (String iteration : inputArray) {
            try {
                int toAdd = Integer.parseInt(iteration);
                if (!output.contains(toAdd)) { //check that no duplicates are added
                    output.add(toAdd);
                }
            } catch (NumberFormatException e) {

            }
        }
        return output;
    }

    public String summarizeCollection(Collection<Integer> input) {
        String output = "";

        Vector<Integer> c = new Vector<Integer>(input);
        Collections.sort(c);

        //create ranges
        int start;
        Integer next;
        Integer end = null;

        ArrayList<String> ranges = new ArrayList<>();
        for (int cnt = 0; cnt<c.size(); cnt++) {
            start = c.get(cnt);
            next = start;
            while(c.contains(next+1)) {
                next = next+1;
                c.remove(next);
                end = next;
            }
            if (end != null) {
                ranges.add(start + "-" + end);
            } else {
                ranges.add(start+"");
            }
            end = null;
        }
        Iterator i = ranges.iterator();
        while(i.hasNext()) {
            output += i.next()+"";
            if (i.hasNext()) { //don't add "," to the result if this is the last values in the range
                output+= ", ";
            }
        }
        return output;
    }

}


/*    class MyMainClass {
        public static void main(String[] args) {
            summarize a = new summarize();
            System.out.println(a.summarizeCollection(a.collect("")));
        }*/
