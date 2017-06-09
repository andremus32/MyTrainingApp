package space.musatov.mytraining.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import space.musatov.mytraining.R;
import space.musatov.mytraining.model.Excersize;
import space.musatov.mytraining.ui.HerExcersizesListFragment.OnListFragmentInteractionListener;
import space.musatov.mytraining.ui.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    List<Excersize> excersizes;
    private final OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<Excersize> excersizes, OnListFragmentInteractionListener listener) {
        this.excersizes = excersizes;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.excersize_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.excersizeName.setText(String.valueOf(excersizes.get(holder.getAdapterPosition()).getExcersizeType()));
        holder.excersizeCount.setText(String.valueOf(excersizes.get(holder.getAdapterPosition()).getExcersizeCount()));

        holder.excersizeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return excersizes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView excersizeName;
        TextView excersizeCount;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            excersizeName = (TextView) itemView.findViewById(R.id.excersizes_list_text_view);
            excersizeCount = (TextView) itemView.findViewById(R.id.excersizes_count_text_view);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + excersizeName.getText() + "'";
        }
    }
}
