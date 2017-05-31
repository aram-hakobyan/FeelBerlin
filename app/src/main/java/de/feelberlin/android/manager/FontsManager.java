package de.feelberlin.android.manager;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;

/**
 * Created by Aram_Hakobyan on 5/31/2017.
 */

public class FontsManager {

    public static String REGULAR = "fonts/Montserrat-Regular.otf";
    public static String LIGHT = "fonts/Montserrat-Light.otf";
    public static String ULTRALIGHT = "fonts/Montserrat-UltraLight.otf";
    public static String BOLD = "fonts/Montserrat-Bold.otf";
    public static String SEMIBOLD = "fonts/Montserrat-SemiBold.otf";

    private FontsManager() {
    }

    private static class HOLDER {
        private static final FontsManager instance = new FontsManager();
    }

    public static FontsManager getInstance() {
        return HOLDER.instance;
    }

    private Typeface regular, light, ultralight, bold, semibold;

    public void initFonts(Context context) {
        setDefaultFont(context, "DEFAULT", LIGHT);
    }

    public Typeface getRegular(Context context) {
        if (regular == null)
            regular = Typeface.createFromAsset(context.getAssets(), REGULAR);
        return regular;
    }

    public Typeface getLight(Context context) {
        if (light == null)
            light = Typeface.createFromAsset(context.getAssets(), LIGHT);
        return light;
    }

    public Typeface getUltralight(Context context) {
        if (ultralight == null)
            ultralight = Typeface.createFromAsset(context.getAssets(), ULTRALIGHT);
        return ultralight;
    }

    public Typeface getBold(Context context) {
        if (bold == null)
            bold = Typeface.createFromAsset(context.getAssets(), BOLD);
        return bold;
    }

    public Typeface getSemibold(Context context) {
        if (semibold == null)
            semibold = Typeface.createFromAsset(context.getAssets(), SEMIBOLD);
        return semibold;
    }

    public static void setDefaultFont(Context context,
                                      String staticTypefaceFieldName, String fontAssetName) {
        final Typeface regular = Typeface.createFromAsset(context.getAssets(),
                fontAssetName);
        replaceFont(staticTypefaceFieldName, regular);
    }

    protected static void replaceFont(String staticTypefaceFieldName,
                                      final Typeface newTypeface) {
        try {
            final Field staticField = Typeface.class
                    .getDeclaredField(staticTypefaceFieldName);
            staticField.setAccessible(true);
            staticField.set(null, newTypeface);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
