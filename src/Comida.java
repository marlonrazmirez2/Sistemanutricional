import java.util.List;
import java.util.ArrayList;

class Comida {
    private String tipo;
    private List<Porcion> porciones;

    public Comida(String tipo) {
        this.tipo = tipo;
        this.porciones = new ArrayList<>();
    }

    public void agregarPorcion(Porcion porcion) {
        porciones.add(porcion);
    }

    public void removerPorcion(Porcion porcion) {
        porciones.remove(porcion);
    }


    public InformacionNutricional calcularTotalNutrientes() {
        double totalCalorias = 0, totalProteinas = 0, totalCarbohidratos = 0;
        double totalGrasas = 0, totalFibra = 0, totalSodio = 0;

        for (Porcion porcion : porciones) {
            InformacionNutricional nutrientes = porcion.obtenerNutrientes();
            totalCalorias += nutrientes.getCalorias();
            totalProteinas += nutrientes.getProteinas();
            totalCarbohidratos += nutrientes.getCarbohidratos();
            totalGrasas += nutrientes.getGrasas();
            totalFibra += nutrientes.getFibra();
            totalSodio += nutrientes.getSodio();
        }

        return new InformacionNutricional(totalCalorias, totalProteinas,
                totalCarbohidratos, totalGrasas,
                totalFibra, totalSodio);
    }


    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public List<Porcion> getPorciones() { return porciones; }
    public void setPorciones(List<Porcion> porciones) { this.porciones = porciones; }
}