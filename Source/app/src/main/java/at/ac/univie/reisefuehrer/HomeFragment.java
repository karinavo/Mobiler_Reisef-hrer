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
import android.widget.ScrollView;



public class HomeFragment extends Fragment {
    LinearLayout category_museums;
    ScrollView bigScrollview;
    RelativeLayout relativeLayout;
    List<ImageView> images_museums = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_fragment,null);
        category_museums = view.findViewById(R.id.museums);
        LayoutInflater inflater1 = LayoutInflater.from(getActivity().getApplicationContext());
        View view1 =inflater1.inflate(R.layout.cat_museums,category_museums,false);
        //BILDER
        ImageView albertina = view1.findViewById(R.id.albertina);
        ImageView belvedere = view1.findViewById(R.id.belvedere);
        ImageView leopold = view1.findViewById(R.id.leopold);
        ImageView hunderwasser = view1.findViewById(R.id.hundertwasser);
        ImageView karlsplatz = view1.findViewById(R.id.albertina);
        ImageView mumok = view1.findViewById(R.id.belvedere);
        ImageView mak = view1.findViewById(R.id.leopold);
        ImageView kunsthistm = view1.findViewById(R.id.hundertwasser);

        images_museums.add(albertina);
        images_museums.add(belvedere);
        images_museums.add(leopold);
        images_museums.add(hunderwasser);
        images_museums.add(karlsplatz);
        images_museums.add(mumok);
        images_museums.add(mak);
        images_museums.add(kunsthistm);
       /* for(ImageView im : images_museums){
            im.setImageResource(R.mipmap.ic_launcher);
        }*/
        //albertina.setImageResource(R.mipmap.ic_launcher);
        //belvedere.setImageResource(R.mipmap.ic_launcher);
        category_museums.addView(view1);

        return view;
    }
}
