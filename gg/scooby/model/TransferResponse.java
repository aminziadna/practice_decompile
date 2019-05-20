package ru.gg.scooby.model;

/* compiled from: MoneyTransfer.kt */
public final class TransferResponse {
    private final long amount;
    private final long fee;
    private final long id;
    private final int status;

    public TransferResponse(long j, long j2, long j3, int i) {
        this.id = j;
        this.amount = j2;
        this.fee = j3;
        this.status = i;
    }

    public final long getId() {
        return this.id;
    }

    public final long getAmount() {
        return this.amount;
    }

    public final long getFee() {
        return this.fee;
    }

    public final int getStatus() {
        return this.status;
    }

    public final long getAmountMinusFee() {
        return this.amount - this.fee;
    }
}
