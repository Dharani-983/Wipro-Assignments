package wipro_day_2_first_assignment;

import java.util.Scanner;

public class Assignment1 {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		char ch;
		boolean a=true;
		do {
			System.out.println("Press 1 to print a table of a number");
			System.out.println("Press 2 to calculate the factorial");
			System.out.println("Press 3 to check the prime number ");
			System.out.println("Press 4 to print fabinocci series");
			System.out.println("Press 5 to exit");
			System.out.println("Enter your choice");
			int choice = s.nextInt();
			switch(choice) {
				case 1:
				{
					System.out.println("Enter n value to print table");
					int n=s.nextInt();
					for(int i=0;i<=10;i++) {
						System.out.println(n + "*" + i + "=" +(n*i));
					}
				}
				break;
				case 2:
				{
					System.out.println("Enter f value to print factorial");
					int f=s.nextInt();
					double fact=1;
					for(int i=f;i>1;i--) {
						fact=fact*i;
					}
					System.out.println(fact);
				}
				break;
				case 3:
				{
					System.out.println("Enter p value to check prime number");
					int p = s.nextInt();
					boolean prime = true;
					if(p <= 1) {
						prime =false;
					}
					else {
						for(int i=2;i<=p/2;i++) {
							if(p % i ==0) {
								prime=false;
								break;
							}
						}
						if(prime) {
							System.out.println(p+ " is a prime number");
						}
						else {
							System.out.println(p+ " is not a prime number");
						}
					}
				}
				break;
				case 4:{
					System.out.println("Enter first series");
					int b = s.nextInt();
					System.out.println("Enter second series");
					int c = s.nextInt();
					System.out.println("Enter the series you want to print");
					int m=s.nextInt();
					for(int i=0;i<=m;i++) {
						System.out.println(b+ " ");
						int d= b+c;
						b=c;
						c=d;
					}
				}
				break;
				case 5:
				{
					a=false;
					System.out.println("Thank You");
				}
				break;
				default:
					System.out.println("Invalid Input");
			}
			System.out.println("Do you want to continue? (Y/N)");
			ch= s.next().charAt(0);
		}
		while(ch=='Y' || ch=='y');
		System.out.println("program ended");
	}

}
