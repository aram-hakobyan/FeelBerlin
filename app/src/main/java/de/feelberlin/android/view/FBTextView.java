package de.feelberlin.android.view;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Apple on 5/27/17.
 */

public class FBTextView extends android.support.v7.widget.AppCompatTextView {

    public FBTextView(Context context) {
        super(context);
        init();
    }

    public FBTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FBTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }
}
