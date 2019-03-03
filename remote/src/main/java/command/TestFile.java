package command;

import java.io.File;

public class TestFile {
    public static void main(String[] args) {
        File file = new File("d:\\a\\b.txt");
        System.out.println(file.getName());
    }
}
