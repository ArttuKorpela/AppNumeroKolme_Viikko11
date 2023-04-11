package com.example.appnumerokolme_viikko11;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;

public class Purchase {
    String name;
    String reminder;
    LocalDateTime time;

    @RequiresApi(api = Build.VERSION_CODES.O)
    Purchase(String name, String reminder) {
        this.name = name;
        this.reminder = reminder;
        this.time = LocalDateTime.now();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public String getName() {
        return name;
    }

    public String getReminder() {
        return reminder;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
