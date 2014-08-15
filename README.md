cf-shutdown-hook
================

This app demonstrates graceful shutdown of an app running in Cloud Foundry. 

Build the app with the following command: 

~~~
$ ./gradlew assemble
~~~

Then push to Cloud Foundry with the included `manifest.yml`. 

When the application container is shut down, a shutdown hook in the app will count down from 9 seconds and then allow the app to exit. Log output like the following will be written, along with Tomcat's shutdown logging:

~~~
2014-08-14 20:44:02.037  INFO 7816 --- [       Thread-5] o.c.s.shutdown.web.LifecycleComponent    : Initiating graceful shutdown
2014-08-14 20:44:02.037  INFO 7816 --- [       Thread-5] o.c.s.shutdown.web.LifecycleComponent    : Shutting down in 9 seconds
14-Aug-2014 20:44:02.081 INFO [Thread-6] org.apache.coyote.AbstractProtocol.pause Pausing ProtocolHandler ["ajp-nio-8009"]
14-Aug-2014 20:44:02.133 INFO [Thread-6] org.apache.catalina.core.StandardService.stopInternal Stopping service Catalina
14-Aug-2014 20:44:02.180 INFO [Thread-6] org.apache.coyote.AbstractProtocol.stop Stopping ProtocolHandler ["http-nio-8080"]
14-Aug-2014 20:44:02.181 INFO [Thread-6] org.apache.coyote.AbstractProtocol.stop Stopping ProtocolHandler ["ajp-nio-8009"]
14-Aug-2014 20:44:02.182 INFO [Thread-6] org.apache.coyote.AbstractProtocol.destroy Destroying ProtocolHandler ["http-nio-8080"]
14-Aug-2014 20:44:02.182 INFO [Thread-6] org.apache.coyote.AbstractProtocol.destroy Destroying ProtocolHandler ["ajp-nio-8009"]
2014-08-14 20:44:03.039  INFO 7816 --- [       Thread-5] o.c.s.shutdown.web.LifecycleComponent    : Shutting down in 8 seconds
2014-08-14 20:44:04.040  INFO 7816 --- [       Thread-5] o.c.s.shutdown.web.LifecycleComponent    : Shutting down in 7 seconds
2014-08-14 20:44:05.041  INFO 7816 --- [       Thread-5] o.c.s.shutdown.web.LifecycleComponent    : Shutting down in 6 seconds
2014-08-14 20:44:06.042  INFO 7816 --- [       Thread-5] o.c.s.shutdown.web.LifecycleComponent    : Shutting down in 5 seconds
2014-08-14 20:44:07.043  INFO 7816 --- [       Thread-5] o.c.s.shutdown.web.LifecycleComponent    : Shutting down in 4 seconds
2014-08-14 20:44:08.045  INFO 7816 --- [       Thread-5] o.c.s.shutdown.web.LifecycleComponent    : Shutting down in 3 seconds
2014-08-14 20:44:09.046  INFO 7816 --- [       Thread-5] o.c.s.shutdown.web.LifecycleComponent    : Shutting down in 2 seconds
2014-08-14 20:44:10.048  INFO 7816 --- [       Thread-5] o.c.s.shutdown.web.LifecycleComponent    : Shutting down in 1 seconds
2014-08-14 20:44:11.050  INFO 7816 --- [       Thread-5] o.c.s.shutdown.web.LifecycleComponent    : Shutting down now
~~~
