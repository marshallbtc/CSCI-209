# Assignment 5: Making a Game

## Objectives

Using a game to explore ideas of inheritance, abstract classes,
dynamic dispatch, and final methods.

## Running the Code

To run the code, run `java Game`

To run the demo game, in the demoClasses directory, run `java -cp 
Game.jar Game`

## Design Decisions

We modified the Game to improve it from its original design.  Below, I
defend the design decisions.

### Making GamePiece Abstract

An abstract GamePiece class is a better design approach because all the pieces in the game are unique, with similar characteristics. For example, each piece has a move method, but they all behave differently. 
The GamePiece class should therefore be abstract because it provides the universal methods for each piece (saving time for both the readers and writers of the code), yet it also provides flexibility for child classes to function in their own unique ways.

### Calling an Abstract Method

The GamePiece class's move method is abstract because all the child classes move in different ways. Polymorphism allows us to call GamePiece's abstract move method on any child class -- the child class's corresponding move method is then called.

### Choices of Final Methods

I made the getXPos(), getYPos(), getImageWidth(), getCharacterWidth(), and draw() methods final because they are public and universal to all child classes.
The GamePiece constructor is not inherited by any child classes, so it can't be made final.
The move method should not be final because the child classes move differently.
The clone method is not final because the Human method has its own clone method.

### Adding a New Goblin

To add a new goblin, follow these steps:
1. Create a new class, call it Zerg.
2. The class should extend the GamePiece class.
3. The constructor should use the super() method to instantiate its parent GamePiece class with coordinates and graphics. The constructor should also assign an image to the object's instance, with a width and character width.
4. Create an overriding public void move() method with the same signature of its parent's move method. This is where you give the Zerg its zig-zag behavior.
5. In the Game class, create a private instance variable for the Zerg.
6. Now in the animate() method of the Game class, create the Zerg's image and add it to the array of pieces so that it will move as the game runs.