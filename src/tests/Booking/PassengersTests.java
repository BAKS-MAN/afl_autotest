package tests.Booking;

import lib.CoreTestCase;
import lib.ui.Booking.PassengersPageObject;
import org.junit.Test;

public class PassengersTests extends CoreTestCase {

    @Test
    public void testEditPassengerData(){
        PassengersPageObject PassengersPageObject = new PassengersPageObject(driver);
        PassengersPageObject.SearchWithOnePassenger("Москва","Сочи",true);
        PassengersPageObject.editPassengerName("Petr");
        PassengersPageObject.editPassengerLastName("Test");
        PassengersPageObject.editPassengerBirthDate("1987");
        PassengersPageObject.editPassengerSex("Мужской");
        PassengersPageObject.selectCitizenCountry("Германия");
        PassengersPageObject.selectPassportType("Заграничный паспорт");
        PassengersPageObject.selectPassportCountry("Испания");
        PassengersPageObject.editPassportNumber("5004698547");
        PassengersPageObject.editPassportIssueDate("2022");
        PassengersPageObject.editPhoneNumber("790412365789");
        PassengersPageObject.editEmailAddress("test@test.com");
        PassengersPageObject.pressNextButton();
    }
    @Test
    public void testEditSeveralPassengersData(){
        PassengersPageObject PassengersPageObject = new PassengersPageObject(driver);
        PassengersPageObject.SearchWithSeveralPassengers("Москва","Берлин",false);
        PassengersPageObject.selectPassengerToEdit("Взрослый","1");
        PassengersPageObject.editPassengerName("Petr");
        PassengersPageObject.editPassengerLastName("Test");
        PassengersPageObject.editPassengerBirthDate("1987");
        PassengersPageObject.editPassengerSex("Мужской");
        PassengersPageObject.selectCitizenCountry("Германия");
        PassengersPageObject.selectPassportType("Заграничный паспорт");
        PassengersPageObject.selectPassportCountry("Россия");
        PassengersPageObject.editPassportNumber("5004698547");
        PassengersPageObject.editPassportIssueDate("2024");
        PassengersPageObject.pressSaveButton();

        PassengersPageObject.selectPassengerToEdit("Ребёнок","1");
        PassengersPageObject.editPassengerName("Nikita");
        PassengersPageObject.editPassengerLastName("Test");
        PassengersPageObject.editPassengerBirthDate("2010");
        PassengersPageObject.editPassengerSex("Мужской");
        PassengersPageObject.selectCitizenCountry("Россия");
        PassengersPageObject.selectPassportType("Заграничный паспорт");
        PassengersPageObject.selectPassportCountry("Россия");
        PassengersPageObject.editPassportNumber("7408541256");
        PassengersPageObject.editPassportIssueDate("2027");
        PassengersPageObject.pressSaveButton();

        PassengersPageObject.selectPassengerToEdit("Младенец","1");
        PassengersPageObject.editPassengerName("Anna");
        PassengersPageObject.editPassengerLastName("Test");
        PassengersPageObject.editPassengerBirthDate("2017");
        PassengersPageObject.editPassengerSex("Женский");
        PassengersPageObject.selectCitizenCountry("Россия");
        PassengersPageObject.selectPassportType("Заграничный паспорт");
        PassengersPageObject.selectPassportCountry("Россия");
        PassengersPageObject.editPassportNumber("8456965258");
        PassengersPageObject.editPassportIssueDate("2019");
        PassengersPageObject.pressSaveButton();

        PassengersPageObject.editPhoneNumber("790412365789");
        PassengersPageObject.editEmailAddress("test@test.com");
        PassengersPageObject.pressNextButton();
    }

}
