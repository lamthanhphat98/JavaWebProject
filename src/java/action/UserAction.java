/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import java.util.Map;
import user.UserDAO;
import user.UserDTO;

/**
 *
 * @author ADMIN
 */
public class UserAction extends ActionSupport {

    private String txtUsername;
    private String txtPassword;
    private String txtFullname;
    private String txtEmail;
    private String Username;
    private String Password;

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public UserAction() {
    }

    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        Map session = ActionContext.getContext().getSession();
        UserDTO dto = new UserDTO(txtUsername, txtPassword, txtFullname, txtEmail);
        try {

            if (dao.addNewUser(dto)) {
                return "success";
            }
        } catch (Exception ex) {
            if (ex.getMessage().contains("duplicate key")) {
                session.put("ERRORUSER", "User is already registed");

            }
        }
        return "fail";
    }

    /**
     * @return the txtUsername
     */
    public String getTxtUsername() {
        return txtUsername;
    }

    /**
     * @param txtUsername the txtUsername to set
     */
    @RequiredStringValidator(message = "Username required")
    public void setTxtUsername(String txtUsername) {
        this.txtUsername = txtUsername;
    }

    /**
     * @return the txtPassword
     */
    public String getTxtPassword() {
        return txtPassword;
    }

    /**
     * @param txtPassword the txtPassword to set
     */
    @RequiredStringValidator(message = "Password required")
    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }

    /**
     * @return the txtFullname
     */
    public String getTxtFullname() {
        return txtFullname;
    }

    /**
     * @param txtFullname the txtFullname to set
     */
    @RequiredStringValidator(message = "Name required")
    public void setTxtFullname(String txtFullname) {
        this.txtFullname = txtFullname;
    }

    /**
     * @return the txtEmail
     */
    public String getTxtEmail() {
        return txtEmail;
    }

    /**
     * @param txtEmail the txtEmail to set
     */
    @RequiredStringValidator(message = "Email required")
    @EmailValidator(message = "Email must be right format (xxx@xxx.xxx)")
    public void setTxtEmail(String txtEmail) {
        this.txtEmail = txtEmail;
    }

}
