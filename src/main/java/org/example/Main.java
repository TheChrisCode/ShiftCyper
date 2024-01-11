package org.example;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        final int shiftAmount = 13;


        Scanner input = new Scanner(System.in);


        System.out.println("Enter a scentence you want to be encrypted.");
        String message = input.nextLine();
        decrypt(shiftAmount, encrypt(shiftAmount, message));
    }


    public static String encrypt(int shiftAmount, String message)
    {
        String newMessage = "";
        for(int i = 0; i <= message.length() - 1; i++)
        {
            char oldChar = message.charAt(i);
            if((int) oldChar == 32)
            {
                newMessage += " ";
            }
            else
            {
                char newChar = (char) (((int) oldChar + shiftAmount - 97) % 26 + 97);
                newMessage += newChar;
            }
        }


        System.out.println("Encrypted Message: " + newMessage);
        return newMessage;
    }
    public static void decrypt(int shiftAmount, String message)
    {
        String newMessage = "";
        for(int i = 0; i <= message.length() - 1; i++)
        {
            char oldChar = message.charAt(i);
            if((int) oldChar == 32)
            {
                newMessage += " ";
            }
            else
            {
                char newChar;
                int newLoc = ((((int) oldChar - 97) - shiftAmount) % 26);
                if(newLoc < 0)
                {
                    newChar = (char) (26 + newLoc + 97);
                }
                else
                {
                    newChar = (char) (newLoc + 97);
                }
                newMessage += newChar;
            }
        }


        System.out.println("Decrypted Message: " + newMessage);
    }


}
