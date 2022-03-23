package uber.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import uber.Uber;
import uber.impl.UberImpl;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	//Life cycle method-start
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Uber Taxi Service Starting ...");
		this.CallInterface();
		System.out.println("Welcome to Uber Taxi");
	}

	private void CallInterface() {
		Uber uber = new UberImpl();
		context.registerService(Uber.class, uber, null);
	}

	//Life cycle method-stop
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Uber Taxi Service Closed");
	}
}