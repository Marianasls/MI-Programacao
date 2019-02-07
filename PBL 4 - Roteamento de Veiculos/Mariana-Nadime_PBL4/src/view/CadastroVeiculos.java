package view;

import controller.RVController;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Veiculos;

/**
 *
 * @author Notebook
 */
public class CadastroVeiculos extends javax.swing.JInternalFrame {
    private RVController controlador;
    /** Creates new form CadastroVeiculos */
    public CadastroVeiculos(RVController controlador) {
        initComponents();
        this.controlador = controlador;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        nomeCarro = new javax.swing.JTextField();
        tipoCombustivel = new javax.swing.JTextField();
        precoCombustivel = new javax.swing.JTextField();
        buttonCadastro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        consumo = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setAlignmentX(250.0F);
        setAlignmentY(50.0F);

        nomeCarro.setDropMode(javax.swing.DropMode.INSERT);
        nomeCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeCarroActionPerformed(evt);
            }
        });

        precoCombustivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precoCombustivelActionPerformed(evt);
            }
        });

        buttonCadastro.setText("Cadastrar");
        buttonCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastroActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome do carro:");

        jLabel2.setText("Tipo de Combustível");

        jLabel3.setText("Preço do Combustível");

        jLabel4.setText("Consumo de combustivel (km/L)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeCarro)
                    .addComponent(jLabel4)
                    .addComponent(tipoCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consumo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precoCombustivel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCadastro)
                        .addGap(103, 103, 103))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipoCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(precoCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCadastro)
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeCarroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeCarroActionPerformed

    private void buttonCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastroActionPerformed
        Veiculos veiculo;
        try{
            double preco = Double.valueOf(precoCombustivel.getText());
            double consumoC = Double.valueOf(consumo.getText());
            veiculo = new Veiculos(nomeCarro.getText(), tipoCombustivel.getText(), preco, consumoC);
            controlador.addVeiculos(veiculo);
        //apenas para teste
            System.out.println("Veiculo salvo: " + veiculo.getNome()+"-"+ 
                veiculo.getTipoCombustivel()+"-"+veiculo.getConsumo()+"-"+veiculo.getPrecoCombustivel());
            
            precoCombustivel.setText("");
            consumo.setText("");
            nomeCarro.setText("");
            tipoCombustivel.setText("");
            this.setClosed(true);
            
        }catch(NumberFormatException e){
            precoCombustivel.setText("");
            consumo.setText("");
        }catch (PropertyVetoException ex) {
            Logger.getLogger(CadastroVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_buttonCadastroActionPerformed

    private void precoCombustivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precoCombustivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precoCombustivelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCadastro;
    private javax.swing.JTextField consumo;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField nomeCarro;
    private javax.swing.JTextField precoCombustivel;
    private javax.swing.JTextField tipoCombustivel;
    // End of variables declaration//GEN-END:variables

}
