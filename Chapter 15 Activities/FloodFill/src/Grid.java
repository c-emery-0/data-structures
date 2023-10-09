import java.util.Stack;

public class Grid
{
    private static final int SIZE = 10;
    private int[][] pixels = new int[SIZE][SIZE];
    private Stack<Pair> toColor = new Stack<>();
    private int fillCount = 1;

    public Grid() {
    }

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int y, int x)
    {
        if (y < 0 || y > 9 || x < 0 || x > 9)
            return;
        toColor.push(new Pair(y, x));

        Pair px = toColor.pop();
        if (pixels[px.getRow()][px.getColumn()] == 0) {
            pixels[px.getRow()][px.getColumn()] = fillCount;
            fillCount++;
            floodfill(y, x - 1);
            floodfill(y + 1, x);
            floodfill(y, x + 1);
            floodfill(y - 1, x);
        }

    }

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
