package model;

import java.util.List;

public class SinhVien {

    private String maSV;
    private String tenSV;
    private String email;
    private String sdt;
    private String gioiTinh;
    private String diaChi;
    private byte[] avatar;

    public SinhVien() {
    }

    public SinhVien(String maSV, String tenSV, String email, String sdt, String gioiTinh, String diaChi, byte[] avatar) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.email = email;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.avatar = avatar;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public Object[] getDataSinhVien() {
        return new Object[]{maSV, tenSV, email, sdt, gioiTinh, diaChi, avatar};
    }

}
