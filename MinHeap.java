/*
MinHeap.java
Author: Cody Patterson
*/

public class MinHeap {
	private Node[] nodes;
	private int size;

	public MinHeap(Node[] nodes) {
		this.nodes = nodes;
		size = nodes.length;
		for (int i = (size - 1) / 2; i >= 0; i--) {
			heapify(i);
		}
	}

	public void heapify(int i) {
		int l = left(i);
		int r = right(i);
		int minIndex = i;
		if (l < size && nodes[l].getValue() < nodes[i].getValue()) {
			minIndex = l;
		}
		if (r < size && nodes[r].getValue() < nodes[minIndex].getValue()) {
			minIndex = r;
		}
		if (minIndex != i) {
			swap(i, minIndex);
			heapify(minIndex);
		}
	}

	public int left(int i) {
		return (2 * i) + 1;
	}

	public int right(int i) {
		return (2 * i) + 2;
	}

	public Node getMin() {
		return nodes[0];
	}

	public void replaceMin(Node node) {
		nodes[0] = node;
		heapify(0);
	}

	public void swap(int x, int y) {
		Node temp = nodes[x];
		nodes[x] = nodes[y];
		nodes[y] = temp;
	}
}