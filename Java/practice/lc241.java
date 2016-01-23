public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        //f(1):1, f(2):1, f(3):f(1)*f(2)+f(2)*f(1)=2, f(4)=f(1)*f(3)+f(2)*f(2)+f(3)*f(1)=5; ...
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(c=='+'||c=='-'||c=='*'){
                List<Integer> lefts = diffWaysToCompute(input.substring(0,i));
                List<Integer> rights = diffWaysToCompute(input.substring(i+1));
                for(int left:lefts){
                    for(int right:rights){
                        if(c=='+') res.add(left+right);
                        if(c=='-') res.add(left-right);
                        if(c=='*') res.add(left*right);
                    }
                }
            }
        }
        if(res.size()==0) res.add(Integer.parseInt(input));
        return res;
    }
}