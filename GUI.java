import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;

class GUI {
    // these variables are declared here so that the thread can be interrupted
    // and the titles for the auto buttons can be changed
    static JButton auto1;
    static JButton auto2;
    static Thread t;

    static JButton createButton(String title, int x, int y, int width, int height) {
        JButton button = new JButton(title);
        button.setBounds(x, y, width, height);
        button.setForeground(Color.decode("#dbdbdb"));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        return button;
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Zoom Opener");
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        panel.setLayout(null);
        panel.setBackground(Color.decode("#202020"));

        JLabel title = new JLabel("Automatic Zoom Opener");
        title.setBounds(136, 35, 224, 26);
        Font font = new Font("Arial", Font.BOLD, 18);
        title.setFont(font);
        title.setForeground(Color.decode("#dbdbdb"));
        panel.add(title);

        JButton first = createButton("First", 54, 96, 90, 26);
        JButton second = createButton("Second", 153, 96, 90, 26);
        JButton third = createButton("Third", 252, 96, 90, 26);
        JButton fourth = createButton("Fourth", 351, 96, 90, 26);
        JButton fifth = createButton("Fifth", 104, 130, 90, 26);
        JButton sixth = createButton("Sixth", 203, 130, 90, 26);
        JButton advis = createButton("Advisory", 302, 130, 90, 26);
        JButton auto1 = createButton("Auto Open 1", 193, 192, 110, 29);
        JButton auto2 = createButton("Auto Open 2", 193, 229, 110, 29);
        JButton cancel = createButton("Cancel", 208, 266, 80, 29);
        panel.add(first);
        panel.add(second);
        panel.add(third);
        panel.add(fourth);
        panel.add(fifth);
        panel.add(sixth);
        panel.add(advis);
        panel.add(auto1);
        panel.add(auto2);
        panel.add(cancel);

        first.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Opener act = new Opener();
                act.first();
            }
        });
        second.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Opener act = new Opener();
                act.second();
            }
        });
        third.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Opener act = new Opener();
                act.third();
            }
        });
        fourth.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Opener act = new Opener();
                act.fourth();
            }
        });
        fifth.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Opener act = new Opener();
                act.fifth();
            }
        });
        sixth.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Opener act = new Opener();
                act.sixth();
            }
        });
        advis.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Opener act = new Opener();
                act.advisory();
            }
        });
        auto1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                t = new Thread(new AutoOpener1());
                t.start();
            }
        });
        auto2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                t = new Thread(new AutoOpener2());
                t.start();
            }
        });
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                t.interrupt();
            }
        });
        frame.setVisible(true);
    }

    public void setAuto1(String title) {
        auto1.setText(title);
    }
    public void setAuto2(String title) {
        auto2.setText(title);
    }

}