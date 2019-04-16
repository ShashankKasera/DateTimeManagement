package com.example.datetimemanagementlib;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.sql.Timestamp;
import java.util.Date;

public class DateTimeManagement {

    public static void datetimemanagement(final DateTimeCallBack dateTime){

        FirebaseDatabase.getInstance().getReference()
                .child("Time")
                .child("timestamp")
                .setValue(ServerValue.TIMESTAMP)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        FirebaseDatabase.getInstance().getReference()
                                .child("Time")
                                .child("timestamp")
                                .addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                        Log.i("nngk", "onDataChange: ");
                                        long datetimeL=dataSnapshot.getValue(Long.class);

                                        Timestamp ts=new Timestamp(datetimeL);
                                        Date date=ts;
                                        String s = date.toString();

                                        Log.i("dfnf", "onDataChange: "+s);

                                        String DateTime[] = s.split(" ");

                                        String Date = DateTime[0];

                                        String DETE[] = Date.split("-");

                                        int year = Integer.parseInt(DETE[0]);
                                        int manth = Integer.parseInt(DETE[1]);
                                        int day = Integer.parseInt(DETE[2]);

                                        String Time = DateTime[1];

                                        String TIME[] = Time.split(":");

                                        int hour = Integer.parseInt(TIME[0]);
                                        int minute = Integer.parseInt(TIME[1]);

                                        Log.i("nkkjn", "onDataChange: year "+year);
                                        Log.i("nkkjn", "onDataChange: manth "+manth);
                                        Log.i("nkkjn", "onDataChange: day "+day);
                                        Log.i("nkkjn", "onDataChange: hour "+hour);
                                        Log.i("nkkjn", "onDataChange: minute "+minute);

                                        dateTime.callBack(year,manth,day,hour,minute,ts);
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }


                                });

                    }
                });
    }
}
