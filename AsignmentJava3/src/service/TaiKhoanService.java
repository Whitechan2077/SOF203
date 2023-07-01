package service;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import model.TaiKhoan;
import repository.TaiKhoanRepository;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class TaiKhoanService {

    TaiKhoanRepository _taiKhoanDAO;

    public TaiKhoanService() {
        _taiKhoanDAO = new TaiKhoanRepository();
    }

    public void addTaiKhoan(TaiKhoan tk) {
        _taiKhoanDAO.addTaiKhoan(tk);
    }

    public void changePass(String tenTK, String newPass) {
        _taiKhoanDAO.changePass(tenTK, newPass);
    }

    public List<TaiKhoan> getAllTaiKhoan() {
        return _taiKhoanDAO.getAllTaiKhoan();
    }

    public boolean checkRoleDaoTao(String userName, Component parent) {
        Pattern regexDaoTao = Pattern.compile("^[D][T][\\w]+$");
        if (!regexDaoTao.matcher(userName).find()) {
            JOptionPane.showMessageDialog(parent, "Tên Tài khoản ko hợp lệ (DTxxxxx)", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean checkMatcherPass(String pass, String confirm, Component parent) {
        if (!pass.equals(confirm)) {
            JOptionPane.showMessageDialog(parent, "Mật khẩu xác nhận không khớp với mật khẩu", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public boolean checkRoleGiangVien(String userName, Component parent) {
        Pattern regexGv = Pattern.compile("^[G][V][\\w]+$");
        if (!regexGv.matcher(userName).find()) {
            JOptionPane.showMessageDialog(parent, "Tên Tài khoản ko hợp lệ (GVxxxxx)", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean checkExisted(String userName, Component parent) {
        List<TaiKhoan> listTk = new ArrayList<>();
        listTk = _taiKhoanDAO.getAllTaiKhoan();
        for (TaiKhoan tk : listTk) {
            if (tk.getUserName().equals(userName)) {
                JOptionPane.showMessageDialog(parent, "Tên Tài đã tồn tại", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        return true;
    }
}
