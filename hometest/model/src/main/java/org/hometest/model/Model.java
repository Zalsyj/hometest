package org.hometest.model;

import org.hometest.contract.IModel;

public class Model implements IModel{

	public String getHelloWorld() {
		return DAOHelloWorld.getInstance().getQuerySelectFirstHelloWorld();
	}

}
