package com.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.dianping.archive.c;
import com.google.gson.annotations.SerializedName;

public class SearchIndexPromptItem extends BasicModel {
    public static final Parcelable.Creator<SearchIndexPromptItem> CREATOR = new Parcelable.Creator<SearchIndexPromptItem>() {
        /* renamed from: a */
        public SearchIndexPromptItem createFromParcel(Parcel parcel) {
            SearchIndexPromptItem searchIndexPromptItem = new SearchIndexPromptItem();
            while (true) {
                int readInt = parcel.readInt();
                if (readInt != -1) {
                    switch (readInt) {
                        case 2633:
                            boolean z = true;
                            if (parcel.readInt() != 1) {
                                z = false;
                            }
                            searchIndexPromptItem.isPresent = z;
                            break;
                        case 7952:
                            searchIndexPromptItem.i = parcel.readString();
                            break;
                        case 9420:
                            searchIndexPromptItem.b = parcel.readString();
                            break;
                        case 14095:
                            searchIndexPromptItem.f = parcel.readString();
                            break;
                        case 16076:
                            searchIndexPromptItem.g = parcel.readString();
                            break;
                        case 18260:
                            searchIndexPromptItem.d = parcel.readString();
                            break;
                        case 19476:
                            searchIndexPromptItem.j = parcel.readString();
                            break;
                        case 34840:
                            searchIndexPromptItem.c = parcel.readString();
                            break;
                        case 41611:
                            searchIndexPromptItem.k = parcel.readString();
                            break;
                        case 46394:
                            searchIndexPromptItem.e = parcel.readString();
                            break;
                        case 49051:
                            searchIndexPromptItem.h = parcel.readString();
                            break;
                        case 50542:
                            searchIndexPromptItem.a = parcel.readString();
                            break;
                    }
                } else {
                    return searchIndexPromptItem;
                }
            }
        }

        /* renamed from: a */
        public SearchIndexPromptItem[] newArray(int i) {
            return new SearchIndexPromptItem[i];
        }
    };
    public static final com.dianping.archive.c<SearchIndexPromptItem> l = new c<SearchIndexPromptItem>() {
        /* renamed from: a */
        public SearchIndexPromptItem[] createArray(int i) {
            return new SearchIndexPromptItem[i];
        }

        /* renamed from: b */
        public SearchIndexPromptItem createInstance(int i) {
            if (i == 6618) {
                return new SearchIndexPromptItem();
            }
            return new SearchIndexPromptItem(false);
        }
    };
    @SerializedName("url")
    public String a = "";
    @SerializedName("title")
    public String b = "";
    @SerializedName("bizId")
    public String c = "";
    @SerializedName("titleColor")
    public String d = "";
    @SerializedName("fontSize")
    public String e = "";
    @SerializedName("queryId")
    public String f = "";
    @SerializedName("searchKeyword")
    public String g = "";
    @SerializedName("tag")
    public String h = "";
    @SerializedName("feedback")
    public String i = "";
    @SerializedName("userMode")
    public String j = "";
    @SerializedName("source")
    public String k = "";


    public void decode(e eVar) throws a {
        while (true) {
            int j2 = eVar.j();
            if (j2 > 0) {
                switch (j2) {
                    case 2633:
                        this.isPresent = eVar.b();
                        break;
                    case 7952:
                        this.i = eVar.g();
                        break;
                    case 9420:
                        this.b = eVar.g();
                        break;
                    case 14095:
                        this.f = eVar.g();
                        break;
                    case 16076:
                        this.g = eVar.g();
                        break;
                    case 18260:
                        this.d = eVar.g();
                        break;
                    case 19476:
                        this.j = eVar.g();
                        break;
                    case 34840:
                        this.c = eVar.g();
                        break;
                    case 41611:
                        this.k = eVar.g();
                        break;
                    case 46394:
                        this.e = eVar.g();
                        break;
                    case 49051:
                        this.h = eVar.g();
                        break;
                    case 50542:
                        this.a = eVar.g();
                        break;
                    default:
                        eVar.i();
                        break;
                }
            } else {
                return;
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(2633);
        parcel.writeInt(this.isPresent ? 1 : 0);
        parcel.writeInt(41611);
        parcel.writeString(this.k);
        parcel.writeInt(19476);
        parcel.writeString(this.j);
        parcel.writeInt(7952);
        parcel.writeString(this.i);
        parcel.writeInt(49051);
        parcel.writeString(this.h);
        parcel.writeInt(16076);
        parcel.writeString(this.g);
        parcel.writeInt(14095);
        parcel.writeString(this.f);
        parcel.writeInt(46394);
        parcel.writeString(this.e);
        parcel.writeInt(18260);
        parcel.writeString(this.d);
        parcel.writeInt(34840);
        parcel.writeString(this.c);
        parcel.writeInt(9420);
        parcel.writeString(this.b);
        parcel.writeInt(50542);
        parcel.writeString(this.a);
        parcel.writeInt(-1);
    }

    public SearchIndexPromptItem() {
        this.isPresent = true;
    }

    public SearchIndexPromptItem(boolean z) {
        this.isPresent = z;
    }
}
