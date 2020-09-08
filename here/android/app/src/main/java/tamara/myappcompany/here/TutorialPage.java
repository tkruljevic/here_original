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

public class TutorialPage extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(null);
        setContentView(R.layout.tutorial_page);

        Intent course1_button = getIntent();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        toolbar.setNavigationOnClickListener(new NavigationIconClickListener(
                TutorialPage.this,
                findViewById(R.id.tutorial_container),
                new AccelerateDecelerateInterpolator()));

        //navigate to class1
        MaterialButton course1button = (MaterialButton) findViewById(R.id.course1_button);

        course1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_C1) {
                navCourse1();
            }
        });

        //navigate to settings
        MaterialButton settingsbutton = (MaterialButton) findViewById(R.id.settings_button);

        settingsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_C1) {
                navSettings();
            }
        });
    }

    private void navCourse1(){
        Intent course1_button = new Intent(TutorialPage.this, CoursesGridFragment.class);
        startActivity(course1_button); // brings up the next activity
    }

    private void navSettings(){
        Intent settings_button = new Intent(TutorialPage.this, Settings_Page.class);
        startActivity(settings_button); // brings up the next activity
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu )
    {
        getMenuInflater().inflate( R.menu.toolbar_menu, menu );
        return true;
    }
}