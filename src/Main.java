import java.util.Random;
import java.util.Scanner;

public class Main {

    /*OPDRACHT:
    Maak een steen-papier-schaar spel.
    Bonus maak het zo dat je het spel vaker kan spelen en dat het de scores bijhoudt.
    Bonus maak het zo dat De computer vaker wint.
    Bonus maak het spel zo dat de computer vals speelt gaat spelen wanneer deze met meer dan 2 punten achter staat
    en dat ook visueel laat zien op een grappige manier maar weer normaal speelt als deze weer minder dan 2 punten achterloopt.
    Bonus maak het zo dat als je spock invoert dat je automatisch wint (cheat code)*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        String[] choices = {"steen", "papier", "schaar"};
        System.out.println("Voer hier je keuze in, steen, papier of schaar.");
        String userInput;
        while (true) {
            System.out.println("Please enter your choice: ");
            userInput = scanner.nextLine().toLowerCase();

            boolean validInput = false;
            for (String choice : choices) {
                if (userInput.equals(choice)) {
                    validInput = true;
                    break;
                }
            }
            if (validInput) {
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        int random = rand.nextInt(2);
        String computerInput = choices[random];
        System.out.println("The computer choice is: " + computerInput);

        if (computerInput.equals("schaar") && userInput.equals("steen")) {
            System.out.println("Jij hebt gewonnen!");
        } else if (computerInput.equals("papier") && userInput.equals("schaar")) {
            System.out.println("Jij hebt gewonnen!");
        } else if (computerInput.equals("steen") && userInput.equals("papier")) {
            System.out.println("Jij hebt gewonnen!");
        } else if (computerInput.equals("steen") && userInput.equals("schaar")) {
            System.out.println("Je hebt verloren.");
        } else if (computerInput.equals("papier") && userInput.equals("steen")) {
            System.out.println("Je hebt verloren.");
        } else if (computerInput.equals("schaar") && userInput.equals("papier")) {
            System.out.println("Je hebt verloren.");
        } else {
            System.out.println("It's a draw.");
        }
    }
}
