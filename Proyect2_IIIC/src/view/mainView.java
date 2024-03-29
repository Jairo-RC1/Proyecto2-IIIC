package view;

import com.formdev.flatlaf.FlatIntelliJLaf;
import controller.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.*;
import controller.ctrlApiHandler;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

public class mainView extends javax.swing.JFrame {

    private user currentUser;
    ctrlUser ctu = new ctrlUser();
    ctrlReservation ctr = new ctrlReservation();
    ctrlApiHandler ctah = new ctrlApiHandler();
    placeDAO placeDAO = new placeDAO();
    eventDAO eventDAO = new eventDAO();
    reservationDAO reservationDAO = new reservationDAO();
    private ShowAPI showAPI;
    private int eventID = -1;

    public mainView() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        FlatIntelliJLaf.setup();
        this.currentUser = currentUser;

    }

    public void setShowAPI(ShowAPI showAPI) {
        this.showAPI = showAPI;
    }

    public Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parsedDate;
    }

    public void setUserData(user currentUser) {
        this.currentUser = currentUser;
        ctu.loadUserDataIntoFields(txtId, txtIdNumber, txtName, txtLastName, txtBirthDate, txtEmail, txtPhoneNumber, txtPassword, currentUser);
        String username = currentUser.getName();
        ctr.loadDataReservationForUser(tblEvents, username);
    }

    public void updateDate(int eventId) {
        // Get the current date and time
        LocalDateTime currentDate = LocalDateTime.now();

        // Format the date as a string in the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = currentDate.format(formatter);
        txtDateReservation.setText(formattedDate);
        txtCodeReservation.setText(String.valueOf(eventId));
        txtUserReservation.setText(currentUser.getName());
    }

    public void getpnBooking() {
        pnBooking.setVisible(true);
    }

    public void setEventDetails(event event) {
        try {
            eventDAO.createEvent(event);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el evento en la base de datos: " + e.toString());
        }
    }

    public void setPlaceDetails(place place) {
        try {
            placeDAO.createPlace(place);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el lugar en la base de datos: " + e.toString());
        }
    }

    // this method updated the user in the txtfields
    public void updateUser() {

        int idNumber = Integer.parseInt(txtIdNumber.getText());
        String name = txtName.getText();
        String lastName = txtLastName.getText();
        String email = txtEmail.getText();
        int phoneNumber = Integer.parseInt(txtPhoneNumber.getText());
        Date birthDate = parseDate(txtBirthDate.getText());
        String password = txtPassword.getText();

        currentUser.setIdNumber(idNumber);
        currentUser.setName(name);
        currentUser.setLastName(lastName);
        currentUser.setEmail(email);
        currentUser.setPhoneNumber(phoneNumber);
        currentUser.setBirthDate(birthDate);
        currentUser.setPassword(password);

        ctu.updateUser(currentUser);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        MainPanel = new javax.swing.JPanel();
        DashBoard = new javax.swing.JPanel();
        SideBar = new javax.swing.JPanel();
        lblOptions = new javax.swing.JLabel();
        ProfilePane = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lblUser = new javax.swing.JLabel();
        lblProfile = new javax.swing.JLabel();
        SerchPane = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        lblSerch = new javax.swing.JLabel();
        lblSerchEvent = new javax.swing.JLabel();
        BookingPane = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        lblCalendar = new javax.swing.JLabel();
        lblBooking = new javax.swing.JLabel();
        separator1 = new javax.swing.JSeparator();
        separator2 = new javax.swing.JSeparator();
        ExitPane = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        lblUser1 = new javax.swing.JLabel();
        lblProfile1 = new javax.swing.JLabel();
        lblOptions1 = new javax.swing.JLabel();
        Events = new javax.swing.JPanel();
        pnBooking = new javax.swing.JPanel();
        lblTitleBooking = new javax.swing.JLabel();
        pnFinishBooking = new javax.swing.JPanel();
        pnUserBooking = new javax.swing.JPanel();
        txtUserReservation = new javax.swing.JTextField();
        lblUserImageBooking = new javax.swing.JLabel();
        pnDateBooking = new javax.swing.JPanel();
        txtDateReservation = new javax.swing.JTextField();
        lblDateImageBooking = new javax.swing.JLabel();
        pnCodEventBooking = new javax.swing.JPanel();
        txtCodeReservation = new javax.swing.JTextField();
        lblCodImageBooking = new javax.swing.JLabel();
        btnFinishBooking = new javax.swing.JPanel();
        lblfinsih = new javax.swing.JLabel();
        lblCheckBooking = new javax.swing.JLabel();
        btnDeleteEvent = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEvents = new javax.swing.JTable();
        lblBackgroundBooking = new javax.swing.JLabel();
        pnProfile = new javax.swing.JPanel();
        jPaneMain = new javax.swing.JPanel();
        txtBirthDate = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtIdNumber = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        lblBirthDate = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblIdNumber = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        btnEdit = new javax.swing.JPanel();
        btnRegis = new javax.swing.JLabel();
        lblSave = new javax.swing.JLabel();
        btnSave2 = new javax.swing.JPanel();
        btnRegis2 = new javax.swing.JLabel();
        lblSave2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        pnSerchEvent = new javax.swing.JPanel();
        pnLookFor = new javax.swing.JPanel();
        pnEvents = new javax.swing.JPanel();
        txtEventName = new javax.swing.JTextField();
        lblEventImages = new javax.swing.JLabel();
        lblFilterBackground = new javax.swing.JLabel();
        pnLocation = new javax.swing.JPanel();
        txtLocationName = new javax.swing.JTextField();
        lblEventImages1 = new javax.swing.JLabel();
        pnCategory = new javax.swing.JPanel();
        boxCategory = new javax.swing.JComboBox<>();
        lblCategoryImage = new javax.swing.JLabel();
        btnEnter = new javax.swing.JPanel();
        lblSerchPlace = new javax.swing.JLabel();
        btnWeatherInfo = new javax.swing.JPanel();
        lbWeatherInfo = new javax.swing.JLabel();
        lblWeatherImage = new javax.swing.JLabel();
        pnQuantity = new javax.swing.JPanel();
        spQuantityPeopel = new javax.swing.JSpinner();
        lblQuantityImage = new javax.swing.JLabel();
        lblBackgroundFilter = new javax.swing.JLabel();
        ScrollPane = new javax.swing.JScrollPane();
        barPane = new javax.swing.JPanel();
        lblIcon = new javax.swing.JLabel();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setMinimumSize(new java.awt.Dimension(1000, 625));
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DashBoard.setBackground(new java.awt.Color(255, 255, 255));
        DashBoard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SideBar.setBackground(new java.awt.Color(163, 226, 243));
        SideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblOptions.setBackground(new java.awt.Color(163, 226, 243));
        lblOptions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/options_icon_254403.png"))); // NOI18N
        lblOptions.setOpaque(true);
        lblOptions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOptionsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOptionsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOptionsMouseExited(evt);
            }
        });
        SideBar.add(lblOptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 48, 48));

        ProfilePane.setBackground(new java.awt.Color(163, 226, 243));
        ProfilePane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProfilePaneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProfilePaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProfilePaneMouseExited(evt);
            }
        });
        ProfilePane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        ProfilePane.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 189, 10));

        lblUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/user.png"))); // NOI18N
        ProfilePane.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 48, 48));

        lblProfile.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblProfile.setForeground(new java.awt.Color(0, 0, 0));
        lblProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProfile.setText("Mi perfil");
        ProfilePane.add(lblProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 140, 40));

        SideBar.add(ProfilePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 190, 60));

        SerchPane.setBackground(new java.awt.Color(163, 226, 243));
        SerchPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SerchPaneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SerchPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SerchPaneMouseExited(evt);
            }
        });
        SerchPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        SerchPane.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 189, 10));

        lblSerch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/serch.png"))); // NOI18N
        SerchPane.add(lblSerch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 48, 48));

        lblSerchEvent.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblSerchEvent.setForeground(new java.awt.Color(0, 0, 0));
        lblSerchEvent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSerchEvent.setText("Buscar Evento");
        SerchPane.add(lblSerchEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 140, 40));

        SideBar.add(SerchPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 190, 60));

        BookingPane.setBackground(new java.awt.Color(163, 226, 243));
        BookingPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookingPaneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BookingPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BookingPaneMouseExited(evt);
            }
        });
        BookingPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        BookingPane.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 189, 10));

        lblCalendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/calendar.png"))); // NOI18N
        BookingPane.add(lblCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 48, 48));

        lblBooking.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblBooking.setForeground(new java.awt.Color(0, 0, 0));
        lblBooking.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBooking.setText("Reservas");
        BookingPane.add(lblBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 140, 40));

        SideBar.add(BookingPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 190, 60));

        separator1.setBackground(new java.awt.Color(0, 0, 0));
        separator1.setForeground(new java.awt.Color(0, 0, 0));
        SideBar.add(separator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 188, 20));

        separator2.setBackground(new java.awt.Color(0, 0, 0));
        separator2.setForeground(new java.awt.Color(0, 0, 0));
        SideBar.add(separator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 188, 20));

        ExitPane.setBackground(new java.awt.Color(163, 226, 243));
        ExitPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitPaneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitPaneMouseExited(evt);
            }
        });
        ExitPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        ExitPane.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 189, 10));

        lblUser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/exit.png"))); // NOI18N
        ExitPane.add(lblUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 48, 48));

        lblProfile1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblProfile1.setForeground(new java.awt.Color(0, 0, 0));
        lblProfile1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProfile1.setText("Cerrar Sesion");
        ExitPane.add(lblProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 140, 40));

        SideBar.add(ExitPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 190, 60));

        DashBoard.add(SideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 550));

        lblOptions1.setBackground(new java.awt.Color(255, 255, 255));
        lblOptions1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOptions1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/options_icon_254403.png"))); // NOI18N
        lblOptions1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOptions1MouseClicked(evt);
            }
        });
        DashBoard.add(lblOptions1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 48, 48));

        Events.setBackground(new java.awt.Color(255, 255, 255));
        Events.setLayout(new java.awt.CardLayout());

        pnBooking.setBackground(new java.awt.Color(255, 255, 255));
        pnBooking.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitleBooking.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitleBooking.setForeground(new java.awt.Color(0, 0, 0));
        lblTitleBooking.setText("Reservación");
        pnBooking.add(lblTitleBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        pnFinishBooking.setBackground(new java.awt.Color(255, 255, 255));
        pnFinishBooking.setOpaque(false);
        pnFinishBooking.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnUserBooking.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        pnUserBooking.setOpaque(false);
        pnUserBooking.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUserReservation.setEditable(false);
        txtUserReservation.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtUserReservation.setForeground(new java.awt.Color(0, 0, 0));
        txtUserReservation.setOpaque(true);
        pnUserBooking.add(txtUserReservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 130, 30));

        lblUserImageBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/user2 - Copy.png"))); // NOI18N
        pnUserBooking.add(lblUserImageBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 30, 30));

        pnFinishBooking.add(pnUserBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 190, 70));

        pnDateBooking.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "Fecha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        pnDateBooking.setOpaque(false);
        pnDateBooking.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDateReservation.setEditable(false);
        txtDateReservation.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtDateReservation.setForeground(new java.awt.Color(0, 0, 0));
        pnDateBooking.add(txtDateReservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 130, 30));

        lblDateImageBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/calendar - Copy.png"))); // NOI18N
        pnDateBooking.add(lblDateImageBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 30, 30));

        pnFinishBooking.add(pnDateBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 190, 70));

        pnCodEventBooking.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "Cod_Evento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        pnCodEventBooking.setOpaque(false);
        pnCodEventBooking.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodeReservation.setEditable(false);
        txtCodeReservation.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCodeReservation.setForeground(new java.awt.Color(0, 0, 0));
        pnCodEventBooking.add(txtCodeReservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 120, 30));

        lblCodImageBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/codigoQR.png"))); // NOI18N
        pnCodEventBooking.add(lblCodImageBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 30, 30));

        pnFinishBooking.add(pnCodEventBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 190, 70));

        btnFinishBooking.setBackground(new java.awt.Color(255, 255, 255));
        btnFinishBooking.setForeground(new java.awt.Color(255, 255, 255));
        btnFinishBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFinishBookingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFinishBookingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFinishBookingMouseExited(evt);
            }
        });
        btnFinishBooking.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblfinsih.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblfinsih.setForeground(new java.awt.Color(0, 0, 0));
        lblfinsih.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblfinsih.setText("Finalizar");
        btnFinishBooking.add(lblfinsih, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 120, 30));

        lblCheckBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/check.png"))); // NOI18N
        btnFinishBooking.add(lblCheckBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        pnFinishBooking.add(btnFinishBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 180, 50));

        btnDeleteEvent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/delete1.png"))); // NOI18N
        btnDeleteEvent.setBorderPainted(false);
        btnDeleteEvent.setContentAreaFilled(false);
        btnDeleteEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteEventActionPerformed(evt);
            }
        });
        pnFinishBooking.add(btnDeleteEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 40, 50));

        pnBooking.add(pnFinishBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 820, 180));

        tblEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuario", "Fecha", "Cantidad", "Evento"
            }
        ));
        tblEvents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEventsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEvents);

        jScrollPane2.setViewportView(jScrollPane1);

        pnBooking.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 800, 250));

        lblBackgroundBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/celeste-blanco.jpg"))); // NOI18N
        pnBooking.add(lblBackgroundBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 520));

        Events.add(pnBooking, "card3");

        pnProfile.setBackground(new java.awt.Color(255, 255, 255));
        pnProfile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPaneMain.setBackground(new java.awt.Color(255, 255, 255));
        jPaneMain.setPreferredSize(new java.awt.Dimension(671, 449));
        jPaneMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBirthDate.setBackground(new java.awt.Color(255, 255, 255));
        txtBirthDate.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtBirthDate.setForeground(new java.awt.Color(0, 0, 0));
        txtBirthDate.setText("Fecha de nacimiento");
        txtBirthDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtBirthDateMousePressed(evt);
            }
        });
        jPaneMain.add(txtBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 210, 40));

        txtPhoneNumber.setBackground(new java.awt.Color(255, 255, 255));
        txtPhoneNumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtPhoneNumber.setForeground(new java.awt.Color(0, 0, 0));
        txtPhoneNumber.setText("Telefono");
        txtPhoneNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPhoneNumberMousePressed(evt);
            }
        });
        txtPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumberActionPerformed(evt);
            }
        });
        jPaneMain.add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 210, 40));

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtEmail.setText("Correo electronico");
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEmailMousePressed(evt);
            }
        });
        jPaneMain.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 210, 40));

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtPassword.setText("Contraseña");
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPasswordMousePressed(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPaneMain.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 180, 40));

        txtIdNumber.setBackground(new java.awt.Color(255, 255, 255));
        txtIdNumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtIdNumber.setForeground(new java.awt.Color(0, 0, 0));
        txtIdNumber.setText("Cedula");
        txtIdNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIdNumberMousePressed(evt);
            }
        });
        txtIdNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdNumberActionPerformed(evt);
            }
        });
        jPaneMain.add(txtIdNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 180, 40));

        txtName.setBackground(new java.awt.Color(255, 255, 255));
        txtName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 0, 0));
        txtName.setText("Nombre");
        txtName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNameMousePressed(evt);
            }
        });
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPaneMain.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 180, 40));

        txtLastName.setBackground(new java.awt.Color(255, 255, 255));
        txtLastName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtLastName.setForeground(new java.awt.Color(0, 0, 0));
        txtLastName.setText("Apellido");
        txtLastName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtLastNameMousePressed(evt);
            }
        });
        jPaneMain.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 210, 40));

        lblBirthDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/calendar.png"))); // NOI18N
        jPaneMain.add(lblBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 40, 40));

        lblPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/password.png"))); // NOI18N
        jPaneMain.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 40, 40));

        lblPhoneNumber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/phone.png"))); // NOI18N
        jPaneMain.add(lblPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 40, 40));

        lblEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/email.png"))); // NOI18N
        jPaneMain.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 40, 40));

        lblIdNumber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/cedula.png"))); // NOI18N
        jPaneMain.add(lblIdNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 40, 40));

        lblLastName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/user.png"))); // NOI18N
        jPaneMain.add(lblLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 40, 40));

        lblName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/user2.png"))); // NOI18N
        jPaneMain.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 40, 40));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/logoAzulOscuro.jpeg"))); // NOI18N
        jPaneMain.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 410, -1, -1));

        btnEdit.setBackground(new java.awt.Color(163, 226, 243));
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditMouseExited(evt);
            }
        });
        btnEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegis.setBackground(new java.awt.Color(163, 226, 243));
        btnRegis.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnRegis.setForeground(new java.awt.Color(0, 0, 0));
        btnRegis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegis.setText("Editar");
        btnRegis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegisMouseExited(evt);
            }
        });
        btnEdit.add(btnRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 100, 40));

        lblSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/Pen.png"))); // NOI18N
        btnEdit.add(lblSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        btnSave2.setBackground(new java.awt.Color(163, 226, 243));
        btnSave2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegis2.setBackground(new java.awt.Color(163, 226, 243));
        btnRegis2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnRegis2.setForeground(new java.awt.Color(0, 0, 0));
        btnRegis2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegis2.setText("Guardar");
        btnRegis2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegis2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegis2MouseExited(evt);
            }
        });
        btnSave2.add(btnRegis2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 100, 40));

        lblSave2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/save.png"))); // NOI18N
        btnSave2.add(lblSave2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        btnEdit.add(btnSave2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 170, 60));

        jPaneMain.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 170, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/identity-card.png"))); // NOI18N
        jPaneMain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 60, 60));

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(255, 255, 255));
        txtId.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtId.setForeground(new java.awt.Color(0, 0, 0));
        txtId.setText("ID");
        txtId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIdMousePressed(evt);
            }
        });
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        jPaneMain.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 180, 40));

        pnProfile.add(jPaneMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 520));

        Events.add(pnProfile, "card4");

        pnSerchEvent.setBackground(new java.awt.Color(255, 255, 255));
        pnSerchEvent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnLookFor.setBackground(new java.awt.Color(255, 255, 255));
        pnLookFor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnEvents.setBackground(new java.awt.Color(255, 255, 255));
        pnEvents.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 71, 96), 4));
        pnEvents.setOpaque(false);
        pnEvents.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEventName.setBackground(new java.awt.Color(255, 255, 255));
        txtEventName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtEventName.setForeground(new java.awt.Color(0, 0, 0));
        txtEventName.setText("Eventos");
        txtEventName.setBorder(null);
        txtEventName.setOpaque(true);
        txtEventName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEventNameMousePressed(evt);
            }
        });
        txtEventName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEventNameActionPerformed(evt);
            }
        });
        pnEvents.add(txtEventName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 150, 30));

        lblEventImages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/cama.png"))); // NOI18N
        pnEvents.add(lblEventImages, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));
        lblEventImages.getAccessibleContext().setAccessibleDescription("");

        pnEvents.add(lblFilterBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 820, 230));

        pnLookFor.add(pnEvents, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 50));

        pnLocation.setBackground(new java.awt.Color(255, 255, 255));
        pnLocation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 71, 96), 4));
        pnLocation.setOpaque(false);
        pnLocation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtLocationName.setBackground(new java.awt.Color(255, 255, 255));
        txtLocationName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtLocationName.setForeground(new java.awt.Color(0, 0, 0));
        txtLocationName.setText("Ubicacion");
        txtLocationName.setBorder(null);
        txtLocationName.setOpaque(true);
        txtLocationName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtLocationNameMousePressed(evt);
            }
        });
        pnLocation.add(txtLocationName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 150, 30));

        lblEventImages1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/location.png"))); // NOI18N
        pnLocation.add(lblEventImages1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        pnLookFor.add(pnLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 210, 50));

        pnCategory.setBackground(new java.awt.Color(255, 255, 255));
        pnCategory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 71, 96), 4));
        pnCategory.setOpaque(false);
        pnCategory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boxCategory.setBackground(new java.awt.Color(255, 255, 255));
        boxCategory.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        boxCategory.setForeground(new java.awt.Color(0, 0, 0));
        boxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoria", "hotels", "attractions", "restaurants", "geos" }));
        boxCategory.setOpaque(true);
        boxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCategoryActionPerformed(evt);
            }
        });
        pnCategory.add(boxCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, 30));

        lblCategoryImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/category.png"))); // NOI18N
        pnCategory.add(lblCategoryImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        pnLookFor.add(pnCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 210, 50));

        btnEnter.setBackground(new java.awt.Color(255, 255, 255));
        btnEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnterMouseExited(evt);
            }
        });

        lblSerchPlace.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblSerchPlace.setForeground(new java.awt.Color(0, 0, 0));
        lblSerchPlace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSerchPlace.setText("BUSCAR");

        javax.swing.GroupLayout btnEnterLayout = new javax.swing.GroupLayout(btnEnter);
        btnEnter.setLayout(btnEnterLayout);
        btnEnterLayout.setHorizontalGroup(
            btnEnterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEnterLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblSerchPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        btnEnterLayout.setVerticalGroup(
            btnEnterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEnterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSerchPlace, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnLookFor.add(btnEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 170, 40));

        btnWeatherInfo.setBackground(new java.awt.Color(255, 255, 255));
        btnWeatherInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnWeatherInfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnWeatherInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnWeatherInfoMouseExited(evt);
            }
        });
        btnWeatherInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbWeatherInfo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbWeatherInfo.setForeground(new java.awt.Color(0, 0, 0));
        lbWeatherInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbWeatherInfo.setText("Informacion del clima");
        btnWeatherInfo.add(lbWeatherInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 160, 35));

        lblWeatherImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/clima.png"))); // NOI18N
        btnWeatherInfo.add(lblWeatherImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 35, 35));

        pnLookFor.add(btnWeatherInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 220, 70));

        pnQuantity.setBackground(new java.awt.Color(255, 255, 255));
        pnQuantity.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 71, 96), 4), "Cantidad de Personas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(39, 71, 96))); // NOI18N
        pnQuantity.setOpaque(false);
        pnQuantity.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        spQuantityPeopel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        spQuantityPeopel.setPreferredSize(new java.awt.Dimension(100, 30));
        pnQuantity.add(spQuantityPeopel, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 19, 110, -1));

        lblQuantityImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/grupoPeople.png"))); // NOI18N
        pnQuantity.add(lblQuantityImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 30, 30));

        pnLookFor.add(pnQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 210, 65));

        lblBackgroundFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/fondoTravel1.jpg"))); // NOI18N
        lblBackgroundFilter.setOpaque(true);
        pnLookFor.add(lblBackgroundFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 230));

        pnSerchEvent.add(pnLookFor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 230));

        ScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        pnSerchEvent.add(ScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 820, 290));

        Events.add(pnSerchEvent, "card2");

        DashBoard.add(Events, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 820, 520));

        MainPanel.add(DashBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1010, 520));

        barPane.setBackground(new java.awt.Color(39, 71, 96));
        barPane.setForeground(new java.awt.Color(132, 206, 250));

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/logoAzulOscuro.jpeg"))); // NOI18N

        javax.swing.GroupLayout barPaneLayout = new javax.swing.GroupLayout(barPane);
        barPane.setLayout(barPaneLayout);
        barPaneLayout.setHorizontalGroup(
            barPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barPaneLayout.createSequentialGroup()
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 906, Short.MAX_VALUE))
        );
        barPaneLayout.setVerticalGroup(
            barPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barPaneLayout.createSequentialGroup()
                .addComponent(lblIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        MainPanel.add(barPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 110));

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
    private void labelColor(JLabel label) {
        label.setBackground(new java.awt.Color(132, 206, 250));
    }

    private void resetLabelColor(JLabel label) {
        label.setBackground(new java.awt.Color(163, 226, 243));
    }

    private void panelColor(JPanel panel) {
        panel.setBackground(new java.awt.Color(132, 206, 250));
    }

    private void resetPanelColor(JPanel panel) {
        panel.setBackground(new java.awt.Color(163, 226, 243));
    }

    private void handleTextFieldMousePressed(JTextField textField, String defaultText) {
        if (textField.getText().equals(defaultText)) {
            textField.setText("");
            textField.setForeground(Color.BLACK);
        }

        if (String.valueOf(txtId.getText()).isEmpty()) {
            txtId.setText("ID");
            txtId.setForeground(Color.BLACK);
        }

        if (String.valueOf(txtName.getText()).isEmpty()) {
            txtName.setText("Nombre");
            txtName.setForeground(Color.BLACK);
        }

        if (String.valueOf(txtLastName.getText()).isEmpty()) {
            txtLastName.setText("Apellido");
            txtLastName.setForeground(Color.BLACK);
        }

        if (String.valueOf(txtIdNumber.getText()).isEmpty()) {
            txtIdNumber.setText("Cedula");
            txtIdNumber.setForeground(Color.BLACK);
        }

        if (String.valueOf(txtEmail.getText()).isEmpty()) {
            txtEmail.setText("Correo electronico");
            txtEmail.setForeground(Color.BLACK);
        }

        if (String.valueOf(txtPhoneNumber.getText()).isEmpty()) {
            txtPhoneNumber.setText("Telefono");
            txtPhoneNumber.setForeground(Color.BLACK);
        }

        if (String.valueOf(txtBirthDate.getText()).isEmpty()) {
            txtBirthDate.setText("Fecha de nacimiento");
            txtBirthDate.setForeground(Color.BLACK);
        }

        if (String.valueOf(txtPassword.getText()).isEmpty()) {
            txtPassword.setText("Contraseña");
            txtPassword.setForeground(Color.BLACK);
        }
    }

    int x = 250;
    private void lblOptions1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptions1MouseClicked
        Thread th = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i <= 188; i++) {
                        Thread.sleep(1);
                        SideBar.setSize(i, 540);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });

        th.start();
        x = 210;
    }//GEN-LAST:event_lblOptions1MouseClicked

    private void lblOptionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionsMouseClicked
        Thread th = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 210; i >= 0; i--) {
                        Thread.sleep(1);
                        SideBar.setSize(i, 540);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });

        th.start();
        x = 0;
    }//GEN-LAST:event_lblOptionsMouseClicked

    private void lblOptionsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionsMouseEntered
        labelColor(lblOptions);
    }//GEN-LAST:event_lblOptionsMouseEntered

    private void lblOptionsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionsMouseExited
        resetLabelColor(lblOptions);
    }//GEN-LAST:event_lblOptionsMouseExited

    private void ProfilePaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfilePaneMouseEntered
        panelColor(ProfilePane);
    }//GEN-LAST:event_ProfilePaneMouseEntered

    private void ProfilePaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfilePaneMouseExited
        resetPanelColor(ProfilePane);
    }//GEN-LAST:event_ProfilePaneMouseExited

    private void SerchPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SerchPaneMouseEntered
        panelColor(SerchPane);
    }//GEN-LAST:event_SerchPaneMouseEntered

    private void SerchPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SerchPaneMouseExited
        resetPanelColor(SerchPane);
    }//GEN-LAST:event_SerchPaneMouseExited

    private void BookingPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookingPaneMouseEntered
        panelColor(BookingPane);
    }//GEN-LAST:event_BookingPaneMouseEntered

    private void BookingPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookingPaneMouseExited
        resetPanelColor(BookingPane);
    }//GEN-LAST:event_BookingPaneMouseExited

    private void SerchPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SerchPaneMouseClicked
        pnSerchEvent.setVisible(true);
        pnBooking.setVisible(false);
        pnProfile.setVisible(false);

        SerchPane.setBackground(new java.awt.Color(132, 206, 250));
    }//GEN-LAST:event_SerchPaneMouseClicked

    private void ProfilePaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfilePaneMouseClicked
        pnSerchEvent.setVisible(false);
        pnBooking.setVisible(false);
        pnProfile.setVisible(true);

        ProfilePane.setBackground(new java.awt.Color(132, 206, 250));
    }//GEN-LAST:event_ProfilePaneMouseClicked

    private void ExitPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitPaneMouseClicked
        login log = new login();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ExitPaneMouseClicked

    private void ExitPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitPaneMouseEntered
        panelColor(ExitPane);
    }//GEN-LAST:event_ExitPaneMouseEntered

    private void ExitPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitPaneMouseExited
        resetPanelColor(ExitPane);
    }//GEN-LAST:event_ExitPaneMouseExited

    private void txtBirthDateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBirthDateMousePressed
        handleTextFieldMousePressed(txtBirthDate, "Fecha de nacimiento");
    }//GEN-LAST:event_txtBirthDateMousePressed

    private void txtPhoneNumberMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPhoneNumberMousePressed
        handleTextFieldMousePressed(txtPhoneNumber, "Telefono");
    }//GEN-LAST:event_txtPhoneNumberMousePressed

    private void txtPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneNumberActionPerformed

    }//GEN-LAST:event_txtPhoneNumberActionPerformed

    private void txtEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMousePressed
        handleTextFieldMousePressed(txtEmail, "Correo electronico");
    }//GEN-LAST:event_txtEmailMousePressed

    private void txtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMousePressed
        handleTextFieldMousePressed(txtPassword, "Contraseña");
    }//GEN-LAST:event_txtPasswordMousePressed

    private void txtIdNumberMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdNumberMousePressed
        handleTextFieldMousePressed(txtIdNumber, "Cedula");
    }//GEN-LAST:event_txtIdNumberMousePressed

    private void txtNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNameMousePressed
        handleTextFieldMousePressed(txtName, "Nombre");
    }//GEN-LAST:event_txtNameMousePressed

    private void txtLastNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLastNameMousePressed
        handleTextFieldMousePressed(txtLastName, "Apellido");
    }//GEN-LAST:event_txtLastNameMousePressed

    private void btnRegisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisMouseEntered
        labelColor(btnRegis);
    }//GEN-LAST:event_btnRegisMouseEntered

    private void btnRegisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisMouseExited
        resetLabelColor(btnRegis);
    }//GEN-LAST:event_btnRegisMouseExited

    private void btnRegis2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegis2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegis2MouseEntered

    private void btnRegis2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegis2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegis2MouseExited

    private void BookingPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookingPaneMouseClicked
        pnSerchEvent.setVisible(false);
        pnBooking.setVisible(true);
        pnProfile.setVisible(false);

        BookingPane.setBackground(new java.awt.Color(132, 206, 250));
    }//GEN-LAST:event_BookingPaneMouseClicked

    private void btnEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseEntered
        panelColor(btnEdit);
    }//GEN-LAST:event_btnEditMouseEntered

    private void btnEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseExited
        resetPanelColor(btnEdit);
    }//GEN-LAST:event_btnEditMouseExited

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtIdNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdNumberActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        if (currentUser != null) {
            updateUser();
        } else {
            System.out.println("El usuario no está cargado correctamente");
        }
    }//GEN-LAST:event_btnEditMouseClicked

    private void txtIdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdMousePressed
        handleTextFieldMousePressed(txtId, "ID");
    }//GEN-LAST:event_txtIdMousePressed

    private void txtEventNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEventNameMousePressed
        if (txtEventName.getText().equals("Eventos")) {
            txtEventName.setText("");
            txtEventName.setForeground(Color.BLACK);
        }
        if (txtLocationName.getText().isEmpty()) {
            txtLocationName.setText("Ubicacion");
            txtLocationName.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtEventNameMousePressed

    private void txtEventNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEventNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEventNameActionPerformed

    private void txtLocationNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLocationNameMousePressed
        if (txtLocationName.getText().equals("Ubicacion")) {
            txtLocationName.setText("");
            txtLocationName.setForeground(Color.BLACK);
        }
        if (txtEventName.getText().isEmpty()) {
            txtEventName.setText("Eventos");
            txtEventName.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtLocationNameMousePressed

    private void boxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxCategoryActionPerformed

    private void btnEnterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnterMouseEntered
        btnEnter.setBackground(new java.awt.Color(163, 226, 243));
    }//GEN-LAST:event_btnEnterMouseEntered

    private void btnEnterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnterMouseExited
        btnEnter.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btnEnterMouseExited

    private void btnEnterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnterMouseClicked
        this.ctah.searchEvents(txtEventName, txtLocationName, ScrollPane, boxCategory, this);
    }//GEN-LAST:event_btnEnterMouseClicked

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnWeatherInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWeatherInfoMouseClicked
        String locationName = txtLocationName.getText();
        JSONObject weatherJSON = OpenWeatherMapAPI.callWeatherAPI(locationName);
        if (weatherJSON != null) {
            String jsonString = weatherJSON.toString(); // Convertir JSONObject a String
            WeatherInfo weatherInfo = OpenWeatherMapAPI.parseWeatherJSON(jsonString, locationName);
            if (weatherInfo != null) {
                OpenWeatherMapAPI.displayWeatherInfo(weatherInfo);
            } else {
                JOptionPane.showMessageDialog(null, "Error al obtener información del clima.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error al obtener información del clima.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnWeatherInfoMouseClicked

    private void btnWeatherInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWeatherInfoMouseEntered
        btnWeatherInfo.setBackground(new java.awt.Color(163, 226, 243));
    }//GEN-LAST:event_btnWeatherInfoMouseEntered

    private void btnWeatherInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWeatherInfoMouseExited
        btnWeatherInfo.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btnWeatherInfoMouseExited

    private void btnFinishBookingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinishBookingMouseClicked
        event selectedEvent = showAPI.getSelectedEvent();
        place selectedPlace = showAPI.getSelectedPlace();
        int option = JOptionPane.showConfirmDialog(this, "¿Quiere reservar el evento: '" + selectedEvent.getName(), "Confirmar", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            setPlaceDetails(selectedPlace);
            int generatedPlaceId = placeDAO.getIDPlaces(selectedPlace.getName());
            selectedEvent.setPlaceId(generatedPlaceId);
            setEventDetails(selectedEvent);
            int generatedEventId = eventDAO.getIDEvents(selectedEvent.getName());
            Integer quantity = (Integer) spQuantityPeopel.getValue();
            ctr.createReservation(txtUserReservation, txtDateReservation, quantity, generatedEventId);
            String username = currentUser.getName();
            ctr.loadDataReservationForUser(tblEvents, username);
        } else {
        }
    }//GEN-LAST:event_btnFinishBookingMouseClicked

    private void btnFinishBookingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinishBookingMouseEntered
        btnFinishBooking.setBackground(new java.awt.Color(163, 226, 243));
    }//GEN-LAST:event_btnFinishBookingMouseEntered

    private void btnFinishBookingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinishBookingMouseExited
        btnFinishBooking.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btnFinishBookingMouseExited

    private void btnDeleteEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteEventActionPerformed
        if (eventID != -1) {
            reservationDAO.deleteReservation(eventID);
            DefaultTableModel model = (DefaultTableModel) tblEvents.getModel();
            model.removeRow(tblEvents.getSelectedRow());
            eventID = -1;
        }
    }//GEN-LAST:event_btnDeleteEventActionPerformed

    private void tblEventsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEventsMouseClicked
        int row = tblEvents.rowAtPoint(evt.getPoint());
        int col = tblEvents.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0) {
            eventID = (int) tblEvents.getValueAt(row, 0);
        }
    }//GEN-LAST:event_tblEventsMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BookingPane;
    private javax.swing.JPanel DashBoard;
    private javax.swing.JPanel Events;
    private javax.swing.JPanel ExitPane;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel ProfilePane;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JPanel SerchPane;
    private javax.swing.JPanel SideBar;
    private javax.swing.JPanel barPane;
    private javax.swing.JComboBox<String> boxCategory;
    private javax.swing.JButton btnDeleteEvent;
    private javax.swing.JPanel btnEdit;
    private javax.swing.JPanel btnEnter;
    private javax.swing.JPanel btnFinishBooking;
    private javax.swing.JLabel btnRegis;
    private javax.swing.JLabel btnRegis2;
    private javax.swing.JPanel btnSave2;
    private javax.swing.JPanel btnWeatherInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPaneMain;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbWeatherInfo;
    private javax.swing.JLabel lblBackgroundBooking;
    private javax.swing.JLabel lblBackgroundFilter;
    private javax.swing.JLabel lblBirthDate;
    private javax.swing.JLabel lblBooking;
    private javax.swing.JLabel lblCalendar;
    private javax.swing.JLabel lblCategoryImage;
    private javax.swing.JLabel lblCheckBooking;
    private javax.swing.JLabel lblCodImageBooking;
    private javax.swing.JLabel lblDateImageBooking;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEventImages;
    private javax.swing.JLabel lblEventImages1;
    private javax.swing.JLabel lblFilterBackground;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblIdNumber;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOptions;
    private javax.swing.JLabel lblOptions1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblProfile;
    private javax.swing.JLabel lblProfile1;
    private javax.swing.JLabel lblQuantityImage;
    private javax.swing.JLabel lblSave;
    private javax.swing.JLabel lblSave2;
    private javax.swing.JLabel lblSerch;
    private javax.swing.JLabel lblSerchEvent;
    private javax.swing.JLabel lblSerchPlace;
    private javax.swing.JLabel lblTitleBooking;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUser1;
    private javax.swing.JLabel lblUserImageBooking;
    private javax.swing.JLabel lblWeatherImage;
    private javax.swing.JLabel lblfinsih;
    private javax.swing.JPanel pnBooking;
    private javax.swing.JPanel pnCategory;
    private javax.swing.JPanel pnCodEventBooking;
    private javax.swing.JPanel pnDateBooking;
    private javax.swing.JPanel pnEvents;
    private javax.swing.JPanel pnFinishBooking;
    private javax.swing.JPanel pnLocation;
    private javax.swing.JPanel pnLookFor;
    private javax.swing.JPanel pnProfile;
    private javax.swing.JPanel pnQuantity;
    private javax.swing.JPanel pnSerchEvent;
    private javax.swing.JPanel pnUserBooking;
    private javax.swing.JSeparator separator1;
    private javax.swing.JSeparator separator2;
    private javax.swing.JSpinner spQuantityPeopel;
    private javax.swing.JTable tblEvents;
    private javax.swing.JTextField txtBirthDate;
    private javax.swing.JTextField txtCodeReservation;
    private javax.swing.JTextField txtDateReservation;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEventName;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdNumber;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtLocationName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtUserReservation;
    // End of variables declaration//GEN-END:variables

}
