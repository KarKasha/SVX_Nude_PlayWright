package utils.com.example;

import java.time.LocalTime;
import java.util.Random;
public class TimeNumberGenerator {


    public static String generateTimeBasedLetters() {
        LocalTime now = LocalTime.now();
        int seed = now.getHour() * 3600 + now.getMinute() * 60 + now.getSecond();
        Random random = new Random(seed);

        StringBuilder letters = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            char letter = (char) ('A' + random.nextInt(26));
            letters.append(letter);
        }

        return letters.toString();
    }
}