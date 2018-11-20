import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * this class represent A Star Algorithm
 */
public class AStarAlgorithm extends AbstractAlgorithm {

    IHeuristic heuristic;
    private int count;
    Queue<Node> priorityQueue ;
    public AStarAlgorithm(ILogic logic,Node node,IHeuristic heuristic){
        super(node,logic);
        this.count = 0;
        this.heuristic = heuristic;
//        this.node = node;
        priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return getF(o1) - getF(o2);
            }
        });
    }

    @Override
    public Solution search() {
        priorityQueue.add(node);
        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            count++;
            if (logic.isGoalState(current)) {
                System.out.println(current + " " + current.getDepth() +" "+ count);
                this.node = current;
                return new Solution(this.getPath(),count,current.getDepth());
            }

            priorityQueue.addAll(logic.getSuccessors(current));

        }
        return null;
    }

    private int getF(Node node) {
        return node.getDepth() + this.heuristic.heuristicDistanceSum(node,logic.getSize());
    }

}
