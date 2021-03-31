

import java.time.LocalDate;

public class DateUtils {
	public static void CompareTwoDates(LocalDate d1, LocalDate d2) {
		int compareValue = d1.compareTo(d2);
		
		if(compareValue > 0 ) {
			System.out.println(d1 + " is later than " + d2);
		}
		else if (compareValue <0)
		{
			System.out.println(d1 + " is earlier than " + d2);
		}
		else 
		{
			System.out.println("both dates are equal");
		}
	}

	public static void SortDates(LocalDate[] listDates) {
		int len = listDates.length;
		for (int i = 0; i <len-1 ; i++)
			for(int j = i+1; j< len ; j ++) {
				if(listDates[i].compareTo(listDates[j]) > 0)
				{
					LocalDate tmpDate = listDates[i];
					listDates[i] = listDates[j];
					listDates[j] = tmpDate;
				}
			}
		
		System.out.println("The list of dates after sort is: ");
		for(LocalDate x: listDates) System.out.println(x);
	}
}
