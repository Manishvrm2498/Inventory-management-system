import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Splash extends JFrame {
    private JLabel heading;

    public Splash() {
        setTitle("INVENTORY MANAGEMENT SYSTEM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        heading = new JLabel("INVENTORY MANAGEMENT SYSTEM", SwingConstants.CENTER);
        heading.setBounds(0, 0, 1200, 60);
        heading.setOpaque(true);
        heading.setBackground(new Color(0, 223, 255));
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("", Font.BOLD, 30));
        add(heading);


        Border border = BorderFactory.createLineBorder(Color.gray,2);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("images/Splash.jpg"));
        Image img2 = img1.getImage().getScaledInstance(1200, 800, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel img = new JLabel(img3);
        img.setBounds(0, 0, 1200, 800);
        img.setBorder(border);
        add(img);

        setSize(1200, 800);
        setLocation(150,70);
        getContentPane().setBackground(new Color(0,0,0));
        setResizable(false);
        setVisible(true);
    }
}