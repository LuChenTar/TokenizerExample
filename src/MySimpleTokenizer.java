/**
 * Created by luchen on 6/05/15.
 */
public class MySimpleTokenizer extends Tokenizer{
    private String text;
    private int pos;
    private Object current;

    static final char whitespace[] = {' ','\n','\t'};
    static final char symbol[] = {'(',')','=',':','?',','};

    public MySimpleTokenizer(String text) {
        this.text = text;
        this.pos = 0;
        next();
    }
    @Override
    boolean hasNext() {
        return current != null;
    }

    @Override
    Object current() {
        return current();
    }

    @Override
    void next() {
        consumewhite();//ignore whitespace
        if (pos == text.length()) {
            current = null;

        } else if (isin(text.charAt(pos), symbol)) {
            current = "" + text.charAt(pos);
            pos++;

        } else if (Character.isDigit(text.charAt(pos))) {
            int start = pos;
            while (pos < text.length() && Character.isDigit(text.charAt(pos)) )
                pos++;
            if (pos+1 < text.length() && text.charAt(pos) == '.' &&
                    Character.isDigit(text.charAt(pos+1))) {
                pos++;
                while (pos < text.length() && Character.isDigit(text.charAt(pos)))
                    pos++;
                current = Double.parseDouble(text.substring(start, pos));
            } else {
                current = Integer.parseInt(text.substring(start, pos));
            }

        } else {
            int start = pos;
            while (pos < text.length() && !isin(text.charAt(pos), symbol)
                    && !isin(text.charAt(pos), whitespace))
                pos++;
            current = text.substring(start, pos);
        }
    }



    private void consumewhite() {
        while (pos < text.length() && isin(text.charAt(pos), whitespace))
            pos++;
    }

    private boolean isin(char c, char charlist[]) {
        for (char w : charlist) {
            if (w == c)
                return true;
        }
        return false;
    }
}
