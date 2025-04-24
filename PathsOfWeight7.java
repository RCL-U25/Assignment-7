import java.util.HashSet;
import java.util.ArrayList;
public class PathsOfWeight7 {
    public static void findPathsOfLength7(Graph graph, Vertex start, Vertex end) {
        dfs(graph, start, end, 0.0, 7.0, new ArrayList<>(), new HashSet<>());
    }

    private static void dfs(Graph graph, Vertex current, Vertex end, double currentLength, double targetLength, ArrayList<Vertex> path, HashSet<Vertex> visited) {
        path.add(current);
        visited.add(current);

        if (current.equals(end) && currentLength == targetLength) {
            printPath(path);
        } else if (currentLength < targetLength) {
            for (Edge edge : graph.getEdgesFrom(current)) {
                Vertex next = edge.toVertex;
                if (!visited.contains(next)) {
                    dfs(graph, next, end, currentLength + edge.weight, targetLength, path, visited);
                }
            }
        }

        path.remove(path.size() - 1);
        visited.remove(current);
    }

    private static void printPath(ArrayList<Vertex> path) {
        path.forEach(vertex -> System.out.print(vertex.label + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        Vertex a = graph.addVertex("A");
        Vertex b = graph.addVertex("B");
        Vertex c = graph.addVertex("C");
        Vertex d = graph.addVertex("D");
        Vertex e = graph.addVertex("E");
        Vertex f = graph.addVertex("F");
        Vertex g = graph.addVertex("G");

        graph.addDirectedEdge(a, b, 2.0);
        graph.addDirectedEdge(b, c, 1.0);
        graph.addDirectedEdge(c, d, 1.0);
        graph.addDirectedEdge(d, e, 1.0);
        graph.addDirectedEdge(e, f, 1.0);
        graph.addDirectedEdge(f, g, 1.0);
        graph.addDirectedEdge(a, d, 3.0);
        graph.addDirectedEdge(d, g, 4.0);

        System.out.println("Paths from A to G with total weight 7:");
        findPathsOfLength7(graph, a, g);
    }
    }



