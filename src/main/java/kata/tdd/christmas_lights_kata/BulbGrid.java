package kata.tdd.christmas_lights_kata;

import java.util.function.Function;
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

    public void turnOnSingleBulb(int columnIndex, int rowIndex) {
        grid[rowIndex][columnIndex] = true;
    }

    public void turnOnBulbsByRange(int startColumn, int startRow, int endColumn, int endRow) {
        changeStatus(startColumn, startRow, endColumn, endRow, status -> true);
    }

    public void turnOffBulbsByRange(int startColumn, int startRow, int endColumn, int endRow) {
        changeStatus(startColumn, startRow, endColumn, endRow, status -> false);

    }

    public boolean isTurnOn(int columnIndex, int rowIndex) {
        return grid[rowIndex][columnIndex];
    }

    public boolean isTurnOff(int columnIndex, int rowIndex) {
        return !isTurnOn(columnIndex, rowIndex);
    }

    public void toggleBulbsByRange(int startColumn, int startRow, int endColumn, int endRow) {
        changeStatus(startColumn, startRow, endColumn, endRow, status-> !status);
    }

    private void changeStatus(int startColumn, int startRow, int endColumn, int endRow, Function<Boolean, Boolean> statusGetter) {
        IntStream.range(startRow, endRow + 1)
                .forEach(row -> IntStream.range(startColumn, endColumn + 1)
                        .forEach(column -> grid[row][column] = statusGetter.apply(grid[row][column])));
    }


}
