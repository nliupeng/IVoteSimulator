
import java.util.ArrayList;
import java.util.Random;


/****
 * A multi-type response from an user to be submitted to a survey
 * For simulation purposes, answers are set in a random fashion
 * @author nliupeng
 */
class MultiTypeResponse implements IResponse {

    private final AnswerGroup answerGroup;
    private ArrayList<String> responseList;
    
    public MultiTypeResponse(AnswerGroup answerGroup) {
        this.answerGroup = answerGroup;
        responseList = new ArrayList<String>();
    }
    
    @Override
    public void setAnswers() {
        // Set answers randomly for simulation purposes
        Random randomGenerator = new Random();
        ArrayList<String> possibleAnswers = new ArrayList<>(answerGroup.getPossibleAnswers());
        
        int totalTries = randomGenerator.nextInt(answerGroup.size()+1);
        
        for (int i=0; i<totalTries; i++) {            
            int random = randomGenerator.nextInt(possibleAnswers.size()); 
            String submittedAnswer = possibleAnswers.get(random);
            
            responseList.add(submittedAnswer);
            possibleAnswers.remove(random);
        }
    }

    @Override
    public ArrayList<String> getAnswers() {       
        return responseList;
    }   
    
}
