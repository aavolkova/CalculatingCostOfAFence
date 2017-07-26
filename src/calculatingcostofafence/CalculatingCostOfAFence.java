package calculatingcostofafence;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CalculatingCostOfAFence {

	public static void main(String[] args) {
		
		// Declare constants
		final double WOODEN_FENCE_COST_PER_FOOT = 25;
		final double CHAIN_LINK_FENCE_COST_PER_FOOT = 15;
		final double GATE_COST = 150;
		final double BUILDING_PERMIT_COST = 50;
		final double TAX_RATE = 0.06;
				 
		// Declare variables
		double yardWidth;
		double yardLength;
		int fenceMaterialIndex;
		int gatesNumber = 1;
		double materialCostPerFoot = 0;
		double fencePrice = 0; //price including installation and excluding the building permit
		 
		// Create a Scanner object
		Scanner scan = new Scanner (System.in);
		
		// Prompt the user about what this program will do.
		System.out.println("*** Calculating Cost of a Fence Project ***");
		System.out.println("");
		
		// Get input from the user
		// Get dimensions 
		System.out.print("Enter the width of your yard in feet: ");
		yardWidth = scan.nextDouble();
		while(yardWidth < 0)
		{
			System.out.println("You cannot have a negative number for yard width.");
			System.out.print("Enter the width of your yard in feet: ");
			yardWidth = scan.nextDouble();
		}
		System.out.print("Enter the length of your yard in feet: ");
		yardLength = scan.nextDouble();
		while(yardLength < 0)
		{
			System.out.println("You cannot have a negative number for yard length.");
			System.out.print("Enter the length of your yard in feet: ");
			yardLength = scan.nextDouble();
		}
		// Get material choice 
		System.out.println("What material would you like for the fence?");
		System.out.print("Enter 1 for the Wooden fencing or 2 for the Chain-link fencing: ");
		fenceMaterialIndex = scan.nextInt();
		while (fenceMaterialIndex != 1 && fenceMaterialIndex != 2)
		{
			System.out.println("Invalid choice!");
			System.out.print("Enter 1 for the Wooden fencing or 2 for the Chain-link fencing: ");
			fenceMaterialIndex = scan.nextInt();
		}
		switch (fenceMaterialIndex)
		{
			case 1: 
				materialCostPerFoot = WOODEN_FENCE_COST_PER_FOOT;
				break;
			case 2: 
				materialCostPerFoot = CHAIN_LINK_FENCE_COST_PER_FOOT;
		}
		// Get number of gates 
		System.out.print("How many gates would you like to install? (1/2/3): ");
		gatesNumber = scan.nextInt();
		while(gatesNumber < 1 || gatesNumber > 3)
		{
			if(gatesNumber < 1)
			{
				System.out.println("At least one gate is required.");
				System.out.print("How many gates would you like to install? (1/2/3): ");
				gatesNumber = scan.nextInt();
			}
			else
			{
				System.out.println("You can install up to 3 gates only.");
				System.out.print("How many gates would you like to install? (1/2/3): ");
				gatesNumber = scan.nextInt();
			}
		}
		
		// Calculate the total cost of a fence
		fencePrice = ((yardWidth * yardLength) * materialCostPerFoot + gatesNumber * GATE_COST) 
				+ ((yardWidth * yardLength) * materialCostPerFoot + gatesNumber * GATE_COST) * TAX_RATE + BUILDING_PERMIT_COST;
		
		// Display the total cost of the fence
		System.out.println("***");
		System.out.printf("The total cost of a fence is: $%.2f%n", fencePrice);
	}

}
