import java.util.List;

public interface ILogic
{

    public int[] getGoalState();
    public List<Node> getSuccessors(Node node);
    public int findSpace(Node node);
    public Node moveUp(int space, Node father);
    public Node moveDown(int space, Node father);
    public Node moveLeft(int space, Node father);
    public Node moveRight(int space, Node father);
    public int calculateIndex(int[] state,int num);
    public boolean isGoalStae(Node node);
    int getSize();
    void initialize();
}
