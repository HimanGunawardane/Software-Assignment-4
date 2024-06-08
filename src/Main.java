import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("post.txt", true));
            writer.write("Hello");
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}