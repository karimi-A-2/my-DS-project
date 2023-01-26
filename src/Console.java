import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    private static final Scanner SCANNER = new Scanner(System.in);
    
    public void printMST( ArrayList<Edge> mst ) {
        println("---> MST:");
        int sum = 0;
        for (Edge edge : mst) {
            sum += edge.weight;
            println(edge.toString());
        }
        println("MST cost : " + sum);
    }
    
    public ArrayList<String> getSample1() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("0 1 10");
        arrayList.add("0 2 6");
        arrayList.add("0 3 5");
        arrayList.add("1 3 15");
        arrayList.add("2 3 4");
        return arrayList;
    }
    
    public ArrayList<String> getSample2() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("7 6 1");
        arrayList.add("8 2 2");
        arrayList.add("6 5 2");
        arrayList.add("0 1 4");
        arrayList.add("2 5 4");
        arrayList.add("8 6 6");
        arrayList.add("2 3 7");
        arrayList.add("7 8 7");
        arrayList.add("0 7 8");
        arrayList.add("1 2 8");
        arrayList.add("3 4 9");
        arrayList.add("5 4 10");
        arrayList.add("1 7 11");
        arrayList.add("3 5 14");
        return arrayList;
    }
    
    public void printNodes( Node[] nodes ) {
        System.out.println("-------------");
        for (int i = 0; i < nodes.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (Node node : nodes) {
            System.out.print(node.next + " ");
        }
        System.out.println();
        for (Node node : nodes) {
            System.out.print(node.rank + " ");
        }
        System.out.println();
    }
    
    public void print( String message ) {
        System.out.print(message);
    }
    
    public void println( String message ) {
        System.out.println(message);
    }
    
    public void printPrompt( String message ) {
        print("\t [> " + message + ": ");
    }
    
    public void printInfo( String message ) {
        println("\t ~~~ " + message);
    }
    
    public void printWarning( String message ) {
        println("\t !!~~ " + message);
    }
    
    
    public String getString( String message ) {
        printPrompt(message);
        return getString();
    }
    
    public int getInt( String message ) {
        printPrompt(message);
        return getInt();
    }
    
    public String getString() {
        return SCANNER.nextLine();
    }
    
    public int getInt() {
        int anInt = SCANNER.nextInt();
        getString();
        return anInt;
    }
    
    public void demandEnter( String message ) {
        print("\t (▶) " + message + " (▶) ");
        getString();
    }
    
}
