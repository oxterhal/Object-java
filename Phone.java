import java.util.Scanner;

public class Phone {
    static class phone {
        private String name;
        private String version;
        private String size;
        private String color;
        private String password;

        public phone(String name, String version, String size, String color, String password) {
            this.name = name;
            this.version = version;
            this.size = size;
            this.color = color;
            this.password = password;
        }

        public void displayInfo() {
            System.out.println("Device Details:");
            System.out.printf("- Name: %s\n", name);
            System.out.printf("- Version: %s\n", version);
            System.out.printf("- Size: %s\n", size);
            System.out.printf("- Color: %s\n", color);
        }

        public boolean validatePassword(String inputPassword) {
            return inputPassword.equals(password);
        }

        public void unlockDevice() {
            Scanner scanner = new Scanner(System.in);
            int attempts = 1;

            while (attempts > 0) {
                System.out.printf("Enter password (Attempts left: %d): ", attempts);
                String inputPassword = scanner.nextLine();

                if (validatePassword(inputPassword)) {
                    System.out.println("Access Granted!");
                    displayInfo();
                    return;
                } else {
                    attempts--;
                    System.out.println("Incorrect password. Try again.");
                }
            }

            System.out.println("Too many incorrect attempts. Device locked.");
        }
    }

    public static void main(String[] args) {
        phone phone = new phone(
            "Minii utas", 
            "11", 
            "6.1 inches", 
            "black", 
            "999999"
        );
        phone.unlockDevice();
    }
}