package kata.tdd.christmas_lights_kata;

import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * phrase 'turn on' means: raise brightness one level
 * phrase 'turn off' means: lower brightness one level
 * phrase 'toggle' means: raise brightness two level
 */
public class BulbGrid {

    private int rowSize;
    private int columnSize;
    private int[][] grid;

    public BulbGrid(int columnSize, int rowSize) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        this.grid = new int[rowSize][columnSize];
    }

    public void turnOnSingleBulb(int columnIndex, int rowIndex) {
        grid[rowIndex][columnIndex] = grid[rowIndex][columnIndex] + 1;
    }

    public void turnOnBulbsByRange(int startColumn, int startRow, int endColumn, int endRow) {
        changeBrightLevelRange(startColumn, startRow, endColumn, endRow, brightLevel -> brightLevel + 1);
    }

    public void turnOffBulbsByRange(int startColumn, int startRow, int endColumn, int endRow) {
        changeBrightLevelRange(startColumn, startRow, endColumn, endRow, brightLevel -> brightLevel - 1);

    }

    public int getBrightLevel(int columnIndex, int rowIndex) {
        return grid[rowIndex][columnIndex];
    }


    public void toggleBulbsByRange(int startColumn, int startRow, int endColumn, int endRow) {
        changeBrightLevelRange(startColumn, startRow, endColumn, endRow, brightLevel -> brightLevel + 2);
    }

    private void changeBrightLevelRange(int startColumn, int startRow, int endColumn, int endRow, Function<Integer, Integer> brightLevelGetter) {
        IntStream.range(startRow, endRow + 1)
                .forEach(row -> IntStream.range(startColumn, endColumn + 1)
                        .forEach(column -> {
                            Integer brightLevelResult = brightLevelGetter.apply(grid[row][column]);
                            grid[row][column] = brightLevelResult <= 0 ? 0 : brightLevelResult;
                        }));
    }

    public int getTotalBrightLevel() {
        return IntStream.range(0, rowSize)
                .flatMap(row -> IntStream.range(0, columnSize)
                        .map(column -> grid[row][column]))
                .reduce(0, Integer::sum);
    }
}
