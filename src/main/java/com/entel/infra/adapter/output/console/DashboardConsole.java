package com.entel.infra.adapter.output.console;

import com.entel.app.usecase.*;
import com.entel.domain.service.LoginService;
import com.entel.infra.adapter.input.PagoRepositoryImpl;
import com.entel.infra.adapter.input.ReservaRepositoryImpl;
import com.entel.infra.adapter.input.UsuarioRepositoryImpl;
import com.entel.infra.adapter.input.VueloRepositoryImpl;

import java.util.Scanner;

public class DashboardConsole {

    public static void main(String[] args) {
        // Crear dependencias para los servicios y repositorios
        UsuarioRepositoryImpl usuarioRepository = new UsuarioRepositoryImpl();
        LoginService loginService = new LoginService(usuarioRepository);
        LoginUseCaseImpl loginUseCase = new LoginUseCaseImpl(loginService);

        VueloRepositoryImpl vueloRepository = new VueloRepositoryImpl();
        BuscarVueloService buscarVueloService = new BuscarVueloService(vueloRepository);
        VerificarCapacidadService verificarCapacidadService = new VerificarCapacidadService(vueloRepository);

        ReservaRepositoryImpl reservaRepository = new ReservaRepositoryImpl();
        CrearReservaService crearReservaService = new CrearReservaService(reservaRepository, vueloRepository);
        ProcesarPagoService procesarPagoService = new ProcesarPagoService(new PagoRepositoryImpl());

        // Scanner para recibir entradas del usuario
        Scanner scanner = new Scanner(System.in);

        // Menú de opciones
        while (true) {
            try {
                System.out.println("\n*** MENÚ DE OPCIONES ***");
                System.out.println("1. Login");
                System.out.println("2. Buscar Vuelos");
                System.out.println("3. Crear Reserva");
                System.out.println("4. Verificar Capacidad");
                System.out.println("5. Procesar Pago");
                System.out.println("6. Salir");
                System.out.print("Selecciona una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar buffer

                switch (opcion) {
                    case 1:
                        // Login
                        System.out.print("Username: ");
                        String username = scanner.nextLine();
                        System.out.print("Password: ");
                        String password = scanner.nextLine();

                        boolean loginExitoso = loginUseCase.ejecutar(username, password);
                        if (! loginExitoso) {
                            System.out.println("Login exitoso!");
                        } else {
                            System.out.println("Credenciales incorrectas.");
                        }
                        break;

                    case 2:
                        // Buscar vuelos
                        System.out.print("Origen: ");
                        String origen = scanner.nextLine();
                        System.out.print("Destino: ");
                        String destino = scanner.nextLine();
                        System.out.print("Fecha: ");
                        String fecha = scanner.nextLine();

                        buscarVueloService.buscarVuelos(origen, destino, fecha).forEach(vuelo ->
                                System.out.println("Vuelo encontrado: " + vuelo.getIdVuelo() + ", " + vuelo.getOrigen() + " -> " + vuelo.getDestino())
                        );
                        break;

                    case 3:
                        // Crear reserva
                        System.out.print("ID de Usuario: ");
                        String idUsuario = scanner.nextLine();
                        System.out.print("ID de Vuelo: ");
                        String idVuelo = scanner.nextLine();

                        crearReservaService.crearReserva(idUsuario, idVuelo);
                        System.out.println("Reserva creada exitosamente.");
                        break;

                    case 4:
                        // Verificar capacidad
                        System.out.print("ID de Vuelo: ");
                        String vueloId = scanner.nextLine();
                        System.out.print("Cantidad de pasajeros: ");
                        int cantidadPasajeros = scanner.nextInt();
                        scanner.nextLine();  // Limpiar buffer

                        boolean capacidadSuficiente = verificarCapacidadService.verificarCapacidad(vueloId, cantidadPasajeros);
                        if (capacidadSuficiente) {
                            System.out.println("Capacidad suficiente.");
                        } else {
                            System.out.println("Capacidad insuficiente.");
                        }
                        break;

                    case 5:
                        // Procesar pago
                        System.out.print("ID de Reserva: ");
                        String idReserva = scanner.nextLine();
                        System.out.print("Monto: ");
                        double monto = scanner.nextDouble();
                        scanner.nextLine();  // Limpiar buffer
                        System.out.print("Método de pago: ");
                        String metodoPago = scanner.nextLine();

                        procesarPagoService.procesarPago(idReserva, monto, metodoPago);
                        System.out.println("Pago procesado exitosamente.");
                        break;

                    case 6:
                        // Salir
                        System.out.println("¡Hasta luego!");
                        return;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                // Manejo de excepciones global
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
