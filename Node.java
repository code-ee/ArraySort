/*
Node.java
Author: Cody Patterson
*/

public class Node {
	private int value;
	private int arrayIndex;
	private int nextValIndex;

	public Node() {
		value = -1;
		arrayIndex = -1;
		nextValIndex = -1;
	}

	public Node(int v, int i, int j) {
		value = v;
		arrayIndex = i;
		nextValIndex = j;
	}

	public int getValue() {
		return value;
	}

	public int getArrayIndex() {
		return arrayIndex;
	}

	public int getNextValIndex() {
		return nextValIndex;
	}

	public void setValue(int x) {
		value = x;
	}

	public void setArrayIndex(int x) {
		arrayIndex = x;
	}

	public void setNextValIndex(int x) {
		nextValIndex = x;
	}

	public void incrementNextValIndex() {
		nextValIndex++;
	}
}