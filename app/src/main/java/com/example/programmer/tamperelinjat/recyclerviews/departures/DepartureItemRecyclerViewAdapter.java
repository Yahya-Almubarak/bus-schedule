package com.example.programmer.tamperelinjat.recyclerviews.departures;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.programmer.tamperelinjat.R;
import com.example.programmer.tamperelinjat.model.stoppoint.StopPoint;

import java.util.List;

import static android.support.v7.widget.RecyclerView.*;

/**
 * {@link Adapter} that can display a {@link Object} and makes a call to the
 * specified {@link DepartureItemFragment.OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class DepartureItemRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Object> mValues;
    private final DepartureItemFragment.OnListFragmentInteractionListener mListener;
    private Object mItem;

    public DepartureItemRecyclerViewAdapter(List<Object> items, DepartureItemFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    private final int STOP_POINT = 0, DEPARTURE = 1, NO_DEPARTURE = 2, LINK = 3;

    @Override
    public int getItemViewType(int position) {
        if (mValues.get(position) instanceof StopPoint) {
            return STOP_POINT;
        } else if (mValues.get(position) instanceof Departure) {
            return DEPARTURE;
        } else if (mValues.get(position) instanceof NoDeparture) {
            return NO_DEPARTURE;
        } else if (mValues.get(position) instanceof Link) {
            return LINK;
        }
        return -1;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder viewHolder;
        switch (viewType) {
            case STOP_POINT:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.stop_info_item, parent, false);
                viewHolder = new ViewHolderStopPointInfo(view);

                break;
            case DEPARTURE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.departure_info_item, parent, false);
                viewHolder = new ViewHolderDepartureInfo(view);
                break;
            case NO_DEPARTURE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.departure_no_departure_item, parent, false);
                viewHolder = new ViewHolderNoDepartureInfo(view);
                break;
            case LINK:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.departure_link_item, parent,  false);
                viewHolder = new ViewHolderLinkInfo(view);
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
            case STOP_POINT:
                ViewHolderStopPointInfo viewHolderStopInfo = (ViewHolderStopPointInfo) holder;
                configureStopPointInfoViewHolder(viewHolderStopInfo, position);
                break;
            case DEPARTURE:
                ViewHolderDepartureInfo viewHolderDepartureInfo = (ViewHolderDepartureInfo) holder;
                configureDepartureInfoViewHolder(viewHolderDepartureInfo, position);
                break;
            case NO_DEPARTURE:
                ViewHolderNoDepartureInfo viewHolderLineInfo = (ViewHolderNoDepartureInfo) holder;
                configureNoDepartureViewHolder(viewHolderLineInfo, position);
                break;
            case LINK:
                ViewHolderLinkInfo viewHolderLineStopInfo = (ViewHolderLinkInfo) holder;
                configureLinkInfoViewHolder(viewHolderLineStopInfo, position);
                break;
            default:
                ViewHolder viewHolder = (ViewHolder) holder;
                configureDefaultViewHolder(viewHolder, position);
        }
    }

    private void configureStopPointInfoViewHolder(final ViewHolderStopPointInfo holder, int position) {
        holder.mItem = mValues.get(position);
        StopPoint stopPoint = (StopPoint) mValues.get(position);
        holder.mStopCodeView.setText(stopPoint.getName() + ": " + stopPoint.getShortName());
       // holder.mStopLinesView.setText(stopPoint.getLinesString());  Todo
        holder.mView.setClickable(true);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    Toast.makeText(v.getContext(), "stop clicked", Toast.LENGTH_SHORT).show();
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    private void configureDepartureInfoViewHolder(final ViewHolderDepartureInfo holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mLineView.setText(((Departure) mValues.get(position)).getLine());
        holder.mHeadSignView.setText(((Departure) mValues.get(position)).getHeadSign());
        holder.mDepartureTimeView.setText(((Departure) mValues.get(position)).getArrivalTime());
        holder.mView.setClickable(true);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    Toast.makeText(v.getContext(), "Line clicked", Toast.LENGTH_SHORT).show();
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });

    }

    private void configureNoDepartureViewHolder(final ViewHolderNoDepartureInfo holder, int position) {
        holder.mItem = mValues.get(position);
        String message = (String) mValues.get(position);
        holder.mMessageView.setText(message);
        holder.mView.setClickable(true);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    Toast.makeText(v.getContext(), "lineInfo clicked", Toast.LENGTH_SHORT).show();
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    private void configureLinkInfoViewHolder(final ViewHolderLinkInfo holder, int position) {
        holder.mItem = mValues.get(position);
        String link = (String) mValues.get(position);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    Toast.makeText(v.getContext(), "lineInfo clicked", Toast.LENGTH_SHORT).show();
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

    public class ViewHolderStopPointInfo extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mStopCodeView;
        public final TextView mStopLinesView;
        public Object mItem;

        public ViewHolderStopPointInfo(View view) {
            super(view);
            mView = view;
            mStopCodeView = (TextView) view.findViewById(R.id.txt_stop_info_name_and_code);
            mStopLinesView = (TextView) view.findViewById(R.id.txt_stop_info_lines);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mStopCodeView.getText() + ", " + mStopLinesView.getText() + "'";
        }
    }

    public class ViewHolderDepartureInfo extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mLineView;
        public final TextView mHeadSignView;
        public final TextView mDepartureTimeView;
        public Object mItem;

        public ViewHolderDepartureInfo(View view) {
            super(view);

            mView = view;
            mLineView = (TextView) view.findViewById(R.id.txt_departure_line);
            mHeadSignView = (TextView) view.findViewById(R.id.txt_departure_head_sign);
            mDepartureTimeView = (TextView) view.findViewById(R.id.txt_departure_time);
        }


        @Override
        public String toString() {
            return super.toString() + " '" + mLineView.getText() + ", " + mHeadSignView.getText() +
                    ", " + mDepartureTimeView + "'";
        }
    }

    public class ViewHolderNoDepartureInfo extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mWarningSignView;
        public final TextView mMessageView;
        public Object mItem;

        public ViewHolderNoDepartureInfo(View view) {
            super(view);

            mView = view;
            mWarningSignView = (ImageView) view.findViewById(R.id.img_no_departure_error);
            mMessageView = (TextView) view.findViewById(R.id.txt_no_departure_msg);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mMessageView.getText();
        }
    }

    public class ViewHolderLinkInfo extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTimetableLinkView;
        public Object mItem;

        public ViewHolderLinkInfo(View view) {
            super(view);

            mView = view;
            mTimetableLinkView = (TextView) view.findViewById(R.id.txt_timetable_link_msg);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTimetableLinkView.getText();
        }
    }
}