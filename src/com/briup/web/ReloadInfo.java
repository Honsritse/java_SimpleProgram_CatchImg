package com.briup.web;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

public class ReloadInfo extends PrintStream {

	private JTextComponent text;
	private StringBuffer sbuf = new StringBuffer();

	public ReloadInfo(OutputStream os, JTextComponent jtf) throws FileNotFoundException {
		super(os);
		this.text = jtf;
	}

	@Override
	public void write(byte[] buf, int off, int len) {
		final String message = new String(buf, off, len);
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				sbuf.append(message + "\n");
				text.setText(sbuf.toString());
			}
		});
	}
}
