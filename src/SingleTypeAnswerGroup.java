
import java.util.ArrayList;


/****
 * An answer group supporting only a single correct answer
 * @author nliupeng
 */
public class SingleTypeAnswerGroup extends AnswerGroup {
    
    private String correctAnswer;
    
    public SingleTypeAnswerGroup(ArrayList<String> possibleAnswers) {
        super(possibleAnswers);
    }
    
    public SingleTypeAnswerGroup(ArrayList<String> possibleAnswers, String correctAnswer) {
        super(possibleAnswers);
        this.correctAnswer = correctAnswer;
    }
    
    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
