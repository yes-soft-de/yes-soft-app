package de.yessoft.android.mohammad.generators;

import android.os.Bundle;

public class BundleGenerator {

    public Bundle generateBundle(String key, String content){
        Bundle bundle = new Bundle();

        bundle.putString(key, content);

        return bundle;
    }
}
