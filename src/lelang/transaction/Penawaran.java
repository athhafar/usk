/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lelang.transaction;

import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.*;
import lelang.*;
import lelang.menu.*;


/**
 *
 * @author athal
 */
public class Penawaran extends javax.swing.JFrame {

      private Connection con;
    private ResultSet rs, rs2;
    private Statement stat, stat2;
    private String sql, sql2, sql3, sql4;
    private Koneksi kon = new Koneksi();
    private DefaultTableModel model;
    private UserSession session = new UserSession();
    private SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
    
    /**
     * Creates new form Penawaran
     */
    public Penawaran() {
        initComponents();
        setLocationRelativeTo(this);
        
        con = kon.con;
        stat = kon.stat;
        stat2 = kon.stat;
        setTitle("Penawaran");
        aturTable();
    }
    
    private void aturTable(){
        String[] judul = {"Nama Barang", "Tgl Lelang", "Harga Awal", "Harga Akhir", "Penawar"};
        model = new DefaultTableModel(null, judul){
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        jTable1.setModel(model);
        
        try{
            sql = "SELECT * FROM tb_lelang INNER JOIN tb_barang ON tb_lelang.id_barang = tb_barang.id_barang LEFT JOIN tb_masyarakat ON tb_lelang.id_user = tb_masyarakat.id_user INNER JOIN tb_petugas ON tb_lelang.id_petugas = tb_petugas.id_petugas WHERE tb_lelang.status='dibuka'";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                Object[] isi = {rs.getString("nama_barang"),String.valueOf(fm.format(rs.getDate("tgl_lelang"))),rs.getString("harga_awal"), rs.getString("harga_akhir") == null ? "Belum Ada" : rs.getString("harga_akhir"), rs.getString("nama_lengkap") == null ? "Belum Ada" : rs.getString("nama_lengkap")};
                model.addRow(isi);
            }
            
            ((DefaultTableCellRenderer)jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            jTable1.setModel(model);
            
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setHorizontalAlignment(JLabel.CENTER);
            jTable1.getColumnModel().getColumn(0).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(1).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(2).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(3).setCellRenderer(render);
            jTable1.getColumnModel().getColumn(4).setCellRenderer(render);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"gagal"+e.getMessage());
        }
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
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Penawaran");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new User().show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        Integer id_barang;
        String result = JOptionPane.showInputDialog(frame, "Masukkan harga penawaran");

        if(result != null){
            try{
                sql = "SELECT id_barang,harga_awal FROM tb_barang WHERE nama_barang='"+ jTable1.getValueAt(jTable1.getSelectedRow(),0) +"'";
                rs = stat.executeQuery(sql);
                if(rs.next()){
                    id_barang = rs.getInt("id_barang");

                    if(Integer.parseInt(result) > rs.getInt("harga_awal")){
                        sql2 = "SELECT harga_akhir FROM tb_lelang WHERE id_barang='"+ id_barang +"' AND harga_akhir IS NOT NULL";
                        rs2 = stat2.executeQuery(sql2);
                        if(rs2.next()){
                            if(Integer.parseInt(result) > rs2.getInt("harga_akhir")){
                                sql3 = "INSERT INTO tb_history_lelang VALUES ("+ null +",(SELECT id_lelang FROM tb_lelang WHERE id_barang='"+ id_barang +"'),'"+ id_barang +"', '"+ session.getId() +"', '"+ result +"')";
                                sql4 = "UPDATE tb_lelang SET harga_akhir='"+ result +"', id_user='"+ session.getId() +"' WHERE id_barang='"+ id_barang +"'";

                                stat.execute(sql3);
                                stat.execute(sql4);

                                JOptionPane.showMessageDialog(null, "Sukses menambah penawaran");

                                model.fireTableDataChanged();
                                model.getDataVector().removeAllElements();

                                aturTable();
                            } else{
                                JOptionPane.showMessageDialog(null,"Masukkan nominal lelang lebih dari harga akhir!");
                            }
                        } else {
                            sql3 = "INSERT INTO tb_history_lelang VALUES ("+ null +",(SELECT id_lelang FROM tb_lelang WHERE id_barang='"+ id_barang +"'),'"+ id_barang +"', '"+ session.getId() +"', '"+ result +"')";
                            sql4 = "UPDATE tb_lelang SET harga_akhir='"+ result +"', id_user='"+ session.getId() +"' WHERE id_barang='"+ id_barang +"'";

                            stat.execute(sql3);
                            stat.execute(sql4);

                            JOptionPane.showMessageDialog(null, "Sukses menambah penawaran");

                            model.fireTableDataChanged();
                            model.getDataVector().removeAllElements();

                            aturTable();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Masukkan nominal lelang lebih dari harga awal!");
                    }
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"gagal"+e.getMessage());
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(Penawaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penawaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penawaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penawaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penawaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
