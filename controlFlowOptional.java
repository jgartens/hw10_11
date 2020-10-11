
/**
 * optional control flow lab for FTCI 
 * Jacob Gartenstein 10/11
 */

import java.util.Scanner;


import java.util.Random;

public class controlFlowOptional {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //print out acceptable numbers
        AsciiChars.printNumbers();
        AsciiChars.printUpperCase();
        AsciiChars.printLowerCase();

        //beginning of interactive portion
        System.out.print("Please enter your name: ");   
        String user_name = scanner.next();  
        System.out.printf("Hello %s\n", user_name);

        System.out.print("Would you like to continue to the interactive portion?\n");
        String cont = scanner.next();
        switch(cont){
            //continue with interactive program
            case "y": case "Y": case "yes": case "Yes":
                survey(scanner);
                System.out.print("Would you like to generate a new set of numbers? (y or n) ");
                while (scanner.next().equals("y")){
                    survey(scanner);
                    System.out.print("Would you like to generate a new set of numbers? (y or n) ");
                }
                System.out.print("Thank you for playing. Good luck!\n");
                break;
            //do not continue
            default: 
                System.out.print("Please return later to complete the survey. Goodbye\n");
                break;
        }


    }
    
    //function which contains the interactive "survey"
    public static void survey(Scanner scanner){
        Random rand = new Random();
        int rand1 = rand.nextInt(1000);
        int rand2 = rand.nextInt(1000);
        int rand3 = rand.nextInt(1000);

        System.out.printf("What is the name of your favorite pet? ");
        String pet = scanner.next();
        System.out.printf("What is (or was) the age of your favorite pet? ");
        int pet_age = scanner.nextInt();
        System.out.printf("What is your lucky number? (whole number) ");
        int lucky_num = scanner.nextInt();
        System.out.printf("Do you have a favorite quarterback? (y or n) ");
        int quarterback = 1000;
        if (scanner.next().equals("y")){
            System.out.printf("Enter your favorite quarterback's jersey number: ");
            quarterback = scanner.nextInt();
        }
        System.out.printf("What is the two-digit model year of your car? (ex 08 , 19) ");
        int car_year = scanner.nextInt();
        System.out.printf("What is the first name of your favorite actor or actress? ");
        String actor = scanner.next();
        System.out.printf("Please enter a random number between 1 and 50: ");
        int rand_num = scanner.nextInt();

        int magic_ball;
        if (quarterback == 1000){
            magic_ball = lucky_num * rand1;
        }
        else {
            magic_ball = quarterback * rand1;
        }
        magic_ball = magic_ball % 75;

        int num1 = ((int) pet.charAt(2)) % 69;
        int num3 = ((car_year + lucky_num) * rand2) % 69;
        int num2 = ((int) actor.charAt(0) + (int) actor.charAt(actor.length() - 1)) % 69;
        int num4 = Math.abs(rand_num - rand3) % 69;
        int num5 = ((pet_age + car_year) * rand_num + 42) % 69;

        System.out.printf("Lottery numbers: %d, %d, %d, %d, %d  Magic ball: %d\n", num1, num2, num3, num4, num5, magic_ball);
    }

    public static class AsciiChars {
        public static void printNumbers() {
            for (int i = 48; i < 58; i++) {
                System.out.printf("%c ", i);
            }   
        }

        public static void printLowerCase() {
            for (int i = 97; i < 123; i++) {
                System.out.printf("%c ", i);
            }    
            System.out.print("\n\n");
        }

        public static void printUpperCase() {
            for (int i = 65; i < 91; i++) {
                System.out.printf("%c ", i);
            }
        }
    }
}
