package io.github.handharbeni.epbb.events;

public class BluetoothEvent {
    public enum BTEvent {
        SCAN_REQUEST,
        SCAN_STOP,
        DEVICE_DISCOVERED,
        BLUETOOTH_STOPPED,
        STOP_BLUETOOTH,
        START_BLUETOOTH,
        BLUETOOTH_CONNECTED
    }
//    public final BTEvent message;
//    public final BluetoothStatus btStatus;

//    public BluetoothEvent(BTEvent message, BluetoothStatus btStatus) {
//        this.message = message;
//        this.btStatus = btStatus;
//    }
}
