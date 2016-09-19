
public class BT {
	private String str; //( parent , left child , right child )
	private Node root;
	
	private class Node {
		int data; // should contain any kinds of data type later
		Node left;
		Node right;
	}
	public BT(String str) {
		this.str = str.replaceAll("\\p{Z}", "");;
		
	}
	
	
	
	private static BT parseBT(String str) {
		BT resultBT = new BT(str);
		return resultBT;
	}
}
