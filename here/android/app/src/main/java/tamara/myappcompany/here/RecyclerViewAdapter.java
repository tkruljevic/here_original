package tamara.myappcompany.here;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.tensorflow.lite.examples.detection.R;

import java.util.List;

/**
 * Adapter used to show a simple grid of products.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.StudentCardViewHolder> {

    private List<StudentRecyclerViewItem> studentList;
//    //private ImageRequester imageRequester;
//
    public RecyclerViewClickListener listener;

    public RecyclerViewAdapter(List<StudentRecyclerViewItem> studentList, RecyclerViewClickListener listener) {
        this.studentList = studentList;
        this.listener = listener;
    }

    public class StudentCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView nameImg;
        private TextView nameTxt;
        private TextView nameTxt2;

        public StudentCardViewHolder(final View view){
            super(view);
            nameImg = view.findViewById(R.id.card_view_image);
            nameTxt = view.findViewById(R.id.card_view_image_name);
            nameTxt2 = view.findViewById(R.id.card_view_image_number);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.StudentCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View studentCardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.courses_grid_fragment_item, parent, false);
//
//        final TextView studentNameView = (TextView) studentCardView.findViewById(R.id.card_view_image_name);
//        final TextView studentNumberView = (TextView) studentCardView.findViewById(R.id.card_view_image_number);
//        final ImageView studentImageView = (ImageView) studentCardView.findViewById(R.id.card_view_image);
//
////        // When click the image.
////        studentImageView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////                String studentName = studentNameView.getText().toString();
////
////                Snackbar snackbar = Snackbar.make(studentImageView, "You click " + studentName +" image", Snackbar.LENGTH_LONG);
////                snackbar.show();
////            }
////        });
//
//        StudentCardViewHolder ret = new StudentCardViewHolder(studentCardView);
//        return ret;
        return new StudentCardViewHolder(studentCardView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.StudentCardViewHolder holder, int position) {
//
//        int image = studentList.get(position).getStudentImageId();
//        String name = studentList.get(position).getStudentName();
//        String number = studentList.get(position).getStudentNumber();
//
//        holder.nameImg.setImageResource(image);
//        holder.nameTxt.setText(name);
//        holder.nameTxt2.setText(number);
        if(studentList!=null) {
            StudentRecyclerViewItem studentItem = studentList.get(position);

            if(studentItem != null) {
                holder.nameTxt.setText(studentItem.getStudentName());
                holder.nameTxt2.setText(studentItem.getStudentNumber());
                holder.nameImg.setImageResource(studentItem.getStudentImageId());
                }
            }
        }



    @Override
    public int getItemCount() {
        int ret = 0;
        if(studentList!=null)
        {
            ret = studentList.size();
        }
        return ret;

    }

    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }


}