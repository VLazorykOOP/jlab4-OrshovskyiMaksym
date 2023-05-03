import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName;
        boolean fileExists = false;
        while (!fileExists) {
            System.out.print("Введіть назву файлу: ");
            fileName = scanner.nextLine();


            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                fileExists = true;
                List<String> words = new ArrayList<>();
                String line;
                while ((line = br.readLine()) != null) {
                    words.addAll(Arrays.asList(line.split("\\s+")));
                }

                Map<Character, Integer> lowercaseLetterCounts = new TreeMap<>();
                Map<Character, Integer> uppercaseLetterCounts = new TreeMap<>();
                for (String word : words) {
                    for (char c : word.toCharArray()) {
                        if (Character.isLetter(c)) {
                            if (Character.isLowerCase(c)) {
                                lowercaseLetterCounts.put(c, lowercaseLetterCounts.getOrDefault(c, 0) + 1);
                            } else {
                                uppercaseLetterCounts.put(c, uppercaseLetterCounts.getOrDefault(c, 0) + 1);
                            }
                        }
                    }
                }

                System.out.println("Літери та їх кількість входжень у нижньому регістрі:");
                for (Map.Entry<Character, Integer> entry : lowercaseLetterCounts.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }

                System.out.println("Літери та їх кількість входжень у верхньому регістрі:");
                for (Map.Entry<Character, Integer> entry : uppercaseLetterCounts.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }

                Set<String> wordsWithDistinctLetters = new TreeSet<>();
                for (String word : words) {
                    Set<Character> distinctLetters = new HashSet<>();
                    for (char c : word.toCharArray()) {
                        if (Character.isLetter(c)) {
                            distinctLetters.add(Character.toLowerCase(c));
                            distinctLetters.add(Character.toUpperCase(c));
                        }
                    }
                    if (distinctLetters.size() == word.length() * 2) {
                        wordsWithDistinctLetters.add(word);
                    }
                }

                System.out.println("Слова з різними літерами:");
                for (String word : wordsWithDistinctLetters) {
                    System.out.println(word);
                }
            } catch (IOException e) {
                System.out.println("Файл з такою назвою не існує.");
            }
        }
    }
