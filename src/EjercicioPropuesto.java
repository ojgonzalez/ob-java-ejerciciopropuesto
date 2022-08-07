import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EjercicioPropuesto extends JFrame implements ActionListener{
    private JPanel jpnlPricipal;
    private JLabel jlblSaldoInicial;
    private JTextField jtxtSaldoInicial;
    private JLabel jlblPorcentaje;
    private JTextField jtxtPorcentaje;
    private JButton jbtnCalcular;
    private JButton jbtnLimpiar;
    private JTextArea jtxaResultados;
    private JTextArea jtxaDescripcion;
    private JScrollPane jscpResultados;
    private int intSaldo;
    private float flPorcentaje;

    public EjercicioPropuesto(){

        setContentPane(jpnlPricipal);
        setTitle("Calculo de Dividendos");
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        jtxtSaldoInicial.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char lCaracter = e.getKeyChar();
                if(((lCaracter < '0') || (lCaracter > '9')) && (lCaracter != KeyEvent.VK_BACK_SPACE)){
                    e.consume();
                }
            }
        });


        jtxtPorcentaje.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char lPorcentaje = e.getKeyChar();
                if(((lPorcentaje < '0') || (lPorcentaje > '9')) && (lPorcentaje != KeyEvent.VK_BACK_SPACE)){
                    e.consume();
                }
            }
        });

        jbtnCalcular.addActionListener(this);
        jbtnLimpiar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        float flTemporal = 0.0f;
        if(e.getSource() == jbtnCalcular){
            intSaldo = Integer.parseInt(jtxtSaldoInicial.getText());
            flPorcentaje = Float.parseFloat(jtxtPorcentaje.getText());
            jtxaResultados.append("Saldo inicial: " + intSaldo + ", Porcentaje inicial: " + flPorcentaje + "%\n");
            for(int dCounter = 1; dCounter <= 180; dCounter++){
                if(dCounter == 1){
                    flTemporal = intSaldo + (intSaldo * (flPorcentaje / 100));
                    System.out.println("Porcentaje: " + (flPorcentaje / 100));
                }else {
                    flTemporal = flTemporal + (flTemporal * (flPorcentaje / 100));
                    System.out.println("Porcentaje: " + (flPorcentaje / 100));
                }
                jtxaResultados.append("Dia: " + dCounter + "\tSaldo: " + flTemporal + "\n");
            }
        }
        if(e.getSource() == jbtnLimpiar){
            jtxaResultados.setText("");
            jtxtSaldoInicial.setText("0");;
            jtxtPorcentaje.setText("1");
        }
    }
}
