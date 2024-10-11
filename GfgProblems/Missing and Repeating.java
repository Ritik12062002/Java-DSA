

class Solve {
    public int[] findTwoElement(int arr[]) {
        int n = arr.length;
        int repeating = -1, missing = -1;

        // Step 1: Correct positioning of elements using cycle sort
        for (int i = 0; i < n; i++) {
            while (arr[i] != arr[arr[i] - 1]) {
                // Swap arr[i] with arr[arr[i] - 1] to place elements in the right position
                int temp = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[temp - 1] = temp;
            }
        }

        // Step 2: Identify repeating and missing
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                repeating = arr[i];  
                missing = i + 1;      
                break;
            }
        }

        return new int[]{repeating, missing};  
    }

}