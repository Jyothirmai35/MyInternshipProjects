import java.util.*;

class Question {
    private String question;
    private List<String> options;
    private int correctOptionIndex;

    public Question(String question, List<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestion());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            System.out.print("Enter your choice: ");
            int userChoice = scanner.nextInt();

            if (userChoice == question.getCorrectOptionIndex() + 1) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
        }

        System.out.println("Quiz completed! Your score: " + score + "/" + questions.size());
        if(score==5){
              System.out.println("Your Performance is OUTSTANDING");
        }
        else if(score==4){
             System.out.println("Your performance is VERY GOOD");
        }
        else if(score==3){
             System.out.println("Your performance is GOOD");
        }
        else{
             System.out.println("NEED TO BE IMPROVED");
       }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Java was invented by?", Arrays.asList("James Gosling", "Dennis Ritchie", "Sun MicroSystems", "guido van rossum"), 2));
        questions.add(new Question("Number of Primitive datatypes in Java?", Arrays.asList("6", "7", "8", "9"), 2));
        questions.add(new Question("Automatic type conversion is possible in which of the cases?", Arrays.asList("Byte to int", "int to long", "long to int", "short to int"), 1));
        questions.add(new Question("Select the valid Statement:",Arrays.asList("char[] ch=new char(5)","char[] ch=new char[5]","char[] ch=new char()","char[] ch=new char[]"), 1));
        questions.add(new Question("compareTo() returns?",Arrays.asList("True","False","An Int value","None"), 2)); 

        // Create quiz
        Quiz quiz = new Quiz(questions);

        // Start quiz
        quiz.start();
    }
}
