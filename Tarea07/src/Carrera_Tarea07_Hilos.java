import java.util.Random;

class Carro extends Thread {
   private  String nombre;
   private int distanciaRecorrida;
    private int meta;
    private int ran;
//cree un constructor que recibira los parametros
    public Carro(String nombre, int meta,int ran) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
        this.meta = meta;
        this.ran = ran;
    }
//encapsule los atributos de la clase
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(int distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public int getMeta() {
        return meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    public int getRan() {
        return ran;
    }

    public void setRan(int ran) {
        this.ran = ran;
    }

    //sobreescribir el metodo run usando la herencia de Hilos (Threads
    @Override
    public void run() {
        while (this.distanciaRecorrida <=this.meta) {//este ciclo se repetira hasta llegar el numero de la meta
            Random random = new Random();//instanciamos random para generar un numero aleatorio
            int avance = random.nextInt(this.ran);//pasamos el numero aleatorio a la variable avance
            this.distanciaRecorrida += avance;//en la variable distanciaRecorrida guardamos una suma iterativa
            StringBuilder avanceString = new StringBuilder();//con esta linea de codigo usamos el metodo appened para concatenar el -
            for (int i = 0; i < avance; i++) {//se crea un ciclo for para imprimir el numero de - guiones que nos da random
                avanceString.append("-");
            }

            synchronized (System.out) {//usamos synchonized para imprimir simultaneamente las lineas siguientes
               //y evitar que se mezclen, o distorcionen
                System.out.print(this.nombre + ": " + avanceString.toString());
                System.out.println(" 🚗 "+ this.distanciaRecorrida );
                System.out.print(" (Total: " + this.distanciaRecorrida + ")\r"); // \r mueve el cursor al principio de la línea
                if (this.distanciaRecorrida>=this.meta){
                    //en esta condicion validamos quien llega primero a la meta
                    System.out.println(this.nombre+"Llego a la meta, Con distancia recorrida de "+this.distanciaRecorrida);
                    break;
                }
            }

            try {
                Thread.sleep(1000); //aqui podemos controlar la velocidad de programa

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}