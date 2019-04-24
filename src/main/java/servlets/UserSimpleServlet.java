package servlets;

import models.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserSimpleServlet extends HttpServlet {
    private UserService service = new UserService();

    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> users = service.findAllUsers();
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/showUsers.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String city = request.getParameter("city");
        User user = new User(name, age, city);
        service.saveUser(user);
        response.sendRedirect("/users");

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = service.findUser(id);
        user.setName(request.getParameter("name"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setCity(request.getParameter("city"));
        service.updateUser(user);
        response.sendRedirect("/users");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.deleteUser(service.findUser(id));
        response.sendRedirect("/users");
    }
}
