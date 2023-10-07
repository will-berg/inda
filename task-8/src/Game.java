/**
 *  This class is the main class of the afterlife application.
 *  It is a very simple, text based adventure game.  Users
 *  can walk around some scenery.
 *
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 *
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 *
 * @author  William Berg
 * @version 2019.11.07
 */

public class Game {
    private Parser parser;
    private Room currentRoom;
    private int counter; // A counter that keeps track of the number of times you have entered a room

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {
        Room outside, lobby, WC, WC2, nave, heaven, hell, trapdoor;

        // create the rooms
        outside = new Room("outside of a dark church in a rotten state");
        lobby = new Room("in the church lobby and there is evil afoot");
        nave = new Room("in the nave, and you see Jesus bleeding");
        heaven = new Room("in heaven");
        hell = new Room("in hell");
        WC = new Room("in a women's bathroom and you hear a woman crying");
        WC2 = new Room("in a men's bathroom and the light is flickering");
        // Trapdoor. No exit doors.
        trapdoor = new Room("trapped between heaven and hell, bummer");

        // initialise room exits
        outside.setExit("north", lobby);

        lobby.setExit("west", WC);
        lobby.setExit("east", WC2);
        lobby.setExit("north", nave);
        lobby.setExit("south", outside);

        WC.setExit("east", lobby);
        WC2.setExit("west", lobby);

        nave.setExit("northwest", heaven);
        nave.setExit("northeast", hell);
        nave.setExit("north", trapdoor);
        nave.setExit("south", lobby);

        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        // Conditions for when the program should be running
        while ((counter != 5) && (currentRoom.getShortDescription() != ("in heaven") && (currentRoom.getShortDescription() != ("in hell")))) {
            Command command = parser.getCommand();
            processCommand(command);
        }
        System.out.println("Thank you for playing. Good bye.");
    }

    /**
     * look around the room.
     */
    private void look() {
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the afterlife");
        System.out.println("This is a new, incredibly fun adventure game.");
        System.out.println("You have died and must navigate your way to heaven.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("look")) {
            look();
        } else if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("go")) {
            goRoom(command);
        } else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the
     * command words.
     */
    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around the church.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /**
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
      	}
        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            // Increment the counter after succsesful room switch
            counter++;
            // Maximum number of moves = 4
            if (counter > 4) {
				System.out.println("Out of time!");
			}
			// Print win or loss message if you reach heaven or hell
			if (currentRoom.getShortDescription() == "in heaven") {
					System.out.println("Whoopty doo, you won");
			}
			if (currentRoom.getShortDescription() == "in hell") {
					System.out.println("Bummer, you lost");
			}
		}
    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }
}
