package shuza.sa.babyapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;

import java.util.ArrayList;

import shuza.sa.babyapp.adapter.PhotoListAdapter;

/**
 * Created by Boka on 24-May-15.
 */
public class AnimalListFragment extends Fragment implements AbsListView.OnScrollListener {

    GridView gridView;
    PhotoListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo_list, container, false);
        gridView = (GridView) view.findViewById(R.id.gridView);

        ArrayList<String> items = new ArrayList<String>();

        items.add("drawable://" + R.drawable.img_animal_1);
        items.add("drawable://" + R.drawable.img_animal_2);
        items.add("drawable://" + R.drawable.img_animal_3);
        items.add("drawable://" + R.drawable.img_animal_4);
        items.add("drawable://" + R.drawable.img_animal_5);
        items.add("drawable://" + R.drawable.img_animal_6);
        items.add("drawable://" + R.drawable.img_animal_7);
        items.add("drawable://" + R.drawable.img_animal_8);
        items.add("drawable://" + R.drawable.img_animal_9);
        items.add("drawable://" + R.drawable.img_animal_10);
        items.add("drawable://" + R.drawable.img_animal_11);
        items.add("drawable://" + R.drawable.img_animal_12);
        items.add("drawable://" + R.drawable.img_animal_13);
        items.add("drawable://" + R.drawable.img_animal_14);
        items.add("drawable://" + R.drawable.img_animal_15);
        items.add("drawable://" + R.drawable.img_animal_16);
        items.add("drawable://" + R.drawable.img_animal_17);
        items.add("drawable://" + R.drawable.img_animal_18);
        items.add("drawable://" + R.drawable.img_animal_19);
        items.add("drawable://" + R.drawable.img_animal_20);
        items.add("drawable://" + R.drawable.img_animal_21);
        items.add("drawable://" + R.drawable.img_animal_22);
        items.add("drawable://" + R.drawable.img_animal_23);
        items.add("drawable://" + R.drawable.img_animal_24);
        items.add("drawable://" + R.drawable.img_animal_25);
        items.add("drawable://" + R.drawable.img_animal_26);
        items.add("drawable://" + R.drawable.img_animal_27);
        items.add("drawable://" + R.drawable.img_animal_28);
        items.add("drawable://" + R.drawable.img_animal_29);
        items.add("drawable://" + R.drawable.img_animal_30);
        items.add("drawable://" + R.drawable.img_animal_31);
        items.add("drawable://" + R.drawable.img_animal_32);
        items.add("drawable://" + R.drawable.img_animal_33);
        items.add("drawable://" + R.drawable.img_animal_34);
        items.add("drawable://" + R.drawable.img_animal_35);

        items.add("drawable://" + R.drawable.img_animal_1);

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
