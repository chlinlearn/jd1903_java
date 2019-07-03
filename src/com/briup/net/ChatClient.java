package com.briup.net;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class ChatClient extends JFrame {
    private Socket socket;
    private static final long serialVersionUID = 1L;
    private JTextArea sendArea;
    private JTextArea contentArea;
    private Container contentPane;
    private String name;

    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        new ChatClient("李四", socket).go();

    }

    public ChatClient(String name, Socket socket) {
        this.name = name;
        this.socket = socket;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initGUI();

        //启动一个子线程接收服务器端传来的数据
        new ClientThread(socket, contentArea).start();
    }

    public void initGUI() {
        Font font = new Font("楷体", Font.BOLD, 18);
        ImageIcon icon = new ImageIcon("src/com/briup/net/icons/client.png");
        setIconImage(icon.getImage());
        this.setSize(500, 600);
        this.setTitle("聊天室");
        contentPane = getContentPane();
        int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setLocation((x - this.getWidth()) / 2, (y - this.getHeight()) / 2);
        this.setResizable(false);

        contentArea = new JTextArea();
        contentArea.setEditable(false);
        contentArea.setFont(font);
        JScrollPane logPanel = new JScrollPane(contentArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sendArea = new JTextArea();
        sendArea.setFont(font);
        sendArea.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    send();
                }
            }
        });
        JScrollPane sendPanel = new JScrollPane(sendArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //分割窗口
        JSplitPane splitPane = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT, logPanel, sendPanel);
        splitPane.setDividerLocation(400);
        contentPane.add(splitPane, BorderLayout.CENTER);


        JPanel jp = new JPanel();
        jp.setLayout(new FlowLayout(FlowLayout.RIGHT));
        contentPane.add(jp, BorderLayout.SOUTH);

        JLabel nameLbl = new JLabel("用户名：" + this.name + " ");
        jp.add(nameLbl);

        JButton resetBtn = new JButton("close");
        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.exit(0);
            }
        });
        jp.add(resetBtn);

        JButton sendBtn = new JButton("send");
        jp.add(sendBtn);
        sendBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                send();
            }
        });
    }

    public void go() {
        this.setVisible(true);
    }

    public void send() {
        String msg = sendArea.getText();
        SimpleDateFormat formater = new SimpleDateFormat("HH:mm:ss");
        String date = formater.format(new Date());
        String sendStr = name + " " + date + ": " + msg;
        try {
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println(sendStr);
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //contentArea.append(sendStr+"\n");
        sendArea.setText("");
    }
}

//接收服务器端的数据，并显示在界面上；
class ClientThread extends Thread {
    private Socket socket;
    private JTextArea contentArea;

    public ClientThread(Socket socket, JTextArea contentArea) {
        this.socket = socket;
        this.contentArea = contentArea;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            String str = null;
            while ((str = br.readLine()) != null && !socket.isClosed()) {
                //显示在界面上
                contentArea.append(str + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}