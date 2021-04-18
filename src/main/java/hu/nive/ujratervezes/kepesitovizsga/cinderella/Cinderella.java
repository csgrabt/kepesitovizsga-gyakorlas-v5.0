package hu.nive.ujratervezes.kepesitovizsga.cinderella;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

public class Cinderella {
    public static final String REGEX = " ";
    private final int[] numbers = new int[WORDS.size()];
    private static final List<String> WORDS = List.of("Hamupipőke", "galamb", "királyfi", "mostoha", "cipő");

    public void readFromFile() {

        try (BufferedReader bf = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(Cinderella.class.getResourceAsStream("cinderella.txt"))))) {
            String line;
            while ((line = bf.readLine()) != null) {
                dataProcess(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }


    }

    private void dataProcess(String line) {
        String[] array = line.split(REGEX);

        for (String item : array
        ) {
            for (int i = 0; i < WORDS.size(); i++
            ) {
                if (item.toLowerCase().contains(WORDS.get(i).toLowerCase())) {
                    numbers[i]++;
                }
            }
        }
    }

    public int[] getNumbers() {
        return numbers;
    }

    public Object[] getMax() {
        Object[] result = new Object[2];
        int number = numbers[0];
        int index = 0;

        for (int i = 1; i < numbers.length; i++) {
            if (number < numbers[i]) {
                number = numbers[i];
                index = i;
            }

        }
        result[0] = WORDS.get(index);
        result[1] = number;
        return result;
    }


    public static void main(String[] args) {
        Cinderella cinderella = new Cinderella();

        cinderella.readFromFile();
    }


}
