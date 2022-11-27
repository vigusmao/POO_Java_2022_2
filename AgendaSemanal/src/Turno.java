public enum Turno {

    MANHA(3),
    TARDE(3),
    NOITE(2);

    private int maxCompromissos;

    Turno(int maxCompromissos) {
        this.maxCompromissos = maxCompromissos;
    }

    public int getMaxCompromissos() {
        return maxCompromissos;
    }
}
