import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * this class represent  BFS Algorithm
 */
public class BFSAlgorithm extends AbstractAlgorithm {


    private int count;
//    protected Node node;
    public BFSAlgorithm(ILogic logic,Node node){
        super(node,logic);
        this.count = 0;
//        this.node = node;
    }
    @Override
    public Solution search() {
        Node current = null;
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            current = queue.poll();
            count++;
            if (logic.isGoalState(current)) {
                node = current;
               return new Solution(this.getPath(),count,0);
//                System.out.println(this.getPath());
            }
            queue.addAll(logic.getSuccessors(current));


        }

//        System.out.println("ERROR");
        return null;
    }
    public int getCount() {
        return count;
    }
}
