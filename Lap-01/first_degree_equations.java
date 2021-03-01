package Buoi1;

import javax.swing.JOptionPane;

class first_degree_equations {
	public static void main(String[] args) {
		String[] options = {"1.A first-degree equation with 1 variable",
							"2.A fisrt-degree equation with 2 variables"};
		
		String input = (String)(JOptionPane.showInputDialog(null,
															"Please choose one program:",
															"First-degree equations",JOptionPane.INFORMATION_MESSAGE,null,options,options[0]));
		if(input.matches(options[0])) {
			
			String stra = JOptionPane.showInputDialog(null,"Enter a:",JOptionPane.INFORMATION_MESSAGE);
			Double a = Double.parseDouble(stra);
		
			String strb = JOptionPane.showInputDialog(null,"Enter b:",JOptionPane.INFORMATION_MESSAGE);
			Double b = Double.parseDouble(strb);
		
			if (b == 0) JOptionPane.showMessageDialog(null, null,"b <0 cannot done!!", JOptionPane.WARNING_MESSAGE);
			else {
					JOptionPane.showMessageDialog(null, (Double)(-b/a),"KET QUA:",JOptionPane.INFORMATION_MESSAGE);
				 }
			}
		
		else {
			
			String stra11 = JOptionPane.showInputDialog(null,"Enter a11",JOptionPane.INFORMATION_MESSAGE);
			Double a11 = Double.parseDouble(stra11);
			
			String stra12 = JOptionPane.showInputDialog(null,"Enter a12",JOptionPane.INFORMATION_MESSAGE);
			Double a12 = Double.parseDouble(stra12);
			
			String stra21 = JOptionPane.showInputDialog(null,"Enter a21",JOptionPane.INFORMATION_MESSAGE);
			Double a21 = Double.parseDouble(stra21);
			
			String stra22 = JOptionPane.showInputDialog(null,"Enter a22",JOptionPane.INFORMATION_MESSAGE);
			Double a22 = Double.parseDouble(stra22);
			
			String strb1 = JOptionPane.showInputDialog(null,"Enter b1",JOptionPane.INFORMATION_MESSAGE);
			Double b1 = Double.parseDouble(strb1);
			
			String strb2 = JOptionPane.showInputDialog(null,"Enter b2",JOptionPane.INFORMATION_MESSAGE);
			Double b2 = Double.parseDouble(strb2);
			
			
			Double D  = a11*a22 - a21*a12;
			Double D1 = b1*a22 - b2*a12;
			Double D2 = a11*b2 - a21*b1;
			
			if( D != 0 ) {
				
				String s = (Double)(D1/D) + " and " + (Double)(D2/D);
				
				JOptionPane.showMessageDialog(null, s , "Solution: X1 and X2 are :",JOptionPane.INFORMATION_MESSAGE);
				
				//JOptionPane.showMessageDialog(null, (Double)(D1/D)," X1 :",JOptionPane.INFORMATION_MESSAGE);;
				//JOptionPane.showMessageDialog(null, (Double)(D2/D),"X2 :",JOptionPane.INFORMATION_MESSAGE);
			} 
			
			else {
				if ((D1 == 0) && (D2 == 0)) {
					JOptionPane.showMessageDialog(null, null,"the system has INFINITElY many solutions!!",JOptionPane.INFORMATION_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(null, null,"the sytem has no solution.",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		}
			
	} 
	
}
