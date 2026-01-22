import java.util.Arrays;
import java.util.Random;

public class FourHouses{
    public static void main(String[] args) {
        int house1[] = new int[31];
        int house2[] = new int[31]; 
        int house3[] = new int[31]; 
        int house4[] = new int[31];
    do{




    }while(allHousesClosed(house1, house2, house3, house4));

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
        if (sumOfHouse(house) >= 31){
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




    public static int sumOfHouse(int[] house){
        int sum = 0;
        for(int i = 0; i < house.length; i++){
            sum += house[i];
        }
        return sum;
    }
    public static int[] selectHouse(int choice){
        int choice = 0;
        switch(choice){
            case 1: return house1[];
            case 2: return house2[];
            case 3: return house3[];    
            case 4: return house4[];
                            
        }
        }

    }


