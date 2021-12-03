package com.example.e_ticaret.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_ticaret.R;
import com.example.e_ticaret.model.Order;

public class ContentPage extends AppCompatActivity {

    ConstraintLayout courseBg;
    ImageView courseImg;
    TextView courseTitle, courseDate, courseLevel, courseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_page);

        courseBg = findViewById(R.id.coursePageBg);
        courseImg = findViewById(R.id.coursePageImage);
        courseTitle = findViewById(R.id.coursePageTitle);
        courseDate = findViewById(R.id.coursePageDate);
        courseLevel = findViewById(R.id.coursePageLevel);
        courseText = findViewById(R.id.coursePageDescription);


        courseBg.setBackgroundColor(getIntent().getIntExtra("courseBg",0));
        courseImg.setImageResource(getIntent().getIntExtra("courseImage",0));
        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        courseDate.setText(getIntent().getStringExtra("courseDate"));
        courseLevel.setText(getIntent().getStringExtra("courseLevel"));
        courseText.setText(getIntent().getStringExtra("courseText"));

    }

    public void addToCart(View view){
        int item_id = getIntent().getIntExtra("courseId", 0);
        Order.itemsId.add(item_id);
        Toast.makeText(this, "Added To Card!", Toast.LENGTH_LONG).show();
    }
}