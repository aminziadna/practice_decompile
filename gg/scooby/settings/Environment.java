package ru.gg.scooby.settings;

import p042b.p047e.p049b.C0700j;

/* compiled from: Environment.kt */
public enum Environment {
    ;
    
    private final int googlePayEnvironment;
    private final String serverUrl;
    private final String terminalKey;
    private final String terminalPassword;

    protected Environment(String str, String str2, String str3, int i) {
        C0700j.m2715b(str, "serverUrl");
        C0700j.m2715b(str2, "terminalKey");
        C0700j.m2715b(str3, "terminalPassword");
        this.serverUrl = str;
        this.terminalKey = str2;
        this.terminalPassword = str3;
        this.googlePayEnvironment = i;
    }

    public final String getServerUrl() {
        return this.serverUrl;
    }

    public final String getTerminalKey() {
        return this.terminalKey;
    }

    public final String getTerminalPassword() {
        return this.terminalPassword;
    }

    public final int getGooglePayEnvironment() {
        return this.googlePayEnvironment;
    }
}
