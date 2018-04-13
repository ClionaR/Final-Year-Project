package com.example.cliona.backend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by User on 2/28/2017.
 */

public class OtherFragment extends Fragment {
    private static final String TAG = "OtherFragment";

    private Button adopt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adopt_other,container,false);

        adopt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "email adopt@dspca.ie for more details",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}

