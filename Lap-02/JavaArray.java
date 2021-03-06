import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class JavaArray {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter the number of array : ");
		int n = keyboard.nextInt();
		int sum=0;
		int arr[] = new int[n];
		
		System.out.println("Please enter the elements of that arr: ");
		for(int i = 0; i<n ; i++ ) {
			arr[i] = keyboard.nextInt();
		}
		//Arrays.sort(arr, Collections.reverseOrder());
		Arrays.sort(arr);
		
		
		System.out.println("The array after sort is: ");
		for(int i :arr) {
			System.out.printf(" %d ",i);
			sum += i;
		}
		System.out.println(".");
		
		System.out.println("Sum and averange of array is :" + sum + " " + (float)(sum/n));
		keyboard.close();
	}
}
