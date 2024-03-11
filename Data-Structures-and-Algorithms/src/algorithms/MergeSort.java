package algorithms;

public class MergeSort extends CreateArray {
  // merge sort = recursively divide array in 2, sort, re-combine
  // run-time complexity = O(n Log n)
  // space complexity = O(n)
  public static void main(String[] args) {
    int[] array = createUnsortedArray(5);
    printArray(array);
    mergeSort(array);
    printArray(array);

  }

  private static void mergeSort(int[] array) {

    int length = array.length;

    if (length <= 1)
      return; // base case

    int middle = length / 2;
    int[] leftArray = new int[middle];
    int[] rightArray = new int[length - middle];

    int i = 0; // left array
    int j = 0; // right array

    for (; i < length; i++) {
      if (i < middle) {
        leftArray[i] = array[i];
      } else {
        rightArray[j] = array[i];
        j++;
      }
    }
    mergeSort(leftArray);
    mergeSort(rightArray);
    merge(leftArray, rightArray, array);
  }

  private static void merge(int[] leftArray, int[] rightArray, int[] array) {
    int leftSize = array.length / 2;
    int rightSize = array.length - leftSize;

    int i = 0,
        l = 0,
        r = 0;

    while (l < leftSize && r < rightSize) {
      if (leftArray[l] < rightArray[r]) {
        array[i] = leftArray[l];
        l++;
      } else {
        array[i] = rightArray[r];
        r++;
      }
      i++;
    }

    while (l < leftSize) {
      array[i] = leftArray[l];
      i++;
      l++;
    }

    while (r < rightSize) {
      array[i] = rightArray[r];
      i++;
      r++;
    }
  }
}