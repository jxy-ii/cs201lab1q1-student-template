
import java.util.*;

public class NumbersArray {

    public static void main(String[] args) {
        Integer[] input = {1, 2, 3, 4, 1, 5};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));

        System.out.println();

        input = new Integer[]{1, 2, 3, 4, 1, 2, 5, 3};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));
    }

    // Write your methods here
    public static int findMax(Integer[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;

    }

    public static int[] findDuplicates(Integer[] arr) {
        //M1 --> create a count arr
        //M2 --> nested for loop to check each rnd if there is a duplicate
        //M3 --> track with hash set

        HashSet<Integer> value = new HashSet<>();
        int[] res = new int[arr.length];
        int id = 0;

        for (int no : arr) {
            if (value.contains(no)) {
                res[id] = no;
                id++;
            }

            value.add(no);
        }

        int[] ans = new int[id];
        for (int i = 0; i < id; i++) {
            ans[i] = res[i];
        }

        return ans;
    }

    public static int[] findUnique(Integer[] arr) {
        int[] res = new int[arr.length];
        int id = 0;
        boolean repeat = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i].equals(arr[j])) {
                    repeat = true;
                    break;
                }
            }

            if (repeat == false) {
                res[id] = arr[i];
                id++;
            }
            repeat = false;
        }

        int[] ans = new int[id];
        for (int i = 0; i < id; i++) {
            ans[i] = res[i];
        }

        return ans;

    }

}
