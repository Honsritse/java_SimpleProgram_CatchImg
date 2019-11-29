package com.briup.web;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @ClassName: CatchEnter
 * @Description: 程序入口，图形化程序
 * @author y2312
 * @date Nov 26, 2019
 *
 */

public class CatchEnter extends JFrame {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private static ReloadInfo info;

	public void setting() throws Exception {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 250);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		JPanel panel = new JPanel();

		this.painting(panel);
		this.add(panel);

	}

	public void painting(JPanel jPanel) throws Exception {
		jPanel.setLayout(null);

		JLabel label = new JLabel("选择保存路径");
		label.setBounds(50, 20, 100, 35);

		JButton but = new JButton("浏览");
		but.setBounds(155, 20, 60, 35);

		JTextField jtf = new JTextField(30);
		jtf.setBounds(50, 70, 300, 30);

		but.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int value = chooser.showOpenDialog(null);
				if (value == JFileChooser.APPROVE_OPTION) {
					jtf.setText(chooser.getSelectedFile().toString());
				} else {
					jtf.setText("未选择");

				}
			}
		});
		JTextField text = new JTextField("\tDEBUG：加载信息显示");
		text.setBounds(50, 100, 300, 100);
//		info = new ReloadInfo(System.out, text);

		JButton boot = new JButton("执行");
		boot.setBounds(220, 20, 60, 35);
		boot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String bath = jtf.getText();
				SkinImgCatch catcher = new SkinImgCatch();
				try {
					catcher.catchSkin(bath);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});


		jPanel.add(label);
		jPanel.add(but);
		jPanel.add(jtf);
		jPanel.add(boot);
		jPanel.add(text);
		
	}

	public static void main(String[] args) throws Exception {
		CatchEnter enter = new CatchEnter();
		enter.setting();
		enter.setVisible(true);
	}

}
