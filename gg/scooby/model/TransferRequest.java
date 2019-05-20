package ru.gg.scooby.model;

/* compiled from: MoneyTransfer.kt */
public final class TransferRequest {
    private final long amount;
    private final long templateId;

    public TransferRequest(long j, long j2) {
        this.templateId = j;
        this.amount = j2;
    }

    public final long getTemplateId() {
        return this.templateId;
    }

    public final long getAmount() {
        return this.amount;
    }
}
