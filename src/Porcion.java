public class Porcion {
    private Alimento alimento;
    private double gramos;

    public Porcion(Alimento alimento, double gramos) {
        this.alimento = alimento;
        this.gramos = gramos;
    }

    public InformacionNutricional obtenerNutrientes() {
        return alimento.calcularNutrientes(gramos);
    }


    public Alimento getAlimento() { return alimento; }
    public void setAlimento(Alimento alimento) { this.alimento = alimento; }

    public double getGramos() { return gramos; }
    public void setGramos(double gramos) { this.gramos = gramos; }
}
