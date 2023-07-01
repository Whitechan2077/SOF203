package model;

public class TaiKhoan {

    private String userName;
    private String passWord;
    private String roles;

    public TaiKhoan() {
    }

    public TaiKhoan(String userName, String passWord, String roles) {
        this.userName = userName;
        this.passWord = passWord;
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Object[] getDataTaiKhoan() {
        return new Object[]{userName, passWord, roles};
    }
}
