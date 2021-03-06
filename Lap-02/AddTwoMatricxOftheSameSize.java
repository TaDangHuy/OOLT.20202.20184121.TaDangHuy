
import java.util.Scanner;

public class AddTwoMatricxOftheSameSize {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the level of matrix: ");
		int lv = keyboard.nextInt();
		
		int arr1[][] = new int[lv][lv];
		int arr2[][] = new int[lv][lv]; 
		int arrSum[][] = new int[lv][lv];
		
		System.out.println("Enter the first matrix:");
		for(int i = 0; i < lv ; i++) 
			for(int j = 0; j<lv ; j++) {
				arr1[i][j] = keyboard.nextInt();
			} 
		
		System.out.println("Now Enter the second matrix: ");
		for(int i = 0; i<lv ; i++) 
			for(int j = 0; j<lv;j++){
				arr2[i][j] = keyboard.nextInt();
				arrSum[i][j] = arr1[i][j] + arr2[i][j];
			}
		
		System.out.println("The solution is:");
		
		for(int i = 0; i<lv ; i++) 
			{
			 	for(int j: arrSum[i]) System.out.printf("%d ", j); 
			 	System.out.println();
			}
			
		keyboard.close();
	}
}
