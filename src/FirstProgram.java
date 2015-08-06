//First program
//5/1/15

public class FirstProgram {
	public static void main(String [] args)
	{
		
		//System.out.println(convRom(1998));
		//lineBrak(10000,30);
		double a = 4.4;
		int b = (int) a;
		int k = 0;
		boolean t = true;
		System.out.println(k + " " + t);
		System.out.println(b);
		
		
	}
	public static int max3(int a, int b, int c)
	{
		int max = a;
		max = max >= b ? max : b;
		max = max >= c ? max : c;
		return max;
		
	}
	
	public static int max4(int a, int b, int c, int d)
	{
		int max = a;
		max = max >= b ? max : b;
		max = max >= c ? max : c;
		max = max >= d ? max : d;
		return max;
	}
	
	public static boolean isLeapYear(int year)
	{
		if (year % 4 == 0)
		{
			if (year % 100 == 0 && year % 400 != 0)
			{
				return false;
			}
			return true;

		}
		else
		{
			return false;
		}
	}
	public static void posPairs()
	{
			for (int b = 1; b < 1000; b++)
			{
				for(int a = 1; a < b; a ++)
				{
					if ((a * a + b * b + 1) % (a*b) == 0)
					{
						System.out.println("(" + a + "," + b + ")");
					}
				}
			}
	}
	public static String convRom(int a)
	{
		int theNum = a;
		int digitCounter = 0;
		int digit = 0;
		String romNum = "";
		if (theNum <= 0)
		{
			return "None";
		}		
		while(theNum > 0){
		digit = theNum % 10;
		digitCounter++;
			switch(digitCounter){
				case 1:
					switch(digit){
						case 1:
							romNum = "I" + romNum;
							break;
						case 2:
							romNum = "II" + romNum;
							break;
						case 3:
							romNum = "III" + romNum;
							break;
						case 4:
							romNum = "IV" + romNum;
							break;
						case 5:
							romNum = "V" + romNum;
							break;
						case 6:
							romNum = "VI" + romNum;
							break;
						case 7:
							romNum = "VII" + romNum;
							break;
						case 8:
							romNum = "VIII" + romNum;
							break;
						case 9:
							romNum = "IX" + romNum;
							break;
						default:
							break;
	
					}
				break;
				case 2:
					switch(digit){
						case 1:
							romNum = "X" + romNum;
							break;
						case 2:
							romNum = "XX" + romNum;
							break;
						case 3:
							romNum = "XXX" + romNum;
							break;
						case 4:
							romNum = "XL" + romNum;
							break;
						case 5:
							romNum = "L" + romNum;
							break;
						case 6:
							romNum = "LX" + romNum;
							break;
						case 7:
							romNum = "LXX" + romNum;
							break;
						case 8:
							romNum = "LXXX" + romNum;
							break;
						case 9:
							romNum = "XC" + romNum;
							break;
						default:
							break;
	
					}
				break;
				case 3:
					switch(digit){
						case 1:
							romNum = "C" + romNum;
							break;
						case 2:
							romNum = "CC" + romNum;
							break;
						case 3:
							romNum = "CCC" + romNum;
							break;
						case 4:
							romNum = "CD" + romNum;
							break;
						case 5:
							romNum = "D" + romNum;
							break;
						case 6:
							romNum = "DC" + romNum;
							break;
						case 7:
							romNum = "DCC" + romNum;
							break;
						case 8:
							romNum = "DCCC" + romNum;
							break;
						case 9:
							romNum = "CM" + romNum;
							break;
						default:
							break;
	
					}
				break;
				case 4:
					switch(digit){
						case 1:
							romNum = "M" + romNum;
							break;
						default:
							break;
	
					}
				break;
				default:
					System.out.println("You aren't able to computer that number yet");
			}
			theNum = theNum / 10;
		}
		
		return romNum;
	}
	public static void lineBrak(int a, int b)
	{
		int counter = 0;
		for (int x = 1; x <= a; x++)
		{
			if (counter == b)
			{
				System.out.println();
				counter = 0;
			}
			counter++;
			System.out.print("[" + x + "]");
		}
	}


}

