package ru.gg.scooby.network;

import io.p181b.C4050f;
import p165d.p168c.C2307f;
import p165d.p168c.C2320s;
import p165d.p168c.C2321t;
import ru.gg.scooby.BuildConfig;
import ru.gg.scooby.model.geo.GeocoderResponse;

/* compiled from: GeocoderManager.kt */
public interface GeocoderService {

    /* compiled from: GeocoderManager.kt */
    public static final class DefaultImpls {
        @C2307f(a = "/geocoding/v5/mapbox.places/{query}.json")
        public static /* synthetic */ C4050f geocode$default(GeocoderService geocoderService, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if (obj == null) {
                return geocoderService.geocode(str, (i & 2) != null ? null : str2, (i & 4) != null ? BuildConfig.MAPBOX_API_KEY : str3, (i & 8) != null ? "ru" : str4, (i & 16) != null ? "ru" : str5, (i & 32) != null ? "country,region,district,place,locality,neighborhood,address,poi" : str6);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: geocode");
        }
    }

    @C2307f(a = "/geocoding/v5/mapbox.places/{query}.json")
    C4050f<GeocoderResponse> geocode(@C2320s(a = "query") String str, @C2321t(a = "proximity") String str2, @C2321t(a = "access_token") String str3, @C2321t(a = "country") String str4, @C2321t(a = "language") String str5, @C2321t(a = "types") String str6);
}
