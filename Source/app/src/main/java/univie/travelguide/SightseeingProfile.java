package univie.travelguide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SightseeingProfile extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sightseeing_profile,null);
        TextView tv = view.findViewById(R.id.text_view);
        ImageView image_sightseeing = view.findViewById(R.id.imageView1);
        image_sightseeing.setImageResource(R.drawable.albertina);
        RadioGroup radioGroup = view .findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio1:

                        System.out.println("INFO");
                        break;
                    case R.id.radio2:
                        System.out.println("Opening Hours");
                        break;
                    case R.id.radio3:
                        System.out.println("REVIEWS");
                }
            }
        });
        return view;
    }
}
