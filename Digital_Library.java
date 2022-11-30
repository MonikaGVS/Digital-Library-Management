package College;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class Digital_Library {
	public static void main(String[] args)
	{
		try (
        Scanner input = new Scanner(System.in)) {
            // menu
			JOptionPane.showMessageDialog(null, "***Welcome to DIGITAL LIBRARY MANAGEMENT*** \n To access the functionings \n please click on 'OK' button","Online Reservation System",3);
            System.out.println(" *******************Welcome to the Digital Library!*******************");
            System.out.println("|                 Select From The Following Options:		      |");
            System.out.println(" *********************************************************************");
			String choose;
			JOptionPane.showMessageDialog(null, "Please enter Student, if You are Student\n Otherwise enter Admin, if You are Admin :","user logging",3);
			choose = input.next();
			if(choose.equals("Student")){
				System.out.println("Hello Student!!!!\n Welcome to Digital Library\n If You are new student to this Library, Please Register as Student to access the Library fuctioning");
			}
			else{
				System.out.println("Hello Admin!!!!!");
			}
            books obj = new books();
            students objStudent = new students();

            int choice;
            int searchChoice;
            do {

            	obj.dispMenu();
            	choice = input.nextInt();
            	switch (choice) {
            	case 1:
            		book b = new book();
            		obj.addBook(b);
            		break;
            	case 2:
            		obj.upgradeBookQty();
            		break;
            	case 3:

            		System.out.println(
            			" press 1 to Search with Book Serial No.");
            		System.out.println(
            			" Press 2 to Search with Book's Author Name.");
            		searchChoice = input.nextInt();
            		switch (searchChoice) {
            		case 1:
            			obj.searchBySno();
            			break;
            		case 2:
            			obj.searchByAuthorName();
            		}
            		break;
            	case 4:
            		obj.showAllBooks();
            		break;
            	case 5:
            		student s = new student();
            		objStudent.addStudent(s);
            		break;
            	case 6:
            		objStudent.showAllStudents();
            		break;
            	case 7:
            		objStudent.checkOutBook(obj);
            		break;
            	case 8:
            		objStudent.checkInBook(obj);
            		break;
				case 9:
					System.out.println("You are Now Student");
            	default:
            		System.out.println("ENTER BETWEEN 0 TO 8.");
            	}

            }
            while (choice != 0);
        }
	}
}

