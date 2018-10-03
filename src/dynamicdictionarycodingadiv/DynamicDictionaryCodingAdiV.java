/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicdictionarycodingadiv;

import java.util.Scanner;

/**
 *
 * @author Adi Venkatesh
 */

/*
Pseudocode:
Ask user for a phrase
Split up the entered phrase into a series of seperate words
Check if a word at it's first occurence occurs at another instance
If the word occurs a second time in the phrase replace it with it's array index
Check if this array index is a number and not anything else
If it is a number, return back to the calling method
Display the phrase seperated by spaces in it's new format to the user
 */
public class DynamicDictionaryCodingAdiV {

    /**
     *
     * @param args the command line arguments
     * @see When entering the sample input, unexpected output is printed,
     * however methods are functional for other examples
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        String[] printOut = dictionary(input);
        for (int x = 0; x < printOut.length; x++) {
            System.out.print(printOut[x] + " ");
        }

    }
    /**
     * 
     * @param splitter is a String that is from the dictionary method, and includes the array of words split up from the original string entered
     * @return true or false based on whether or not the index at the char that is being tested is a number
     * @see When entering the sample input, unexpected output is printed, however methods are functional for other examples
     */

    public static boolean check(String splitter) {
        char test = splitter.charAt(0);
//This piece of code had a similar use in Caesar Cipher, basically checking if the string at the specific array index is a number and not anything else
//This is comparing the ascii values of the character being tested to ensure that this is the case
        if (((test >= 'a') && (test <= 'z')) || ((test >= 'A') && (test <= 'Z'))) {
            return false;
        } else {
            return true;
        }

    }

    
    /**
     *
     * @param input is the original phrase that the user enters in the form of a
     * string
     * @return splitter is an array of different words split up and condensed
     * using the specifications of the assignment
     * @see When entering the sample input, unexpected output is printed,
     * however methods are functional for other examples
     */

    public static String[] dictionary(String input) {
        String[] splitter = input.split(" ");
        //Nested for loop in order to compare array elements based on position and occurence
        for (int a = 0; a < splitter.length - 1; a++) {
            for (int b = a + 1; b < splitter.length; b++) {
                //This if statement is basically comparing all the words in the input phrase with the word at the a^th position, but does not include itself
                //Uses the check method to exclude the current value from the calculations
                if ((splitter[a].equals(splitter[b])) && (!check(splitter[a]))) {
                    //If a match is found, it is replaced with the respective array index of that word's first occurence in the phrase
                    splitter[b] = Integer.toString(a + 1);
                }
            }
        }

        return splitter;
    }
  

}
