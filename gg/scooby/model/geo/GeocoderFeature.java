package ru.gg.scooby.model.geo;

import com.google.gson.p141a.C1687c;
import io.card.payment.BuildConfig;
import p042b.C0724k;
import p042b.p047e.p049b.C0700j;
import p042b.p053i.C0721e;
import p042b.p053i.C4773o;

/* compiled from: GeocoderFeature.kt */
public final class GeocoderFeature {
    private final Double[] center;
    @C1687c(a = "place_name")
    private String placeName;
    public String subTitle;
    @C1687c(a = "text")
    private final String text;
    public String title;

    public GeocoderFeature(Double[] dArr, String str, String str2) {
        C0700j.m2715b(dArr, "center");
        C0700j.m2715b(str, "text");
        this.center = dArr;
        this.text = str;
        this.placeName = str2;
    }

    public final Double[] getCenter() {
        return this.center;
    }

    public final String getText() {
        return this.text;
    }

    public final String getPlaceName() {
        return this.placeName;
    }

    public final void setPlaceName(String str) {
        this.placeName = str;
    }

    public final double getLatitude() {
        return this.center[1].doubleValue();
    }

    public final double getLongitude() {
        return this.center[0].doubleValue();
    }

    public final String getTitle() {
        String str = this.title;
        if (str == null) {
            C0700j.m2716b("title");
        }
        return str;
    }

    public final void setTitle(String str) {
        C0700j.m2715b(str, "<set-?>");
        this.title = str;
    }

    public final String getSubTitle() {
        String str = this.subTitle;
        if (str == null) {
            C0700j.m2716b("subTitle");
        }
        return str;
    }

    public final void setSubTitle(String str) {
        C0700j.m2715b(str, "<set-?>");
        this.subTitle = str;
    }

    public final void postInit() {
        this.title = new C0721e("\\s+").m2743a(this.text, " ");
        String str = this.placeName;
        if (str != null) {
            str = new C0721e("\\s+").m2743a(str, " ");
        } else {
            str = null;
        }
        this.placeName = str;
        this.subTitle = createSubtitle();
    }

    private final String createSubtitle() {
        Object obj;
        String str;
        String stringBuilder;
        int a;
        String str2;
        int length;
        CharSequence charSequence = this.placeName;
        if (charSequence != null) {
            if (charSequence.length() != 0) {
                obj = null;
                if (obj != null) {
                    return BuildConfig.FLAVOR;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                str = this.title;
                if (str == null) {
                    C0700j.m2716b("title");
                }
                stringBuilder2.append(str);
                stringBuilder2.append(", ");
                stringBuilder = stringBuilder2.toString();
                str = this.placeName;
                if (str == null) {
                    C0700j.m2709a();
                }
                a = C4773o.m22215a((CharSequence) str, stringBuilder, 0, false, 6, null);
                if (a < 0) {
                    str2 = this.placeName;
                    if (str2 == null) {
                        C0700j.m2709a();
                    }
                    length = stringBuilder.length() + a;
                    if (str2 != null) {
                        return C4773o.m22223a((CharSequence) str2, a, length).toString();
                    }
                    throw new C0724k("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String str3;
                str = this.placeName;
                if (str == null) {
                    C0700j.m2709a();
                }
                CharSequence charSequence2 = str;
                str3 = this.title;
                if (str3 == null) {
                    C0700j.m2716b("title");
                }
                a = C4773o.m22215a(charSequence2, str3, 0, false, 6, null);
                if (a < 0) {
                    str2 = this.placeName;
                    if (str2 == null) {
                        C0700j.m2709a();
                    }
                    length = stringBuilder.length() + a;
                    if (str2 != null) {
                        return C4773o.m22223a((CharSequence) str2, a, length).toString();
                    }
                    throw new C0724k("null cannot be cast to non-null type kotlin.CharSequence");
                }
                stringBuilder = this.placeName;
                if (stringBuilder == null) {
                    C0700j.m2709a();
                }
                return stringBuilder;
            }
        }
        obj = 1;
        if (obj != null) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder stringBuilder22 = new StringBuilder();
        str = this.title;
        if (str == null) {
            C0700j.m2716b("title");
        }
        stringBuilder22.append(str);
        stringBuilder22.append(", ");
        stringBuilder = stringBuilder22.toString();
        str = this.placeName;
        if (str == null) {
            C0700j.m2709a();
        }
        a = C4773o.m22215a((CharSequence) str, stringBuilder, 0, false, 6, null);
        if (a < 0) {
            str = this.placeName;
            if (str == null) {
                C0700j.m2709a();
            }
            CharSequence charSequence22 = str;
            str3 = this.title;
            if (str3 == null) {
                C0700j.m2716b("title");
            }
            a = C4773o.m22215a(charSequence22, str3, 0, false, 6, null);
            if (a < 0) {
                stringBuilder = this.placeName;
                if (stringBuilder == null) {
                    C0700j.m2709a();
                }
                return stringBuilder;
            }
            str2 = this.placeName;
            if (str2 == null) {
                C0700j.m2709a();
            }
            length = stringBuilder.length() + a;
            if (str2 != null) {
                return C4773o.m22223a((CharSequence) str2, a, length).toString();
            }
            throw new C0724k("null cannot be cast to non-null type kotlin.CharSequence");
        }
        str2 = this.placeName;
        if (str2 == null) {
            C0700j.m2709a();
        }
        length = stringBuilder.length() + a;
        if (str2 != null) {
            return C4773o.m22223a((CharSequence) str2, a, length).toString();
        }
        throw new C0724k("null cannot be cast to non-null type kotlin.CharSequence");
    }
}
