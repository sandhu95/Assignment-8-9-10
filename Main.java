import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// creating object of scanner class to take user input
		Scanner input = new Scanner(System.in);

		// creating the first block of blockChain
		BlockChain B1 = new BlockChain("First Block");

		// printing the info of first Block
		System.out.println("The Data for first Block is: " + B1.getData());
		System.out.println("The hash Code for first Block is: " + B1.getHash());

		// After changing the data of first block the hash changes
		B1.setData("Data Changed");
		B1.setHash();
		System.out.println("New Data for first Block is: " + B1.getData());
		System.out.println("New hash Code for first Block is: " + B1.getHash());

		// creating an array to store blockChain
		BlockChain[] BlockChainArray = new BlockChain[5];

		BlockChainArray[0] = B1;

		System.out.println();

		// creating the series blocks of blockChain and assume the number of blocks to
		// be 5
		for (int i = 1; i < BlockChainArray.length; i++) {
			BlockChainArray[i] = new BlockChain("", BlockChainArray[i - 1].getHash());
		}

		System.out.println("Following are the Blocks created in the BlockChain: ");

		// printing the data and hash codes of whole BlockChain
		for (int i = 0; i < BlockChainArray.length; i++) {
			System.out.println("Data for number " + (i + 1) + " Block is: " + BlockChainArray[i].getData());
			System.out.println("Hash for number " + (i + 1) + " Block is: " + BlockChainArray[i].getHash());
		}

		System.out.println();
		String userInput;
		// giving user privilege to add data in the recently created blockChain
		for (int i = 1; i < BlockChainArray.length; i++) {
			System.out.println("Enter the data for Block " + (i + 1));
			userInput = input.nextLine();
			BlockChainArray[i].setData(userInput);
			BlockChainArray[i].setHash(BlockChainArray[i - 1].getHash());
			BlockChainArray[i].setPreviousHash(BlockChainArray[i - 1].getHash());

		}

		System.out.println();
		System.out.println("Following is the data enterd by User with their respective hash codes:");

		// Displaying the data entered by user in the blocks of blockChain
		for (int i = 0; i < BlockChainArray.length; i++) {
			System.out.println("Data for number " + (i + 1) + " Block is: " + BlockChainArray[i].getData());
			System.out.println("Hash for number " + (i + 1) + " Block is: " + BlockChainArray[i].getHash());
			System.out.println(
					"Previous Hash for number " + (i + 1) + " Block is: " + BlockChainArray[i].getPreviousHash());
		}

		// calling function for validation of blockChain
		System.out.println(B1.transactionValidator(BlockChainArray));

		System.out.println();
		System.out.println();

		// Phase5-6-7-8
		// Starting the nonsense coins
		// creating a nonsense coin blockChain
		ArrayList<BlockChain> NonsenseCoins = new ArrayList<BlockChain>();

		// adding the genises block to the arrayList
		NonsenseCoins.add(B1);

		String UserInput2 = "Y";
		String UserInputData = "";
		// Maintaining the database of coins won by user
		int count = 0;
		while (UserInput2.equalsIgnoreCase("Y")) {

			// generating the coin from a program in blockChain class
			Boolean result = B1.AddCoins(NonsenseCoins.get(count).getHash());
			if (result) {

				// giving the prize to the user
				System.out.println("congratulations, you got a nonsense coin!");

				System.out.print("Enter the data for new coin: ");

				// getting data from the user and generating hash from that
				UserInputData = input.nextLine();

				// validating the newly added coin
				System.out.println(B1.transactionValidator(NonsenseCoins));

				//
				NonsenseCoins.add(new BlockChain(UserInputData));

				// setting the hash and previousHash for the newly created coin
				NonsenseCoins.get(count + 1).setHash(NonsenseCoins.get(count).getHash());
				NonsenseCoins.get(count + 1).setPreviousHash(NonsenseCoins.get(count).getHash());

			}
			System.out.println();
			System.out.println("To continue adding coins, Enter Y and to stop Enter Anything");
			UserInput2 = input.nextLine();
			count++;
		}

		// printing the hashes of the coins won by the user
		System.out.println("Enter Y to see the hash code of coins you won: ");
		String userInputPrintData = input.nextLine();
		if (userInputPrintData.equalsIgnoreCase("y")) {
			System.out.println();
			System.out.println("You won " + count + " coins");
			System.out.println();
			System.out.println("Hash Code for the Coins you won is:");
			for (int i = 1; i < NonsenseCoins.size(); i++) {
				System.out.println("Coin " + (i) + ":" + NonsenseCoins.get(i).getHash());
			}
		}

		input.close();
	}

}
