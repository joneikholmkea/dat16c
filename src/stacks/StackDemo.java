package stacks;

public class StackDemo {

    public static void main(String[] args) {
       new StackDemo();
    }

    public StackDemo(){
        String exp = "234+*";
        MyStack<Integer> stk = new MyStack<>();
        for (int i = 0; i < exp.length(); i++) {
            String token = exp.charAt(i)+"";
            switch (token){
                case "+" : stk.push(stk.pop() + stk.pop());
                break;
                case "*" : stk.push(stk.pop() * stk.pop());
                break;
                default: stk.push(Integer.parseInt(token));
            }
        }
            System.out.println("resultat: " + stk.pop());


    }

}
