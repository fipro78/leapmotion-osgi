package org.fipro.leapmotion.impl;

import org.eclipse.e4.core.di.suppliers.ExtendedObjectSupplier;
import org.eclipse.e4.core.di.suppliers.IObjectDescriptor;
import org.eclipse.e4.core.di.suppliers.IRequestor;

import com.leapmotion.leap.Controller;

public class LeapControllerObjectSupplier extends ExtendedObjectSupplier {

	static {
		//load the native libraries for the Leap Motion 
		//device in the specified order
		System.loadLibrary("Leap");
		System.loadLibrary("LeapJava");
	}

	/**
	 * The Leap Motion Controller that will be provided by this 
	 * object supplier.
	 */
	private Controller controller;

	@Override
	public Object get(
		IObjectDescriptor descriptor, IRequestor requestor, 
			boolean track, boolean group) {

		if (this.controller == null) {
			this.controller = new Controller();
		}
		return this.controller;
	}
}