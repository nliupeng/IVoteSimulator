
import java.util.ArrayList;


/****
 * An answer group supporting multiple correct answers
 * @author nliupeng
 */
public class MultiTypeAnswerGroup extends AnswerGroup {
    
    private ArrayList<String> correctAnswers;
    
    public MultiTypeAnswerGroup(ArrayList<String> possibleAnswers) {
        super(possibleAnswers);  
    }
    
    public MultiTypeAnswerGroup(ArrayList<String> possibleAnswers, ArrayList<String> correctAnswers) {
        super(possibleAnswers);
        this.correctAnswers = correctAnswers;    
    }
      
    public ArrayList<String> getCorrectAnswers() {
        return correctAnswers;
    }
    
}
