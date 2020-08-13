package com.example.programmer.tamperelinjat.recyclerviews.journeypattern;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.programmer.tamperelinjat.R;
import com.example.programmer.tamperelinjat.model.journeypattern.StopPoint;
import com.example.programmer.tamperelinjat.model.lines.Line;

import java.util.List;

import static android.support.v7.widget.RecyclerView.Adapter;
import static android.support.v7.widget.RecyclerView.ViewHolder;
import static android.view.View.OnClickListener;

/**
 * {@link Adapter} that can display a {@link Object} and makes a call to the
 * specified {@link StopsItemFragment.OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class StopsItemRecyclerViewAdapter extends Adapter<ViewHolder> {

    private final List<Object> mValues;
    private final StopsItemFragment.OnListFragmentInteractionListener mListener;
    private Object mItem;

    public StopsItemRecyclerViewAdapter(List<Object> items, StopsItemFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    private final int LINE_INFO = 0, STOP_POINT = 1;

    @Override
    public int getItemViewType(int position) {
        if (mValues.get(position) instanceof String) {
            return LINE_INFO;
        } else if (mValues.get(position) instanceof StopPoint) {
            return STOP_POINT;
        }
        return -1;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder viewHolder;
        switch (viewType) {
            case LINE_INFO:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.line_info_item, parent, false);
                viewHolder = new ViewHolderLineInfo(view);

                break;
            case STOP_POINT:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.stop_info_item, parent, false);
                viewHolder = new ViewHolderStopPointInfo(view);
                break;
            default:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.default_message_list_item, parent, false);
                viewHolder = new ViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        mItem = mValues.get(position);

        switch (getItemViewType(position)) {
            case LINE_INFO:
                ViewHolderLineInfo viewHolderLineInfo = (ViewHolderLineInfo) holder;
                configureLineInfoViewHolder(viewHolderLineInfo, position);
                break;
            case STOP_POINT:
                ViewHolderStopPointInfo viewHolderStopPointInfo = (ViewHolderStopPointInfo) holder;
                configureStopPointInfoViewHolder(viewHolderStopPointInfo, position);
                break;
            default:
                ViewHolder viewHolder = (ViewHolder) holder;
                configureDefaultViewHolder(viewHolder, position);
        }
    }

    private void configureLineInfoViewHolder(final ViewHolderLineInfo holder, int position) {
        holder.mItem = mValues.get(position);
        Line line = (Line) mValues.get(position);
        holder.mLineNameView.setText(line.getName());
        holder.mLineRefView.setText(line.getDescription());
       // holder.mStopLinesView.setText(stopPoint.getLinesString());  Todo
        holder.mView.setClickable(true);
        holder.mView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    Toast.makeText(v.getContext(), "line clicked", Toast.LENGTH_SHORT).show();
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    private void configureStopPointInfoViewHolder(final ViewHolderStopPointInfo holder, int position) {
        holder.mItem = mValues.get(position);
        com.example.programmer.tamperelinjat.model.journeypattern.StopPoint stopPoint = (com.example.programmer.tamperelinjat.model.journeypattern.StopPoint) mValues.get(position);
        holder.mStopCodeView.setText(stopPoint.getName() + ": " + stopPoint.getShortName());
        // holder.mStopLinesView.setText(stopPoint.getLinesString());  Todo
        holder.mView.setClickable(true);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    Toast.makeText(v.getContext(), "stop in lines clicked", Toast.LENGTH_SHORT).show();
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }



    private void configureDefaultViewHolder(ViewHolder holder, int position) {
        holder.mDefaultMessageView.setText("No available information");
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mDefaultMessageView;
        public Object mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mDefaultMessageView = (TextView) view.findViewById(R.id.txt_default_msg);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mDefaultMessageView.getText() + "'";
        }
    }

    public class ViewHolderLineInfo extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mLineRefView;
        public final TextView mLineNameView;
        public Object mItem;

        public ViewHolderLineInfo(View view) {
            super(view);

            mView = view;
            mLineRefView = (TextView) view.findViewById(R.id.txt_line_ref);
            mLineNameView = (TextView) view.findViewById(R.id.txt_line_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mLineRefView.getText() + ", " + mLineNameView.getText();
        }
    }

    public class ViewHolderStopPointInfo extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mStopCodeView;
        public Object mItem;

        public ViewHolderStopPointInfo(View view) {
            super(view);
            mView = view;
            mStopCodeView = (TextView) view.findViewById(R.id.txt_stop_info_name_and_code);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mStopCodeView.getText();
        }
    }
}