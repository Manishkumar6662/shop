/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package allpanerlsss;

import com.silverwink.medicalshop.DataBaseConnection;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class creatingabill extends javax.swing.JPanel {

    /**
     * Creates new form creatingabill
     */
     public static int user_id,product_select_row;
     public static int custdata,product_id;
     DefaultTableModel productdefaultTableModel;
    public creatingabill() {
        initComponents();
    }
   
    public creatingabill (int us){
        initComponents();
        user_id=us;
        jButton2.setVisible(false);
        qtychange.setVisible(false);
        
    }
    
    @SuppressWarnings("unchecked")
      public void getProduct(String data1){
        try {
            Connection con = DataBaseConnection.getConnection();
            
            String qry ="";
            
            if(data1.equals("all")){
                qry = "SELECT * FROM addproduct WHERE user_id='"+user_id+"'";
            } else {
                qry = "SELECT * FROM addproduct WHERE user_id='"+user_id+"' and product_name LIKE '%"+data1+"%'";
            }
            PreparedStatement preparedStatement = con.prepareStatement(qry);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            String field_name[] = {"Product Number","Product_name","Product_price","Quantity",};

            DefaultTableModel defaultTableModel = new DefaultTableModel(field_name,0);
        
            while(resultSet.next()){
                String p_name = resultSet.getString("product_name");
                String p_num = resultSet.getString("product_number");
                String p_price = resultSet.getString("product_price");
                String p_qnt = resultSet.getString("quantity");
                
                String[] data = {p_name,p_num,p_price,p_qnt};
                defaultTableModel.addRow(data);
            }
            customer_table.setModel(defaultTableModel);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "DATABASE Product ERROR");
            System.out.println("Priduct ERRO =>"+e);
        }
        
    }
       public void getCustomer(String data1){
        try {
            Connection con = DataBaseConnection.getConnection();
            
            String qry ="";
            
            if(data1.equals("all")){
                qry = "SELECT * FROM partytable WHERE user_id='"+user_id+"'";
            } else {
                qry = "SELECT * FROM partytable WHERE user_id='"+user_id+"' and product_name LIKE '%"+data1+"%'";
            }
            PreparedStatement preparedStatement = con.prepareStatement(qry);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            String field_name[] = {"Name","Contact", "Email","Address"};

            DefaultTableModel defaultTableModel = new DefaultTableModel(field_name,0);
        
            while(resultSet.next()){
                String pname = resultSet.getString("Name");
                String pcontact = resultSet.getString("Contact");
                String pemail = resultSet.getString("Email");
                String padd= resultSet.getString("Address");
                
                String[] data = {pname,pcontact,pemail,padd};
                defaultTableModel.addRow(data);
            }
            customer_table.setModel(defaultTableModel);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "DATABASE customer ERROR");
            System.out.println("Priduct ERRO =>"+e);
        }
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        bill_date = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        bill_number = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        product_bill = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        details = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        customer_table = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        cgst1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        sgst1 = new javax.swing.JTextField();
        Total = new javax.swing.JLabel();
        final_price_box = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        option = new javax.swing.JLabel();
        search_detail = new javax.swing.JTextField();
        qtychange = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel6.setText("Bill Date :");

        jLabel7.setText("Bill no.");

        product_bill.setModel(new javax.swing.table.DefaultTableModel(
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
        product_bill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_billMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(product_bill);

        details.setColumns(20);
        details.setRows(5);
        details.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(details);

        jButton1.setText("Select customer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        customer_table.setModel(new javax.swing.table.DefaultTableModel(
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
        customer_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customer_tableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(customer_table);

        jButton2.setText("Change Quantity");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Select Product");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("GST Enabeled bill");

        jLabel2.setText("CGST :");

        cgst1.setText("9");
        cgst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cgst1ActionPerformed(evt);
            }
        });

        jLabel3.setText("SGST :");

        sgst1.setText("9");

        Total.setText("Total amount :");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CREATE A PRODUCT BILL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        search_detail.setText("Search detail");
        search_detail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                search_detailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                search_detailFocusLost(evt);
            }
        });
        search_detail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_detailKeyReleased(evt);
            }
        });

        jLabel5.setText("Product Details");

        jButton5.setText("Generate Bill");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setText("Genrate Total");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("Genrate Bill Number");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sgst1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cgst1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(final_price_box, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton3))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(bill_number, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(22, 22, 22)
                                                .addComponent(jButton6))
                                            .addComponent(bill_date, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(135, 135, 135)
                                        .addComponent(qtychange, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(search_detail, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(option, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2)
                                    .addComponent(qtychange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)))
                        .addGap(141, 141, 141))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bill_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(option, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search_detail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bill_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6))
                                .addGap(73, 73, 73)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cgst1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sgst1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(final_price_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
             try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicalshop","root","");
                String qry="SELECT * FROM partytable";
                PreparedStatement ps=conn.prepareStatement(qry);
                ResultSet rs=ps.executeQuery();
                option.setText("Select customer detail");
                String[] columnNames ={"id","Name","Contact","Email","Address"};
                DefaultTableModel tableModel=new DefaultTableModel(columnNames,0);
                while(rs.next()){
                    int d= rs.getInt("id");
                    String n= rs.getString("name");
                    String c= rs.getString("contact");
                    String em= rs.getString("email");
                    String add= rs.getString("address");
                    String [] data ={String.valueOf(d),n,c,em,add};
                    tableModel.addRow(data);
                }
                customer_table.setModel(tableModel);
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(this, "Database Error");
                System.err.println("ERROR = >"+e.getMessage());
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cgst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cgst1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cgst1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
               try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicalshop","root","");
                String qry="SELECT * FROM addproduct";
                PreparedStatement ps=conn.prepareStatement(qry);
                ResultSet rs=ps.executeQuery();
                
                        option.setText("Select product detail");
                String[] columnNames ={"id","Product Name","product number","price","Quantity"};
                DefaultTableModel tableModel=new DefaultTableModel(columnNames,0);
                while(rs.next()){
                    int id= rs.getInt("id");
                    String n= rs.getString("product_name");
                    String c= rs.getString("product_number");
                    String em= rs.getString("sale_price");
                    String add= rs.getString("quantity");
                    String [] data ={String.valueOf(id),n,c,em,add};
                    tableModel.addRow(data);
                }
                customer_table.setModel(tableModel);
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(this, "Database Error");
                System.err.println("ERROR = >"+e.getMessage());
            }       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void search_detailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search_detailFocusGained
        search_detail.setText("");
    }//GEN-LAST:event_search_detailFocusGained

    private void search_detailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search_detailFocusLost
        String k = search_detail.getText();
        if(k.equals("")){
            search_detail.setText("Search Product/search Customer");
        }
    }//GEN-LAST:event_search_detailFocusLost

    private void search_detailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_detailKeyReleased
        String data = search_detail.getText();
        if(!data.equals("")){
            getProduct(data); 
        }else if(!data.equals("")){
            getCustomer(data);
        }
        else{
            getProduct("all");
        }
    }//GEN-LAST:event_search_detailKeyReleased
    int sr=1;
    private void customer_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customer_tableMouseClicked
       int row = customer_table.getSelectedRow();
        int value = Integer.parseInt((String) customer_table.getValueAt(row,0));
        
        if(option.getText().equals("Select customer detail")){
            custdata = value; 
            
        String name = (String) customer_table.getValueAt(row,1);
        
        String contact = (String) customer_table.getValueAt(row,2);
        
        String email = (String) customer_table.getValueAt(row,3);
        
        String add = (String) customer_table.getValueAt(row,4);
            
        details.setText("Name: "+name+""
                + "\nContact: "+contact+""
                        + "\nEmial: "+email+""
                                + "Address: "+add+"");
            
            
        } else if(option.getText().equals("Select product detail")){
            product_id = value;
            String PROD = (String) customer_table.getValueAt(row,1);
        String Price = (String) customer_table.getValueAt(row,3);
        JOptionPane.showMessageDialog(this, value);
        String header[] = {"Sr.","Product Name","Qty.","Price"};
        productdefaultTableModel = new DefaultTableModel(header,0);
        String data[] = {String.valueOf(sr), PROD,"1",Price};
        productdefaultTableModel.addRow(data);
        product_bill.setModel(productdefaultTableModel);
        
        }
        sr++;
    }//GEN-LAST:event_customer_tableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                try {
             Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicalshop","root","");
                String qry="SELECT * FROM addproduct WHERE id='"+product_id+"'";
                PreparedStatement ps=conn.prepareStatement(qry);
                ResultSet rs=ps.executeQuery();
                
                if(rs.next()){
                   
        
                    int final_qty_price = Integer.parseInt(rs.getString("sale                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 _price"));
                    JOptionPane.showMessageDialog(this, final_qty_price);                                                                     
                     int changeQty = Integer.parseInt(qtychange.getText());      
                    final_qty_price =  final_qty_price * changeQty;                                                                                                            

                    JOptionPane.showMessageDialog(this, "Data"+final_qty_price);
                   productdefaultTableModel.setValueAt(changeQty,product_select_row, 2);
                   productdefaultTableModel.setValueAt(final_qty_price,product_select_row, 3);
                   jButton2.setVisible(false);
                   qtychange.setVisible(true);
                } 
        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(this, "DATABASE ERROR");
                    System.err.println("DATABASE ERROR = "+e.getMessage());
        }
       product_bill.getSelectionModel().clearSelection();                
    }//GEN-LAST:event_jButton2ActionPerformed

    private void product_billMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_billMouseClicked
         jButton2.setVisible(true);
        qtychange.setVisible(true);
         
        int rownumber = product_bill.getSelectedRow();
        int qt =  Integer.parseInt((String) product_bill.getValueAt(rownumber, 2));
        product_select_row = rownumber;
        qtychange.setText(""+qt);
    }//GEN-LAST:event_product_billMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        MessageFormat header = new  MessageFormat("the Shop bill is");
        
        try{
             details.print();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
          try{
             product_bill.print();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int price = Integer.parseInt(String.valueOf(product_bill.getValueAt(0, 3)));
        
        int sgst = Integer.parseInt(sgst1.getText());
        int cgst = Integer.parseInt(cgst1.getText());
        
        float final_price = (sgst+cgst/100)+price;
        
        final_price_box.setText(""+final_price);
        
        product_bill.getSelectionModel().clearSelection();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
          Date d = new Date();
        Random rand = new Random();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy");
        bill_date.setText(""+dateFormat.format(d));
        bill_number.setText(""+dateFormat2.format(d)+"-"+rand.nextInt(999*9));
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Total;
    private javax.swing.JTextField bill_date;
    private javax.swing.JTextField bill_number;
    private javax.swing.JTextField cgst1;
    private javax.swing.JTable customer_table;
    private javax.swing.JTextArea details;
    private javax.swing.JTextField final_price_box;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel option;
    private javax.swing.JTable product_bill;
    private javax.swing.JTextField qtychange;
    private javax.swing.JTextField search_detail;
    private javax.swing.JTextField sgst1;
    // End of variables declaration//GEN-END:variables
}
