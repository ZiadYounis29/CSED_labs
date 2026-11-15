package Lab1;

interface ICalculator {
    /**
     * Multiplies given two numbers
     * @param x first number
     * @param y second number
     * @return the product of the two numbers
     */
    int multiply(int x, int y);
    /**
     * Computes the bitwise and of the two numbers
     * @param x first number
     * @param y second number
     * @return the bitwise AND result
     */
    int bitwiseAnd(int x, int y);
}
