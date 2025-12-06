import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.BreakIterator;

public class Login extends JFrame implements ActionListener {

    JLabel quoteTitle,bigQuote,quoteDesc,logo,welcome,subText,subText1,password,signUp;
    JTextField emailField ,passField;
    JPanel rightPanel;
    JButton forgotPass,loginButton,googleBtn,sign;
    Login() {

        setTitle("Modern Login UI");
        setSize(1100, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        setLayout(null);



        setResizable(false);

        JPanel leftPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("images/login-bg.jpg"));
                g.drawImage(bg.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };

        leftPanel.setBounds(40, 30, 550, 650);
        leftPanel.setLayout(null);
//        leftPanel.setOpaque(false);
        leftPanel.setBorder(new LineBorder(Color.GRAY, 2, true));
        add(leftPanel);

        quoteTitle = new JLabel("A WISE QUOTE");
        quoteTitle.setForeground(Color.WHITE);
        quoteTitle.setBounds(20, 10, 300, 30);
        quoteTitle.setFont(new Font("SansSerif", Font.BOLD, 14));
        leftPanel.add(quoteTitle);

        bigQuote = new JLabel("<html><b>Get<br>Everything<br>You Want</b></html>");
        bigQuote.setForeground(Color.WHITE);
        bigQuote.setBounds(20, 400, 400, 200);
        bigQuote.setFont(new Font("Serif", Font.BOLD, 46));
        leftPanel.add(bigQuote);

        quoteDesc = new JLabel(
                "<html>You can get everything you want if you work hard,<br>trust the process, and stick to the plan.</html>");
        quoteDesc.setForeground(Color.WHITE);
        quoteDesc.setFont(new Font("SansSerif", Font.PLAIN, 14));
        quoteDesc.setBounds(20, 580, 400, 60);
        leftPanel.add(quoteDesc);

        rightPanel = new JPanel();
        rightPanel.setBounds(550, 30, 520, 650);
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.BLACK);
        add(rightPanel);

        logo = new JLabel("Hello!");
        logo.setBounds(250, 50, 200, 40);
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("SansSerif", Font.BOLD, 20));
        rightPanel.add(logo);

        welcome = new JLabel("Welcome Back");
        welcome.setBounds(180, 100, 400, 50);
        welcome.setForeground(Color.WHITE);
        welcome.setFont(new Font("Serif", Font.BOLD, 34));
        rightPanel.add(welcome);

        subText = new JLabel("Enter your email and password to access your account");
        subText.setBounds(130, 140, 400, 20);
        subText.setFont(new Font("SansSerif", Font.PLAIN, 12));
        subText.setForeground(Color.WHITE);
        rightPanel.add(subText);

        subText1 = new JLabel("Email");
        subText1.setBounds(100, 195, 400, 20);
        subText1.setFont(new Font("SansSerif", Font.PLAIN, 14));
        subText1.setForeground(Color.WHITE);
        rightPanel.add(subText1);

        emailField = new JTextField();
        emailField.setBounds(100, 220, 350, 40);
        emailField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        emailField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        emailField.setToolTipText("Enter your email");
        rightPanel.add(emailField);


        password = new JLabel("Password");
        password.setBounds(100, 275, 400, 20);
        password.setFont(new Font("SansSerif", Font.PLAIN, 14));
        password.setForeground(Color.WHITE);
        password.setToolTipText("Enter your password");
        rightPanel.add(password);

        passField = new JPasswordField();
        passField.setBounds(100, 300, 350, 40);
        passField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        passField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        rightPanel.add(passField);


        JCheckBox remember = new JCheckBox("Remember me");
        remember.setBounds(95, 350, 150, 20);
        remember.setBackground(Color.GRAY);
        remember.setForeground(Color.WHITE);
        rightPanel.add(remember);

        forgotPass = new JButton("Forgot Password?");
        forgotPass.setBounds(320, 345, 150, 30);
        forgotPass.setBorder(null);
        forgotPass.setFocusPainted(false);
        forgotPass.setContentAreaFilled(false);
        forgotPass.setForeground(Color.WHITE);
        rightPanel.add(forgotPass);

        loginButton = new JButton("Sign In");
        loginButton.setBounds(100, 380, 350, 45);
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(Color.BLACK);
        loginButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        loginButton.addActionListener(this);
        rightPanel.add(loginButton);

        ImageIcon googleIcon = new ImageIcon(ClassLoader.getSystemResource("images/google.png"));
        Image googleImg = googleIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

        googleBtn = new JButton("Sign In with Google", new ImageIcon(googleImg));
        googleBtn.setBounds(100, 440, 350, 45);
        googleBtn.setBackground(Color.WHITE);
        googleBtn.setForeground(Color.WHITE);
        googleBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        googleBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
        rightPanel.add(googleBtn);

        signUp = new JLabel("Don't have an account?");
        signUp.setBounds(150, 500, 300, 30);
        signUp.setFont(new Font("SansSerif", Font.PLAIN, 14));
        signUp.setForeground(Color.WHITE);
        rightPanel.add(signUp);

        sign = new JButton("Sign Up");
        sign.setBounds(320, 505, 60, 25);
        sign.setBackground(Color.WHITE);
        sign.setForeground(Color.WHITE);
        sign.setFont(new Font("SansSerif", Font.PLAIN, 10));
        sign.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        rightPanel.add(sign);

        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("images/login-bg.jpg"));
        Image bgImg = bgIcon.getImage().getScaledInstance(1200, 800, Image.SCALE_SMOOTH);
        JLabel bg = new JLabel(new ImageIcon(bgImg));
        bg.setBounds(0, 0, 1100, 740);
        add(bg);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ev){
        try{
            String username = emailField.getText();
            String password = passField.getText();

            JDBC conn = new JDBC();
            String query = "Select * from login where username = '"+ username + "' and password = '"+password+"'";

            ResultSet rs = conn.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Splash().setVisible(true);
            }else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
