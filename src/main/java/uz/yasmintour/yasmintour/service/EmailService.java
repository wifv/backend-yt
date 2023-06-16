package uz.yasmintour.yasmintour.service;

import uz.yasmintour.yasmintour.dto.MessageDto;

public interface EmailService {
    boolean sendSimpleMail(MessageDto details);
}
