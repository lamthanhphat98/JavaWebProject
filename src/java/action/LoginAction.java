/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import user.UserDAO;

/**
 *
 * @author ADMIN
 */
public class LoginAction {

    private String txtUsername;
    private String txtPassword;

    public String getTxtPassword() {
        return txtPassword;
    }

    public String getTxtUsername() {
        return txtUsername;
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }

    public void setTxtUsername(String txtUsername) {
        this.txtUsername = txtUsername;
    }

    public LoginAction() {
    }

    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        Map session = ActionContext.getContext().getSession();
        //UserDTO dto = new UserDTO(txtUsername, txtPassword, txtFullname, txtEmail);
        //System.out.println(txtUsername + "1" + txtPassword);
        if (dao.checkLogin(txtUsername, txtPassword)) {
            session.put("CURRENTUSER", txtUsername);
            return "success";
        } else {
            session.put("ERRORLOGIN", "Username or password may be wrong");
            return "fail";
        }

    }

    public String logout() throws Exception {
        // UserDAO dao = new UserDAO();
        Map session = ActionContext.getContext().getSession();
        session.clear();
        return "success";
    }

}
