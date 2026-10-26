import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MiniLibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Book Name to save: ");
        String bookName = scanner.nextLine();

        
        try {
            FileWriter writer = new FileWriter("library_books.txt", true);
            writer.write(bookName + "\n");
            writer.close();
            System.out.println("Book added and saved to 'library_books.txt' successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file.");
            e.printStackTrace();
        }
        scanner.close();
    }
}