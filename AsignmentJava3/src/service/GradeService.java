package service;

import repository.GradeRepository;
import java.util.ArrayList;
import java.util.List;
import model.Grade;
import model.SinhVien;
import java.util.regex.Pattern;

public class GradeService {

    private GradeRepository _gradeDAO;

    public GradeService() {
        _gradeDAO = new GradeRepository();
    }

    public List<Grade> getAllGrade() {
        return _gradeDAO.sellectAllGrade();
    }

    public void addGrade(Grade grade) {
        _gradeDAO.insertGrade(grade);
    }

    public void deleteGrade(String maSV) {
        _gradeDAO.deleteGrade(maSV);
    }

    public void updateGrade(String location, String maSv, int TiengAnh, int Tin, int GiaoDucTC) {
        _gradeDAO.updateGrade(location, maSv, TiengAnh, Tin, GiaoDucTC);
    }

    public String getNameFormMaSV(String maSV) {
        List<SinhVien> listSv = new ArrayList<>();
        listSv = new SinhVienService().getAllSinhVien();
        for (SinhVien sv : listSv) {
            if (sv.getMaSV().equals(maSV)) {
                return sv.getTenSV();
            }
        }
        return null;
    }

    public boolean checkNumberGrade(String mark) {
        Pattern regexInt = Pattern.compile("^[0-9]+$");
        Pattern regexDouble = Pattern.compile("^[0-9]+(\\.)[0-9]+$");
        if (!regexInt.matcher(mark).find() && !regexDouble.matcher(mark).find()) {
            return false;
        } else {
            return true;
        }

    }
}
