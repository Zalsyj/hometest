package org.hometest.view;

import org.hometest.contract.IView;

public class View implements IView {
	public void displayMessage(String message) {
		System.out.println(message);		
	}
}
