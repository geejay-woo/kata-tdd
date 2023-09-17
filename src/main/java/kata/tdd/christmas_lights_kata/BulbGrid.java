package kata.tdd.christmas_lights_kata;

import java.util.stream.IntStream;

public class BulbGrid {

    private int rowSize;
    private int columnSize;
    private boolean[][] grid;

    public BulbGrid(int columnSize, int rowSize) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        this.grid = new boolean[rowSize][columnSize];
    }

    public void turnOn(int startColumn, int startRow, int endColumn, int endRow) {
        IntStream.range(startRow, endRow + 1)
                .forEach(row -> IntStream.range(startColumn, endColumn + 1)
                        .forEach(column -> grid[row][column] = true));
    }


    public boolean isTurnOn(int columnIndex, int rowIndex) {
        return grid[rowIndex][columnIndex];
    }
}
