package uz.yasmintour.yasmintour.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

public class MessageDto {
    @NotBlank
    @Length(min = 3, max = 46,message = "Ismingiz Minimum 3 Maximum 46 ta harifda iborat bo'lishi kerak")
    private String firstName;
    @NotBlank
    @Length(min = 7, max = 15, message = "Telefon raqam minimum 7 maximum 15 ta raqamdan tashkil topgan bo'lishi kerak")
    private String number;
    @Length(min = 7, max = 500, message = "Xabar 7 ta harfdan ko'p bo'lishi kerak")
    private String message;
    @Email(message = "Noto'g'ri email")
    @NotBlank(message = "Email bo'sh bo'lmasligi kerak")
    private String mail;

    public MessageDto(String firstName, String number, String message, String mail) {
        this.firstName = firstName;
        this.number = number;
        this.message = message;
        this.mail = mail;
    }

    public MessageDto() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "firstName='" + firstName + '\'' +
                ", number='" + number + '\'' +
                ", message='" + message + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}