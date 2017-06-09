package space.musatov.mytraining.ui.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import space.musatov.mytraining.model.Excersize;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Excersize> ITEMS = new ArrayList<Excersize>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Excersize> ITEM_MAP = new HashMap<String, Excersize>();

    private static final int COUNT = 25;

    //static {
        // Add some sample items.
        //for (int i = 1; i <= COUNT; i++) {
       //     addItem(createDummyItem(i));
       // }
    //}

    private static void addItem(Excersize item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getExcersizeType(), item);
    }

    //private static Excersize createDummyItem(int position) {
     //   return new Excersize(String.valueOf(position), "Item " + position, makeDetails(position));
    //}

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        private String excersizeType;
        private String excersizeDescription;
        private int excersizeCount;

        public DummyItem(String excersizeType, String excersizeDescription, int excersizeCount) {
            this.excersizeType = excersizeType;
            this.excersizeDescription = excersizeDescription;
            this.excersizeCount = excersizeCount;
        }

        @Override
        public String toString() {
            return excersizeDescription;
        }
    }
}
