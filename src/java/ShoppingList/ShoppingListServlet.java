package ShoppingList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 684243
 */
@WebServlet(urlPatterns = {"/ShoppingListServlet"})
public class ShoppingListServlet extends HttpServlet {

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String action = (String) request.getParameter("action");

        if (username == null || action == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            
        } else if (action.compareTo("logout") == 0) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);   
            
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        ServletContext sc = getServletContext();
        String url = "/WEB-INF/register.jsp";
        HttpSession session = request.getSession();
        System.out.println(action);
        ArrayList<String> list;
        
        
        if (session.getAttribute("list") == null) {
            list = new ArrayList<String>();

        }else{
            list = (ArrayList<String>) session.getAttribute("list");
        }

        if (action.compareTo("register") == 0) {
            session.setAttribute("username", request.getParameter("username"));
            url = "/WEB-INF/shoppingList.jsp";
        } 
        
        else if (action.compareTo("add") == 0) {
            if(request.getParameter("newItem").compareTo("") != 0){
                
                list.add(request.getParameter("newItem"));
                session.setAttribute("list", list);
            }
            url = "/WEB-INF/shoppingList.jsp";
        } 
        
        else if (action.compareTo("delete") == 0) {
            String selected = (String) request.getParameter("listSelected");
            
            for(int i =0; i < list.size(); i++){
                if(selected.compareToIgnoreCase(list.get(i)) == 0){
                    list.remove(i);
                }
            }
            
            url = "/WEB-INF/shoppingList.jsp";
        }

        sc.getRequestDispatcher(url)
                .forward(request, response);
    }

}
