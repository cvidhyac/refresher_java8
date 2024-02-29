package org.example;

public class DefaultAndStaticMethods {

    public static void main(String[] args) {

        EmployeeImpl employeeImpl = new EmployeeImpl();
        employeeImpl.find(1234);

        //static method is accessible
        System.out.println(Employee.getDefaultCountry());
    }

}

class EmployeeImpl implements Employee {

    @Override
    public Employee find(int id) {
        //default method is accessible automatically.
        boolean executiveEmployee = isExecutive(id);
        return null;
    }
}

@FunctionalInterface
interface Employee {

    Employee find(int id);

    default boolean isExecutive(int id) {
        return true;
    }

    static String getDefaultCountry() {
        return "Canada";
    }
}