package at.ac.univie.reisefuehrer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;



public class HomeFragment extends Fragment {
    RelativeLayout category_museums;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_fragment,null);

        category_museums = view.findViewById(R.id.museums);
        LayoutInflater inflater1 = LayoutInflater.from(this.getActivity());
        View view1 =inflater1.inflate(R.layout.cat_museums,category_museums,false);
        ImageView im = view1.findViewById(R.id.albertina);
        im.setImageResource(R.mipmap.ic_launcher);
        category_museums.addView(view1);


        return view;
    }
}
