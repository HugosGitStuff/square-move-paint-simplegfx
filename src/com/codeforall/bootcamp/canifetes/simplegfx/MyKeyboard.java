package com.codeforall.bootcamp.canifetes.simplegfx;

import com.codeforall.simplegraphics.keyboard.Keyboard;
import com.codeforall.simplegraphics.keyboard.KeyboardEvent;
import com.codeforall.simplegraphics.keyboard.KeyboardEventType;
import com.codeforall.simplegraphics.keyboard.KeyboardHandler;

/*Notes:
"This class implements the KeyboardHandler interface"
"We override the keyPressed method to handle keyboard events"
"We use conditional statements to determine which key was pressed"
"The setter methods let us connect the keyboard to the square and grid,
so the keyboard knows which objects to control."
*/

public class MyKeyboard implements KeyboardHandler {
    
    private Keyboard keyboard;
    private Square square;
    private BackgroundGrid grid;
    
    public void init() {
        
        keyboard = new Keyboard(this);
        
        //set up the event
        KeyboardEvent goRight = new KeyboardEvent();
        KeyboardEvent goLeft = new KeyboardEvent();
        KeyboardEvent goUp = new KeyboardEvent();
        KeyboardEvent goDown = new KeyboardEvent();

        // paint/clear events
        KeyboardEvent paintEvent = new KeyboardEvent();
        KeyboardEvent clearEvent = new KeyboardEvent();
        KeyboardEvent clearAllEvent = new KeyboardEvent();

        //set event key
        //right
        goRight.setKey(KeyboardEvent.KEY_RIGHT);
        goRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        // left
        goLeft.setKey(KeyboardEvent.KEY_LEFT);
        goLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        // up
        goUp.setKey(KeyboardEvent.KEY_UP);
        goUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        // down
        goDown.setKey(KeyboardEvent.KEY_DOWN);
        goDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        // paint/clear keys
        paintEvent.setKey(KeyboardEvent.KEY_SPACE);
        paintEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        clearEvent.setKey(KeyboardEvent.KEY_SHIFT);
        clearEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        clearAllEvent.setKey(KeyboardEvent.KEY_ESC);
        clearAllEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        
        //add keyboard events for moving
        keyboard.addEventListener(goRight);
        keyboard.addEventListener(goLeft);
        keyboard.addEventListener(goUp);
        keyboard.addEventListener(goDown);

        // add keyboard events for drawing
        keyboard.addEventListener(paintEvent);
        keyboard.addEventListener(clearEvent);
        keyboard.addEventListener(clearAllEvent);
    }
    
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            // System.out.println("go right");
            square.moveRight();
        } else if(keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            // System.out.println("go left");
            square.moveLeft();
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            // System.out.println("go up");
            square.moveUp();
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            // System.out.println("go down");
            square.moveDown();
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) { // paint/clear
            grid.paintCell(square.getX(), square.getY());
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_SHIFT) {
            grid.clearCell(square.getX(), square.getY());
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_ESC) {
            grid.clearAllCells();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        // this method is required by KeyboardHandler interface
        // we don't need to do anything when keys are released
        // so we leave it empty
    }

    // setter method to connect the square to the keyboard
    public void setSquare(Square square) {
        this.square = square;  // store the square reference so we can move it
    }

    // setter method to connect the grid to the keyboard
    public void setGrid(BackgroundGrid grid) {
        this.grid = grid;  // store the grid reference so we can paint/clear cells
    }
}
