package startup.loga.client.model;

public enum Role {

    ADMINISTRATOR {
        @Override
        public String getRole() {
            return "ADMINISTRATEUR";
        }
    },
    SUPERVISOR {
        @Override
        public String getRole() {
            return "SUPERVISEUR";
        }
    },
    MEMBER {
        @Override
        public String getRole() {
            return "MEMBRE";
        }
    };

    public abstract String getRole();
}