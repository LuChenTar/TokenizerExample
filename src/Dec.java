/**
 * Created by luchen on 5/05/15.
 */
public class Dec extends Expression{
    Expression subexp;

    public Dec(Expression exp) {
        subexp = exp;
    }


    @Override
    public int evaluate() {
        int sv = subexp.evaluate();
        return (sv== 0? sv: sv - 1);
    }

    @Override
    public String show() {
        return "dec(" + subexp.show() + ")";
    }
}
