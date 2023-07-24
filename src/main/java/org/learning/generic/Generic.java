package org.learning.generic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class Generic<E, F> implements Cloneable{
    private E first;
    private F second;
    public Generic(E first, F second) {
        this.first = first;
        this.second = second;
    }
    public E getFirst() {
        return first;
    }
    public void setFirst(E first) {
        this.first = first;
    }
    public F getSecond() {
        return second;
    }
    public void setSecond(F second) {
        this.second = second;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Generic<E, F> other = (Generic<E, F>) obj;

        return Objects.equals(this.first, other.first) && Objects.equals(this.second, other.getSecond());
    }
    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public Generic<E,F> clone() throws CloneNotSupportedException {
        //return (Generic<E,F>)super.clone();
        try {
            Generic<E, F> cloneObj = (Generic<E, F>) super.clone();
            cloneObj.first = deepClone(first);
            cloneObj.second = deepClone(second);
            return cloneObj;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // This should not happen since Pair implements Cloneable
        }
    }

    private <G> G deepClone(G object) {
        if (object instanceof Cloneable) {
            try {
                Method cloneMethod = object.getClass().getMethod("clone");
                return (G) cloneMethod.invoke(object);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                // Handle the exceptions as needed
            }
        }
        return object;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Generic<String, Integer> generic = new Generic<>("first", 1);
        Generic<String, Integer> generic2 = new Generic<>("first", 1);

        System.out.println(generic.equals(generic2));

        System.out.println(generic.hashCode());
        System.out.println(generic.hashCode());

        Generic<String, Integer> generic3 = generic.clone();
        generic3.setSecond(100);

        System.out.println(generic.getSecond());
        System.out.println(generic3.getSecond());

        System.out.println(generic.equals(generic3));

    }
}
