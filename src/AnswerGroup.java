
import java.util.ArrayList;


/****
 * Defines a group of answers for a given survey
 * Contains list of possible answers
 * @author nliupeng
 */
public abstract class AnswerGroup {
    
    private ArrayList<String> possibleAnswers;
    
    public AnswerGroup(ArrayList<String> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }
    
    public int size() {
        return possibleAnswers.size();
    }
    
    public ArrayList<String> getPossibleAnswers() {
        return possibleAnswers;
    }
    
}
