package com.S14;

import java.util.ArrayList;

public class WithoutStreams_Concept {

	public static void main(String[] args) {
		
		//count the number of names starting with A in list
		ArrayList<String> name = new ArrayList<String>();
		name.add("Asutosh");
		name.add("Pitabas");
		name.add("Abinash");
		name.add("Debasish");
		name.add("Anirudh");
		name.add("Srinibash");
		name.add("Ambarish");
		name.add("Snehasish");
		
		int count=0;
		for(int i=0; i<name.size(); i++)
		{
			String s=(name.get(i));
			if(s.startsWith("A"))
			{
				count++;
			}
			
		}
		System.out.println(count);

	}

}
