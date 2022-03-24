package foodproducer;

import java.util.Hashtable;


import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;

import org.osgi.framework.ServiceRegistration;
import foodproducer.FoodProducer;

public class Activator implements BundleActivator {

//Register Food Producer service
	private static BundleContext context;
	ServiceRegistration serviceRegistration;
	
	public void start(BundleContext bundleContext) throws Exception {

		Activator.context = bundleContext;
		IFoodProducer foodProducer = new FoodProducer();
		serviceRegistration = bundleContext.registerService(FoodProducer.class.getName(), foodProducer, null);
		
	}

	public void stop(BundleContext ctx) throws Exception {
		Activator.context = null;
		serviceRegistration.unregister();
	}}


