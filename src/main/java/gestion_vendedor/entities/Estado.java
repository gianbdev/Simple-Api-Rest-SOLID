package gestion_vendedor.entities;

public enum Estado {
	ACTIVO("A"), INACTIVO("I");

	private final String codigo;

	Estado(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public static Estado fromCodigo(String codigo) {
		for (Estado estado : Estado.values()) {
			if (estado.getCodigo().equals(codigo)) {
				return estado;
			}
		}
		throw new IllegalArgumentException("Código de estado inválido: " + codigo);
	}
}
