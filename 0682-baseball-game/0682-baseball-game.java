import java.util.ArrayDeque;

class Solution {
    public int calPoints(String[] operations) {
        
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for(String op : operations){

            switch(op){
                case "C":
                    stack.pop();
                    break;

                case "D":
                    stack.push(stack.peek() * 2);
                    break;

                case "+":
                    int first = stack.pop();
                    int second = stack.peek();
                    stack.push(first);
                    stack.push(first + second);
                    break;
                
                default:
                    stack.push(Integer.parseInt(op));
            }

        }

        int sum = 0;

        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        return sum;

    }
}