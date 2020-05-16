package edu.umb.cs.cs681.hw01;
@FunctionalInterface
public interface Observer {
    void update(Observable o, Object obj);
}
