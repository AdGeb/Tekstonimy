
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Words {
    private List<String> words;

    public Words(String filename) {
        words = readWords(filename);
    }

    public List<String> getWords() {
        return words;
    }

    private static List<String> readWords(String filename) {
        try (FileReader reader = new FileReader(filename); Scanner sc = new Scanner(reader)) {
            System.out.println("READING WORDS...");
            List<String> lines = new ArrayList<>();
            while (sc.hasNextLine()){
                lines.add(sc.nextLine());
            }
            System.out.println("ALL WORDS ARE READ.");
            return lines;

        } catch (Exception e) {
            System.err.println("FAILED TO CONNECT WITH FILE: " + filename);
        }
        return null;
    }

    public static void display(List<String> words, int amount){
        int cnt = 0;
        for (String s: words) {
            if(cnt >= amount){
                break;
            }
            System.out.print(s+"\t");
            ++cnt;
        }
    }

}
