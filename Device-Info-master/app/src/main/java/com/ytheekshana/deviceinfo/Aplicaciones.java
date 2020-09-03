package com.ytheekshana.deviceinfo;

public class Aplicaciones {

        private int id;
        private String name;

        public Aplicaciones(){}

        public Aplicaciones(int id, String name){
            this.setId(id);
            this.setName(name);
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

}
