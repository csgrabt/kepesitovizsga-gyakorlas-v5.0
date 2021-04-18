package hu.nive.ujratervezes.kepesitovizsga.sleepingbeauty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SleepingBeauty {
    public Map<Character, Integer> countCharacters(String s) {
        Map<Character, Integer> result = new HashMap<>();

        try (BufferedReader bf = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(SleepingBeauty.class.getResourceAsStream("/" + s))))) {
            dataProcess(result, bf);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Something went wrong", ioe);
        }


        return result;
    }

    private void dataProcess(Map<Character, Integer> result, BufferedReader bf) throws IOException {
        String line;
        while ((line = bf.readLine()) != null) {
            char[] array = line.toCharArray();
            fillTheMap(result, array);
        }
    }

    private void fillTheMap(Map<Character, Integer> result, char[] array) {
        for (Character item : array
        ) {
            char ignoreUppercase = Character.toLowerCase(item);
            if (Character.isAlphabetic(ignoreUppercase)) {

                if (!(result.containsKey(ignoreUppercase))) {
                    result.put(ignoreUppercase, 1);
                } else {
                    result.put(ignoreUppercase, result.get(ignoreUppercase) + 1);
                }
            }
        }
    }
}
