package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoTreadsSample extends JFrame implements ActionListener, Runnable {

    // Конструктор
    NoTreadsSample(){

        // Создание окна с кнопкой и текстовым полем
        GridLayout gl = new GridLayout(2,1);
        this.getContentPane().setLayout(gl);

        JButton myButton = new JButton("Kill time");
        myButton.addActionListener(this);

        this.getContentPane().add(myButton);
        this.getContentPane().add(new JTextField());

    }

    // Обработчик нажатия кнопки
    @Override
    public void actionPerformed(ActionEvent e) {
        // Создать поток и выполнить “замораживающий” код
        // без блокировки
        Thread worker = new Thread(this);
        worker.start(); // вызывает метод run()

    }

    @Override
    public void run() {
        // Заморозить на некоторое время, чтобы показать, что
        // элементы окна НЕ блокируются
        for (int i = 0; i < 300001; i++) {
            this.setTitle("i = " + i);
        }
    }

    public static void main(String[] args) {
        // Создать окно
        NoTreadsSample myWindow = new NoTreadsSample();

        // Закрыть окно при нажатии на крестик
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Установить размеры окна – координаты левого верхнего
        //угла и высоту с шириной
        myWindow.setBounds(0,0,300,100);

        // Отображать окно по центру экрана
        myWindow.setLocationRelativeTo(null);

        // Запретить изменять размеры окна
        myWindow.setResizable(false);

        // Делаем окно видимым
        myWindow.setVisible(true);
    }
}
