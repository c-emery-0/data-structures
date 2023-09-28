import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {

        /* The Map interface is generic.
         * The first type is the type of the key, the second type is the type of the value.
         */

        Map<String, Color> favColors = new HashMap<>();

        // Add elements to a map using the put method
        favColors.put("Peter", Color.BLACK);
        favColors.put("Seth", Color.BLUE);
        favColors.put("Celeste", Color.ORANGE);

        // Two different keys can have the same value
        favColors.put("Dr. Miller", Color.ORANGE);

        // The same key can't have two values.
        // Using put() on a key that already exists rewrites that key's value.
        // This rewrites black with yellow.
        favColors.put("Peter", Color.YELLOW); 

        // Create a set of the keys in a map
        Set<String> keys = favColors.keySet();
        for( String key : keys ) {
            System.out.println(key + " ("+ key.hashCode() + ") " + favColors.get(key));
        }

    }
}
