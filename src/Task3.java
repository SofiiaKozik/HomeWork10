import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Task3 {

    Map<String, Integer> countWords = new HashMap<>();
    public void counter (String fileAdress) {
        File words = new File(fileAdress);

        if(words.exists()) {
            try (InputStream fis = new FileInputStream(words)) {
                Scanner scanner = new Scanner(fis);
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    String[] splitedLine = line.split(" ");
                    createMap(splitedLine);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Map<String, Integer> result = new TreeMap<>(comparator.reversed());
        result.putAll(countWords);

        System.out.println(result);
    }

    private void createMap(String[] splitedLine){

        for (String word: splitedLine) {
            if(countWords.containsKey(word)){
                int count = countWords.get(word);
                countWords.put(word, count + 1);
            } else {
                countWords.put(word, 1);
            }
        }

    }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer value1 = countWords.get(o1);
                Integer value2 = countWords.get(o2);
                int comp = value1.compareTo(value2);
                if (comp == 0) {
                    return 1;
                }
                return comp;
            }
        };
    }

