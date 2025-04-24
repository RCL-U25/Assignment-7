public class DrawGraph
{
    public static void printAdjTable(Object[][] input)
    {
        int n = input.length;
        String[] labels = new String[n];
        int[] steps = new int[n];

        for (int i = 0; i < n; i++) {
            labels[i] = (String) input[i][0];
            steps[i] = (Integer) input[i][1];
        }

        int[][] adjMatrix = new int[n][n];


        for (int i = 0; i < n; i++) {
            int step = steps[i];
            int right = (i + step) % n;
            int left = (i - step + n) % n;

            adjMatrix[i][right] = 1;
            adjMatrix[i][left] = 1;
        }

        System.out.print("   ");
        for (String label : labels) {
            System.out.print(label + " ");
        }
        System.out.println();


        for (int i = 0; i < n; i++) {
            System.out.print(labels[i] + ": ");
            for (int j = 0; j < n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Object[][] array = {{"I", 2}, {"A", 5} , {"E", 4} , {"F",2} , {"T", 2},{"S", 3}};


        printAdjTable(array);
    }
}
