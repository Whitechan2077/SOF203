package service;

import java.awt.Container;
import repository.SinhVienRepository;
import java.util.List;
import model.SinhVien;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class SinhVienService {

    private SinhVienRepository _sinhVienDAO;

    public SinhVienService() {
        _sinhVienDAO = new SinhVienRepository();
    }

    public List<SinhVien> getAllSinhVien() {
        return _sinhVienDAO.sellectAllSinhVien();
    }

    public void addSinhVien(SinhVien sv) {
        _sinhVienDAO.addSinhVien(sv);
    }

    public void deleteSinhVien(String maSV) {
        _sinhVienDAO.deleteSinhVien(maSV);
    }

    public void updateSinhVien(String location, String code, String name, String email, String sdt, String gender, String address, byte[] avatar) {
        _sinhVienDAO.updateSinhVien(location, code, name, email, sdt, gender, address, avatar);
    }

    public boolean checkValidate(String maSV, String email, String sdt, Container parent) {
        Pattern regexMaSV = Pattern.compile("^[P][H][0-9]+$");
        if (!regexMaSV.matcher(maSV).find()) {
            JOptionPane.showMessageDialog(parent, "Mã SV ko hợp lệ (PHxxxxx)", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        Pattern regexEmail = Pattern.compile("^[\\w]+@fpt.edu.vn$");
        if (!regexEmail.matcher(email).find()) {
            JOptionPane.showMessageDialog(parent, "Email không hợp lệ (@fpt.edu.vn)", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        Pattern regexSdt = Pattern.compile("^[0][1-9]{9,11}$");
        if (!regexSdt.matcher(sdt).find()) {
            JOptionPane.showMessageDialog(parent, "Sdt không hợp lệ (10-12 số)", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
}
