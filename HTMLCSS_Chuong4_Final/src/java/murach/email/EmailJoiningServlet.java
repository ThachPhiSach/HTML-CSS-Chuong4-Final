/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package murach.email;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Arrays;
// import java.util.List;

import murach.business.User;
import murach.business.RadioSelect;
import murach.business.CheckBox;
import murach.business.DropDown;

/**
 *
 * @author ACER
 */
@WebServlet(name = "EmailJoiningServlet", urlPatterns = {"/emailJoin"})
public class EmailJoiningServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/index.html";

        // get current action
        String action = request.getParameter("action");
        if (action==null) {
            action = "join"; // defaull action
        }
        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.html"; // the "join" page
        }
        else if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String birthday = request.getParameter("birthday");

            // store data in User object and save User object in db
            User user = new User(firstName, lastName, email, birthday);
            // UserDB.insert(user);

            // set User object in request object and set URL
            request.setAttribute("user", user);
            url = "/return.jsp"; // the "thanks" page
        }
        // retrieving radio button value
        String option = request.getParameter("about");
        
        RadioSelect radio = new RadioSelect();
        radio.setOption(option);
        
        request.setAttribute("radio", radio);

        // retrieving checkbox value
        String[] selected = request.getParameterValues("check");
        
        CheckBox checkbox = new CheckBox();
        checkbox.setOptions(Arrays.asList(selected));
        
        request.setAttribute("checkbox", checkbox);
        
        // retrieving dropdown value
        String selectOption = request.getParameter("contact");
        
        DropDown dropdown = new DropDown();
        dropdown.setDropdown(selectOption);
        
        request.setAttribute("dropdown", dropdown);
        
        
        // forward request and respond objects to specified URL
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    } 

}
