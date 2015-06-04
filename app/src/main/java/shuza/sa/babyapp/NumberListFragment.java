package shuza.sa.babyapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

import shuza.sa.babyapp.adapter.PhotoListAdapter;

/**
 * Created by Boka on 21-May-15.
 */
public class NumberListFragment extends Fragment implements AbsListView.OnScrollListener {

    GridView gridView;
    PhotoListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo_list, container, false);
        gridView = (GridView) view.findViewById(R.id.gridView);

        ArrayList<String> items = new ArrayList<String>();
        items.add("drawable://" + R.drawable.img_number_1);
        items.add("drawable://" + R.drawable.img_number_2);
        items.add("drawable://" + R.drawable.img_number_3);
        items.add("drawable://" + R.drawable.img_number_4);
        items.add("drawable://" + R.drawable.img_number_5);
        items.add("drawable://" + R.drawable.img_number_6);
        items.add("drawable://" + R.drawable.img_number_7);
        items.add("drawable://" + R.drawable.img_number_8);
        items.add("drawable://" + R.drawable.img_number_9);
        items.add("drawable://" + R.drawable.img_number_10);
        items.add("drawable://" + R.drawable.img_number_11);
        items.add("drawable://" + R.drawable.img_number_12);
        items.add("drawable://" + R.drawable.img_number_13);
        items.add("drawable://" + R.drawable.img_number_14);
        items.add("drawable://" + R.drawable.img_number_15);
        items.add("drawable://" + R.drawable.img_number_16);
        items.add("drawable://" + R.drawable.img_number_17);
        items.add("drawable://" + R.drawable.img_number_18);
        items.add("drawable://" + R.drawable.img_number_19);
        items.add("drawable://" + R.drawable.img_number_20);
        items.add("drawable://" + R.drawable.img_number_1);

        mAdapter = new PhotoListAdapter(getActivity(), items);
        gridView.setAdapter(mAdapter);
        gridView.setOnScrollListener(this);

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
