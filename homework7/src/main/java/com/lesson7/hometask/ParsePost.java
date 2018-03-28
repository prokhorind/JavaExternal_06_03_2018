package com.lesson7.hometask;

/**
 * Created by kleba on 28.03.2018.
 */
public class ParsePost {
    private StackForResult theStack;
    private String input;

    public ParsePost(String s){
        this.input = s;
    }
    public double doParse() {
        theStack = new StackForResult(20);
        char ch;
        int j;
        double num1, num2, interAns;
        for(j=0; j<input.length(); j++) {
            ch = input.charAt(j);
            if(ch >= '0' && ch <= '9') {
                theStack.push((double) (ch - '0'));
            }else if(ch=='s'||ch=='c'||ch=='t'||ch=='g'){
                switch (ch){
                    case 's':
                        interAns=  Math.sin(theStack.pop());
                        break;
                    case 'c':
                        interAns=  Math.cos(theStack.pop());
                        break;
                    case 't':
                        interAns= Math.tan(theStack.pop());
                        break;
                    case 'g':
                        interAns= 1.0/ Math.tan(theStack.pop());
                        break;
                    default:
                        interAns = 0;
                        break;
                }
                theStack.push(interAns);
            } else{
                num2 = theStack.pop();
                num1 = theStack.pop();
                switch(ch){
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                }
                theStack.push(interAns);
            }
        }
        interAns = theStack.pop();
        return interAns;
    }
}

