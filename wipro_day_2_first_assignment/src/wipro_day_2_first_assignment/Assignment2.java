package wipro_day_2_first_assignment;

import java.util.Scanner;

public class Assignment2 {
	public static int countVowels(String st1) {
		int vow=0;
		Scanner s=new Scanner(System.in);
		st1 = s.nextLine().toLowerCase();
		for(int i=0;i<st1.length();i++) {
			char ch=st1.charAt(i);
			if(ch>='a' && ch<='z') {
				if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
					vow++;
				}
			}
		}
		return +vow; 
	}
	public static int countCons(String st2) {
		int cons=0;
		Scanner s=new Scanner(System.in);
		st2= s.nextLine().toLowerCase();
		for(int i=0;i<st2.length();i++) {
			char ch=st2.charAt(i);
			if(ch>='a' && ch<='z') {
				if(ch!='a' && ch!='e' && ch!='i' && ch!='o' && ch!='u') {
					cons++;
				}
			}
		}
		return +cons; 
	}
	public static boolean isPalindrome(String str) {
		Scanner s=new Scanner(System.in);
		str= s.nextLine().toLowerCase();
		String rev="";
		for(int i=str.length()-1;i>=0;i--) {
			rev+=str.charAt(i);
		}
		return str.equals(rev);
	}
	public static String reverseString(String str) {
		Scanner s=new Scanner(System.in);
		str= s.nextLine().toLowerCase();
		String rev=" ";
		for(int i=0;i<str.length();i++) {
			rev=str.charAt(i)+rev;
		}
		return rev;
	}
	public static String toUpperCase(String str) {
		Scanner s=new Scanner(System.in);
		str=s.nextLine();
		String uppercase=str.toUpperCase();
		System.out.println(uppercase);
		return uppercase;
	}
	public static String toLowerCase(String str) {
		Scanner s=new Scanner(System.in);
		str=s.nextLine();
		String lowercase=str.toLowerCase();
		System.out.println(lowercase);
		return lowercase;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		boolean st = true;
		char c;
		do {
			System.out.println("press 1 for the count of vowels and consonants");
			System.out.println("Press 2 to check if the string is palindrome");
			System.out.println("Press 3 to reverse the string");
			System.out.println("Press 4 to convert the string to uppercase and lowercase");
			System.out.println("press 5 to replace a word in the string");
			System.out.println("press 6 for exit");
			int choice=s.nextInt();
			String st1="Dharani".toLowerCase();
			switch(choice) {
			case 1:
			{
				System.out.println("Enter a string for vowels:");
				String result= s.nextLine();
				int vowels = countVowels(result);
				System.out.println("The count of vowels is:" +vowels);
				System.out.println("Enter a string for consonants:");
				int cons = countCons(result);
				System.out.println("The count of Consonants is:" +cons);
				
			}
			break;
			case 2:
			{
				System.out.println("Enter a string:");
				String input=s.nextLine();
				if(isPalindrome(input)) {
					System.out.println(input+ "is a palindrome");
				}
				else {
					System.out.println(input+ "is not a palindrome");
				}
			}
			break;
			case 3:
			{
				System.out.println("Enter a string:");
				String st3=s.nextLine();
				String rev=reverseString(st3);
				System.out.println(rev);
			}
			break;
			case 4:
			{
				System.out.println("Enter a string for uppercase:");
				String str=s.nextLine();
				String up=toUpperCase(str);
				System.out.println("Enter a string for lowercase:");
				String lower=toLowerCase(str);
			}
			break;
			case 5: 
			{
				StringBuffer s2= new StringBuffer("Marthala Guru Dharani");
				s2.replace(0, 8, "MG");
				System.out.println(s2);
			}
			break;
			case 6:
			{
				st=false;
				System.out.println("Thank You");
			}
			break;
			default:
				System.out.println("Invalid Input");
			}
			System.out.println("Do you want to continue? (Y/N)");
			c= s.next().charAt(0);
		}
		while(c=='Y' || c=='y');
		System.out.println("program ended");
	}
}
