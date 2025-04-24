public class directedGraphChecker
{

        public static void isDirected(int[][] matrix)
        {
            boolean isDirected = false;
            for (int i = 0; i < matrix.length; i++)
            {
                for (int j = 0; j < matrix.length; j++)
                {
                    if (matrix[i][j] != matrix[j][i])
                    {
                        isDirected = true;
                        break;
                    }
                }
                if (isDirected)
                    break;
            }
            if (!isDirected)
            {
                System.out.println("Graph is undirected");
            }else{
                System.out.println("Graph is directed");
            }
        }
        public static void main(String[] args)
        {
            int[][] matrix = {{0,1,0},
                              {1,0,1},
                              {0,0,0}};
            int[][] matrix2 = {
                                {1,0,0},
                                {0,1,0},
                                {0,0,0}};
            isDirected(matrix);
            isDirected(matrix2);

        }
}
