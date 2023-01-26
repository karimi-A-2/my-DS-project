import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Director {
    Console console;
    
    public Director() {
        console = new Console();
    }
    
    public void start() {
        Graph graph = getGraph();
        ArrayList<Edge> kruskalMST = graph.getKruskalMST();
        console.printMST(kruskalMST);
    }
    
    private Graph getGraph() {
        console.println("Enter weighted edges line by line and Enter 'end' to stop reading");
        
        String patternStr = "(\\d+) (\\d+) (\\d+)";
        Pattern pattern = Pattern.compile(patternStr);
        
        ArrayList<String> arrayList = new ArrayList<>();
        HashSet<Integer> vertices = new HashSet<>();
        while (true) {
            String edgeStr = console.getString();
            if (edgeStr.equals("end")) {
                break;
            }
            Matcher matcher = pattern.matcher(edgeStr);
            if (matcher.find()) {
                arrayList.add(edgeStr);
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                vertices.add(x);
                vertices.add(y);
            } else {
                System.out.println("!!! ---> invalid input");
            }
        }
        
        Graph graph = new Graph(vertices.size(), arrayList.size());
        
        for (int i = 0; i < arrayList.size(); i++) {
            String str = arrayList.get(i);
            String[] split = str.split(" ");
            graph.edges[i].x = Integer.parseInt(split[0]);
            graph.edges[i].y = Integer.parseInt(split[1]);
            graph.edges[i].weight = Integer.parseInt(split[2]);
        }
        
        return graph;
    }
    
}