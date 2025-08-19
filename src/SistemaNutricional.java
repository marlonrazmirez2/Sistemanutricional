
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
class SistemaNutricional {
    private Persona persona;
    private Map<LocalDate, List<Comida>> registroDiario;
    private List<Alimento> baseAlimentos;

    public SistemaNutricional(Persona persona) {
        this.persona = persona;
        this.registroDiario = new HashMap<>();
        this.baseAlimentos = new ArrayList<>();
    }


    public void agregarAlimento(Alimento alimento) {
        baseAlimentos.add(alimento);
    }


    public void registrarComida(LocalDate fecha, Comida comida) {
        registroDiario.computeIfAbsent(fecha, k -> new ArrayList<>()).add(comida);
    }


    public InformacionNutricional obtenerResumenDiario(LocalDate fecha) {
        List<Comida> comidasDelDia = registroDiario.get(fecha);
        if (comidasDelDia == null || comidasDelDia.isEmpty()) {
            return new InformacionNutricional(0, 0, 0, 0, 0, 0);
        }

        double totalCalorias = 0, totalProteinas = 0, totalCarbohidratos = 0;
        double totalGrasas = 0, totalFibra = 0, totalSodio = 0;

        for (Comida comida : comidasDelDia) {
            InformacionNutricional nutrientes = comida.calcularTotalNutrientes();
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


    public String generarReporteIMC() {
        double imc = persona.calcularIMC();
        CategoriaIMC categoria = persona.obtenerCategoriaIMC();
        double caloriasRecomendadas = persona.calcularCaloriasRecomendadas();

        StringBuilder reporte = new StringBuilder();
        reporte.append("=== REPORTE NUTRICIONAL ===\n");
        reporte.append("Persona: ").append(persona.getNombre()).append("\n");
        reporte.append("IMC: ").append(String.format("%.2f", imc)).append("\n");
        reporte.append("Categoría: ").append(categoria.getDescripcion()).append("\n");
        reporte.append("Calorías recomendadas: ").append(String.format("%.0f", caloriasRecomendadas)).append(" kcal/día\n");

        return reporte.toString();
    }


    public String compararConRecomendaciones(LocalDate fecha) {
        InformacionNutricional consumido = obtenerResumenDiario(fecha);
        double caloriasRecomendadas = persona.calcularCaloriasRecomendadas();

        StringBuilder comparacion = new StringBuilder();
        comparacion.append("=== COMPARACIÓN DIARIA (").append(fecha).append(") ===\n");
        comparacion.append("Calorías consumidas: ").append(String.format("%.0f", consumido.getCalorias())).append(" kcal\n");
        comparacion.append("Calorías recomendadas: ").append(String.format("%.0f", caloriasRecomendadas)).append(" kcal\n");

        double diferencia = consumido.getCalorias() - caloriasRecomendadas;
        if (diferencia > 0) {
            comparacion.append("Exceso: ").append(String.format("%.0f", diferencia)).append(" kcal\n");
        } else if (diferencia < 0) {
            comparacion.append("Déficit: ").append(String.format("%.0f", Math.abs(diferencia))).append(" kcal\n");
        } else {
            comparacion.append("Consumo ideal\n");
        }

        return comparacion.toString();
    }


    public Persona getPersona() { return persona; }
    public List<Alimento> getBaseAlimentos() { return baseAlimentos; }
}