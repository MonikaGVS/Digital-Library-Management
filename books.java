package College;
import java.util.Scanner;
public class books {
	book obj_Books[] = new book[50];
	public static int count;

	Scanner input = new Scanner(System.in);
	public int compareBookObjects(book b1, book b2)
	{
		if (b1.bookName.equalsIgnoreCase(b2.bookName)) {
			System.out.println(
				"Book of this Name Already Exists.");
			return 0;
		}
		if (b1.sNo == b2.sNo) {
			System.out.println(
				"Book of this Serial No Already Exists.");

			return 0;
		}
		return 1;
	}
	public void addBook(book b)
	{

		for (int i = 0; i < count; i++) {

			if (this.compareBookObjects(b, this.obj_Books[i])
				== 0)
				return;
		}

		if (count < 50) {

			obj_Books[count] = b;
			count++;
		}
		else {

			System.out.println(
				"No Space to Add More Books.");
		}
	}
	public void searchBySno()
	{
		System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");
		int sNo;
		System.out.println("Enter Serial No of Book:");
		sNo = input.nextInt();

		int flag = 0;
		System.out.println(
			"S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

		for (int i = 0; i < count; i++) {
			if (sNo == obj_Books[i].sNo) {
				System.out.println(
					obj_Books[i].sNo + "\t\t"
					+ obj_Books[i].bookName + "\t\t"
					+ obj_Books[i].authorName + "\t\t"
					+ obj_Books[i].bookQtyCopy + "\t\t"
					+ obj_Books[i].bookQty);
				flag++;
				return;
			}
		}
		if (flag == 0)
			System.out.println("No Book for Serial No "
							+ sNo + " Found.");
	}
	public void searchByAuthorName()
	{
		System.out.println(
			"\t\t\t\tSEARCH BY AUTHOR'S NAME");

		input.nextLine();

		System.out.println("Enter Author Name:");
		String authorName = input.nextLine();

		int flag = 0;

		System.out.println(
			"S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

		for (int i = 0; i < count; i++) {
			if (authorName.equalsIgnoreCase(
					obj_Books[i].authorName)) {
				System.out.println(
					obj_Books[i].sNo + "\t\t"+obj_Books[i].bookName+"\t"+obj_Books[i].authorName+"\t"+obj_Books[i].bookQtyCopy+"\t"+obj_Books[i].bookQty);
				flag++;
			}
		}
		if (flag == 0)
			System.out.println("No Books of " + authorName
							+ " Found.");
	}
	public void showAllBooks()
	{

		System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
		System.out.println(
			"S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

		for (int i = 0; i < count; i++) {

			System.out.println(
				obj_Books[i].sNo + "\t\t"
				+ obj_Books[i].bookName + "\t\t"
				+ obj_Books[i].authorName + "\t\t"
				+ obj_Books[i].bookQtyCopy + "\t\t"
				+ obj_Books[i].bookQty);
		}
	}
	public void upgradeBookQty()
	{

		System.out.println(
			"\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
		System.out.println("Enter Serial No of Book");

		int sNo = input.nextInt();

		for (int i = 0; i < count; i++) {

			if (sNo == obj_Books[i].sNo) {
				System.out.println(
					"Enter No of Books to be Added:");

				int addingQty = input.nextInt();
				obj_Books[i].bookQty += addingQty;
				obj_Books[i].bookQtyCopy += addingQty;

				return;
			}
		}
	}
	public void dispMenu()
	{
		System.out.println(
			"----------------------------------------------------------------------------------------------------------");
		System.out.println("Press 0 to Exit Application.");
		System.out.println("Press 1 to Add new Book.");
		System.out.println(
			"Press 2 to Upgrade Quantity of a Book.");
		System.out.println("Press 3 to Search a Book.");
		System.out.println("Press 4 to Show All Books.");
		System.out.println("Press 5 to Register Student.");
		System.out.println(
			"Press 6 to Show All Registered Students.");
		System.out.println("Press 7 to Check Out Book. ");
		System.out.println("Press 8 to Check In Book");
		System.out.println("Press 9 to Switch as Student. ");
		System.out.println(
			"-------------------------------------------------------------------------------------------------------");
	}

	
	public int isAvailable(int sNo)
	{

		for (int i = 0; i < count; i++) {
			if (sNo == obj_Books[i].sNo) {
				if (obj_Books[i].bookQtyCopy > 0) {

					System.out.println(
						"Book is Available.");
					return i;
				}
				System.out.println("Book is Unavailable");
				return -1;
			}
		}

		System.out.println("No Book of Serial Number "
						+ " Available in Library.");
		return -1;
	}
	public book checkOutBook()
	{

		System.out.println(
			"Enter Serial No of Book to be Checked Out.");
		int sNo = input.nextInt();

		int bookIndex = isAvailable(sNo);

		if (bookIndex != -1) {
			obj_Books[bookIndex].bookQtyCopy--;
			return obj_Books[bookIndex];
		}
		return null;
	}
	public void checkInBook(book b)
	{
		for (int i = 0; i < count; i++) {
			if (b.equals(obj_Books[i])) {
				obj_Books[i].bookQtyCopy++;
				return;
			}
		}
	}
}
