





Program is run:

* (Press enter to start the game?? )
* Two players **Black \& White** (white plays first) and two variables (ints) for storing score *eg: scoreWhite \& scoreBlack*  

(int scoreWhite = 0; int scoreBlack = 0;)

* 4 arrays Home1\[], Home2\[], Home3\[], Home4\[]
* Random number between 1-15 at the start of every round  ------------> (**The code must run in circles until stopped)**
* Player is prompted to choose
* User choses a number between 1-4
* Random number N is put inside the array I (from previous step) --------> Input validity???





* The sum of elements is checked every round for sum<31 ------> **Method** which is called(method for this)  **OR** int sumHome(i) = Arrays.stream(*arrayName).*sum() from **java.util.Arrays**
* Next round begins \& nenw round starts for the other player
* If sumHome(I) = 31, the sumHome(i) becomes 0 and the player gains 50 points ( score*OfPlayerOnRound += 50; )*
* A Homei with sumHome(i) > 31, the Homei can not be changed any more, is **closed for the rest of the game**





* \##Idealy player should not be allowed to close a House if they have another option, i.e. another House where 31 is not exceeded.##





* **Game runs until all Homes is closed.** After it Prints ScoreWhite and ScoreBlack. The player with the most score wins!

# Notes for 2d array:

1 create  one int houses[][] = new int[4][31];

2 diplay for both players should only send houses (not 1,2,3,4)

3 allHousesClosed should only send houses (not 1,2,3,4)

4 all housesClosed should do a for to check for all arrays 

5 displayMenu should do a for to call displayHouse(houses[i], i + 1)  and hous1,house2,h... should be replaced with the 2d array houses

6 in choiceStage when processHouseChoice is called swap getHouseByChoice() with houses[choice - 1]

7 DELETe get house by choice

8 processHouseChoice house1,2,3,4 in the parameters should be replaced with int houses[][] and return it to choices if illegal move

9 in cannotCloseHouse replace the four if statements with a for loop






