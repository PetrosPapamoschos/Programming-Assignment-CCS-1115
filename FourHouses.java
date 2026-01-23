import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FourHouses{

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize houses with size 31 to hold house numbers because the odds to exceed 31 are 1 in 19.175,105.923.288.408.666.849.136.352.539.062.5(so basically impossible)
        int houses[][] = new int[4][31];
        int roundNumber = -1; // Start from -1 so that first round is 0 (even) for WHITE
        // Initialize player scores
        int playerWhiteScore = 0;
        int playerBlackScore = 0;
        do{
            roundNumber++; // Increment round number
            int randomNumber = randomNumberGenerator(1, 15);
            if(roundNumber % 2 == 0){ // WHITE's turn is on even rounds
                System.out.println("WHITE Plays (" + playerWhiteScore + " points)");
                displayMenu(houses, randomNumber); //Display game menu
                playerWhiteScore = choiceStage(houses, randomNumber, playerWhiteScore); //Run choice stage for WHITE and update score
            }else{
                System.out.println("BLACK Plays (" + playerBlackScore + " points)");
                displayMenu(houses, randomNumber); //Display game menu
                playerBlackScore = choiceStage(houses, randomNumber, playerBlackScore); //Run choice stage for BLACK and update score
            }
        }while(!allHousesClosed(houses)); //Continue until all houses are closed
        System.out.println("Game Over!");
        if (playerWhiteScore > playerBlackScore){
            System.out.println("WHITE wins with "+playerWhiteScore+" points!"); 
        }else if (playerBlackScore > playerWhiteScore){
            System.out.println("BLACK wins with "+playerBlackScore+" points!"); 
        }else if(playerBlackScore == playerWhiteScore){
            System.out.println("It's a tie! Both players have "+playerBlackScore+" points!");
        }
    }

    //Method to generate random number between min and max
    public static int randomNumberGenerator(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    //Method to check if all houses are closed
    public static boolean allHousesClosed(int houses[][]){
        for(int i=0; i < houses.length; i++) {
            if(!isHouseClosed(houses[i])){
                return false;
            }
        }
       return true;
    }

    //Method to check if a singular house is closed
    public static boolean isHouseClosed(int house[]){
       return (sumOfHouse(house) > 31 || nextEmptyIndex(house) == -1);
    }

    //Method to calculate the sum of numbers in a house
    public static int sumOfHouse(int house[]){
            int sum = 0;
            for (int i = 0; i < house.length; i++){
                if(house[i] == 0){// Stop summing at the first empty index
                    break;
                }
                sum += house[i];
            }
            return sum;
    }

    //Method to check if the sum of a house equals 31 and reset if true
    public static boolean houseEquals31(int house[]){
        if(sumOfHouse(house) == 31){
            resetHouse(house);
            return true;
        }
        return false;
    }

    //Method to check if adding a number to a house would exceed 31
    public static boolean houseGoesOver31(int house[], int numberToAdd){
        return (sumOfHouse(house) + numberToAdd) > 31;
    }

    //Method to reset a house
    public static void resetHouse(int house[]){
        Arrays.fill(house, 0);
    }

    //Method to add a number to a house
    public static void addtoHouse(int house[], int numberToAdd){
        int nextIndex = nextEmptyIndex(house);
        if (nextIndex != -1){ //Validatefor the unlikely event that the house is full
           house[nextIndex] = numberToAdd;
        }
    }

    //Method to find the next empty index in a house
    public static int nextEmptyIndex(int house[]){
            for (int i = 0; i < house.length; i++){
                if (house[i] == 0){
                    return i; // Return the first empty index
                }
            }
            return -1; // Return -1 if house is full(which is immpossible in this game as mentioned before)
    }

    //Method to display the game menu
    public static void displayMenu(int houses[][], int randomNumber){
        System.out.println("Houses:");
        for(int i=0; i < houses.length; i++) {
            displayHouse(houses[i], i + 1);
        }
        System.out.println("Random number drawn: "+randomNumber+ "\nTo which house do you want to add the number?");
    }

    //Method to display a singular house in the menu
    public static void displayHouse(int house[], int houseNumber){
        if(isHouseClosed(house)){
            System.out.println("House " + houseNumber + ": Closed!");
        }else{
            System.out.print("House " + houseNumber + " (sum: "+sumOfHouse(house)+") ");
            for(int i=0; i < house.length; i++) {
                if (house[i] == 0) {// Stop printing at the first empty index
                    break;
                }
                System.out.print(house[i]+" ");
            }
            System.out.println();
        }
    }

    //Method to handle the choice stage of the game
    public static int choiceStage(int houses[][], int randomNumber, int playerScore){
        int choice = scan.nextInt();
        while(choice < 1 || choice > 4){
            System.out.println("Your choice should be from 1 to 4. Please enter again:");
            choice = scan.nextInt();
        } // Validate choice input
        return processHouseChoice(houses[choice - 1], randomNumber, choice, playerScore, houses);
    }

    //Method to process the player's house choice
    public static int processHouseChoice(int houseOfChoice[], int randomNumber, int choice, int playerScore, int houses[][]){
        if(isHouseClosed(houseOfChoice)){
            System.out.println("House " + choice + " is closed. Please choose another house:");
            return choiceStage(houses, randomNumber, playerScore);
        }else if(cannotCloseHouse(houseOfChoice, randomNumber, houses)){
            System.out.println("Invalid move, other move(s) are availabe without closing a house. Choose another house.");
            return choiceStage(houses, randomNumber, playerScore);
        }
        addtoHouse(houseOfChoice, randomNumber);
        if (houseEquals31(houseOfChoice)){
            playerScore += 50; // Award 50 points for hitting exactly 31
            System.out.println("You scored 50 points!");
        }else if(isHouseClosed(houseOfChoice)){
            System.out.println("House " + choice + " closed.");
        }
        return playerScore; // return same score if no points were scored
    }

    //Method to check if the chosen house cannot be closed due to other available houses
    public static boolean cannotCloseHouse(int houseOfChoice[], int randomNumber, int houses[][]){
        //Check if adding the random number to the chosen house would exceed 31 
        //and if there are other houses that can accept the number without exceeding 31 which are not the chosen house
        if(houseGoesOver31(houseOfChoice, randomNumber)){
            for(int i=0; i < houses.length; i++) {
                if(houses[i] != houseOfChoice && !houseGoesOver31(houses[i], randomNumber)){
                    return true;
                }
            }
        }
        return false;
    }
}