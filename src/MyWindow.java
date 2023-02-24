import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyWindow extends JFrame {

    private JLabel heading;
    private JLabel clock;
    private Font font = new Font("", Font.BOLD, 30);

    public MyWindow(){
        this.setTitle("MyClock");
        this.getContentPane().setBackground( Color.GREEN );
        this.setBounds(50, 50, 600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.createGUI();
        this.startTimer();
        this.setVisible(true);
    }

    public void createGUI(){

        heading = new JLabel("My Digital Clock", SwingConstants.CENTER);
        heading.setFont(font);

        clock = new JLabel("", SwingConstants.CENTER);
        clock.setFont(font);

        this.setLayout(new GridLayout(2, 1));
        this.add(heading);
        this.add(clock);

    }

    public void startTimer(){

        Runnable r = () -> {

            try{

                while(true){

                    Date t = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("EE, dd MMM yyyy, hh:mm:ss");
                    String dateTime = sdf.format(t);

                    clock.setText(dateTime);
                    Thread.sleep(1000);

                }

            }catch (Exception e){
                e.printStackTrace();
            }

        };

        new Thread(r).start();

    }

}