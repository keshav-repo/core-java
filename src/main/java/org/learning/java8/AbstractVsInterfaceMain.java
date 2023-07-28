package org.learning.java8;

abstract class AbstractShape {
    // Concrete method

    private String clor;

    public void display() {
        System.out.println("Displaying shape.");
    }

    // Abstract method to be implemented by subclasses
    public abstract void draw();
}

// Concrete class extending the abstract class
class Circle extends AbstractShape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle.");
    }
}

// Interface example
interface Drawable {
    // Abstract method
    void draw();

    // Default method with concrete behavior
    default void display() {
        System.out.println("Displaying shape.");
    }
}

// Concrete class implementing the interface
class Square implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a square.");
    }
}


public class AbstractVsInterfaceMain {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.display();
        circle.draw();

        Square square = new Square();
        square.display();
        square.draw();




        AbstractShape abstractShape = new AbstractShape() {
            @Override
            public void draw() {
                System.out.println("something drawing");
            }
        };
        abstractShape.display();
        abstractShape.draw();
    }
}

