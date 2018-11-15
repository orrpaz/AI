import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class IDSAlgorithm extends AbstractAlgorithm {
    private int count;
    private Stack<Node> openList;


    public IDSAlgorithm(Logic logic, Node node) {
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
            System.out.println(current + " " + current.getDepth());

            if (logic.isGoalStae(current)) {
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

//            openList.addAll(logic.getSuccessors(current));



        }
        count = 0;
        return null;
    }
}



