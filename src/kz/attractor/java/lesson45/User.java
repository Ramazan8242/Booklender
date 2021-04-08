package kz.attractor.java.lesson45;

    public class User {
        private String name;
        private String email;
        private String login;
        private String password;

        public User() { }

        public static User makeUser(String name,String email, String login, String password){
            User u = new User();
            u.name = name;
            u.email = email;
            u.login = login;
            u.password = password;
            return u;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

