package com.anlia.recyclerviews;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.anlia.recyclerviews.group.GroupActivity;
import com.anlia.recyclerviews.group.SideGroupActivity;
import com.anlia.recyclerviews.header.TopProjectionActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickEvent(View view) {
    	switch (view.getId()) {
            case R.id.btn_group_default:
                startActivity(new Intent(this, GroupActivity.class));
                break;
            case R.id.btn_group_side:
                startActivity(new Intent(this, SideGroupActivity.class));
                break;
            case R.id.btn_top_projection:
                startActivity(new Intent(this, TopProjectionActivity.class));
                break;
    	}
    }
}
