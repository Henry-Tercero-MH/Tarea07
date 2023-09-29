import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //instanciamos scanner para pedir datos
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite la meta: ");
        int meta = entrada.nextInt();
        System.out.println("Digita el rango de avance: ");
        int aleatorio = entrada.nextInt();
        //pintaremos una bandera e imprimiremos trambien la meta
         String banderaCuadros = "\u1F3C";
        System.out.println("Meta................................................... " +meta+ banderaCuadros);
    //instanciamos 4 objetos de tipo Carro y le pasamos datos
        Carro carro1 = new Carro("Car.1", meta, aleatorio);
        Carro carro2 = new Carro("Car.2", meta, aleatorio);
        Carro carro3 = new Carro("Car.3", meta, aleatorio);
        Carro carro4 = new Carro("Car.4", meta, aleatorio);
//iniciamos la ejeucion de cada hilo
        carro1.start();
        carro2.start();
        carro3.start();
        carro4.start();
    }
}


