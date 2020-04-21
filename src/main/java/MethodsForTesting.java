import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MethodsForTesting {

    String abbreviation(String phrase) {
        if (phrase.isBlank()) {
            return "";
        }
        phrase = getAllWords(phrase.replaceAll("(С|с)анкт-(П|п)етербург(ский|скии)*", "СПб"))
                .replaceAll(" (с|в|или|к|и|на|за|под|по) ", " ")
                .replaceAll("\\s+", " ")
                .trim();
        return Arrays.stream(phrase.split(" "))
                .map(word -> "СПб".equals(word)
                        ? word
                        : word.substring(0, 1).toUpperCase()
                )
                .collect(Collectors.joining());
    }

    private String getAllWords(String phrase) {
        Pattern p = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = p.matcher(phrase);
        List<String> words = new LinkedList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return String.join(" ", words);
    }

    int minDigit(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

}
