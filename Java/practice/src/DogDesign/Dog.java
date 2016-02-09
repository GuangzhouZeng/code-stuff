package DogDesign;

import java.util.Stack;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by guangzhouzeng on 2/8/16.
 */
public class Dog {
    int[] position;
    int direction; //0 - north, 1 - east, 2 - south, 3 - west

    Dog(int x, int y, int direction){
        position = new int[2];
        position[0] = x;
        position[1] = y;
        this.direction = direction;
    }

    public void turnRight(){
        direction = ++direction % 4;
    }

    public void moveOneStep(){
        switch(direction){
            case 0: position[0]--;break;
            case 1: position[1]++;break;
            case 2: position[0]++;break;
            case 3: position[1]--;break;
        }
    }
    public int[] getPosition(String str) throws Exception { //input: FFFRRF
        for (char c : str.toCharArray()) {
            if (c == 'F') {
                moveOneStep();
                System.out.print('F');
            } else if (c == 'R') {
                turnRight();
                System.out.print('R');
            } else throw new Exception("wrong input in getPosition");
        }
        return new int[]{position[0], position[1]};
    }

    public int[] getPositionWithNum(String str) throws Exception{ //input: 3F2RF => FFFRRF
        int count = 1;
        for(char c: str.toCharArray()){
            if(Character.isDigit(c)){
                count = c - '0';
            }else if(c == 'F' || c == 'R'){
                while(count -- > 0){
                    getPosition(String.valueOf(c));
                }
                count = 1;
            }else throw new Exception("wrong input in getPositionWithNum");
        }
        return new int[]{position[0], position[1]};
    }

    public int[] getPositionWithParenthesis(String str) throws Exception{ //input: (3FR(R(2F2R)))
        Stack<Character> stack = new Stack<>();
        for(char c: str.toCharArray()){
            if(Character.isDigit(c) || c == 'F' || c =='R' || c == '('){
                stack.push(c);
            }else if(c == ')'){
                StringBuilder buffer = new StringBuilder();
                while(stack.peek() != '('){
                    buffer.insert(0, stack.pop());
                }
                stack.pop(); //pop the '('
                getPositionWithNum(buffer.toString());
            }else throw new Exception("Wrong input in getPositionWithParenthesis ");
        }
        StringBuilder buffer = new StringBuilder();
        while(!stack.isEmpty()){
            buffer.insert(0, stack.pop());
        }
        getPositionWithNum(buffer.toString());
        return new int[]{position[0], position[1]};
    }
}
