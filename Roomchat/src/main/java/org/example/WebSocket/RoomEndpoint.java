package org.example.WebSocket;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Classes.AUser;
import org.example.Classes.Room;
import org.example.Response.GetResponse;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ServerEndpoint("/room")
public class RoomEndpoint {
    private final static List<Session> sessions = new ArrayList<>();

    public static List<Session> getRoomSessions() {
        return sessions;
    }
    ObjectMapper mapper = new ObjectMapper();

    @OnOpen
    public void open(Session session) throws IOException {
        sessions.add(session);
        sendData(session);
    }
    @OnClose
    public void close(Session session){
        sessions.remove(session);
    }
    public void resendData() throws IOException {
        for (Session session:sessions){
            sendData(session);
        }
    }
    private void sendData(Session session) throws IOException {
        session.getBasicRemote().sendText(mapper.writeValueAsString(getActiveUsers()));
    }
    private List<AUser> getActiveUsers(){
        Map<Session, Room> sessionRoomMap = ChatEndpoint.getSessions();
        List<AUser> active = new ArrayList<>();
        GetResponse response = new GetResponse();
        for (Room room : response.getResultList()) {
            int i = 0;
            for (Room room1 : sessionRoomMap.values()) {
                if (room.getId() == room1.getId()) {
                    i+=1;
                    System.out.println("a");
                }
            }
            active.add(new AUser(room,i));
        }
        return active;
    }
}