import java.util.Arrays;
import java.util.Random;

public class FourHouses{
    public static void main(String[] args) {
        

    }

    public static int sumOfHouse(int[] house){
        int sum = 0;
        for(int i = 0; i < house.length; i++){
            sum += house[i];
        }
        return sum;
    }

}