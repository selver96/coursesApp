package com.example.e_ticaret.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e_ticaret.R;
import com.example.e_ticaret.adapter.CategoryAdapter;
import com.example.e_ticaret.adapter.CourseAdapter;
import com.example.e_ticaret.model.Category;
import com.example.e_ticaret.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> coursesList = new ArrayList<>();
    static List<Course> fullCoursesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Game"));
        categoryList.add(new Category(2, "Web"));
        categoryList.add(new Category(3, "Lang"));
        categoryList.add(new Category(4, "Other"));
        setCategoryRecycler(categoryList);

        coursesList.add(new Course(1, "java", "JAVA", "1 October", "Advance","black","erweb w tewt wetewt wtwe twt w w", 1));
        coursesList.add(new Course(2, "java", "PYTHON", "2 October", "Advance","yellow"," wtwe tet ww t wt wtw twt",1));
        coursesList.add(new Course(3, "java", "C#", "3 October", "Advance","blue"," twt et wtw twt wt wt wt tw t",1));
        coursesList.add(new Course(4, "java", "C++", "4 October", "Advance","green","w twtewtw twet wtw weewtwet wtw",2));
        coursesList.add(new Course(3, "java", "JAVA", "3 October", "Advance","blue"," twt et wtw twt wt wt wt tw t",2));
        coursesList.add(new Course(4, "java", "JAVA", "4 October", "Advance","green","w twtewtw twet wtw weewtwet wtw",3));
        coursesList.add(new Course(3, "java", "JAVA", "3 October", "Advance","blue"," twt et wtw twt wt wt wt tw t",3));
        coursesList.add(new Course(4, "java", "JAVA", "4 October", "Advance","green","w twtewtw twet wtw weewtwet wtw",4));
        fullCoursesList.addAll(coursesList);
        setCourseRecycler(coursesList);
    }

    private void setCourseRecycler(List<Course> coursesList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);
        courseAdapter = new CourseAdapter(this,coursesList);
        courseRecycler.setAdapter(courseAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    public void showAllCourses(View view){
        coursesList.clear();
        coursesList.addAll(fullCoursesList);
        courseAdapter.notifyDataSetChanged();
    }

    public static void showCoursesByCategory(int category){
        coursesList.clear();
        coursesList.addAll(fullCoursesList);
        List<Course> filterCourses = new ArrayList<>();
        for(Course c : coursesList){
            if(c.getCategory() == category){
               filterCourses.add(c);
            }
        }
        coursesList.clear();
        coursesList.addAll(filterCourses);
        courseAdapter.notifyDataSetChanged();
    }

    public void openShoppingCard(View view){
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);
    }
}