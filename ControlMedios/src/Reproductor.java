import javax.management.StringValueExp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reproductor extends JFrame {
    JProgressBar barraDeProgreso;
    private Timer timer;
    private int progresoActual;

    public Reproductor(){
        JPanel controlesReproductor = new JPanel();
        controlesReproductor.setLayout(new BoxLayout(controlesReproductor, BoxLayout.X_AXIS));


        JButton play = new JButton("Play");
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });
        controlesReproductor.add(play);
        JButton stop = new JButton("Stop");
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                progresoActual = 0;
            }
        });
        controlesReproductor.add(stop);
        JButton pause = new JButton("Pause");
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });
        controlesReproductor.add(pause);
        add(controlesReproductor, BorderLayout.SOUTH);


        JPanel tecladoNumerico = new JPanel();
        tecladoNumerico.setLayout(new GridLayout(3,3));
        for (int i = 1; i <= 9; i++){
            tecladoNumerico.add(new JButton(String.valueOf(i)));
        }
        add(tecladoNumerico,BorderLayout.CENTER);

        barraDeProgreso = new JProgressBar();
        barraDeProgreso.setMaximum(100);

        add(barraDeProgreso,BorderLayout.NORTH);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progresoActual += 5;
                if (progresoActual > 100) {
                    progresoActual = 100;
                    timer.stop();
                }
                barraDeProgreso.setValue(progresoActual);
            }
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 150);
        setVisible(true);
    }

}
