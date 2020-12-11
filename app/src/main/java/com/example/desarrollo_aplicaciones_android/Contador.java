package com.example.desarrollo_aplicaciones_android;


       public class Contador {
        private int cafes;
        private int tiempo;
        private  static final int PAUSA = 5;

        public Contador() {
            this.cafes = 0;
            this.tiempo = PAUSA;
        }

        public Contador(int c, int t) {
            this.cafes = c;
            this.tiempo = t;
        }

           public void setCafes(int cafes) {
               this.cafes = cafes;
           }

           public int getCafes() {
               return cafes;
           }

           public String  contadorCero(){
            this.cafes= 0;
            return String.valueOf(this.cafes);

           }

           public String aumentarTiempo(){
            this.tiempo += 1;
            return String.valueOf(this.tiempo) + ":00";
        }

        public String reducirTiempo(){
            this.tiempo -= 1;
            if (this.tiempo < 1)
                tiempo = 1;
            return String.valueOf(this.tiempo) + ":00";
        }

        public String aumentarCafes(){
            this.cafes += 1;
            return String.valueOf(this.cafes);
        }

        public int getTiempo(){
            return  this.tiempo;
        }

    }

