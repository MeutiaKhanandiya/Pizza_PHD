package com.meutia.myapplication.Activities;

import android.os.Parcel;
import android.os.Parcelable;

public class OrderActivity implements Parcelable {
    public static final int PEPPERONI_PIZZA = 0;
    public static final int VEGGIE_PIZZA = 1;
    public static final int SPLITZA_PIZZA = 2;
    public static final int SPLITZA_CLASSIC_PIZZA = 3;
    public static final int HAWAIIAN_PIZZA = 4;

    private String nama;
    private int type;
    private int satuan;
    private int jumlah;

    public String getNama() {
        return nama;
    }

    public int getType() {
        return type;
    }

    public int getSatuan() {
        return satuan;
    }


    public OrderActivity(String nama, int type, int satuan) {
        this.nama = nama;
        this.type = type;
        this.satuan = satuan;
        this.jumlah = calculate();
    }

    protected OrderActivity(Parcel in) {
        nama = in.readString();
        type = in.readInt();
        satuan = in.readInt();
        jumlah = in.readInt();
    }

    public static final Creator<OrderActivity> CREATOR = new Creator<OrderActivity>() {
        @Override
        public OrderActivity createFromParcel(Parcel in) {
            return new OrderActivity(in);
        }

        @Override
        public OrderActivity[] newArray(int size) {
            return new OrderActivity[size];
        }
    };

    public int getJumlah() {
        return jumlah;
    }

    private int calculate() {
        switch (type) {
            case PEPPERONI_PIZZA:
                return satuan * 84000;
            case VEGGIE_PIZZA:
                return satuan * 84000;
            case SPLITZA_PIZZA:
                return satuan * 88000;
            case SPLITZA_CLASSIC_PIZZA:
                return satuan * 78000;
            case HAWAIIAN_PIZZA:
                return satuan * 74000;
            default:
                return 0;
        }
    }


    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeInt(type);
        parcel.writeInt(satuan);
        parcel.writeInt(jumlah);
    }
}