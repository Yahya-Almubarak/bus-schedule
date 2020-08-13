package com.example.programmer.tamperelinjat.recyclerviews.lines;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.programmer.tamperelinjat.R;
import com.example.programmer.tamperelinjat.model.lines.Line;
import com.example.programmer.tamperelinjat.model.routes.Route;

import java.util.List;

import static android.support.v7.widget.RecyclerView.Adapter;
import static android.support.v7.widget.RecyclerView.ViewHolder;
import static android.view.View.OnClickListener;

/**
 * {@link Adapter} that can display a {@link Object} and makes a call to the
 * specified {@link LinesItemFragment.OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class LinesItemRecyclerViewAdapter extends Adapter<ViewHolder> {

    private final List<Object> mValues;
    private final LinesItemFragment.OnListFragmentInteractionListener mListener;
    private Object mItem;

    public LinesItemRecyclerViewAdapter(List<Object> items, LinesItemFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    private final int LINE_INFO = 0, LINE_GROUP = 1, ROUTE = 2;

    @Override
    public int getItemViewType(int position) {
        if (mValues.get(position) instanceof Line) {
            return LINE_INFO;
        } else if (mValues.get(position) instanceof LinesGroup) {
            return LINE_GROUP;
        } else if (mValues.get(position) instanceof Route){
            return ROUTE;
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
            case LINE_GROUP:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.lines_group_info_item, parent, false);
                viewHolder = new ViewHolderLinesGroup(view);
                break;
            case ROUTE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.lines_route_item, parent, false);
                viewHolder = new ViewHolderLinesRoute(view);
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
            case LINE_GROUP:
                ViewHolderLinesGroup viewHolderLinesGroup = (ViewHolderLinesGroup) holder;
                configureLinesGroupViewHolder(viewHolderLinesGroup, position);
                break;
            case ROUTE:
                ViewHolderLinesRoute viewHolderLinesRoute = (ViewHolderLinesRoute) holder;
                configureLinesRouteViewHolder(viewHolderLinesRoute, position);
                break;
            default:
                ViewHolder viewHolder = (ViewHolder) holder;
                configureDefaultViewHolder(viewHolder, position);
        }
    }

    private void configureLineInfoViewHolder(final ViewHolderLineInfo holder, final int position) {
        holder.mItem = mValues.get(position);
        Line line = (Line) mValues.get(position);
        holder.mLineNameView.setText(line.getDescription());
        holder.mLineRefView.setText(line.getName());
       // holder.mStopLinesView.setText(stopPoint.getLinesString());  Todo
        holder.mView.setClickable(true);
        holder.mView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    Toast.makeText(v.getContext(), "line info clicked", Toast.LENGTH_SHORT).show();
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem, position);
                }
            }
        });
    }

    private void configureLinesRouteViewHolder(final ViewHolderLinesRoute holder, final int position) {
        holder.mItem = mValues.get(position);
        Route route = (Route) mValues.get(position);
        holder.mLinesRouteView.setText(route.getName());
        // holder.mStopLinesView.setText(stopPoint.getLinesString());  Todo
        holder.mView.setClickable(true);
        holder.mView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    Toast.makeText(v.getContext(), "lines route clicked", Toast.LENGTH_SHORT).show();
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem, position);
                }
            }
        });
    }

    private void configureLinesGroupViewHolder(final ViewHolderLinesGroup holder, final int position) {
        holder.mItem = mValues.get(position);
        LinesGroup group = (LinesGroup) mValues.get(position);
        holder.mFavouriteImageView.setVisibility(View.GONE);
        holder.mHistoryImageView.setVisibility(View.GONE);
        holder.mNearbyStopsImageView.setVisibility(View.GONE);
        holder.mAllImageView.setVisibility(View.GONE);
        if (group == LinesGroup.FAVOURITE){ // it is from favourite
            holder.mFavouriteImageView.setVisibility(View.VISIBLE);
            holder.mGroupNameView.setText("Lines From Favourite");
        } else if (group == LinesGroup.HISTORY){ // it is from nearby stops
            holder.mHistoryImageView.setVisibility(View.VISIBLE);
            holder.mGroupNameView.setText("Lines From History");
        } else if (group == LinesGroup.BUS_STOP){ // it is from history
            holder.mNearbyStopsImageView.setVisibility(View.VISIBLE);
            holder.mGroupNameView.setText("Lines From Nearby Stops");
        } else { // it is from all
            holder.mAllImageView.setVisibility(View.VISIBLE);
            holder.mGroupNameView.setText("All lines");
        }

        holder.mView.setClickable(true);
        holder.mView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem, position);
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

    public class ViewHolderLinesRoute extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mLinesRouteView;
        public Object mItem;

        public ViewHolderLinesRoute(View view) {
            super(view);

            mView = view;
            mLinesRouteView = (TextView) view.findViewById(R.id.txt_lines_route_name);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mLinesRouteView.getText();
        }
    }

    public class ViewHolderLinesGroup extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mFavouriteImageView;
        public final ImageView mNearbyStopsImageView;
        public final ImageView mHistoryImageView;
        public final ImageView mAllImageView;
        public final TextView mGroupNameView;
        public Object mItem;

        public ViewHolderLinesGroup(View view) {
            super(view);

            mView = view;
            mFavouriteImageView = (ImageView) view.findViewById(R.id.img_lines_group_favourite);
            mNearbyStopsImageView = (ImageView) view.findViewById(R.id.img_lines_group_bus_stop);
            mHistoryImageView = (ImageView) view.findViewById(R.id.img_lines_group_history);
            mAllImageView = (ImageView) view.findViewById(R.id.img_lines_group_all);
            mGroupNameView = (TextView) view.findViewById(R.id.txt_lines_group_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mGroupNameView.getText();
        }
    }
}