

package com.massurya.healty.ds;
import com.massurya.healty.R;
import java.util.ArrayList;
import java.util.List;
import buildup.util.StringUtils;

// Item static data
public class EmptyDatasourceItems{

    public static List<Item> ITEMS = new ArrayList<Item>();
    public static void addItem(Item item) {
        ITEMS.add(item);
    }
}

