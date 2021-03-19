import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyClass {
    static String inputText = "";
    static String resultText = "";
    static int count = 9;
    static String val1 = "";
    static String val2 = "";
    static String[] op = {"+", "-", "*", "/"};

    public static void main(String[] args){
        JFrame frame = new JFrame();
        int width, height;
        width = 100;
        height = 100;

        //labels
        //JPanel panel = new JPanel();
        JLabel input = new JLabel();
        JLabel result = new JLabel();

        //panel.setBackground(new Color(100, 100, 100));
        //panel.setBounds(0, 0, 420, 150);

        //frame.add(panel);

        input.setText(inputText);
        input.setForeground(Color.cyan);
        input.setBackground(new Color(100, 100, 100));
        input.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        input.setBounds(0, 0, 600, 75);
        frame.add(input);

        result.setText(resultText);
        result.setForeground(Color.cyan);
        result.setBackground(new Color(100, 100, 100));
        result.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        result.setBounds(0, 75, 600, 75);
        frame.add(result);

        //buttons
        JButton buttons[] = new JButton[18];
        int x, y;
        x = 200;
        y = 150;

        for (int i = 9; i >= 1; i--){
            buttons[count] = new JButton();
            buttons[count].setText(String.valueOf(i));
            buttons[count].setFocusPainted(false);
            buttons[count].setBounds(x, y, width, height);
            buttons[count].setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
            buttons[count].setForeground(Color.cyan);
            buttons[count].setBackground(new Color(0, 0, 100));
            if (i == 7 || i == 4){
                x = 200;
                y += 100;
            }else {
                x -= 100;
            }
            buttons[count].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int j = 1; j <= 9; j++){
                        if (e.getSource() == buttons[j]) {
                            inputText += String.valueOf(j);
                            input.setText(inputText);
                        }
                    }
                }
            });

            frame.add(buttons[count]);
            count -= 1;
        }

        x = 0;
        y = 450;
        count = 10;

        for (int i = 0; i < 3; i++){
            buttons[count] = new JButton();
            buttons[count].setFocusPainted(false);
            buttons[count].setBounds(x, y, width, height);
            buttons[count].setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
            buttons[count].setForeground(Color.cyan);
            buttons[count].setBackground(new Color(0, 0, 100));
            frame.add(buttons[count]);
            if (i == 0){
                buttons[count].setText(".");
                buttons[count].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        inputText += buttons[10].getText();
                        input.setText(inputText);
                    }
                });
                count = 0;
            }
            if (i == 1){
                buttons[count].setText("0");
                buttons[count].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        inputText += "0";
                        input.setText(inputText);
                    }
                });
                count = 11;
            }
            if (i == 2){
                buttons[count].setText("=");
                buttons[count].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String expression;
                        String solution = "";
                        expression = inputText;
                        Integer length = expression.length();
                        String c;

                        for (int i = 0; i < length; i++){
                            c = String.valueOf(expression.charAt(i));
                            if (c.equals("*")){
                                val1 = expression.substring(0, i);
                                val2 = expression.substring(i+1, length);
                                solution = String.valueOf(Double.parseDouble(val1) * Double.parseDouble(val2));
                            }else{
                                if (c.equals("/")) {
                                    val1 = expression.substring(0, i);
                                    val2 = expression.substring(i + 1, length);
                                    solution = String.valueOf(Double.parseDouble(val1) / Double.parseDouble(val2));
                                }else{
                                    if (c.equals("+")){
                                        val1 = expression.substring(0, i);
                                        val2 = expression.substring(i+1, length);
                                        solution = String.valueOf(Double.parseDouble(val1) + Double.parseDouble(val2));
                                    }else{
                                        if (c.equals("-")){
                                            val1 = expression.substring(0, i);
                                            val2 = expression.substring(i+1, length);
                                            solution = String.valueOf(Double.parseDouble(val1) - Double.parseDouble(val2));
                                        }
                                    }
                                }
                            }

                        }


                        resultText = solution;
                        result.setText(resultText);
                    }
                });
            }

            x += 100;
        }

        x = 300;
        y = 450;
        count = 15;

        for (int i = 0; i <= 3; i++){
            buttons[count] = new JButton();
            buttons[count].setFocusPainted(false);
            buttons[count].setBounds(x, y, width, height);
            buttons[count].setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
            buttons[count].setForeground(Color.cyan);
            buttons[count].setBackground(new Color(0, 0, 100));
            if (i == 0){
                buttons[count].setText("/");
            }
            if (i == 1){
                buttons[count].setText("*");
            }
            if (i == 2){
                buttons[count].setText("-");
            }
            if (i == 3){
                buttons[count].setText("+");
            }
            buttons[count].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int j = 12; j <= 15; j++){
                        if (e.getSource() == buttons[j]) {
                            inputText += buttons[j].getText();
                            input.setText(inputText);
                        }
                    }
                }
            });

            y -= 100;
            frame.add(buttons[count]);
            count -= 1;
        }

        for (int i = 16; i <= 17; i++){
            buttons[i] = new JButton();
            buttons[i].setFocusPainted(false);
            buttons[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
            buttons[i].setForeground(Color.cyan);
            buttons[i].setBackground(new Color(0, 0, 100));
            if (i == 16){
                buttons[i].setBounds(400, 150, 100, 100);
                buttons[i].setText("Clear");
                buttons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        inputText = "";
                        input.setText(inputText);
                    }
                });
            }
            if (i == 17){
                buttons[i].setBounds(400, 250, 100, 100);
                buttons[i].setText("Del");
                buttons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String temp = inputText;
                        inputText = "";

                        for (int j = 0; j < temp.length()-1; j++){
                            inputText += String.valueOf(temp.charAt(j));
                        }

                        input.setText(inputText);
                    }
                });
            }
            frame.add(buttons[i]);
        }

        frame.setSize(515, 590);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("Calculator");
        frame.setVisible(true);
    }
}
