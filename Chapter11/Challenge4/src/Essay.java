/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   11/12/2016.
 */
public class Essay extends GradedActivity
{
    private int grammar;
    private int spelling;
    private int correctLength;
    private int content;


    public Essay()
    {
        super();
        grammar = 0;
        spelling = 0;
        correctLength = 0;
        content = 0;
        setScore(0);
    }

    public Essay(int grammar, int spelling, int correctLength, int content)
    {
        super();
        this.grammar = grammar;
        this.spelling = spelling;
        this.correctLength = correctLength;
        this.content = content;
        setScore(calculateScore());
    }

    public int calculateScore()
    {
        return grammar + spelling + correctLength + content;
    }

    public void setGrammar(int grammar) {
        if(validGrammarScore()) {
            this.grammar = grammar;
            setScore(calculateScore());
        }
        else
            System.out.println("The Grammar score was entered incorrectly!");
    }

    public int getGrammar() {
        return grammar;
    }

    public void setSpelling(int spelling) {
        if(validSpellingScore()) {
            this.spelling = spelling;
            setScore(calculateScore());
        }
        else
            System.out.println("The Spelling score was entered incorrectly!");
    }

    public int getSpelling() {
        return spelling;
    }

    public void setCorrectLength(int correctLength) {
        if(validCorrectLengthScore()) {
            this.correctLength = correctLength;
            setScore(calculateScore());
        }
        else
            System.out.println("The Correct Length score was entered incorrectly!");

    }

    public int getCorrectLength() {
        return correctLength;
    }

    public void setContent(int content) {
        if(validContentScore())
        {
            this.content = content;
            setScore(calculateScore());
        }
        else
            System.out.println("The Content score was entered incorrectly!");
    }

    public int getContent() {
        return content;
    }

    public boolean validGrammarScore() {
        return grammar<=30 && grammar>=0;
    }

    public boolean validSpellingScore() {
        return spelling<=20 && spelling>=0;
    }

    public boolean validCorrectLengthScore() {
        return correctLength<=20 && correctLength>=0;
    }

    public boolean validContentScore() {
        return content<=30 && content>=0;
    }

    public boolean ScoresAreValid()
    {
        return validGrammarScore() && validSpellingScore() &&
                validCorrectLengthScore() && validContentScore();
    }

    public char getGrade()
    {
        if(ScoresAreValid())
            return super.getGrade();
        else
        {
            System.out.println("The scores were entered incorrectly!");
            return 'U';
        }

    }
}
