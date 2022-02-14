package grammar;

public class Intlit implements Node{
        private int val;
        
        Intlit (int val){
            this.val = val;
        }

        @Override
        public double evaluate() throws SyntaxError {
            // TODO Auto-generated method stub
            return 0;
        }
}
