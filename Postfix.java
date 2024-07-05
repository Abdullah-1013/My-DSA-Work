public class Postfix {
    static class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        private Node top;

        public Stack() {
            this.top = null;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public void push(char data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
        }

        public char pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            char data = top.data;
            top = top.next;
            return data;
        }

        public char top() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return top.data;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node current = top;
            while (current != null) {
                sb.append(current.data).append(" ");
                current = current.next;
            }
            return sb.toString();
        }
    }

    public static String infixToPostfix(String input) {
        StringBuilder postfix = new StringBuilder();
        Stack stack = new Stack();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.top() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Remove the opening parenthesis from the stack
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.top())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    public static float postfixEvaluation(String postfix) {
        Stack stack = new Stack();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(c);
            } else {
                float operand2 = Float.parseFloat(String.valueOf(stack.pop()));
                float operand1 = Float.parseFloat(String.valueOf(stack.pop()));

                float result = switch (c) {
                    case '+' -> operand1 + operand2;
                    case '-' -> operand1 - operand2;
                    case '*' -> operand1 * operand2;
                    case '/' -> operand1 / operand2;
                    default -> throw new IllegalArgumentException("Invalid operator: " + c);
                };
                stack.push(String.valueOf(result).charAt(0));
            }
        }

        return Float.parseFloat(String.valueOf(stack.pop()));
    }

    public static void main(String[] args) {
        String infixExpression = "3+4*2/(1-5)^2^3";
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);

        float result = postfixEvaluation(postfixExpression);
        System.out.println("Result: " + result);
    }
}
