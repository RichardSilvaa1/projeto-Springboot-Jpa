package com.educandoweb.course.entities.enums;

public enum OrderStatus {

	AGUARDANDO_PAGAMENTO(1), PAGO(2), ENVIADO(3), ENTREGUE(4), CANCELADO5(5);

	private int code;

	private OrderStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	// metodo statico para converter um valor numero em um tipo enumerado

	public static OrderStatus valueOf(int code) throws IllegalAccessException {
		//percorre o status
		for (OrderStatus value : OrderStatus.values()) {
			// compara os code
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalAccessException("OrderStatus inexistente");
	}

}
