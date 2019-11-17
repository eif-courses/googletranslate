import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static com.google.common.io.Resources.getResource;

public class Main {

    private static final String TRANSLATIONS_PATH = "C:\\Users\\Marius\\Desktop\\ProjectsForTesting\\src\\main\\resources\\translations.xml";

    private static List<String> translates = new ArrayList<>();
    public static void main(String[] args) throws IOException, InterruptedException {

        Map<String, String> languages = new HashMap<>();

        languages.put("af", "af");
        languages.put("am", "am");
        languages.put("ar", "ar");
        languages.put("hy-AM", "hy");
        languages.put("az-AZ", "az");
        languages.put("bn-BD", "bn");
        languages.put("eu-ES", "eu");
        languages.put("be", "be");
        languages.put("bg", "bg");
        languages.put("my-MM", "my");
        languages.put("ca", "ca");
        languages.put("zh-HK", "zh-CN");
        languages.put("zh-CN", "zh-CN");
        languages.put("zh-TW", "zh-TW");
        languages.put("hr", "hr");
        languages.put("cs-CZ", "cs-CZ");
        languages.put("da-DK", "da");
        languages.put("nl-NL", "nl");
        languages.put("en-IN", "en");

        String text_to_translate = "how-do-i-efficiently-iterate-over-each-entry-in-a-java-map";
        translate(languages, text_to_translate);


        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(TRANSLATIONS_PATH), StandardCharsets.UTF_8);
        for (String translate : translates) {
            //JOptionPane.showMessageDialog(null, translate);
            System.out.println(translate);

                writer.append(translate);
                writer.append("\n");
        }
        writer.flush();
        writer.close();

    }

    private static void translate(Map <String, String> languages, String word) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Marius\\Desktop\\ProjectsForTesting\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        languages.forEach((key, val) -> {
            driver.get("https://translate.google.com/?hl=en&op=translate&sl=en&tl="+key+"&text="+word);
            //System.out.println("https://translate.google.com/?hl=en&op=translate&sl=lt&tl="+language+"&text="+word);
            String rez = driver.findElement(By.cssSelector("span.tlid-translation.translation")).getText();
            //System.out.println("" + rez);
            translates.add("<"+val+">"+"\n"+rez+"\n"+"</"+val+">");
        });


        //Thread.sleep(100);
        driver.close();
        driver.quit();
    }


}
