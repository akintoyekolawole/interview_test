package com.adio.consultancy.group.recruitment.QuestionOneAndTwo;

import java.util.Scanner;

public class QuestionOne {

    static final int NUNMBER_OF_CHARACTERS = 150;
    static char count[] = new char[NUNMBER_OF_CHARACTERS];
    private static void characterCountInArray(String str)
    {
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;
    }
    private static int firstNonRepeating(String str)
    {
        characterCountInArray(str);
        int index = -1, i;
        for (i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                index = i;
                break;
            }
        }
        return index;
    }
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = s.nextLine();
        int index = firstNonRepeating(str);
        System.out.println( "First non-repeating character is : " + str.charAt(index));
    }
}
