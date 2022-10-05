package cooper.test;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class UITest {
    private JTable table1;
    private JTable table2;
    private JButton 做二休二行事曆Button;
    private JButton 產生Button;
    private JPanel jpanelAll;
    private JButton button3;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton c1BeforeBut;
    private JButton c1NextBtn;
    private JLabel c1YMLab;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public UITest() {

        comboBox1.addItem("正常班");
        comboBox1.addItem("做二休二");

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ymString = c1YMLab.getText();
                if("-".equals(ymString)){
                    ymString = "2022/10";
                    c1YMLab.setText(ymString);
                }
                LocalDate localDate;

                if(ymString==null || "".equals(ymString) || "-".equals(ymString)){
                    localDate = LocalDate.now();
                }else{
                    //todo 字串測試
                    localDate = LocalDate.parse(ymString+"/01",formatter);
                }
                insertTable1(getMonthCalendar(localDate));
            }
        });
        c1BeforeBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ymString = c1YMLab.getText();
                if(!"-".equals(ymString)) {
                    int yyyy = Integer.parseInt(ymString.split("/")[0]);
                    int mm = Integer.parseInt(ymString.split("/")[1]);
                    mm--;
                    if (mm == 0) {
                        mm = 12;
                        yyyy--;
                    }
                    String title;
                    if (mm < 10) {
                        title = yyyy + "/0" + mm;
                    }else{
                        title = yyyy + "/" + mm;
                    }
                    c1YMLab.setText(title);
                    LocalDate localDate = LocalDate.parse(title+"/01", formatter);
                    insertTable1(getMonthCalendar(localDate));
                }
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

    public String[][] getMonthCalendar(LocalDate date){
        date = date.withDayOfMonth(1);
        String[][] result;
        if(date.lengthOfMonth()>28){
            result = new String[7][7];
        }else{
            result = new String[6][7];
        }
        result[0] = new String[]{"一","二","三","四","五","六","日"};

        int nowMonth = date.getMonth().getValue();
        int rowCount=1;
        while (date.getMonth().getValue() == nowMonth){
            int dayOfWeek = date.getDayOfWeek().getValue();
            result[rowCount][dayOfWeek-1] = String.valueOf(date.getDayOfMonth());
            if(date.getDayOfWeek().getValue() == 7){
                rowCount++;
            }
            date = date.plus(1, ChronoUnit.DAYS);
        }
        return result;
    }

    public void insertTable1(String[][] calendar){
        AbstractTableModel abstractTableModel = new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return calendar.length;
            }

            @Override
            public int getColumnCount() {
                return 7;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return calendar[rowIndex][columnIndex];
            }
        };

        table1.setModel(abstractTableModel);
        table1.updateUI();
    }
}
