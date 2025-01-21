package day6;

import org.testng.annotations.Test;
import com.github.javafaker.Faker;
public class FakerGenerator {
    @Test
    public void randomGenerateUserid() //generate dummy data
    {
            Faker faker = new Faker();
            String fullname = faker.name().fullName();
            System.out.println(fullname);

        String username = faker.name().username();
        System.out.println(username);

        String mobileNo = faker.phoneNumber().cellPhone();
        System.out.println(mobileNo);

        String password = faker.internet().password();
        System.out.println(password);


    }
}
