import java.util.Stack;

public class BT {
	private String str; // ( parent , left child , right child )
	private Node root;
	private class Node {
		char data; // should contain any kinds of data type later
		Node left;
		Node right;
		
		Node(char data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public BT(String str) {
		this.str = str;
		this.root = null;
	}
	
	public Node newNode(char data) {
		return new Node(data);
	}
	public String toString() {
		StringBuffer sb = new StringBuffer("(");
		
		// Traverse tree
		
		sb.append(")");
		return sb.toString();
	}
	
	private static BT parseBT(String str) {
		StringBuffer inputStr = new StringBuffer(str.replaceAll("\\p{Z}", ""));
		final int PARENT = 0;
		final int LEFT = 1;
		final int RIGHT = 2;
		
		int state = PARENT;
		
		int pos = 0;
		if(inputStr.charAt(0) != '(') {
			// surround inputStr w/ brackets
			inputStr.insert(0, "(");
			inputStr.append(")");
		}
		
		Stack<Character> brackets = new Stack<Character>();
		Stack<Node> parentTracker = new Stack<Node>();
		
		BT resultBT = new BT(str);
		
		for(int i = 0; i < inputStr.length(); i++) {
			char inputChar = inputStr.charAt(i);
			
			if(inputChar == '(') {
				brackets.push('(');
			}
			else if(inputChar == ')') {
				brackets.pop();
			}
			else if(inputChar == ',') {
				state = (state + 1) % 3;
			}
			else { // actual data
				switch(state) {
					case PARENT:
						parentTracker.push(resultBT.newNode(inputChar));
						break;
					case LEFT:
						// attach a new node to the left side of the current parent node.
						break;
					case RIGHT:
						// attach a new node to the right side of the current parent node.
						break;
				}
			}
		}
		
		// set the last Node in parentTracker as the root node.
		
		return resultBT;
	}
	
}
