package com.adio.consultancy.group.recruitment.QuestionOneAndTwo;

import java.util.Scanner;

public class QuestionTwo {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please input string here : ");
        String string1 = s.nextLine();
        int count;
        char string[] = string1.toCharArray();
        System.out.println("The Repeated characters in a string with corresponding counts : ");
        for(int i = 0; i <string.length; i++) {
            count = 1;
            for(int j = i+1; j <string.length; j++) {
                if(string[i] == string[j] && string[i] != ' ') {
                    count++;
                    string[j] = '0';
                }
            }
            if(count > 1 && string[i] != '0')
                System.out.println(string[i] + " = " + count);
        }
    }
}
