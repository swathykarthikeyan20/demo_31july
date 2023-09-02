package com.firstname;

class TypeException extends Exception {
    @Override
    public String toString() {
        return "Vehicle Type Not Set";
    }
}

class Vehicles {
    protected String type;
    protected String model_no;
    protected String model_name;
    protected String owner_name;
    protected String owner_details;

    public Vehicles(String model_no, String model_name, String owner_name, String owner_details) {
        this.model_no = model_no;
        this.model_name = model_name;
        this.owner_name = owner_name;
        this.owner_details = owner_details;
    }

    public Vehicles() {
    }

    public String get_type() {
        return type;
    }

    public String retrieve() {
        return "null";
    }
}

class Car extends Vehicles {
    public Car(String model_no, String model_name, String owner_name, String owner_details) {
        super(model_no, model_name, owner_name, owner_details);
    }

    public Car() {
    }

    @Override
    public String get_type() {
        return type;
    }

    public void set_type(String type) {
        this.type = type;
    }

    @Override
    public String retrieve() {
        if (type == null) {
            try {
                throw new TypeException();
            } catch (TypeException e) {
                return e.toString();
            }
        } else {
            return model_no + ", " + model_name + ", " + owner_details + ", " + owner_name;
        }
    }
}

public class customexception {
    public static void main(String[] args) {
        Car car = new Car("123", "Toyota", "John Doe", "123 Main Street");
        System.out.println("Car details: " + car.retrieve());

        car.set_type("Sedan");
        System.out.println("Car type: " + car.get_type());
        System.out.println("Car details: " + car.retrieve());
    }
}
