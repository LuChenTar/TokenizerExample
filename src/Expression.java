/**
 * Created by luchen on 5/05/15.
 */
public abstract class Expression {

    public abstract int evaluate();
    public abstract String show();

    public static Expression parse(Tokenizer tok) throws ParseException {
        Object curr = tok.current();
        if(curr.equals("dec")) {
            tok.next();
            if (!tok.current().equals("(")) throw new ParseException();
            tok.next();
            Expression subexp = parse(tok);
            if(!tok.current().equals(")")) throw new ParseException();
            return new Dec(subexp);
        }else if(curr.equals("inc")) {
            tok.next();
            if (!tok.current().equals("(")) throw new ParseException();
            tok.next();
            Expression subexp = parse(tok);
            if(!tok.current().equals(")")) throw new ParseException();
            return new Inc(subexp);
        }else if(curr instanceof  Integer) {
            int v = (Integer) curr;
            tok.next();
            return new Num(v);
        }
        return null;
    }
}
