package ru.geekbrains.lesson_d;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ClientGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JTextArea log = new JTextArea();

    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top");
    private final JTextField tfLogin = new JTextField("ivan");
    private final JPasswordField tfPassword = new JPasswordField("123");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JButton btnDisconnect = new JButton("<html><b>Disconnect</b></html>");
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    private final JList<String> userList = new JList<>();




    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { // Event Dispatching Thread

                new ClientGUI();
            }
        });
    }

    private ClientGUI() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        log.setEditable(false);
        JScrollPane scrollUser = new JScrollPane(userList);
        JScrollPane scrollLog = new JScrollPane(log);
        String[] users = {"user1", "user2", "user3", "user4", "user5",
                "user_with_an_exceptionally_long_name_in_this_chat"};
        userList.setListData(users);
        scrollUser.setPreferredSize(new Dimension(100, 0));
        cbAlwaysOnTop.addActionListener(this);

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(cbAlwaysOnTop);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        panelBottom.add(btnDisconnect, BorderLayout.WEST);
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);

        add(scrollLog, BorderLayout.CENTER);
        add(scrollUser, BorderLayout.EAST);
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);

        File file = new File("F:/Java/Java Core/src/ru/geekbrains/lesson_d/Log.txt");

        tfMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = tfMessage.getText();
                log.append(s + "\n");
                System.out.println("Your message: " + s);

                try {
                    FileWriter logFile;
                    logFile = new FileWriter(file,true);
                    BufferedWriter bf = new BufferedWriter(logFile);
                    bf.append(s);
                    bf.newLine();
                    bf.flush();
                    bf.close();


                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                tfMessage.setText("");
            }
        });

        btnSend.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                String s = tfMessage.getText();
                log.append(s + "\n");
                System.out.println("Your message: " + s);

                try {
                    FileWriter logFile;
                    logFile = new FileWriter(file,true);
                    BufferedWriter bf = new BufferedWriter(logFile);
                    bf.append(s);
                    bf.newLine();
                    bf.flush();
                    bf.close();

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                tfMessage.setText("");
            }
        });

        setVisible(true);

    }

  /*  public static void writeLogFile(String logText) throws IOException {
        try {
            //File file = new File("F:/Java/Java Core/src/ru/geekbrains/lesson_d/Log.txt");
 //           if (
           // FileWriter logFile = new FileWriter("Log.txt");

            FileWriter file = new FileWriter("F:/Java/Java Core/src/ru/geekbrains/lesson_d/Logfile.txt");
            BufferedWriter logFile = new BufferedWriter(file);
            logFile.append(logText);
            logFile.flush();
            logFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == cbAlwaysOnTop) {
            setAlwaysOnTop(cbAlwaysOnTop.isSelected());
        } else {
            throw new RuntimeException("Unknown source: " + src);
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        String msg;
        StackTraceElement[] ste = e.getStackTrace();
        msg = "Exception in " + t.getName() + " " +
                e.getClass().getCanonicalName() + ": " +
                e.getMessage() + "\n\t at " + ste[0];
        JOptionPane.showMessageDialog(this, msg, "Exception", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }

}