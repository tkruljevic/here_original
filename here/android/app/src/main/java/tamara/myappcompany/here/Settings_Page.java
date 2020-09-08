package tamara.myappcompany.here;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;

import org.tensorflow.lite.examples.detection.R;

public class Settings_Page extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(null);
        setContentView(R.layout.settings_page);

        Intent course1_button = getIntent();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        //toolbar.inflateMenu(R.menu.toolbar_menu);


        toolbar.setNavigationOnClickListener(new NavigationIconClickListener(
                Settings_Page.this,
                findViewById(R.id.settings_container),
                new AccelerateDecelerateInterpolator()));

        //navigate to class1
        MaterialButton course1button = (MaterialButton) findViewById(R.id.course1_button);

        course1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_C1) {
                navCourse1();
            }
        });

        //navigate to about page
        MaterialButton aboutbutton = (MaterialButton) findViewById(R.id.about_button);

        aboutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_about) {
                navAbout();
            }
        });

        //navigate to tutorial page
        MaterialButton tutorialbutton = (MaterialButton) findViewById(R.id.tutorial_button);

        tutorialbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_about) {
                navTutorial();
            }
        });

//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new GridLayoutManager(CoursesGridFragment.this, 2, GridLayoutManager.VERTICAL, false));
//        recyclerView.setAdapter(adapter);
////
////        setOnClickListener();
////        RecyclerViewAdapter courseDataAdapter = new RecyclerViewAdapter(studentList, listener);
////        recyclerView.setAdapter(courseDataAdapter);
//
//        int largePadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing);
//        int smallPadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small);
//        recyclerView.addItemDecoration(new StudentGridItemDecoration(largePadding, smallPadding));



    }

    private void navCourse1(){
        Intent course1_button = new Intent(Settings_Page.this, CoursesGridFragment.class);
        startActivity(course1_button); // brings up the next activity
    }

    private void navAbout(){
        Intent about_button = new Intent(Settings_Page.this, About_Page.class);
        startActivity(about_button); // brings up the next activity
    }

    private void navTutorial(){
        Intent tutorial_button = new Intent(Settings_Page.this, TutorialPage.class);
        startActivity(tutorial_button); // brings up the next activity
    }


//        setOnClickListener();
//        RecyclerViewAdapter courseDataAdapter = new RecyclerViewAdapter(studentList, listener);
//        recyclerView.setAdapter(courseDataAdapter);

//
//    private void setOnClickListener() {
//        listener = new RecyclerViewAdapter.RecyclerViewClickListener() {
//            @Override
//            public void onClick(View v, int position) {
//                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
//                intent.putExtra("name", studentList.get(position).getStudentName());
//                intent.putExtra("number",studentList.get(position).getStudentNumber());
//                startActivity(intent);
//            }
//        };
//    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu )
    {
        getMenuInflater().inflate( R.menu.toolbar_menu, menu );
        return true;
    }


}