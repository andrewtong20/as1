/*
Andrew Tong
Mr. Ritter
Feb. 20, 2019
AS1

This program finds the location, area, circumference, volume and surface area of the circle/sphere given a radius and x/y coordinates.
It also asks the user for meters and converts it into the corresponding number of miles, feet, and inches. Then it prints the meters and the miles, feet, and inches to "meters.txt"
Finally, it reads a line of text from the user, outputs the line with the first word moved to the end of the line, and prints the length of the string
*/
package as1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class As1 {

    public static void main(String[] args) throws FileNotFoundException
    {
        //Part 1: Circle
        //inputs
        Scanner in = new Scanner(System.in); 
        
        System.out.println("Welcome to Andrew's Assignment 1."); //instructions say to add user intro
        System.out.println("This program will: ");
        System.out.println("1) take a radius  and x/y coordinates to find the location, area, circumference,\n volume and surface area of the circle/sphere");
        System.out.println("2) takes a length in meters, converts it to miles, feet, and inches, \n and outputs it to \"meters.txt\"");
        System.out.println("3) takes a line of text, outputs the line with the first word moved to the end of the line,\n and prints the length of the string. ");
        System.out.println();
        System.out.println("You are entering the first part of the program where we will construct a circle.");
        System.out.println("The program will ask for x/y coordinates and a radius and output the location, area,\n circumference, volume, and surface area.");
        System.out.println("What is your name?");
        String User=in.nextLine();//Instructions ask to prompt user to input their name to address them later
        
        System.out.println(User+ ", what is the x coordinate of your circle? ");
        double xCoord=in.nextDouble();
        
        System.out.println(User+", what is the y coordinate of your circle? ");
        double yCoord=in.nextDouble();
        
        System.out.println(User+ ", what is the radius of your circle? ");
        double radius=in.nextDouble();
        
        //choosing parameter constructor over default constructor to be more efficient; program does not have to create the same object again
        circle userCircle=new circle(radius);
        
        System.out.println();
        //outputs
        System.out.println(User+", your circle has the following values.");
        System.out.println("X location: "+ xCoord);//instructions do not require rounding on location
        System.out.println("Y location: "+ yCoord);//location should be exact to what the user inputs
        
        System.out.printf("Area (rounded to 2 decimal places): %.2f \n", userCircle.getArea());//Rounded to 2 decimal places for user readibility and ease of uses
        System.out.printf("Circumference (rounded to 2 decimal places): %.2f \n", userCircle.getCircum()); //Rounded to 2 decimal places for user readibility and ease of uses
        System.out.println();
        
        System.out.println(User+", if your circle was a sphere with the same radius, it would have these following values.");
        System.out.printf("Volume (rounded to 2 decimal places): %.2f \n", userCircle.getVolume()); //Rounded to 2 decimal places for user readibility and ease of uses
        System.out.printf("Surface area (rounded to 2 decimal places): %.2f \n", userCircle.getSurface()); //Rounded to 2 decimal places for user readibility and ease of uses
        
        
        //Part 2: Meter conversion
        
        System.out.println();
        System.out.println();
        System.out.println(User+", you are now entering the second part of the program.");
        System.out.println("The program will ask for a length in meters and convert it to its equivalent miles, \n feet, and inches and output these values to \"meters.txt\"");
                
        
        System.out.println("What is your length in meters (do not input units)?");
        double meters=in.nextDouble();
        
        //Conversion Factors
        double meters2miles=1609.34; //conversion factors from Google
        double meters2feet=.3048;
        double meters2inches=.0254;
        
        //Dividing by miles
        
        double metersRemain = meters%meters2miles;//remainder division to get meters left over that could not be converted to whole miles
        double miles = (meters-metersRemain)/meters2miles; //integer division to get the miles in integer form from meters
        int milesFinal= (int) miles; //convert to integer so that the miles won't have the unnecessary decimal of .0 when displaying it
        
        //Dividing by feet
        double metersRemain2=metersRemain%meters2feet;//remainder division to get meters left over not divisible into feet
        double feet= (metersRemain-metersRemain2)/meters2feet; //integer division to get feet in integer form from meters
        int feetFinal= (int) feet; //removes unnecessary .0 for visual pleasure
        
        //Dividing by inches
        double inches= metersRemain2/meters2inches;//double division because the inches division will not be an exact integer.
        
        //conversion
        System.out.println(User+", your length of "+ meters +" meters is equivalent to:");
        System.out.println(milesFinal+" miles");//units required for user experience
        System.out.println(feetFinal+" feet");
        System.out.printf("%.2f inches \n", inches);//only inches should be a double and for ease of use, rounded to 2 decimal places.
        
        //output to file
        PrintWriter out=new PrintWriter("meters.txt");//per instructions, output to meters.txt file; Mr. Ritter said to ignore yellow warning
        out.println(meters); //directions do not say including units in the output file
        out.println(milesFinal);//so no units attached because the units can interfere with what the user wants to do with output file
        out.println(feetFinal);
        out.printf("%.2f \n", inches);//inches to 2 decimal places for visuals
        
        
        out.close();//need to close the PrintWriter to fully save the document in meters.txt
        
        //Part 3: String Manipulation
        
        System.out.println();
        System.out.println();
        System.out.println(User+", you are now entering the third part of the program.");
        System.out.println("This part will take a line of text and move the first word to the end,\n changing the capitalizations of the first two words to \n match the creation of a new sentence, and finds the length of the string");
        
        System.out.println("Enter a line of text.  No punctuation please.");
        String junk = in.nextLine();//Note: junk because from numbers to string, not a comment, removes the enter in queue
        String userInput= in.nextLine();
        
        System.out.println("I have rephrased the line to read: ");
        
        String space= " ";
        int endPosition=userInput.indexOf(space);//identifies the positions of the first word/substring
        String firstWord= userInput.substring(0,endPosition);//As per the instructions, can move this substring to the end
        int startPosition=endPosition+1; //note: new start position of sentence here, not a comment
        String restOfSentence=userInput.substring(startPosition);
        
        //capitalizations
        char char1=firstWord.charAt(0);
        char char1down= Character.toLowerCase(char1);//instructions require the first word's first character to be lower case because it will be at the end of a sentence.
        String firstWordTrunc=firstWord.substring(1);
        String firstWordOutput=char1down+ firstWordTrunc;
        
        char char2=restOfSentence.charAt(0);
        char char2up=Character.toUpperCase(char2);//instructions require the second word's first character to be upper case because it begins a sentence.
        String restOfSentenceTrunc=restOfSentence.substring(1);
        String restOfSentenceOutput=char2up+restOfSentenceTrunc;
        
        System.out.println(restOfSentenceOutput+space+firstWordOutput);
        
        //finding length
        System.out.println("The line of text has "+ userInput.length()+" characters in it.");//instructions require the length of string
        
        System.out.println();
        System.out.println(User+ ", thank you for using Andrew's Assignment 1!");//instructions require user friendliness
        
    }
    
}
