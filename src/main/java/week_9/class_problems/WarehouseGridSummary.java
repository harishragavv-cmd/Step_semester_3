package week_9.class_problems;

public class WarehouseGridSummary {

    public static class Summary {
        private final long totalItems;
        private final int maxRow;
        private final int maxCol;

        private Summary(long totalItems, int maxRow, int maxCol) {
            this.totalItems = totalItems;
            this.maxRow = maxRow;
            this.maxCol = maxCol;
        }

        public long getTotalItems() { return totalItems; }
        public int getMaxRow() { return maxRow; }
        public int getMaxCol() { return maxCol; }

        @Override
        public String toString() {
            return "(" + totalItems + ", (" + maxRow + ", " + maxCol + "))";
        }
    }

    public static Summary warehouseSummary(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            throw new IllegalArgumentException("Grid must contain at least one cell");
        }

        int columns = grid[0].length;
        long total = 0;
        int maxValue = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int row = 0; row < grid.length; row++) {
            if (grid[row] == null || grid[row].length != columns) {
                throw new IllegalArgumentException("Grid must be rectangular");
            }

            for (int col = 0; col < columns; col++) {
                int value = grid[row][col];
                if (value < 0) {
                    throw new IllegalArgumentException("Grid values cannot be negative");
                }

                total += value;
                // Strictly greater preserves the first maximum in row-major order.
                if (value > maxValue) {
                    maxValue = value;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }

        return new Summary(total, maxRow, maxCol);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {4, 9, 2},
                {7, 1, 6},
                {3, 12, 5}
        };
        System.out.println(warehouseSummary(grid));
    }
}