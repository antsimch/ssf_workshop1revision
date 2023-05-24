package sg.edu.nus.iss.ssf11_workshop1revision;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ssf11Workshop1revisionApplication {

	private static final String DEFAULT_PORT = "3000";

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(Ssf11Workshop1revisionApplication.class);

		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);

		List<String> opsValues = appArgs.getOptionValues("port");

		String port;

		if ((opsValues == null) || (opsValues.get(0) == null)) {

			port = System.getenv("PORT");

			if (port == null) {
				port = DEFAULT_PORT;
			}
		} else {

			port = opsValues.get(0);
		}

		if (port != null) {
			app.setDefaultProperties(Collections.singletonMap("server.port", port));
		}


		app.run(args);
	}

}
