package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print(this.register(null));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter wr = resp.getWriter();


        String first = req.getParameter("FirstName");
        String last = req.getParameter("LastName");
        String user = req.getParameter("UserName");
        String phone = req.getParameter("Phone");
        String email = req.getParameter("Email");
        String password = req.getParameter("Password");
        String conPassword = req.getParameter("ConfirmPassword");

        String actionError = "";
                    if (first == null || first.equalsIgnoreCase(""))
                actionError = "please enter a valid first name<br/>";

            if (last == null || last.equalsIgnoreCase(""))
                actionError += "please enter a valid last  name<br/>";

            if (user == null|| user.equalsIgnoreCase(""))
                actionError += "please enter a username<br/>";

            if (email == null || email.equalsIgnoreCase(""))
                actionError = "please enter your email<br/>";

            if (phone == null || phone.equalsIgnoreCase(""))
                actionError += "please enter mobile number<br/>";

            if (password == null || phone.equalsIgnoreCase(""))
                actionError += "enter valid password<br/>";

            if (conPassword == null || phone.equalsIgnoreCase(""))
                actionError = "please confirm password<br/>";

            if ((password != null && conPassword != null) && !password.equals(conPassword)  )
                actionError += "password do not match<br/>";

            if((password != null && conPassword != null) && password.equals(conPassword))
                resp.sendRedirect("/login");
            else
                wr.print(this.register(actionError));


    }

    public String register(String actionError){

        return "<!DOCTYPE html>"+
                "<html lang=\"en\">"+

"<head>"+
 " <!-- Required meta tags -->"+
  "<meta charset=\"utf-8\">"+
  "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">"+
  "<title>Badili Sacco</title>"+
  "<!-- plugins:css -->"+
  "<link rel=\"stylesheet\" href=\"../../vendors/feather/feather.css\">"+
  "<link rel=\"stylesheet\" href=\"../../vendors/ti-icons/css/themify-icons.css\">"+
  "<link rel=\"stylesheet\" href=\"../../vendors/css/vendor.bundle.base.css\">"+
  "<!-- endinject -->"+
  "<!-- Plugin css for this page -->"+
  "<!-- End plugin css for this page -->"+
  "<!-- inject:css -->"+
  "<link rel=\"stylesheet\" href=\"../../css/vertical-layout-light/style.css\">"+
  "<!-- endinject -->"+
  "<link rel=\"shortcut icon\" href=\"../../images/favicon.png\" />"+
"</head>"+

"<body bgcolor=\"Lightskyblue\" style=\"margin: auto; width: 220px; >"+
 " <div class=\"container-scroller\">"+
    "<div class=\"container-fluid page-body-wrapper full-page-wrapper\">"+
     " <div class=\"content-wrapper d-flex align-items-center auth px-0\">"+
      "  <div class=\"row w-100 mx-0\">"+
       "   <div class=\"col-lg-4 mx-auto\">"+
        "    <div class=\"auth-form-light text-left py-5 px-4 px-sm-5\">"+
         "     <div class=\"brand-logo\">"+
          "      <img src=\"../../images/logo.svg\" alt=\"logo\">"+
           "   </div>"+
            "  <h4>New here?</h4>"+
             " <h6 class=\"font-weight-light\">Signing up to join the Sacco</h6>"+
              "<form class=\"pt-3\">"+
               " <div class=\"form-group\">"+
                "  <input type=\"text\" class=\"form-control form-control-lg\" id=\"exampleInputFistName1\" placeholder=\"FirstName\">"+
                "</div>"+
                "<div class=\"form-group\">"+
                 " <input type=\"text\" class=\"form-control form-control-lg\" id=\"exampleInputLastName1\" placeholder=\"LastName\">"+
                "</div>"+
                "<div class=\"form-group\">"+
                 " <input type=\"text\" class=\"form-control form-control-lg\" id=\"exampleInputUsername1\" placeholder=\"Username\">"+
                "</div>"+
                "<div class=\"form-group\">"+
                 " <input type=\"email\" class=\"form-control form-control-lg\" id=\"exampleInputEmail1\" placeholder=\"Email\">"+
                "</div>"+
                "<div class=\"form-group\">"+
                 " <input type=\"number\" class=\"form-control form-control-lg\" id=\"exampleInputPhone1\" placeholder=\"Phone\">"+
                "</div>"+

                "<div class=\"form-group\">"+
                 " <select class=\"form-control form-control-lg\" id=\"exampleFormControlSelect2\">"+
                  "  <option>Gender</option>"+
                   " <option>Male</option>"+
                    "<option>Female</option>"+
                    "<option>Other</option>"+

                  "</select>"+
                "</div>"+
                "<div class=\"form-group\">"+
                 " <input type=\"password\" class=\"form-control form-control-lg\" id=\"exampleInputPassword1\" placeholder=\"Password\">"+
                "</div>"+
                "<div class=\"mb-4\">"+
                 " <div class=\"form-check\">"+
                  "  <label class=\"form-check-label text-muted\">"+
                  "    <input type=\"checkbox\" class=\"form-check-input\">"+
                "I agree to all Terms & Conditions"+
                "</label>"+
                 " </div>"+
                "</div>"+
                "<div class=\"mt-3\">"+
                 " <a class=\"btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn\" <a href='./login'>Login</a>\">SIGN UP</a>"+
                "</div>"+
                "<div class=\"text-center mt-4 font-weight-light\">"+
                "Already have an account? <a href='./login'>Login</a>"+
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
  "<script src=\"../../js/hoverable-collapse.js\"></script>"+
  "<script src=\"../../js/template.js\"></script>"+
  "<script src=\"../../js/settings.js\"></script>"+
  "<script src=\"../../js/todolist.js\"></script>"+
  "<!-- endinject -->"+
"</body>"+

"</html>";


    }

}
