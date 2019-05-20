package ru.gg.scooby.manager;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import androidx.core.content.C0318b;
import androidx.core.content.FileProvider;
import com.bluelinelabs.conductor.C0809d;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p042b.p043a.C4381k;
import p042b.p046d.C0688a;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ContextProvider;
import ru.gg.scooby.util.DateUtils;

/* compiled from: FileUploadManager.kt */
public final class FileUploadManager {
    public static final FileUploadManager INSTANCE = new FileUploadManager();
    private static final String SHARED_IMAGES_SUBDIR = "images";
    private static final ContentResolver contentResolver = ContextProvider.INSTANCE.getContext().getContentResolver();
    private static final Context context = ContextProvider.INSTANCE.getContext();
    private static Uri tempFileUri;

    private FileUploadManager() {
    }

    public final Uri getTempFileUri() {
        return tempFileUri;
    }

    public final void setTempFileUri(Uri uri) {
        tempFileUri = uri;
    }

    public final void fromGallery(C0809d c0809d) {
        C0700j.m2715b(c0809d, "controller");
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        c0809d.startActivityForResult(intent, 3);
    }

    public final byte[] getBytesFromUri(Context context, Uri uri) {
        C0700j.m2715b(context, "context");
        Object openInputStream = context.getContentResolver().openInputStream(uri);
        C0700j.m2711a(openInputStream, "context.contentResolver.openInputStream(uri)");
        return C0688a.m2696a(openInputStream);
    }

    public final String getMimeType(Uri uri) {
        return contentResolver.getType(uri);
    }

    public final void fromCamera(C0809d c0809d) {
        C0700j.m2715b(c0809d, "controller");
        if (C0318b.m1289a(context, "android.permission.CAMERA") == 0) {
            sendCameraIntent(c0809d);
        } else if (VERSION.SDK_INT >= 23) {
            c0809d.requestPermissions(new String[]{"android.permission.CAMERA"}, 2);
        }
    }

    public final void sendCameraIntent(C0809d c0809d) {
        C0700j.m2715b(c0809d, "controller");
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File createImageFile = createImageFile();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getPackageName());
        stringBuilder.append(".fileprovider");
        tempFileUri = FileProvider.m1214a(context.getApplicationContext(), stringBuilder.toString(), createImageFile);
        intent.putExtra("output", tempFileUri);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            Object queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            C0700j.m2711a(queryIntentActivities, "resInfoList");
            Iterable<ResolveInfo> iterable = (Iterable) queryIntentActivities;
            Collection arrayList = new ArrayList(C4381k.m18905a(iterable, 10));
            for (ResolveInfo resolveInfo : iterable) {
                arrayList.add(resolveInfo.activityInfo.packageName);
            }
            for (String grantUriPermission : (List) arrayList) {
                context.grantUriPermission(grantUriPermission, tempFileUri, 3);
            }
            c0809d.startActivityForResult(intent, 2);
        }
    }

    private final File createImageFile() {
        String file = context.getFilesDir().toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("images/");
        stringBuilder.append(DateUtils.INSTANCE.toImageName(System.currentTimeMillis()));
        stringBuilder.append(".jpg");
        File file2 = new File(file, stringBuilder.toString());
        new File(file2.getParent()).mkdirs();
        return file2;
    }

    public final void deleteTempFile() {
        if (tempFileUri != null) {
            ContextProvider.INSTANCE.getContext().getContentResolver().delete(tempFileUri, null, null);
        }
    }
}
