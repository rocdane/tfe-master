package startup.loga.client.model;

public enum Unit {
    Km{
        @Override
        public String getUnit() {
            return "Kilomètre";
        }
    },
    Mi{
        @Override
        public String getUnit() {
            return "Miles";
        }
    };

    public abstract String getUnit();
}
