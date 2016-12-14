#Class ArraySort#
_______________________________________________________________________________
Author: Cody Patterson

###Problem:###
Given N sorted arrays of integers, returns one array with all the elements,
sorted. For this, we use a minimum heap with number of nodes equal to the
number of arrays we were given. Each node holds the value, an index that
represents which array it came from, and the index of the location of that
array, respectively.

###Running Time:###
If K = the sum of each array size (Ksub0 + Ksub1 + Ksub2 + ... + KsubN)
Then the time complexity of this algorithm is N * K * log(K).

###Steps:###
1. Create a result array of size: N * K
2. Create a heap with N nodes, each node holding the first value of each array
3. From the min heap, place the value of the root into the result array
4. Replace the root in the min heap with the next element in the array from
   which the element was extracted in step 3. If the array has no more elements
   to grab from, then replace the root with int max.
5. Maintain the heap property by heapifying the heap from the root node.
6. Repeat steps 3-5 for each index in the result array.