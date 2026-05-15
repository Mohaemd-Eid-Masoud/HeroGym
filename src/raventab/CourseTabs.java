package raventab;

import java.sql.SQLException;
import menuPackage.MenuPage;
import newpackage.Course;
import newpackage.CourseBLL;
import newpackage.CourseDAL;

/**
 * Course management tabs screen.
 * Allows adding, searching, updating, and deleting gym courses.
 */
public class CourseTabs extends javax.swing.JFrame {

    public CourseTabs() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tabbedPane = new raventab.TabbedPaneCustom();
        // --- Registration Panel ---
        jPanelReg = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblPlan = new javax.swing.JLabel();
        txtCourseName = new javax.swing.JTextField();
        txtPlan = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnHomeReg = new javax.swing.JButton();
        btnExitReg = new javax.swing.JButton();
        lblHeroesReg = new javax.swing.JLabel();
        lblGymReg = new javax.swing.JLabel();
        lblQuote = new javax.swing.JLabel();
        // --- Profile Panel ---
        jPanelProfile = new javax.swing.JPanel();
        lblSearch = new javax.swing.JLabel();
        lblNameP = new javax.swing.JLabel();
        lblPlanP = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        txtCourseNameP = new javax.swing.JTextField();
        txtPlanP = new javax.swing.JTextField();
        btnGoOn = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblHeroes = new javax.swing.JLabel();
        lblGym = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        tabbedPane.setBackground(new java.awt.Color(204, 204, 204));
        tabbedPane.setForeground(new java.awt.Color(255, 255, 255));
        tabbedPane.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14));
        tabbedPane.setSelectedColor(new java.awt.Color(0, 0, 0));
        tabbedPane.setUnselectedColor(new java.awt.Color(102, 102, 102));

        // -------- Registration Tab --------
        jPanelReg.setBackground(new java.awt.Color(204, 204, 204));

        lblName.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14));
        lblName.setText("Course Name :");

        lblPlan.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14));
        lblPlan.setText("Plan / Description :");

        txtCourseName.setBackground(new java.awt.Color(153, 153, 153));
        txtCourseName.setFont(new java.awt.Font("Palatino Linotype", 1, 14));

        txtPlan.setBackground(new java.awt.Color(153, 153, 153));
        txtPlan.setFont(new java.awt.Font("Palatino Linotype", 1, 14));

        btnSubmit.setBackground(new java.awt.Color(0, 0, 0));
        btnSubmit.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14));
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnHomeReg.setBackground(new java.awt.Color(0, 0, 0));
        btnHomeReg.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14));
        btnHomeReg.setForeground(new java.awt.Color(255, 255, 255));
        btnHomeReg.setText("Home");
        btnHomeReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeRegActionPerformed(evt);
            }
        });

        btnExitReg.setBackground(new java.awt.Color(0, 0, 0));
        btnExitReg.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14));
        btnExitReg.setForeground(new java.awt.Color(255, 255, 255));
        btnExitReg.setText("EXIT");
        btnExitReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        lblHeroesReg.setFont(new java.awt.Font("Lucida Handwriting", 1, 18));
        lblHeroesReg.setForeground(new java.awt.Color(51, 51, 51));
        lblHeroesReg.setText("HEROES");

        lblGymReg.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14));
        lblGymReg.setForeground(new java.awt.Color(51, 51, 51));
        lblGymReg.setText("GYM");

        lblQuote.setFont(new java.awt.Font("Lucida Calligraphy", 1, 12));
        lblQuote.setForeground(new java.awt.Color(0, 102, 204));
        lblQuote.setText("\"Train hard, turn up, never quit.\"");

        javax.swing.GroupLayout regLayout = new javax.swing.GroupLayout(jPanelReg);
        jPanelReg.setLayout(regLayout);
        regLayout.setHorizontalGroup(
            regLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(regLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(regLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(regLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblHeroesReg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblQuote)
                .addGap(50, 50, 50))
            .addGroup(regLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblGymReg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnHomeReg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnExitReg, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        regLayout.setVerticalGroup(
            regLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblQuote)
                .addGap(80, 80, 80)
                .addGroup(regLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(regLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlan)
                    .addComponent(txtPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(regLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHomeReg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExitReg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHeroesReg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGymReg)
                .addGap(20, 20, 20))
        );

        tabbedPane.addTab("Registration", jPanelReg);

        // -------- Profile/Search Tab --------
        jPanelProfile.setBackground(new java.awt.Color(204, 204, 204));

        lblSearch.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14));
        lblSearch.setText("Search :");

        lblNameP.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14));
        lblNameP.setText("Course Name :");

        lblPlanP.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14));
        lblPlanP.setText("Plan / Description :");

        txtSearch.setBackground(new java.awt.Color(153, 153, 153));
        txtSearch.setFont(new java.awt.Font("Palatino Linotype", 1, 14));

        txtCourseNameP.setBackground(new java.awt.Color(153, 153, 153));
        txtCourseNameP.setFont(new java.awt.Font("Palatino Linotype", 1, 14));

        txtPlanP.setBackground(new java.awt.Color(153, 153, 153));
        txtPlanP.setFont(new java.awt.Font("Palatino Linotype", 1, 14));

        btnGoOn.setBackground(new java.awt.Color(0, 0, 0));
        btnGoOn.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14));
        btnGoOn.setForeground(new java.awt.Color(255, 255, 255));
        btnGoOn.setText("Go On");
        btnGoOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoOnActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 0, 0));
        btnUpdate.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 0, 0));
        btnDelete.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnHome.setBackground(new java.awt.Color(0, 0, 0));
        btnHome.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14));
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(0, 0, 0));
        btnExit.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14));
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        lblHeroes.setFont(new java.awt.Font("Lucida Handwriting", 1, 18));
        lblHeroes.setForeground(new java.awt.Color(51, 51, 51));
        lblHeroes.setText("HEROES");

        lblGym.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14));
        lblGym.setForeground(new java.awt.Color(51, 51, 51));
        lblGym.setText("GYM");

        javax.swing.GroupLayout profileLayout = new javax.swing.GroupLayout(jPanelProfile);
        jPanelProfile.setLayout(profileLayout);
        profileLayout.setHorizontalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSearch)
                    .addComponent(lblNameP, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlanP, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profileLayout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnGoOn))
                    .addComponent(txtCourseNameP, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlanP, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(profileLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblHeroes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(profileLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblGym)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        profileLayout.setVerticalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGoOn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameP)
                    .addComponent(txtCourseNameP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlanP)
                    .addComponent(txtPlanP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHeroes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGym)
                .addGap(20, 20, 20))
        );

        tabbedPane.addTab("Profile", jPanelProfile);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1390, 710));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // ---- Registration Tab Events ----

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {
        String name = txtCourseName.getText().trim();
        String plan = txtPlan.getText().trim();
        if (name.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Course Name is required.", "Submit Course", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            CourseDAL courseDAL = new CourseDAL();
            Course course = new Course();
            course.setCourseName(name);
            course.setPlan(plan);
            courseDAL.createCourse(course);
            javax.swing.JOptionPane.showMessageDialog(this, "Course added successfully!", "Submit Course", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txtCourseName.setText("");
            txtPlan.setText("");
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void btnHomeRegActionPerformed(java.awt.event.ActionEvent evt) {
        MenuPage menu = new MenuPage();
        menu.setVisible(true);
        dispose();
    }

    // ---- Profile Tab Events ----

    private void btnGoOnActionPerformed(java.awt.event.ActionEvent evt) {
        String nameToSearch = txtSearch.getText().trim();
        if (nameToSearch.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Enter a course name to search.", "Search Course", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            CourseDAL courseDAL = new CourseDAL();
            Course course = courseDAL.getCourseByName(nameToSearch);
            if (course != null) {
                txtCourseNameP.setText(course.getCourseName());
                txtPlanP.setText(course.getPlan());
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Course not found: " + nameToSearch, "Search Course", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                txtCourseNameP.setText("");
                txtPlanP.setText("");
            }
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        String searchName = txtSearch.getText().trim();
        if (searchName.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Search for a course first using 'Go On'.", "Update Course", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        String newName = txtCourseNameP.getText().trim();
        String newPlan = txtPlanP.getText().trim();
        if (newName.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Course Name cannot be empty.", "Update Course", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            CourseDAL courseDAL = new CourseDAL();
            Course course = new Course();
            course.setCourseName(newName);
            course.setPlan(newPlan);
            courseDAL.updateCourse(course);
            javax.swing.JOptionPane.showMessageDialog(this, "Course updated successfully!", "Update Course", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        String name = txtSearch.getText().trim();
        if (name.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Enter the course name to delete in the Search field.", "Delete Course", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete course: " + name + "?",
            "Confirm Delete", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            try {
                CourseDAL courseDAL = new CourseDAL();
                courseDAL.deleteCourse(name);
                javax.swing.JOptionPane.showMessageDialog(this, "Course deleted successfully!", "Delete Course", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                txtSearch.setText("");
                txtCourseNameP.setText("");
                txtPlanP.setText("");
            } catch (SQLException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {
        MenuPage menu = new MenuPage();
        menu.setVisible(true);
        dispose();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CourseTabs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseTabs().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnExitReg;
    private javax.swing.JButton btnGoOn;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnHomeReg;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelProfile;
    private javax.swing.JPanel jPanelReg;
    private javax.swing.JLabel lblGym;
    private javax.swing.JLabel lblGymReg;
    private javax.swing.JLabel lblHeroes;
    private javax.swing.JLabel lblHeroesReg;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameP;
    private javax.swing.JLabel lblPlan;
    private javax.swing.JLabel lblPlanP;
    private javax.swing.JLabel lblQuote;
    private javax.swing.JLabel lblSearch;
    private raventab.TabbedPaneCustom tabbedPane;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JTextField txtCourseNameP;
    private javax.swing.JTextField txtPlan;
    private javax.swing.JTextField txtPlanP;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration
}
