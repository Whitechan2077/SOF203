package view;

import model.SinhVien;
import model.TaiKhoan;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import repository.TaiKhoanRepository;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import service.GradeService;
import service.SinhVienService;

public class QLSinhVien extends javax.swing.JFrame {

    private DefaultTableModel _dtm;
    private SinhVienService _svs;
    private List<SinhVien> _listSV;
    private String _locationUpdate;
    private ImageIcon _defaultAvatar;
    private byte[] _arrAvatar;

    public QLSinhVien(String userCurrent) {
        initComponents();
        pnlStudent.setVisible(true);
        pnlAccountStudent.setVisible(false);
        _dtm = new DefaultTableModel();
        _svs = new SinhVienService();
        _listSV = new ArrayList<>();
        _defaultAvatar = new ImageIcon("C:\\Users\\trant\\OneDrive\\Desktop\\Java3_project\\AsignmentJava3\\src\\icon\\add-image.png");
        _listSV = _svs.getAllSinhVien();
        tblSV.setModel(_dtm);
        String nameColumn[] = {"Mã SV", "Họ Tên", "Email", "Sdt", "Giới tính", "Địa chỉ"};
        _dtm.setColumnIdentifiers(nameColumn);
        showDataToTable(_listSV);
        lbNameDaoTao.setText(userCurrent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlParent = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbStudent = new javax.swing.JLabel();
        lbAccount = new javax.swing.JLabel();
        lbLogOut = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();
        pnlStudent = new javax.swing.JPanel();
        lbMaSV = new javax.swing.JLabel();
        lbTen = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lbSdt = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        lbGioiTinh = new javax.swing.JLabel();
        rbtnNam = new javax.swing.JRadioButton();
        rbtnNu = new javax.swing.JRadioButton();
        lbAvatar = new javax.swing.JLabel();
        lbDiaChi = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lbUpload = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSV = new javax.swing.JTable();
        pnlAccountStudent = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtUser1 = new javax.swing.JTextField();
        txtPass1 = new javax.swing.JTextField();
        txtConfirm1 = new javax.swing.JTextField();
        btnDoiMk = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNewPass = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbNameDaoTao = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1025, 586));

        pnlParent.setBackground(new java.awt.Color(255, 153, 51));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/graduated.png"))); // NOI18N
        jLabel7.setText("FPT MANAGER");

        lbStudent.setBackground(new java.awt.Color(255, 255, 255));
        lbStudent.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbStudent.setForeground(new java.awt.Color(255, 255, 255));
        lbStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/best.png"))); // NOI18N
        lbStudent.setText("STUDENT");
        lbStudent.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbStudent.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        lbStudent.setInheritsPopupMenu(false);
        lbStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbStudentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbStudentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbStudentMouseExited(evt);
            }
        });

        lbAccount.setBackground(new java.awt.Color(255, 255, 255));
        lbAccount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbAccount.setForeground(new java.awt.Color(255, 255, 255));
        lbAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/account.png"))); // NOI18N
        lbAccount.setText("ACCOUNT");
        lbAccount.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAccountMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbAccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbAccountMouseExited(evt);
            }
        });

        lbLogOut.setBackground(new java.awt.Color(255, 255, 255));
        lbLogOut.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbLogOut.setForeground(new java.awt.Color(255, 255, 255));
        lbLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/turn-off.png"))); // NOI18N
        lbLogOut.setText("LOG OUT");
        lbLogOut.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLogOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbLogOutMouseExited(evt);
            }
        });

        pnlStudent.setBackground(new java.awt.Color(255, 255, 255));

        lbMaSV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMaSV.setForeground(new java.awt.Color(255, 153, 51));
        lbMaSV.setText("Mã Sinh viên :");

        lbTen.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTen.setForeground(new java.awt.Color(255, 153, 51));
        lbTen.setText("Tên :");

        lbEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(255, 153, 51));
        lbEmail.setText("Email :");

        lbSdt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbSdt.setForeground(new java.awt.Color(255, 153, 51));
        lbSdt.setText("Sdt :");

        lbGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbGioiTinh.setForeground(new java.awt.Color(255, 153, 51));
        lbGioiTinh.setText("Giới Tính :");

        buttonGroup1.add(rbtnNam);
        rbtnNam.setSelected(true);
        rbtnNam.setText("Nam");

        buttonGroup1.add(rbtnNu);
        rbtnNu.setText("Nữ");

        lbAvatar.setBackground(new java.awt.Color(255, 102, 102));
        lbAvatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add-image.png"))); // NOI18N

        lbDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbDiaChi.setForeground(new java.awt.Color(255, 153, 51));
        lbDiaChi.setText("Địa chỉ :");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane2.setViewportView(txtDiaChi);

        btnNew.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/addition.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loop.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete-button.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lbUpload.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbUpload.setForeground(new java.awt.Color(51, 51, 255));
        lbUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cloud-computing.png"))); // NOI18N
        lbUpload.setText("Upload");
        lbUpload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbUpload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbUploadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbUploadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbUploadMouseExited(evt);
            }
        });

        tblSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSV.setAutoscrolls(false);
        tblSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSVMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSV);

        javax.swing.GroupLayout pnlStudentLayout = new javax.swing.GroupLayout(pnlStudent);
        pnlStudent.setLayout(pnlStudentLayout);
        pnlStudentLayout.setHorizontalGroup(
            pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStudentLayout.createSequentialGroup()
                .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlStudentLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlStudentLayout.createSequentialGroup()
                                    .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbMaSV))
                                    .addGap(27, 27, 27)
                                    .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                        .addComponent(txtMa)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStudentLayout.createSequentialGroup()
                                    .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbGioiTinh)
                                        .addComponent(lbSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(60, 60, 60)
                                    .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pnlStudentLayout.createSequentialGroup()
                                            .addComponent(rbtnNam)
                                            .addGap(52, 52, 52)
                                            .addComponent(rbtnNu))
                                        .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(lbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(176, 176, 176))
                    .addGroup(pnlStudentLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnUpdate)
                        .addGap(71, 71, 71)))
                .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete)
                    .addGroup(pnlStudentLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(lbUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
            .addComponent(jScrollPane3)
        );
        pnlStudentLayout.setVerticalGroup(
            pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStudentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStudentLayout.createSequentialGroup()
                        .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMaSV, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTen)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSdt)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlStudentLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(lbGioiTinh))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbtnNam)
                                .addComponent(rbtnNu)))
                        .addGap(29, 29, 29)
                        .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDiaChi)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStudentLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addGap(52, 52, 52)
                .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(261, 261, 261))
        );

        pnlAccountStudent.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 204, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/account.png"))); // NOI18N
        jLabel6.setText("Đổi Mật Khẩu");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 102, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/account.png"))); // NOI18N
        jLabel8.setText("User name");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lock.png"))); // NOI18N
        jLabel9.setText("Password");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/check.png"))); // NOI18N
        jLabel10.setText("Confirm");

        btnDoiMk.setBackground(new java.awt.Color(51, 255, 51));
        btnDoiMk.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDoiMk.setText("OK");
        btnDoiMk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMkActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lock.png"))); // NOI18N
        jLabel1.setText("New Password");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/contact.png"))); // NOI18N
        jLabel11.setText("Mọi Thắc mắc liên hệ :tranthequan22051997@gmail.com/Sdt :0971787297");

        javax.swing.GroupLayout pnlAccountStudentLayout = new javax.swing.GroupLayout(pnlAccountStudent);
        pnlAccountStudent.setLayout(pnlAccountStudentLayout);
        pnlAccountStudentLayout.setHorizontalGroup(
            pnlAccountStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccountStudentLayout.createSequentialGroup()
                .addGroup(pnlAccountStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAccountStudentLayout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAccountStudentLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jLabel11))
                    .addGroup(pnlAccountStudentLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addGroup(pnlAccountStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDoiMk, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlAccountStudentLayout.createSequentialGroup()
                                .addGroup(pnlAccountStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(46, 46, 46)
                                .addGroup(pnlAccountStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUser1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                    .addComponent(txtPass1)
                                    .addComponent(txtConfirm1)
                                    .addComponent(txtNewPass))))))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        pnlAccountStudentLayout.setVerticalGroup(
            pnlAccountStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccountStudentLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addGap(48, 48, 48)
                .addGroup(pnlAccountStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtUser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAccountStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlAccountStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnlAccountStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtConfirm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnDoiMk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlAccountStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlStudent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlAccountStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customer.png"))); // NOI18N
        jLabel2.setText("HELLO PHÒNG ĐÀO TẠO ");

        lbNameDaoTao.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        lbNameDaoTao.setForeground(new java.awt.Color(175, 243, 243));
        lbNameDaoTao.setText("Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customer.png"))); // NOI18N
        jLabel3.setText("Tài khoản đang hoạt động :");

        javax.swing.GroupLayout pnlParentLayout = new javax.swing.GroupLayout(pnlParent);
        pnlParent.setLayout(pnlParentLayout);
        pnlParentLayout.setHorizontalGroup(
            pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbLogOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNameDaoTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlParentLayout.setVerticalGroup(
            pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlParentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlContent, javax.swing.GroupLayout.PREFERRED_SIZE, 594, Short.MAX_VALUE)
                    .addGroup(pnlParentLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNameDaoTao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(lbStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                        .addComponent(lbLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlParent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlParent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbStudentMouseClicked
        pnlStudent.setVisible(true);
        pnlAccountStudent.setVisible(false);
    }//GEN-LAST:event_lbStudentMouseClicked

    private void lbStudentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbStudentMouseEntered
        lbStudent.setForeground(Color.RED);
    }//GEN-LAST:event_lbStudentMouseEntered

    private void lbStudentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbStudentMouseExited
        lbStudent.setForeground(Color.WHITE);
    }//GEN-LAST:event_lbStudentMouseExited

    private void lbAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAccountMouseClicked
        pnlStudent.setVisible(false);
        pnlAccountStudent.setVisible(true);
    }//GEN-LAST:event_lbAccountMouseClicked

    private void lbAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAccountMouseEntered
        lbAccount.setForeground(Color.RED);
    }//GEN-LAST:event_lbAccountMouseEntered

    private void lbAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAccountMouseExited
        lbAccount.setForeground(Color.WHITE);
    }//GEN-LAST:event_lbAccountMouseExited

    private void lbLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogOutMouseEntered
        lbLogOut.setForeground(Color.RED);
    }//GEN-LAST:event_lbLogOutMouseEntered

    private void lbLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogOutMouseExited
        lbLogOut.setForeground(Color.WHITE);
    }//GEN-LAST:event_lbLogOutMouseExited

    private void lbLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogOutMouseClicked
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_lbLogOutMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtMa.setText("");
        txtTen.setText("");
        txtEmail.setText("");
        txtDiaChi.setText("");
        txtSdt.setText("");
        rbtnNam.setSelected(true);
        lbAvatar.setIcon(_defaultAvatar);
        _arrAvatar = null;
        showDataToTable(_listSV);

    }//GEN-LAST:event_btnNewActionPerformed

    private boolean checkClickTable() {
        int row = tblSV.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(pnlContent, "Vui lòng Click vào Sinh viên trong Bảng");
            return false;
        }
        return true;
    }

    private boolean checkEmpty() {
        if (txtMa.getText().isEmpty() || txtTen.getText().isEmpty() || txtEmail.getText().isEmpty()
                || txtSdt.getText().isEmpty() || txtDiaChi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(pnlContent, "Không được để trống");
            return false;
        }

        return true;
    }

    private boolean checkExisted(List<SinhVien> list, String maSv) {
        for (SinhVien sv : list) {
            if (sv.getMaSV().equals(maSv)) {
                JOptionPane.showMessageDialog(pnlContent, "Mã sinh viên đã tồn tại");
                return false;
            }
        }
        return true;
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (checkEmpty()) {
            SinhVien sv = new SinhVien();
            if (checkExisted(_listSV, txtMa.getText())
                    && _svs.checkValidate(txtMa.getText(), txtEmail.getText(), txtSdt.getText(), pnlContent)) {
                sv.setMaSV(txtMa.getText());
                sv.setTenSV(txtTen.getText());
                sv.setEmail(txtEmail.getText());
                sv.setSdt(txtSdt.getText());
                sv.setDiaChi(txtDiaChi.getText());
                if (rbtnNam.isSelected()) {
                    sv.setGioiTinh("Nam");
                } else {
                    sv.setGioiTinh("Nữ");

                }
                sv.setAvatar(_arrAvatar);
                _svs.addSinhVien(sv);
                _listSV = _svs.getAllSinhVien();
                showDataToTable(_listSV);
                JOptionPane.showMessageDialog(pnlContent, "Save Success !");
            }

        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void lbUploadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUploadMouseEntered
        lbUpload.setForeground(Color.red);
    }//GEN-LAST:event_lbUploadMouseEntered

    private void lbUploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUploadMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        int x = fileChooser.showOpenDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();//return file selected-gán path cho File
            Image img = new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(lbAvatar.getWidth(), lbAvatar.getHeight(), Image.SCALE_SMOOTH);
            lbAvatar.setIcon(new ImageIcon(img));//tao đối tượng ImageIcon(lấy path file truyền vào)rồi seticon cho label
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "png", baos);
                _arrAvatar = new byte[baos.toByteArray().length];
                _arrAvatar = baos.toByteArray();

            } catch (IOException ex) {
                Logger.getLogger(QLSinhVien.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_lbUploadMouseClicked

    private void lbUploadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUploadMouseExited
        lbUpload.setForeground(Color.BLUE);

    }//GEN-LAST:event_lbUploadMouseExited

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tblSV.getSelectedRow();
        if (checkClickTable()) {
            _svs.deleteSinhVien(tblSV.getValueAt(row, 0).toString());
            _listSV = _svs.getAllSinhVien();
            showDataToTable(_listSV);
            btnNewActionPerformed(evt);
            JOptionPane.showMessageDialog(pnlContent, "Delete Success !");
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnDoiMkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMkActionPerformed
        int count = 0;
        TaiKhoanRepository tkDao = new TaiKhoanRepository();
        List<TaiKhoan> listTK = tkDao.getAllTaiKhoan();
        for (TaiKhoan tk : listTK) {
            if (txtUser1.getText().equals(tk.getUserName()) && txtPass1.getText().equals(String.valueOf(tk.getPassWord()))) {
                count++;
                if (txtNewPass.getText().equals(txtConfirm1.getText())) {
                    tkDao.changePass(tk.getUserName(), txtNewPass.getText());
                    JOptionPane.showMessageDialog(pnlContent, "Success !");
                    this.setVisible(false);
                    new Login().setVisible(true);
                    break;
                } else {
                    JOptionPane.showMessageDialog(pnlContent, "Mật khẩu mới không khớp với Confirm", "Cảnh báo", JOptionPane.WARNING_MESSAGE);

                    break;
                }
            }
        }
        if (count == 0) {
            JOptionPane.showMessageDialog(pnlContent, "Tài khoản hoặc mật khẩu không chính xác", "Cảnh báo", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btnDoiMkActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int count = 0;
        if (checkClickTable()) {
            if (!_locationUpdate.equals(txtMa.getText())) {
                for (SinhVien sv : _listSV) {
                    if (sv.getMaSV().equalsIgnoreCase(txtMa.getText())) {
                        JOptionPane.showMessageDialog(pnlContent, "Mã Sv đã tồn tại, ko thể Update");
                        count++;
                        break;
                    }
                }
                if (count == 0 && _svs.checkValidate(txtMa.getText(), txtEmail.getText(), txtSdt.getText(), pnlContent)) {
                    new GradeService().deleteGrade(_locationUpdate);
                    _svs.updateSinhVien(_locationUpdate, txtMa.getText(), txtTen.getText(), txtEmail.getText(),
                            txtSdt.getText(), rbtnNam.isSelected() ? "Nam" : "Nữ", txtDiaChi.getText(), _arrAvatar);
                    _listSV = _svs.getAllSinhVien();
                    btnNewActionPerformed(evt);
                    showDataToTable(_listSV);
                    JOptionPane.showMessageDialog(pnlContent, "Update Success !");
                }
            } else {
                if (count == 0 && _svs.checkValidate(txtMa.getText(), txtEmail.getText(), txtSdt.getText(), pnlContent)) {
                    _svs.updateSinhVien(_locationUpdate, txtMa.getText(), txtTen.getText(), txtEmail.getText(),
                            txtSdt.getText(), rbtnNam.isSelected() ? "Nam" : "Nữ", txtDiaChi.getText(), _arrAvatar);
                    _listSV = _svs.getAllSinhVien();
                    showDataToTable(_listSV);
                    btnNewActionPerformed(evt);
                    JOptionPane.showMessageDialog(pnlContent, "Update Success !");
                }
            }

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSVMouseClicked
        int row = tblSV.getSelectedRow();
        _locationUpdate = tblSV.getValueAt(row, 0).toString();
        fillDataToForm(_listSV, row);
    }//GEN-LAST:event_tblSVMouseClicked

    private void fillDataToForm(List<SinhVien> list, int index) {
        txtMa.setText(list.get(index).getMaSV());
        txtTen.setText(list.get(index).getTenSV());
        txtEmail.setText(list.get(index).getEmail());
        txtSdt.setText(list.get(index).getSdt());
        txtDiaChi.setText(list.get(index).getDiaChi());
        if (list.get(index).getGioiTinh().equalsIgnoreCase("Nam")) {
            rbtnNam.setSelected(true);
        } else {
            rbtnNu.setSelected(true);
        }
        _arrAvatar = list.get(index).getAvatar();
        if (_arrAvatar != null) {
            Image img = new ImageIcon(_arrAvatar).getImage().getScaledInstance(lbAvatar.getWidth(), lbAvatar.getHeight(), Image.SCALE_SMOOTH);
            lbAvatar.setIcon(new ImageIcon(img));
        } else {
            lbAvatar.setIcon(_defaultAvatar);

        }

    }

    private void showDataToTable(List<SinhVien> list) {
        _dtm.setRowCount(0);
        for (SinhVien sv : list) {
            _dtm.addRow(sv.getDataSinhVien());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDoiMk;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbAccount;
    private javax.swing.JLabel lbAvatar;
    private javax.swing.JLabel lbDiaChi;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGioiTinh;
    private javax.swing.JLabel lbLogOut;
    private javax.swing.JLabel lbMaSV;
    private javax.swing.JLabel lbNameDaoTao;
    private javax.swing.JLabel lbSdt;
    private javax.swing.JLabel lbStudent;
    private javax.swing.JLabel lbTen;
    private javax.swing.JLabel lbUpload;
    private javax.swing.JPanel pnlAccountStudent;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlParent;
    private javax.swing.JPanel pnlStudent;
    private javax.swing.JRadioButton rbtnNam;
    private javax.swing.JRadioButton rbtnNu;
    private javax.swing.JTable tblSV;
    private javax.swing.JTextField txtConfirm1;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNewPass;
    private javax.swing.JTextField txtPass1;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtUser1;
    // End of variables declaration//GEN-END:variables
}
