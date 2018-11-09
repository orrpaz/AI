public class Matrix
{
    private int[][] mat;
    private int size;
    private Node root;
    private Node goal;
    private String state;
    private int creationTime;

    public Matrix(String state, int size) {
        this.state = state;
        this.size = size;
        this.creationTime = 0;
        this.mat = new int[this.size][this.size];
        this.setBoard(this.state.toCharArray(), this.size);
        this.setRootAndGoal();
    }

    public int getSize() {
        return this.size;
    }
    public Node getRoot() {
        return this.root;
    }
    public Node getGoal() {
        return this.goal;
    }
    public void setBoard(int[] state, int size) {
}
