
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


/****
 * First configured with a give question type (SingleType or MultiType) and candidate answers.
 * Accepts submissions from users (1 answer per user. If multiple attempts, last one is counted)
 * Displays statistical results form survey.
 * @author nliupeng
 */
public class IVoteService {
    
    private Question question;
    private AnswerGroup answerGroup;
    private HashMap<String, Submission> submissions;
    
    public IVoteService(Question question, AnswerGroup answerGroup) {
        this.question = question;
        this.answerGroup = answerGroup;        
        submissions = new HashMap<String, Submission>();
    }
       
    public void acceptSubmission(String studentId, Submission answers) {
        submissions.put(studentId, answers);
    }
    
    public void displayResults() {
        for (String key : submissions.keySet()) {
            System.out.println(key + " " + submissions.get(key).getSubmittedAnswers());
        }
    }
    
    public void displayStatResults() {     
        ArrayList<String> responseList = new ArrayList<>();
        for (Submission submission : submissions.values()) {
            ArrayList<String> submittedAnswers = submission.getSubmittedAnswers();
            for (String answer : submittedAnswers) {
                responseList.add(answer);
            }
        }
        for (String answer : answerGroup.getPossibleAnswers()) {
            int count = Collections.frequency(responseList, answer);
            System.out.println("\"" + answer + "\": " + count);
        }
    }
    
}
