package grammar;

public class Tokenizer {
    private String src;
    private String next;
    private int pos;

    public Tokenizer(String src) throws SyntaxError{
        this.src = src;
        pos = 0;
        computeNext();
    }

    private void computeNext() throws SyntaxError{
        StringBuilder s = new StringBuilder();
        while(pos < src.length() && Character.isWhitespace(src.charAt(pos))) pos++;
        if(pos < src.length()) {
            char c = src.charAt(pos);
            if (Character.isDigit(c)) {
                s.append(c);
                for (pos++; pos < src.length() && Character.isDigit(src.charAt(pos)); pos++) {
                    s.append(src.charAt(pos));
                }
            } else if (c == '+' || c == '(' || c == ')' || c == '-' || c == '*' || c == '/' || c == '%') {
                s.append(c);
                pos++;
            } else throw new SyntaxError();
        }
            next = s.toString();
    }
    
    
}
