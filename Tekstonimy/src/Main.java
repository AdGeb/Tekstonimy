import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a combination of numbers: ");
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        Words words = new Words("C:\\Users\\Adam\\Desktop\\sjp\\slowa.txt");
        Map<String, List<String>> combinations = Converter.convert(words, digits);
        List<String> fiveFoundWords = combinations.get(digits).stream().limit(5).collect(Collectors.toList());
        combinations.forEach((k, v) -> System.out.println("FOR GIVEN COMBINATION: " + k +
                "\nNUMBER OF FOUND WORDS:  "+ v.size() +
                "\nFOUND WORDS: "));
        fiveFoundWords.forEach(s -> System.out.print(s+"\t"));
    }
}
