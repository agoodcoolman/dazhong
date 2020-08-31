package com.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class SearchIndexPromptResult extends BasicModel {
    public static final Parcelable.Creator<SearchIndexPromptResult> CREATOR;

    public static final c<SearchIndexPromptResult> l = new c<SearchIndexPromptResult>() {
        @Override
        public SearchIndexPromptResult[] createArray(int paramInt) {
            return new SearchIndexPromptResult[0];
        }

        @Override
        public SearchIndexPromptResult createInstance(int paramInt) {
            return null;
        }

        public SearchIndexPromptResult[] a(int param1Int) {
            return new SearchIndexPromptResult[param1Int];
        }

        public SearchIndexPromptResult b(int param1Int) {
            return (param1Int == 56072) ? new SearchIndexPromptResult() : new SearchIndexPromptResult(false);
        }
    };

    @SerializedName("url")
    public String a = "";

    @SerializedName("title")
    public String b = "";

    @SerializedName("biz_id")
    public String c = "";

    @SerializedName("titleColor")
    public String d = "";

    @SerializedName("fontSize")
    public int e = 0;

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

    @SerializedName("itemList")
    public SearchIndexPromptItem[] k = new SearchIndexPromptItem[0];

    static {
        CREATOR = new Parcelable.Creator<SearchIndexPromptResult>() {
            @Override
            public SearchIndexPromptResult createFromParcel(Parcel source) {
                return null;
            }

            @Override
            public SearchIndexPromptResult[] newArray(int size) {
                return new SearchIndexPromptResult[0];
            }

            public SearchIndexPromptResult a(Parcel param1Parcel) {
                SearchIndexPromptResult searchIndexPromptResult = new SearchIndexPromptResult();
                while (true) {
                    int i = param1Parcel.readInt();
                    if (i != -1) {
                        switch (i) {
                            default:
                                continue;
                            case 48026:
                                searchIndexPromptResult.d = param1Parcel.readString();
                                continue;
                            case 39034:
                                searchIndexPromptResult.k = (SearchIndexPromptItem[])param1Parcel.createTypedArray(SearchIndexPromptItem.CREATOR);
                                continue;
                            case 19790:
                                searchIndexPromptResult.a = param1Parcel.readString();
                                continue;
                            case 19476:
                                searchIndexPromptResult.j = param1Parcel.readString();
                                continue;
                            case 18299:
                                searchIndexPromptResult.h = param1Parcel.readString();
                                continue;
                            case 14057:
                                searchIndexPromptResult.b = param1Parcel.readString();
                                continue;
                            case 11687:
                                searchIndexPromptResult.f = param1Parcel.readString();
                                continue;
                            case 7952:
                                searchIndexPromptResult.i = param1Parcel.readString();
                                continue;
                            case 7821:
                                searchIndexPromptResult.g = param1Parcel.readString();
                                continue;
                            case 7349:
                                searchIndexPromptResult.e = param1Parcel.readInt();
                                continue;
                            case 5447:
                                searchIndexPromptResult.c = param1Parcel.readString();
                                continue;
                            case 2633:
                                break;
                        }
                        i = param1Parcel.readInt();
                        boolean bool = true;
                        if (i != 1)
                            bool = false;
                        searchIndexPromptResult.isPresent = bool;
                        continue;
                    }
                    return searchIndexPromptResult;
                }
            }

            public SearchIndexPromptResult[] a(int param1Int) {
                return new SearchIndexPromptResult[param1Int];
            }
        };
    }

    public SearchIndexPromptResult() {}

    public SearchIndexPromptResult(boolean paramBoolean) {}

    public void decode(e parame) throws a {
        while (true) {
            int i = parame.j();
            if (i > 0) {
                switch (i) {
                    default:
                        parame.i();
                        continue;
                    case 48026:
                        this.d = parame.g();
                        continue;
                    case 39034:
                        this.k = (SearchIndexPromptItem[])parame.b(SearchIndexPromptItem.l);
                        continue;
                    case 19790:
                        this.a = parame.g();
                        continue;
                    case 19476:
                        this.j = parame.g();
                        continue;
                    case 18299:
                        this.h = parame.g();
                        continue;
                    case 14057:
                        this.b = parame.g();
                        continue;
                    case 11687:
                        this.f = parame.g();
                        continue;
                    case 7952:
                        this.i = parame.g();
                        continue;
                    case 7821:
                        this.g = parame.g();
                        continue;
                    case 7349:
                        this.e = parame.c();
                        continue;
                    case 5447:
                        this.c = parame.g();
                        continue;
                    case 2633:
                        break;
                }
                this.isPresent = parame.b();
                continue;
            }
            break;
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }


}
