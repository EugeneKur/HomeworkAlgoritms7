package ru.geekbrains.homework7;

import java.util.*;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, int travelTime) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = travelTime;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

/*
    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);

        for (String other : others) {
            result &= addEdge(startLabel, other);
        }

        return result;
    }

 */

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] != 0) {
                    System.out.print(" - " + adjMatrix[i][j]+ " - " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }


    @Override
    public void dfs(String startLabel, String endLabel, int pathsAmount) {
        int count = 0;
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }
        int endIndex = indexOf(endLabel);
        if (endIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + endLabel);
        }

        int stop = 0;

        while (stop < pathsAmount) {

            count = 0;
            stop++;
            System.out.print("Путь №" + stop + " : ");
            Stack<Vertex> stack = new Stack<>();
            Vertex vertex = vertexList.get(startIndex);
            visitedVertex(stack, vertex);
            vertex = getNearUnvisitedVertex(stack.peek());
            count = count + adjMatrix[startIndex][vertexList.indexOf(vertex)];
            if (vertex != null && !vertex.isNearAllVisited()) {
                vertex.setNearAllVisited(true);
                visitedVertex(stack, vertex);
            } else {
                stack.pop();
            }
            while (!stack.isEmpty()) {
                Vertex vertexLast = vertex;
                vertex = getNearUnvisitedVertex(stack.peek());
                if (vertex != null) {
                    visitedVertex(stack, vertex);
                    if (vertex.getLabel() == endLabel) {
                        resetVisitedVertex();
                        count = count + adjMatrix[vertexList.indexOf(vertexLast)][vertexList.indexOf(vertex)];
                        break;
                    }
                    count = count + adjMatrix[vertexList.indexOf(vertexLast)][vertexList.indexOf(vertex)];
                } else {
                    stack.pop();
                }
            }
            System.out.println(". Время в пути: " + count + " ч");

        }
        System.out.println();

    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] != 0 && !vertexList.get(i).isVisited() && !vertexList.get(i).isNearAllVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }
    private void resetVisitedVertex() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    private void visitedVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setVisited(true);
    }
/*
    private void visitedVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        queue.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitedVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitedVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
        System.out.println();
    }

 */
}
