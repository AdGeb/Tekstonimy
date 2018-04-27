import java.util.*;
import java.util.stream.Collectors;

public class Converter {

    public static Map<String, List<String>> convert(Words words, String digitCombination) {
        Map<String, String> digitsFromWords = new HashMap<>();
        for( String w : words.getWords()) {
            digitsFromWords.put(w, convertStringToNumbers(w));
        }

        Map<String, List<String>> groupedCombinations = new HashMap<>();
        for (Map.Entry<String, String> e : digitsFromWords.entrySet()) {
            if (groupedCombinations.containsKey(e.getValue())) {
                groupedCombinations.get(e.getValue()).add(e.getKey());
            } else {
                groupedCombinations.put(e.getValue(), new ArrayList<>(Arrays.asList(e.getKey())));
            }
        }
        return groupedCombinations
                .entrySet()
                .stream()
                .filter(e -> e.getKey().equals(digitCombination))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static String convertStringToNumbers(String text) {
        StringBuilder digits = new StringBuilder();
        Map<String, String> keyboardMapper = mapper();
        for (char c : text.toCharArray()) {
            digits
                    .append(
                            keyboardMapper
                                    .entrySet()
                                    .stream()
                                    .filter(e -> e.getKey().contains(Character.toString(c)))
                                    .findFirst()
                                    .orElseThrow(NullPointerException::new)
                                    .getValue()
                    );

        }
        return digits.toString();
    }

    private static Map<String, String> mapper() {
        Map<String, String> keyboardMapper = new HashMap<>();
        keyboardMapper.put("aąbcć", "2");
        keyboardMapper.put("deęf", "3");
        keyboardMapper.put("ghi", "4");
        keyboardMapper.put("jklł", "5");
        keyboardMapper.put("mnńoó", "6");
        keyboardMapper.put("pqrsś", "7");
        keyboardMapper.put("tuv", "8");
        keyboardMapper.put("wxyzźż", "9");
        return keyboardMapper;
    }
}
