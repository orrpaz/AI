import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * this class represent A Star Algorithm
 */
public class AStarAlgorithm extends AbstractAlgorithm {

    private IHeuristic heuristic;
    private int count;
    private Queue<Node> priorityQueue;
    private int timeStamp;

    public AStarAlgorithm(ILogic logic,Node node,IHeuristic heuristic){
        super(node,logic);
        this.count = 0;
        this.timeStamp = 0;
        this.heuristic = heuristic;
//        this.node = node;
        priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int result = evaluateFunctionF(o1) - evaluateFunctionF(o2);
            if (result != 0) {
                return result;
            } else {
                int resultPriority = o1.getTimeStamp() - o2.getTimeStamp();
                if (resultPriority < 0) {
                    return -1;
                }
                return 1;
                }
            });
    }

    @Override
    public Solution search() {
        node.setIimeStamp(timeStamp);
        timeStamp++;
        priorityQueue.add(node);
        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
//            current.setPriority(count);
            count++;
            if (logic.isGoalState(current)) {
//                System.out.println(current + " " + current.getDepth() +" "+ count);
                this.node = current;
                return new Solution(this.getPath(),count,this.node.getDepth());
            }
            for(Node successor : logic.getSuccessors(current)) {
                successor.setIimeStamp(timeStamp++);
                priorityQueue.add(successor);
            }

        }
        return null;
    }

    private int evaluateFunctionF(Node node) {
        return node.getDepth() + this.heuristic.heuristicDistanceSum(node,logic.getSize());
    }

}
