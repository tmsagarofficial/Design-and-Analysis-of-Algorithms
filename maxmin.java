
package Algorithm;
import java.util.Scanner;
public class maxmin

{

    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    static int a[];

    static int size;


    static void MaxMin(int i, int j)

    {

        int max1, min1, mid;

        if (i == j)
            max = min = a[i];
        else if (i == j - 1){
            if (a[i] < a[j]) {
                max = a[j];
                min = a[i];
            } else{
                max = a[i];
                min = a[j];
            }
        } else {
            mid = (i + j) / 2;
            MaxMin(i, mid);
            max1 = max;
            min1 = min;
            MaxMin(mid + 1, j);
            if (max < max1)
                max = max1; //updating here
            if (min > min1)
                min = min1;
        }
    }
    public static void main(String[] args)

    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        size = sc.nextInt();
        a = new int[size];
        System.out.println("Enter the array elements");
        for (int i = 0; i < size; i++)
            a[i] = sc.nextInt();
        long start = System.nanoTime();
        MaxMin(0, size - 1);
        long end = System.nanoTime();
        System.out.println("Max value: " + max + "\nMin value: " + min);
        System.out.println("Time taken is: " + (end - start) + "ns");
    }
}