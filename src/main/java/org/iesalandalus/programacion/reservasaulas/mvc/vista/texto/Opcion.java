package org.iesalandalus.programacion.reservasaulas.mvc.vista.texto;

import javax.naming.OperationNotSupportedException;

public enum Opcion {
	
	SALIR("Salir") {
		public void ejecutar() {
			vista.salir();
		}
	},
	
	INSERTAR_AULA("Insertar aula") {
		public void ejecutar() throws OperationNotSupportedException {
			vista.insertarAula();
		}
	},
	
	BORRAR_AULA("Borrar aula") {
		public void ejecutar() throws OperationNotSupportedException {
			vista.borrarAula();
		}
	},
	
	BUSCAR_AULA("Buscar aula") {
		public void ejecutar() {
			vista.buscarAula();
		}
	},
	
	LISTAR_AULAS("Listar aulas") {
		public void ejecutar() {
			vista.listarAulas();
		}
	},
	
	INSERTAR_PROFESOR("Insertar profesor") {
		public void ejecutar() throws OperationNotSupportedException {
			vista.insertarProfesor();
		}
	},
	
	BORRAR_PROFESOR("Borrar profesor") {
		public void ejecutar() throws OperationNotSupportedException {
			vista.borrarProfesor();
		}
	},
	
	BUSCAR_PROFESOR("Buscar profesor") {
		public void ejecutar() {
			vista.buscarProfesor();
		}
	},

	LISTAR_PROFESORES("Listar profesores") {
		public void ejecutar() {
			vista.listarProfesores();
		}
	},
	
	INSERTAR_RESERVA("Insertar reserva") {
		public void ejecutar() throws OperationNotSupportedException {
			vista.realizarReserva();
		}
	},
	BORRAR_RESERVA("Borrar reserva") {
		public void ejecutar() throws OperationNotSupportedException {
			vista.anularReserva();
		}
	},
	
	LISTAR_RESERVAS("Listar reservas") {
		public void ejecutar() {
			vista.listarReservas();
		}
	},
	
	LISTAR_RESERVAS_AULA("Listar reservas aula") {
		public void ejecutar() {
			vista.listarReservasAula();
		}
	},
	LISTAR_RESERVAS_PROFESOR("Listar reservas profesor") {
		public void ejecutar() {
			vista.listarReservaProfesor();
		}
	},
	CONSULTAR_DISPONIBILIDAD("Consultar disponibilidad") {
		public void ejecutar() {
			vista.consultarDisponibilidad();
		}
	};

	private String mensajeAMostrar;
	private static VistaTexto vista;

	private Opcion(String mensajeAMostrar) {
		this.mensajeAMostrar = mensajeAMostrar;
	}
	
	public String getMensaje() {

		return mensajeAMostrar;
	}

	public abstract void ejecutar() throws OperationNotSupportedException;

	protected static void setVista(VistaTexto vista) {
		if (vista == null) {
			throw new NullPointerException("ERROR: La vista no pueda ser nula.");
		}
		Opcion.vista = vista;
	}
	
	@Override
	public String toString() {
		return String.format("%d.- %s", ordinal(), mensajeAMostrar);
	}

	public static Opcion getOpcionSegunOrdinal(int ordinal) {
		if (!esOrdinalValido(ordinal)) {
			throw new IllegalArgumentException("Ordinal de la opción no válido");
		}
		return values()[ordinal];
	}

	public static boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length - 1);
	}

}
