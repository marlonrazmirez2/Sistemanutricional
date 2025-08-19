public class InformacionNutricional {


        private double calorias;
        private double proteinas;
        private double carbohidratos;
        private double grasas;
        private double fibra;
        private double sodio;

        public InformacionNutricional(double calorias, double proteinas, double carbohidratos,
                                      double grasas, double fibra, double sodio) {
            this.calorias = calorias;
            this.proteinas = proteinas;
            this.carbohidratos = carbohidratos;
            this.grasas = grasas;
            this.fibra = fibra;
            this.sodio = sodio;
        }


        public double getCalorias() { return calorias; }
        public void setCalorias(double calorias) { this.calorias = calorias; }

        public double getProteinas() { return proteinas; }
        public void setProteinas(double proteinas) { this.proteinas = proteinas; }

        public double getCarbohidratos() { return carbohidratos; }
        public void setCarbohidratos(double carbohidratos) { this.carbohidratos = carbohidratos; }

        public double getGrasas() { return grasas; }
        public void setGrasas(double grasas) { this.grasas = grasas; }

        public double getFibra() { return fibra; }
        public void setFibra(double fibra) { this.fibra = fibra; }

        public double getSodio() { return sodio; }
        public void setSodio(double sodio) { this.sodio = sodio; }
    }

