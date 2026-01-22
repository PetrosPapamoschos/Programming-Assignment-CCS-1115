import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FourHouses{
    public static void main(String[] args) {
        int house1[] = new int[31];
        int house2[] = new int[31]; 
        int house3[] = new int[31]; 
        int house4[] = new int[31];

        int randomNumber =  32;//randomNumberGenerator(1, 15);
      
        int choice = 0;
        int playerWhiteScore = 0;
        int playerBlackScore = 0;

    do{
        displayMenu(house1, house2, house3, house4, randomNumber);
        choiceStage(house1, house2, house3, house4, randomNumber, choice); 
        


    }while(allHousesClosed(house1, house2, house3, house4));

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
            System.out.print("Houses:\n"+"House1 (sum:"+sumOfHouse(house1)+") ");
            for(int i=0; i<nextEmptyIndex(house1); i++) {
                System.out.print(house1[i]+" ");
            }
            System.out.println();
            System.out.print("House2 (sum"+sumOfHouse(house2)+") ");
            for(int i=0; i<nextEmptyIndex(house2); i++) {
                System.out.print(house2[i]+" ");
            }
            System.out.println();
            System.out.print("House3 (sum"+sumOfHouse(house3)+") ");
            for(int i=0; i<nextEmptyIndex(house3); i++) {
                System.out.print(house3[i]+" ");
            }
            System.out.println();
            System.out.print("House4 (sum"+sumOfHouse(house4)+") ");
            for(int i=0; i<nextEmptyIndex(house4); i++) {
                System.out.print(house4[i]+" ");
            }
            System.out.println();
            System.out.println("Random number drawn: "+randomNumber+ "\nTo which house do you want to add the number?");
        }
        public static void houseEquals31(int house[]){
            if(sumOfHouse(house) == 31){
                //playerScore += 50;
                resetHouse(house);
            }
        }

        public static void resetHouse(int house[]){
            Arrays.fill(house, 0);
        }

        public static void choiceStage(int house1[],int  house2[],int house3[],int  house4[], int randomNumber, int choice){
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
                    choiceStage(house1, house2, house3, house4, randomNumber, choice);
                }
                addtoHouse(house1, randomNumber);
                // if(houseEquals31(house1)){
                //     playerScore += 50;
                // }else 
                if(isHouseClosed(house1)){
                    System.out.println("House 1 closed.");
                }
                break;
            }
            
            
            case 2: 
            {
                if(isHouseClosed(house2)){
                    System.out.println("House 2 is closed. Please choose another house:");
                    choiceStage(house1, house2, house3, house4, randomNumber, choice);
                }
                addtoHouse(house2, randomNumber);
                // if(houseEquals31(house2)){
                //     playerScore += 50;
                // }else
                 if(isHouseClosed(house2)){
                    System.out.println("House 2 closed.");
                }
                break;
            }
            case 3: 
            {
                if(isHouseClosed(house3)){
                    System.out.println("House 3 is closed. Please choose another house:");
                    choiceStage(house1, house2, house3, house4, randomNumber, choice);
                }
                addtoHouse(house3, randomNumber);
                // if(houseEquals31(house3)){
                //     playerScore += 50;
                // }else 
                if(isHouseClosed(house3)){
                    System.out.println("House 3 closed.");
                }
                break;
            }
            case 4: 
            {
               if(isHouseClosed(house4)){
                    System.out.println("House 4 is closed. Please choose another house:");
                    choiceStage(house1, house2, house3, house4, randomNumber, choice);
                }
                addtoHouse(house4, randomNumber);
                // if(houseEquals31(house4)){
                //     playerScore += 50;
                // }else
                if(isHouseClosed(house4)){
                    System.out.println("House 4 closed.");
                }
                break;
            }
        }

    }

}



