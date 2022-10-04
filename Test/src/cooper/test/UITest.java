package cooper.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UITest {
    private JTable table1;
    private JTable table2;
    private JTable table3;
    private JButton 輸入員工班別Button;
    private JButton 產生Button;
    private JPanel jpanelAll;
    private JButton button3;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;

    public UITest() {

        comboBox1.addItem("正常班");
        comboBox1.addItem("做二休二");

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboBox1.getSelectedItem());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("UITest");
        frame.setContentPane(new UITest().jpanelAll);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
