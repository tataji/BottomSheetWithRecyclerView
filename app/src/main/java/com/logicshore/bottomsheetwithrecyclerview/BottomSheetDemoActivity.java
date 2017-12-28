package com.logicshore.bottomsheetwithrecyclerview;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class BottomSheetDemoActivity extends AppCompatActivity {

    boolean bottomsheet_showed=false;
    BottomSheetBehavior bottomSheetBehavior;
    Button show_or_close_bt;
    RecyclerView recycler_view_demo;
    ReccyclerView_custom_adapter reccyclerView_custom_adapter;
    ArrayList<String> smaple_arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottomsheet_demo);

        //recycler view
        recycler_view_demo=(RecyclerView)findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager_criminals = new LinearLayoutManager(getApplicationContext());
        recycler_view_demo.setNestedScrollingEnabled(false);
        recycler_view_demo.setHasFixedSize(true);
        recycler_view_demo.setLayoutManager(mLayoutManager_criminals);
         //array list hard coded data
        smaple_arrayList=new ArrayList<>();
        smaple_arrayList.add("sample list item one");
        smaple_arrayList.add("sample list item two");
        smaple_arrayList.add("sample list item three");
        smaple_arrayList.add("sample list item four");
        smaple_arrayList.add("sample list item five");
        smaple_arrayList.add("sample list item 6");
        smaple_arrayList.add("sample list item 7");
        smaple_arrayList.add("sample list item 8");
        smaple_arrayList.add("sample list item 9");
        smaple_arrayList.add("sample list item 10");
        smaple_arrayList.add("sample list item 11");
        smaple_arrayList.add("sample list item 12");
        smaple_arrayList.add("sample list item 13");
        smaple_arrayList.add("sample list item 14");

        //recycler view custom adapter
        reccyclerView_custom_adapter = new ReccyclerView_custom_adapter(smaple_arrayList, BottomSheetDemoActivity.this);
        recycler_view_demo.setAdapter(reccyclerView_custom_adapter);

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
