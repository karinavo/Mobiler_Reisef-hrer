package univie.travelguide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SightseeingProfile extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sightseeing_profile,null);
        TextView tv = view.findViewById(R.id.text_view);
        if(InfoSightseeing.information.containsKey(InfoSightseeing.flag_sightseeing)) {
            tv.setText(InfoSightseeing.information.get(InfoSightseeing.flag_sightseeing));
        }
        return view;
    }
}
