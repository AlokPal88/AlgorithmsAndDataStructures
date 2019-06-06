package MiscellaneousProblems;

class Solution {
	  static class Node {
	    Node left = null;
	    Node right = null;
	    int data;

	    public Node(int data, Node left, Node right) { 
	      this.data = data; 
	      this.left = left;
	      this.right = right;
	    }
	  }
	  
	  public static void main(String[] args) {
	      
	    Node n8 = new Node(8, null, null);
	    Node n9 = new Node(9, null, null);
	    Node n10 = new Node(10, null, null);
	    Node n11 = new Node(11, null, null);
	    
	    Node n4 = new Node(4, null, null);
	    Node n5 = new Node(5, null, null);
	    Node n6 = new Node(6, null, null);
	    Node n7 = new Node(7, n8, n9);
	      
	    Node n3 = new Node(3, n6, n7);
	    Node n2 = new Node(2, n4, n5);
	      
	    Node n1 = new Node(1, n2, n3);
	      
	    System.out.println(isSymmetric(n1));
	  
	    }
	  
	  private static boolean isSymmetric(Node root) {
	    // TODO
	    Node ptr = root;
	    int countL = 0;
	    int countR = 0;
	    int leftTreeSize = inOrderTraversal(root.left);
	    int rightTreeSize = inOrderTraversal(root.right);
	    System.out.println(leftTreeSize + ":" + rightTreeSize);
	    return leftTreeSize==rightTreeSize;
	}
	  private static int inOrderTraversal(Node node){
		 if(node == null)
	      return 0;
	    int lSize = inOrderTraversal(node.left);
	    int rSize = inOrderTraversal(node.right);
	    return lSize+rSize+1;
	    
	    /*System.out.println(count);
	    return count;*/
	  }
	}
