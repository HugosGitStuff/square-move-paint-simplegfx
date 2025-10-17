package com.codeforall.bootcamp.canifetes.simplegfx;

import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Rectangle;

/* Notes:
"We use a two-dimensional array to store Rectangle objects representing each cell"
"The draw method uses nested for loops to iterate through rows and columns"
"We calculate each cell's position and store it in the array"
*/

public class BackgroundGrid {

    private int cellSize; // cell size
    private int gridSize; // cell quantity
    private int startX;  // grid start on x 10
    private int startY;  // grid start on y 10
    private Rectangle[][] gridArray; // array of arrays to store cells


    // constructor to create grid
    public BackgroundGrid(int startX, int startY, int gridSize, int cellSize) {
        this.startX = startX;
        this.startY = startY;
        this.gridSize = gridSize;
        this.cellSize = cellSize;
        this.gridArray = new Rectangle[gridSize][gridSize];
    }

    // method draw entire grid
    public void draw() {
        // out loop through each row
        for (int row = 0; row < gridSize; row++) {

            // in loop through each column in this row
            for (int col = 0; col < gridSize; col++) {

                // calculate position for this cell
                int x = startX + (col * cellSize);  // Move right for each column
                int y = startY + (row * cellSize);  // Move down for each row

                // create a rectangle for this cell
                Rectangle cell = new Rectangle(x, y, cellSize, cellSize);

                // set grid line color black
                cell.setColor(Color.BLACK);

                // draw cells
                cell.draw();

                // store cell in array
                gridArray[row][col] = cell;
            }
        }
    }

    // paint cell at square position
    public void paintCell(int squareX, int squareY) {
        // convert pixel position to grid coordinates
        int col = (squareX - startX) / cellSize;  // which column (subtract grid start, divide by cell size)
        int row = (squareY - startY) / cellSize;  // which row (subtract grid start, divide by cell size)

        // fill the cell with color (already set to BLACK in draw method)
        gridArray[row][col].fill();
    }

    // clear cell at square position
    public void clearCell(int squareX, int squareY) {
        // convert pixel position to grid coordinates
        int col = (squareX - startX) / cellSize;  // which column
        int row = (squareY - startY) / cellSize;  // which row

        // draw only outline (clears the fill, shows black border)
        gridArray[row][col].draw();
    }

    // clear all painted cells
    public void clearAllCells() {
        // loop through all rows
        for (int row = 0; row < gridSize; row++) {
            // loop through all columns
            for (int col = 0; col < gridSize; col++) {
                // draw only outline for each cell (clears all fills)
                gridArray[row][col].draw();
            }
        }
    }
}
