import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Puzzle {

    public static void main(String[] args) {
//        IOFile rd = new IOFile("input.txt");
        List<String> info = new ArrayList<>();
        AbstractAlgorithm algorithm = null;
        Solution sol=null;
        PrintWriter writer = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("my_input2.txt"));

            String st = reader.readLine();
            while (st != null) {
                info.add(st);
                st = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int size = Integer.parseInt(info.get(1));
//        System.out.println(list.get(2));
        String[] parts = (info.get(2)).split("-");
        int[] result = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            result[i] = Integer.parseInt(parts[i]);
        }
        Node firstNode = new Node(result,null,' ');
        Logic logic = new Logic(size);

        switch (Integer.parseInt(info.get(0))) {
            case 1:
                algorithm = new IDSAlgorithm(logic,firstNode);
                sol = algorithm.search();
                break;
            case 2:
                algorithm = new BFSAlgorithm(logic,firstNode);
                sol = algorithm.search();


                break;
            case 3:
               algorithm = new AStarAlgorithm(logic,firstNode,new ManhattanHeuristic(logic));
               sol = algorithm.search();

                break;
            default:
                break;
        }


        try {
            writer = new PrintWriter("output4.txt", "UTF-8");
            if (sol != null) {
                writer.print(sol.path + " " + sol.countNode + " " + sol.cost);
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        // algorithmChooser(info.get(0));




//        int[] state = rd.readFromFile();
//        Node root = new Node(result);
        //        Board board = new Board(rd.getSize());
//        board.setBoard(parts);
//        rd.getTheAlgorithm().search(board,logic);
//        parse(info);
    }
}
//
//    public static void parse(List<String> info){
//        algorithmChooser(info.get(0));
//        this.size = Integer.parseInt(info.get(1));
////        System.out.println(list.get(2));
//        String[] parts = (info.get(2)).split("-");
//
//
//    }
//
//    private void algorithmChooser(String algo) {
//        switch (Integer.parseInt(algo)){
//            case 1:
////                this.theAlgorithm = new IDSAlgorithm();
//                break;
//            case 2:
//                this.theAlgorithm = new BFSAlgorithm();
//                break;
//            case 3:
////                this.theAlgorithm = new AStarAlgorithm();
//                break;
//            default:
//                break;
//        }
//
//    }

//    public static void loadFile(String fileName){
//
//        File file = new File(fileName);
//
//        BufferedReader br = null;
//        try {
//            br = new BufferedReader(new FileReader(file));
//            String st;
//            while ((st = br.readLine()) != null)
//                System.out.println(st);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//    }




