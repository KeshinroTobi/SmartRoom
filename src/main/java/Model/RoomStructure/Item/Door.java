package Model.RoomStructure.Item;

import java.sql.Timestamp;

public class Door {
    private int doorId;
    Boolean isOpen;
    private Timestamp timestamp;

    public Door(int doorId, Boolean isOpen) {
        this.doorId = doorId;
        this.isOpen = isOpen;
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public Door(int doorId) {
        this.doorId = doorId;
        isOpen = null;
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public int getDoorId() {
        return doorId;
    }

    public void setDoorId(int doorId) {
        this.doorId = doorId;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
