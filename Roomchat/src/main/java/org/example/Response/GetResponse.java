package org.example.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Classes.Room;
import org.example.Service.DatabaseReader;

import java.util.List;

public class GetResponse {
    private final DatabaseReader reader=DatabaseReader.getReader();
    public List<Room> getResultList(){
        return reader.findRooms();
    }
    public String getResultString() throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(getResultList());
    }
}