package space.musatov.mytraining.ui;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import space.musatov.mytraining.R;

/**
 * Created by LENOVO on 02.06.2017.
 */

public class FragmentExsercizeActivity extends Fragment {

    private ImageView excersizeImage;
    private TextView excersizeDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_excersize, container, false);

        excersizeImage = (ImageView) root.findViewById(R.id.excersize_image_container);
        excersizeDescription = (TextView) root.findViewById(R.id.excersize_text_container);

        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

}
