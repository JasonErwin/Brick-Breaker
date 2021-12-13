# <ins>BrickDestroy FX (Prepared by Loo Yang Shen Jason)</ins>

## <ins>Refactoring </ins>

### <ins>Package (2%)</ins>
Change Package name from test to BrickDestroyFX to make it more meaningful.

### <ins>Basic Maintenance (6%)</ins>
Separate Crack from Brick Class to follow Single Responsibility Principle.

Update methods in CementBrick and Crack due to separation of Crack from Brick Class.

Separate methods that controls the generation of new levels into its own class known as Level. This is to follow the Single Responsibility Principle.

Create a brickFactory from the makeBrick method in Level. Factory design patterns provides loose coupling and high cohesion.

Split GameBoard into GameBoardController, GameBoardView and GameBoardModel Respectively.

### <ins>MVC (10%)</ins>
Convert GameBoard into GameBoardModel , GameBoardView and GameBoardControl respectively. Benefits of converting GameBoard to MVC are ease to maintain due to components having low dependency on one another and adoption of MVC makes an application easier to understand.

Arrange BrickDestroyFX Application into MVC patterns. Reasoning is same as above.

### <ins>JUnit Tests (10%) </ins>
<ins>GameBoardView Class</ins>

getWall() Method.

<ins>CementBrick Class</ins>

repair() Method.

<ins>Crack Class</ins>

draw(), reset(), makeCrack() Methods.

<ins>GameBoardModel Class</ins>

isCheck(), getMessage(), setMessage(), getInput(), setInput(), isRun(), setRun(), setCheck() Methods.

<ins>Level Class</ins>

nextLevel(), hasLevel() Methods.

<ins>Player Class</ins>

moveLeft(), movRight(), stop(), getWidth(), getHeight(), getX(), getY(), moveTo() Methods.

<ins>SteelBrick Class</ins>

impact() Method.

<ins>Wall Class</ins>

move(), getBrickCount(), resetBallCount(), isBallLost(),isDone(), isBallEnd(),getBallCount(), impactBorder(),setBallCount() , setBrickCount(), setBallXSpeed(), setBallYSpeed(),makeBall(),ballReset(),wallReset() Methods.

### <ins>Maven (2%)</ins>
Use Maven as it can add all dependencies required for the project automatically by reading pom file.

Created Jar Files for BrickDestroy Application. (**Only Used shaded.jar version**)

## Addition 

### <ins>Score (10%)</ins>
Implemented scoring into to game by destroying bricks. 

Added a button to show high score in main menu by reading a prepared txt file.

User is able to press "R" on the keyboard to have a High Score Pop Up to appear in game.

### <ins>Additional Playable Level(5%)</ins>
Added two levels made of all steel and cement brick respectively.

### <ins>Simple Additions(5%)</ins>
Added a relevant Main Menu Picture.

Added info button that shows how to play the game.

## <ins>JavaFX (10% Bonus)</ins>
Converted the whole BrickDestroy Application to JavaFX from JavaSwing. 

Covers Game Logic , Main menu , Pause Screen and Debug Panel.