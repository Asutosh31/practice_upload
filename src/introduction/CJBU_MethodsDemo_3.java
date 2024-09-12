package introduction;

public class CJBU_MethodsDemo_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CJBU_MethodsDemo_3 d = new CJBU_MethodsDemo_3();
		String word = d.getData();
		System.out.println(word);
		
		CJBU_MethodsDemo_31 d1 = new CJBU_MethodsDemo_31();		//access methods from other class
		String word1 = d1.getUserData(); 
		System.out.println(word1);
		
		getData2();
		

	}
	
	public String getData()
	{
		System.out.println("Hello world");
		return "God tujh si great ho";
	}
	
	public static String getData2()					//without object directly accessing with the method name
	{
		System.out.println("Hello world2");
		return "God tujh si great ho2";
	}

}
