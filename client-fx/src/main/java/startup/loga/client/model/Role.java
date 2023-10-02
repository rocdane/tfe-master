package startup.loga.client.model;

public enum Role {

    ADMINISTRATOR {
        @Override
        public String getRole() {
            return "ADMIN";
        }
    },
    SUPERVISOR {
        @Override
        public String getRole() {
            return "SUPER";
        }
    },
    USER {
        @Override
        public String getRole() {
            return "USER";
        }
    };

    public abstract String getRole();
}