
public class Main {

	public static void main(String[] args) {
		// creating the first block of blockChain
		BlockChain B1 = new BlockChain("First Block");

		// printing the info of first Block
		System.out.println("The Data for first Block is: " + B1.getData());
		System.out.println("The hash Code for first Block is: " + B1.getHash());

		// After changing the data of first block the hash changes
		B1.setData("Data Changed");
		System.out.println("New Data for first Block is: " + B1.getData());
		System.out.println("New hash Code for first Block is: " + B1.getHash());
	}

}
