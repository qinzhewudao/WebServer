package com.beancore;

import com.beancore.ui.MainFrame;

public class game {
	public String planegame(String document)
	{
		MainFrame mainFrame;
		try {
		    mainFrame = new MainFrame();
		    mainFrame.loadGame();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return document;
	}
    public static void main(String args[]) throws InterruptedException {
	MainFrame mainFrame;
	try {
	    mainFrame = new MainFrame();
	    mainFrame.loadGame();
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }
}
