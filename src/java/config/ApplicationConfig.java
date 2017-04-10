/*
 * TODO: Change me
 */
package config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Andrew
 */
@javax.ws.rs.ApplicationPath("API")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(services.AdministrationService.class);
        resources.add(services.AuthenticationService.class);
        resources.add(services.DailyDiaryService.class);
        resources.add(services.FortnightlyDiaryService.class);
        resources.add(services.HelloWorldService.class);
        resources.add(services.RegistrationService.class);
    }
    
}
