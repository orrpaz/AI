import java.util.List;
import java.util.Stack;
/**
 * this class represent IDS Algorithm
 */
public class IDSAlgorithm extends AbstractAlgorithm {
    private int count;
    private Stack<Node> openList;


    public IDSAlgorithm(ILogic logic, Node node) {
        super(node,logic);
        this.count = 0;
        this.openList = new Stack<>();

    }

    @Override
    public Solution search() {
        int limit = 0;
        Solution solution = null;
        while(true){
            openList.clear();
             solution = DFSLimit(limit);
             if (solution != null){
                 break;
             }

            limit++;

        }
        return solution;

    }

    public Solution DFSLimit(int limit){
        this.openList.push(node);
        while (!openList.isEmpty()) {
            count++;
            Node current = openList.pop();

            if (logic.isGoalState(current)) {
                this.node = current;
                return new Solution(this.getPath(),count,current.getDepth());
            }
             if(current.getDepth() == limit){
                 continue;
             }

            List<Node> successors = logic.getSuccessors(current);
             for(int i = successors.size()-1; i>=0; i--){
                 openList.push(successors.get(i));
             }
        }
        count = 0;
        return null;
    }
}



