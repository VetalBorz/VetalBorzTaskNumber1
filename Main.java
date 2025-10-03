import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Игра висилица!!!!!!

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Слово для угадывания (можно поменять)
        String word = "JAVA";
        word = word.toUpperCase();

        Set<Character> guessed = new HashSet<>();
        int attemptsLeft = 100; // Количество жизней

        output("=== Игра Виселица ===");
        output("Угадай слово по буквам!");

        while (attemptsLeft > 0) {
            // Печатаем текущее состояние
            StringBuilder display = new StringBuilder();
            boolean allGuessed = true;
            for (char c : word.toCharArray()) {
                if (guessed.contains(c)) {
                    display.append(c).append(" ");
                } else {
                    display.append("_ ");
                    allGuessed = false;
                }
            }
            output("\nСлово: " + display);

            if (allGuessed) {
                output("🎉 Поздравляем! Ты угадал слово!");
                return;
            }

            output("Осталось попыток: " + attemptsLeft);
            System.out.print("Введи букву: ");
            String input = sc.nextLine().trim().toUpperCase();

            if (input.isEmpty()) {
                output("❌ Введи хотя бы одну букву!");
                continue;
            }

            char guess = input.charAt(0);
            if (!Character.isLetter(guess)) {
                output("❌ Нужно ввести букву!");
                continue;
            }

            if (guessed.contains(guess)) {
                output("⚠️ Буква уже называлась.");
                attemptsLeft--;
                continue;
            }

            guessed.add(guess);

            if (word.indexOf(guess) >= 0) {
               output("✅ Верно!");
                attemptsLeft--;
            } else {
                output("❌ Такой буквы нет.");
                attemptsLeft--;
            }
        }

        output("\n☠️ Ты проиграл! Загаданное слово было: " + word);
    }
    public static void output(String word) {
       // StringBuilder output = new StringBuilder(word);
        System.out.println(word);
    }
}