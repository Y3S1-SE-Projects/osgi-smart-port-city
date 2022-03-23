package pickme.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import pickme.Pickme;
import pickme.impl.PickmeImpl;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	//Life cycle method-start
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Pickme Taxi Service Starting ...");

		this.Callservice();

		System.out.println("Welcome to Pickme Taxi");
	}

	private void Callservice() {
		Pickme pickme = new PickmeImpl();
		context.registerService(Pickme.class, pickme, null);
	}

	//Life cycle method-stop
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Pickme Taxi Service Closed");
	}
}