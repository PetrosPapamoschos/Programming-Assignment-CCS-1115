import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FourHouses{
    public static void main(String[] args) {
        int house1[] = new int[31];
        int house2[] = new int[31]; 
        int house3[] = new int[31]; 
        int house4[] = new int[31];
        int roundNumber = -1;
        int choice = 0;
        int playerWhiteScore = 0;
        int playerBlackScore = 0;
        do{
            roundNumber++;
            int randomNumber = randomNumberGenerator(1, 15);
            if(roundNumber % 2 == 0){
                System.out.println("WHITE Plays (" + playerWhiteScore + " points)");
                displayMenu(house1, house2, house3, house4, randomNumber);
                playerWhiteScore = choiceStage(house1, house2, house3, house4, randomNumber, choice, playerWhiteScore); 
            }else{
                System.out.println("BLACK Plays (" + playerBlackScore + " points)");
                displayMenu(house1, house2, house3, house4, randomNumber);
                playerBlackScore = choiceStage(house1, house2, house3, house4, randomNumber, choice, playerBlackScore); 
            }
        }while(allHousesClosed(house1, house2, house3, house4));

        System.out.println("Game Over!");

        if (playerWhiteScore > playerBlackScore){
            System.out.println("WHITE wins with "+playerWhiteScore+" points!"); 
        }else if (playerBlackScore > playerWhiteScore){
            System.out.println("BLACK wins with "+playerBlackScore+" points!"); 
        }else if(playerBlackScore == playerWhiteScore){
            System.out.println("It's a tie! Both players have "+playerBlackScore+" points!");
        }
    }




        public static int randomNumberGenerator(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;
        return randomNumber;
    }

    public static boolean allHousesClosed(int house1[], int house2[], int house3[], int house4[]){
        int count = 0;
        if (isHouseClosed(house1)){
            count++;
        }
        if (isHouseClosed(house2)){
            count++;
        }
        if (isHouseClosed(house3)){
            count++;
        }
        if (isHouseClosed(house4)){
            count++;
        }
        if (count == 4){
            return false;
        }else{
            return true;
        }
    }

    public static boolean isHouseClosed(int house[]){
        if (sumOfHouse(house) > 31){
            return true;
        }else{
            return false;
        }
    }

        public static int sumOfHouse(int house[]){
            int sum = 0;
            for (int i = 0; i < house.length; i++){
                sum += house[i];
            }
            return sum;
    }

        public static void addtoHouse(int house[], int numberToAdd){
           house[nextEmptyIndex(house)] = numberToAdd;
        }

        public static int nextEmptyIndex(int house[]){
            for (int i = 0; i < house.length; i++){
                if (house[i] == 0){
                    return i;
                }
            }
            return -1;
        }

        public static void displayMenu(int[] house1, int[] house2, int[] house3, int[] house4, int randomNumber){
            if(isHouseClosed(house1)){
                System.out.println("Houses: \n"+"House 1: Closed!");
            }else{
            System.out.print("Houses:\n"+"House1 (sum:"+sumOfHouse(house1)+") ");
            for(int i=0; i<nextEmptyIndex(house1); i++) {
                System.out.print(house1[i]+" ");
            }
            System.out.println();
            }
            if(isHouseClosed(house2)){
                System.out.println("House 2: Closed!");
            }else{
            System.out.print("House2 (sum: "+sumOfHouse(house2)+") ");
            for(int i=0; i<nextEmptyIndex(house2); i++) {
                System.out.print(house2[i]+" ");
            }
            System.out.println();
            }

            if(isHouseClosed(house3)){
                System.out.println("House 3: Closed!");
            }else{
                System.out.print("House3 (sum: "+sumOfHouse(house3)+") ");
                for(int i=0; i<nextEmptyIndex(house3); i++) {
                System.out.print(house3[i]+" ");
            }
            System.out.println();
            }
            if(isHouseClosed(house4)){
                System.out.println("House 4: Closed!");
            }else{
            System.out.print("House4 (sum: "+sumOfHouse(house4)+") ");
            for(int i=0; i<nextEmptyIndex(house4); i++) {
                System.out.print(house4[i]+" ");
            }
            System.out.println();
            }
            System.out.println("Random number drawn: "+randomNumber+ "\nTo which house do you want to add the number?");
        }
        public static boolean houseEquals31(int house[]){
            if(sumOfHouse(house) == 31){
                resetHouse(house);
                return true;
            }
            return false;
        }

        public static void resetHouse(int house[]){
            Arrays.fill(house, 0);
        }

        public static int choiceStage(int house1[],int  house2[],int house3[],int  house4[], int randomNumber, int choice, int playerScore){
              Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
        while(choice < 1 || choice > 4){
            System.out.println("Your choice should be from 1 to 4. Please enter again:");
            choice = scan.nextInt();
        }     
            switch(choice){
            case 1: 
            {
                if(isHouseClosed(house1)){
                    System.out.println("House 1 is closed. Please choose another house:");
                    choiceStage(house1, house2, house3, house4, randomNumber, choice, playerScore);
                    return playerScore;
                }
                addtoHouse(house1, randomNumber);
                if(houseEquals31(house1)){
                    playerScore += 50;
                    System.out.println("You scored 50 points!");
                    return playerScore;
                }else if(isHouseClosed(house1)){
                    System.out.println("House 1 closed.");
                }
                break;
            }
            
            
            case 2: 
            {
                if(isHouseClosed(house2)){
                    System.out.println("House 2 is closed. Please choose another house:");
                    choiceStage(house1, house2, house3, house4, randomNumber, choice, playerScore);
                    return playerScore;
                }
                addtoHouse(house2, randomNumber);
                if(houseEquals31(house2)){
                    playerScore += 50;
                    System.out.println("You scored 50 points!");
                    return playerScore;
                }else if(isHouseClosed(house2)){
                    System.out.println("House 2 closed.");
                }
                break;
            }
            case 3: 
            {
                if(isHouseClosed(house3)){
                    System.out.println("House 3 is closed. Please choose another house:");
                    choiceStage(house1, house2, house3, house4, randomNumber, choice, playerScore);
                    return playerScore;
                }
                addtoHouse(house3, randomNumber);
                if(houseEquals31(house3)){
                    playerScore += 50;
                    System.out.println("You scored 50 points!");
                    return playerScore;
                }else if(isHouseClosed(house3)){
                    System.out.println("House 3 closed.");
                }
                break;
            }
            case 4: 
            {
               if(isHouseClosed(house4)){
                    System.out.println("House 4 is closed. Please choose another house:");
                    choiceStage(house1, house2, house3, house4, randomNumber, choice, playerScore);
                    return playerScore;
                }
                addtoHouse(house4, randomNumber);
                if(houseEquals31(house4)){
                    playerScore += 50;
                    System.out.println("You scored 50 points!");
                    return playerScore;
                }else if(isHouseClosed(house4)){
                    System.out.println("House 4 closed.");
                }
                break;
            }
        }
            return playerScore;

    }

}



