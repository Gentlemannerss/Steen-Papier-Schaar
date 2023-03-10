import java.util.Random;
import java.util.Scanner;

public class Main {

    /*OPDRACHT:
    Maak een Steen-papier-schaar spel.
    Bonus maak het zo dat je het spel vaker kan spelen en dat het de scores bijhoudt.
    Bonus maak het zo dat De computer vaker wint.
    Bonus maak het spel zo dat de computer vals speelt gaat spelen wanneer deze met meer dan 2 punten achter staat
    en dat ook visueel laat zien op een grappige manier maar weer normaal speelt als deze weer minder dan 2 punten achterloopt.
    Bonus maak het zo dat als je spock invoert dat je automatisch wint (cheat code)*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        String[] choices = {"Steen", "Papier", "Schaar"};
        System.out.println("Voer hier je keuze in, steen, papier of schaar.");
        String userInput = scanner.nextLine();
        System.out.println(userInput);
        int random = rand.nextInt(0,2);
        String computerInput = choices[random];

        if (computerInput.equals(userInput)) {
            System.out.println("It's a draw.");
        } else if (computerInput.equals("Schaar") && userInput.equals("Steen")) {
            System.out.println("Jij hebt gewonnen!");
        } else if (computerInput.equals("Papier") && userInput.equals("Schaar")) {
            System.out.println("Jij hebt gewonnen!");
        } else if (computerInput.equals("Steen") && userInput.equals("Papier")) {
            System.out.println("Jij hebt gewonnen!");
    }
}