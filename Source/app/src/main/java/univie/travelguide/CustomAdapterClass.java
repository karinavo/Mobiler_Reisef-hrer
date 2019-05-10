package univie.travelguide;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterClass extends ArrayAdapter {

    private final Activity context;
    private final ArrayList<Integer> imageIDarray;
    private final ArrayList<String> nameArray;
    private final ArrayList<String> infoArray;


    public CustomAdapterClass(Activity context, ArrayList<String> nameArrayParam, ArrayList<String> infoArrayParam, ArrayList<Integer> imageIDArrayParam){

        super(context,R.layout.row_list_view_tour , nameArrayParam);

        this.context = context;
        this.imageIDarray = imageIDArrayParam;
        this.nameArray = nameArrayParam;
        this.infoArray = infoArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent) {
        System.out.println("aaaaa");


        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.row_list_view_tour, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = rowView.findViewById(R.id.tv_title);
        TextView infoTextField = rowView.findViewById(R.id.tv_description);
        ImageView imageView = rowView.findViewById(R.id.image_view_row);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(nameArray.get(position));
        infoTextField.setText(infoArray.get(position));
        imageView.setImageResource(imageIDarray.get(position));

        return rowView;

    };
}
