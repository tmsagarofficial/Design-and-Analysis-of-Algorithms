package Algorithms;
import java.util.*;
public class heapsort 
{
    public static void heapify(int a[], int n, int i) // Places the highest element at the top followed by descending order of elements
    {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && a[left] > a[largest]) // Change the second sign
            largest = left;
        if (right < n && a[right] > a[largest]) // Change the second sign
            largest = right;
        if (largest != i) 
        {
            int swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;
            heapify(a, n, largest);
        }
    }
    public static void heapSort(int a[]) 
    {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(a, n, i);
        for (int i = n - 1; i > 0; i--) // To reverse the order of the elements i.e. to place lowest element at the top followed by ascending order
        {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a, i, 0);
        }
    }
    public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        heapSort(a);
        System.out.println("Sorted array in ascending order (min heap):"); // Change the output statement
        for (int i = 0; i < n; i++) {
        	System.out.print(a[i]+" ");
        }
        }
}
    