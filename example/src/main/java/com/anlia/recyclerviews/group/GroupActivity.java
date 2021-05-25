package com.anlia.recyclerviews.group;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anlia.library.group.GroupItem;
import com.anlia.library.group.GroupItemClickListener;
import com.anlia.library.group.GroupItemDecoration;
import com.anlia.recyclerviews.GroupTestAdapter;
import com.anlia.recyclerviews.R;

import java.util.ArrayList;
import java.util.List;

public class GroupActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    private GroupTestAdapter groupTestAdapter;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        recyclerView =  findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        initData();
    }

    private void initData(){
        for (int i=0;i<30;i++){
            list.add(i+1+"");
        }

        groupTestAdapter = new GroupTestAdapter(this,list);
        recyclerView.setAdapter(groupTestAdapter);

        //开始使用GroupItemDecoration
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.item_group,null);
        GroupItemDecoration groupItemDecoration = new GroupItemDecoration(this, view, new GroupItemDecoration.DecorationCallback() {
            @Override
            public void setGroup(List<GroupItem> groupList) {
                //设置分组，例如：
                GroupItem groupItem;
                int startPosition = 0;
                for(int i=0;i<list.size();i++){
                    if(list.get(i).equals("10")){
                        groupItem = new GroupItem(0);
                        groupItem.setData("name","1-10");
                        groupList.add(groupItem);
                        startPosition=i+1;
                    }else if(list.get(i).equals("20")){
                        groupItem = new GroupItem(startPosition);
                        groupItem.setData("name","11-20");
                        groupItem.setData("imgId",R.drawable.ic_head);
                        groupList.add(groupItem);
                        startPosition=i+1;
                    }else if(list.get(i).equals("30")){
                        groupItem = new GroupItem(startPosition);
                        groupItem.setData("name","21-30");
                        groupList.add(groupItem);
                    }
                }
            }

            @Override
            public void buildGroupView(View groupView, GroupItem groupItem) {
                //构建GroupView，通过view.findViewById找到内部控件，例如
                TextView textName = (TextView) groupView.findViewById(R.id.text_name);
                textName.setText(groupItem.getData("name").toString());

                ImageView imageView = (ImageView) groupView.findViewById(R.id.img);
                if(groupItem.getData("name").equals("11-20")){
                    imageView.setImageDrawable(getResources().getDrawable((int)groupItem.getData("imgId")));
                }else {
                    imageView.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
                }
            }
        });
        recyclerView.addItemDecoration(groupItemDecoration);
//        recyclerView.addOnItemTouchListener(new GroupItemClickListener(groupItemDecoration,new GroupItemClickListener.OnGroupItemClickListener() {
//            @Override
//            public void onGroupItemClick(GroupItem groupItem) {
//                Toast.makeText(GroupActivity.this, "点击了Group:"+groupItem.getData("name"), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onGroupItemLongClick(GroupItem groupItem) {
//                Toast.makeText(GroupActivity.this, "长按了Group:"+groupItem.getData("name"), Toast.LENGTH_SHORT).show();
//            }
//        }));
    }
}
