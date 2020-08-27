package com.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class BasicModel implements Parcelable {

    public static final Parcelable.Creator<BasicModel> CREATOR;

    static Gson gson = (new GsonBuilder()).setPrettyPrinting().serializeSpecialFloatingPointValues().create();

    @SerializedName("isPresent")
    public boolean isPresent;

    static {
        CREATOR = new Parcelable.Creator<BasicModel>() {
            public BasicModel a(Parcel param1Parcel) {
                return new BasicModel(param1Parcel);
            }

            public BasicModel[] a(int param1Int) {
                return new BasicModel[param1Int];
            }
        };
    }

    protected BasicModel() {}

    protected BasicModel(Parcel paramParcel) {}

    public void appendJson(StringBuilder paramStringBuilder) {}

    public void decode(e parame) throws a {}

    public int describeContents() {
        return 0;
    }

    public String toJson() {
        return gson.toJson(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {}

    static {
        b.a("e37a3b86c611eab61d13600cab314bca");
    }
}
