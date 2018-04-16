package hashsetexample;

import java.util.Iterator;
import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
	
		
		MyHashSet<Integer> myHashSet=new MyHashSet<Integer>();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter the element");
			myHashSet.add(sc.nextInt());
			sc.nextLine();
			System.out.println("Do you want to continue(Y/N):");
			if(sc.nextLine().charAt(0)=='N')
			{
				break;
			}
			
		}
		
		Iterator<Integer> iterator=myHashSet.iterator();
		
		while(iterator.hasNext())
		{
			System.out.println(iterator.next()+"   ");
		}
		
	}
		
}
