package shuza.sa.babyapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import shuza.sa.babyapp.AlphabetListFragment;
import shuza.sa.babyapp.AnimalListFragment;
import shuza.sa.babyapp.FoodListFragment;
import shuza.sa.babyapp.NumberListFragment;

/**
 * Created by Boka on 21-May-15.
 */
public class CategoryAdapter extends FragmentStatePagerAdapter {
    private ArrayList<String> category;
    private FragmentManager mFragmentManager;

    public CategoryAdapter(FragmentManager fm, ArrayList<String> categoty) {
        super(fm);
        this.category = categoty;
        this.mFragmentManager = fm;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FoodListFragment();
            case 1:
                return new NumberListFragment();
            case 2:
                return new AnimalListFragment();
            case 3:
                return new AlphabetListFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return category.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return category.get(position);
    }
}
