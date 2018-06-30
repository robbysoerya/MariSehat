package com.massurya.healty.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import buildup.ui.BaseDetailActivity;

public class IdealActivity
        extends BaseDetailActivity
{
    protected Class<? extends Fragment> getFragmentClass()
    {
        return IdealFragment.class;
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        if (isTaskRoot()) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }else
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}


/* Location:              /home/robbysoerya/Documents/dex2jar-2.1-SNAPSHOT/classes-dex2jar.jar!/com/massurya/healty/ui/IdealActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */