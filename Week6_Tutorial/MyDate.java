import FormatIO.*;
public class MyDate {
	private int day,month,year;
	public MyDate(int day,int month,int year) {
		this.day = day;
		this.month = month;
		this.year = year;
		// We always store year as 4 digits
		if(this.year <= 20) {
			this.year += 2000;
		}else {
			this.year += 1900;
		}
	}
	public MyDate(int ddmmyy) {
		this.day = ddmmyy / 10000;
		ddmmyy %= 10000; // get rid of the day part
		this.month = ddmmyy / 100;
		this.year  = ddmmyy % 100;
		// Does the same as the ifs in other constructor
		this.year  = (this.year <= 20) ? 2000 + this.year : 1900 + year;
	}
	public int getDay() { return day;}
	public int getYear() { return year;}
	public int getMonth() { return month;}
	public String getDate() {
		String ds = "";
		ds += String.format("%02d", day);
		ds += String.format("%02d",month);
		if(year >= 2000) {
			ds += String.format("%02d",year - 2000);
		}else {
			ds += String.format("%02d", year - 1900);
		}
		return ds;
	}
	public void print(Console fred) {
		String s = String.format("%02d/%02d/%04d",day,month,year);
		fred.println(s);
	}
	
	public int differenceInYears(MyDate now) {
		int diff = 0;
		if(now.getMonth() > this.month) { // could also use this.getMonth() instead of this.month but not now.month (month is private)
			// if the now month is greater than this then just subtract
			diff = now.getYear() - this.getYear();
		}else if (now.getMonth() < this.month){
			// if now month is less than, we need to subtract 1
			diff = now.getYear() - this.getYear() - 1;
		}else {
			// Same month, compare the days
			if(now.getDay() > this.day) {
				diff = now.getYear() - this.getYear();
			}else {
				diff = now.getYear() - this.getYear() - 1;
			}
		}
		return diff;
	}
	
	public static void main(String[] args) {
		MyDate d1 = new MyDate(14,10,43);
		System.out.println(d1.getDate());
		MyDate d2 = new MyDate(01,02,05);
		System.out.println(d2.getDate());
		MyDate d3 = new MyDate(130506);
		System.out.println(d3.getDate());
		
		Console con = new Console();
		d3.print(con);
		
		
		// Test the difference in years
		// Note this prints in eclipse and not in the console...
		int a = d1.differenceInYears(d2);
		System.out.println(a);
	}
	
}
