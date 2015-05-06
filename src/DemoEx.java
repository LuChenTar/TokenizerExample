/**
 * Created by luchen on 6/05/15.
 */
public class DemoEx {

    public static void main(String[] args) throws ParseException {
        Expression e = new Dec(new Num(7));
        System.out.println(e.show() + "evals to " +e.evaluate());

    }
}
