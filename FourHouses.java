import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FourHouses{

    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Initialize houses with size 31 to hold house numbers because the odds to exceed 31 are 1 in 19.175,105.923.288.408.666.849.136.352.539.062.5(so basically impossible)
        int house1[] = new int[31];
        int house2[] = new int[31]; 
        int house3[] = new int[31]; 
        int house4[] = new int[31];
        int roundNumber = -1; // Start from -1 so that first round is 0 (even) for WHITE
        // Initialize player scores
        int playerWhiteScore = 0;
        int playerBlackScore = 0;
        do{
            roundNumber++; // Increment round number
            int randomNumber = randomNumberGenerator(1, 15);
            if(roundNumber % 2 == 0){ // WHITE's turn is on even rounds
                System.out.println("WHITE Plays (" + playerWhiteScore + " points)");
                displayMenu(house1, house2, house3, house4, randomNumber); //Display game menu
                playerWhiteScore = choiceStage(house1, house2, house3, house4, randomNumber, playerWhiteScore); //Run choice stage for WHITE and update score
            }else{
                System.out.println("BLACK Plays (" + playerBlackScore + " points)");
                displayMenu(house1, house2, house3, house4, randomNumber); //Display game menu
                playerBlackScore = choiceStage(house1, house2, house3, house4, randomNumber, playerBlackScore); //Run choice stage for BLACK and update score
            }
        }while(!allHousesClosed(house1, house2, house3, house4)); //Continue until all houses are closed
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
    public static boolean allHousesClosed(int house1[], int house2[], int house3[], int house4[]){
       return (isHouseClosed(house1) && isHouseClosed(house2) && isHouseClosed(house3) && isHouseClosed(house4));
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

    //Method to reset a house
    public static void resetHouse(int house[]){
        Arrays.fill(house, 0);
    }

    //Method to add a number to a house
    public static void addtoHouse(int house[], int numberToAdd){
        int nextIndex = nextEmptyIndex(house);
        if (nextIndex != -1){ //Validatefor the unlikely event that the house is full
           house[nextEmptyIndex(house)] = numberToAdd;
        }
    }

    //Method to find the next empty index in a house
    public static int nextEmptyIndex(int house[]){
            for (int i = 0; i < house.length; i++){
                if (house[i] == 0){
                    return i;
                }
            }
            return -1; // Return -1 if house is full(which is immpossible in this game as mentioned before)
    }

    //Method to display the game menu
    public static void displayMenu(int[] house1, int[] house2, int[] house3, int[] house4, int randomNumber){
        System.out.println("Houses:");
        displayHouse(house1, 1);
        displayHouse(house2, 2);
        displayHouse(house3, 3);
        displayHouse(house4, 4);
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
    public static int choiceStage(int house1[],int  house2[],int house3[],int  house4[], int randomNumber, int playerScore){
        int choice = scan.nextInt();
        while(choice < 1 || choice > 4){
            System.out.println("Your choice should be from 1 to 4. Please enter again:");
            choice = scan.nextInt();
        } // Validate choice input
        return processHouseChoice(getHouseByChoice(choice, house1, house2, house3, house4), randomNumber, choice, playerScore, house1, house2, house3, house4);
    }

    //Method to get the house array based on player's choice
    public static int[] getHouseByChoice(int choice, int house1[], int house2[], int house3[], int house4[]){
        switch(choice){
            case 1:
                return house1;
            case 2:
                return house2;
            case 3:
                return house3;
            case 4:
                return house4;
            default:
                return null;
        }
    }

    //Method to process the player's house choice
    public static int processHouseChoice(int house[], int randomNumber, int choice, int playerScore, int house1[], int house2[], int house3[], int house4[]){
        if(isHouseClosed(house)){
            System.out.println("House " + choice + " is closed. Please choose another house:");
            return choiceStage(house1, house2, house3, house4, randomNumber, playerScore);
        }
        addtoHouse(house, randomNumber);
        if (houseEquals31(house)){
            playerScore += 50; // Award 50 points for hitting exactly 31
            System.out.println("You scored 50 points!");
        }else if(isHouseClosed(house)){
            System.out.println("House " + choice + " closed.");
        }
        return playerScore; // return same score if no points were scored
    }
}