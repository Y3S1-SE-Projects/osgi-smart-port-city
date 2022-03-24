# OSGi-Smart-Port-City :sparkles:

![logo](img/osgi-logo.jpg "logo")

## Table of Contents

- [Use Case Scenario](#Use-Case-Scenario)
- [Getting Started - Installation](#Getting-Started---Installation)
- [System Overview](#System-Overview)
- [Authors](#Authors)

## Use Case Scenario :palm_tree:
We will be building an OSGi application for the ongoing construction of the Port City in Sri Lanka. Our object is to make a “Smart Port City” and produce services to the customers going in and out of the Port City, where they would be able to subscribe or consume those services in their own convenience. 

However, you may ask why we have chosen the OSGi framework as our technology to develop this application? We know that among the construction of the Port City there would be many different services added from time to time such as various restaurants, different types of hotels etc. Therefore, from a developer’s point of view implementing each of these services may be a hustle and would take a long time to develop. The application would be large which can be difficult to maintain, difficult to maintain security and implement new services. New developers may find it difficult to comprehend the code and hence would increase development time. However, the OSGi framework solves this problem.

The OSGi framework provides mainly reliable configuration, strong encapsulation and high modularity. Modularity enables the program to separate the functionality of a large program into independent, interchangeable modules, in such a way that each module would contain everything it needs to execute one single functionality. Therefore, we can say that each module is fully encapsulated thus reducing security vulnerabilities. As you can see, due to these advantages of the OSGi framework for our use case this technology would be the perfect choice :stuck_out_tongue:

## Getting Started - Installation :computer:

1.  This is a basic producer and consumer application utilising the OSGi Framework.
2.  Run all the producer bundles first before the consumer because you need to run these `separately`.
3.  Make sure to create a new OSGi configuration for each producer bundle  when running and also select ONLY the producer bundle you want to run.
4.  For each producer press `Enter` and type `lb` to list all the bundles in order to check if your producer bundle is `ACTIVE` or not. 
5.  If you cannot find the bundle then use `Ctrl + f` to search by the bundle name or type `ss` and move to the top of the bundle list IDs, usually your desired    bundle would be within the top 10 IDs.
6.  Create a new OSGi configuration for the consumer bundle and run the configuration by selecting ALL the producer bundles including the consumer bundle.
7.  Repeat steps 4 and 5 and check if all bundles, producers and consumers are `ACTIVE`. (If they are already `ACTIVE` your application will run automatically)


## System Overview :package:
The following would be provided in the form of a report in PDF format in the root directory :

- [x] System Flowcharts
- [x] Console Outputs of the OSGi Application System
- [x] Screenshots of MANIFEST files of each bundle

## Authors :mortar_board:
- [Dissanayake M.C.Y.D  -  IT20013332](https://github.com/Chabbax)
- [Abineshh U  -  IT20025908](https://github.com/)
- [Zihara M.I.F  -  IT20032388](https://github.com/)
- [Kuruppu S.G  -  IT20061302](https://github.com/)
