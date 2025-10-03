import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Игра висилица!!!!!! asdweqweqwe

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Слово для угадывания (можно поменять)
        String word = "JAVA";
        word = word.toUpperCase();

        Set<Character> guessed = new HashSet<>();
        int attemptsLeft = 6; // Количество жизней

        System.out.println("=== Игра Виселица ===");
        System.out.println("Угадай слово по буквам!");

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
            System.out.println("\nСлово: " + display);

            if (allGuessed) {
                System.out.println("🎉 Поздравляем! Ты угадал слово!");
                return;
            }

            System.out.println("Осталось попыток: " + attemptsLeft);
            System.out.print("Введи букву: ");
            String input = sc.nextLine().trim().toUpperCase();

            if (input.isEmpty()) {
                System.out.println("❌ Введи хотя бы одну букву!");
                continue;
            }

            char guess = input.charAt(0);
            if (!Character.isLetter(guess)) {
                System.out.println("❌ Нужно ввести букву!");
                continue;
            }

            if (guessed.contains(guess)) {
                System.out.println("⚠️ Буква уже называлась.");
                continue;
            }

            guessed.add(guess);

            if (word.indexOf(guess) >= 0) {
                System.out.println("✅ Верно!");
            } else {
                System.out.println("❌ Такой буквы нет.");
                attemptsLeft--;
            }
        }

        System.out.println("\n☠️ Ты проиграл! Загаданное слово было: " + word);
    }
}