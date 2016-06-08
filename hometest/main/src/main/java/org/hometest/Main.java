package org.hometest;

import org.hometest.controller.Controller;
import org.hometest.model.Model;
import org.hometest.view.View;

public class Main {
	public static void main(String[] args) {
		Controller controller = new Controller(new View(), new Model());
		controller.run();
	}
}
