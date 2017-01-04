/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   01/12/2016.
 */
public class VowelAndConsonants
{
    private String sentence;
    char[] vowels = {'a','e','i','o','u'};

    public VowelAndConsonants(String sentence)
    {
        this.sentence = sentence;
    }

    public void setSentence(String sentence)
    {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }


    public int countVowelsAndConsonants()
    {
        int count = 0;

        char[] letters = sentence.toCharArray();
        for(char letter : letters) {
            if(Character.isLetter(letter))
                count++;
        }

        return count;
    }


    public int countVowels()
    {
        int i;
        int count = 0;

        char[] letters = sentence.toCharArray();
        for(char letter : letters)
        {
            if(Character.isLetter(letter))
            {
                for(i=0; i<5; i++) {
                    if(Character.toLowerCase(letter) == vowels[i]) {
                        count++;
                        i = 6;
                    }
                }
            }
        }

        return count;
    }


    public int countConsonants()
    {
        int i;
        int count = 0;

        char[] letters = sentence.toCharArray();
        for(char letter : letters)
        {
            if(Character.isLetter(letter))
            {
                // Check if the character is a constant
                for(i=0; i<5; i++)
                {
                    if(Character.toLowerCase(letter) == vowels[i])
                        i = 5;
                }

                if(i!=6)
                    count++;
            }
        }

        return count;
    }
}
