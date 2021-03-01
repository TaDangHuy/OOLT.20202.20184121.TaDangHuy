package Buoi1;

import javax.swing.JOptionPane;

public class calculate {
	public static void main(String[] args) {
		String strNum1 = JOptionPane.showInputDialog(null,"Please input the first number: ", "Input the first number",JOptionPane.INFORMATION_MESSAGE);
		double num1 = Double.parseDouble(strNum1);
		
		String strNum2 = JOptionPane.showInputDialog(null,"Please input the second number: ", "Input the second number",JOptionPane.INFORMATION_MESSAGE);
		double num2 = Double.parseDouble(strNum2);
		
		double sum = num1+ num2;
		JOptionPane.showMessageDialog(null, sum ,"Sum of two num", JOptionPane.INFORMATION_MESSAGE);
		
		double difference = num1- num2;
		JOptionPane.showMessageDialog(null, difference ,"difference of two num", JOptionPane.INFORMATION_MESSAGE);
		
		double product = num1 * num2;
		JOptionPane.showMessageDialog(null, product ,"Sum of product num", JOptionPane.INFORMATION_MESSAGE);
		
		double quotient = (double)(num1 / num2);
		JOptionPane.showMessageDialog(null, quotient ,"Sum of two quotient", JOptionPane.INFORMATION_MESSAGE);
		
	}
}
