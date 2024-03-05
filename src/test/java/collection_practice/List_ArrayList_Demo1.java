package collection_practice;

import java.util.ArrayList;

public class List_ArrayList_Demo1 {

	public static void main(String[] args) 
	{
		
		ArrayList arr = new ArrayList();
		
		arr.add("Java");
		
		arr.add(0, "Selenium");
		
		arr.add("Java");
		
		arr.set(2, "TestNG");
		
		arr.add(null);
		
		arr.add(null);
		
		System.out.println(arr);
		
		System.out.println(arr.get(2));
		

	}

}
