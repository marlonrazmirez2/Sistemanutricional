enum CategoriaIMC {
    BAJO_PESO("Bajo peso", 0, 18.5),
    NORMAL("Normal", 18.5, 25),
    SOBREPESO("Sobrepeso", 25, 30),
    OBESIDAD_I("Obesidad I", 30, 35),
    OBESIDAD_II("Obesidad II", 35, 40),
    OBESIDAD_III("Obesidad III", 40, Double.MAX_VALUE);

    private final String descripcion;
    private final double limiteInferior;
    private final double limiteSuperior;

    CategoriaIMC(String descripcion, double limiteInferior, double limiteSuperior) {
        this.descripcion = descripcion;
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
    }

    public String getDescripcion() { return descripcion; }
    public double getLimiteInferior() { return limiteInferior; }
    public double getLimiteSuperior() { return limiteSuperior; }
}
