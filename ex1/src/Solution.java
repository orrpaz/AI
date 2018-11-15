public class Solution {
    String path;
    int countNode;
    int cost;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getCountNode() {
        return countNode;
    }

    public void setCountNode(int countNode) {
        this.countNode = countNode;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Solution(String path, int count, int cost){
        this.cost = cost;
        this.path = path;
        this.countNode = count;
    }
}
