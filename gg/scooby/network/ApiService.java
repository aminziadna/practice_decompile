package ru.gg.scooby.network;

import io.p181b.C4050f;
import java.util.List;
import okhttp3.C4138w.C2654b;
import p165d.C2342r;
import p165d.p168c.C2302a;
import p165d.p168c.C2303b;
import p165d.p168c.C2307f;
import p165d.p168c.C2313l;
import p165d.p168c.C2315n;
import p165d.p168c.C2316o;
import p165d.p168c.C2317p;
import p165d.p168c.C2318q;
import p165d.p168c.C2321t;
import ru.gg.scooby.model.AdvFilter;
import ru.gg.scooby.model.Car;
import ru.gg.scooby.model.Code;
import ru.gg.scooby.model.Color;
import ru.gg.scooby.model.GetVerifyCodeResponse;
import ru.gg.scooby.model.Model;
import ru.gg.scooby.model.ParkingAdvert;
import ru.gg.scooby.model.ParkingForSell;
import ru.gg.scooby.model.ParkingStatus;
import ru.gg.scooby.model.ParkingStatusResponse;
import ru.gg.scooby.model.ParkingsResponse;
import ru.gg.scooby.model.PaymentTemplate;
import ru.gg.scooby.model.Pin;
import ru.gg.scooby.model.PostVerifyCodeResponse;
import ru.gg.scooby.model.TransferRequest;
import ru.gg.scooby.model.TransferResponse;
import ru.gg.scooby.model.User;
import ru.gg.scooby.model.UserLocationRequest;
import ru.gg.scooby.model.UserLocationResponse;

/* compiled from: ApiManager.kt */
public interface ApiService {
    @C2316o(a = "car/add")
    C4050f<C2342r<Void>> addCar(@C2321t(a = "phoneNumber") String str, @C2302a Car car);

    @C2316o(a = "money-transfer-template/add")
    C4050f<C2342r<PaymentTemplate>> addPaymentTemplate(@C2321t(a = "phoneNumber") String str, @C2302a PaymentTemplate paymentTemplate);

    @C2316o(a = "parking/reserve")
    C4050f<C2342r<Void>> buyParking(@C2321t(a = "phoneNumber") String str, @C2321t(a = "id") long j);

    @C2317p(a = "parking/deal-cancel")
    C4050f<C2342r<Void>> dealCancel(@C2321t(a = "phoneNumber") String str, @C2321t(a = "id") long j, @C2321t(a = "reason") String str2);

    @C2317p(a = "parking/deal-complete")
    C4050f<C2342r<Void>> dealComplete(@C2321t(a = "phoneNumber") String str, @C2321t(a = "id") long j);

    @C2303b(a = "car/delete")
    C4050f<C2342r<Void>> deleteCar(@C2321t(a = "phoneNumber") String str, @C2321t(a = "carId") long j);

    @C2303b(a = "parking/delete")
    C4050f<C2342r<Void>> deleteParking(@C2321t(a = "phoneNumber") String str, @C2321t(a = "id") long j);

    @C2303b(a = "money-transfer-template/delete")
    C4050f<C2342r<Void>> deletePaymentTemplate(@C2321t(a = "phoneNumber") String str, @C2321t(a = "id") long j);

    @C2307f(a = "user-location/pull")
    C4050f<C2342r<UserLocationResponse>> getBuyerLocation(@C2321t(a = "phoneNumber") String str, @C2321t(a = "adv-id") long j);

    @C2307f(a = "persistent/car-colors")
    C4050f<C2342r<List<Color>>> getCarColors();

    @C2307f(a = "persistent/car-models")
    C4050f<C2342r<List<Model>>> getCarModels();

    @C2307f(a = "car/get-cars")
    C4050f<C2342r<List<Car>>> getCars(@C2321t(a = "phoneNumber") String str);

    @C2307f(a = "parking/get-by-id")
    C4050f<C2342r<ParkingStatusResponse>> getParking(@C2321t(a = "phoneNumber") String str, @C2321t(a = "id") long j);

    @C2307f(a = "parking/get-by-id")
    C4050f<C2342r<ParkingStatus>> getParkingById(@C2321t(a = "phoneNumber") String str, @C2321t(a = "id") long j);

    @C2307f(a = "parking/get-status")
    C4050f<C2342r<ParkingStatusResponse>> getParkingStatus(@C2321t(a = "phoneNumber") String str, @C2321t(a = "id") long j);

    @C2316o(a = "parking/get-by-filter")
    C4050f<C2342r<ParkingsResponse>> getParkings(@C2321t(a = "phoneNumber") String str, @C2302a AdvFilter advFilter);

    @C2307f(a = "money-transfer-template/get-list")
    C4050f<C2342r<List<PaymentTemplate>>> getPaymentTemplates(@C2321t(a = "phoneNumber") String str);

    @C2307f(a = "user/get")
    C4050f<C2342r<User>> getUser(@C2321t(a = "phoneNumber") String str);

    @C2317p(a = "parking/like")
    C4050f<C2342r<Void>> like(@C2321t(a = "phoneNumber") String str, @C2321t(a = "id") long j);

    @C2307f(a = "login/login")
    C4050f<C2342r<Void>> login(@C2321t(a = "phoneNumber") String str);

    @C2316o(a = "login/pin-login")
    C4050f<C2342r<Void>> pinLogin(@C2321t(a = "phoneNumber") String str, @C2302a Pin pin);

    @C2316o(a = "login/pin-set")
    C4050f<C2342r<Void>> pinSet(@C2321t(a = "phoneNumber") String str, @C2302a Pin pin);

    @C2307f(a = "login/verify-code")
    C4050f<C2342r<GetVerifyCodeResponse>> requestCode(@C2321t(a = "phoneNumber") String str);

    @C2316o(a = "parking/sell")
    C4050f<C2342r<ParkingAdvert>> sellParking(@C2321t(a = "phoneNumber") String str, @C2302a ParkingForSell parkingForSell);

    @C2317p(a = "user-location/push")
    C4050f<C2342r<Void>> sendBuyerLocation(@C2321t(a = "phoneNumber") String str, @C2302a UserLocationRequest userLocationRequest);

    @C2316o(a = "login/verify-code")
    C4050f<C2342r<PostVerifyCodeResponse>> sendCode(@C2321t(a = "phoneNumber") String str, @C2321t(a = "code") String str2);

    @C2316o(a = "car/set")
    C4050f<C2342r<Void>> setDefaultCar(@C2321t(a = "phoneNumber") String str, @C2321t(a = "carId") long j);

    @C2313l
    @C2316o(a = "user/upload-avatar")
    C4050f<C2342r<Void>> updateAvatar(@C2321t(a = "phoneNumber") String str, @C2318q C2654b c2654b);

    @C2315n(a = "car/update")
    C4050f<C2342r<Void>> updateCar(@C2321t(a = "phoneNumber") String str, @C2302a Car car);

    @C2316o(a = "user/device-id")
    C4050f<C2342r<Void>> updateDeviceId(@C2321t(a = "phoneNumber") String str, @C2321t(a = "device-id") String str2);

    @C2315n(a = "parking/update")
    C4050f<C2342r<ParkingAdvert>> updateParking(@C2321t(a = "phoneNumber") String str, @C2321t(a = "id") long j, @C2302a ParkingForSell parkingForSell);

    @C2315n(a = "money-transfer-template/update")
    C4050f<C2342r<Void>> updatePaymentTemplate(@C2321t(a = "phoneNumber") String str, @C2302a PaymentTemplate paymentTemplate);

    @C2315n(a = "user/name")
    C4050f<C2342r<Void>> updateUserName(@C2321t(a = "phoneNumber") String str, @C2321t(a = "name") String str2);

    @C2307f(a = "login/view-code")
    C4050f<C2342r<Code>> viewCode(@C2321t(a = "phoneNumber") String str);

    @C2316o(a = "money-transfer/add")
    C4050f<C2342r<TransferResponse>> withdrawFunds(@C2321t(a = "phoneNumber") String str, @C2302a TransferRequest transferRequest);
}
