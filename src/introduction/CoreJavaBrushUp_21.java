package introduction;

public class CoreJavaBrushUp_21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//By string literal
		String s =  "I’m The Best";
		String s1 = "God is always with me";
		
		//By new keyword
		String s2 = new String("Welcome");
		String s3 = new String("Welcome");
		
		String[] splitstrStrings = s.split(" ");		//split the String
		System.out.println(splitstrStrings[0]);
		System.out.println(splitstrStrings[1]);
		System.out.println(splitstrStrings[2]);
		
		System.out.println("**********************");

		for(int i=s.length()-1; i>=0; i--)
		{
			System.out.println(s.charAt(i));
		}
	}

}
