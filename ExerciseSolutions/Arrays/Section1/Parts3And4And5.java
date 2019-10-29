import java.util.Arrays;

public class Parts3And4And5 {
    public static void main(String[] args) {
        int[] testArray = {1,3,6,5,3,2};
        System.out.println(firstOccurance(testArray,6)); // should return 2
        System.out.println(firstOccurance(testArray,7)); // should return -1 because 7 isn't in array

        System.out.println(lastOccurance(testArray,3)); // should return 4
        System.out.println(lastOccurance(testArray,7)); // should return -1 because 7 isn't in array

        int[] three = allOccurances(testArray, 3);
        System.out.println(Arrays.toString(three));
        int[] five = allOccurances(testArray, 5);
        System.out.println(Arrays.toString(five));
        int[] seven = allOccurances(testArray, 7);
        System.out.println(Arrays.toString(seven));
        
    }
    
    public static int firstOccurance(int[] array,int value) {
        int pos = -1; // will store position of first occurance
        for(int i=0;i<array.length;i++) {
            if(array[i] == value) {
                pos = i;
                break;
            }
        }
        return pos;
    }
    /*
        In the solution below I've looked over the whole
        array from the start and kept re-assigning pos
        every time value is found. Hence when the loop ends, it
        will have the last correct position.

        You could also do this by implementing something like
        the previous one, but looping through the array in the
        opposite direction
    */
    public static int lastOccurance(int[] array,int value) {
        int pos = -1;
        for(int i=0;i<array.length;i++) {
            if(array[i] == value) {
                pos = i;
            }
        }
        return pos;
    }

    /*
        This is a bit trickier. We need to find all of them
        and put them into an array. But we don't know how many
        there will be. So, we'll make an array that is the maximum
        possible size (all things in array equal value) and then
        once we've found them all, we copy it into a smaller
        one that is the right size.
    */
    public static int[] allOccurances(int[] array,int value) {
        int[] temp = new int[array.length];
        int nFound = 0; // how many times we've found 'value' so far
        for(int i=0;i<array.length;i++) {
            if(array[i] == value) {
                temp[nFound] = i; // Store this position
                nFound ++; // increase the number found
            }
        }
        // If we found any, copy them into a new array of
        // the correct length
        if(nFound > 0) {
            int[] output = new int[nFound];
            for(int i=0;i<nFound;i++) {
                output[i] = temp[i];
            }
            return output;
        }else {
            // Didn't find anything
            return null; // return a nothing object!
        }
    }
}