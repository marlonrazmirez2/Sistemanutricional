public class Persona {

    private String nombre;
    private int edad;
    private double peso;
    private double altura;
    private String genero;
    private String nivelActividad;

    public Persona(String nombre, int edad, double peso, double altura,
                   String genero, String nivelActividad) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.genero = genero;
        this.nivelActividad = nivelActividad;
    }


    public double calcularIMC() {
        return peso / (altura * altura);
    }


    public CategoriaIMC obtenerCategoriaIMC() {
        double imc = calcularIMC();
        for (CategoriaIMC categoria : CategoriaIMC.values()) {
            if (imc >= categoria.getLimiteInferior() && imc < categoria.getLimiteSuperior()) {
                return categoria;
            }
        }
        return CategoriaIMC.OBESIDAD_III;
    }


    public double calcularMetabolismoBasal() {
        if (genero.equalsIgnoreCase("masculino")) {
            return 88.362 + (13.397 * peso) + (4.799 * altura * 100) - (5.677 * edad);
        } else {
            return 447.593 + (9.247 * peso) + (3.098 * altura * 100) - (4.330 * edad);
        }
    }


    public double calcularCaloriasRecomendadas() {
        double metabolismoBasal = calcularMetabolismoBasal();
        double factorActividad;

        switch (nivelActividad.toLowerCase()) {
            case "sedentario":
                factorActividad = 1.2;
                break;
            case "ligero":
                factorActividad = 1.375;
                break;
            case "moderado":
                factorActividad = 1.55;
                break;
            case "intenso":
                factorActividad = 1.725;
                break;
            case "muy intenso":
                factorActividad = 1.9;
                break;
            default:
                factorActividad = 1.2;
        }

        return metabolismoBasal * factorActividad;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNivelActividad() {
        return nivelActividad;
    }

    public void setNivelActividad(String nivelActividad) {
        this.nivelActividad = nivelActividad;
    }
}