# BrickDestroy FX (Prepared by Loo Yang Shen Jason)

## Refactoring 

### Package (2%)
Change Package name from test to BrickDestroyFX to make it more meaningful.

### Basic Maintenance (6%)
Separate Crack from Brick Class to follow Single Responsibility Principle.

Update methods in CementBrick and Crack due to separation of Crack from Brick Class.

Separate methods that controls the generation of new levels into its own class known as Level. This is to follow the Single Responsibility Principle.

Create a brickFactory from the makeBrick method in Level. Factory design patterns provides loose coupling and high cohesion.

### MVC (10%)
Convert GameBoard into GameBoardModel , GameBoardView and GameBoardControl respectively. Benefits of converting GameBoard to MVC are ease to maintain due to components having low dependency on one another and adoption of MVC makes an application easier to understand.

Arrange BrickDestroyFX Application into MVC patterns. Reasoning is same as above.

### JUnit Tests (10%)
###GameBoardView Class 
getWall() Method.

###CementBrick Class 
repair() Method.

###Crack Class 
draw(), reset(), makeCrack() Methods.

###GameBoardModel Class 
isCheck(), getMessage(), setMessage(), getInput(), setInput(), isRun(), setRun(), setCheck() Methods.

###Level Class 
nextLevel(), hasLevel() Methods.

###Player Class 
moveLeft(), movRight(), stop(), getWidth(), getHeight(), getX(), getY(), moveTo() Methods.

###SteelBrick Class
impact() Method.

###Wall Class 
move(), getBrickCount(), resetBallCount(), isBallLost(),isDone(), isBallEnd(),getBallCount(), impactBorder(),setBallCount() , setBrickCount(), setBallXSpeed(), setBallYSpeed(),makeBall(),ballReset(),wallReset() Methods.

### Maven (2%)
Use Maven as it can add all dependencies required for the project automatically by reading pom file.

## Addition 

### Score (10%)
Implemented scoring into to game by destroying bricks. High Score can be seen in the Main Menu.

### Additional Playable Level(5%)
Added two levels made of all steel and cement brick respectively.

### Simple Additions(5%)
Added a relevant Main Menu Picture.

Added info button that shows how to play the game.

## JavaFX (10% Bonus)
Converted the whole BrickDestroy Application to JavaFX from JavaSwing. 

Covers Game Logic , Main menu , Pause Screen and Debug Panel.