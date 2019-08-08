import java.util.Date;

public class BlockChain {
	// declaring the properties of the class
	private int hash;
	private int previousHash;
	private String data;
	private long timeStamp;

	// creating the constructor to initialize the genesis block
	public BlockChain(String data) {
		// setting the data
		this.data = data;

		// getting the timeStamp from current time of system
		this.timeStamp = new Date().getTime();

		// creating the hash code from both data and timeStamp generated by the system
		this.hash = (this.data + timeStamp).hashCode();
	}

	// getters and setters
	public int getHash() {
		this.hash = (this.data + timeStamp).hashCode();
		return hash;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}

	public int getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(int previousHash) {
		this.previousHash = previousHash;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
