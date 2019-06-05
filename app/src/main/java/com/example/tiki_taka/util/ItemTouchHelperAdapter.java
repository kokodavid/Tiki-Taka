package com.example.tiki_taka.util;

    public interface ItemTouchHelperAdapter {
        boolean onItemMove(int fromPosition, int toPosition);
        void onItemDismiss(int position);
    }

