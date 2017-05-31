package de.feelberlin.android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import de.feelberlin.android.R;
import de.feelberlin.android.manager.FontsManager;

/**
 * Created by Apple on 5/27/17.
 */

public class FBButton extends android.support.v7.widget.AppCompatButton {

    public FBButton(Context context) {
        super(context);
        init();
    }

    public FBButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FBTextView, 0, 0);

        try {
            int font = a.getInt(R.styleable.FBTextView_font, 0);
            setFont(context, font);
        } finally {
            a.recycle();
        }

        init();
    }

    private void setFont(Context context, int font) {
        switch (font) {
            case 0:
                setTypeface(FontsManager.getInstance().getRegular(context));
                break;
            case 1:
                setTypeface(FontsManager.getInstance().getLight(context));
                break;
            case 2:
                setTypeface(FontsManager.getInstance().getUltralight(context));
                break;
            case 3:
                setTypeface(FontsManager.getInstance().getBold(context));
                break;
            case 4:
                setTypeface(FontsManager.getInstance().getSemibold(context));
                break;
            default:
                setTypeface(FontsManager.getInstance().getRegular(context));
                break;
        }
    }

    private void init() {

    }
}
