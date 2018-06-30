
package com.massurya.healty.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.massurya.healty.R;
import buildup.ds.Datasource;
import android.widget.TextView;
import buildup.ds.SearchOptions;
import buildup.ds.filter.Filter;
import java.util.Arrays;
import com.massurya.healty.ds.Item;
import com.massurya.healty.ds.EmptyDatasource;

public class TentangFragment extends buildup.ui.DetailFragment<Item>  {

    private Datasource<Item> datasource;
    private SearchOptions searchOptions;

    public static TentangFragment newInstance(Bundle args){
        TentangFragment card = new TentangFragment();
        card.setArguments(args);

        return card;
    }

    public TentangFragment(){
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchOptions = SearchOptions.Builder.searchOptions().build();
    }

    @Override
    public Datasource getDatasource() {
        if (datasource != null) {
            return datasource;
        }
        datasource = EmptyDatasource.getInstance(searchOptions);
        return datasource;
    }

    // Bindings

    @Override
    protected int getLayout() {

        return R.layout.tentang_custom;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final Item item, View view) {
    }

    @Override
    protected void onShow(Item item) {
        // set the title for this fragment
        getActivity().setTitle("Tentang");
    }
}
