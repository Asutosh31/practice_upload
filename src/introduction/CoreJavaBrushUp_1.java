package introduction;

public class CoreJavaBrushUp_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int a =34;
		String b ="Asu";
		double c =22.22;
		char d = 'R';
		boolean flag = true;
		System.out.println(flag);
		
		
		//Arrays -
		int[] arr = new int[4];  	//syntax or here we create size/memory allocation of array is [4]
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
	//	arr[4] = 50;
		System.out.println(arr[3]);
		
		System.out.println(".......");
		int[] arr2 = {1,2,3,4,5};			// simple syntax of array
		System.out.println(arr2[4]); 	
		
		System.out.println(".......");
		for(int i=0; i<arr.length; i++)		//for loop -
		{
			System.out.println(arr[i]);
		}
		
		System.out.println(".......");
		String[] name = {"Asu", "Ronu", "Gudu", "Manu"};	//String for loop
		for (int i=0; i<name.length; i++)
		{
			System.out.println(name[i]);
		}
		
		System.out.println(".......");
		for(String s: name)									//Enhanced for loop syntax
		{
			System.out.println(s);
		}

	}

}
