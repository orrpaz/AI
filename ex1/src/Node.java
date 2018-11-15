public class Node {
    private int[] state;
    private Node parent;
    private char move;
    private int depth;


    public Node(int[] state, Node node,char c){
        this.state = state;
        parent = node;
        move = c;
        if (parent == null) {
            this.depth = 0;
        } else {
            this.depth = parent.getDepth() + 1;
        }
    }

    public int[] getState() {
        return state;
    }

    public void setState(int[] state) {
        this.state = state;
    }

    public Node getFather() {
        return parent;
    }

    public void setFather(Node root) {
        this.parent = root;
    }

    public char getMove() {
        return move;
    }

    public void setMove(char move) {
        this.move = move;
    }
    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String toString(){
        String res="";
        for(int i=0;i<state.length;i++){
            res += Integer.toString(state[i]);
        }
        return res;
    }
}

