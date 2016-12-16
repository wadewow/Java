package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by wade on 2016/12/15.
 */
public class Mycalculator {

    public static void main(String[] args){

        new CalculatorFrame();
    }
}

class CalculatorFrame extends JFrame{

    CalulatorPanel calulatorPanel = new CalulatorPanel();
    public CalculatorFrame(){

        this.add(calulatorPanel);
        this.pack();
        this.setVisible(true);

        //添加窗口监听器
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }


}

/**
 * 设置自己的面板
 */
class CalulatorPanel extends JPanel{

    JLabel display = null;
    JPanel jbutton_panel = null;//用于放置按钮
    boolean flag = true;
    String command = "=";
    double result;
    boolean point = false;
    public CalulatorPanel(){

        this.setLayout(new BorderLayout());
        display = new JLabel();
        display.setText("0");
        jbutton_panel = new JPanel();
        //总体布局

        jbutton_panel.setLayout(new GridLayout(4,4));

        this.add(BorderLayout.NORTH,display);
        this.add(BorderLayout.CENTER,jbutton_panel);



        //创建监听器对象
        Number_ActionListener NA = new Number_ActionListener();
        Operation_ActionListener OA = new Operation_ActionListener();

        addButton("7",NA);
        addButton("8",NA);
        addButton("9",NA);
        addButton("+",OA);
        addButton("4",NA);
        addButton("5",NA);
        addButton("6",NA);
        addButton("-",OA);
        addButton("1",NA);
        addButton("2",NA);
        addButton("3",NA);
        addButton("*",OA);
        addButton("0",NA);
        addButton(".",NA);
        addButton("/",OA);
        addButton("=",OA);
    }
    //添加按钮方法
    public void addButton(String number, ActionListener actionListener){

        JButton jButton = new JButton(number);
        jButton.addActionListener(actionListener);
        jbutton_panel.add(jButton);
    }

/**
 * 设置两个监听器
 */
 class Number_ActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();
        if (flag){
            display.setText("");
            flag = false;
        }
        display.setText(display.getText()+input);
    }
}

class Operation_ActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {

        String input = e.getActionCommand();
        if (flag){
            command = input;
        }else {
            if (command.equals("+")){
                result += Double.parseDouble(display.getText());
            }else if (command.equals("-")){
                result -= Double.parseDouble(display.getText());
            }else if (command.equals("*")){
                result *= Double.parseDouble(display.getText());
            }else if (command.equals("/")){
                result /= Double.parseDouble(display.getText());
            }else if (command.equals("=")){
                result = Double.parseDouble(display.getText());
            }
            display.setText(""+result);
            command = input;
            flag = true;
        }

    }
}

}