import java.util.EmptyStackException;

public class ArrayStack {

    private String[] stack;
    private int top;

    public ArrayStack(int capacity) {
        stack = new String[capacity];
    }

    public void push(String s) {
        if (top == stack.length) {
            // need to resize the backing array
            String[] newArray = new String[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }

        stack[top++] = s;
    }

    public String pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        String s = stack[--top];
        stack[top] = null;
        return s;
    }

    public String peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

}