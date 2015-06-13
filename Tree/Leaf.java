package Tree;

/**
 * Created by amfad33 on 6/13/2015.
 */
public class Leaf extends Node {
    public final String value; // the character this leaf represents

    public Leaf(int frequency, String value) {
        super(frequency);
        this.value = value;
    }
}
