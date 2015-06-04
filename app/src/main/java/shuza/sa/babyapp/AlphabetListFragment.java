package shuza.sa.babyapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class AlphabetListFragment extends Fragment implements AbsListView.OnScrollListener {

    GridView gridView;
    PhotoListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo_list, container, false);
        gridView = (GridView) view.findViewById(R.id.gridView);

        ArrayList<String> items = new ArrayList<String>();

        items.add("drawable://" + R.drawable.img_alphabet_1);
        items.add("drawable://" + R.drawable.img_alphabet_2);
        items.add("drawable://" + R.drawable.img_alphabet_3);
        items.add("drawable://" + R.drawable.img_alphabet_4);
        items.add("drawable://" + R.drawable.img_alphabet_5);
        items.add("drawable://" + R.drawable.img_alphabet_6);
        items.add("drawable://" + R.drawable.img_alphabet_7);
        items.add("drawable://" + R.drawable.img_alphabet_8);
        items.add("drawable://" + R.drawable.img_alphabet_9);
        items.add("drawable://" + R.drawable.img_alphabet_10);

        items.add("drawable://" + R.drawable.img_alphabet_11);
        items.add("drawable://" + R.drawable.img_alphabet_12);
        items.add("drawable://" + R.drawable.img_alphabet_13);
        items.add("drawable://" + R.drawable.img_alphabet_14);
        items.add("drawable://" + R.drawable.img_alphabet_15);
        items.add("drawable://" + R.drawable.img_alphabet_16);
        items.add("drawable://" + R.drawable.img_alphabet_17);
        items.add("drawable://" + R.drawable.img_alphabet_18);
        items.add("drawable://" + R.drawable.img_alphabet_19);
        items.add("drawable://" + R.drawable.img_alphabet_20);

        items.add("drawable://" + R.drawable.img_alphabet_21);
        items.add("drawable://" + R.drawable.img_alphabet_22);
        items.add("drawable://" + R.drawable.img_alphabet_23);
        items.add("drawable://" + R.drawable.img_alphabet_24);
        items.add("drawable://" + R.drawable.img_alphabet_25);
        items.add("drawable://" + R.drawable.img_alphabet_26);

        items.add("drawable://" + R.drawable.img_alphabet_1);


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
