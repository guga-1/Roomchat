package org.example.Request;

import lombok.Getter;
import org.example.Classes.Room;

@Getter
public class AddRequest {
    Room room;
    public AddRequest(String chatName,String maxMembers) {
        room.setChatName(chatName);
        room.setMaxMembers(Integer.parseInt(maxMembers));
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}