package launch;

import java.io.File;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class Main {

	public static void main(String[] args) {

		String webappDirLocation = "/";
		Tomcat tomcat = new Tomcat();
		
		String webPort = System.getenv("PORT");
		if(webPort == null || webPort.isEmpty()){
			webPort = "8080";
		}
		tomcat.setPort(Integer.valueOf(webPort));

		StandardContext ctx= null;
		try {
			ctx = (StandardContext) tomcat.addWebapp("", new File(webappDirLocation).getAbsolutePath());
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());

        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

        try {
			tomcat.start();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
        tomcat.getServer().await();
	}

}
