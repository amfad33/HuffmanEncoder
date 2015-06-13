package Tree;

/**
 * Created by amfad33 on 6/13/2015.
 *
 * The Huffman Tree Structure
 */
abstract public class Node implements Comparable<Node> {
    public final int frequency; // the frequency of this tree
    public String code="";
    public Node(int f) { frequency = f; }
    // compares on the frequency
    public int compareTo(Node tree) {
        return frequency - tree.frequency;
    }
}
