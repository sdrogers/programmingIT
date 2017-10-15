/**
 Class to model data for a guessing game
*/

import java.util.*;

public class QuizSetter
{
//a class to mangage a number guessing game
	private final static Random rand = new Random();
	private int answer;
	
	/**initialises the answer to a random number between 1 and 10 inclusive
	* @param rand is the Random number generater
	 */
	public QuizSetter()
	
	{
		answer = rand.nextInt(10)+1;
		System.out.println(answer);
	}
	
	/**returns answer
	 *@return the value of the instance variable answer
	 */
	public int getAnswer()
        {
	    return answer;
        }

	/**returns true if guess is equal to answer	
	 *@param guess an integer representing a guess
	 *@return true if guess is equal to answer, otherwise false
	 */
	public boolean guessCorrect(int guess)
	{
	    return (guess==answer);
	}
   
	/**returns true if guess is within 1 answer	
	 *@param guess an integer representing a guess
	 *@return true if guess is within 1 of answer, otherwise false
	 */
        public boolean guessClose(int guess)
        {
	    return Math.abs(guess-answer)==1;
	    //or return (guess-answer)==1||(answer-guess)==1
        }
   
	/**returns true if guess is bigger than answer	
	 *@param guess an integer representing a guess
	 *@return true if guess is bigger than answer, otherwise false
	 */
        public boolean guessTooBig(int guess)
        {
	    return guess>answer;
        }
}
