package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.TaiKhoan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import service.TaiKhoanService;

public class Login extends javax.swing.JFrame {

    private List<TaiKhoan> _listTk;
    private CardLayout _cardLayout;
    private TaiKhoanService _tks;

    public Login() {
        initComponents();
        ImageIcon img = new ImageIcon("C:\\Users\\trant\\OneDrive\\Desktop\\Java3_project\\AsignmentJava3\\src\\icon\\logo-fpt-polytechnic-inkythuatso-09-12-57-46.jpg");
        this.setIconImage(img.getImage());
        this.getContentPane().setBackground(Color.WHITE);
        _listTk = new ArrayList<>();
        _tks = new TaiKhoanService();
        _listTk = _tks.getAllTaiKhoan();
        _cardLayout = (CardLayout) pnlContent.getLayout();
        _cardLayout.show(pnlContent, "login");
        PnlQuyDinhDK.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContent = new javax.swing.JPanel();
        pnlDangKi = new javax.swing.JPanel();
        lbOngVang = new javax.swing.JLabel();
        txtDKTaiKhoan = new javax.swing.JTextField();
        txtDKMK = new javax.swing.JTextField();
        btnDangKi = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDkXacNhan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDkHoTen = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnDkHuy = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cbbloaiTk = new javax.swing.JComboBox<>();
        lbQuyDinhDK = new javax.swing.JLabel();
        PnlQuyDinhDK = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnDongQuyDinh = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        pnlLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lbDangKi = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FPT SCHOOL MANAGER");
        setUndecorated(true);

        pnlContent.setBackground(new java.awt.Color(255, 121, 29));
        pnlContent.setLayout(new java.awt.CardLayout());

        pnlDangKi.setBackground(new java.awt.Color(255, 113, 66));
        pnlDangKi.setName("dangki"); // NOI18N

        lbOngVang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ongvag.png"))); // NOI18N

        btnDangKi.setBackground(new java.awt.Color(255, 204, 102));
        btnDangKi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDangKi.setForeground(new java.awt.Color(51, 153, 0));
        btnDangKi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customer.png"))); // NOI18N
        btnDangKi.setText("Đăng Kí");
        btnDangKi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKiActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tài khoản");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Mật khẩu");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Xác nhận mật khẩu");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Họ và Tên");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo-fpt-polytechnic-inkythuatso-09-12-57-46.jpg"))); // NOI18N

        btnDkHuy.setBackground(new java.awt.Color(255, 204, 0));
        btnDkHuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDkHuy.setForeground(new java.awt.Color(51, 153, 0));
        btnDkHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/turn-off.png"))); // NOI18N
        btnDkHuy.setText("Hủy");
        btnDkHuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDkHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDkHuyActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Loại Tài Khoản");

        cbbloaiTk.setBackground(new java.awt.Color(153, 204, 255));
        cbbloaiTk.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        cbbloaiTk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đào Tạo", "Giảng Viên" }));
        cbbloaiTk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbbloaiTk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbloaiTkActionPerformed(evt);
            }
        });

        lbQuyDinhDK.setForeground(new java.awt.Color(255, 255, 255));
        lbQuyDinhDK.setText("Quy định đăng kí tài khoản !");
        lbQuyDinhDK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbQuyDinhDK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQuyDinhDKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbQuyDinhDKMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbQuyDinhDKMouseExited(evt);
            }
        });

        PnlQuyDinhDK.setBackground(new java.awt.Color(255, 153, 51));

        jTextArea1.setBackground(new java.awt.Color(255, 153, 51));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText("1.Tài khoản Giáo viên phải có dạng GVxxxxx\n2.Tài khoản Đào tạo phải có dạng DTxxxxxx\n3.Mọi vi phạm sẽ không thể đăng kí\n4.Ngiêm cấm các hành vi phát tán tài khoản\nra bên ngoài nội bộ nhà trường.Mọi vi phạm \nsẽ bị xử lí !\nChân thành cảm ơn !\n");
        jScrollPane1.setViewportView(jTextArea1);

        btnDongQuyDinh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDongQuyDinh.setForeground(new java.awt.Color(0, 153, 153));
        btnDongQuyDinh.setText("Đóng");
        btnDongQuyDinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongQuyDinhActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/role-playing-game.png"))); // NOI18N

        javax.swing.GroupLayout PnlQuyDinhDKLayout = new javax.swing.GroupLayout(PnlQuyDinhDK);
        PnlQuyDinhDK.setLayout(PnlQuyDinhDKLayout);
        PnlQuyDinhDKLayout.setHorizontalGroup(
            PnlQuyDinhDKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlQuyDinhDKLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PnlQuyDinhDKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlQuyDinhDKLayout.createSequentialGroup()
                        .addComponent(btnDongQuyDinh)
                        .addGap(102, 102, 102))))
        );
        PnlQuyDinhDKLayout.setVerticalGroup(
            PnlQuyDinhDKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
            .addGroup(PnlQuyDinhDKLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDongQuyDinh)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout pnlDangKiLayout = new javax.swing.GroupLayout(pnlDangKi);
        pnlDangKi.setLayout(pnlDangKiLayout);
        pnlDangKiLayout.setHorizontalGroup(
            pnlDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDangKiLayout.createSequentialGroup()
                .addComponent(lbOngVang, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDangKiLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDangKiLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(pnlDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13))
                        .addGap(103, 103, 103)
                        .addGroup(pnlDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(pnlDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtDkXacNhan)
                                        .addComponent(txtDKMK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtDKTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDkHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDangKiLayout.createSequentialGroup()
                                    .addComponent(btnDangKi)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDkHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlDangKiLayout.createSequentialGroup()
                                .addComponent(cbbloaiTk, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lbQuyDinhDK, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(pnlDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDangKiLayout.createSequentialGroup()
                    .addContainerGap(590, Short.MAX_VALUE)
                    .addComponent(PnlQuyDinhDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        pnlDangKiLayout.setVerticalGroup(
            pnlDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDangKiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(pnlDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbloaiTk, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(lbQuyDinhDK))
                .addGap(56, 56, 56)
                .addGroup(pnlDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDkHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(29, 29, 29)
                .addGroup(pnlDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDKTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(pnlDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDKMK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDkXacNhan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(pnlDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDkHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
            .addComponent(lbOngVang, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(pnlDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDangKiLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PnlQuyDinhDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(514, Short.MAX_VALUE)))
        );

        pnlContent.add(pnlDangKi, "dangki");

        pnlLogin.setBackground(new java.awt.Color(255, 153, 0));
        pnlLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlLogin.setForeground(new java.awt.Color(255, 255, 255));
        pnlLogin.setName("login"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/account.png"))); // NOI18N
        jLabel1.setText("User name :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lock.png"))); // NOI18N
        jLabel2.setText("Password :");

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 102, 102));
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/enter.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(0, 153, 102));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/turn-off.png"))); // NOI18N
        btnCancel.setText("Exit");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lbDangKi.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lbDangKi.setForeground(new java.awt.Color(255, 255, 255));
        lbDangKi.setText("Bạn chưa có tài khoản ? Đăng kí");
        lbDangKi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbDangKi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDangKiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbDangKiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbDangKiMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/contact.png"))); // NOI18N
        jLabel7.setText("Mọi Thắc mắc liên hệ :tranthequan22051997@gmail.com/Sdt :0971787297");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/polyANh.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Sitka Display", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("WELCOME TO FPOLY");

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                        .addGap(0, 365, Short.MAX_VALUE)
                        .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addComponent(btnLogin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(254, 254, 254))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(377, 377, 377))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                                .addComponent(lbDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(490, 490, 490))))
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlLoginLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin)
                    .addComponent(jLabel2)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(lbDangKi)
                .addGap(32, 32, 32)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        pnlContent.add(pnlLogin, "login");

        getContentPane().add(pnlContent, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        int count = 0;
        for (TaiKhoan tk : _listTk) {
            if (txtUser.getText().equals(tk.getUserName()) && String.valueOf(pass.getPassword()).equals(tk.getPassWord())) {
                count++;
                if (txtUser.getText().substring(0, 2).equals("DT")) {
                    new QLSinhVien(tk.getUserName()).setVisible(true);
                    this.setVisible(false);
                }
                if (txtUser.getText().substring(0, 2).equals("GV")) {
                    new DiemSV(tk.getUserName()).setVisible(true);
                    this.setVisible(false);

                }
                break;
            }
        }
        if (count == 0) {
            JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không chính xác", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void lbDangKiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDangKiMouseEntered
        lbDangKi.setForeground(Color.red);
    }//GEN-LAST:event_lbDangKiMouseEntered

    private void lbDangKiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDangKiMouseExited
        lbDangKi.setForeground(Color.WHITE);

    }//GEN-LAST:event_lbDangKiMouseExited

    private void lbDangKiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDangKiMouseClicked
        _cardLayout.show(pnlContent, "dangki");
    }//GEN-LAST:event_lbDangKiMouseClicked

    private void btnDkHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDkHuyActionPerformed
        _cardLayout.show(pnlContent, "login");
    }//GEN-LAST:event_btnDkHuyActionPerformed

    private boolean checkEmptyDangKi() {
        if (txtDKTaiKhoan.getText().isBlank() || txtDKMK.getText().isBlank() || txtDkXacNhan.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Can not empty");
            return false;
        } else {
            return true;
        }
    }
    private void btnDangKiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKiActionPerformed
        if (checkEmptyDangKi()) {
            if (cbbloaiTk.getSelectedIndex() == 0) {
                if (_tks.checkRoleDaoTao(txtDKTaiKhoan.getText(), pnlDangKi)
                        && _tks.checkExisted(txtDKTaiKhoan.getText(), pnlDangKi)
                        && _tks.checkMatcherPass(txtDKMK.getText(), txtDkXacNhan.getText(), pnlDangKi)) {
                    _tks.addTaiKhoan(new TaiKhoan(txtDKTaiKhoan.getText(), txtDKMK.getText(), cbbloaiTk.getSelectedItem().toString()));
                    JOptionPane.showMessageDialog(pnlContent, "Đăng kí thành công");

                }
            } else if (cbbloaiTk.getSelectedIndex() == 1) {
                if (_tks.checkRoleGiangVien(txtDKTaiKhoan.getText(), pnlDangKi)
                        && _tks.checkExisted(txtDKTaiKhoan.getText(), pnlDangKi)
                        && _tks.checkMatcherPass(txtDKMK.getText(), txtDkXacNhan.getText(), pnlDangKi)) {
                    _tks.addTaiKhoan(new TaiKhoan(txtDKTaiKhoan.getText(), txtDKMK.getText(), cbbloaiTk.getSelectedItem().toString()));
                    JOptionPane.showMessageDialog(pnlContent, "Đăng kí thành công");

                }
            }
        }

    }//GEN-LAST:event_btnDangKiActionPerformed

    private void cbbloaiTkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbloaiTkActionPerformed
        if (cbbloaiTk.getSelectedIndex() == 0) {
            txtDKTaiKhoan.setText("DT");
        } else {
            txtDKTaiKhoan.setText("GV");

        }
    }//GEN-LAST:event_cbbloaiTkActionPerformed

    private void lbQuyDinhDKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQuyDinhDKMouseEntered
        lbQuyDinhDK.setForeground(Color.RED);
    }//GEN-LAST:event_lbQuyDinhDKMouseEntered

    private void lbQuyDinhDKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQuyDinhDKMouseExited
        lbQuyDinhDK.setForeground(Color.WHITE);
    }//GEN-LAST:event_lbQuyDinhDKMouseExited

    private void lbQuyDinhDKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQuyDinhDKMouseClicked
        PnlQuyDinhDK.setVisible(true);

    }//GEN-LAST:event_lbQuyDinhDKMouseClicked

    private void btnDongQuyDinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongQuyDinhActionPerformed
        PnlQuyDinhDK.setVisible(false);
    }//GEN-LAST:event_btnDongQuyDinhActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlQuyDinhDK;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDangKi;
    private javax.swing.JButton btnDkHuy;
    private javax.swing.JButton btnDongQuyDinh;
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<String> cbbloaiTk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbDangKi;
    private javax.swing.JLabel lbOngVang;
    private javax.swing.JLabel lbQuyDinhDK;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlDangKi;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JTextField txtDKMK;
    private javax.swing.JTextField txtDKTaiKhoan;
    private javax.swing.JTextField txtDkHoTen;
    private javax.swing.JTextField txtDkXacNhan;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
