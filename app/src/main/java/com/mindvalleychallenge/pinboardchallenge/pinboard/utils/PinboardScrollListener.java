package com.mindvalleychallenge.pinboardchallenge.pinboard.utils;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * Created by MuhammadMahmoor on 8/17/17.
 */

public abstract class PinboardScrollListener extends RecyclerView.OnScrollListener {

    StaggeredGridLayoutManager layoutManager;

    public PinboardScrollListener(StaggeredGridLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int visibleItemCount = layoutManager.getChildCount();
        int totalItemCount = layoutManager.getItemCount();
        int[] firstVisibleItems = null;
        firstVisibleItems = layoutManager.findFirstVisibleItemPositions(firstVisibleItems);
        int firstVisibleItemPosition = 0;
        if(firstVisibleItems != null && firstVisibleItems.length > 0) {
            firstVisibleItemPosition = firstVisibleItems[0];
        }

        if (!isLoading() && !isLastPage()) {
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                    && firstVisibleItemPosition >= 0) {
                loadMoreItems();
            }
        }

    }

    protected abstract void loadMoreItems();

    public abstract int getTotalPageCount();

    public abstract boolean isLastPage();

    public abstract boolean isLoading();
}
