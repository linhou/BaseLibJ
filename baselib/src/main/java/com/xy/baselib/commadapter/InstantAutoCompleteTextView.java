package com.xy.baselib.commadapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.AutoCompleteTextView;



@SuppressLint("AppCompatCustomView")
public class InstantAutoCompleteTextView extends AutoCompleteTextView  {


    public InstantAutoCompleteTextView(Context context) {
        super(context);

    }

    public InstantAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InstantAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    public boolean enoughToFilter() {
        return true;
    }


    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused && getAdapter() != null) {
            performFiltering(getText(), KeyEvent.KEYCODE_UNKNOWN);
        }
    }
}
