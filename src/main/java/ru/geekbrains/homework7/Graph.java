package ru.geekbrains.homework7;

public interface Graph {

    void addVertex(String label);

    //    boolean addEdge(String startLabel, String secondLabel, String... others);
    boolean addEdge(String startLabel, String secondLabel, int travelTime);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel, String endLabel, int pathsAmount);

    /**
     * англ. breadth-first search, BFS
     */
//    void bfs(String startLabel);

}
