
package view;

import com.formdev.flatlaf.FlatIntelliJLaf;

/**
 *
 * @author jefry
 */
public class mainView extends javax.swing.JFrame {

    /**
     * Creates new form mainView
     */
    public mainView() {
        initComponents();
        FlatIntelliJLaf.setup();
        System.out.println("55655");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        MainPanel = new javax.swing.JPanel();
        DashBoard = new javax.swing.JPanel();
        SideBar = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 625));
        setResizable(false);

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setMinimumSize(new java.awt.Dimension(1000, 625));
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DashBoard.setBackground(new java.awt.Color(255, 255, 255));

        SideBar.setBackground(new java.awt.Color(211, 82, 1));

        javax.swing.GroupLayout SideBarLayout = new javax.swing.GroupLayout(SideBar);
        SideBar.setLayout(SideBarLayout);
        SideBarLayout.setHorizontalGroup(
            SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        SideBarLayout.setVerticalGroup(
            SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DashBoardLayout = new javax.swing.GroupLayout(DashBoard);
        DashBoard.setLayout(DashBoardLayout);
        DashBoardLayout.setHorizontalGroup(
            DashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoardLayout.createSequentialGroup()
                .addComponent(SideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 790, Short.MAX_VALUE))
        );
        DashBoardLayout.setVerticalGroup(
            DashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SideBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MainPanel.add(DashBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 112, 1000, 520));

        jPanel1.setBackground(new java.awt.Color(211, 82, 1));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(211, 82, 1));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/TreeTravel.jpeg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 100));

        MainPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DashBoard;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel SideBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
