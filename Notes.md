





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



