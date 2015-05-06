/**
 * Created by luchen on 5/05/15.
 */
public abstract class Tokenizer {

    abstract boolean hasNext();

    abstract Object current();

    abstract void next();

    public void parse(Object o) throws ParseException {
        if (current() == null || !current().equals(o))
            throw new ParseException();
        next();
    }
}