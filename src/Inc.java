/**
 * Created by luchen on 5/05/15.
 */
public class Inc extends Expression {
    Expression exp;

    public Inc(Expression exp) {
        this.exp = exp;
    }

    @Override
    public int evaluate() {
        return 1+exp.evaluate();
    }

    @Override
    public String show() {
        return "inc(" + exp.show()+")";
    }
}
