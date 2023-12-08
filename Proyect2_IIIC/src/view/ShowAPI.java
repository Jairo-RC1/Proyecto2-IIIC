package view;

import java.awt.Desktop;
import java.net.URI;
import java.net.URL;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Event;
import model.APIHandler;
import model.place;
import model.ApiPlace;
import model.ConvertImages;

public class ShowAPI extends javax.swing.JPanel {

    private Event event;
    private APIHandler apiE = new APIHandler();
    private List<String> imageUrls;

    public ShowAPI(Event event, APIHandler api) {
        initComponents();
        this.event = event;
        this.imageUrls = imageUrls;
        lblName.setText(event.getName());
        lblAddress.setText("Direccion: " + event.getAddress());

        try {
            updateEventDetails();
        } catch (Exception e) {
            System.out.println("Error cargando detalles: " + e.getMessage());
        }
    }

    private void updateEventDetails() throws Exception {
        Event details = apiE.getDetailsApi(event.getLocationId());
        event.setCantReviews(details.getCantReviews());
        lblReviews.setText("Basado en: " + event.getCantReviews() + " opiniones");
        event.setCalificationUrlImages(details.getCalificationUrlImages());

        // Update description if available
        if ("Descripcion no disponible".equals(details.getDescription()) || details.getDescription().isEmpty()) {
            btnDetails.setEnabled(false);
        } else {
            event.setDescription(details.getDescription());
        }

        imageUrls = apiE.getImagesApi(event.getLocationId());
        event.setUrlImages(imageUrls);
        updateImages();
        String ratingImageUrl = event.getCalificationUrlImages();
        if (!ratingImageUrl.isEmpty()) {
            ImageIcon ratingIcon = ConvertImages.getSVGIcon(ratingImageUrl);
            if (ratingIcon != null) {
                lblRatingImage.setIcon(ratingIcon);
            }
        }
    }

    private void updateImages() {
        try {
            List<String> imageUrls = event.getUrlImages();
            if (!imageUrls.isEmpty()) {
                String imageUrl = imageUrls.get(0);
                lblImage.setIcon(new javax.swing.ImageIcon(new URL(imageUrl)));
            }
        } catch (Exception e) {
            System.out.println("Error cargando imagen: " + e.getMessage());
        }
    }

@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImage = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        btnDetails = new javax.swing.JButton();
        btnWeb = new javax.swing.JButton();
        lblRatingImage = new javax.swing.JLabel();
        lblReviews = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/cedula.png"))); // NOI18N

        lblName.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        lblName.setText("Nombre");

        lblAddress.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblAddress.setText("Direccion");

        btnDetails.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnDetails.setText("Descripcion");
        btnDetails.setContentAreaFilled(false);
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });

        btnWeb.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnWeb.setText("Web");
        btnWeb.setContentAreaFilled(false);
        btnWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWebActionPerformed(evt);
            }
        });

        lblRatingImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/email.png"))); // NOI18N

        lblReviews.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblReviews.setText("Sin Opiniones");

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton1.setText("Reservar");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setText("Precio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnWeb))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDetails)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRatingImage, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(lblReviews))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(12, 12, 12)))
                        .addGap(205, 205, 205))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblRatingImage)
                                    .addComponent(lblReviews))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnWeb)
                                    .addComponent(jButton1)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDetails)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        try {
            Event details = apiE.getDetailsApi(event.getLocationId());
            String formattedDescription = details.getDescription().replace("\\n", "\n");
            placeDescription detailsDialog = new placeDescription( null, true, "Detalles del Evento", formattedDescription);
            detailsDialog.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error fetching event details: " + e.getMessage());
        }
    }//GEN-LAST:event_btnDetailsActionPerformed

    private void btnWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWebActionPerformed
        /*try {
            String tripAdvisorLink = apiP.getPlaceDetails(Event.getLocationId()).getTripAdvisorLink();
            if (tripAdvisorLink != null && !tripAdvisorLink.isEmpty()) {
                Desktop.getDesktop().browse(new URI(tripAdvisorLink));
            } else {
                JOptionPane.showMessageDialog(this, "No hay enlace de TripAdvisor disponible.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Error opening TripAdvisor link: " + e.getMessage());
        }*/
    }//GEN-LAST:event_btnWebActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnWeb;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRatingImage;
    private javax.swing.JLabel lblReviews;
    // End of variables declaration//GEN-END:variables
}
