package introduction;

import java.util.ArrayList;

public class CoreJavaBrushUp_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,2,3,4,5,6,7,8,11,10,9,12};
		
		for (int i=0; i<arr.length; i++)
		{
			if(arr[i]%2 == 0)
			{
				System.out.println(arr[i]);
			}
			else
			{
				System.out.println(arr[i]+"is not multiple by 2");
			}

		}
		System.out.println("............................");
		
		ArrayList<String> arr2 = new ArrayList<String>();
		arr2.add("Always");
		arr2.add("Believe");
		arr2.add("On");
		arr2.add("God");
		System.out.println(arr2.get(3));
		System.out.println("............................");
		
		for(int i = 0; i<arr2.size(); i++)
		{
			System.out.println(arr2.get(i));
		}
		System.out.println("............................");
		
		for(String s: arr2)					//Enhanced for loop
		{
			System.out.println(s);
		}
		System.out.println("******************");
		
		System.out.println(arr2.contains("God"));	//Java String contains() Method
		
	}

}
