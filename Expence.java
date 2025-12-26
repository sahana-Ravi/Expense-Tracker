
import java.time.LocalDateTime;
import java.util.UUID;

public  class Expence {
    private UUID id;
    private String description;
    private double amount;
    private LocalDateTime timeStamp;

    public Expence(String description, double amount) {
        this.description = description;
        this.amount = amount;
        timeStamp = LocalDateTime.now();
        this.id = UUID.randomUUID();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getId() {
        return id;
    }
}