
/**
 * This application displays your purchasing information 
 * (Title of the book, The number of Book you bought, each price, and amount)
 * @author Yuki Miyazawa
 * @29th Oct 2018
 */
import java.util.Scanner; // import Scanner method

public class BookSalesApplication {
	
	static Scanner input = new Scanner(System.in);// initialize the scanner as class level 
    static final byte MINIMUM_NUMBER_OF_BOOK = 0;
    static final byte MAXIMUM_NUMBER_OF_BOOK = 10;
    static final byte MINIMUM_PRICE = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name; // declare name of book
		int numberOfBook; // declare the number of book
		float price; // declare price of the book
		int counter = 0; // for restricting user to use this application up to 5 times and no more
	
		displayPurpose(); // to display description/instruction of this application 
		
		do{
		System.out.printf("Transaction : %d \n", counter + 1); // to display the amount due for the transaction.
			
		name = getName(); // calling getName method;
		numberOfBook = getNumberOfBook(name); // calling getNumberofBook method
		price = getPrice(name);// calling getPrice method;
		
		displayResult(name,numberOfBook,price); // to display the result.
		System.out.printf("Amount of your transaction of %s: $ %.1f\n",name,amountPrice(numberOfBook,price)); // to display the amount due for the transaction.
		
		counter++; // counter + 1
		input.nextLine(); // this is for a buffer (flush)
		}while(counter <= 4);
		
		System.out.println("*************End of transaction*******************");
		System.out.println("*************Thank you for using!*******************");

		
	}// of main
	
	
	public static void displayPurpose(){// this method displays the purpose of this application
		System.out.println("********************    WELCOME    ****************************************");
		System.out.println("      This application displays your purchase information			");
		System.out.println("Title of the book, The number of Book you bought, each price, and amount");
		System.out.println("***************************************************************************");
	}
	
	public static String getName(){ // this method returns the user name
		System.out.println("please enter the title of book");
		String name = input.nextLine();
		return name;
	}

	public static int getNumberOfBook(String name){// this method returns the number of the book the user bought
		System.out.printf("please enter the number of book of %s\n",name);
		int number = input.nextInt();
		while(number > MAXIMUM_NUMBER_OF_BOOK || number < MINIMUM_NUMBER_OF_BOOK){// this while statement restricts the user from typing invalid number
			System.out.printf("invalid input, please ensure that the number should be betweeen %d - %d\n",MINIMUM_NUMBER_OF_BOOK,MAXIMUM_NUMBER_OF_BOOK);
			System.out.printf("please enter the number of book of %s\n",name);
			number = input.nextInt();			
		}
		return number;
	}

	public static float getPrice(String name){// this method returns price of the book the user bought
		System.out.printf("please enter the price of book of %s\n",name);
		float price = input.nextFloat();
		while(price < MINIMUM_PRICE){ // this while statement restricts the user from typing invalid number
			System.out.printf("invalid input, please ensure that the number should be more than %d \n",MINIMUM_PRICE);
			System.out.printf("please enter the price of book of %s\n",name);
			price = input.nextFloat();
		}
		return price;
	}
	
	public static float amountPrice(int price, float numberOfBook){ // this method returns total amount of transaction
		return price * numberOfBook;
	}

	public static void displayResult(String name, int number, float price){ // this method displays the result
		System.out.printf("------------your purchase---------------------\n");
		System.out.printf("Name of Book: %s \n",name);
		System.out.printf("Number of Book: %s \n",number);
		System.out.printf("Price of Book: $ %s \n",price);
		System.out.printf("----------------Amount---------------------\n");
	}
	
}
