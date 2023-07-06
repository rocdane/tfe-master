package startup.loga.client.model;

public enum Mode {
    ESPECE{
        @Override
        public String getMode() {
            return "Espèce";
        }
    },
    CHEQUE{
        @Override
        public String getMode() {
            return "Chèque";
        }
    },
    VIREMENT{
        @Override
        public String getMode() {
            return "Virement";
        }
    },
    MOBILE{
        @Override
        public String getMode() {
            return "Transfert mobile";
        }
    };

    public abstract String getMode();
}
