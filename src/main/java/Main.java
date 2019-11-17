import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import static com.google.common.io.Resources.getResource;

public class Main {

    private static final String TRANSLATIONS_PATH = "C:\\Users\\Marius\\Desktop\\ProjectsForTesting\\src\\main\\resources\\translations.xml";

    public static void main(String[] args) throws IOException {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Marius\\Desktop\\ProjectsForTesting\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();



        driver.get("https://translate.google.com/?hl=en#view=home&op=translate&sl=lt&tl=zh-CN&text=laba%20diena");
        String rez = driver.findElement(By.cssSelector("span.tlid-translation.translation")).getText();
        System.out.println("" + rez);

        String fileContent = "Hello Learner !! Welcome to howtodoinjava.com.";

        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(TRANSLATIONS_PATH), StandardCharsets.UTF_8)){
            writer.write(rez);
        }

        // do stuff

       // JOptionPane.showMessageDialog(null, rez);

        driver.close();

    }
}
