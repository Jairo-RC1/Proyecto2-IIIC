
package view;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Bravo
 */
public class placeDescription extends javax.swing.JDialog {

    /**
     * Creates new form eventDescription
     */
    public placeDescription(java.awt.Frame parent, boolean modal, String title, String details) {
        super(parent, modal);
        initComponents();
        setTitle(title);
        descriptionArea.setText(details);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        pack();
        setLocationRelativeTo(parent);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        descriptionArea.setEditable(false);
        descriptionArea.setColumns(20);
        descriptionArea.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        descriptionArea.setRows(5);
        jScrollPane1.setViewportView(descriptionArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
