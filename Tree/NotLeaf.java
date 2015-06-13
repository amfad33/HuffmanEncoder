package Tree;

/**
 * Created by amfad33 on 6/13/2015.
 */
public class NotLeaf extends Node {
    public final Node left, right; // subtrees

    public NotLeaf(Node l, Node r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}

