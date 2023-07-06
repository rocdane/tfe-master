package startup.loga.client.model;

public enum Category {
    LUBRIFIANT{
        @Override
        public String getCategory() {
            return "Lubrifiant";
        }
    },
    CONSOMMABLE {
        @Override
        public String getCategory() {
            return "Consommable";
        }
    },
    PIECE {
        @Override
        public String getCategory() {
            return "Pièce de rechange";
        }
    };

    public abstract String getCategory();
}
