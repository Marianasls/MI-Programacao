package view;

import controller.RVController;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import model.Veiculos;

/**
 *
 * @author Mariana Lima
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private RVController controlador;
    private JPanel panel = new JPanel();
    private JButton btnVeiculo = new JButton("Definir Veiculo");
    private JButton btnRota = new JButton("Definir Rota");
    private JButton btnCadastro = new JButton("Cadastrar Veiculos");
    private CardLayout card = new CardLayout();
    private JPanel panel_inicio = new JPanel();
    private DefinirVeiculo panel_1;
    private JPanel panel_2;
    private JInternalFrame frame1;

    /**
     * Creates new form TelaPrincipal
     * @param controlador
     */
    public TelaPrincipal(RVController controlador) {
        initComponents();
        this.controlador = controlador;
        panel_2 = new Mapa(controlador.getCidades());
        frame1 = new CadastroVeiculos(controlador);
        panel_1 = new DefinirVeiculo(controlador.getVeiculos(), controlador.getRota());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        btnVeiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painelVeiculos();
            }
        });

        btnRota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painelRota();
            }
        });

        btnCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCadastro();
            }
        });

        getContentPane().setLayout(new BorderLayout());
        panel.setLayout(new FlowLayout());
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.add(btnVeiculo);
        panel.add(btnRota);
        panel.add(btnCadastro);

        panel_1.add(new JLabel("Definir Veiculos"));
        panel_2.add(new JLabel("Definir Rota"));

        panel_inicio.setLayout(card);
        panel_inicio.add(panel_1, "Definir Veiculos");
        panel_inicio.add(panel_2, "Definir Rota");
        panel_inicio.add(frame1, "Cadastrar Veiculos");
        panel_1.setBackground(Color.blue);
        panel_2.setBackground(Color.yellow);
        getContentPane().add(panel_inicio);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void painelVeiculos() {
        card.first(panel_inicio);
        panel_1.setVisible(true);
        panel_1.mostraVeiculos();
        this.setSize(400, 400);

    }

    public void painelRota() {
        card.next(panel_inicio);
        panel_2.setVisible(true);
        this.setSize(720, 1065);
            
    }

    public void frameCadastro() {        
        card.last(panel_inicio);
        frame1.setVisible(true);
        this.setSize(400, 400);
        
    
    }
//    private void cadastrarVeiculosActionPerformed(java.awt.event.ActionEvent evt) {                                                  
//        // TODO add your handling code here:
//        CadastroVeiculos obj = new CadastroVeiculos(controlador);
//        jDesktopPane1.add(obj);
//        obj.setVisible(true);
//    }
//
//    private void definirRoteiroActionPerformed(java.awt.event.ActionEvent evt) {                                               
//        // TODO add your handling code here:
//        Mapa obj = new Mapa(controlador.getCidades());
//        jDesktopPane1.add(obj);
//        jDesktopPane1.setVisible(true);
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
