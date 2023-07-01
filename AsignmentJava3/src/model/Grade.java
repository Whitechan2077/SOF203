package model;

import service.GradeService;

public class Grade {

    private int id;
    private String maSV;
    private int tiengAnh;
    private int tinHoc;
    private int giaoDucTC;

    public Grade() {
    }

    public Grade(int id, String maSV, int tiengAnh, int tinHoc, int giaoDucTC) {
        this.id = id;
        this.maSV = maSV;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.giaoDucTC = giaoDucTC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public int getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(int tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public int getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(int tinHoc) {
        this.tinHoc = tinHoc;
    }

    public int getGiaoDucTC() {
        return giaoDucTC;
    }

    public void setGiaoDucTC(int giaoDucTC) {
        this.giaoDucTC = giaoDucTC;
    }

    public double getDiemTb() {
        double diemTb = (double) (tiengAnh + tinHoc + giaoDucTC) / 3;
        return Math.ceil(diemTb*100)/100;
    }

    public String getNameSv(String maSv) {
        return new GradeService().getNameFormMaSV(maSv);
    }

    public Object[] getDataGrade() {
        return new Object[]{maSV, getNameSv(maSV), tiengAnh, tinHoc, giaoDucTC, getDiemTb()};
    }
}
