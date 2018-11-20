import java.util.List;
/**
 * this class represent ILogic interface.
 */
public interface ILogic
{
    /**
     *
     * @return
     */
    public int[] getGoalState();

    /**
     *
     * @param node
     * @return
     */
    public List<Node> getSuccessors(Node node);

    /**
     *
     * @param node
     * @return
     */
    public int findSpace(Node node);

    /**
     * moveUp
     * @param space the free cell
     * @param father the node father
     * @return new node after move
     */
    public Node moveUp(int space, Node father);

    /**
     *
     * @param space the free cell
     * @param father the node father
     * @return new node after move
     */
    public Node moveDown(int space, Node father);

    /**
     *
     * @param space the free cell
     * @param father the node father
     * @return new node after move
     */
    public Node moveLeft(int space, Node father);

    /**
     *
     * @param space the free cell
     * @param father the node father
     * @return new node after move
     */
    public Node moveRight(int space, Node father);

    /**
     * given state and number. return the index of number in state
     * @param state state
     * @param num number we search
     * @return return the index of number in state
     */
    public int calculateIndex(int[] state,int num);

    /**
     * check if it is goal state.
     * @param node node
     * @return true if yes, flase otherwise.
     */
    public boolean isGoalState(Node node);

    /**
     *
     * @return size of state.
     */
    int getSize();

    /**
     * initialize
     */
    void initialize();
}
