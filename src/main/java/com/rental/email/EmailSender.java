package com.rental.email;

public interface EmailSender {
    void send(String to, String email,String subject);
}
