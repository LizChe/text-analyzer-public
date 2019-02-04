package com.codecool.textexpert.services;

import java.util.Iterator;
import java.util.Set;

/**
 * StatisticalAnalysis is the dataset. It is initialized with Iterator and provides functions for statistical analysis
 * of the text elements (Strings). NOTE: You may choose any data structure to store the processed data.
 * The choice will affect the amount of code you will have to write.
 */
public class StatisticalAnalysis {

   public StatisticalAnalysis(Iterator<String> iterator) {
       /**
        * Implement constructor here
        */
   }

   public int countOf(String... elems) {
       /**
        * @return sum of all occurences of the elements given as arguments
        */
   }

   public int dictionarySize() {
       /**
        * @return the numbber of unique elements of the dataset
        */
   }

   public int size() {
       /**
        * @return the total number of all elements. The total number of words
        * or characters
        */
   }

   public Set<String> occurMoreThan(Integer n) {
       /**
        * @return all the elements that occur more than n_times in the dataset
        */
   }
}
