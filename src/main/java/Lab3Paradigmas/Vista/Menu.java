package Lab3Paradigmas.Vista;

import Lab3Paradigmas.Controlador.Control;
import java.util.Scanner;

/**
 * Clase que representa un menu
 */
public class Menu {
    int opcion;
    private Control controlador;

    /**
     * Constructor de instancia de un menu
     */
    public Menu() {
        this.controlador = null;
    }

    /**
     * Pide el nombre de un jugador a registrar
     * @param scanner para poder ingresar datos por teclado
     * @return el nombre ingresado por el usuario
     */
    public String pedirNombre(Scanner scanner){
        scanner.nextLine();
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.nextLine();
        scanner.reset();
        return nombre;
    }

    /**
     * Pide un numero entero y se asegura de que asi sea
     * @param scanner para poder ingresar datos por teclado
     * @return el dato ingresado por el usuario
     */
    public int pedirOpcion(Scanner scanner){
        boolean flagEntry = true;
        int opcion = 0;
        while (flagEntry) {
            try {
                opcion = scanner.nextInt();
                flagEntry = false;
            } catch (Exception e) {
                System.out.println("Por favor elija una opcion correcta");
                scanner.reset();
            }
        }
        return opcion;
    }

    /**
     * Pide un numero entero entre un rango de nuemeros y se asegura de que asi sea
     * @param min cota inferior del rango
     * @param max cota superior del rango
     * @param scanner para poder ingresar datos por tecladoss
     * @return el dato ingresado por el usuario
     */
    public int pedirOpcion(int min, int max, Scanner scanner){
        boolean flagEntry = true;
        int opcion = 0;
        while (flagEntry) {
            try {
                opcion = scanner.nextInt();
                if (opcion > max || opcion < min) {
                    throw new Exception();
                } else
                    flagEntry = false;
            } catch (Exception e) {
                System.out.println("Por favor elija una opcion correcta");
                scanner.reset();
            }
        }
        return opcion;
    }

    /**
     * Se encarga de mostrar el menu principal y llammar a controlador para que ejecutar las acciones elegidas
     */
    public void MenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        boolean flagContinue = true;
        while (flagContinue) {
            System.out.println("Bienvenido a Dobble");
            System.out.println("¿Que desea hacer?");
            System.out.println("1. Crear un juego nuevo");
            System.out.println("2. Registrar un jugador");
            System.out.println("3. Elegir/Cambiar modo de juego");
            System.out.println("4. Ver descripcion de cada modo de juego");
            System.out.println("5. Jugar");
            System.out.println("6. Salir");
            System.out.println("Ingrese el indice de una de las opciones de arriba: ");
            this.opcion = pedirOpcion(1,6,scanner);
            switch (this.opcion){
                case 1:
                    this.menuOpcion1(scanner);
                    break;
                case 2:
                    this.menuOpcion2(scanner);
                    break;
                case 3:
                    this.menuOpcion3(scanner);
                    break;
                case 4:
                    this.menuOpcion4();
                    break;
                case 5:
                    this.menuOpcion5();
                    break;
                case 6:
                    System.out.println("Gracias por jugar Dobble");
                    System.out.println("¡Hasta luego!");
                    flagContinue = false;

            }
        }
        scanner.close();
    }

    /**
     * Se encarga de crear un juego nuevo
     * @param scanner para leer datos por teclado
     */
    public void menuOpcion1(Scanner scanner){
        System.out.println("¿Cuantos simbolos desea por carta?:");
        int numE = pedirOpcion(scanner);
        System.out.println("¿Cuantas cartas desea generar?");
        System.out.println("¡Importante!, si ingresa una cantidad mayor a la que es posible generar" +
                " con la cantidad de simbolos ingresados se creará el maximo de cartas posibles");
        int maxC = pedirOpcion(scanner);
        this.controlador = new Control(numE,maxC);
        System.out.println(this.controlador.getGame().getCardsSet().getCartas().get(0).getCantidadSimbolos());
        if (!this.controlador.getGame().getCardsSet().esCorrecto()){
            System.out.println("La cantidad de simbolos no es correcta");
            System.out.println("La cantidad de simbolos - 1 debe ser potencia de un numero primo");
            System.out.println("*******Juego no creado*******");
            this.controlador = null;
        }else{
            System.out.println("Juego creado con exito");
            System.out.println("Las cartas del mazo son las siguientes");
            this.controlador.getGame().getCardsSet().mostrarCartas();
        }
    }

    /**
     * Se encarga de registrar un nuevo jugador
     * @param scanner para poder ingresar datos por teclados
     */
    public void menuOpcion2(Scanner scanner){
        if (this.controlador!=null){
            System.out.println();
            String nombre = this.pedirNombre(scanner);
            this.controlador.registrar(nombre);
            System.out.println("Jugador " + nombre + " registrado con exito");
            System.out.println("Jugadores registrados: "+this.controlador.getGame().
                    getJugadores().toString());
        }else
            System.out.println("Para registrar un jugador primero debe crear un juego");
    }

    /**
     * Se encarga de elegir el modo de juego
     * @param scanner para poder ingresar datos por teclado
     */
    public void menuOpcion3(Scanner scanner) {
        if (this.controlador != null) {
            System.out.println("Los modos de juego disponibles para jugar son los siguientes:");
            System.out.println("1. Stack");
            System.out.println("2. Empty Hand Stack");
            System.out.print("Elija el indice de uno de los modos de juego: ");
            int mode = pedirOpcion(1, 2, scanner);
            if(mode == 2){
                System.out.println("¿Cuantas cartas desea repartir a cada jugador?");
                this.controlador.setCartasARepartir(pedirOpcion(scanner));
                if (this.controlador.getCartasARepartir() > (this.controlador.getGame().getCardsSet().getCantidadCartas()-1)
                        /this.controlador.getGame().getCantidadJugadores()){
                    System.out.println("No hay suficientes cartas para repartir y poder jugar");
                    System.out.println("Modo de juego no elegido");
                    return;
                }
            }
            this.controlador.elegirModo(mode);
            System.out.println("Modo de juego "+this.controlador.getModoDeJuego().toString() +" elegido con exito:");
        } else {
            System.out.println("Para elegir el modo de juego debe haber creado un juego previamente");
            System.out.println("Modo de juego no elegido");
        }
    }

    /**
     * Muestra en pantalla una descripcion de cada modo de juego
     */
    public void menuOpcion4(){
        System.out.println("Stack: Se disponen el conjunto de cartas apiladas por el reverso en el tablero.\n" +
                " Luego se retiran las dos primeras cartas de la pila y se voltean para revelar su contenido\n" +
                " sobre la mesa. A continuación, el primer jugador que identifique el elemento común entre estas\n" +
                " dos cartas, se queda con las cartas. El juego termina cuando no quedan más cartas por voltear y gana\n" +
                " aquel jugador que tiene más cartas.\n\n");
        System.out.println("EmptyHandsStack: Cada jugador parte con un número igual de cartas en su poder  y debe\n" +
                " quedar una pila de cartas al centro. Las cartas asignadas al jugador y las del stack deben estar\n" +
                " volteadas sin revelar su contenido. A continuación, se voltea una carta desde la pila y todos los\n" +
                " jugadores voltean una de las que tienen en su poder. El primero que identifique coincidencias entre\n" +
                " su carta y la de la pila, puede descartar su carta junto a la que se volteó desde la pila. La carta\n" +
                " descartada y la de la pila se reubican en la base de ésta. Por otro lado, el resto de los jugadores\n" +
                " vuelve a recoger su propia carta. El juego continúa hasta que uno de los jugadores quede sin cartas\n" +
                " en su poder, quién será el ganador.\n");
    }

    /**
     * Se encarga de ejecutar la partida en el modo de juego elegido
     */
    public void menuOpcion5() {
        try {
            if (this.controlador.getGame().getCantidadJugadores() >= 2) {
                System.out.println("Modo de juego: " + this.controlador.getModoDeJuego().toString());
                this.controlador.jugar();
                System.out.println("Ganador = "+this.controlador.obtenerGanador().toString());
                System.out.println("Para volver a jugar debe crear un juego nuevo");
            } else {
                System.out.println("Para poder jugar debe haber al menos 2 jugadores registrados");
            }
        } catch (Exception e) {
            System.out.println("Para poder jugar debe elegir el modo de juego primero");
        }
    }
}
