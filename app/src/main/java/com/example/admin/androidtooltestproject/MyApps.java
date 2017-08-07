package com.example.admin.androidtooltestproject;

/**
 * Created by Admin on 8/5/2017.
 */

public class MyApps {

    String appName, description, authorName, appImage;


    public MyApps() {
    }

    public MyApps(String appName, String description, String authorName, String appImage) {
        this.appName = appName;
        this.description = description;
        this.authorName = authorName;
        this.appImage = appImage;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAppImage() {
        return appImage;
    }

    public void setAppImage(String appImage) {
        this.appImage = appImage;
    }
}
