/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ateeq.bookstore;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;


/**
 *
 * @author nosix
 */
public class BookStore extends javax.swing.JFrame {
    
    private Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/bookstore";
    private String username = "root";
    private String password = "";
    
    

    /**
     * Creates new form BookStore
     */
    public BookStore() {
        initComponents();
        initialize_connection();
        populate_table();
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
        jLabel2 = new javax.swing.JLabel();
        bookname_input = new javax.swing.JTextField();
        bookprice_input = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        addbook_btn = new javax.swing.JButton();
        book_id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bookdelete_btn = new javax.swing.JButton();
        bookupdate_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel1.setText("Book Store");

        jLabel2.setText("Book Name: ");

        jLabel3.setText("Price:  ");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        addbook_btn.setText("Add");
        addbook_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbook_btnActionPerformed(evt);
            }
        });

        jLabel4.setText("Id");

        bookdelete_btn.setText("Delete");
        bookdelete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookdelete_btnActionPerformed(evt);
            }
        });

        bookupdate_btn.setText("Update");
        bookupdate_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookupdate_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(445, 445, 445))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(book_id, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(40, 40, 40)
                                .addComponent(bookname_input, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bookprice_input, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addbook_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(bookupdate_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(bookdelete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(254, 254, 254))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(book_id, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(bookname_input, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(bookprice_input, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addbook_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookdelete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookupdate_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addbook_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbook_btnActionPerformed
        // TODO add your handling code here:
        insert_book();
    }//GEN-LAST:event_addbook_btnActionPerformed

    private void bookdelete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookdelete_btnActionPerformed
        // TODO add your handling code here:
        delete_book();
        book_id.setText("");
    }//GEN-LAST:event_bookdelete_btnActionPerformed

    private void bookupdate_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookupdate_btnActionPerformed
        // TODO add your handling code here:
        update_book();
    }//GEN-LAST:event_bookupdate_btnActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        book_id.setText(String.valueOf(table.getColumnCount()));
        int selected_row = table.getSelectedRow();
        
        book_id.setText(String.valueOf(table.getValueAt(selected_row,0)));
        bookname_input.setText(String.valueOf(table.getValueAt(selected_row,1)));
        bookprice_input.setText(String.valueOf(table.getValueAt(selected_row,2)));
    }//GEN-LAST:event_tableMouseClicked

    /**
     * @param args the command line arguments
     */
    
    private void initialize_connection(){
        try{
            
            connection = (Connection) DriverManager.getConnection(url,username,password);
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    private void delete_book(){
        String id = book_id.getText().toString();
        
        try{
            String query = "DELETE FROM books WHERE id = "+id;
            PreparedStatement delete = connection.prepareStatement(query);
            delete.executeUpdate();
            
        }catch(Exception ex){
            
        }
        populate_table();
    }
    
    private void update_book(){
        
        String bookname = bookname_input.getText().toString();
        String bookprice = bookprice_input.getText().toString();
        String id = book_id.getText().toString();
        try{
            String query = "UPDATE books SET book_name='"+bookname+"', price='"+bookprice+"' WHERE id="+id;
            PreparedStatement update = connection.prepareStatement(query);
            update.executeUpdate();
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        populate_table();
    }
    
    private void insert_book(){
        
        String bookname = bookname_input.getText().toString();
        String bookprice = bookprice_input.getText().toString();
        
        
        
        try{
            String query = "INSERT INTO books(book_name,price) "+ "VALUES(?,?)";
            PreparedStatement create = connection.prepareStatement(query);
            create.setString(1,bookname);
            create.setString(2,bookprice);
            create.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }

        populate_table();
        
        
    }
    
    private void populate_table(){
        
        DefaultTableModel model = new DefaultTableModel();
        String query = "SELECT * FROM books";
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) 
                columnNames[i - 1] = metaData.getColumnName(i);
            
            model.setColumnIdentifiers(columnNames);

            // Add the rows to the table model
            while (rs.next()){ 
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) 
                    row[i - 1] = rs.getObject(i);
                
                model.addRow(row);
                
            }
            
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        table.setModel(model);
        
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        
        
     

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookStore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbook_btn;
    private javax.swing.JTextField book_id;
    private javax.swing.JButton bookdelete_btn;
    private javax.swing.JTextField bookname_input;
    private javax.swing.JTextField bookprice_input;
    private javax.swing.JButton bookupdate_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
