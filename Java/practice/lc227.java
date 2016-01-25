public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num=0;
        char sign='+';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+c-'0';
            }
            if(c=='+'||c=='-'||c=='*'||c=='/'||i==s.length()-1){
                if(sign=='+'){
                    stack.push(num);
                    sign=c;num=0;
                }else if(sign=='-'){
                    stack.push(-num);
                    sign=c;num=0;
                }else if(sign=='*'){
                    stack.push(stack.pop()*num);
                    sign=c;num=0;
                }else if(sign=='/'){
                    stack.push(stack.pop()/num);
                    sign=c;num=0;
                }
            }
        }
        int res=0;
        /*while(!stack.isEmpty()){
            res+=stack.pop();
        }*/
        for(int i: stack) res+=i;
        return res;
    }
}