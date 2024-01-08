/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Student;

/**
 *
 * @author Admin
 */
@WebServlet(name="StudentServlet", urlPatterns={"/student"})
public class StudentServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String name ="Nguyen van a";
        request.setAttribute("name", name);
        Student s = new Student(1, name, true, 8);
        request.setAttribute("st", s);
        String num_raw = request.getParameter("num");
        int num;
        try {
            num=Integer.parseInt(num_raw);
            List<Student> list =new ArrayList<>();
            int id ;
            int mark;
            boolean gender ;
            String w [] ={"A","B","C","D","E","F"};
            Random r = new Random();
            for (int i = 0; i < num ; i++) {
                id=r.nextInt(99-10+1) + 10;
                mark=r.nextInt(11);
                gender=r.nextBoolean();
                int k = r.nextInt(w.length);
                if(gender){
                    name="Mr "+ w[k];
                }else{
                    name="Mrs "+ w[k];
                }
                s = new Student(id, name, gender, mark);
                list.add(s);
            }
            request.setAttribute("data", list);
        } catch (Exception e) {
        }
        request.getRequestDispatcher("h3.jsp").forward(request, response);
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
