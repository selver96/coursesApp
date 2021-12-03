package com.example.e_ticaret.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.e_ticaret.R;
import com.example.e_ticaret.model.Course;
import com.example.e_ticaret.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    ListView orders_list;
    List<String> coursesTitle = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);
        orders_list = findViewById(R.id.orders_list);

        for(Course c : MainActivity.fullCoursesList){
            if(Order.itemsId.contains(c.getId())){
                coursesTitle.add(c.getTitle());
            }
        }

        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coursesTitle));
    }
}