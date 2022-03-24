package cinnamon_grand_hotel_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration publicServiceRegistration;

	public void start(BundleContext context) throws Exception {
		
		CinnamonInterface hotelService = new CinnamonInterfaceImpl();
		publicServiceRegistration = context.registerService(CinnamonInterface.class.getName(), hotelService, null);
		
		System.out.println("Cinnamon Grand Hotel Producer Opened");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Cinnamon Grand Hotel Producer Closed");
		publicServiceRegistration.unregister();
	}

}
