/**
 * this class represent Solution.
 */
public class Solution {
    private String path;
    private int countNode;
    private int cost;

    /**
     * getters.
     * @return string
     */
    public String getPath() {
        return path;
    }

    /**
     * getters.
     * @return int
     */
    public int getCountNode() {
        return countNode;
    }

    /**
     * getters.
     * @return int
     */
    public int getCost() {
        return cost;
    }

    /**
     * constructor
     * @param path path
     * @param count count
     * @param cost cost
     */
    public Solution(String path, int count, int cost){
        this.cost = cost;
        this.path = path;
        this.countNode = count;
    }
}
