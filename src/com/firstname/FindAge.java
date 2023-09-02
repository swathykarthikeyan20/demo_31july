package com.firstname;

class Age {
    String drink;
    String vote;
    String movie;
}

class IllegalAgeException extends Exception {
    public IllegalAgeException(String message) {
        super(message);
    }
}

class ExceptionCheck {
    public String drinkingCheck(Age a, int age) {
        try {
            if (age < 21) {
                a.drink = "illegal";
                throw new IllegalAgeException("Illegal drinking age");
            } else {
                a.drink = "legal";
            }
        } catch (IllegalAgeException e) {
            return e.getMessage();
        }
        return a.drink;
    }

    public String votingCheck(Age a, int age) {
        try {
            if (age < 18) {
                a.vote = "illegal";
                throw new IllegalAgeException("Illegal voting age");
            } else {
                a.vote = "legal";
            }
        } catch (IllegalAgeException e) {
            return e.getMessage();
        }
        return a.vote;
    }

    public String movieCheck(Age a, int age) {
        try {
            if (age < 14) {
                a.movie = "illegal";
                throw new IllegalAgeException("Illegal movie-watching age");
            } else {
                a.movie = "legal";
            }
        } catch (IllegalAgeException e) {
            return e.getMessage();
        }
        return a.movie;
    }
}

public class FindAge {
    public static void main(String[] args) {
        ExceptionCheck check = new ExceptionCheck();
        Age age = new Age();

        int ageForDrinking = 25;
        System.out.println("Drinking: " + check.drinkingCheck(age, ageForDrinking));

        int ageForVoting = 17;
        System.out.println("Voting: " + check.votingCheck(age, ageForVoting));

        int ageForMovie = 12;
        System.out.println("Movie: " + check.movieCheck(age, ageForMovie));
    }
}