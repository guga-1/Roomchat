package org.example.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Request.AddRequest;
import org.example.Response.AddResponse;
import org.example.Response.GetResponse;

import java.io.IOException;

@WebServlet("/room")
public class RoomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetResponse response=new GetResponse();
        resp.getWriter().write(response.getResultString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String limit=req.getParameter("limit");
        if (name.isEmpty()||limit.isEmpty()){
            resp.sendError(401);
        }else {
            AddRequest request = new AddRequest(name, limit);
            AddResponse response = new AddResponse(request);
        }
    }
}