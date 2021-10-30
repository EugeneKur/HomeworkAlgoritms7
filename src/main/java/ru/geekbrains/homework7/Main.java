package ru.geekbrains.homework7;

public class Main {
    public static void main(String[] args) {
        testGraph();
//        testDfs();
//        testBfs();
    }

    private static void testGraph() {
        Graph graph = new GraphImpl(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва", "Тула", 5);
        graph.addEdge("Москва", "Рязань", 3);
        graph.addEdge("Москва", "Калуга", 4);
        graph.addEdge("Тула", "Липецк", 6);
        graph.addEdge("Липецк", "Воронеж", 7);
        graph.addEdge("Рязань", "Тамбов", 5);
        graph.addEdge("Тамбов", "Саратов", 2);
        graph.addEdge("Саратов", "Воронеж", 1);
        graph.addEdge("Калуга", "Орел", 9);
        graph.addEdge("Орел", "Курск", 5);
        graph.addEdge("Курск", "Воронеж", 7);

        System.out.println("Size of graph is " + graph.getSize());
        graph.display();

        graph.dfs("Москва", "Воронеж", 3);
    }
/*
    private static void testDfs() {
        Graph graph = new GraphImpl(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("D", "F");
        graph.addEdge("F", "G");

        graph.dfs("A");
    }

 */
/*
    private static void testBfs() {
        Graph graph = new GraphImpl(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdge("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("E", "H");
        graph.addEdge("C", "F");
        graph.addEdge("D", "G");

        graph.bfs("A");
    }

 */
}
