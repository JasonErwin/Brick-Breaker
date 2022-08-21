# Brick Breaker  FX 
A classic retro game (Brick Breaker) would have to be maintained and extended with additonal features.

More information about Brick Breaker could be found here : https://heroconcept.com/a-brief-history-of-brick-breaker-video-games/

Original Source Code of the Game was obtained from : https://github.com/FilippoRanza/Brick_Destroy

## Key Refactoring Work
1. Change package name from test to BrickDestroyFX to make it more meaningful.
2. Separate Crack Class from Brick Class to follow Single Responsibility Principle.
3. Update methods in CementBrick and Crack to correctly represent the sepeartion of Crack Class from Brick Class.
4. Removed method overloading in Crack class by renaming one of the makeCrack() method to crack. 
5. Uses Enum to replace constant integer type for the  impactDirection in Brick Class and the Direction in Crack class.
6. Introduce polymorphism in Brick class in setImpact() method for non-crackable brick class.
7. Create a Level class from Wall class that contains the logic behind level generation.
8. Convert the entire game from Swing to JavaFX whiles maintaining game logic .

## Additions and Extensions
### Simple Add Ons:
1. Made Changes to the design of the main menu screen in terms of layout.
2. Added background images for Main Menu , Tutorial Menu and Pause Menu.
3. Changed the game icon.
4. Added an tutorial button that shows the controls of the game.

### High Score List:
1. Added the recording of high score functionalities by adopting file handling.

### Additonal playable levels:
1.  Added 2 extra level:
    - a) First Level : Contained 40 Bricks ,  'CEMENT' Bricks
    - b) Second Level : Contained 40 Brick ,  'STEEL' Bricks

### Exciting Features:
1. Implemented a score system in the GameLogic class.
     - Increase: Completing a level, type of brick affect scoring.

## Design Pattern
1. Create BrickFactory class to better represent switch statements in Levels Class. This is done to encourage abstraction.
2. Applied MVC patterns for GameBoard classes and all the scene in the game for easy regression tests at a later date.
3. Created a number of  models for controller.
4. Created a SceneManager class which handle the stage and scene transition in the entire game.

## More:
1. Added buttons for Info Screen and Leaderboard.
    - Tutorial Screen: Display the game controls.
    - LeaderBoard: Display the top 5 player score from a txt file.
2. Improved the view and design for all the FXML file using CSS, images and icons .

