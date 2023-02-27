import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Task2 {
    List<UserDto> users = new LinkedList<>();

    public void createListUsers(String fileAdress) throws IOException {

        File numbers = new File(fileAdress);
        if(numbers.exists()){
            try (InputStream fis = new FileInputStream(numbers)){
                Scanner scanner = new Scanner(fis);
                scanner.nextLine();

                while (scanner.hasNext()){
                    String line = scanner.nextLine();
                    UserDto userDto = new UserDto();
                    userDto.setName(line.split(" ")[0]);
                    userDto.setAge(line.split(" ")[1]);
                    users.add(userDto);
                }
                System.out.println(users);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            createJsonFile();
        }
    }

    private void createJsonFile() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fileWriter = new FileWriter("Users.json");
        gson.toJson(users, fileWriter);
        fileWriter.close();
    }
}

