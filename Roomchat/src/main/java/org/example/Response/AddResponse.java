package org.example.Response;
import org.example.Classes.Room;
import org.example.Request.AddRequest;
import org.example.Service.DatabaseReader;

public class AddResponse {
    public AddResponse(AddRequest request) {
        Room room=request.getRoom();
        AddRoom(room);
    }
    private void AddRoom(Room room){
        DatabaseReader reader=DatabaseReader.getReader();
        reader.addRoom(room);
    }
}