package tamara.myappcompany.here;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import org.tensorflow.lite.examples.detection.R;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CoursesGridFragment extends AppCompatActivity {

    public List<StudentRecyclerViewItem> studentList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(null);
        setContentView(R.layout.courses_grid_fragment);

        Intent course1_button = getIntent();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        //toolbar.inflateMenu(R.menu.toolbar_menu);


        toolbar.setNavigationOnClickListener(new NavigationIconClickListener(
                CoursesGridFragment.this,
                findViewById(R.id.c1_container),
                new AccelerateDecelerateInterpolator()));

        //navigate to settings
        MaterialButton settingsbutton = (MaterialButton) findViewById(R.id.settings_button);

        settingsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_C1) {
                navSettings();
            }
        });

//        //export to excel
//        MaterialButton exportButton = (MaterialButton) findViewById(R.id.export_button);
//
//        exportButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view_export) {
//                export();
//            }
//        });



        // Set up the RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        initializeStudentList();
        setAdapter();

//        String new_name = "Student name not set";
//        String numb = "Student number not set";
//        int photo = 0;
//        Boolean newphoto = false;
//
//        addnewstudent(new_name, numb, photo, newphoto);






        //studentList.add(new StudentRecyclerViewItem("Tom Holland","Peter Parker", R.drawable.c1_tom_holland));
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

//        Object instance = new Constuctor().methodCall();






//        String firstElement = null;
//        if (!studentList.isEmpty() && studentList.size() > 0) {
//            firstElement = studentList.get(0);
//        }

    }

    public void export(View view) {
        //generate data
        StringBuilder data = new StringBuilder();
        data.append(" Date" + ","+ "Robert Downey Jr,Chris Evans,Chris Hemsworth, Mark Ruffalo, Jeremy Renner, Scarlett Johansson, Chadwick Boseman, Tom Holland");
        data.append("\n" + "01/09/2020, Yes, Yes, , , Yes, , Yes, ");
        data.append("\n" + "02/09/2020, Yes, , , , Yes, , Yes, ");
        data.append("\n" + "03/09/2020, Yes, , , , Yes, , Yes, ");
        data.append("\n" + "04/09/2020, , Yes, Yes, , , , Yes, ");
        data.append("\n" + "05/09/2020, , , , , , , , ");
        data.append("\n" + "06/09/2020, , , , , , , , ");
        data.append("\n" + "07/09/2020, , Yes, Yes, , Yes, , Yes, ");
        data.append("\n" + "08/09/2020, , Yes,Yes, , Yes, , Yes, ");
//        data.append(" Date" + ","+ String.valueOf(studentList));
//        for(int i = 1; i<=studentList.size(); i++){
//            data.append("\n"+String.valueOf(studentList) + "," + String.valueOf(attended));
//        }

        try {
            //saving the file into the device
            FileOutputStream out = openFileOutput("data.csv", Context.MODE_PRIVATE);
            out.write(data.toString().getBytes());
            out.close();

            //exporting
            Context context = getApplicationContext();
            File filelocation = new File(getFilesDir(), "data.csv");
            Uri path = FileProvider.getUriForFile(context,"tamara.myappcompany.here.fileprovider",filelocation);
            Intent fileIntent = new Intent(Intent.ACTION_SEND);
            fileIntent.setType("text/csv");
            fileIntent.putExtra(Intent.EXTRA_SUBJECT, "Data");
            fileIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            fileIntent.putExtra(Intent.EXTRA_STREAM, path);
            startActivity(Intent.createChooser(fileIntent, "Send mail"));
        }

        catch (Exception e){
            e.printStackTrace();
        }

    }

    private void navSettings(){
        Intent settings_button = new Intent(CoursesGridFragment.this, Settings_Page.class);
        startActivity(settings_button); // brings up the next activity
    }


    private void setAdapter() {
        setOnClickListener();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(studentList, listener);


        recyclerView.setLayoutManager(new GridLayoutManager(CoursesGridFragment.this, 2, GridLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
//
//        setOnClickListener();
//        RecyclerViewAdapter courseDataAdapter = new RecyclerViewAdapter(studentList, listener);
//        recyclerView.setAdapter(courseDataAdapter);

        int largePadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small);
        recyclerView.addItemDecoration(new StudentGridItemDecoration(largePadding, smallPadding));
    }

    private void setOnClickListener() {
        listener = new RecyclerViewAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                intent.putExtra("StudentName", studentList.get(position).getStudentName());
                intent.putExtra("StudentNumber",studentList.get(position).getStudentNumber());
                intent.putExtra("StudentImageID",studentList.get(position).getStudentImageId());
                startActivity(intent);
            }
        };
    }
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

    public boolean addStudent(StudentRecyclerViewItem newStudent) {
        studentList.add(newStudent);
        return true;
    }

    public void initializeStudentList(){
        addStudent(new StudentRecyclerViewItem("Robert Downey Jr","Tony Stark", R.drawable.c1_robert_downey));
        addStudent(new StudentRecyclerViewItem("Chris Evans", "Steve Rogers", R.drawable.c1_chris_evans));
        addStudent(new StudentRecyclerViewItem("Chris Hemsworth","Thor", R.drawable.c1_chris_hemsworth));
        addStudent(new StudentRecyclerViewItem("Mark Ruffalo","Bruce Banner", R.drawable.c1_mark_ruffalo));
        addStudent(new StudentRecyclerViewItem("Jeremy Renner","Clint Barton", R.drawable.c1_jeremy_renner));
        addStudent(new StudentRecyclerViewItem("Scarlett Johansson","Natasha Romanoff", R.drawable.c1_scarlett_johansson));
        addStudent(new StudentRecyclerViewItem("Chadwick Boseman","T'Challa", R.drawable.c1_chadwick_boseman));
        addStudent(new StudentRecyclerViewItem("Tom Holland","Peter Parker", R.drawable.c1_tom_holland));
    }

//    /* Initialise student items in list. */
//    public boolean initializeStudentList()
//    {
//
////        if(studentList == null)
////        {
////            studentList = new ArrayList<>();
//            studentList.add(new StudentRecyclerViewItem("Robert Downey Jr","Tony Stark",R.drawable.c1_robert_downey));
//            studentList.add(new StudentRecyclerViewItem("Chris Evans", "Steve Rogers",R.drawable.c1_chris_evans));
//            studentList.add(new StudentRecyclerViewItem("Chris Hemsworth","Thor", R.drawable.c1_chris_hemsworth));
//            studentList.add(new StudentRecyclerViewItem("Mark Ruffalo","Bruce Banner", R.drawable.c1_mark_ruffalo));
//            studentList.add(new StudentRecyclerViewItem("Jeremy Renner","Clint Barton", R.drawable.c1_jeremy_renner));
//            studentList.add(new StudentRecyclerViewItem("Scarlett Johansson","Natasha Romanoff", R.drawable.c1_scarlett_johansson));
//            studentList.add(new StudentRecyclerViewItem("Chadwick Boseman","T'Challa", R.drawable.c1_chadwick_boseman));
//            studentList.add(new StudentRecyclerViewItem("Tom Holland","Peter Parker", R.drawable.c1_tom_holland));
////        }
//
//
//
//        return true;
//
//    }
//
//    public boolean addnewstudent(String new_name,String numb,int photo, Boolean newphoto){
//
//        if (newphoto) {
//            studentList.add(new StudentRecyclerViewItem(new_name,numb, photo));
//        }
//
//        return true;
//
//    }

}


//attendanceList = new ArrayList<>();
//attendanceList =