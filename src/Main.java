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

        boolean runAgain = true;
        int playerScore = 0;
        int computerScore = 0;

        while (runAgain) {
            String[] choices = {"steen", "papier", "schaar", "spock"};
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

            String computerInput;
            if (computerScore <= playerScore - 2) {
                // Computer is cheating
                String[] newchoices;
                if (userInput.equals("steen")) {
                    newchoices = new String[]{"steen", "papier"}; // Remove losing option (scissors)
                } else if (userInput.equals("papier")) {
                    newchoices = new String[]{"papier", "schaar"}; // Remove losing option (rock)
                } else {
                    newchoices = new String[]{"schaar", "steen"}; // Remove losing option (paper)
                }
                computerInput = newchoices[rand.nextInt(2)]; // Randomly choose from remaining options
                System.out.println("The computer can't win from the likes of you, he is cheating and chooses: " + computerInput);
            } else {
                // Computer is playing fairly
                computerInput = choices[rand.nextInt(3)];
                System.out.println("The computer choice is: " + computerInput);
            }

            if (computerInput.equals("schaar") && userInput.equals("steen") /*&& rand.nextDouble() < 0.8*/) { //This makes it that the player will only win 20% of the time.
                System.out.println("Jij hebt gewonnen!");
                playerScore++;
            } else if (computerInput.equals("papier") && userInput.equals("schaar") /* || Make it that all wins are in the same statement.*/) {
                System.out.println("Jij hebt gewonnen!");
                playerScore++;
            } else if (computerInput.equals("steen") && userInput.equals("papier")) {
                System.out.println("Jij hebt gewonnen!");
                playerScore++;
            } else if (computerInput.equals("steen") && userInput.equals("schaar")) {
                System.out.println("Je hebt verloren.");
                computerScore++;
            } else if (computerInput.equals("papier") && userInput.equals("steen")) {
                System.out.println("Je hebt verloren.");
                computerScore++;
            } else if (computerInput.equals("schaar") && userInput.equals("papier")) {
                System.out.println("Je hebt verloren.");
                computerScore++;
            } else if (userInput.equals("spock")) {
                System.out.println("Jij hebt gewonnen!");
                playerScore++;
            } else {
                System.out.println("It's a draw.");
            }
            System.out.println("You're score is: " + playerScore + " versus " + computerScore + " of the computer.");
            runAgain = systemRunAgain(scanner);
        }
    }

    private static boolean systemRunAgain(Scanner scannerRunAgain) {
        System.out.println("Would you like to play another round? (yes/no): ");
        String anotherConversion = scannerRunAgain.next();
        scannerRunAgain.nextLine();
        return anotherConversion.equalsIgnoreCase("yes");
    }
}
