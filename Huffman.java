import Tree.Leaf;
import Tree.Node;
import Tree.NotLeaf;

import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by amfad33 on 6/13/2015.
 */
public class Huffman {
    public static Node build(Map map) {
        PriorityQueue<Node> trees = new PriorityQueue<Node>();

        Iterator i = map.entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry pair = (Map.Entry)i.next();
            int a;
            if ((a=Integer.parseInt(pair.getValue().toString()))>0)
                trees.offer(new Leaf(a, pair.getKey().toString()));
        }  //building first leaves in priority queue

        assert trees.size() > 0;
        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            Node a = trees.poll();
            Node b = trees.poll();

            // put into new node and re-insert into queue (making parents)
            trees.offer(new NotLeaf(a, b));
        }
        return trees.poll();
    }

    public static void compute(Node tree) {
        assert tree != null;
        if (tree instanceof Leaf) {   //the tree has only one character
            Leaf leaf = (Leaf)tree;
            // print out character, frequency, and code for this leaf (which is just the prefix)
            System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + leaf.code);

        } else if (tree instanceof NotLeaf) {
            NotLeaf node = (NotLeaf)tree;

            // traverse left
            node.left.code=node.code+"0";
            compute(node.left);

            // traverse right
            node.right.code=node.code+"1";
            compute(node.right);
        }
    }
}
