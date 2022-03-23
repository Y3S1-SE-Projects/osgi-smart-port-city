package customer.activator;

import java.util.Scanner;
import kangaroo.Kangaroo;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import pickme.Pickme;
import User.CustomerImpl;
import transportservice.Transport;
import transportservice.TransportImpl;
import uber.Uber;

public class Activator implements BundleActivator {

	//Initializing Objects
	private static BundleContext context;
	private Pickme pickme;
	private Uber uber;
	private Kangaroo kangaroo;
	private Transport Trans;

	static BundleContext getContext() {
		return context;
	}

	//Life cycle method-start
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Fetching Taxis ..... Customer bundle starting");
		Scanner sc = new Scanner(System.in);
		String choice = "no";

		float distance;

		ServiceReference serviceTrans = context.getServiceReference(Transport.class);
		if (serviceTrans != null) {
			Trans = (Transport) context.getService(serviceTrans);
			if (Trans != null) {
				System.out.println("");
				System.out.println("------------------------------------------------------------------------------------------------");
				System.out.println("You can book a taxi for instantanously find a taxi. Please note that booking costs extra charges");
				System.out.println("Do you want to book an Taxi? yes or no");
				System.out.println("");

				choice = sc.next();
				if (choice.equals("yes")) {
					Transport Uber_Taxi = new TransportImpl();
					System.out.println("------------------------------------------------------------------------");
					System.out.println("What is the distance between your current location and your destination?");
					System.out.println("");

					distance = sc.nextFloat();
					CustomerImpl.NoBooking = distance;
					CustomerImpl.BookingCharge = Uber_Taxi.calculate(distance);
					this.MainAction();
				} else {
					this.MainAction();
				}
				context.ungetService(serviceTrans);
			} else {
				System.out.println(" Taxi Service cannot run.... ");
			}
		} else {
			System.out.println("Taxi Service cannot be found!");
		}

		System.out.println("Customer Consumer has stopped");
	}

	//Main method implementation for the taxi choices 
	private void MainAction() {
		Scanner sc = new Scanner(System.in);
		String whileCon = "no";
		do {
			int a = CustomerImpl.find();

			//Condition
			if (a == 2) {
				ServiceReference service = context.getServiceReference(Pickme.class);
				if (service != null) {
					pickme = (Pickme) context.getService(service);
					if (pickme != null) {
						CustomerImpl.run(pickme);
						context.ungetService(service);
					} else {
						System.out.println("Customer bundle cannot run!");
					}
				} else {
					System.out.println("Customer bundle cannot be found....");
				}
			} else if (a == 1) {
				ServiceReference service = context.getServiceReference(Uber.class);
				if (service != null) {
					uber = (Uber) context.getService(service);
					if (uber != null) {
						CustomerImpl.run2(uber);
						context.ungetService(service);
					} else {
						System.out.println("Customer bundle cannot run! ");
					}
				} else {
					System.out.println("Customer bundle cannot be found!");
				}
			} else if (a == 3) {
				ServiceReference service = context.getServiceReference(Kangaroo.class);
				if (service != null) {
					kangaroo = (Kangaroo) context.getService(service);
					if (kangaroo != null) {
						CustomerImpl.run3(kangaroo);
						context.ungetService(service);
					} else
						System.out.println("Customer bundle cannot run! ");
				} else {
					System.out.println("Customer bundle cannot be found!");
				}
			} else {
				System.out.println(" ");
			}

			System.out.println("----------------------------------------------------");
			System.out.println("Do you want to exit? \n 'yes' for YES \n 'no' for NO");
			System.out.println("");

			whileCon = sc.next();

		} while (whileCon.equals("no"));
		CustomerImpl.PrintTotalInvoice();
	}

	//Life cycle method-stop
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Customer bundle stopped!");
	}

}