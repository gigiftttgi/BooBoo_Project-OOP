package grammar;

public class Intlit implements Node{
        private double val;
        
        Intlit (Double val){
            this.val = val;
        }

        @Override
        public double evaluate() throws SyntaxError {
            return val;
        }
}
