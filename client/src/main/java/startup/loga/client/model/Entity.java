package startup.loga.client.model;

/**
 * énumération des entités:Entity concernant par les facteurs:Factor de diagnostic:Diagnosis
 */
public enum Entity {
    CHASSIS{
        @Override
        public String getEntity() {
            return "Chassis";
        }
    },
    CARROSSERIE {
        @Override
        public String getEntity() {
            return "Carrosserie";
        }
    },
    MOTORISATION {
        @Override
        public String getEntity() {
            return "Système de motorisation";
        }
    },
    TRANSMISSION {
        @Override
        public String getEntity() {
            return "Système de transmission";
        }
    },
    FREINAGE {
        @Override
        public String getEntity() {
            return "Système de freinage";
        }
    },
    SUSPENSION {
        @Override
        public String getEntity() {
            return "Système de suspension";
        }
    },
    DIRECTION {
        @Override
        public String getEntity() {
            return "Système de direction";
        }
    },
    OBD {
        @Override
        public String getEntity() {
            return "Système embarqué de diagnostic";
        }
    };

    public abstract String getEntity();
}
