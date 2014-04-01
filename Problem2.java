

import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author benjamin
 */
public class Problem2 {

    /**
     * @param args the command line arguments
     */
    
     public static void main(String[] args) {
        
       int[] array = generateSomeHugeArray();
       System.out.println("Here is a huge array.");
       System.out.println(Arrays.toString(array));
       System.out.println();
       
       Arrays.sort(array);
       System.out.println("Here is the array, ordered.");
       System.out.println(Arrays.toString(array));
       System.out.println();
       
       int arraySize = array.length;
       
       int first = array[0];
       int last = array[arraySize-1];
       int range = last - (first-1);
       System.out.println("The range of the array is " + range + ",");
       System.out.println("with numbers ranging from " + first + " to " + last + ".");
       System.out.println();
              
       double meanAverageOfArray = findMeanAverage(array, arraySize);
       System.out.println("The mean average of the array elements is " + meanAverageOfArray + ".");
       System.out.println();
       
       double medianAverageOfArray = findMedianAverage(array, arraySize);
       System.out.println("The median average of the array elements is " + medianAverageOfArray + ".");
       System.out.println();
       
       ArrayList modeAverageOfArray = findModeAverage(array, arraySize, last);
       System.out.println("The mode average of the array elements is/are " + modeAverageOfArray + ".");
       System.out.println();
       
    }

    private static int[] generateSomeHugeArray() {
        /**
         * Creates an array of numbers which is between 50 and 75 numbers long
         * and contains integers between 40 and 60
         */
        Random randomNumber = new Random();
        
        int arraySize = 50 + randomNumber.nextInt(25);
        int arrayRange = 40 + randomNumber.nextInt(20);
        //System.out.println("range: " + arrayRange + " size: " + arraySize);
        int[] someHugeArray = new int[arraySize]; 
        
        for (int i=0; i<arraySize; i++) {
            someHugeArray[i] = randomNumber.nextInt(arrayRange) + 1;
        } 
        return someHugeArray;
    }
    
    private static double findMeanAverage(int[] array, int size) {
        double meanAverage;
        double total = 0;
        
        for (int i=0; i<size; i++) {
            total += array[i];
        }
        
        meanAverage = total/size;
                
        return meanAverage;        
    }
    
    private static double findMedianAverage(int[] array, int size) {
        double medianAverage;
        int halfSize = round(size/2); // This rounds up!
        
        if (size %2 ==0) {
            medianAverage = (array[halfSize]+array[halfSize -1]) / 2;
            System.out.println("Mean-Meadian:");
        }
        else {
            medianAverage = array[halfSize];
            System.out.println("True-Meadian:");
        }
        return medianAverage;
    }
    
    private static ArrayList findModeAverage(int[] array, int size, int highestNumber) {
        ArrayList maxKey = new ArrayList();
        int maxCounts = 0;
        int[] counts = new int[highestNumber+1];
        for (int i=0; i<size; i++) {            
            counts[array[i]]++;
            
            if (maxCounts < counts[array[i]]) {
                
                maxCounts = counts[array[i]];
                maxKey.clear();
         
            }
            if (maxCounts <= counts[array[i]]) {
                
                int index = array[i];
                String newWinner = Integer.toString(index);
                
                maxKey.add(newWinner);
            }
            
        }
        return maxKey;
    }
}
