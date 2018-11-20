import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class java_ex1 {

    public static void main(String[] args) {
//        IOFile rd = new IOFile("input.txt");
        List<String> info = new ArrayList<>();
        AbstractAlgorithm algorithm = null;
        Solution sol=null;
        PrintWriter writer = null;

        // read from file.
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input_elad1.txt"));

            String st = reader.readLine();
            while (st != null) {
                info.add(st);
                st = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int size = Integer.parseInt(info.get(1));
        // convert to array of string.
        String[] parts = (info.get(2)).split("-");
        int[] result = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            result[i] = Integer.parseInt(parts[i]);
        }
        // create first node and logic
        Node firstNode = new Node(result,null,' ');
        ILogic logic = new Logic(size);

        // select algorithm
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

        // write to file.
        try {
            writer = new PrintWriter("output.txt", "UTF-8");
            if (sol != null) {
                writer.print(sol.getPath() + " " + sol.getCountNode() + " " + sol.getCost());
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
        // algorithmChooser(info.get(0));
