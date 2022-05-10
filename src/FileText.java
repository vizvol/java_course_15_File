import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileText {
    String text; // полный текст
    List<String> bigWords; // слова, в которых кол-во букв > 6

    public FileText(String text) {
        this.text = text;
        this.bigWords = ConvertToList(text);
    }

      private List<String> ConvertToList (String text) {
        List<String> stringList = new ArrayList<>();
        Pattern longWord = Pattern.compile("\\+*[а-яА-Я]{6,}");
        Matcher matcher = longWord.matcher(text);
        while (matcher.find()) {
            stringList.add(firstUpperCase(matcher.group()));
        };
        return stringList;
    }
    private String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public String OutputText (){

        return this.text + "\n" + ListToString(this.bigWords);
    }

    public String ListToString (List<String> list) {
        StringBuilder str = new StringBuilder();
        for (String s : list) {
            str.append(s + " ");
        }
        return str.toString();
    }



}
