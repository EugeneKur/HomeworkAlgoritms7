package ru.geekbrains.homework7;

import java.util.Objects;

public class Vertex {
    private final String label;
    private boolean isVisited;
    private boolean nearAllVisited;

    public boolean isNearAllVisited() {
        return nearAllVisited;
    }

    public void setNearAllVisited(boolean nearAllVisited) {
        this.nearAllVisited = nearAllVisited;
    }


    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return "Vertex{" + "label='" + label + '\'' + '}';
    }
}
