package corejavademo.ds;

public class BinaryTreeDemo {

	private Node root;

	class Node {
		private int data;
		private Node left, right;

		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public void addElement(int d) {
		this.root = addElement(root, d);
	}

	private Node addElement(Node root, int d) {
		if (root == null) {
			root = new Node(d);
			return root;
		}

		if (d < root.data) {
			root.left = addElement(root.left, d);
		}

		if (d > root.data) {
			root.right = addElement(root.right, d);
		}

		return root;

	}

	public void preOrderTraversal() {
		preOrderTraversal(root);

	}

	public void preOrderTraversal(Node node) {
		if (node != null) {
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
			System.out.println(node.data);
		}
	}

	public void preOrderLeftTraversal(Node node) {
		if (node != null) {
			if (node.left == null) {
				System.out.println("Min Value : " + node.data);
				return;
			}
			preOrderLeftTraversal(node.left);
		}
	}

	public void preOrderRightTraversal(Node node) {
		if (node != null) {
			if (node.right == null) {
				System.out.println("Max Value : " + node.data);
				return;
			}
			preOrderRightTraversal(node.right);
		}
	}

	public void findMax() {
		preOrderRightTraversal(root);
	}

	public void searchMinValue(int ele) {
		// preOrderLeftTraversal(root);
		preOrderRightTraversal(root);
	}

	public static void main(String[] args) {

		try {
			BinaryTreeDemo obj = new BinaryTreeDemo();
			obj.addElement(10);
			obj.addElement(5);
			obj.addElement(11);
			obj.addElement(7);
			obj.addElement(40);
			obj.addElement(50);

			// obj.preOrderTraversal();
			obj.searchMinValue(1);
			obj.findMax();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
