
package com.massurya.healty.ui;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import buildup.ui.DrawerActivity;

import buildup.actions.StartActivityAction;
import buildup.util.Constants;
import com.massurya.healty.R;

public class MariSehatMainActivity extends DrawerActivity {

    private final SparseArray<Class<? extends Fragment>> sectionFragments = new SparseArray<>();
    {
            sectionFragments.append(R.id.entry0, MariSehatFragment.class);
            sectionFragments.append(R.id.entry1, KaloriFragment.class);
            sectionFragments.append(R.id.entry2, MinumFragment.class);
            sectionFragments.append(R.id.entry3, IdealFragment.class);
            sectionFragments.append(R.id.entry4, TentangFragment.class);
    }

    @Override
    public SparseArray<Class<? extends Fragment>> getSectionFragmentClasses() {
      return sectionFragments;
    }

}
