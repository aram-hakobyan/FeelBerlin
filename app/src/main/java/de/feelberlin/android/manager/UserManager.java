package de.feelberlin.android.manager;

import android.content.Context;

import de.feelberlin.android.util.AppUtils;

/**
 * Created by Aram_Hakobyan on 5/31/2017.
 */

public class UserManager {

    private UserManager() {
    }

    private static class HOLDER {
        private static final UserManager instance = new UserManager();
    }

    public static UserManager getInstance() {
        return HOLDER.instance;
    }

    private String UUID;

    public String getUUID(Context context) {
        if (UUID == null) {
            UUID = AppUtils.getAndroidId(context); // TODO: 5/31/2017 replace with device ID and handle permissions runtime check
        }
        return UUID;
    }
}
