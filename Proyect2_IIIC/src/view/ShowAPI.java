package view;
import java.net.URL;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.event;
import model.APIHandler;
import model.ApiPlace;
import model.ConvertImages;
import model.place;

public class ShowAPI extends javax.swing.JPanel {

    private event event;
    private APIHandler apiE = new APIHandler();
    private List<String> imageUrls;
        private ApiPlace apiP = new ApiPlace();
    private mainView parent;
    private int currentIndex;

    public ShowAPI(event event, APIHandler api, mainView parent) {
        initComponents();
        this.event = event;
        this.imageUrls = imageUrls;
        this.parent = parent;
        this.currentIndex = 0;
        lblName.setText(event.getName());
        lblAddress.setText("Direccion: " + event.getAddress());

        try {
            updateEventDetails();
            updateEventDetails();
        } catch (Exception e) {
            System.out.println("Error cargando detalles: " + e.getMessage());
        }
    }
    
    

    private void updateEventDetails() throws Exception {
        event details = apiE.getDetailsApi(event.getLocationId());
        event.setCantReviews(details.getCantReviews());
        lblReviews.setText("Basado en: " + event.getCantReviews() + " opiniones");
        event.setCalificationUrlImages(details.getCalificationUrlImages());

        // Update description if available
        if ("Descripcion no disponible".equals(details.getDescription()) || details.getDescription().isEmpty()) {
           btnDescription.setEnabled(false);
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
        lblRatingImage = new javax.swing.JLabel();
        lblReviews = new javax.swing.JLabel();
        btnReserve = new javax.swing.JPanel();
        lblReserve = new javax.swing.JLabel();
        lblReserveImage = new javax.swing.JLabel();
        btnDescription = new javax.swing.JPanel();
        lblDescription = new javax.swing.JLabel();
        lblDescriptionImage = new javax.swing.JLabel();
        lbladdressImage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/java.png"))); // NOI18N
        add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 165, 150));

        lblName.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        lblName.setText("Nombre");
        add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, 38));

        lblAddress.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblAddress.setText("Direccion");
        add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 380, 40));

        lblRatingImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/java.png"))); // NOI18N
        add(lblRatingImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 130, 40));

        lblReviews.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblReviews.setText("Sin Opiniones");
        add(lblReviews, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 140, 20));

        btnReserve.setBackground(new java.awt.Color(253, 223, 150));
        btnReserve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReserveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReserveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReserveMouseExited(evt);
            }
        });
        btnReserve.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblReserve.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblReserve.setForeground(new java.awt.Color(0, 0, 0));
        lblReserve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReserve.setText("Reservar");
        btnReserve.add(lblReserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 70, -1));

        lblReserveImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/Reservar.png"))); // NOI18N
        btnReserve.add(lblReserveImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        add(btnReserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 120, 40));

        btnDescription.setBackground(new java.awt.Color(253, 223, 150));
        btnDescription.setForeground(new java.awt.Color(0, 204, 204));
        btnDescription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDescriptionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDescriptionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDescriptionMouseExited(evt);
            }
        });
        btnDescription.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDescription.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(0, 0, 0));
        lblDescription.setText("Descripcion");
        btnDescription.add(lblDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 90, -1));

        lblDescriptionImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/Descripcion.png"))); // NOI18N
        btnDescription.add(lblDescriptionImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 40));

        add(btnDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 120, 40));

        lbladdressImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/direccion.png"))); // NOI18N
        add(lbladdressImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 40, 40));
    }// </editor-fold>//GEN-END:initComponents

    
    public event getSelectedEvent() {
        return event;
    }

    public place getSelectedPlace() {
        try {
            int selectedEventId = event.getLocationId();
            return apiP.getPlaceDetails(selectedEventId);
        } catch (Exception e) {
            System.out.println("Error obteniendo detalles del lugar: " + e.getMessage());
            return null;
        }
    }
    private void panelColor(JPanel panel) {
        panel.setBackground(new java.awt.Color(197, 134, 54));
    }

    private void resetPanelColor(JPanel panel) {
        panel.setBackground(new java.awt.Color(253,223,150));
    }
    private void btnReserveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReserveMouseClicked
       int selectedEventId = event.getLocationId();
        String eventName = event.getName();

        // Show a confirmation dialog
        int option = JOptionPane.showConfirmDialog(this, "¿Serás dirigido a la pagina de reservas del evento '" + eventName + "'?", "Confirmar", JOptionPane.YES_NO_OPTION);
        // Check the user response
        if (option == JOptionPane.YES_OPTION) {
            parent.setShowAPI(this);
            //parent.getJpReservations();
            parent.actualizarFecha(selectedEventId);
        } else {
        } 
    }//GEN-LAST:event_btnReserveMouseClicked

    private void btnReserveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReserveMouseEntered
        panelColor(btnReserve);
    }//GEN-LAST:event_btnReserveMouseEntered

    private void btnReserveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReserveMouseExited
        resetPanelColor(btnReserve);
    }//GEN-LAST:event_btnReserveMouseExited

    private void btnDescriptionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescriptionMouseEntered
        panelColor(btnDescription);
    }//GEN-LAST:event_btnDescriptionMouseEntered

    private void btnDescriptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescriptionMouseClicked
        try {
            event details = apiE.getDetailsApi(event.getLocationId());
            String formattedDescription = details.getDescription().replace("\\n", "\n");
            placeDescription detailsDialog = new placeDescription( null, true, "Detalles del Evento", formattedDescription);
            detailsDialog.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error fetching event details: " + e.getMessage());
        }
    }//GEN-LAST:event_btnDescriptionMouseClicked

    private void btnDescriptionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescriptionMouseExited
        resetPanelColor(btnDescription);
    }//GEN-LAST:event_btnDescriptionMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnDescription;
    private javax.swing.JPanel btnReserve;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblDescriptionImage;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRatingImage;
    private javax.swing.JLabel lblReserve;
    private javax.swing.JLabel lblReserveImage;
    private javax.swing.JLabel lblReviews;
    private javax.swing.JLabel lbladdressImage;
    // End of variables declaration//GEN-END:variables
}
