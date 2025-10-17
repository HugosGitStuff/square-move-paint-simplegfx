package com.codeforall.bootcamp.canifetes.simplegfx;

import com.codeforall.simplegraphics.graphics.Canvas;

/*Notes:
"In the Main class, we instantiate a BackgroundGrid object and a Square object"
"We pass arguments to the constructors to initialize the objects"
"We invoke the draw() method on the grid object"
*/

public class Main {

    public static void main(String[] args) {

        // canvas size
        Canvas.setMaxX(510);
        Canvas.setMaxY(510);

        // defining grid properties
        int gridStartX = 10;
        int gridStartY = 10;
        int cellSize = 50;      // each cell in pixels
        int gridSize = 10;       // grid of cells

        // draw background grid
        BackgroundGrid grid = new BackgroundGrid(gridStartX, gridStartY, gridSize, cellSize);
        grid.draw();

        // create movable square starts at gridStart
        Square square = new Square(gridStartX, gridStartY, cellSize, gridSize);

        // keyboard controls
        MyKeyboard myKeyboard = new MyKeyboard();
        myKeyboard.setSquare(square);
        myKeyboard.setGrid(grid);
        myKeyboard.init();
    }
}
