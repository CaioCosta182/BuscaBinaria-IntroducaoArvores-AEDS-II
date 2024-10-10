package ex01prova;

/**
 *
 * @author caiocosta
 */
public class Ex01Prova {

    public static int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            
            if (arr[left] <= arr[mid]) {
            
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            
            else {
            
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        
        return -1;
    }

    
    public static void main(String[] args) {
        int[] arr = {12, 14, 18, 21, 3, 6, 8, 9}; 
        int target = 6;

        int result = search(arr, target);
        if (result != -1) {
            System.out.println("Elemento encontrado no índice: " + result);
        } else {
            System.out.println("Elemento não encontrado.");
        }
    }
}
