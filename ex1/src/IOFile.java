//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class IOFile {
//    private AbstractAlgorithm theAlgorithm;
////    private FileReader file;
//    private BufferedReader reader;
//    private List<String> list;
//    private int size;
//    private String path;
//
//
//    public IOFile(String filename) {
//        this.path = filename;
//        this.list = new ArrayList<String>();
//    }
//    public int[] readFromFile() {
//        try {
//            this.reader = new BufferedReader(new FileReader(path));
//
//        String st = this.reader.readLine();
//        while (st != null) {
//            this.list.add(st);
//            st = this.reader.readLine();
//        }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return parse();
//    }
//
//    public int[] parse() {
//        algorithmChooser(this.list.get(0));
//        this.size = Integer.parseInt(this.list.get(1));
////        System.out.println(list.get(2));
//        String[] parts = (list.get(2)).split("-");
//        int[] result = new int[parts.length];
//        for (int i = 0; i < parts.length; i++) {
//            result[i] = Integer.parseInt(parts[i]);
//        }
//        return result;
//    }
//
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
//
//    public List<String> getList() {
//        return list;
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//    public AbstractAlgorithm getTheAlgorithm() {
//        return theAlgorithm;
//    }
//}
