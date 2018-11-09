package com.solution.tree;

public class BSTDemo {

	private Node root;

	class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public void add(int data) {
		root = add(root, data);
	}

	private Node add(Node node, int data) {
		if (node == null) {
			return new Node(data);
		}

		if (data < node.data) {
			node.left = add(node.left, data);
		} else {
			node.right = add(node.right, data);
		}

		return node;
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}
	}

	public void delete(int ele) {
		root = delete(root, ele);
	}

	private Node delete(Node node, int ele) {
		if (node == null) {
			return null;
		}

		if (node.data == ele) {
			System.out.println("ele cound!");
			
			if(node.left == null && node.right == null){
				node = null;
			} else if(node.left == null){
				Node temp = node;
				node = temp.right;
			} else if(node.right == null){
				Node temp = node;
				node = temp.left;
			} else {
				Node minNode = findMaxNode(node, ele);
				System.out.println("minNode : " + minNode.data);
			}
		} else if (ele < node.data){
			node.left = delete(node.left, ele);
		} else {
			node.right = delete(node.right, ele);
		}
		
		return node;
	}
	
	public Node findMinNode(Node node, int ele){
		if(node != null){
			if(node.data < ele){
				return node;
			}
			
			if(ele < node.data){
				node.left = findMinNode(node.left, ele);
			} else {
				node.right = findMinNode(node.right, ele);
			}	
		}
		return node;
	}

	public Node findMaxNode(Node node, int ele){
		if(node != null){
			if(node.data > ele){
				return node;
			}
			
			if(ele < node.data){
				node.left = findMinNode(node.left, ele);
			} else {
				node.right = findMinNode(node.right, ele);
			}	
		}
		return node;
	}
	
	public static void main(String args[]) {
		BSTDemo tree = new BSTDemo();
		tree.add(4);
		tree.add(3);
		tree.add(6);
		tree.add(2);
		tree.add(5);
		tree.add(7);

		tree.inOrder();
		tree.delete(6);
		System.out.println("---------------------------------");
		tree.inOrder();
	}
}
