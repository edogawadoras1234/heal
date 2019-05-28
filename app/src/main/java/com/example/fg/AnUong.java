package com.example.fg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class AnUong extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable  ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_anuong, container, false);

        ImageView img = (ImageView) view.findViewById(R.id.tangcan);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(v);
            }
        });

        return view;
    }
    public void buttonClicked(View view){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.Nen, new TangCan());
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
