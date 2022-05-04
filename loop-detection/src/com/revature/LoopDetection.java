package com.revature;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LoopDetection {

	public static void main(String[] args) {
		// create list of nodes with loop
		LinkedList<Node> list = new LinkedList<Node>();

		list.add(new Node(2));
		list.add(new Node(4));
		list.add(new Node(6));
		list.add(new Node(8));
		list.add(new Node(10));
		list.add(list.get(2));	// index 2 is the loop with value 6
		
		// print value at index where loop starts
		System.out.println(detectLoop(list));
	}
	
	public static int detectLoop(LinkedList<Node> list) {
		int result = -1;

		// create map to store previous Node-value pairs
		LinkedHashMap<Node, Integer> nodeMap = new LinkedHashMap<Node, Integer>();
		
		// create iterator to iterate over list
		Iterator<Node> iter = list.iterator(); 
		
		while(iter.hasNext()) {
			Node temp = iter.next();
			if (!nodeMap.containsKey(temp)) {
				// if the map doesn't have the Node-value pair, add it
				nodeMap.put(temp, temp.getData());
			} else {
				// if the map has the Node-value pair, that is the start of the loop
				result = nodeMap.get(temp);
				// return the value at the index where the loop starts
				return result;
			}
		}
		// print -1 if something goes wrong
		return result;
	}
}

//create Node class to populate list of nodes
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
