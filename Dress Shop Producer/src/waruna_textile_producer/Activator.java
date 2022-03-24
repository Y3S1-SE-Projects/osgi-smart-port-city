package waruna_textile_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {

	ServiceRegistration publicServiceRegistration;

	public void start(BundleContext context) throws Exception {
		
		DressInterface dressService = new DressInterfaceImpl();
		publicServiceRegistration = context.registerService(DressInterface.class.getName(), dressService, null);
		
		System.out.println("Dress shop producer service is open");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Dress shop producer service closed");
		publicServiceRegistration.unregister();
	}

}
