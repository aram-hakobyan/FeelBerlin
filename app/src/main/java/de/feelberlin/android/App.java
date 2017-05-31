package de.feelberlin.android;

import android.app.Application;

import de.feelberlin.android.manager.FontsManager;

/**
 * Created by Aram_Hakobyan on 5/31/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FontsManager.getInstance().initFonts(getApplicationContext());
    }

}
