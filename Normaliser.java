/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Eysys;

import java.util.StringTokenizer;

/**
 *
 * @author benjamin
 */
public class Normaliser {
    String[] normalList = {
        "- NO MATCHES -", 
        "Architect", 
        "Software engineer", 
        "Quantity surveyor", 
        "Accountant"
    };
    int size = normalList.length;
    int[] scores = new int[size];
    
    public String normalise(String userJob) {
        
        StringTokenizer uJT = new StringTokenizer(userJob); 
        String[] userJobTokens = toArray(uJT);
        int jMax = userJobTokens.length;

        for (int i=0; i<normalList.length; i++) {
            int wordsInCommon = 0;
            
            String normalJob = normalList[i];
            StringTokenizer nJT = new StringTokenizer(normalJob);
            String[] normalJobTokens = toArray(nJT);
            int kMax = normalJobTokens.length;
            
            //System.out.println("Comparing " + userJob + " with " + normalJob);

            for (int j=0; j<jMax; j++) {
                String Token1 = userJobTokens[j];
                
                for (int k=0; k<kMax; k++) {
                    String Token2 = normalJobTokens[k];
                    
                    //System.out.println("Comparing " + Token1 + " with " + Token2);
                    if (Token1.equalsIgnoreCase(Token2)) {
                        wordsInCommon++;  
                        //System.out.println("Match!");
                    }
                    //else 
                        //System.out.println("Not a match.");
                    
                    //System.out.println("Words in common so far: " + wordsInCommon);
                }

            }
            //System.out.println("User inputed job: '" + userJob + "' and normal job: '" + normalJob + "' have " + wordsInCommon + " word(s) in common.");
            //System.out.println();
            scores[i] = wordsInCommon; 
        }
        
        //System.out.println(Arrays.toString(scores));
        int positionOfBestGuess = findGuess(scores);
        String bestGuess = normalList[positionOfBestGuess];       
        return bestGuess;    
    }
    
    public int findGuess(final int[] array) {
    int maxKey = 0;

    for (int i=0; i < array.length; i++) {
        if (array[i] >= 1) 
            maxKey = i;
        
    }
    //System.out.print(maxKey);
    return maxKey;
    }
    
    public void display(StringTokenizer tokens) {
        while (tokens.hasMoreElements()) {
			System.out.println(tokens.nextElement());
		}
    }
    
    public String[] toArray(StringTokenizer tokens) {
        String[] tokenArray = new String[tokens.countTokens()];
        int i=0;
        while (tokens.hasMoreElements()) {
                tokenArray[i] = tokens.nextToken();
                i++;
            } 
        return tokenArray;
    }
}
