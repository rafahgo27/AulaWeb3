package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ValidaLogin", urlPatterns = {"/ValidaLogin"})
public class ValidaLogin extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        String user = "";
        if(request.getParameter("user").isEmpty()){
            PrintWriter msg = response.getWriter();
            msg.print("<script>"
                    + "alert('Nome de Usuário Não Preenchido!');"
                    + "history.back(-1);"
                    + "</script>");
        }else{
            user = request.getParameter("user");
        }
    
        String pass = "";
        if(request.getParameter("pass").isEmpty()){
           PrintWriter msg = response.getWriter();
           msg.print("<script>"
                   + "alert('Senha Não Preenchida!');"
                   + "history.back(-1);"
                   + "</script>");
        }else{
            pass = request.getParameter("pass");
        }
        
        String userDb = "email@email.com";
        String passDb = "senha1234";
        
        if(user.equals(userDb) && pass.equals(passDb)){
            request.setAttribute("nomeDoUsuario", user);
            request.getRequestDispatcher("inicio.jsp").forward(request, response);
        }else{
            PrintWriter msg = response.getWriter();
            msg.print("<script>"
                    + "alert('Acesso Negado!');"
                    + "history.back(-1);"
                    + "</script>");
        }
        
        try(PrintWriter out = response.getWriter()){
           out.println("<!DOCTYPE html>");
           out.println("<html>");
           out.println("<head>");
           out.println("<title>Servlet ValidaLogin</title>");
           out.println("</head>");
           out.println("<body>");
           out.println("<h1>Servlet ValidaLogin at" + request.getContextPath() + "</h1>");
           out.println("</body>");
           out.println("</html>");
        }       
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo(){
        return "Short Description";
    }
    
}    
