package com.firstname;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Header {
    String from;
    String to;

    public Header(String from, String to) {
        this.from = from;
        this.to = to;
    }
}

class Email {
    Header header;
    String body;
    String greetings;

    public Email(Header header, String body, String greetings) {
        this.header = header;
        this.body = body;
        this.greetings = greetings;
    }
}

class EmailOperations {
    public int emailVerify(Email e) {
        String from = e.header.from;
        String to = e.header.to;

        Pattern pattern = Pattern.compile("^[A-Za-z_]+@[A-Za-z]+\\.[A-Za-z]+$");
        Matcher fromMatcher = pattern.matcher(from);
        Matcher toMatcher = pattern.matcher(to);

        if (fromMatcher.matches() && toMatcher.matches()) {
            return 2;
        } else if (fromMatcher.matches() || toMatcher.matches()) {
            return 1;
        } else {
            return 0;
        }
    }

    public String bodyEncryption(Email e) {
        StringBuilder encryptedBody = new StringBuilder();
        for (char c : e.body.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char encryptedChar = (char) (((c - 'A' + 3) % 26) + 'A');
                encryptedBody.append(encryptedChar);
            } else if (Character.isLowerCase(c)) {
                char encryptedChar = (char) (((c - 'a' + 3) % 26) + 'a');
                encryptedBody.append(encryptedChar);
            } else {
                encryptedBody.append(c);
            }
        }
        return encryptedBody.toString();
    }

    public String greetingMessage(Email e) {
        String from = e.header.from;
        String name = from.substring(0, from.indexOf('@'));
        return e.greetings + " " + name;
    }
}

public class emailopertaion {
    public static void main(String[] args) {
        Header header = new Header("amit@doselect.com", "john@doselect.com");
        Email email = new Email(header, "Hi There Hows you", "Regards");
        EmailOperations emailOperations = new EmailOperations();

        int emailVerifyResult = emailOperations.emailVerify(email);
        System.out.println("Email Verification Result: " + emailVerifyResult);

        String encryptedBody = emailOperations.bodyEncryption(email);
        System.out.println("Encrypted Body: " + encryptedBody);

        String greetingMessage = emailOperations.greetingMessage(email);
        System.out.println("Greeting Message: " + greetingMessage);
    }
}
