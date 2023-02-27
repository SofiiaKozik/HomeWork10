import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {

    public void SearchNumbers(String fileAdress) {
        File numbers = new File(fileAdress);
        if(numbers.exists()){
            try (InputStream fis = new FileInputStream(numbers)){
                Scanner scanner = new Scanner(fis);
                while (scanner.hasNext()){
                    String line = scanner.nextLine();
                    Pattern patternOne = Pattern.compile("^(\\d{3}[-]?){2}\\d{4}$");
                    Pattern patternTwo = Pattern.compile( "^\\(\\d{3}\\)[ ]\\d{3}[-]\\d{4}$");
                    Matcher matcherOne = patternOne.matcher(line);
                    Matcher matcherTwo = patternTwo.matcher(line);
                    if (matcherOne.matches() || matcherTwo.matches()){
                        System.out.println(line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
