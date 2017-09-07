import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Contacts {
	//create an ArrayList Object for Contact books.
	ArrayList<String> contactBooks = new ArrayList<String>();
	Scanner input = new Scanner(System.in);
	private Scanner x;
	
	public boolean checkContactBook(){
		String contactBookName;
		boolean result = false;
		contactBookName = contactBookName();
		
		//next is to create a method to check the arrayList to know if the contact book name already exists.
		for(String check : contactBooks){
			if(contactBookName.contains(check)){
				System.out.println("Name already exits!");
				result = true;
			}else{
				result = false;
			}
		}
		return result;
	}
	
	public String contactBookName(){
		System.out.println("Enter the name of the contact book you want to create:\n");
		String contactBookName;
		contactBookName = input.nextLine();
		return contactBookName;
	}
	
	public void addToList(){
		contactBooks.add(contactBookName());
		System.out.println("Contact book added to Array list!");
	}
	
	@SuppressWarnings("static-access")
	public void addRecords(String name){
		String result1;
		
		boolean result2;
		
		String contactName, address, petName, dateOfBirth, email, phoneNumber;
		System.out.println("Enter in this order, the contacts name:\n"
				+ "Address\nPet name:\n"
				+ "Date of birth in this format day.month.year:\n"
				+ "Email:\n"
				+ "Phone number:\n");
		contactName = input.nextLine();
		address = input.nextLine();
		petName = input.nextLine();
		dateOfBirth = input.nextLine();
		email= input.nextLine();
		phoneNumber = input.nextLine();
		
		try{
			result1 = name.format("Contact name: %s, "
					+ "Address: %s, "
					+ "Pet name: %s, "
					+ "Date of Birth: %s, "
					+ "Email: %s, "
					+ "Phone number: %s", 
					contactName, address, petName, dateOfBirth, email, phoneNumber);
			
			if(result2 = Boolean.parseBoolean(result1)){
				System.out.println("record added!");
			}
	
		}catch(Exception e){
			System.out.println("Record not added!");
		}		
	}
	

	
	public void openFile(String n){
		try{
			x = new Scanner(new File(n+".txt"));
		}
		catch(Exception e){
			System.out.println("could not find file");	
		}
	}
	
	public String file(){
		System.out.println("Enter the name of the file you want to open:\n");
		String n;
		n = x.nextLine();
		return n;
	}
	
	public void clearContacts(String n){
		FileWriter fw = null;
		try {
			fw = new FileWriter(n+".txt", false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(n+".txt");
		}catch(FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pw.flush();
		pw.close();
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printContacts(String n){
		
		try {
			Scanner x = new Scanner(new File(n+".txt"));
			while (x.hasNextLine())
			{
			   System.out.println(input.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}


	