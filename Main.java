import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<String> readWords(String path){

        if(path == null){
            System.out.println("PATH IS NOT DECLARED!");
            return null;
        }

        File file = new File(path);
        List<String> list = new ArrayList<>();
        System.out.println("READING WORDS...");
        try (Scanner sc = new Scanner(file)) {
            String in;
            while (sc.hasNextLine()){
                in = sc.nextLine();
                list.add(in);
            }
            sc.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("ALL WORDS ARE READ.");
        return list;
    }

    public static String selectNumber(char c){

        Character character = c;
            if(character.toString().matches("^[aąbcć]?")){
                return "2";
            }else if(character.toString().matches("^[deęf]?")){
                return "3";
            }else if(character.toString().matches("^[ghi]?")){
                return "4";
            }else if(character.toString().matches("^[jklł]?")){
                return "5";
            }else if(character.toString().matches("^[mnńoó]?")){
                return "6";
            }else if(character.toString().matches("^[pqrsś]?")){
                return "7";
            }else if(character.toString().matches("^[tuv]?")){
                return "8";
            }else if(character.toString().matches("^[wxyzźż]?")){
                return "9";
            }else return null;
    }

    public static String buildNumberArray(String s){
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(selectNumber(arr[i]) != null) sb.append(selectNumber(arr[i]));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String path = "C:/Users/Adam/Desktop/sjp/slowa.txt";
        List<String> list = readWords(path);
        List<String> foundTextonims = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("PODAJ CIAG CYFR:");
        String numbers = sc.next();

        int counter = 0;
        for (String s: list) {
            if(numbers.equals(buildNumberArray(s))){
                counter++;
                if(foundTextonims.size() < 5) foundTextonims.add(s);
            }
        }



        ///////////////////////////////////////////////////////////////////
        ////////////////////////////OUTPUT/////////////////////////////////
        if(counter > 0) {
            System.out.println("MATCHING WORDS: " + counter);
            System.out.println("FOUND:");
            for (String s2 : foundTextonims) {
                System.out.print(s2 + "\t");
            }
        }else System.out.println("NO WORDS FOUND");

    }
}
