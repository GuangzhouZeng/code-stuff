package DogDesign;

/**
 * Created by guangzhouzeng on 2/8/16.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Dog dog = new Dog(10, 10, 1);
        String s1 = "2FR3F2R";
        String s2 = "(2F(R2F)R(3F2R))";
        String s3 = "(F2R(2F(2RF)))";
        String s4 = "F2RF";
        dog.getPositionWithNum(s1);
        System.out.println();
        dog.getPositionWithParenthesis(s4);

        /*
        FFRFFFRR
        RRFFFFRR
         */
    }
}
