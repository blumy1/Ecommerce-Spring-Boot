package blumek.sb.ecommercespringboot.bootstrap;

import blumek.sb.ecommercespringboot.models.*;
import blumek.sb.ecommercespringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.logging.Logger;

@SuppressWarnings("Duplicates")
@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final UserRepository userRepository;
    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    public UserLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        // User1
        String login = "Syzak";
        String password = "Haslo123";
        String email = "Syzak@gmail.com";
        String firstName = "Szymon";
        String secondName = "Blumczyński";

        String country = "Poland";
        String city = "Konin";
        String zipCode = "62-510";
        String street = "11 Listopada 16";
        String house = "61";
        Address address1 = new Address(country, city, zipCode, street, house);

        country = "Poland";
        city = "Poznań";
        zipCode = "60-102";
        street = "Os. Sobieskiego 2";
        house = "3";
        Address address2 = new Address(country, city, zipCode, street, house);


        User user1 = new User(login, password, email, firstName, secondName, new Date(), new HashSet<>());
        user1.getAddresses().add(address1);
        user1.getAddresses().add(address2);
        address1.setUser(user1);
        address2.setUser(user1);

        userRepository.save(user1);
        logger.info("SAVED USER: " + user1.getId());


        // User2
        login = "Piotr02";
        password = "Piotr123";
        email = "Piotr02@gmail.com";
        firstName = "Piotr";
        secondName = "Nowak";

        country = "Poland";
        city = "Poznań";
        zipCode = "60-102";
        street = "Szymanowskiego 3";
        house = "15";
        address1 = new Address(country, city, zipCode, street, house);

        User user2 = new User(login, password, email, firstName, secondName, new Date(), new HashSet<>());
        user2.getAddresses().add(address1);
        address1.setUser(user2);

        userRepository.save(user2);
        logger.info("SAVED USER: " + user2.getId());


        //User3
        login = "Drag235";
        password = "TrudneHaslo123";
        email = "drag22@gmail.com";
        firstName = "Dariusz";
        secondName = "Kowalski";

        country = "Poland";
        city = "Wrocław";
        zipCode = "51-671";
        street = "Kwiatowa 3";
        house = "55";
        address1 = new Address(country, city, zipCode, street, house);

        country = "Poland";
        city = "Poznań";
        zipCode = "60-102";
        street = "Os. Bolesława Chrobrego II 14";
        house = "23";
        address2 = new Address(country, city, zipCode, street, house);

        User user3 = new User(login, password, email, firstName, secondName, new Date(), new HashSet<>());
        user3.getAddresses().add(address1);
        user3.getAddresses().add(address2);
        address1.setUser(user3);
        address2.setUser(user3);

        userRepository.save(user3);
        logger.info("SAVED USER: " + user3.getId());

        // User4
        login = "Jax22";
        password = "Jax098";
        email = "jaxy@gmail.com";
        firstName = "Szymon";
        secondName = "Blumczyński";

        country = "Poland";
        city = "Wrocław";
        zipCode = "51-671";
        street = "Kolorowa 23";
        house = "61";
        address1 = new Address(country, city, zipCode, street, house);

        User user4 = new User(login, password, email, firstName, secondName, new Date(), new HashSet<>());
        user4.getAddresses().add(address1);
        address1.setUser(user4);

        userRepository.save(user4);
        logger.info("SAVED USER: " + user4.getId());
    }
}
