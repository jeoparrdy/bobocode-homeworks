public class SortExamples {

    public static void main(String[] args) {
        int [] array ={12,17,5,6,3,3,19,58,42,78,34,23,66};
        divideInpArray(array);
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int element: array) {
            System.out.print(element + " ");
        }
    }

    public static void divideInpArray(int[] array){
        int length = array.length;
        if (length<2) {
            return;
        }
        int[] leftSubArray = new int[length/2];
        int[] rightSubArray = new int[length - length/2];

        System.arraycopy(array,0,leftSubArray,0,leftSubArray.length);
        System.arraycopy(array, leftSubArray.length, rightSubArray,0,rightSubArray.length);

        divideInpArray(leftSubArray);
        divideInpArray(rightSubArray);

        mergeSortedSubArr(leftSubArray,rightSubArray,array);

    }

    public static void mergeSortedSubArr(int[] leftSubArray, int[] rightSubArray, int[] result ){
        int cursorL = 0, cursorR = 0, cursorRes =0;

        //it works while sub arrays not empty
        while (cursorL < leftSubArray.length && cursorR < rightSubArray.length){
            if (leftSubArray[cursorL] <= rightSubArray[cursorR]){
                result[cursorRes++] = leftSubArray[cursorL++];
            } else {
                result[cursorRes++] = rightSubArray[cursorR++];
            }
        }

        //it works if right sub array is empty, but left isn't yet
        while (cursorL < leftSubArray.length){
            result[cursorRes++] = leftSubArray[cursorL++];
        }

        //otherwise
        while (cursorR < rightSubArray.length){
            result[cursorRes++] = rightSubArray[cursorR++];
        }



    }
}
