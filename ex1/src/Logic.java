import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * this class represent logic of game.
 */
public class Logic implements ILogic{

    private int size;
    private int[] goalState = null;

    public Logic(int size){
        this.size = size;
        this.goalState = new int[this.size*this.size];
        initialize();
    }
     public void initialize(){
         for(int i = 0; i < this.size*this.size ;++i){
             goalState[i] = i + 1;
         }
         goalState[this.size*this.size -1] = 0;
     }

    public int[] getGoalState(){
        return goalState;
    }

    public List<Node> getSuccessors(Node node){
        List<Node> list = new ArrayList<>();
//        Node firstNode = node.getFather();
        int space = findSpace(node);

        // can move up.
        if(space < size * (size-1)){
            list.add(moveUp(space,node));
        }
        // can move down.
        if(space >= size){
            list.add(moveDown(space,node));
        }
        // can move left
        if(space % size != size -1) {
            list.add(moveLeft(space,node));
        }
        // can move right.
        if(space % size != 0){
            list.add(moveRight(space,node));
        }


        return list;
    }

    public int findSpace(Node node){
        for(int i = 0; i < size; ++i){
            for(int j = 0; j < size; ++j){
                if(node.getState()[i*size +j] == 0){
                    return i*size +j;
                }
            }
        }
        return -1;
    }

    public Node moveUp(int space, Node father){
        // create copy of array and swap between suitable place.
        int[] b = Arrays.copyOf(father.getState(), father.getState().length);
         b[space] = b[space+size];
         b[space+size] = 0;
        return new Node(b, father, 'U');

    }

    public Node moveDown(int space, Node father){
        // create copy of array and swap between suitable place.
        int[] b = Arrays.copyOf(father.getState(), father.getState().length);
        b[space] = b[space-size];
        b[space-size] = 0;
        return new Node(b, father, 'D');


    }

    public Node moveLeft(int space, Node father){
        // create copy of array and swap between suitable place.
        int[] b = Arrays.copyOf(father.getState(), father.getState().length);
        b[space] = b[space+1];
        b[space+1] = 0;
        return new Node(b, father, 'L');

    }
    public Node moveRight(int space, Node father){
        // create copy of array and swap between suitable place.
        int[] b = Arrays.copyOf(father.getState(), father.getState().length);
        b[space] =b[space-1];
        b[space-1] = 0;
        return new Node(b, father, 'R');

    }

    public int getSize() {
        return size;
    }

    public boolean isGoalState(Node node){
        return Arrays.equals(node.getState(),this.getGoalState());
    }

    public int calculateIndex(int[] state,int num){
        for(int i =0;i<this.size*this.size;++i){
            if(state[i] == num){
                return i;
            }
        }
        return -1;
    }


}
