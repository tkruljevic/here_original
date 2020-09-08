package tamara.myappcompany.here;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.tensorflow.lite.examples.detection.R;

public class StudentCardViewHolder extends RecyclerView.ViewHolder{

    private TextView StudentNameText = null;
    private TextView StudentNumberText = null;
    private ImageView StudentImageView = null;

    public StudentCardViewHolder(View itemView) {
        super(itemView);

        if(itemView != null)
        {
            StudentNameText = (TextView)itemView.findViewById(R.id.card_view_image_name);
            StudentNumberText = (TextView)itemView.findViewById(R.id.card_view_image_number);
            StudentImageView = (ImageView)itemView.findViewById(R.id.card_view_image);

//            itemView.setOnClickListener(this);
        }
    }

    public TextView getStudentNameText() {
        return StudentNameText;
    }

    public TextView getStudentNumberText() {
        return StudentNumberText;
    }

    public ImageView getStudentImageView() {
        return StudentImageView;
    }


//    public void onClick(View view) {
//        listener.onClick(itemView,getAdapterPosition());
//    }
}