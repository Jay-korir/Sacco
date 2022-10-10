package controller;

import model.Members;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




@WebServlet(urlPatterns = "/login", initParams = {
        @WebInitParam(name = "username",value = "jenelle"),
        @WebInitParam(name = "password",value = "5055")
})
public class LogIn extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
            PrintWriter wr = servletResponse.getWriter();
            wr.print(this.login(null));

    }

    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
        PrintWriter wr = res.getWriter();
        String user = req.getParameter("UserName");
        String password = req.getParameter("Password");


        if (user == null || user.equalsIgnoreCase("")){
            wr.print(this.login("username  is required<br/>"));
        return;
    }
        if (password == null || password.equalsIgnoreCase("")) {
            wr.print(this.login("password is required"));
            return;
            }
          if (!user.equals(getServletConfig().getInitParameter("username")) && !password.equals(getServletConfig().getInitParameter("password"))) {
                wr.print(this.login("Invalid username & password combination<br/>"));
               return;
            }


        HttpSession session = req.getSession(true);
          session.setAttribute("username",user);
        session.setAttribute("loggedInTime"," logged in time :" + new Date());

        List<Members>  members = new ArrayList<Members>();
        session.setAttribute("members", members);

        System.out.println(session.getId());
        System.out.println(session.getCreationTime());
        System.out.println(session.getLastAccessedTime());

        RequestDispatcher read = req.getRequestDispatcher("dash");
        read.forward(req, res);

    }

    public String login(String actionError){

        return "<!DOCTYPE html>" +
                 "<html >" +

                     "<head>" +
 " <!-- Required meta tags -->" +
  "<meta charset=>"+
  //"<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">"+
  "<title>Badili Sacco</title>"+
  "<!-- plugins:css -->"+
  "<link rel=\"stylesheet\" href=\"./vendors/feather/feather.css\">"+
  "<link rel=\"stylesheet\" href=\"./vendors/ti-icons/css/themify-icons.css\">"+
  "<link rel=\"stylesheet\" href=\"./vendors/css/vendor.bundle.base.css\">"+
  "<!-- endinject -->"+
  "<!-- Plugin css for this page -->"+
  "<!-- End plugin css for this page -->"+
  "<!-- inject:css -->"+
  "<link rel=\"stylesheet\" href=\"./css/vertical-layout-light/style.css\">"+
  "<!-- endinject -->"+
  "<link rel=\"shortcut icon\" href=\"./images/favicon.png\" />"+
"</head>"+

"<body bgcolor=\"Lightskyblue\" style=\"margin: auto; width: 220px;>"+
 " <div class=\"container-scroller\">"+
  "  <div class=\"container-fluid page-body-wrapper full-page-wrapper\">"+
   "   <div class=\"content-wrapper d-flex align-items-center auth px-0\">"+
    "    <div class=\"row w-100 mx-0\">"+
     "     <div class=\"col-lg-4 mx-auto\">"+
      "      <div class=\"auth-form-light text-left py-5 px-4 px-sm-5\">"+
       "       <div class=\"brand-logo\">"+
        "        <img src=\"./assets/images/logo.svg\">"+
         "     </div>"+
          "    <h4>Badili Sacco! jipange uzeeni</h4>"+
           "   <h6 class=\"font-weight-light\">Sign in to continue </h6>" +

              "    <input type=\"email\"  placeholder=\"Username\">"+

                "<div class=\"form-group\">"+
                 " <input type=\"password\" class=\"form-control form-control-lg\" id=\"exampleInputPassword1\" placeholder=\"Password\">"+
                "</div>"+
                "<div class=\"mt-3\">"+
                 "<button type=\"submit\">Login</button>"+
                "</div>"+
                "<div class=\"my-2 d-flex justify-content-between align-items-center\">"+
                 " <div class=\"form-check\">"+
                  "  <label class=\"form-check-label text-muted\">"+
                   "   <input type=\"checkbox\" class=\"form-check-input\">"+
                "Keep me signed in"+
                "</label>"+
                 " </div>"+
                  "<a href=\"#\" class=\"auth-link text-black\">Forgot password?</a> "+
               " </div> "+

                "<div class=\"text-center mt-4 font-weight-light\"> "+
                "Don't have an account? <a href='./register'>Register</a><br/>\" "+
                "</div>"+
              "</form>"+
            "</div>"+
          "</div>"+
        "</div>"+
      "</div>"+
      "<!-- content-wrapper ends -->"+
    "</div>"+
    "<!-- page-body-wrapper ends -->"+
  "</div>"+
  "<!-- container-scroller -->"+
  "<!-- plugins:js -->"+
  "<script src=\"../../vendors/js/vendor.bundle.base.js\"></script>"+
  "<!-- endinject -->"+
  "<!-- Plugin js for this page -->"+
  "<!-- End plugin js for this page -->"+
  "<!-- inject:js -->"+
  "<script src=\"../../js/off-canvas.js\"></script>"+
  "<script src=\"./assets/js/hoverable-collapse.js\"></script>"+
  "<script src=\"../../js/template.js\"></script>"+
  "<script src=\"../../js/settings.js\"></script>"+
  "<script src=\"../../js/todolist.js\"></script>"+
  "<!-- endinject -->"+
"</body>"+

"</html>";

    }
}
