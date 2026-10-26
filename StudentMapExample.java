import java.util.HashMap;
import java.util.Map;

public class StudentMapExample {
    public static void main(String[] args) {
        
        HashMap<Integer, String> studentMap = new HashMap<>();

        
        studentMap.put(101, "Rahul");
        studentMap.put(102, "Priya");
        studentMap.put(103, "Amit");

    
        System.out.println("--- Roll Number & Student Names ---");
        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
            System.out.println("Roll No: " + entry.getKey() + " | Name: " + entry.getValue());
        }
    }
}