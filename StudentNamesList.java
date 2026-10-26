import java.util.ArrayList;
import java.util.List;

public class StudentNamesList {
    public static void main(String[] args) {

        List<String> studentNames = new ArrayList<>();
        

        studentNames.add("Rahul");
        studentNames.add("Priya");
        studentNames.add("Amit");
        studentNames.add("Sneha");

    
        System.out.println("--- Student Names ---");
        for (String name : studentNames) {
            System.out.println(name);
        }
    }
}