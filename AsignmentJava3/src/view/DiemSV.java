package view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Grade;
import service.GradeService;
import service.SinhVienService;
import model.SinhVien;
import model.TaiKhoan;
import repository.TaiKhoanRepository;

public class DiemSV extends javax.swing.JFrame {

    private DefaultTableModel _dtm;
    private List<Grade> _listGrade;
    private GradeService _gsv;
    private String _locationUpdate;
    private String _nameSV;
    private int _indexPrev;
    private int _indexNext;

    public DiemSV(String userCurrent) {
        initComponents();
        pnlGrade.setVisible(true);
        pnlAccount.setVisible(false);
        _listGrade = new ArrayList<>();
        _gsv = new GradeService();
        _dtm = new DefaultTableModel();
        _listGrade = _gsv.getAllGrade();
        tblDiem.setModel(_dtm);
        String columnName[] = {"Mã Sinh Viên", "Tên", "Tiếng Anh", "Tin", "Giáo dục TC", "Điểm TB"};
        _dtm.setColumnIdentifiers(columnName);
        showDatatoTable(_listGrade);
        lbNameGV.setText(userCurrent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlParent = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbLogOut = new javax.swing.JLabel();
        lbAccount = new javax.swing.JLabel();
        lbGrage = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();
        pnlGrade = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtTiengAnh = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTin = new javax.swing.JTextField();
        txtGiaoDuc = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        lbMark = new javax.swing.JLabel();
        btnLast = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDiem = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        pnlAccount = new javax.swing.JPanel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtConfirm = new javax.swing.JTextField();
        btnDoiMK = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNewPass = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbNameGV = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÍ ĐIỂM SINH VIÊN");
        setBackground(new java.awt.Color(204, 197, 134));
        setSize(new java.awt.Dimension(1025, 586));

        pnlParent.setBackground(new java.awt.Color(255, 153, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/graduated.png"))); // NOI18N
        jLabel1.setText("FPT MANAGER");

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

        lbGrage.setBackground(new java.awt.Color(255, 255, 255));
        lbGrage.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbGrage.setForeground(new java.awt.Color(255, 255, 255));
        lbGrage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/best.png"))); // NOI18N
        lbGrage.setText("GRADE");
        lbGrage.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbGrage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbGrage.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        lbGrage.setInheritsPopupMenu(false);
        lbGrage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbGrageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbGrageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbGrageMouseExited(evt);
            }
        });

        pnlContent.setPreferredSize(new java.awt.Dimension(765, 520));

        pnlGrade.setBackground(new java.awt.Color(255, 255, 255));
        pnlGrade.setPreferredSize(new java.awt.Dimension(765, 520));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 153, 51));
        jLabel15.setText("Họ và tên :");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 153, 51));
        jLabel16.setText("Mã Sinh viên");

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

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 255));
        jLabel17.setText("Tiếng anh :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 255));
        jLabel18.setText("Tin học :");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 255));
        jLabel19.setText("Giáo dục TC :");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 255));
        jLabel20.setText("ĐIỂM TB:");

        lbMark.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbMark.setForeground(new java.awt.Color(255, 51, 51));
        lbMark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/token.png"))); // NOI18N

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/next.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/previous.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/right-arrow.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/left-arrow.png"))); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        jLabel21.setText("Mã Sinh viên");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblDiem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "mã SV", "Tên", "Tiếng anh", "Tin học", "Giáo dục TC", "Điểm TB"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDiemMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDiem);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/best.png"))); // NOI18N
        jLabel9.setText("Top 5 Sv Điểm TB cao nhất");

        javax.swing.GroupLayout pnlGradeLayout = new javax.swing.GroupLayout(pnlGrade);
        pnlGrade.setLayout(pnlGradeLayout);
        pnlGradeLayout.setHorizontalGroup(
            pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGradeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(txtMa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlGradeLayout.createSequentialGroup()
                        .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlGradeLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(txtGiaoDuc, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGradeLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTin, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlGradeLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38)
                        .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlGradeLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbMark, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
            .addComponent(jScrollPane3)
            .addGroup(pnlGradeLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGradeLayout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(35, 408, Short.MAX_VALUE))
                    .addGroup(pnlGradeLayout.createSequentialGroup()
                        .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlGradeLayout.createSequentialGroup()
                                .addGap(242, 242, 242)
                                .addComponent(jLabel9))
                            .addGroup(pnlGradeLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlGradeLayout.setVerticalGroup(
            pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGradeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlGradeLayout.createSequentialGroup()
                        .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlGradeLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlGradeLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(txtTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(26, 26, 26)
                        .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(txtGiaoDuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMark, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(67, 67, 67)
                        .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlGradeLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(pnlGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnLast, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNext, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlAccount.setBackground(new java.awt.Color(255, 255, 255));
        pnlAccount.setPreferredSize(new java.awt.Dimension(765, 520));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/check.png"))); // NOI18N
        jLabel2.setText("Confirm");

        btnDoiMK.setBackground(new java.awt.Color(51, 255, 51));
        btnDoiMK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDoiMK.setText("OK");
        btnDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMKActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/account.png"))); // NOI18N
        jLabel3.setText("User name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lock.png"))); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 204, 0));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/account.png"))); // NOI18N
        jLabel5.setText("Đổi Mật Khẩu");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lock.png"))); // NOI18N
        jLabel6.setText("New Password");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/contact.png"))); // NOI18N
        jLabel7.setText("Mọi Thắc mắc liên hệ :tranthequan22051997@gmail.com/Sdt :0971787297");

        javax.swing.GroupLayout pnlAccountLayout = new javax.swing.GroupLayout(pnlAccount);
        pnlAccount.setLayout(pnlAccountLayout);
        pnlAccountLayout.setHorizontalGroup(
            pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccountLayout.createSequentialGroup()
                .addGroup(pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAccountLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlAccountLayout.createSequentialGroup()
                                .addGroup(pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlAccountLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlAccountLayout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlAccountLayout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAccountLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtConfirm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnDoiMK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(pnlAccountLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel7)))
                .addContainerGap(236, Short.MAX_VALUE))
        );
        pnlAccountLayout.setVerticalGroup(
            pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccountLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addGap(53, 53, 53)
                .addGroup(pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(btnDoiMK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGrade, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
            .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE))
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGrade, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
            .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customer.png"))); // NOI18N
        jLabel8.setText("HELLO GIÁO VIÊN");

        lbNameGV.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        lbNameGV.setForeground(new java.awt.Color(0, 153, 0));
        lbNameGV.setText("name");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customer.png"))); // NOI18N
        jLabel10.setText("Tài khoản đang hoạt động :");

        javax.swing.GroupLayout pnlParentLayout = new javax.swing.GroupLayout(pnlParent);
        pnlParent.setLayout(pnlParentLayout);
        pnlParentLayout.setHorizontalGroup(
            pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(lbGrage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNameGV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlParentLayout.setVerticalGroup(
            pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                    .addGroup(pnlParentLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNameGV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(lbGrage, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(202, 202, 202)
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


    private void lbGrageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGrageMouseClicked
        pnlGrade.setVisible(true);
        pnlAccount.setVisible(false);
    }//GEN-LAST:event_lbGrageMouseClicked

    private void lbAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAccountMouseClicked
        pnlGrade.setVisible(false);
        pnlAccount.setVisible(true);
    }//GEN-LAST:event_lbAccountMouseClicked

    private void lbGrageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGrageMouseEntered
        lbGrage.setForeground(Color.RED);
    }//GEN-LAST:event_lbGrageMouseEntered

    private void lbGrageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGrageMouseExited
        lbGrage.setForeground(Color.WHITE);
    }//GEN-LAST:event_lbGrageMouseExited

    private void lbAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAccountMouseExited
        lbAccount.setForeground(Color.WHITE);
    }//GEN-LAST:event_lbAccountMouseExited

    private void lbAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAccountMouseEntered
        lbAccount.setForeground(Color.RED);
    }//GEN-LAST:event_lbAccountMouseEntered

    private void lbLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogOutMouseExited
        lbLogOut.setForeground(Color.WHITE);
    }//GEN-LAST:event_lbLogOutMouseExited

    private void lbLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogOutMouseEntered
        lbLogOut.setForeground(Color.RED);
    }//GEN-LAST:event_lbLogOutMouseEntered

    private void lbLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogOutMouseClicked
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_lbLogOutMouseClicked

    private boolean checkClickTable() {
        int row = tblDiem.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(pnlContent, "Vui lòng Click vào Sinh viên trong Bảng Điểm");
            return false;
        }
        return true;
    }

    private void showDatatoTable(List<Grade> list) {
        _dtm.setRowCount(0);
        list.sort((o1, o2) -> {
            return Double.compare(o2.getDiemTb(), o1.getDiemTb());
        });
        for (Grade grade : list) {
            _dtm.addRow(grade.getDataGrade());
            if (_dtm.getRowCount() == 5) {
                break;
            }
        }
    }

    private void fillDatatoForm(int row) {
        txtMa.setText(tblDiem.getValueAt(row, 0).toString());
        txtTen.setText(tblDiem.getValueAt(row, 1).toString());
        txtTiengAnh.setText(tblDiem.getValueAt(row, 2).toString());
        txtTin.setText(tblDiem.getValueAt(row, 3).toString());
        txtGiaoDuc.setText(tblDiem.getValueAt(row, 4).toString());
        lbMark.setText(tblDiem.getValueAt(row, 5).toString());

    }
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtTen.setText("");
        txtMa.setText("");
        txtTiengAnh.setText("");
        txtTin.setText("");
        txtGiaoDuc.setText("");
        txtSearch.setText("");
        lbMark.setText("");
        _listGrade = _gsv.getAllGrade();
        showDatatoTable(_listGrade);
    }//GEN-LAST:event_btnNewActionPerformed

    private boolean checkEmpty() {
        if (txtTiengAnh.getText().isEmpty() || txtTin.getText().isEmpty() || txtGiaoDuc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(pnlContent, "Ko được để trống điểm số !", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean checkExistOfSvFormGrade() {
        for (Grade grade : _listGrade) {
            if (grade.getMaSV().equalsIgnoreCase(txtMa.getText())) {
                JOptionPane.showMessageDialog(pnlContent, "Sinh Viên đã có điểm,ko thể thêm !");
                return false;
            }
        }
        return true;
    }

    private boolean checkExistOfSvFormStudent() {
        List<SinhVien> listSV = new ArrayList<>();
        listSV = new SinhVienService().getAllSinhVien();
        for (SinhVien sv : listSV) {
            if (sv.getMaSV().equals(txtMa.getText()) && sv.getTenSV().equalsIgnoreCase(txtTen.getText())) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(pnlContent, "Sinh viên này không tồn tại.Vui lòng kiểm tra lại Tên hoặc mã SV");
        return false;
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (checkEmpty() && checkExistOfSvFormGrade() && checkExistOfSvFormStudent()) {
            Grade grade = new Grade();
            grade.setMaSV(txtMa.getText());
            grade.setTiengAnh(Integer.parseInt(txtTiengAnh.getText()));
            grade.setTinHoc(Integer.parseInt(txtTin.getText()));
            grade.setGiaoDucTC(Integer.parseInt(txtGiaoDuc.getText()));
            new GradeService().addGrade(grade);
            _listGrade = _gsv.getAllGrade();
            showDatatoTable(_listGrade);
            JOptionPane.showMessageDialog(pnlContent, "Save Success !");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (checkClickTable()) {
            if (checkEmpty() && checkExistOfSvFormStudent()) {
                if (!_locationUpdate.equals(txtMa.getText()) || !_nameSV.equalsIgnoreCase(txtTen.getText())) {
                    JOptionPane.showMessageDialog(pnlContent, "Bạn ko đủ thẩm quyền để thay đổi mã Sinh viên SV", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (_gsv.checkNumberGrade(txtTiengAnh.getText()) && _gsv.checkNumberGrade(txtTin.getText()) && _gsv.checkNumberGrade(txtGiaoDuc.getText())) {
                        _gsv.updateGrade(_locationUpdate, txtMa.getText(),
                                Integer.parseInt(txtTiengAnh.getText()),
                                Integer.parseInt(txtTin.getText()),
                                Integer.parseInt(txtGiaoDuc.getText()));
                        _listGrade = _gsv.getAllGrade();
                        showDatatoTable(_listGrade);
                        btnNewActionPerformed(evt);
                        JOptionPane.showMessageDialog(pnlContent, "Update Success !");
                    } else {
                        JOptionPane.showMessageDialog(pnlContent, "Điểm phải là số !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                    }

                }

            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (checkClickTable()) {
            _gsv.deleteGrade(txtMa.getText());
            _listGrade = _gsv.getAllGrade();
            showDatatoTable(_listGrade);
            btnNewActionPerformed(evt);
            JOptionPane.showMessageDialog(pnlContent, "Delete Success !");
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        List<Grade> listSearch = new ArrayList<>();
        if (txtSearch.getText().isEmpty()) {
            JOptionPane.showMessageDialog(pnlContent, "Vui lòng nhập mã SV cần tìm !");
        } else {
            for (Grade grade : _listGrade) {
                if (txtSearch.getText().equals(grade.getMaSV())) {
                    listSearch.add(grade);
                    showDatatoTable(listSearch);
                    break;
                }
            }
            if (listSearch.size() == 0) {
                JOptionPane.showMessageDialog(pnlContent, "Sinh viên chưa có trong bảng điểm !");
            }
            listSearch.clear();
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        tblDiem.setRowSelectionInterval(0, 0);
        fillDatatoForm(0);
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        tblDiem.setRowSelectionInterval(_dtm.getRowCount() - 1, _dtm.getRowCount() - 1);
        fillDatatoForm(_dtm.getRowCount() - 1);

    }//GEN-LAST:event_btnLastActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        if (_indexPrev < 0) {
            _indexPrev = _dtm.getRowCount() - 1;
        }
        tblDiem.setRowSelectionInterval(_indexPrev, _indexPrev);
        fillDatatoForm(_indexPrev);
        _indexNext = _indexPrev + 1;
        _indexPrev--;
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (_indexNext == _dtm.getRowCount()) {
            _indexNext = 0;
        }
        tblDiem.setRowSelectionInterval(_indexNext, _indexNext);
        fillDatatoForm(_indexNext);
        _indexPrev = _indexNext - 1;
        _indexNext++;
    }//GEN-LAST:event_btnNextActionPerformed

    private void tblDiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDiemMouseClicked
        int row = tblDiem.getSelectedRow();
        _locationUpdate = tblDiem.getValueAt(row, 0).toString();
        _nameSV = tblDiem.getValueAt(row, 1).toString();
        fillDatatoForm(row);
    }//GEN-LAST:event_tblDiemMouseClicked

    private void btnDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMKActionPerformed
        int count = 0;
        TaiKhoanRepository tkDao = new TaiKhoanRepository();
        List<TaiKhoan> listTK = tkDao.getAllTaiKhoan();
        for (TaiKhoan tk : listTK) {
            if (txtUser.getText().equals(tk.getUserName()) && txtPass.getText().equals(String.valueOf(tk.getPassWord()))) {
                count++;
                if (txtNewPass.getText().equals(txtConfirm.getText())) {
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
    }//GEN-LAST:event_btnDoiMKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDoiMK;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbAccount;
    private javax.swing.JLabel lbGrage;
    private javax.swing.JLabel lbLogOut;
    private javax.swing.JLabel lbMark;
    private javax.swing.JLabel lbNameGV;
    private javax.swing.JPanel pnlAccount;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlGrade;
    private javax.swing.JPanel pnlParent;
    private javax.swing.JTable tblDiem;
    private javax.swing.JTextField txtConfirm;
    private javax.swing.JTextField txtGiaoDuc;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNewPass;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTiengAnh;
    private javax.swing.JTextField txtTin;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
