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
        if (sumOfHouse(house1) == 31){
            count++;
        }
        if (sumOfHouse(house2) == 31){
            count++;
        }
        if (sumOfHouse(house3) == 31){
            count++;
        }
        if (sumOfHouse(house4) == 31){
            count++;
        }
        if (count == 4){
            return false;
        }else{
            return true;
        }
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


    }
