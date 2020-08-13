package com.example.programmer.tamperelinjat.recyclerviews.detailedline;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.programmer.tamperelinjat.R;
import com.example.programmer.tamperelinjat.model.detailedvehicleactivity.VehicleActivity;
import com.example.programmer.tamperelinjat.model.journeys.Call;
import com.example.programmer.tamperelinjat.recyclerviews.departures.DepartureItemFragment;

import java.util.List;

import static android.support.v7.widget.RecyclerView.Adapter;
import static android.view.View.OnClickListener;
import static android.support.v7.widget.RecyclerView.ViewHolder;

/**
 * {@link Adapter} that can display a {@link Object} and makes a call to the
 * specified {@link DepartureItemFragment.OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class LineItemRecyclerViewAdapter extends Adapter<ViewHolder> {

    private final List<Object> mValues;
    private final LineItemFragment.OnListFragmentInteractionListener mListener;
    private Object mItem;

    public LineItemRecyclerViewAdapter(List<Object> items, LineItemFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    private final int LINE_INFO = 0, CALL = 1;

    @Override
    public int getItemViewType(int position) {
        if (mValues.get(position) instanceof VehicleActivity) {
            return LINE_INFO;
        } else if (mValues.get(position) instanceof Call) {
            return CALL;
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
            case CALL:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.line_call_info_item, parent, false);
                viewHolder = new ViewHolderCallInfo(view);
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
            case CALL:
                ViewHolderCallInfo viewHolderCallInfo = (ViewHolderCallInfo) holder;
                configureCallInfoViewHolder(viewHolderCallInfo, position);
                break;
            default:
                ViewHolder viewHolder = (ViewHolder) holder;
                configureDefaultViewHolder(viewHolder, position);
        }
    }

    private void configureLineInfoViewHolder(final ViewHolderLineInfo holder, int position) {
        holder.mItem = mValues.get(position);
        VehicleActivity vehicleActivity = (VehicleActivity) mValues.get(position);
        holder.mLineNameView.setText(vehicleActivity.getMonitoredVehicleJourney().getLineRef());
        holder.mLineRefView.setText(vehicleActivity.getMonitoredVehicleJourney().getDestinationShortName());
       // holder.mStopLinesView.setText(stopPoint.getLinesString());  Todo
        holder.mView.setClickable(true);
        holder.mView.setOnClickListener(new OnClickListener() {
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

    private void configureCallInfoViewHolder(final ViewHolderCallInfo holder, int position) {
        holder.mItem = mValues.get(position);
        Call call = (Call) mValues.get(position);
        holder.mRouteStartBusstopImageView.setVisibility(View.GONE);
        holder.mRouteEndBusstopImageView.setVisibility(View.GONE);
        holder.mRouteInBetweenBusstopImageView.setVisibility(View.GONE);
        if (position == 1){ // it is first Call
            holder.mRouteStartBusstopImageView.setVisibility(View.VISIBLE);
        } else if (position == mValues.size() -1){ // last Call
            holder.mRouteEndBusstopImageView.setVisibility(View.VISIBLE);
        } else {
            holder.mRouteInBetweenBusstopImageView.setVisibility(View.VISIBLE);
        }

        holder.mLineCallCodeView.setText(call.getStopPoint().getName());
        holder.mLineCallNameView.setText(call.getStopPoint().getShortName());
        holder.mLineCallTimeView.setText(call.getArrivalTime());
        holder.mView.setClickable(true);
        holder.mView.setOnClickListener(new OnClickListener() {
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

    public class ViewHolderCallInfo extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mRouteStartBusstopImageView;
        public final ImageView mRouteInBetweenBusstopImageView;
        public final ImageView mRouteEndBusstopImageView;
        public final TextView mLineCallCodeView;
        public final TextView mLineCallNameView;
        public final TextView mLineCallTimeView;
        public Object mItem;

        public ViewHolderCallInfo(View view) {
            super(view);

            mView = view;
            mRouteStartBusstopImageView = (ImageView) view.findViewById(R.id.route_line_image_start);
            mRouteInBetweenBusstopImageView = (ImageView) view.findViewById(R.id.route_line_image_in_between);
            mRouteEndBusstopImageView = (ImageView) view.findViewById(R.id.route_line_image_end);
            mLineCallNameView = (TextView) view.findViewById(R.id.txt_line_call_name);
            mLineCallCodeView = (TextView) view.findViewById(R.id.txt_line_call_code);
            mLineCallTimeView = (TextView) view.findViewById(R.id.txt_line_call_time);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mLineCallCodeView.getText() + ", " + mLineCallNameView.getText();
        }
    }
}