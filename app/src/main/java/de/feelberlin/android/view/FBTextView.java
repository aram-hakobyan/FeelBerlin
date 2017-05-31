package de.feelberlin.android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import de.feelberlin.android.R;
import de.feelberlin.android.manager.FontsManager;

public class FBTextView extends android.support.v7.widget.AppCompatTextView {

    public FBTextView(Context context) {
        super(context);
        init();
    }

    public FBTextView(Context context, AttributeSet attrs) {
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

    public FBTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }
}
