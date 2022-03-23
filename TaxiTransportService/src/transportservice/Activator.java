package transportservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	//Life cycle method-start
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Transport service starting...");
		this.CallDressService();
		System.out.println("Transport service started....");
	}

	private void CallDressService() {
		Transport Ds = new TransportImpl();
		context.registerService(Transport.class, Ds, null);
	}

	//Life cycle method-stop
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}