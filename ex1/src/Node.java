public class Node {
    private int[] state;
    private Node parent;
    private char move;
    private int depth;


    private int timeStamp;

    /**
     * constructor.
     * @param state state
     * @param node noce
     * @param c char thar symbolize which move we did to get this node.
     */
    public Node(int[] state, Node node,char c){
        this.state = state;
        parent = node;
        move = c;
        timeStamp = 0;
        if (parent == null) {
            this.depth = 0;
        } else {
            this.depth = parent.getDepth() + 1;
        }
    }

    /**
     *
     * @return state.
     */
    public int[] getState() {
        return state;
    }

    /**
     *
     * @return father node
     */
    public Node getFather() {
        return parent;
    }

    /**
     *
     * @return move
     */
    public char getMove() {
        return move;
    }

    /**
     *
     * @return depth.
     */
    public int getDepth() {
        return depth;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setIimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }


    public String toString(){
        String res="";
        for(int i=0;i<state.length;i++){
            res += Integer.toString(state[i]);
        }
        return res;
    }
}

