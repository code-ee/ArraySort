/*

ArraySort.java
Author: Cody Patterson

Given N sorted arrays of integers, returns one array with all the elements,
sorted. For this, we use a minimum heap with number of nodes equal to the
number of arrays we were given. Each node holds the value, an index that
represents which array it came from, and the index of the location of that
array, respectively.

If K = the sum of each array size (Ksub0 + Ksub1 + Ksub2 + ... + KsubN)
Then the time complexity of this algorithm is N * K * log(K).

Steps:
1. Create a result array of size: N * K
2. Create a heap with N nodes, each node holding the first value of each array
3. From the min heap, place the value of the root into the result array
4. Replace the root in the min heap with the next element in the array from
   which the element was extracted in step 3. If the array has no more elements
   to grab from, then replace the root with int max.
5. Maintain the heap property by heapifying the heap from the root node.
6. Repeat steps 3-5 for each index in the result array.

*/

public class ArraySort {

	// driver method
	public static void main(String[] args) {

		// hard coded arrays to sort
		int[] x = { 1, 2, 4, 6, 20, 30, 50, 70 };
		int[] y = { 3, 4, 6, 8, 9, 10, 11, 12, 15, 19, 20, 25 };
		int[] z = { 6, 7, 8, 9, 10, 50, 51, 56, 57, 59 };

		int[][] arrays = { x, y, z };

		ArraySort a = new ArraySort();
		int[] result = a.mergeArrays(arrays);

		System.out.println("Given Arrays: ");
		for (int i = 0; i < arrays.length; i++) {
			a.printArray(arrays[i]);
		}

		System.out.println("Resulting Array: ");
		a.printArray(result);
	}

	public int[] mergeArrays(int[][] arrays) {
		// get the number of arrays
		int numArrays = arrays.length;

		// determine size of result array
		int resultSize = 0;
		for (int i = 0; i < numArrays; i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				resultSize++;
			}
		}
		int[] result = new int[resultSize];

		// create an array of nodes; one node per array
		Node[] nodes = new Node[numArrays];

		// each node holds the first element of each array,
		// the index of the array it came from, 
		// and the index of the next element to be checked from that array
		for (int i = 0; i < numArrays; i++) {
			nodes[i] = new Node(arrays[i][0], i, 1);
		}

		// create the heap with the given nodes
		MinHeap heap = new MinHeap(nodes);

		for (int pos = 0; pos < resultSize; pos++) {
			//place the value of the root into the result array
			Node root = heap.getMin();
			result[pos] = root.getValue();

			// check to see if the array still has elements to grab from.
			if (root.getNextValIndex() < arrays[root.getArrayIndex()].length) {
				// replace the root value with the next element in the array
				root.setValue(
					arrays[root.getArrayIndex()][root.getNextValIndex()]
				);
				// increment the counter for that array
				root.incrementNextValIndex(); 
			} else {
				// if there were no more elements, replace with max int
				root.setValue(Integer.MAX_VALUE);
			}

			// heapify from root to maintain heap property
			heap.replaceMin(root);
		}

		return result;
	}

	public void printArray(int[] a) {
		int s = a.length;
		System.out.print("[");
		for (int i = 0; i < s; i++) {
			System.out.print(a[i]);
			if (i != s - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}