package Model.RoomStructure.Item;

import java.sql.Timestamp;

public class Window {
    private int windowId;
    private Timestamp timestamp;
    private Boolean isOpen;

    public Window(int windowId) {
        this.windowId = windowId;
        isOpen = null;
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public int getWindowId() {
        return windowId;
    }

    public void setWindowId(int windowId) {
        this.windowId = windowId;
    }
}
