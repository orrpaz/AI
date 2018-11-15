public class ManhattanHeuristic implements IHeuristic{
    Logic logic;
    public ManhattanHeuristic(Logic logic){
        this.logic = logic;

    }


    @Override
    public int heuristicDistance(int size, int i,int j) {
        int currentRow = i / size;
        int currentCol = i % size;

        int expectedRow = j / size;
        int expectedCol = j % size;

        return Math.abs(currentRow-expectedRow) + Math.abs(currentCol - expectedCol);
    }
    public int heuristicDistanceSum(Node node,int size) {
        int sum=0;
        int[] goal = logic.getGoalState();
        int[] state = node.getState();
        for(int i = 0;i<size*size;++i){
            sum += heuristicDistance(size,logic.calculateIndex(state,i+1),
                    logic.calculateIndex(goal,i+1));
        }
        return sum;
    }
}
