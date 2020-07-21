// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;

// public class ReadFile {
//    // private Algorithm theAlgorithm;
//     private FileReader file;
//     private BufferedReader reader;
//     private List<String> list;
//     private int size;
//     private String path;


//     public ReadFile(String filename) {
//         this.path = filename;
//         this.list = new ArrayList<String>();
//     }
//     public void readFromFile() {
//         try {
//             this.reader = new BufferedReader(new FileReader(path));

//         String st = this.reader.readLine();
//         while (st != null) {
//             this.list.add(st);
//             st = this.reader.readLine();
//         }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
//     public void parse(){
//         algorithmChooser(this.list.get(0));
//         this.size = Integer.parseInt(this.list.get(1));



//     }

//     private void algorithmChooser(String algo) {
//         switch (Integer.parseInt(algo)){
//             case 1:
//                 this.theAlgorithm = new IDSAlgorithm();
//                 break;
//             case 2:
//                 this.theAlgorithm = new BFSAlgorithm();
//                 break;
//             case 3:
//                 this.theAlgorithm = new AStarAlgorithm();
//                 break;
//             default:
//                 break;
//         }

//     }
// }
