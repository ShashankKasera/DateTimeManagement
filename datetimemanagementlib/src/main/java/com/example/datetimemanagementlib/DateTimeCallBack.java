package com.example.datetimemanagementlib;

import java.sql.Timestamp;

public interface DateTimeCallBack {

    void callBack(int year, int manth, int day, int hour, int minute, Timestamp ts);
}
