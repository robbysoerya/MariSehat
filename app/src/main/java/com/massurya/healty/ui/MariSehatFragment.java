

package com.massurya.healty.ui;

import android.os.Bundle;

import com.massurya.healty.R;

import java.util.ArrayList;
import java.util.List;

import buildup.MenuItem;

import buildup.actions.StartActivityAction;
import buildup.util.Constants;

/**
 * MariSehatFragment menu fragment.
 */
public class MariSehatFragment extends buildup.ui.MenuFragment {
    /**
     * Default constructor
     */
    public MariSehatFragment(){
        super();
    }

    // Factory method
    public static MariSehatFragment newInstance(Bundle args) {
        MariSehatFragment fragment = new MariSehatFragment();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Menu Fragment interface
    @Override
    public List<MenuItem> getMenuItems() {
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        items.add(new MenuItem()
            .setLabel("Kalori")
            .setIcon(R.drawable.png_icons8calories50533)
            .setAction(new StartActivityAction(KaloriActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Minum")
            .setIcon(R.drawable.png_icons8drinking50826)
            .setAction(new StartActivityAction(MinumActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Ideal")
            .setIcon(R.drawable.png_icons8neck50875)
            .setAction(new StartActivityAction(IdealActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Informasi")
            .setIcon(R.drawable.png_icons8about50519)
            .setAction(new StartActivityAction(TentangActivity.class, Constants.DETAIL))
        );
        return items;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_grid;
    }

    @Override
    public int getItemLayout() {
        return R.layout.marisehat_item;
    }
}
