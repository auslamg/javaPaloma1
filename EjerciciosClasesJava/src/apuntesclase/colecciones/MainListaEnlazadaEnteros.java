package apuntesclase.colecciones;

import java.util.NoSuchElementException;

public class MainListaEnlazadaEnteros {

    public static void main(String[] args) {
        LinkList li = new LinkList();
        li.addLast(1);
        li.addLast(2);

		for (int i = 0; i < li.size; i++) {
			System.out.println(li.getNodeByIndex(i).data);
		}
    }
}

class Node {

    int data;
	Node previous;
    Node next;

    Node(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    public void getNext(Node n) {
    }

    public void setNext(Node n) {
    }

	public boolean equals(Node n) {
		return this.data == n.data;
	}
}

class LinkList {

	int size = 0;
    Node first = null;
	Node last = null;

    public Node getFirst() {
        return first;
    }

	public Node getLast() {
		return last;
	}

	public Node getNodeByMatch(Node n) {
		Node currentNode = first;
		boolean foundNode = false;

		while (!foundNode) {
			//No nodes left
			if (currentNode == null) {
				return null;			
			}
			//Match
			if (currentNode.equals(n) ) {
				return currentNode;
			}
			//Check next
			currentNode = currentNode.next;
		}
		
		return null;
	}

	public Node getNodeByIndex(int index) {
		Node currentNode = first;
		boolean foundNode = false;

		for (int i = 0; i < index; i++) {
			try {
				currentNode = currentNode.next;
			} catch (NullPointerException e) {

			}
		}

		int i = 0;
		while (!foundNode) {
			//No nodes left
			if (currentNode == null) {
				return null;			
			}
			//Match
			if (i == index) {
				return currentNode;
			}
			//Check next
			currentNode = currentNode.next;
			i++;
		}
		
		return null;
	}

	public int indexOf(Node n) throws NoSuchElementException {
		Node currentNode = first;
		boolean foundNode = false;

		int i = 0;
		while (!foundNode) {
			//No nodes left
			if (currentNode == null) {
				throw new NoSuchElementException("Element is not inside the linked list");
			}
			//Match
			if (currentNode.equals(n)) {
				return i;
			}
			//Check next
			currentNode = currentNode.next;
			i++;
		}
		throw new NoSuchElementException();
	}

	public void addFirst(int value) {
		addFirst(new Node(value));
    }

	public void addFirst(Node newNode) {

		//Si no hay primero
		if (first == null) {
			first = newNode;
			last = newNode;
		}
		else {
			first.previous = newNode;
			newNode.next = first;

			first = newNode;
		}
		size++;
    }

	public void addLast(int value) {
		addLast(new Node(value));
	}

    public void addLast(Node newNode) {

		//Si no hay primero
		if (first == null) {
			first = newNode;
			last = newNode;
		}
		else {
			last.next = newNode;
			newNode.previous = last;

			last = newNode;
		}
		size++;
    }

    public void removeNode(Node n) {
		Node replacer = n.next;

		if (n.previous != null) {
			n.previous.next = replacer;
		}
		if (replacer != null) {
			replacer.previous = n.previous;			
		}
		if (n == first) {
			first = replacer;
		}

		size--;
    }

	
}

