package univie.travelguide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SightseeingProfile extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sightseeing_profile,null);

        final TextView tv = view.findViewById(R.id.text_view);
        final ImageView image_sightseeing = view.findViewById(R.id.imageView1);
        RadioGroup radioGroup = view .findViewById(R.id.radio_group);
        image_sightseeing.setImageResource(Variables.sightseeingWithFoto.get(Variables.getSightseeingList().get(Variables.itemPosition)));
        tv.setText(Variables.sightseeingDescription.get(Variables.getDesription().get(Variables.itemPosition)));
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio1:
                        image_sightseeing.setImageResource(Variables.sightseeingWithFoto.get(Variables.getSightseeingList().get(Variables.itemPosition)));
                        tv.setText(Variables.sightseeingDescription.get(Variables.getDesription().get(Variables.itemPosition)));
                        break;
                    case R.id.radio2:
                        image_sightseeing.setImageResource(Variables.sightseeingWithFoto.get(Variables.getSightseeingList().get(Variables.itemPosition)));
                        tv.setText(Variables.sightseeingopenhours.get(Variables.getHours().get(Variables.itemPosition)));
                        break;
                    case R.id.radio3:
                        System.out.println("REVIEWS");
                }
            }
        });

        final CheckBox checkBox = view.findViewById(R.id.likeIcon);

        if(Variables.favouriteSightseeings.contains(Variables.itemPosition)){
            checkBox.setChecked(true);
        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Variables.favouriteSightseeings.add(Variables.itemPosition);
                }
                if(!isChecked){
                    Variables.favouriteSightseeings.remove(Variables.itemPosition);
                    System.out.println(Variables.favouriteSightseeings);
                }
            }
        });




        return view;
    }
}
