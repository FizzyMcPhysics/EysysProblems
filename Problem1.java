public class Problem1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String[] abnormalList = {
            "Java enginer", 
            "C# engineer", 
            "Software Engineer", 
            "Chartered Surveyor", 
            "Accountant", 
            "Chief Accountant",
            "Charterd Acowntant"
        };
        
        Normaliser2 norm = new Normaliser2();
        
        for (String job : abnormalList) {
            String normalisedTitle = norm.normalise(job);
            System.out.println(job + " ----> " + normalisedTitle 
                         + ", Certainty:" + norm.certaintyOfBestGuess + ".");
            System.out.println();
        }
        
    }
}
