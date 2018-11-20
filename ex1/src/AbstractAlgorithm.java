
/**
 * this class represent Abstract Algorithm.
 */
abstract class AbstractAlgorithm {
//    protected Logic logic;
//    protected int count;
//    protected Node node;

    protected Node node;
    protected ILogic logic;

    public AbstractAlgorithm(Node node, ILogic logic) {
        this.node = node;
        this.logic = logic;
    }

    /**on
     * search the solution of game.
     * @return soluti
     */
    public abstract Solution search();

    /**
     * get path of the solution
     * @return path
     */
    public String getPath(){
        StringBuilder stringBuilder = new StringBuilder();
        Node current = node;
        while(current != null){
            char move = current.getMove();
            if(move!=' ') {
                // use stringBuilder to build string of path
                stringBuilder.insert(0, move);
            }
            current = current.getFather();

        }
        return stringBuilder.toString();
    }
}
