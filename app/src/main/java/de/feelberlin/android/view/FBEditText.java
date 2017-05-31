package de.feelberlin.android.view;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;


public class FBEditText extends AppCompatEditText {

    public FBEditText(Context context) {
        super(context);
    }

    public FBEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FBEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void onSuccess() {
        reset();
    }

    public void onFailure(String errorMessage) {
        reset();
        setError(errorMessage);
    }

    public void reset() {

    }

    public String getString() {
        if (getText() == null)
            return new String();
        return getText().toString();
    }
}