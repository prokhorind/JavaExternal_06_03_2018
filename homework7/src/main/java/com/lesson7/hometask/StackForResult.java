package com.lesson7.hometask;

/**
 * Created by kleba on 28.03.2018.
 */
public class StackForResult {
    private int maxSize;
    private double[] stackArray;
    private int top;
    public StackForResult(int size){
        maxSize = size;
        stackArray = new double[maxSize];
        top = -1;
    }

    public void push(double j) {
        stackArray[++top] = j;
    }

    public double pop() {
        return stackArray[top--];
    }

    public double peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize-1);
    }

    public int size(){
     return top+1;
    }

    public double peekN(int n){
        return stackArray[n];
    }

    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for(int j=0; j<size(); j++) {
            System.out.print( peekN(j) );
            System.out.print(' ');
        }
        System.out.println("");
    }
}
