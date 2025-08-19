public class Alimento {
    private String nombre;
    private String categoria;
    private InformacionNutricional infoNutricional; // Por 100g

    public Alimento(String nombre, String categoria, InformacionNutricional infoNutricional) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.infoNutricional = infoNutricional;
    }


    public InformacionNutricional calcularNutrientes(double gramos) {
        double factor = gramos / 100.0;
        return new InformacionNutricional(
                infoNutricional.getCalorias() * factor,
                infoNutricional.getProteinas() * factor,
                infoNutricional.getCarbohidratos() * factor,
                infoNutricional.getGrasas() * factor,
                infoNutricional.getFibra() * factor,
                infoNutricional.getSodio() * factor
        );
    }


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public InformacionNutricional getInfoNutricional() { return infoNutricional; }
    public void setInfoNutricional(InformacionNutricional infoNutricional) {
        this.infoNutricional = infoNutricional;
    }
}
