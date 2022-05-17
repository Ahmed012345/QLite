package com.finallite.app.main.materialaboutlibrary.util;


import com.finallite.R;

public enum OpenSourceLicense {
    APACHE_2, MIT, GNU_GPL_3, BSD;

    public int getResourceId() {
        switch (this) {
            case APACHE_2:
                return R.string.license_apache2;
            case MIT:
                return R.string.license_mit;
            case GNU_GPL_3:
                return R.string.license_gpl;
            case BSD:
                return R.string.license_bsd;
            default:
                return -1;
        }
    }
}
