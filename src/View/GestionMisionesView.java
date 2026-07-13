/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Dron;
import Repository.Data;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class GestionMisionesView extends javax.swing.JFrame {

    private Timer timerMision;

    public GestionMisionesView() {
    initComponents();
    
    // 1. Carga de datos y componentes iniciales
    cargarSedes(); // Asegura que las zonas aparezcan en el combo box
    actualizarTabla();
    
    // 2. Aplicamos placeholders
    configurarPlaceholder(txtCodigoMision, "Ej: MIS-001");
    configurarPlaceholder(txtZona, "INGRESE UBICACION");
    
    // 3. Aplicamos colores dinámicos a la tabla
    configurarColoresTabla();

    // 4. Listener para autocompletar el código al seleccionar una fila en la tabla
    tblDrones.getSelectionModel().addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()) {
            int fila = tblDrones.getSelectedRow();
            if (fila != -1) {
                // Obtiene el valor de la columna 0 y lo pone en el campo de texto
                txtCodigoMision.setText(tblDrones.getValueAt(fila, 0).toString());
                txtCodigoMision.setForeground(Color.BLACK);
            }
        }
    });
}

    private void cargarSedes() {
    cmbSedesMision.removeAllItems();
    cmbSedesMision.addItem("Zona Norte");
    cmbSedesMision.addItem("Zona Sur");
    cmbSedesMision.addItem("Zona Este");
    cmbSedesMision.addItem("Zona Oeste");
    cmbSedesMision.addItem("Zona Centro");
}

    private void configurarPlaceholder(javax.swing.JTextField textField, String textoAyuda) {
        textField.setText(textoAyuda);
        textField.setForeground(Color.GRAY);
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                if (textField.getText().equals(textoAyuda)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent evt) {
                if (textField.getText().isEmpty()) {
                    textField.setText(textoAyuda);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }

    private void actualizarTabla() {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tblDrones.getModel();
        modelo.setRowCount(0);
        for (Dron d : Data.drones) {
            String info = d.getEstado() + " - " + d.getNivelBateria() + "%";
            modelo.addRow(new Object[]{d.getCodigo(), d.getModelo(), info});
        }
    }

    private void configurarColoresTabla() {
        tblDrones.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
                try {
                    double bateria = Double.parseDouble(value.toString().replaceAll("[^0-9.]", ""));
                    if (bateria > 60) c.setForeground(Color.GREEN);
                    else if (bateria > 20) c.setForeground(Color.ORANGE);
                    else c.setForeground(Color.RED);
                } catch (Exception e) { c.setForeground(Color.BLACK); }
                return c;
            }
        });
    }

    private void gestionarCicloDron(Dron dron, int consumo) {
    if (timerMision != null && timerMision.isRunning()) timerMision.stop();
    
    timerMision = new Timer(1000, e -> {
        if (dron.getEstado().equalsIgnoreCase("En Misión")) {
            // AHORA EL CONSUMO DEPENDE DE LA PRIORIDAD PASADA
            dron.setNivelBateria(dron.getNivelBateria() - consumo);
            
            if (dron.getNivelBateria() <= 0) {
                dron.setNivelBateria(0);
                dron.setEstado("Cargando");
                javax.swing.JOptionPane.showMessageDialog(this, "Dron " + dron.getCodigo() + " sin batería. Iniciando carga.");
            }
        } else if (dron.getEstado().equalsIgnoreCase("Cargando")) {
            dron.setNivelBateria(dron.getNivelBateria() + 20.0);
            if (dron.getNivelBateria() >= 100.0) {
                dron.setNivelBateria(100.0);
                dron.setEstado("Disponible");
                ((Timer)e.getSource()).stop();
            }
        }
        actualizarTabla();
    });
    timerMision.start();
}
    // Llama a gestionarCicloDron(dronSeleccionado) dentro de tu botón Iniciar Misión
    // Y asegúrate de pasar el estado a "En Misión" antes de llamar al método.
    
  // ... (Mantén tus métodos cargarSedes y configurarPlaceholder aquí) ...


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDrones = new javax.swing.JTable();
        txtCodigoMision = new javax.swing.JTextField();
        cmbTipoMision = new javax.swing.JComboBox<>();
        btnIniciarMision = new javax.swing.JButton();
        btnFinalizarMision = new javax.swing.JButton();
        cmbSedesMision = new javax.swing.JComboBox<>();
        txtZona = new javax.swing.JTextField();
        cmbPrioridad = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblDrones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Modelo", "Batería"
            }
        ));
        jScrollPane1.setViewportView(tblDrones);

        txtCodigoMision.addActionListener(this::txtCodigoMisionActionPerformed);

        cmbTipoMision.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vigilancia", "Entrega", "Transmision", "Monitoreo" }));
        cmbTipoMision.addActionListener(this::cmbTipoMisionActionPerformed);

        btnIniciarMision.setText("Iniciar Misión");
        btnIniciarMision.addActionListener(this::btnIniciarMisionActionPerformed);

        btnFinalizarMision.setText("Finalizar Misión");
        btnFinalizarMision.addActionListener(this::btnFinalizarMisionActionPerformed);

        cmbSedesMision.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbPrioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 - Baja", "2", "3", "4", "5 - Alta" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(btnIniciarMision, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(btnFinalizarMision)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbTipoMision, 0, 144, Short.MAX_VALUE)
                    .addComponent(txtCodigoMision)
                    .addComponent(cmbSedesMision, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtZona)
                    .addComponent(cmbPrioridad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(txtCodigoMision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbTipoMision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbSedesMision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizarMision, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciarMision, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoMisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoMisionActionPerformed

    }//GEN-LAST:event_cmbTipoMisionActionPerformed

    private void btnIniciarMisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarMisionActionPerformed

                                                                          
                                
    int fila = tblDrones.getSelectedRow();
    
    // 1. Validación de selección
    if (fila == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecciona un dron de la tabla.");
        return;
    }

    // 2. Obtener datos
    String codDron = tblDrones.getValueAt(fila, 0).toString();
    
    // 3. Buscar dron y validar estado
    Dron dronSeleccionado = null;
    for (Dron d : Data.drones) {
        if (d.getCodigo().equalsIgnoreCase(codDron)) {
            dronSeleccionado = d;
            break;
        }
    }

    if (dronSeleccionado != null) {
        if (dronSeleccionado.getEstado().equalsIgnoreCase("En Misión")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Este dron ya está ocupado en otra misión.");
            return;
        }
        
        if (dronSeleccionado.getNivelBateria() <= 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "El dron no tiene batería. Ponlo a cargar primero.");
            return;
        }
        
        // --- AQUÍ ESTÁ LA CORRECCIÓN DE PRIORIDAD ---
        // Obtenemos el número de prioridad seleccionado (ejemplo: "1 - Baja" -> extrae "1")
        String seleccionPrioridad = cmbPrioridad.getSelectedItem().toString();
        int consumo = Integer.parseInt(seleccionPrioridad.substring(0, 1)); 
        
        // 4. Cambiar estado a misión
        dronSeleccionado.setEstado("En Misión");
        
        // 5. ACTIVAR EL CICLO PASANDO EL CONSUMO VARIABLE
        gestionarCicloDron(dronSeleccionado, consumo);
        
        // 6. Refrescar tabla
        actualizarTabla(); 
        
        javax.swing.JOptionPane.showMessageDialog(this, "Misión iniciada con prioridad: " + consumo);
    }

    }//GEN-LAST:event_btnIniciarMisionActionPerformed

    private void btnFinalizarMisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarMisionActionPerformed

    int fila = tblDrones.getSelectedRow();
    if (fila == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Selecciona el dron que ha finalizado su misión.");
        return;
    }

    String codDron = tblDrones.getValueAt(fila, 0).toString();
    for (Dron d : Data.drones) {
        if (d.getCodigo().equalsIgnoreCase(codDron)) {
            // CORRECCIÓN: Si estaba en misión, lo enviamos a cargar, no a disponible directo
            if (d.getEstado().equalsIgnoreCase("En Misión")) {
                d.setEstado("Cargando");
                javax.swing.JOptionPane.showMessageDialog(this, "Misión finalizada. El dron está regresando a la base para cargar.");
            } else {
                d.setEstado("Disponible");
            }
            break;
        }
    }
    actualizarTabla();

    }//GEN-LAST:event_btnFinalizarMisionActionPerformed

    private void txtCodigoMisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoMisionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoMisionActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace(); 
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new GestionMisionesView().setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizarMision;
    private javax.swing.JButton btnIniciarMision;
    private javax.swing.JComboBox<String> cmbPrioridad;
    private javax.swing.JComboBox<String> cmbSedesMision;
    private javax.swing.JComboBox<String> cmbTipoMision;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDrones;
    private javax.swing.JTextField txtCodigoMision;
    private javax.swing.JTextField txtZona;
    // End of variables declaration//GEN-END:variables
}
