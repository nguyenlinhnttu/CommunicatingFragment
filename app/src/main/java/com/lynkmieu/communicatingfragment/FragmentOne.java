package com.lynkmieu.communicatingfragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by LynkMieu on 6/3/2017.
 */

public class FragmentOne extends Fragment {
    OnSelectedListener mCallback;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Activity phải implement interface này
    public interface OnSelectedListener {
        public void onSelected(String value);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        ListView lvData = (ListView) view.findViewById(R.id.list_data);
        final String[] data = {"Linh","Kim","Minh","Khải"};
        lvData.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data));
        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = data[position];
                mCallback.onSelected(value);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (OnSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnSelectedListener");
        }
    }
}
