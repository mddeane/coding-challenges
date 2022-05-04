package com.revature;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LinkedListIntersect {

	public static void main(String[] args) {
		
		// create first list of nodes
		LinkedList<Node> list1 = new LinkedList<Node>();

		list1.add(new Node(2));
		list1.add(new Node(4));
		list1.add(new Node(6));
		list1.add(new Node(8));
		list1.add(new Node(10));
		list1.add(new Node(12));
		list1.add(new Node(14));
		list1.add(new Node(16));

		// create second list of nodes with intersection
		LinkedList<Node> list2 = new LinkedList<Node>();

		list2.add(new Node(5));
		list2.add(list1.get(4)); // intersection with value 10
		list2.add(new Node(15));
		list2.add(new Node(20));
		list2.add(new Node(25));
		list2.add(new Node(30));

		// print value of Node at intersection
		System.out.println(getIntersection(list1, list2));
		
	}
	
	public static int getIntersection(LinkedList<Node> list1, LinkedList<Node> list2) {

		int result = -1;
		
		// get list sizes to see which one will be the map and which one will check values
		int list1Size = list1.size();
		int list2Size = list2.size();

		Iterator<Node> iter1 = list1.iterator();
		Iterator<Node> iter2 = list2.iterator();

		LinkedHashMap<Node, Integer> nodeMap = new LinkedHashMap<Node, Integer>();

		// counter will represent the index of the intersection in the map
		int counter = 0; 

		// build map with Node reference and index key-value pairs
		// larger list is the map
		// smaller list checks for .contains() intersection of Node reference
		if (list1Size > list2Size) {
			while (iter1.hasNext()) {
				nodeMap.put(iter1.next(), counter);
				counter++;
			}
			while (iter2.hasNext()) {
				Node temp = iter2.next();
				if (list1.contains(temp)) {
					// return value at intersection
					return temp.getData();
				}
			}
		} else {
			while (iter2.hasNext()) {
				nodeMap.put(iter2.next(), counter);
				counter++;
			}
			while (iter1.hasNext()) {
				Node temp = iter1.next();
				if (list2.contains(temp)) {
					return temp.getData();
				}
			}
		}
		// return -1 if something went wrong
		return result;
	}
}

// create Node class to populate list of nodes
class Node {
	private int data;
	private Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	public int getData() {
		return this.data;
	}

	public Node getNext() {
		return this.next;
	}

}