import javax.swing.JOptionPane;

public class days_of_monthnew {

    
  public static void main(String[] strings) {

        //Scanner input = new Scanner(System.in);

        int number_Of_DaysInMonth = 0; 
        String MonthOfName = "Unknown";
        int year = -1;
        
        while(year <=0) {
        	String strYear = JOptionPane.showInputDialog(null,"Please enter a year:",JOptionPane.INFORMATION_MESSAGE);
        	year = (int)(Double.parseDouble(strYear));
        }

        String strMonth = JOptionPane.showInputDialog(null,"Please enter a month:",JOptionPane.INFORMATION_MESSAGE);
 
        if("January,Jan.,1".contains(strMonth)) {
                MonthOfName = "January";
                number_Of_DaysInMonth = 31;
        }else if ("Februaru,Feb.,2".contains(strMonth)) {
                MonthOfName = "February";
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    number_Of_DaysInMonth = 29;
                } else {
                    number_Of_DaysInMonth = 28;
                }
        }else if ("March,Mar.,3".contains(strMonth)) {
        	MonthOfName = "March";
            number_Of_DaysInMonth = 31;
		}else if ("April,Apr.,4".contains(strMonth)) {
			MonthOfName = "April";
            number_Of_DaysInMonth = 30;
		}else if ("May,May.,5".contains(strMonth)) {
			 MonthOfName = "May";
             number_Of_DaysInMonth = 31;
		}else if ("June,Jun.,6".contains(strMonth)) {
			MonthOfName = "June";
            number_Of_DaysInMonth = 30;
		}else if ("July,Jul.,7".contains(strMonth)) {
			 MonthOfName = "July";
             number_Of_DaysInMonth = 31;
		}else if ("August,Aug.,8".contains(strMonth)) {
			 MonthOfName = "August";
             number_Of_DaysInMonth = 31;
		}else if ("September,Sept.,9".contains(strMonth)) {
			 MonthOfName = "September";
             number_Of_DaysInMonth = 30;
		}else if ("October,Oct.,10".contains(strMonth)) {
			MonthOfName = "October";
            number_Of_DaysInMonth = 31;
		}else if ("November,Nov.,11".contains(strMonth)) {
			MonthOfName = "November";
            number_Of_DaysInMonth = 30;
		}else if ("December,Dec.,12".contains(strMonth)) {
			MonthOfName = "December";
            number_Of_DaysInMonth = 31;
		};
        
        String solutionString =  MonthOfName + " " + year + " has " + number_Of_DaysInMonth + " days";
        JOptionPane.showMessageDialog(null, solutionString);
    }
}