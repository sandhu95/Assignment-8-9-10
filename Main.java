import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		
		//creating object of scanner class to take user input
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
		
		//creating an array to store blockChain
		BlockChain[] BlockChainArray= new BlockChain[5];
		
		BlockChainArray[0]= B1;
		
		System.out.println();
		
		//creating the series blocks of blockChain and assume the number of blocks to be 5
		for(int i=1; i<BlockChainArray.length; i++)
		{
			BlockChainArray[i]= new BlockChain("",BlockChainArray[i-1].getHash());
		}
		
		System.out.println("Following are the Blocks created in the BlockChain: ");
		
		//printing the data and hash codes of whole BlockChain
		for(int i=0; i<BlockChainArray.length; i++)
		{
			System.out.println("Data for number "+(i+1)+" Block is: "+BlockChainArray[i].getData());
			System.out.println("Hash for number "+(i+1)+" Block is: "+BlockChainArray[i].getHash());
		}
		
		System.out.println();
		String userInput;
		//giving user privilege to add data in the recently created blockChain
		for(int i=1; i<BlockChainArray.length; i++)
		{
			System.out.println("Enter the data for Block "+(i+1));
			userInput= input.nextLine();
			BlockChainArray[i].setData(userInput);
			BlockChainArray[i].setHash(BlockChainArray[i-1].getHash());
		}
		
		System.out.println();
		System.out.println("Following is the data enterd by User with their respective hash codes:");
		
		//Displaying the data entered by user in the blocks of blockChain
		for(int i=0; i<BlockChainArray.length; i++)
		{
			System.out.println("Data for number "+(i+1)+" Block is: "+BlockChainArray[i].getData());
			System.out.println("Hash for number "+(i+1)+" Block is: "+BlockChainArray[i].getHash());
		}
		
		input.close();
	}

}
