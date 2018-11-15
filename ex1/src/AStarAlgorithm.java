import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStarAlgorithm extends AbstractAlgorithm {

    IHeuristic heuristic;
    private int count;
    private int cost;
    Queue<Node> priorityQueue ;
    public AStarAlgorithm(Logic logic,Node node,IHeuristic heuristic){
        super(node,logic);
        this.count = 0;
        this.cost = 0;
        this.heuristic = heuristic;
//        this.node = node;
        priorityQueue = new PriorityQueue<>(Comparator.comparingInt(this::getF));
    }

    @Override
    public Solution search() {
        priorityQueue.add(node);
        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            count++;
            if (logic.isGoalStae(current)) {
                this.cost = calculateCost(current);
                System.out.println(current + " " + current.getDepth() +" "+ count);
                this.node = current;
                return new Solution(this.getPath(),count,cost);
            }
            priorityQueue.addAll(logic.getSuccessors(current));

        }
        return null;
    }

    private int getF(Node node) {
        return node.getDepth() + this.heuristic.heuristicDistanceSum(node,logic.getSize());
    }

    private int calculateCost(Node current){
        while(current!=null){
            cost+=getF(current);
            current = current.getFather();
        }
        return cost;
    }
}
