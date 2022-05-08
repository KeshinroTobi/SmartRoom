package Model.RoomStructure;

import Model.RoomStructure.Item.Door;
import Model.RoomStructure.Item.Ventilator;
import Model.RoomStructure.Item.Window;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;

public class Room {
    private int id;
    private int size;
    private String name;
    private int maxPeople;
    private int noOfPeople;
    private Timestamp timestamp;
    private int temperature;
    private int co2;
    private Date roomTime;
    private String color;
    private Ventilator ventilator;
    private LinkedList<Door> doorLinkedList;
    private LinkedList<Window> windowLinkedList;

    public Room(int id, int size, String name) {
        this.id = id;
        this.size = size;
        this.name = name;
    }

    public Room(int id, int size, String name, int maxPeople, Ventilator ventilator, LinkedList<Door> doorLinkedList,
                LinkedList<Window> windowLinkedList) {
        this(id,size,name);
        this.maxPeople = maxPeople;
        this.ventilator = ventilator;
        this.doorLinkedList = doorLinkedList;
        this.windowLinkedList = windowLinkedList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(int noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getCo2() {
        return co2;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    public Date getRoomTime() {
        return roomTime;
    }

    public void setRoomTime(Date roomTime) {
        this.roomTime = roomTime;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Ventilator getVentilator() {
        return ventilator;
    }

    public void setVentilator(Ventilator ventilator) {
        this.ventilator = ventilator;
    }

    public LinkedList<Door> getDoorLinkedList() {
        return doorLinkedList;
    }

    public void setDoorLinkedList(LinkedList<Door> doorLinkedList) {
        this.doorLinkedList = doorLinkedList;
    }

    public LinkedList<Window> getWindowLinkedList() {
        return windowLinkedList;
    }

    public void setWindowLinkedList(LinkedList<Window> windowLinkedList) {
        this.windowLinkedList = windowLinkedList;
    }

    public void addDoor(Door...doors){
        for (Door door: doors){
            doorLinkedList.add(door);
        }
    }
    public void addWindows(Window...windows){
        for (Window window: windows){
            windowLinkedList.add(window);
        }
    }
    public void removeWindow(Window window){
        windowLinkedList.remove(window);
    }
    public void removeDoor(Door door){
        doorLinkedList.remove(door);
    }
    public void updateRoom(int size){

        this.size = size;
    }
    public void addRandomValues(){
        int co2 = (int) Math.floor(Math.random()*(1500-200+1)+200);
        int temp = (int) Math.floor(Math.random()*(100-(-10)+1)+(-10));
        int numberPeople = (int) Math.floor(Math.random()*(maxPeople-0+1)+0);
        this.co2 = co2;
        this.temperature = temp;
        this.noOfPeople = numberPeople;
    }

    //change the status for a Ventilator
    public void setVentilatorStatus(Ventilator ventilator, Boolean value){
        ventilator.setOn(value);
    }

    public void setDoorStatus(Door door, Boolean value){
        door.setOpen(value);
    }

    public void setWindowStatus(Window window, Boolean value){
        window.setOpen(value);
    }


}
