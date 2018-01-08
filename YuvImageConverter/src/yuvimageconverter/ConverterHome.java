package yuvimageconverter;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author zebra All rights reserved
 */
public final class ConverterHome extends javax.swing.JFrame {

    public static boolean mouseListenerIsActive;
    ProccessWindow sp = new ProccessWindow();
    ImagePreviewingWindow ipw = new ImagePreviewingWindow();
    public static String zoom_in = "zoom_in.png";
    public static String zoom_out = "zoom_out.png";
    public static int imageSelectedFromList = 0;
    int status = 0;
    int btnZooming_status = status;
    int btnSave_status = status;
    int btnSaveTo_status = status;
    int btnBatchProccess_status = status;

    public ConverterHome() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(500, 850));

        initComponents();

        JDialog.setDefaultLookAndFeelDecorated(true);
        changeMouseOverColor();
        disable_Buttons();

        lstFiles.addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {

                Object[] selectedValuesList = lstFiles.getSelectedValuesList().toArray();
                String listValue = selectedValuesList[0].toString();
                if (listValue.length() > 0) {
                    imageSelectedFromList = 1;
                    btnZooming.setEnabled(true);
                    btnSave.setEnabled(true);
                } else if (listValue.length() <= 0) {
                    btnSave.setEnabled(false);
                    imageSelectedFromList = 0;
                }
                previewSelectedImage(listValue);

                lblSelectedImage.setText("");

                lblPreview.setIcon(null);

            }
        });

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"Yes", "No"};
                changeFontJOptionPane();
                int PromptResult = JOptionPane.showOptionDialog(null, "Do you want to exit?", "Yuv Image Converter 1.0", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
                if (PromptResult == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

    }

    public void changeMouseOverColor() {

        Color clrFor = new Color(62, 60, 81);
        Color clrBack = new Color(255, 255, 255);

        btnChoose.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {

                btnChoose.setForeground(clrFor);
                btnChoose.setBackground(clrBack);
            }

            public void mouseExited(MouseEvent me) {
                btnChoose.setForeground(clrBack);
                btnChoose.setBackground(clrFor);
            }
        });

        btnZooming.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {

                btnZooming.setForeground(clrFor);
                btnZooming.setBackground(clrBack);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btnZooming.setForeground(clrBack);
                btnZooming.setBackground(clrFor);
            }
        });

        btnSave.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btnSave.setForeground(clrFor);
                btnSave.setBackground(clrBack);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btnSave.setForeground(clrBack);
                btnSave.setBackground(clrFor);
            }
        });
        btnClearList.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btnClearList.setForeground(clrFor);
                btnClearList.setBackground(clrBack);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btnClearList.setForeground(clrBack);
                btnClearList.setBackground(clrFor);
            }
        });

        btnSaveTo.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btnSaveTo.setForeground(clrFor);
                btnSaveTo.setBackground(clrBack);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btnSaveTo.setForeground(clrBack);
                btnSaveTo.setBackground(clrFor);
            }
        });
        btnBatchProccess.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btnBatchProccess.setForeground(clrFor);
                btnBatchProccess.setBackground(clrBack);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btnBatchProccess.setForeground(clrBack);
                btnBatchProccess.setBackground(clrFor);
            }
        });
    }

    void previewSelectedImage(String selectFile) {

        disableUIComponent();
        previewImage(selectFile);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtFilePath = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtRowStp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtWidth = new javax.swing.JTextField();
        txtHeight = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFiles = new javax.swing.JList<>();
        btnSaveTo = new javax.swing.JButton();
        txtSaveTo = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnBatchProccess = new javax.swing.JButton();
        btnClearList = new javax.swing.JButton();
        btnChoose = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnZooming = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pnlSelectedImage = new javax.swing.JPanel();
        lblSelectedImage = new javax.swing.JLabel();
        scrlPane = new javax.swing.JScrollPane();
        lblPreview = new javax.swing.JLabel();
        lblZoom = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Yuv Image Converter 1.0");

        jPanel1.setBackground(new java.awt.Color(42, 44, 59));

        txtFilePath.setEditable(false);
        txtFilePath.setBackground(new java.awt.Color(255, 255, 255));
        txtFilePath.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        txtFilePath.setForeground(new java.awt.Color(39, 50, 68));
        txtFilePath.setToolTipText("");
        txtFilePath.setBorder(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Row Step");

        txtRowStp.setBackground(new java.awt.Color(255, 255, 255));
        txtRowStp.setForeground(new java.awt.Color(39, 50, 68));
        txtRowStp.setText("1360");
        txtRowStp.setToolTipText("");
        txtRowStp.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtRowStp.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtRowStp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRowStpActionPerformed(evt);
            }
        });
        txtRowStp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRowStpKeyTyped(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Height ");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Width ");

        txtWidth.setBackground(new java.awt.Color(255, 255, 255));
        txtWidth.setForeground(new java.awt.Color(39, 50, 68));
        txtWidth.setText("1280");
        txtWidth.setToolTipText("");
        txtWidth.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtWidth.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtWidth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWidthActionPerformed(evt);
            }
        });
        txtWidth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtWidthKeyTyped(evt);
            }
        });

        txtHeight.setBackground(new java.awt.Color(255, 255, 255));
        txtHeight.setForeground(new java.awt.Color(39, 50, 68));
        txtHeight.setText("800");
        txtHeight.setToolTipText("");
        txtHeight.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtHeight.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtHeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHeightActionPerformed(evt);
            }
        });
        txtHeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHeightKeyTyped(evt);
            }
        });

        lstFiles.setBackground(new java.awt.Color(238, 238, 238));
        lstFiles.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lstFiles.setForeground(new java.awt.Color(39, 50, 68));
        lstFiles.setToolTipText("");
        lstFiles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(lstFiles);

        btnSaveTo.setBackground(new java.awt.Color(39, 50, 68));
        btnSaveTo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSaveTo.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveTo.setText("Save to");
        btnSaveTo.setToolTipText("Click here to choose a save location");
        btnSaveTo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnSaveTo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveTo.setMargin(new java.awt.Insets(5, 15, 5, 15));
        btnSaveTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveToActionPerformed(evt);
            }
        });

        txtSaveTo.setEditable(false);
        txtSaveTo.setBackground(new java.awt.Color(255, 255, 255));
        txtSaveTo.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        txtSaveTo.setForeground(new java.awt.Color(39, 50, 68));
        txtSaveTo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSaveTo.setToolTipText("");
        txtSaveTo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnSave.setBackground(new java.awt.Color(39, 50, 68));
        btnSave.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.setToolTipText("Save a single image");
        btnSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.setMargin(new java.awt.Insets(5, 15, 5, 15));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnBatchProccess.setBackground(new java.awt.Color(39, 50, 68));
        btnBatchProccess.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBatchProccess.setForeground(new java.awt.Color(255, 255, 255));
        btnBatchProccess.setText("Batch Save");
        btnBatchProccess.setToolTipText("Batch proccessing");
        btnBatchProccess.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnBatchProccess.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBatchProccess.setMargin(new java.awt.Insets(5, 15, 5, 15));
        btnBatchProccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatchProccessActionPerformed(evt);
            }
        });

        btnClearList.setBackground(new java.awt.Color(39, 50, 68));
        btnClearList.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnClearList.setForeground(new java.awt.Color(255, 255, 255));
        btnClearList.setText("Clear");
        btnClearList.setToolTipText("Clear all fields");
        btnClearList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnClearList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearList.setMargin(new java.awt.Insets(5, 15, 5, 15));
        btnClearList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearListActionPerformed(evt);
            }
        });

        btnChoose.setBackground(new java.awt.Color(39, 50, 68));
        btnChoose.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnChoose.setForeground(new java.awt.Color(255, 255, 255));
        btnChoose.setText("Browse");
        btnChoose.setToolTipText("Click here to browse yuv files");
        btnChoose.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnChoose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChoose.setMargin(new java.awt.Insets(5, 15, 5, 15));
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(":");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(":");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(":");

        btnZooming.setBackground(new java.awt.Color(39, 50, 68));
        btnZooming.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnZooming.setForeground(new java.awt.Color(255, 255, 255));
        btnZooming.setText("Zoom ");
        btnZooming.setToolTipText("On the image Left click to zoom in and Right click to zoom out");
        btnZooming.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnZooming.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnZooming.setMargin(new java.awt.Insets(5, 15, 5, 15));
        btnZooming.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSaveTo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSaveTo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatchProccess, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClearList, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btnChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFilePath)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtRowStp, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnZooming, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnChoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFilePath))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRowStp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnZooming, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSaveTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSaveTo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatchProccess, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearList, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jPanel2.setBackground(new java.awt.Color(238, 238, 238));
        jPanel2.setForeground(new java.awt.Color(39, 50, 68));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setPreferredSize(new java.awt.Dimension(1500, 1500));

        pnlSelectedImage.setBackground(new java.awt.Color(42, 44, 59));

        lblSelectedImage.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblSelectedImage.setForeground(new java.awt.Color(42, 44, 59));
        lblSelectedImage.setText("Images will be appeared here");

        javax.swing.GroupLayout pnlSelectedImageLayout = new javax.swing.GroupLayout(pnlSelectedImage);
        pnlSelectedImage.setLayout(pnlSelectedImageLayout);
        pnlSelectedImageLayout.setHorizontalGroup(
            pnlSelectedImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectedImageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSelectedImage)
                .addContainerGap(603, Short.MAX_VALUE))
        );
        pnlSelectedImageLayout.setVerticalGroup(
            pnlSelectedImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSelectedImageLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lblSelectedImage)
                .addContainerGap())
        );

        scrlPane.setBackground(new java.awt.Color(39, 50, 68));
        scrlPane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblPreview.setBackground(new java.awt.Color(238, 238, 238));
        lblPreview.setForeground(new java.awt.Color(42, 44, 59));
        lblPreview.setText("Image will be appeared here");
        lblPreview.setToolTipText("");
        lblPreview.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scrlPane.setViewportView(lblPreview);

        lblZoom.setForeground(new java.awt.Color(42, 44, 59));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSelectedImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrlPane)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblZoom)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pnlSelectedImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrlPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 742, Short.MAX_VALUE)
                .addComponent(lblZoom)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRowStpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRowStpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRowStpActionPerformed

    private void txtWidthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWidthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWidthActionPerformed

    private void btnSaveToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveToActionPerformed
        String filename;

        try {

            JFileChooser chooser = new JFileChooser();
            Dimension dm = new Dimension(900, 800);
            chooser.setPreferredSize(dm);

            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.showOpenDialog(null);

            File file = chooser.getSelectedFile();
            try {
                filename = file.getAbsolutePath();
                txtSaveTo.setText(filename + "/");

                Path path = Paths.get(filename + "/Converted images");
                if (createDir(path)) {

                    Path bp = Paths.get(filename + "/Converted images/Batch Processing");
                    Path sngl = Paths.get(filename + "/Converted images/Single");

                    if (createDir(bp)) {
                        Path BMP = Paths.get(filename + "/Converted images/Batch Processing/BMP");
                        Path PNG = Paths.get(filename + "/Converted images/Batch Processing/PNG");
                        Path H = Paths.get(filename + "/Converted images/Batch Processing/H Files");
                        createDir(BMP);
                        createDir(PNG);
                        createDir(H);

                    }

                    if (createDir(sngl)) {
                        Path BMP = Paths.get(filename + "/Converted images/Single/BMP");
                        Path PNG = Paths.get(filename + "/Converted images/Single/PNG");
                        Path H = Paths.get(filename + "/Converted images/Single/H Files");
                        createDir(BMP);
                        createDir(PNG);
                        createDir(H);
                    }

                }
            } catch (Exception e) {

            }

        } catch (HeadlessException e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveToActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {

            SingleProccess cm = new SingleProccess();

            String selectFile = lstFiles.getSelectedValue();
            cm.selectFile = selectFile;

            cm.path = txtFilePath.getText();
            cm.height = Integer.parseInt(txtHeight.getText());
            cm.width = Integer.parseInt(txtWidth.getText());
            cm.rowStep = Integer.parseInt(txtRowStp.getText());
            cm.savepath = txtSaveTo.getText();
            if (txtSaveTo.getText().length() <= 0) {
                JFrame fr = new JFrame();
                changeFontJOptionPane();
                JOptionPane.showMessageDialog(fr, "Check whether you have selected a save path |");

            } else {

                Dimension windowSize = cm.getSize();
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                Point centerPoint = ge.getCenterPoint();

                int dx = centerPoint.x - windowSize.width / 2;
                int dy = centerPoint.y - windowSize.height / 2;
                cm.setLocation(dx, dy);
                cm.setVisible(true);
            }
        } catch (NumberFormatException ex) {

            JFrame fr = new JFrame();

            JOptionPane.showMessageDialog(fr, checkErrorPNG());

        }
    }//GEN-LAST:event_btnSaveActionPerformed
    String checkErrorPNG() {
        String err = "Check whether you have set";
        try {
            if (lstFiles.getSelectedValue().length() <= 0) {
                err += " selected an image |";
            }
        } catch (Exception e) {
            err += " selected an image |";
        }
        if (txtHeight.getText().length() <= 0) {
            err += " height |";

        }
        if (txtWidth.getText().length() <= 0) {
            err += " width |";

        }

        if (txtSaveTo.getText().equals("")) {
            err += " save path |";
        }

        if (txtRowStp.getText().equals("")) {
            err += " row step |";
        }
        return err;

    }
    private void btnBatchProccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatchProccessActionPerformed
        BatchProccess bp = new BatchProccess();

        try {

            bp.height = Integer.parseInt(txtHeight.getText());
            bp.width = Integer.parseInt(txtWidth.getText());
            bp.rowStep = Integer.parseInt(txtRowStp.getText());
            bp.selectPath = txtFilePath.getText();
            bp.savepath = txtSaveTo.getText();

            if (txtSaveTo.getText().length() <= 0) {
                JFrame fr = new JFrame();
                changeFontJOptionPane();
                JOptionPane.showMessageDialog(fr, "Check whether you have selected a save path |");

            } else {
                Dimension windowSize = bp.getSize();
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                Point centerPoint = ge.getCenterPoint();

                int dx = centerPoint.x - windowSize.width / 2;
                int dy = centerPoint.y - windowSize.height / 2;
                bp.setLocation(dx, dy);

                bp.setVisible(true);
            }

        } catch (NumberFormatException ex) {
            JFrame fr = new JFrame();
            JOptionPane.showMessageDialog(fr, checkErrorBMP());

        }
    }//GEN-LAST:event_btnBatchProccessActionPerformed
    String checkErrorBMP() {
        String err = "Check again whether you have set";

        if (txtHeight.getText().length() <= 0) {

            err += " height |";
        }

        if (txtWidth.getText().length() <= 0) {
            err += " width |";
        }
        if (txtSaveTo.getText().equals("")) {
            err += " save path |";
        }
        if (txtRowStp.getText().equals("")) {
            err += " row step |";
        }
        return err;

    }

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed

        enable_Buttons();
        btnSave.setEnabled(false);
        try {

            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            Dimension dm = new Dimension(900, 800);
            chooser.setPreferredSize(dm);
            int rv = chooser.showOpenDialog(null);

            if (rv == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();

                String filename = file.getAbsolutePath() + "/";

                txtFilePath.setText(filename);

                DefaultListModel model = new DefaultListModel();

                File dir = new File(filename);
                String[] files = dir.list();
                try {
                    if (files.length == 0) {
                        JFrame fr1 = new JFrame();
                        changeFontJOptionPane();
                        JOptionPane.showMessageDialog(fr1, "This directory has no yuv files.");

                    } else {
                        for (String aFile : files) {

                            File yuvFileOnly = new File(filename.concat(aFile));
                            String extension = getFileExtension(yuvFileOnly);

                            if (extension.equalsIgnoreCase("yuv")) {

                                model.addElement(aFile);

                            }

                        }
                    }

                } catch (HeadlessException x) {

                }

                lstFiles.setModel(model);

            } else {

                btnBatchProccess.setEnabled(false);
                btnSave.setEnabled(false);
            }
        } catch (HeadlessException e) {

        }
    }//GEN-LAST:event_btnChooseActionPerformed

    void setDefaultParas() {
        imageSelectedFromList = 0;
        lstFiles.setModel(new DefaultListModel());
        lblPreview.setText("");
        ImageIcon im = new ImageIcon("");
        lblPreview.setIcon(im);
        lblZoom.setText("");
        lblPreview.setText("Image will be appeared here");
        txtFilePath.setText("");
        txtSaveTo.setText("");
        txtHeight.setText("");
        txtWidth.setText("");
        txtRowStp.setText("");
        btnBatchProccess.setEnabled(false);
        btnSave.setEnabled(false);
        lblSelectedImage.setText("");
        Color clr1 = new Color(42, 44, 59);
        pnlSelectedImage.setBackground(clr1);
        lblSelectedImage.setText("");
        Color clr2 = new Color(153, 153, 153);
        lblSelectedImage.setForeground(clr2);
        btnZooming.setEnabled(false);
    }
    private void btnClearListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearListActionPerformed

        changeFontJOptionPane();
        int response = JOptionPane.showConfirmDialog(null, "Are you sure that you want to clear?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        switch (response) {
            case JOptionPane.NO_OPTION:
                break;
            case JOptionPane.YES_OPTION:
                try {
                    setDefaultParas();
                    break;
                } catch (Exception e) {

                    setDefaultParas();

                }
            case JOptionPane.CLOSED_OPTION:

                break;
            default:
                break;
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearListActionPerformed

    private void txtHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHeightActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtHeightActionPerformed

    private void txtRowStpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRowStpKeyTyped
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txtRowStpKeyTyped

    private void txtHeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHeightKeyTyped
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txtHeightKeyTyped

    private void txtWidthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWidthKeyTyped
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txtWidthKeyTyped

    private void btnZoomingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomingActionPerformed

        try {
            Toolkit toolkit2 = Toolkit.getDefaultToolkit();
            BufferedImage myImage1 = ImageIO.read(ConverterHome.class.getResource(zoom_in));

            Image image3 = myImage1;
            Cursor c0 = toolkit2.createCustomCursor(image3, new Point(lblPreview.getX(), lblPreview.getY()), "img");
            lblPreview.setCursor(c0);
            lblPreview.addMouseListener(getMouseListenerForZooming(lblPreview, 1.25));        // TODO add your handling code here:
        } catch (HeadlessException | IOException | IndexOutOfBoundsException e) {
        }


    }//GEN-LAST:event_btnZoomingActionPerformed
    public static byte[] combine(byte[] a, byte[] b) {
        int length = a.length + b.length;
        byte[] result = new byte[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    boolean createDir(Path path) {

        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);

                return true;

            } catch (IOException e) {
                JFrame fr = new JFrame();
                changeFontJOptionPane();
                JOptionPane.showMessageDialog(fr, "Something went wrong. Please try again!");
                return false;
            }
        } else if (Files.exists(path)) {
            return true;
        }
        return false;
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    String checkErrorPreview() {
        String err = "Check again whether you have";

        if (txtHeight.getText().length() <= 0) {

            err += " set Height |";

        }

        if (txtWidth.getText().length() <= 0) {
            err += " set Width |";

        }
        if (txtRowStp.getText().equals("")) {
            err += " set Row Step |";
        }
        return err;

    }

    private void previewImage(String selectFile) {

        SwingWorker<String, Integer> swingWorker = new SwingWorker< String, Integer>() {
            @Override
            protected String doInBackground() throws Exception {

                Color clr0 = new Color(42, 44, 59);
                pnlSelectedImage.setBackground(clr0);

                int width = 0, height = 0, rowStep = 0;
                try {
                    width = Integer.parseInt(txtWidth.getText());
                    height = Integer.parseInt(txtHeight.getText());
                    rowStep = Integer.parseInt(txtRowStp.getText());
                } catch (NumberFormatException ex) {

                    JFrame fr = new JFrame();
                    changeFontJOptionPane();
                    JOptionPane.showMessageDialog(fr, checkErrorPreview());
                    enableUIComponent();
                    return null;

                }
                showImagePreviewer(true);

                String path = txtFilePath.getText();
                String savepath = path;
                File file = new File(path + selectFile); // The input NV21 file
                String extension = getFileExtension(file);

                if (extension.equalsIgnoreCase("yuv")) {

                    Random rand = new Random();

                    short pixelBits = 32;

                    try {

                        int n = rand.nextInt(100000) + 1;
                        String name = selectFile + "_" + Integer.toString(n);
                        byte[] bytes = Files.readAllBytes(file.toPath());

                        int size_total, size_qrtr;
                        size_total = bytes.length;
                        size_qrtr = size_total / 2;

                        byte[] uByte = new byte[size_qrtr]; // for u
                        byte[] vByte = new byte[size_qrtr]; // for v

                        Arrays.fill(uByte, (byte) 128);
                        Arrays.fill(vByte, (byte) 128);

                        byte[] uvBytes = combine(uByte, vByte);

                        byte[] final_bytes = combine(bytes, uvBytes);

                        int[] data = NV21.yuv2rgb(final_bytes, width, height, rowStep);

                        BMP bmp = new BMP(width, height, pixelBits, data);
                        bmp.saveBMP(savepath + name + ".bmp"); // The output BMP file

                        BufferedImage input_image = null;
                        input_image = ImageIO.read(new File(savepath + name + ".bmp")); //read bmp into input_image object
                        File outputfile = new File(savepath + name + ".png"); //create new outputfile object
                        ImageIO.write(input_image, "PNG", outputfile); //write PNG output to file

                        lblPreview.setText(null);

                        lblSelectedImage.setText("");
                        lblSelectedImage.setText(selectFile);

                        Color clr = new Color(42, 44, 59);
                        pnlSelectedImage.setBackground(clr);
                        lblSelectedImage.setForeground(Color.white);

                        BufferedImage image = null;
                        try {
                            image = loadImage(savepath + name + ".png");

                        } catch (IOException e) {

                        }
                        ImageIcon im = new ImageIcon(image);

                        lblPreview.setIcon(im);
                        lblZoom.setText("");
                        mouseListenerIsActive = false;
                        lblPreview.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        showImagePreviewer(false);
                        enableUIComponent();

                        Path dltPath = Paths.get(savepath + name + ".bmp");
                        Files.delete(dltPath);
                        Path dltPath1 = Paths.get(savepath + name + ".png");
                        Files.delete(dltPath1);

                    } catch (IOException e) {

                        JFrame fr = new JFrame();
                        changeFontJOptionPane();
                        JOptionPane.showMessageDialog(fr, "Something went wrong. Please try again!");
                        showImagePreviewer(false);
                    }
                }

                return null;

            }

        };
        swingWorker.execute();
    }

    void enable_Buttons() {
        btnBatchProccess.setEnabled(true);
        btnSave.setEnabled(true);
        btnSaveTo.setEnabled(true);
        lstFiles.setEnabled(true);
        status = 0;
        btnZooming_status = status;
        btnSave_status = status;
        btnSaveTo_status = status;
        btnBatchProccess_status = status;

    }

    void disable_Buttons() {
        btnZooming.setEnabled(false);
        btnBatchProccess.setEnabled(false);
        btnSave.setEnabled(false);
        btnSaveTo.setEnabled(false);
        lstFiles.setEnabled(false);

        status = 1;
        btnZooming_status = status;
        btnSave_status = status;
        btnSaveTo_status = status;
        btnBatchProccess_status = status;

    }

    void showImagePreviewer(boolean b) {

        Dimension windowSize = ipw.getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        ipw.setLocation(dx, dy);

        if (b == true) {

            ipw.setVisible(true);

        } else if (b == false) {

            ipw.setVisible(false);

        }
    }

    void showSpinner(boolean b) {

        Dimension windowSize = sp.getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        sp.setLocation(dx, dy);

        if (b == true) {

            sp.setVisible(true);

        } else if (b == false) {

            sp.setVisible(false);

        }
    }

    void disableUIComponent() {

        btnChoose.setEnabled(false);
        btnSaveTo.setVisible(false);
        btnBatchProccess.setEnabled(false);
        btnSave.setEnabled(false);
        btnZooming.setEnabled(false);
        lstFiles.setEnabled(false);
        txtHeight.setEnabled(false);
        txtRowStp.setEnabled(false);
        txtWidth.setEnabled(false);

        status = 1;
        btnZooming_status = status;
        btnSave_status = status;
        btnSaveTo_status = status;
        btnBatchProccess_status = status;
    }

    void enableUIComponent() {
        btnZooming.setEnabled(true);
        btnChoose.setEnabled(true);
        btnSaveTo.setVisible(true);
        btnBatchProccess.setEnabled(true);
        btnSave.setEnabled(true);
        lstFiles.setEnabled(true);
        txtHeight.setEnabled(true);
        txtRowStp.setEnabled(true);
        txtWidth.setEnabled(true);
       
        status = 0;
        btnZooming_status = status;
        btnSave_status = status;
        btnSaveTo_status = status;
        btnBatchProccess_status = status;

    }
    
  

    void changeFontJOptionPane() {

        UIManager.put("OptionPane.messageFont", new Font("System", Font.BOLD, 13));
    }

    public static BufferedImage loadImage(final String filepath)
            throws IOException {
        return ImageIO.read(new File(filepath));
    }

    public static ImageIcon getIcon(BufferedImage image) {
        return new ImageIcon(image);
    }

    public static BufferedImage aspectZoom(BufferedImage image, Point focus, double scale) {

        double origWidth = image.getWidth(), origHeight = image.getHeight();
        double cutWidth = origWidth / scale, cutHeight = origHeight / scale;

        int upperLeftX = (int) Math.round(focus.getX() - cutWidth / 2.0), upperLeftY = (int) Math.round(focus.getY() - cutHeight / 2.0);
        int bottomRightX = (int) Math.ceil(focus.getX() + cutWidth / 2.0), bottomRightY = (int) Math.ceil(focus.getY() + cutHeight / 2.0);

        if (upperLeftX < 0) {

            upperLeftX = 0;

        }
        if (upperLeftY < 0) {

            upperLeftY = 0;

        }
        if (bottomRightX > origWidth) {
            int a = upperLeftX;

            upperLeftX = upperLeftX - (int) (bottomRightX - origWidth);
            bottomRightX = (int) Math.ceil(upperLeftX + cutWidth);

        }
        if (bottomRightY > origHeight) {
            int a = upperLeftY;

            upperLeftY = upperLeftY - (int) (bottomRightY - origHeight);
            bottomRightY = (int) Math.ceil(upperLeftY + cutHeight);

        }

        BufferedImage croppedImage = image.getSubimage(upperLeftX, upperLeftY, ((int) cutWidth == 0 ? 1 : (int) cutWidth), ((int) cutHeight == 0 ? 1 : (int) cutHeight));

        AffineTransform transform = new AffineTransform();
        transform.setToScale(origWidth / cutWidth, origHeight / cutHeight);
        AffineTransformOp tOper = new AffineTransformOp(transform, AffineTransformOp.TYPE_BICUBIC);

        BufferedImage zoomedImage = tOper.filter(croppedImage, null);

        return zoomedImage;
    }

    public static MouseAdapter getMouseListenerForZooming(final JLabel label, final double zoom_factor) {
        mouseListenerIsActive = true;
        if (zoom_factor == 0) {
            throw new RuntimeException("zoom_factor is not allowed to be zero");
        }

        return new MouseAdapter() {

            public double current_zoom = 1.0;

            public final BufferedImage originalImage = (BufferedImage) (((ImageIcon) label.getIcon()).getImage());

            @Override
            public void mouseClicked(MouseEvent evt) {

                if (mouseListenerIsActive) {
                    // int clickCount = evt.getClickCount();
                    int btn_pressed = evt.getButton();

                    switch (btn_pressed) {

                        case MouseEvent.BUTTON1:

                            Toolkit toolkit = Toolkit.getDefaultToolkit();
                            try {
                                BufferedImage myImage = ImageIO.read(ConverterHome.class.getResource(zoom_in));
                                Image image2 = myImage;
                                Cursor c = toolkit.createCustomCursor(image2, new Point(lblPreview.getX(), lblPreview.getY()), "img");
                                lblPreview.setCursor(c);

                                label.setIcon(new ImageIcon(aspectZoom((BufferedImage) (((ImageIcon) label.getIcon()).getImage()), evt.getPoint(), zoom_factor)));
                                this.current_zoom *= zoom_factor;

                                if (this.current_zoom > 50) {
                                    this.current_zoom = 50;
                                    lblZoom.setText(this.current_zoom + " x Maximum zoom");
                                }
                                printCurrentZoom();
                            } catch (Exception e) {
                            }
                            break;

                        case MouseEvent.BUTTON3:
                            if (this.current_zoom <= 1) {
                                try {

                                    mouseListenerIsActive = false;
                                    lblPreview.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

                                } catch (Exception e) {
                                }
                                return;
                            } else {
                                try {
                                    Toolkit toolkit1 = Toolkit.getDefaultToolkit();
                                    BufferedImage myImage1 = ImageIO.read(ConverterHome.class.getResource(zoom_out));
                                    Image image = myImage1;
                                    Cursor c1 = toolkit1.createCustomCursor(image, new Point(lblPreview.getX(), lblPreview.getY()), "img");
                                    lblPreview.setCursor(c1);

                                    label.setIcon(new ImageIcon(aspectZoom(this.originalImage, evt.getPoint(), this.current_zoom / zoom_factor)));
                                    this.current_zoom /= zoom_factor;
                                    printCurrentZoom();
                                } catch (Exception e) {
                                }
                            }
                            break;

                    }
                }
            }

            public void printCurrentZoom() {

                lblZoom.setText(this.current_zoom + " x");
                //System.out.println("\nCurrent Zoom: " + this.current_zoom + "x\n");
            }
        };

    }

    // zoom done
    /**
     * s
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConverterHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ConverterHome().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnBatchProccess;
    public static javax.swing.JButton btnChoose;
    public static javax.swing.JButton btnClearList;
    public static javax.swing.JButton btnSave;
    public static javax.swing.JButton btnSaveTo;
    public static javax.swing.JButton btnZooming;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblPreview;
    private javax.swing.JLabel lblSelectedImage;
    public static javax.swing.JLabel lblZoom;
    public static javax.swing.JList<String> lstFiles;
    private javax.swing.JPanel pnlSelectedImage;
    public static javax.swing.JScrollPane scrlPane;
    public static javax.swing.JTextField txtFilePath;
    public static javax.swing.JTextField txtHeight;
    public static javax.swing.JTextField txtRowStp;
    public static javax.swing.JTextField txtSaveTo;
    public static javax.swing.JTextField txtWidth;
    // End of variables declaration//GEN-END:variables
}
