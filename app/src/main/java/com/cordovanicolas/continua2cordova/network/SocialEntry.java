package com.cordovanicolas.continua2cordova.network;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.cordovanicolas.continua2cordova.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SocialEntry {

    private static final String TAG = SocialEntry.class.getSimpleName();

    public final String name;
    public final Uri dynamicUrl;
    public final String url;
    public final String description;

    public SocialEntry(String name, String dynamicUrl, String url, String description) {
        this.name = name;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
        this.description = description;
    }

    public static List<SocialEntry> initSocialEntryList(Resources resources) {
        InputStream inputStream = resources.openRawResource(R.raw.social);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int pointer;
            while ((pointer = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, pointer);
            }
        } catch (IOException exception) {
            Log.e(TAG, "Error writing/reading from the JSON file.", exception);
        } finally {
            try {
                inputStream.close();
            } catch (IOException exception) {
                Log.e(TAG, "Error closing the input stream.", exception);
            }
        }
        String jsonSocialString = writer.toString();
        Gson gson = new Gson();
        Type socialListType = new TypeToken<ArrayList<SocialEntry>>() {
        }.getType();
        return gson.fromJson(jsonSocialString, socialListType);
    }
}
