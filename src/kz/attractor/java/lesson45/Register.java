package kz.attractor.java.lesson45;

import java.util.ArrayList;
import java.util.List;

public class Register {
    private Registers reg = new Registers("Apache", "FreeMarker");
    private List<Registers> registers = new ArrayList<>();

//    public Register() {
//        registers.add(new Registers("Marco Marco@test.mail",123456789,false));
//        registers.add(new Registers("Winston Winston@test.mail", 987654321,false));
//        registers.add(new Registers("Amos Amos@test.mail", 102938465, false));
//        registers.get(1).setEmailConfirmed(true);
//    }

    public List<Registers> getRegisters() {
        return registers;
    }

    public void setRegisters(List<Registers> registers) {
        this.registers = registers;
    }

    public class Registers{
        private String email;
        private String username;
        private int password;
        private boolean emailConfirmed = false;

        public Registers(String email, String username) {
            this.email = email;
            this.username = username;
        }

        public Registers( String username, int password, boolean emailConfirmed) {
            this.email = username + "@test.mail";
            this.username = username;
            this.password = password;
            this.emailConfirmed = emailConfirmed;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getPassword() {
            return password;
        }

        public void setPassword(int password) {
            this.password = password;
        }

        public boolean isEmailConfirmed() {
            return emailConfirmed;
        }

        public void setEmailConfirmed(boolean emailConfirmed) {
            this.emailConfirmed = emailConfirmed;
        }
    }
}
