package com.logicshore.bottomsheetwithrecyclerview;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BottomSheetDemoActivity extends AppCompatActivity {

    boolean bottomsheet_showed=false;
    BottomSheetBehavior bottomSheetBehavior;
    Button show_or_close_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottomsheet_demo);

        //bottom sheet
        final View bottomSheet = findViewById(R.id.bottom_sheet1);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        bottomSheetBehavior.setHideable(true);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        show_or_close_bt = (Button) findViewById(R.id.show_bottom_sheet);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if(newState== BottomSheetBehavior.STATE_HIDDEN){
                    show_or_close_bt.setText("SHOW");
                    bottomsheet_showed = false;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        show_or_close_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!bottomsheet_showed) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    bottomsheet_showed = true;
                    show_or_close_bt.setText("HIDE");
                }else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                    bottomsheet_showed = false;
                    show_or_close_bt.setText("SHOW");
                }
            }
        });
    }
}
