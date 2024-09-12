package com.S14;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Stream_Concept {
	
	
	public static void main(String[] args) {
	
	//count the number of names starting with A in the list
	ArrayList<String> name = new ArrayList<String>();
	name.add("Asutosh");
	name.add("Pitabash");
	name.add("Abinash");
	name.add("Debasish");
	name.add("Anirudh");
	name.add("Srinibash");
	name.add("Ambarish");
	name.add("Snehasish");
	
		Long c = name.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
	//print all the name present in list
		name.stream().filter(s->s.length()>6).forEach(s->System.out.println(s));
	//print all  the names starts with S
		System.out.println("---------------");
		name.stream().filter(s->s.startsWith("S")).forEach(s->System.out.println(s));
	//print the name Starts with A in uppercase
		System.out.println("---------------");
		name.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	//print all the name with sorted order
		System.out.println("---------------");
		name.stream().sorted().map(s->s.toLowerCase()).forEach(s->System.out.println(s));
	
	}

	
}
