import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Splash extends JFrame {

    private JLabel heading;
    private Timer typingTimer;
    private String fullText = "SMART INVENTORY MANAGEMENT SYSTEM";
    private String currentText = "";
    private int charIndex = 0;

    public Splash() {

        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
//        setUndecorated(true);

        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("images/Splash.jpg"));
        Image bgImg = bgIcon.getImage().getScaledInstance(1200, 800, Image.SCALE_SMOOTH);
        JLabel bg = new JLabel(new ImageIcon(bgImg));
        bg.setBounds(0, 0, 1200, 800);
        add(bg);


        heading = new JLabel("", SwingConstants.CENTER);
        heading.setBounds(0, 40, 1200, 40);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        heading.setForeground(Color.BLACK);
        bg.add(heading);

        typingTimer = new Timer(100, e -> {
            if (charIndex < fullText.length()) {
                currentText += fullText.charAt(charIndex);
                heading.setText(currentText);
                charIndex++;
            } else {
                typingTimer.stop();
            }
        });
        typingTimer.start();


        JLabel tagline = new JLabel("Reliable Solutions for Smart Business", SwingConstants.CENTER);
        tagline.setFont(new Font("SansSerif", Font.ITALIC, 18));
        tagline.setForeground(Color.WHITE);
        tagline.setBounds(0, 90, 1200, 30);
        bg.add(tagline);


        JProgressBar progress = new JProgressBar();
        progress.setBounds(300, 680, 600, 20);
        progress.setForeground(new Color(0, 153, 255));
        progress.setBackground(Color.DARK_GRAY);
        progress.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bg.add(progress);

        Timer t = new Timer(40, e -> {
            int val = progress.getValue();
            if (val < 100) {
                progress.setValue(val + 1);
            }
            if (val == 100) {
                ((Timer)e.getSource()).stop();
                dispose();
                new Login().setVisible(true);
            }
        });
        t.start();


        JLabel version = new JLabel("Version 1.0.0");
        version.setFont(new Font("Arial", Font.PLAIN, 14));
        version.setForeground(Color.GRAY);
        version.setBounds(20, 740, 200, 30);
        bg.add(version);


        JLabel copy = new JLabel("© 2025 InventorySoft Technologies", SwingConstants.CENTER);
        copy.setFont(new Font("Calibri", Font.PLAIN, 14));
        copy.setForeground(Color.BLACK);
        copy.setBounds(0, 740, 1200, 30);
        bg.add(copy);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Splash();
    }
}
