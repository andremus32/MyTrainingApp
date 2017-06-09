package space.musatov.mytraining.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import space.musatov.mytraining.R;
import space.musatov.mytraining.model.Excersize;
import space.musatov.mytraining.model.ExcersizeList;
import space.musatov.mytraining.ui.dummy.DummyContent;

/**
 * Created by ANDREY MUSATOV on 31.05.2017.
 */

public class HerSportzalActivity extends AppCompatActivity{
    List<Excersize> excersizes;
    RecyclerView excersizesList;
    MyItemRecyclerViewAdapter adapter;
    HerExcersizesListFragment.OnListFragmentInteractionListener mListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_her_sportzal);

        excersizes = ExcersizeList.getInstance().getExcersizes();
        excersizesList = (RecyclerView)findViewById(R.id.workout2_list);
        mListener = new HerExcersizesListFragment.OnListFragmentInteractionListener() {
            @Override
            public void onListFragmentInteraction(DummyContent.DummyItem item) {

            }
        };
        adapter = new MyItemRecyclerViewAdapter(excersizes, mListener);

        excersizesList.setLayoutManager(new LinearLayoutManager(HerSportzalActivity.this));
        excersizesList.setAdapter(adapter);
    }

/*
    private class ExcersizeAdapter extends RecyclerView.Adapter<ExcersizeHolder>{
        List<Excersize> excersizes;

        public ExcersizeAdapter(List<Excersize> excersizes) {
            this.excersizes = excersizes;
        }

        @Override
        public ExcersizeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View excersizeItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.excersize_list_item, parent, false);

            return new ExcersizeHolder(excersizeItem);
        }

        @Override
        public void onBindViewHolder(final ExcersizeHolder holder, int position) {
            holder.excersizeName.setText(String.valueOf(excersizes.get(holder.getAdapterPosition()).getExcersizeType()));
            holder.excersizeCount.setText(String.valueOf(excersizes.get(holder.getAdapterPosition()).getExcersizeCount()));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (holder.getAdapterPosition())
                    {
                        case 0:
                            Toast.makeText(HerSportzalActivity.this, "button 1 clicked", Toast.LENGTH_SHORT).show();
                            //FragmentManager fm = getSupportFragmentManager();
                            //FragmentExsercizeActivity fea = new FragmentExsercizeActivity();
                            //fm.beginTransaction().replace(R.id.container, fea).commit();

                            break;
                        case 1:
                            Toast.makeText(HerSportzalActivity.this, "button 2 clicked", Toast.LENGTH_SHORT).show();
                            break;
                        case 2:
                            Toast.makeText(HerSportzalActivity.this, "button 3 clicked", Toast.LENGTH_SHORT).show();
                            break;
                        case 3:
                            Toast.makeText(HerSportzalActivity.this, "button 4 clicked", Toast.LENGTH_SHORT).show();
                            break;
                        case 4:
                            Toast.makeText(HerSportzalActivity.this, "button 5 clicked", Toast.LENGTH_SHORT).show();
                            break;
                        case 5:
                            Toast.makeText(HerSportzalActivity.this, "button 6 clicked", Toast.LENGTH_SHORT).show();
                            break;
                        case 6:
                            Toast.makeText(HerSportzalActivity.this, "button 7 clicked", Toast.LENGTH_SHORT).show();
                            break;
                        case 7:
                            Toast.makeText(HerSportzalActivity.this, "button 8 clicked", Toast.LENGTH_SHORT).show();
                            break;

                    }
                    //HisOfpActivity.startActivity(HerSportzalActivity.this, holder.getAdapterPosition());
                }
            });
        }

        @Override
        public int getItemCount() {
            if (excersizes != null){
                return excersizes.size();
            }
            else return 0;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(HerSportzalActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private class ExcersizeHolder extends RecyclerView.ViewHolder{
        TextView excersizeName;
        TextView excersizeCount;

        public ExcersizeHolder(View itemView) {
            super(itemView);
            excersizeName = (TextView) itemView.findViewById(R.id.excersizes_list_text_view);
            excersizeCount = (TextView) itemView.findViewById(R.id.excersizes_count_text_view);
        }
    }
*/

}
