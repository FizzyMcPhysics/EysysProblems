/**
 *
 * @author benjamin
 */
public class Problem1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String[] abnormalList = {"Java engineer", "C# engineer", "Accountant", "Chief Accountant"};
        
        Normaliser norm = new Normaliser();
        
        for (String job : abnormalList) {
            String normalisedTitle = Normaliser.normalise(job);
            System.out.println("'" + job + "'" + " is most likely a type of " + "'" + normalisedTitle + "'");
            System.out.println();
            //System.out.println();
        }
        
    }
}
