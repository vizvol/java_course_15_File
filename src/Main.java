import com.sun.org.apache.xerces.internal.xs.StringList;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        //File file = new File("src","file_input.txt");

        try (FileReader fr = new FileReader("src/file_input.txt");
             FileWriter fw = new FileWriter("src/file_output.txt");
            BufferedReader br = new BufferedReader(fr);
             BufferedWriter bw = new BufferedWriter(fw)) {
            StringBuilder str = new StringBuilder();
            int i;
            while ( (i = br.read()) != -1) {
                if (!Character.toString((char)i).matches("\\p{Punct}"))
                    str.append(Character.toLowerCase( (char)i ));
            }
            FileText fileText = new FileText(str.toString());
            bw.write(fileText.OutputText());

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
