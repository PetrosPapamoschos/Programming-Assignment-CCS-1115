import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FourHouses{
    public static void main(String[] args) {
        int house1[] = new int[31];
        int house2[] = new int[31]; 
        int house3[] = new int[31]; 
        int house4[] = new int[31];

        int randomNumber = randomNumberGenerator(1, 15);
        Scanner scan = new Scanner(System.in);
        int choice = 0;
    do{
        displayMenu(house1, house2, house3, house4, randomNumber);        
        switch(choice){
            case 1: 
            {
                addtoHouse(house1, randomNumber);
                break;
            }
            case 2: 
            {
                addtoHouse(house2, randomNumber);
                break;
            }
            case 3: 
            {
                addtoHouse(house3, randomNumber);
                break;
            }
            case 4: 
            {
                addtoHouse(house4, randomNumber);
                break;
            }
        }


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

    }
