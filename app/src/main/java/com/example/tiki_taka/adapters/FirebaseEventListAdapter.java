package com.example.tiki_taka.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiki_taka.R;
import com.example.tiki_taka.ui.Event;
import com.example.tiki_taka.util.ItemTouchHelperAdapter;
import com.example.tiki_taka.util.OnStartDragListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;

public class FirebaseEventListAdapter extends FirebaseRecyclerAdapter<Event, FirebaseEventViewHolder> implements ItemTouchHelperAdapter {

    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;


    public FirebaseEventListAdapter(FirebaseRecyclerOptions<Event> options,
                                    DatabaseReference ref,
                                    OnStartDragListener onStartDragListener,
                                    Context context) {
        super(options);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;
    }



    @NonNull
    @Override
    public FirebaseEventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list_item_drag, parent, false);
        return new FirebaseEventViewHolder(view);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition){
        return false;
    }

    @Override
    public void onItemDismiss(int position){

    }

    @Override
    protected void onBindViewHolder(@NonNull FirebaseEventViewHolder viewHolder, int position, @NonNull Event model) {
        viewHolder.bindEvents(model);
        viewHolder.mImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                    mOnStartDragListener.onStartDrag(viewHolder);
                }
                return false;
            }
        });
    }
}
