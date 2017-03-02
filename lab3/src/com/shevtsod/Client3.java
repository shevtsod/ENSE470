package com.shevtsod;

import com.shevtsod.componentdecorators.*;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Daniel Shevtsov
 */
public class Client3 {
	/**
	 * Main program entry point
	 * @param args String arguments from console (unused)
	 */
	public static void main(String[] args) {
		
		System.out.println("CAR CUSTOMIZER SIMULATOR");
		System.out.println(" This program uses the decorator pattern to allow customization of " +
                "a car purchase.\n");

		//Base car object
		Car car = new BaseCar();

		//Keep track of currently added customizations, so that user can only add each
        //customization once
        boolean isAdded[] = new boolean[ComponentDecorator.NUM_DECORATORS];

		//User input handling objects
        Scanner input = new Scanner(System.in, "UTF-8");
        boolean correctInput = false;
        int nInput = 0;

        do {
            System.out.println("Enter an option:\n" +
                    " 0 - Complete Purchase\n" +
                    " 1 - Add Winter Package\n" +
                    " 2 - Add Custom Color Package\n" +
                    " 3 - Add Drivetrain Package\n" +
                    " 4 - Add Premium Interior Package\n" +
                    " 5 - Add Entertainment Package\n"
            );
            //Print current car information
            printCarInformation(car);
            System.out.println();

            //Get user input
            correctInput = false;
            do {
                System.out.print("\tINPUT: ");
                try {
                    nInput = input.nextInt();
                    if (nInput >= 0 && nInput <= 5)
                        correctInput = true;
                    else
                        System.out.println(" - ERROR: Incorrect input value");
                    input.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println(" - ERROR: Incorrect input type");
                    input.nextLine();
                }
            } while (!correctInput);

            //If input was 0, leave the loop here and end the customization
            if(nInput == 0)
                break;

            //Check if the selected package has already been added, if so, skip to the next iteration
            //of the loop
            if(isAdded[nInput - 1]) {
                System.out.println(" - ERROR: Package already added, cannot add again");
                continue;
            }

            //Process user input
            switch(nInput) {
                case 1:
                    car = new WinterDec(car);
                    break;
                case 2:
                    car = new ColorDec(car);
                    break;
                case 3:
                    car = new DrivetrainDec(car);
                    break;
                case 4:
                    car = new InteriorDec(car);
                    break;
                case 5:
                    car = new EntertainmentDec(car);
                    break;
                case 0: default:
                    break;
            }

            //Remember that this package has been added
            isAdded[nInput - 1] = true;

        } while(nInput != 0);

        //Print final order information
        System.out.println("\nORDER COMPLETE, FINAL ORDER INFORMATION:");
        printCarInformation(car);

        input.close();

		System.out.println("\nProgram completed successfully.");
	}

    /**
     * Helper method to format and print a Car object's information.
     * @param c The Car object to print the information of
     */
	private static void printCarInformation(Car c) {
        DecimalFormat currency = new DecimalFormat("#,####,###.00 CAD");
        System.out.println("YOUR ORDER:\n" + c.getInformation());
        System.out.println("PRICE TOTAL: " + currency.format(c.getPrice()));
    }
}
