package ufc.gestao.scs.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "beneficio")
public class Beneficio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    @Column(name = "informacoes", columnDefinition = "TEXT")
    private String informacoes;

    private Double valor;
    
    @ManyToMany(mappedBy = "beneficios", cascade = CascadeType.ALL)
    private List<Cargo> cargos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    public List<Cargo> getCargos() {
		return cargos;
	}
    
    public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

}