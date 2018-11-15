abstract class AbstractAlgorithm {
//    protected Logic logic;
//    protected int count;
//    protected Node node;

    protected Node node;
    protected Logic logic;

    public AbstractAlgorithm(Node node, Logic logic) {
        this.node = node;
        this.logic = logic;
    }

    public abstract Solution search();
    public String getPath(){
        StringBuilder stringBuilder = new StringBuilder();
        Node current = node;
        while(current != null){
            char move = current.getMove();
            if(move!=' ') {
                stringBuilder.insert(0, move);
            }
            current = current.getFather();

        }
        return stringBuilder.toString();
    }
}
