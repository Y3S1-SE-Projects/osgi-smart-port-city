package kangaroo.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import kangaroo.Kangaroo;
import kangaroo.impl.KangarooImpl;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	//Life cycle method-start
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Kangaroo Taxi Service Starting ...");
		this.calltoy();
		System.out.println("Welcome to Kangaroo Taxi");
	}

	private void calltoy() {
		Kangaroo kangaroo = new KangarooImpl();
		context.registerService(Kangaroo.class, kangaroo, null);
	}

	//Life cycle method-stop
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Kangaroo Taxi Service Closed");
	}
}
