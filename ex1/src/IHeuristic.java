/**
 * this class represent Heuristic interface.
 */
public interface IHeuristic {

    /**
     * calculate heuristic Distance
     * @param size - size of state
     * @param i -index
     * @param j index
     * @return return the output of heuristic function
     */
    public int heuristicDistance(int size, int i,int j);

    /**
     * this method sum all  heuristic distances.
     * @param node node
     * @param size size
     * @return return sum
     */
    public int heuristicDistanceSum(Node node ,int size) ;

    }
