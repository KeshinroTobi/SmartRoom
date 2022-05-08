package Model.RoomStructure.Item;

import java.sql.Timestamp;

public class Ventilator {
    private int ventilatorId;
    private Timestamp timestamp;
    private Boolean isOn;

    public Ventilator(int ventilatorId) {
        this.ventilatorId = ventilatorId;
        isOn = null;
        timestamp = new Timestamp(System.currentTimeMillis());

    }
    public int getVentilatorId() {
        return ventilatorId;
    }

    public void setVentilatorId(int ventilatorId) {
        this.ventilatorId = ventilatorId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getOn() {
        return isOn;
    }

    public void setOn(Boolean on) {
        isOn = on;
    }
}
