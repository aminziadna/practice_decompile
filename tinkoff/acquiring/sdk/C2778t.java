package ru.tinkoff.acquiring.sdk;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import ru.tinkoff.acquiring.sdk.p222e.C2761a;

/* compiled from: CryptoUtils */
/* renamed from: ru.tinkoff.acquiring.sdk.t */
public class C2778t {
    /* renamed from: a */
    public static java.lang.String m11418a(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:16:0x0049 in {7, 8, 10, 13, 15} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/788625466.run(Unknown Source)
*/
        /*
        if (r5 == 0) goto L_0x0041;
    L_0x0002:
        r0 = "SHA-256";	 Catch:{ Exception -> 0x003a }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ Exception -> 0x003a }
        r1 = "UTF-8";	 Catch:{ Exception -> 0x003a }
        r5 = r5.getBytes(r1);	 Catch:{ Exception -> 0x003a }
        r5 = r0.digest(r5);	 Catch:{ Exception -> 0x003a }
        r0 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x003a }
        r0.<init>();	 Catch:{ Exception -> 0x003a }
        r1 = 0;	 Catch:{ Exception -> 0x003a }
    L_0x0018:
        r2 = r5.length;	 Catch:{ Exception -> 0x003a }
        if (r1 >= r2) goto L_0x0035;	 Catch:{ Exception -> 0x003a }
    L_0x001b:
        r2 = r5[r1];	 Catch:{ Exception -> 0x003a }
        r2 = r2 & 255;	 Catch:{ Exception -> 0x003a }
        r2 = java.lang.Integer.toHexString(r2);	 Catch:{ Exception -> 0x003a }
        r3 = r2.length();	 Catch:{ Exception -> 0x003a }
        r4 = 1;	 Catch:{ Exception -> 0x003a }
        if (r3 != r4) goto L_0x002f;	 Catch:{ Exception -> 0x003a }
    L_0x002a:
        r3 = 48;	 Catch:{ Exception -> 0x003a }
        r0.append(r3);	 Catch:{ Exception -> 0x003a }
    L_0x002f:
        r0.append(r2);	 Catch:{ Exception -> 0x003a }
        r1 = r1 + 1;	 Catch:{ Exception -> 0x003a }
        goto L_0x0018;	 Catch:{ Exception -> 0x003a }
    L_0x0035:
        r5 = r0.toString();	 Catch:{ Exception -> 0x003a }
        return r5;
    L_0x003a:
        r5 = move-exception;
        r0 = new java.lang.RuntimeException;
        r0.<init>(r5);
        throw r0;
    L_0x0041:
        r5 = new java.lang.IllegalArgumentException;
        r0 = "Argument cannot be null";
        r5.<init>(r0);
        throw r5;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tinkoff.acquiring.sdk.t.a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static byte[] m11420a(String str, PublicKey publicKey) {
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, publicKey);
            return instance.doFinal(str.getBytes());
        } catch (NoSuchPaddingException e) {
            str = e;
            throw new RuntimeException(str);
        } catch (InvalidKeyException e2) {
            str = e2;
            throw new RuntimeException(str);
        } catch (NoSuchAlgorithmException e3) {
            str = e3;
            throw new RuntimeException(str);
        } catch (BadPaddingException e4) {
            str = e4;
            throw new RuntimeException(str);
        } catch (IllegalBlockSizeException e5) {
            str = e5;
            throw new RuntimeException(str);
        }
    }

    /* renamed from: a */
    public static String m11419a(byte[] bArr) {
        return C2761a.m11370b(bArr, 0).trim();
    }
}
