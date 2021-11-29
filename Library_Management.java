import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
class Library
{
    ArrayList<String> BooksList = new ArrayList<>(Arrays.asList("Python","Java","Bash","Html","Css","Hadoop","Excel","Vba","Javascript","Angular","Sql","Mongodb"));
    List<String> OriginalList = (List<String>) BooksList.clone();
    ArrayList<Integer> NumberOfBooks = new ArrayList<>(Arrays.asList(9,8,7,5,4,6,5,4,6,5,8,6));

    public void showAvailableBooks()
    {
        System.out.println("NUMBER OF BOOKS AVAILABLE                               BOOKS");
        for (int value=0; value< BooksList.size(); value++)
        {
            System.out.println("  " + NumberOfBooks.get(value) + "                                                      " + BooksList.get(value));
        }

    }

    public void addingBooks(String newBook)
    {
        if(BooksList.contains(newBook))
        {
            int index = BooksList.indexOf(newBook);
            NumberOfBooks.set(index, NumberOfBooks.get(index)+1);
        }
        else
        {
            BooksList.add(newBook);
            NumberOfBooks.add(1);
        }
    }

    public String issueBook(String newBook, String name)
    {
        if(BooksList.contains(newBook))
        {
            int index = BooksList.indexOf(newBook);
            NumberOfBooks.set(index, NumberOfBooks.get(index)-1);
            return "Hey " + name + " Your Book " + newBook + " has been issued. \n..............Thank You have a nice day............. !\n";

        }
        else
        {
            return " Sorry " + name + ", Your Book " + newBook + " is not available in our Library shortly . \n ......Hey " + name +" Why not you try Books available in our Library which are given below\n\n" + OriginalList;
        }
    }
    public void returningBook(String newBook,String name)
    {
        if(BooksList.contains(newBook))
        {
            int index = BooksList.indexOf(newBook);
            NumberOfBooks.set(index, NumberOfBooks.get(index)+1);
            System.out.println("Thank you " + name + " Your Book is Successfully returned .\n You can also try these books \n\n " + OriginalList);
        }
        else
        {
            System.out.println("Hey " + name +" , We don't have any data of your Book Name " + newBook + " . Please check Your Spelling from here :\n\n" + OriginalList );
        }
    }
}

public class Library_Management
{
    public String optionsAvailable()
    {
        return """
                Choose to Type :
                1.           for         Adding Books
                2.           for         Returning Books
                3.           for         Issue Book
                4.           for         Show Available Books
                0.           for         Exit
                Enter Your Chosen Value Here............""";
    }
    public static void  main(String ar[])
    {

        Scanner input_object = new Scanner(System.in);
        System.out.println("Welcome to Library");
        System.out.println("Please Enter Your Name");

        String name = input_object.nextLine();

        System.out.println("Hello "+ name + " , I am JAVA what should i do for you from the following commands");
        Library_Management vix = new Library_Management();
        System.out.println(vix.optionsAvailable());
        Library Call_options = new Library();

        boolean val = true;
        while (val){
        int chosen_value = input_object.nextInt();
        switch (chosen_value) {
            case 1 -> {
                System.out.println(name + " Please Enter The Book You want to add in our Library \t");
                String Book = input_object.next();
                Call_options.addingBooks(Book);
                System.out.print(".................Thank Your for adding a book for our Library................\n ");
                System.out.println("You can choose other available options from here \n");
                System.out.println(vix.optionsAvailable());

            }
            case 2 -> {
                System.out.print(name + " Please Enter The Book You want to return to Library \t");
                String newBook = input_object.next();
                Call_options.returningBook(newBook, name);
                System.out.println("You can choose other available options from here \n");
                System.out.println(vix.optionsAvailable());
            }
            case 3 -> {
                System.out.print(name + " Please Enter The Book You want to issue from Library \t");
                String newBook = input_object.next();
                System.out.println(Call_options.issueBook(newBook, name));
                System.out.println("Hey " + name +"You can choose more options available  here");
                System.out.println(vix.optionsAvailable());
            }
            case 4 -> {
                Call_options.showAvailableBooks();
                System.out.println("Hey " + name +"You can choose more options available  here");
                System.out.println(vix.optionsAvailable());
            }
            case 0 -> {

                System.out.print(".................Thank Your for Coming. Have a Good Day!.......");
                val = false;

            }
        }

            }
        }




    }
