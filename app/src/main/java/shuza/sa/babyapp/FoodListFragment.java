package shuza.sa.babyapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import shuza.sa.babyapp.adapter.PhotoListAdapter;

/**
 * Created by Boka on 21-May-15.
 */
public class FoodListFragment extends Fragment implements AbsListView.OnScrollListener {

    PhotoListAdapter mAdapter;
    GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo_list, container, false);
        gridView = (GridView) view.findViewById(R.id.gridView);

        ArrayList<String> items = new ArrayList<String>();
        items.add("drawable://" + R.drawable.img_food_1);
        items.add("drawable://" + R.drawable.img_food_2);
        items.add("drawable://" + R.drawable.img_food_3);
        items.add("drawable://" + R.drawable.img_food_4);
        items.add("drawable://" + R.drawable.img_food_5);
        items.add("drawable://" + R.drawable.img_food_6);
        items.add("drawable://" + R.drawable.img_food_7);
        items.add("drawable://" + R.drawable.img_food_8);
        items.add("drawable://" + R.drawable.img_food_1);

        gridView.setOnScrollListener(this);

        mAdapter = new PhotoListAdapter(getActivity(), items);
        gridView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisible, int visibleCount, int totalCount) {
        if(firstVisible == totalCount - 2){
            gridView.setAdapter(mAdapter);
        }
    }
}
