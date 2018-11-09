package corejavademo;

public class MyLinkedList {

	private Node root;
	private Node tail;

	public MyLinkedList() {
	}

	class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public synchronized void put(int data) {
		if (this.root == null) {
			this.root = new Node(data);
			this.tail = this.root;
			return;
		}

		Node node = new Node(data);
		tail.next = node;
		tail = node;

	}

	public int size() {
		int count = 0;
		Node temp = root;
		while (temp != null) {
			temp = temp.next;
			count++;
		}

		return count;
	}

	public boolean search(int ele) {
		Node temp = root;
		while (temp != null) {
			if (temp.data == ele) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public boolean searchRecursivly(int ele) {
		return searchRecursivly(root, ele, false);
	}

	private boolean searchRecursivly(Node node, int ele, boolean result) {
		if (node == null) {
			return false;
		}

		if (node.data == ele) {
			return true;
		}

		return searchRecursivly(node.next, ele, result);
	}

	public int sizeByRecursion() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		return size(node.next) + 1;
	}

	public int findNthNode(int pos) {
		int idx = 0;
		Node temp = root;
		while (temp != null && idx < pos) {
			temp = temp.next;
			if(idx == pos){
				return temp.data;	
			}
						
			idx++;
		}

		return temp.data;
	}

	// private int findNthNodeFromLast(){
	//
	//
	// }

	public void reverse() {
		Node pre, cur, next;
		cur =  root;
		pre = next = null;

		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		
		root = pre;

	}

	public void traverse() {
		Node temp = root;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public void findMidNodeOfLinkedList() {

	}

	public static void main(String args[]) {
		MyLinkedList list = new MyLinkedList();
		list.put(3);
		list.put(11);
		list.put(4);
		list.put(23);
		list.put(35);
		list.put(34);
		list.put(25);
		list.put(39);
		list.put(45);
		list.put(38);
		list.put(33);
		list.traverse();
		System.out.println("Size : " + list.size());
		System.out.println("Size : " + list.sizeByRecursion());
		System.out.println("Search : " + list.search(11));
		System.out.println("Search : " + list.search(111));
		System.out.println("Search2 : " + list.searchRecursivly(11));
		System.out.println("Search3 : " + list.findNthNode(5));
		list.reverse();
		System.out.println("Search3@ : " + list.findNthNode(2));
		list.traverse();

	}
}
