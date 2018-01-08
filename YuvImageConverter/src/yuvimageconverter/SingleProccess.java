package yuvimageconverter;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import static yuvimageconverter.ConverterHome.*;

/**
 *
 * @author zebra All rights reserved
 */
public class SingleProccess extends javax.swing.JFrame {

    String path, selectFile, savepath;
    int height, width, rowStep;
    String[] hexArray;
    ImagePreviewingWindow ipw = new ImagePreviewingWindow();

    public SingleProccess() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        changeMouseOverColor();
    }

    public void changeMouseOverColor() {

        Color clrFor = new Color(62, 60, 81);
        Color clrBack = new Color(187, 187, 187);

        btnBmp.addMouseListener(new MouseAdapter() {
            Color oldcolor = btnBmp.getForeground();

            public void mouseEntered(MouseEvent me) {

                btnBmp.setForeground(clrFor);
                btnBmp.setBackground(clrBack);
            }

            public void mouseExited(MouseEvent me) {
                btnBmp.setForeground(clrBack);
                btnBmp.setBackground(clrFor);
            }
        });
        btnPng.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent me) {
                btnPng.setForeground(clrFor);
                btnPng.setBackground(clrBack);
            }

            public void mouseExited(MouseEvent me) {
                btnPng.setForeground(clrBack);
                btnPng.setBackground(clrFor);
            }
        });
        btnDotH.addMouseListener(new MouseAdapter() {
            Color oldcolor = btnDotH.getForeground();

            public void mouseEntered(MouseEvent me) {
                btnDotH.setForeground(clrFor);
                btnDotH.setBackground(clrBack);
            }

            public void mouseExited(MouseEvent me) {
                btnDotH.setForeground(clrBack);
                btnDotH.setBackground(clrFor);
            }
        });
        btnCancel.addMouseListener(new MouseAdapter() {
            Color oldcolor = btnCancel.getForeground();

            public void mouseEntered(MouseEvent me) {
                btnCancel.setForeground(clrFor);
                btnCancel.setBackground(clrBack);
            }

            public void mouseExited(MouseEvent me) {
                btnCancel.setForeground(clrBack);
                btnCancel.setBackground(clrFor);
            }
        });
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
        jLabel1 = new javax.swing.JLabel();
        btnPng = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnBmp = new javax.swing.JButton();
        btnDotH = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Single proccess");

        jPanel1.setBackground(new java.awt.Color(62, 60, 81));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("How do you want to save your image?");

        btnPng.setBackground(new java.awt.Color(62, 60, 81));
        btnPng.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnPng.setForeground(new java.awt.Color(255, 255, 255));
        btnPng.setText("PNG");
        btnPng.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnPng.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPng.setMargin(new java.awt.Insets(5, 15, 5, 15));
        btnPng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPngActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(62, 60, 81));
        btnCancel.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.setMargin(new java.awt.Insets(5, 15, 5, 15));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnBmp.setBackground(new java.awt.Color(62, 60, 81));
        btnBmp.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnBmp.setForeground(new java.awt.Color(255, 255, 255));
        btnBmp.setText("BMP");
        btnBmp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnBmp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBmp.setMargin(new java.awt.Insets(5, 15, 5, 15));
        btnBmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBmpActionPerformed(evt);
            }
        });

        btnDotH.setBackground(new java.awt.Color(62, 60, 81));
        btnDotH.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnDotH.setForeground(new java.awt.Color(255, 255, 255));
        btnDotH.setText(".h");
        btnDotH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnDotH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDotH.setMargin(new java.awt.Insets(5, 15, 5, 15));
        btnDotH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDotHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBmp, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPng, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDotH, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 64, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPng, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBmp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDotH, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnCancel)
                .addGap(16, 16, 16))
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPngActionPerformed
        showSpinner(true);
        setVisible(false);
        disableUIComponent();
        convertToPNG();        // TODO add your handling code here:
    }//GEN-LAST:event_btnPngActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setVisible(false);    // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnBmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBmpActionPerformed
        showSpinner(true);
        setVisible(false);
        disableUIComponent();
        convertToBMP(); // TODO add your handling code here:
    }//GEN-LAST:event_btnBmpActionPerformed

    private void btnDotHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDotHActionPerformed
        showSpinner(true);
        setVisible(false);
        disableUIComponent();
        convertToDotH();
    }//GEN-LAST:event_btnDotHActionPerformed
    public static byte[] combine(byte[] a, byte[] b) {
        int length = a.length + b.length;
        byte[] result = new byte[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    private void convertToDotH() {
        // disableUIComponent();
        SwingWorker<String, Integer> swingWorker = new SwingWorker< String, Integer>() {
            @Override
            protected String doInBackground() throws Exception {

                File file = new File(path + selectFile); // The input NV21 file
                String subPath = "Converted images/Single/H Files/";
                String extension = getFileExtension(file);

                if (extension.equalsIgnoreCase("yuv")) {
                    Random rand = new Random();
                    int n = rand.nextInt(100000) + 1;
                    String name = selectFile + "_" + Integer.toString(n);

                    short pixelBits = 32;

                    try {
                        // Read all bytes
                        byte[] bytes = Files.readAllBytes(file.toPath());

                        int size_total, size_half;
                        size_total = bytes.length;
                        size_half = size_total / 2;

                        byte[] uByte = new byte[size_half]; // for u
                        byte[] vByte = new byte[size_half]; // for v

                        Arrays.fill(uByte, (byte) 128);
                        Arrays.fill(vByte, (byte) 128);

                        byte[] uvBytes = combine(uByte, vByte);
                        byte[] final_bytes = combine(bytes, uvBytes);

                  //      int[] data = NV21.yuv2rgb(final_bytes, width, height, rowStep);
                        byte[] byte_data = NV21.returnByteArray(final_bytes, width, height, rowStep);

                      //  BMP bmp = new BMP(width, height, pixelBits, data);

                        String saveFilePath = savepath + subPath + name + ".txt";
                        getHexArr(byte_data, saveFilePath);

                        setVisible(false);
                        showSpinner(false);
                        JFrame fr = new JFrame();
                        changeFontJOptionPane();
                        JOptionPane.showMessageDialog(fr, "File successfully created");
                        enableUIComponent();

                    } catch (Exception e) {

                        showSpinner(false);
                        JFrame fr = new JFrame();

                        if (savepath.equalsIgnoreCase(null)) {
                            changeFontJOptionPane();
                            JOptionPane.showMessageDialog(fr, "Please select a save path");
                        }
                        enableUIComponent();
                    }
                }
                setVisible(false);
                return null;

            }

            @Override
            protected void process(List<Integer> list) {

            }

        };
        swingWorker.execute();
    }

    public void getHexArr(byte[] byteArr, String saveFilePath) {

        hexArray = new String[width * height];
        for (int i = 0; i < hexArray.length; i++) {
            hexArray[i] = byteToHex(byteArr[i]);
        }
        try {
            write(hexArray, saveFilePath);

        } catch (Exception e) {
        }
    }

    public String byteToHex(byte b) {
        int i = b & 0xFF;
        String hexNum = Integer.toHexString(i);
        if (hexNum.length() < 2) {
            hexNum = "0x0" + Integer.toHexString(i);
        } else if (hexNum.length() == 2) {
            hexNum = "0x" + Integer.toHexString(i);
        }

        return hexNum;
    }

    public void write(String[] hexArr, String saveFilePath) throws IOException {

        BufferedWriter outputWriter = null;
        String comment = "/* width(" + width + ")*height(" + height + ") = " + width * height + " */";

        String arrayDescription = "unsigned char array[" + width * height + "]={";
        System.out.println(arrayDescription);
        outputWriter = new BufferedWriter(new FileWriter(saveFilePath));
        outputWriter.write(comment);
        outputWriter.newLine();
        outputWriter.write(arrayDescription);
        outputWriter.newLine();

        int count = 0;
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {

                if (x == height - 1 && y == width - 1) {
                    //   System.out.print(" " + hexArr[count] + "if ");
                    outputWriter.write(hexArr[count] + "};");
                } else {
                    //   System.out.print(" " + hexArr[count] + "else ");
                    outputWriter.write(hexArr[count] + ",");
                }
                count++;
            }
            //     System.out.println();
            outputWriter.newLine();

        }

        outputWriter.flush();
        outputWriter.close();
    }

    private void convertToPNG() {

        SwingWorker<String, Integer> swingWorker = new SwingWorker< String, Integer>() {
            @Override
            protected String doInBackground() throws Exception {
                File file = new File(path + selectFile); // The input NV21 filConverted imagese
                String extension = getFileExtension(file);
                String subPath = "Converted images/Single/PNG/";
                if (extension.equalsIgnoreCase("yuv")) {

                    Random rand = new Random();

                    short pixelBits = 32;

                    try {
                        int n = rand.nextInt(100000) + 1;
                        String name = selectFile + "_" + Integer.toString(n);
                        byte[] bytes = Files.readAllBytes(file.toPath());

                        int size_total, size_half;
                        size_total = bytes.length;
                        size_half = size_total / 2;

                        byte[] uByte = new byte[size_half]; // for u
                        byte[] vByte = new byte[size_half]; // for v

                        Arrays.fill(uByte, (byte) 128);
                        Arrays.fill(vByte, (byte) 128);

                        byte[] uvBytes = combine(uByte, vByte);
                        byte[] final_bytes = combine(bytes, uvBytes);

                        int[] data = NV21.yuv2rgb(final_bytes, width, height, rowStep);
                        BMP bmp = new BMP(width, height, pixelBits, data);
                        bmp.saveBMP(savepath + subPath + name + ".bmp"); // The output BMP file

                        BufferedImage input_image = null;
                        input_image = ImageIO.read(new File(savepath + subPath + name + ".bmp")); //read bmp into input_image object
                        File outputfile = new File(savepath + subPath + name + ".png"); //create new outputfile object
                        ImageIO.write(input_image, "PNG", outputfile); //write PNG output to file
                        setVisible(false);

                        JFrame fr = new JFrame();
                        showSpinner(false);
                        changeFontJOptionPane();
                        JOptionPane.showMessageDialog(fr, "Image successfully saved");
                        enableUIComponent();

                        Path dltPath = Paths.get(savepath + subPath + name + ".bmp");
                        Files.delete(dltPath);

                    } catch (Exception e) {
                        showSpinner(false);

                        JFrame fr = new JFrame();
                        changeFontJOptionPane();
                        JOptionPane.showMessageDialog(fr, "Something went wrong. Please try again!");
                        enableUIComponent();
                    }
                }
                setVisible(false);
                return null;

            }

        };
        swingWorker.execute();
    }

    private void convertToBMP() {
     
        SwingWorker<String, Integer> swingWorker = new SwingWorker< String, Integer>() {
            @Override
            protected String doInBackground() throws Exception {

                File file = new File(path + selectFile); // The input NV21 file
                String subPath = "Converted images/Single/BMP/";
                String extension = getFileExtension(file);

                if (extension.equalsIgnoreCase("yuv")) {
                    Random rand = new Random();
                    int n = rand.nextInt(100000) + 1;
                    String name = selectFile + "_" + Integer.toString(n);

                    short pixelBits = 32;

                    try {
                        // Read all bytes
                        byte[] bytes = Files.readAllBytes(file.toPath());

                        int size_total, size_half;
                        size_total = bytes.length;
                        size_half = size_total / 2;

                        byte[] uByte = new byte[size_half]; // for u
                        byte[] vByte = new byte[size_half]; // for v

                        Arrays.fill(uByte, (byte) 128);
                        Arrays.fill(vByte, (byte) 128);

                        byte[] uvBytes = combine(uByte, vByte);
                        byte[] final_bytes = combine(bytes, uvBytes);

                        int[] data = NV21.yuv2rgb(final_bytes, width, height, rowStep);
                        BMP bmp = new BMP(width, height, pixelBits, data);

                        bmp.saveBMP(savepath + subPath + name + ".bmp"); // The output BMP file

                        setVisible(false);
                        showSpinner(false);
                        JFrame fr = new JFrame();
                        changeFontJOptionPane();
                        JOptionPane.showMessageDialog(fr, "Image successfully saved");
                        enableUIComponent();

                    } catch (Exception e) {

                        showSpinner(false);
                        JFrame fr = new JFrame();

                        if (savepath.equalsIgnoreCase(null)) {
                            changeFontJOptionPane();
                            JOptionPane.showMessageDialog(fr, "Please select a save path");
                        }
                        enableUIComponent();
                    }
                }
                setVisible(false);
                return null;

            }

            @Override
            protected void process(List<Integer> list) {

            }

        };
        swingWorker.execute();
    }

    void showSpinner(boolean b) {
        if (b == true) {
            ipw.setVisible(true);
        } else if (b == false) {
            ipw.setVisible(false);
        }
        Dimension windowSize = ipw.getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        ipw.setLocation(dx, dy);

    }

    void changeFontJOptionPane() {
        UIManager.put("OptionPane.messageFont", new Font("System", Font.BOLD, 13));
    }

    void setTruOrFalse(boolean val) {

        btnChoose.setEnabled(val);
        btnSaveTo.setVisible(val);
        btnBatchProccess.setEnabled(val);
        btnSave.setEnabled(val);
        btnClearList.setEnabled(val);
        lstFiles.setEnabled(val);
        txtHeight.setEnabled(val);
        txtRowStp.setEnabled(val);
        txtWidth.setEnabled(val);
        lblPreview.setEnabled(val);
        lblZoom.setEnabled(val);
        scrlPane.setEnabled(val);
        btnZooming.setEnabled(val);

    }

    void disableUIComponent() {
        setTruOrFalse(false);
        lblPreview.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    void enableUIComponent() {
        setTruOrFalse(true);
    }

    /**
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SingleProccess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SingleProccess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SingleProccess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SingleProccess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SingleProccess().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnBmp;
    public static javax.swing.JButton btnCancel;
    public static javax.swing.JButton btnDotH;
    public static javax.swing.JButton btnPng;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
