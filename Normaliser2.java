import java.util.Arrays;

/**
 *
 * @author benjamin
 */
public class Normaliser2 {
    String[] normalList = {
        "- NO MATCHES -", 
        "Architect", 
        "Software engineer", 
        "Quantity surveyor", 
        "Accountant"
    };
    int size = normalList.length;
    double[] scores = new double[size];
    double certaintyOfBestGuess;
    
    public String normalise(String userJob) {
        
        LevenshteinDistance compare = new LevenshteinDistance();
        
        for (int i=1; i < size; i++)
        {
            scores[i] = compare.similarityBetween(userJob, normalList[i]);
            
        }
        
        //System.out.println(Arrays.toString(scores));
        
        String bestGuess = findGuess(scores); 
        
        return bestGuess;    
    }
    
    public String findGuess(double[] array) {
    double highest = 0;
    int maxKey=0;

    for (int i=0; i < array.length; i++) {
        if (array[i] > highest) 
        {
            highest = array[i];
            maxKey = i;
        }
    }
    
    String positionOfBestGuess = normalList[maxKey];
    certaintyOfBestGuess = scores[maxKey];
    
    return positionOfBestGuess;
    }
    

}
