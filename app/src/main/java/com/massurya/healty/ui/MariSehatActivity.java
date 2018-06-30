

package com.massurya.healty.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.massurya.healty.R;

import buildup.ui.BaseListingActivity;
/**
 * MariSehatActivity list activity
 */
public class MariSehatActivity extends BaseListingActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        if(isTaskRoot()) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        
        setTitle(getString(R.string.mariSehatActivity));
    }

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return MariSehatFragment.class;
    }

}
