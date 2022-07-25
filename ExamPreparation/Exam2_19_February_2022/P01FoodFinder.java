package Exam2_19_February_2022;

import java.util.*;

public class P01FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //queue
        ArrayDeque<Character> vowels = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> vowels.offer(e.charAt(0)));
        //stack
        ArrayDeque<Character> consonants = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> consonants.push(e.charAt(0)));

        Map<String, Set<String>> foundWords = new LinkedHashMap<>();
        foundWords.put("pear", new HashSet<>());
        foundWords.put("flour", new HashSet<>());
        foundWords.put("pork", new HashSet<>());
        foundWords.put("olive", new HashSet<>());

        while (!consonants.isEmpty()) {
            String singleVowel = Objects.requireNonNull(vowels.poll().toString());
            String singleConsonant = consonants.pop().toString();

            for (Map.Entry<String, Set<String>> entry : foundWords.entrySet()) {
                String word = entry.getKey();
                if (word.contains(singleVowel)) {
                    Set<String> val = foundWords.get(word);
                    val.add(singleVowel);
                    foundWords.put(word, val);
                }

                if(word.contains(singleConsonant)) {
                    Set<String> val = foundWords.get(word);
                    val.add(singleConsonant);
                    foundWords.put(word, val);
                }
            }

            vowels.offer(singleVowel.charAt(0));
        }

        System.out.printf("Words found: %d%n", foundWords.entrySet().stream().filter(e -> e.getKey().length() == e.getValue().size()).count());
        foundWords.entrySet().stream().filter(e -> e.getKey().length() == e.getValue().size()).forEach(e -> System.out.println(e.getKey()));
    }
}

/*
e a u o
p r l x f

a o y
b h p j r n k
 */

/*
        ArrayDeque<String> vowels = Arrays.stream(console.nextLine().split("\\s+")).collect(Collectors.toCollection(ArrayDeque::new)); //queue

        ArrayDeque<String> consonants = new ArrayDeque<>(); //stack
        Arrays.stream(console.nextLine().split("\\s+")).forEach(consonants::push);

        Map<String, Set<String>> word = new LinkedHashMap<>();
        word.put("pear", new HashSet<>());
        word.put("flour", new HashSet<>());
        word.put("pork", new HashSet<>());
        word.put("olive", new HashSet<>());

        List<String> foundWord = new ArrayList<>();

        while (!consonants.isEmpty()) {
            String singleVowel = vowels.poll();
            String singleConsonant = consonants.pop();
            for (var entry : word.entrySet()) {
                if(entry.getKey().contains(singleVowel)) {
                    entry.getValue().add(singleVowel);
                }
                if(entry.getKey().contains(singleConsonant)) {
                    entry.getValue().add(singleConsonant);
                }
            }
            vowels.offer(singleVowel);
        }

        for (var entry : word.entrySet()) {
            if(entry.getKey().length() == entry.getValue().size()) {
                foundWord.add(entry.getKey());
            }
        }

        System.out.println("Words found: " + foundWord.size());
        System.out.println(String.join(System.lineSeparator(), foundWord));
 */