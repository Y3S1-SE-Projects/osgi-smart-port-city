package foodconsumer;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import foodproducer.FoodProducer;
import foodproducer.IFoodProducer;
//create reference to  food producer service
public class Activator implements BundleActivator {
	
	
	private static BundleContext context;
	ServiceReference serviceReference;
	
	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		
	//Activator.bc = bc;
	Activator.context = bundleContext;
	
	serviceReference = bundleContext.getServiceReference(FoodProducer.class.getName());
	
	FoodProducer foodProducer = (FoodProducer) bundleContext.getService(serviceReference);
	


	
	System.out.println("Service done!"+foodProducer.buy(5, 4));
	foodProducer.printintro();
	}

	
	

	public void stop(BundleContext bc) throws Exception {
	Activator.context = null;
	
	}

	}




