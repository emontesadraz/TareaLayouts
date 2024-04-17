import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Operaciones extends JFrame {

    private JTextField pantalla;
    private String operacion;
    private int primerNumero;




    public Operaciones(){
        setLayout(new BorderLayout());

        pantalla = new JTextField();
        pantalla.setPreferredSize(new Dimension(500, 50)); // Aumenta el tamaño de la pantalla
        pantalla.setFont(new Font("Arial", Font.PLAIN, 24)); // Aumenta el tamaño de la fuente a 24
        add(pantalla, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 5));

        BotonesNumeros(panelBotones);

        Boton0("0", panelBotones);

        panelBotones.add(new JLabel(""));
        panelBotones.add(new JLabel(""));


        BotonSumar("+", panelBotones);

        BotonOperacion("-", panelBotones);

        BotonOperacion("*", panelBotones);

        BotonOperacion("/", panelBotones);

        add(panelBotones, BorderLayout.CENTER);

        JPanel panelOperacionesEspeciales = getjPanel();

        BotonCalcular(panelOperacionesEspeciales);

        add(panelOperacionesEspeciales, BorderLayout.EAST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    private void BotonCalcular(JPanel panelOperacionesEspeciales) {
        JButton botonCalcular = new JButton("Calcular");
        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int segundoNumero = Integer.parseInt(pantalla.getText());
                int resultado = 0;

                switch (operacion) {
                    case "+":
                        resultado = getSuma(segundoNumero);
                        break;
                    case "-":
                        resultado = getResta(segundoNumero);
                        break;
                    case "*":
                        resultado = getMultiplicacion(segundoNumero);
                        break;
                    case "/":
                        if (segundoNumero != 0) {
                            resultado = getDivision(segundoNumero);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se puede dividir por cero");
                        }
                        break;
                }

                pantalla.setText(String.valueOf(resultado));
            }
        });
        panelOperacionesEspeciales.add(botonCalcular);
    }

    private int getDivision(int segundoNumero) {
        int resultado;
        resultado = primerNumero / segundoNumero;
        return resultado;
    }

    private int getMultiplicacion(int segundoNumero) {
        int resultado;
        resultado = primerNumero * segundoNumero;
        return resultado;
    }

    private int getResta(int segundoNumero) {
        int resultado;
        resultado = primerNumero - segundoNumero;
        return resultado;
    }

    private int getSuma(int segundoNumero) {
        int resultado;
        resultado = primerNumero + segundoNumero;
        return resultado;
    }

    private JPanel getjPanel() {
        JPanel panelOperacionesEspeciales = new JPanel();
        panelOperacionesEspeciales.setLayout(new BoxLayout(panelOperacionesEspeciales, BoxLayout.Y_AXIS));
        JButton botonLimpiar = new JButton("Limpiar");
        botonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalla.setText("");
            }
        });
        panelOperacionesEspeciales.add(botonLimpiar);
        return panelOperacionesEspeciales;
    }

    private void BotonOperacion(String text, JPanel panelBotones) {
        JButton botonResta = new JButton(text);
        botonResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primerNumero = Integer.parseInt(pantalla.getText());
                operacion = text;
                pantalla.setText("");
            }
        });
        panelBotones.add(botonResta);
    }

    private void BotonSumar(String text, JPanel panelBotones) {
        BotonOperacion(text, panelBotones);
    }

    private void Boton0(String number, JPanel panelBotones) {
        JButton boton0 = new JButton(number);
        boton0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalla.setText(pantalla.getText() + boton0.getText());
            }
        });
        panelBotones.add(boton0);
    }

    private void BotonesNumeros(JPanel panelBotones) {
        for (int i = 1; i <= 9; i++) {
            Boton0(String.valueOf(i), panelBotones);
        }
    }

}