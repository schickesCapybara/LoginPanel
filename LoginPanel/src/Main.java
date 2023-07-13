import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Main extends JFrame implements ActionListener {
    static JButton button = new JButton("Submit");
    static JTextField textField1 = new JTextField(20);
    static JTextField textField2 = new JTextField(20);
    static JPanel panel = new JPanel(new GridLayout(2, 2));
    static JLabel label1 = label1 = new JLabel("Mail: ");
    static JLabel label2 = new JLabel("Password: ");
    static HashMap<String, String> passwordHashMap = new HashMap<>();
    static JFrame frame = new JFrame();

    public static void main(String[] args) {

        passwordHashMap.put("leon.schickedanz@gmail.com", "1234"); //not my real password lmao
        
        loginPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            if (passwordHashMap.containsKey(textField1.getText())) {
                if (passwordHashMap.get(textField1.getText()).equals(textField2.getText())) {
                    System.out.println("You logged in successfully.");
                    frame.dispose();
                } else {
                    System.out.println("Not the correct Password.");
                    frame.dispose();
                    loginPanel();

                }
            } else {
                System.out.println("This Mail does not exist.");
                frame.dispose();
                loginPanel();
            }
            frame.dispose();
        }
    }

    public static void loginPanel() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(300, 150);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        textField1.setPreferredSize(new Dimension(200, 30));

        textField2 = new JTextField(20);
        textField2.setPreferredSize(new Dimension(200, 30));

        button.setSize(40, 40);
        button.addActionListener(new Main());

        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();

    }
}

