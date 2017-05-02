package com.example.bikramkoju.newdesigncode;

import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bikramkoju on 5/2/2017.
 */

public class TypeB extends Fragment {
    private GridView gridView;
    private GridViewAdapter gridViewAdapter;

    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    TextView result;
    long sum;

    public TypeB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        sharedPreferences = this.getActivity().getSharedPreferences("values", 0);
        editor = sharedPreferences.edit();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_typeb, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        result = (TextView) view.findViewById(R.id.resultb);
        gridView = (GridView) view.findViewById(R.id.gridViewb);
        gridViewAdapter = new GridViewAdapter(getActivity(), R.layout.grid_item_layout2, getData());
        gridView.setAdapter(gridViewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);
                long value = Long.parseLong(item.getTitle());
                sum = sum - value;
                result.setText(String.valueOf(sum));
            }
        });
    }

    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();

        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        TypedArray nums = getResources().obtainTypedArray(R.array.numbers);

        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));

            String vlue = nums.getString(i);

            imageItems.add(new ImageItem(bitmap, vlue));
        }
        return imageItems;
    }
}
