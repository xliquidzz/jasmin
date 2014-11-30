package ch.fihlon.jasmin;

import ch.fihlon.jasmin.resources.BacklogItemResource;
import ch.fihlon.jasmin.resources.SprintResource;
import ch.fihlon.jasmin.resources.TeamResource;
import ch.fihlon.jasmin.resources.UserResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class App extends Application<JasminConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private static DBI dbi;

    public static void main(@Nonnull final String[] args) throws Exception {
        LOGGER.info("Starting application with arguments: %s", new Object[]{args});
        new App().run(args);
    }

    public static @Nullable DBI getDBI() {
        return dbi;
    }

    @Override
    public void initialize(@Nonnull final Bootstrap<JasminConfiguration> bootstrap) {
        // Register additional Jackson modules
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JSR310Module());
    }

    @Override
    public void run(@Nonnull final JasminConfiguration configuration, @Nonnull final Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        dbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");

        environment.jersey().register(new SprintResource(dbi));
        environment.jersey().register(new TeamResource(dbi));
        environment.jersey().register(new BacklogItemResource(dbi));
        environment.jersey().register(new UserResource(dbi));
    }
}
