package sprint.example.crud_application;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load(); // create an obj of env that ingnore if sonthing is missing
		dotenv.entries().forEach((
				entry) -> System.setProperty(
				entry.getKey() , entry.getValue()
		));
		SpringApplication.run(CrudApplication.class, args);
		System.out.println("hello");
	}
}
