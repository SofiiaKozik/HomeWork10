import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        Task1 task1 = new Task1();
        task1.SearchNumbers("files/Numbers.txt");
        Task2 task2 = new Task2();
        task2.createListUsers("files/File.txt");
        Task3 task3 = new Task3();
        task3.counter("files/Words.txt");
    }
}
