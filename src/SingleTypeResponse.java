
import java.util.ArrayList;
import java.util.Random;


/****
 * A single-type response from an user to be submitted to a survey
 * For simulation purposes, answer is set in a random fashion
 * @author nliupeng
 */
class SingleTypeResponse implements IResponse {

    private final AnswerGroup answerGroup;
    private ArrayList<String> responseList;

    public SingleTypeResponse(AnswerGroup answerGroup) {
        this.answerGroup = answerGroup;
        responseList = new ArrayList<String>();
    }

    @Override
    public void setAnswers() {
        // Set answers randomly for simulation purposes
        Random randomGenerator = new Random();
        int random = randomGenerator.nextInt(answerGroup.size());

        String submittedAnswer = answerGroup.getPossibleAnswers().get(random);                
        responseList.add(submittedAnswer);
    }
    
    @Override
    public ArrayList<String> getAnswers() {
        return responseList;
    }
    
}
