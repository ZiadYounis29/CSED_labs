package Lab1;

public class Calculator implements ICalculator {
    @Override
    public int multiply(int x,int y){
        return x*y;
    }
    @Override
    public int bitwiseAnd(int x, int y){
        return x&y;
    }
}
