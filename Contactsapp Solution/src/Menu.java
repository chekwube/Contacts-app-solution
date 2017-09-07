import java.util.Formatter;
import java.util.Scanner;

public class Menu {
	Scanner keyin = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu startMenu = new Menu();
		startMenu.printHeader();
		startMenu.runMenu();
		
	}
	
	private void printHeader(){
		System.out.println("+--------------+");
		System.out.println("| Contacts App |");
		System.out.println("+--------------+/n");
	}
	
	private void runMenu(){
		System.out.println("Press 1 to Create Contacts Book \n Press 2 to Load Contacts Book \n Press 3 to Exit \n Enter choice:\n");
		int choice1 = getInput1();
		yourChoice1(choice1);		
	}
	
	private int getInput1(){
		String mychoice;
		int choice1 = 0;
		
		mychoice = keyin.nextLine();
		
		
			try{
				choice1 = Integer.parseInt(mychoice);
				if(choice1 > 0 && choice1 < 4){
					
				}else{
					System.out.println("Select a number between 1 to 3");
				}
				
			}catch(NumberFormatException e){
				System.out.println("Invalid Selection, Numbers Only!");
			}
		
		return choice1;
	}
	
	private void yourChoice1(int choice1){
		switch(choice1){
			case 1:
				//call the createContactBook method
				createContactBook();
			case 2: 
				//loadContact book
				loadContact();
				case 3:
			//Exit Application
			System.out.println("Thank you for using our application");
			System.exit(0);
		}
	}
	
	private void loadContact() {
		// TODO Auto-generated method stub
		
	}

	private void createContactBook(){
		System.out.println("Enter the name of the contact book you want to create:\n");
		Contacts contacts = new Contacts();
		//next is to check the array list to know if the contact book name already exists.
		if(contacts.checkContactBook() == true){
			System.out.println("Another contact book already bears that name!");
			createContactBook();
		}else{
			
			String name = contacts.contactBookName();
			//create a file that bears the name you chose for the contacts book
			final Formatter file;
			try{
				file = new Formatter(name + ".txt");
				System.out.printf("%s.txt contact book created successfully: press Enter", name);
			}catch(Exception e){
				System.out.println("Error: contact book not created");
			}
			//add the contacts book name you chose to the arrayList
			contacts.addToList();
		}
		Contacts list = new Contacts();
		list.openFile(list.file());	
		
		//Display the createContacts options
		System.out.println("Press 1 to Add a Contact\n"
				+ "Press 2 to Remove a Contact\n"
				+ "Press 3 to List the Contact\n"
				+ "Press 4 to Go back:\n");
		//process the option selected from createContactsMenu
		int choice2 = getInput2();
		yourChoice2(choice2);	
	}

	private int getInput2(){
		int choice2 = -1;
		if(choice2 > 0 && choice2 < 5){
			try{
				choice2 = Integer.parseInt(keyin.nextLine());
			}catch(NumberFormatException e){
				System.out.println("Invalid Selection, Numbers Only!");
			}
		}else{
			System.out.println("Select a number between 1 to 4");
		}
		return choice2;
	}
	
	private void yourChoice2(int choice2){
		
		switch(choice2){
		case 1:
			//call the addContact method
			addContact();
		case 2:
			//call the removeContacts method
			removeContact();
		
		case 3:
			//call the listContact method
			listContact();
		case 4:
			//Go back
			runMenu();	
		}
	}

	private void addContact(){
		Contacts contacts = new Contacts();
		contacts.addRecords(contacts.file());		
	}
	
	private void removeContact(){
		Contacts contacts = new Contacts();
		contacts.clearContacts(contacts.file());
	
	}

	private void listContact(){
		Contacts contacts = new Contacts();
		contacts.printContacts(contacts.file());
	
	}
	
}
