package com.erichiroshi.cursomc.domain;

import java.io.Serializable;

import com.erichiroshi.cursomc.domain.enums.EstadoPagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer estado;

	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId
	private Pedido pedido;

	public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
		this.id = id;
		setEstado(estado);
		this.pedido = pedido;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.valueOf(estado);
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCode();
	}
}
