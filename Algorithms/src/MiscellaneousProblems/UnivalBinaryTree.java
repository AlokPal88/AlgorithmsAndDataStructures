
public class UnivalBinaryTree {

	static class Node
	{
		int data;
		Node left;
		Node right;
		Node(){}
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}
	static class Count
	{
		int count = 0;
	}
	public static void main(String[] args) {
		
		
		Node root = new Node(5);
		root.left = new Node(4);
		root.right = new Node(5);
		root.left.left = new Node(4);
		root.left.right = new Node(4);
		root.right.right = new Node(5);
		Count count = new Count();
		countUnivalSubTree(root,count);
		System.out.println(count.count);
	}

	private static boolean countUnivalSubTree(Node root,Count count) {
		if(root == null)
			return true;
		
		boolean lTree = countUnivalSubTree(root.left, count);
		boolean rTree = countUnivalSubTree(root.right, count);
		
		if(!lTree && !rTree)
			return false;
		if(root.left != null && root.data != root.left.data)
			return false;
		if(root.right != null && root.data != root.right.data)
			return false;
		
		count.count++;
		
		return true;
	}

}
