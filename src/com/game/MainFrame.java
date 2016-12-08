package com.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private static String[] buttonLabels = { "群主最帅", "管理员最帅", "楼上最帅", "楼下最帅", "我最帅", "" };
	private static String[] alertTitles = { "群主", "最帅的人", "傻逼", "你儿子", "就是你", "你麻痹" };
	private static String[] alertMsgs = { "群主去东莞嫖娼了", "别逗了，只有那个叫情天的最帅", "楼上是傻逼", "楼下是你儿子", "没错，你是最帅的",
			"你麻痹没看见没字，点个毛线" };

	public MainFrame() {
		init();
	}

	private void init() {
		this.setLocation(500, 200);
		this.setSize(480, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		createOptions();
		this.setVisible(true);
	}

	private void createOptions() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JLabel label = new JLabel("本群谁最帅？");
		label.setFont(new Font("Dialog", 1, 36));
		label.setForeground(new Color(106, 76, 156));
		label.setBounds(120, 0, 500, 100);
		panel.add(label);
		createButtons(panel);
		this.add(panel);
	}

	private void createButtons(JPanel panel) {
		for (int i = 0; i < 6; i++) {
			JButton button = new JButton(buttonLabels[i]);
			int x = 40 + (i % 3) * 140;
			int y = i < 3 ? 120 : 180;
			button.setBounds(x, y, 100, 30);
			panel.add(button);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Integer index = findIndexFromButtonLabels(e.getActionCommand());
					JOptionPane.showMessageDialog(null, alertMsgs[index], alertTitles[index],
							JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
	}

	private Integer findIndexFromButtonLabels(String text) {
		Integer index = null;
		for (int i = 0; i < buttonLabels.length; i++) {
			if (buttonLabels[i].equals(text)) {
				index = i;
			}
		}
		return index;
	}
}