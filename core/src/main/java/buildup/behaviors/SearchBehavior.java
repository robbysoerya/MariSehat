package buildup.behaviors;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import buildup.core.R;
import buildup.injectors.ApplicationInjector;
import buildup.ui.Filterable;

/**
 * Adds an action bar search interface
 */
public class SearchBehavior extends NoOpBehavior {

    Filterable mFilterable;

    SearchView searchView;

    public SearchBehavior(Filterable f) {
        mFilterable = f;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchMenuItem);

        SearchView.SearchAutoComplete searchEditText = (SearchView.SearchAutoComplete)
                searchView.findViewById(R.id.search_src_text);

        searchEditText.setHintTextColor(ContextCompat.getColor(
                ApplicationInjector.getApplicationContext(), R.color.hintSearchBarColor));

        if (searchView != null) {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    refreshSearch(s);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    if (s.equals("")) {
                        refreshSearch(null);
                    }
                    return false;
                }
            });

            MenuItemCompat.setOnActionExpandListener(searchMenuItem,
                    new MenuItemCompat.OnActionExpandListener() {
                        @Override
                        public boolean onMenuItemActionExpand(MenuItem menuItem) {
                            //nothing to override
                            return true;
                        }

                        @Override
                        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                            //reset the filtering string
                            refreshSearch(null);
                            return true;
                        }
                    });
        }
    }

    public void refreshSearch(String newFilter) {
        mFilterable.onSearchTextChanged(newFilter);
    }
}
