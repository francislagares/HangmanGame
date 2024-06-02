import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) throws Exception {

        // Scanner class to get user input
        Scanner scanner = new Scanner(System.in);

        // Declarations and assignments
        String secretWord = "intelligence";
        int maxAttempts = 10;
        int attempts = 0;
        boolean isWordGuessed = false;

        // Array to store guessed letters
        char[] guessedLetters = new char[secretWord.length()];

        // Initialize the guessed letters array with underscores
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        // Main game loop
        while (!isWordGuessed && attempts < maxAttempts) {
            System.out.println("Word to guess: " + String.valueOf(guessedLetters) + " (" + secretWord.length() + " letters)");
            System.out.println("Please enter a letter:");

            // Get the user's guessed letter
            char letter = Character.toLowerCase(scanner.next().charAt(0));

            boolean isLetterCorrect = false;

            // Check if the guessed letter is in the secret word
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == letter) {
                    guessedLetters[i] = letter;
                    isLetterCorrect = true;
                }
            }

            // If the letter was not found in the secret word
            if (!isLetterCorrect) {
                attempts++;
                System.out.println("Incorrect! You have " + (maxAttempts - attempts) + " attempts left.");
            }

            // Check if the entire word has been guessed
            if (String.valueOf(guessedLetters).equals(secretWord)) {
                isWordGuessed = true;
                System.out.println("Congratulations! You guessed the secret word: " + secretWord);
            }
        }

        // If the word was not guessed within the allowed attempts
        if (!isWordGuessed) {
            System.out.println("Too bad, you're out of attempts! GAME OVER");
        }

        scanner.close();
    }
}
