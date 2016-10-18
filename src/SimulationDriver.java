
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/****
 * Simulates a voting process by using the IVoteSimulator.
 * A random number of students are generated.
 * A survey is configured (it currently supports two types: SingleType and MultiType responses.
 * Each student submits a response to the IVoteService.
 * Results are displayed on screen.
 * @author nliupeng
 */
public class SimulationDriver {
    
    private static Random randomGenerator = new Random();
    
    public static void main(String[] args) {
        
        String question;
        ArrayList<String> possibleAnswers;
        AnswerGroup answerGroup;
        
        // Survey 1
        question = "GPA or education?";    
        possibleAnswers = new ArrayList<String>();
        possibleAnswers.add("GPA. I just want to graduate");
        possibleAnswers.add("Education. I come here to learn");
        answerGroup = new SingleTypeAnswerGroup(possibleAnswers);
        simulateSurvey(question, answerGroup);
        
        // Survey 2
        question = "Which of the following would be your potential pet?";    
        possibleAnswers = new ArrayList<String>();
        possibleAnswers.add("Dog");
        possibleAnswers.add("Cat");
        possibleAnswers.add("Hamster");
        possibleAnswers.add("Fish");
        possibleAnswers.add("Bird");
        answerGroup = new MultiTypeAnswerGroup(possibleAnswers);
        simulateSurvey(question, answerGroup);
        
        // Survey 3
        question = "What is the trickle-down effect?";    
        possibleAnswers = new ArrayList<String>();
        String correctAnswer = "A concept that states that resources flow vertically from upper to lower classes";
        possibleAnswers.add(correctAnswer);
        possibleAnswers.add("A phenomenon where a fake treatment can improve a person's health simply because of his or her expectations");
        possibleAnswers.add("The cumulative effect produced when one event sets off a chain of similar events");
        answerGroup = new SingleTypeAnswerGroup(possibleAnswers, correctAnswer);
        simulateSurvey(question, answerGroup);
    }
    
    private static void simulateSurvey(String q, AnswerGroup answerGroup) { 
        
        // Retrieving random number of students
        System.out.println("\nRetrieving random number of students...");
        int totalStudents = randomGenerator.nextInt(40);
        Student[] studentList = new Student[totalStudents];
        for (int i=0; i<studentList.length; i++) {
            studentList[i] = new Student();
        }
        System.out.println("Total number of participants: " + totalStudents);
        
        // Configuring survey 
        System.out.println("Configuring survey...");
        Collections.shuffle(answerGroup.getPossibleAnswers());
        IVoteService iVoteService = new IVoteService(new Question(q), answerGroup);
        
        // Accepting submissions for survey 
        System.out.println("Accepting user submissions...");
        for(Student student : studentList) {
            IResponse response = responseHelper(answerGroup);
            response.setAnswers();      // In this simulation it attempts to set answers in a random manner per user
            iVoteService.acceptSubmission(student.getId(), new Submission(response.getAnswers()));
        }
        
        // Displaying submission results
        System.out.println("Displaying survey results...");
        iVoteService.displayResults();
        System.out.println();
        iVoteService.displayStatResults();
    }
    
    /****
     * Select what type of response an user should be able to submit based on the type of the survey
     */
    private static IResponse responseHelper(AnswerGroup answerGroup) {
        if (answerGroup instanceof SingleTypeAnswerGroup) {
            return new SingleTypeResponse(answerGroup);
        }
        else if (answerGroup instanceof MultiTypeAnswerGroup) {
            return new MultiTypeResponse(answerGroup);
        }
        else {
            return new IResponse() {
                @Override
                public ArrayList<String> getAnswers() {
                    throw new UnsupportedOperationException("Response not supported."); 
                }
                @Override
                public void setAnswers() {
                    throw new UnsupportedOperationException("Response not supported."); 
                }
            };
        }
    } 
    
}
