/**
 * Created by luchen on 5/05/15.
 */
public class Num extends Expression {
    int value;

    public Num(int v) {
        value = v;
    }

    @Override
    public int evaluate() {
        return value;
    }

    @Override
    public String show() {
        return "" + value ;
    }
}
