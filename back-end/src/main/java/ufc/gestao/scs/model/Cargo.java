package ufc.gestao.scs.model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulacao;

    @Column(name = "missao", columnDefinition = "TEXT")
    private String missao;
    

    private String experienciaMinima;
    private String area;
    private String unidade;

    private Double salarioBaseMinimo;
    private Double salarioBaseMaximo;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="cargo_beneficio", joinColumns = {@JoinColumn(name="id")}, inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
    private List<Beneficio> beneficios;

    @ManyToMany
    @JoinTable(name = "cargo_has_treinamento", joinColumns = @JoinColumn(referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private List<Treinamento> treinamentos;

    @OneToMany
    @JoinTable(name = "cargo_has_conhecimento", joinColumns = @JoinColumn(referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private List<Conhecimento> conhecimentos;

    @OneToMany
    @JoinTable(name = "cargo_has_atividade", joinColumns = @JoinColumn(referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private List<Atividade> atividades;

    @OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionarios;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getMissao() {
        return missao;
    }

    public void setMissao(String missao) {
        this.missao = missao;
    }

    public String getExperienciaMinima() {
        return experienciaMinima;
    }

    public void setExperienciaMinima(String experienciaMinima) {
        this.experienciaMinima = experienciaMinima;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getSalarioBaseMinimo() {
        return salarioBaseMinimo;
    }

    public void setSalarioBaseMinimo(Double salarioBaseMinimo) {
        this.salarioBaseMinimo = salarioBaseMinimo;
    }

    public Double getSalarioBaseMaximo() {
        return salarioBaseMaximo;
    }

    public void setSalarioBaseMaximo(Double salarioBaseMaximo) {
        this.salarioBaseMaximo = salarioBaseMaximo;
    }

    public List<Beneficio> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List<Beneficio> beneficios) {
        this.beneficios = beneficios;
    }

    public List<Treinamento> getTreinamentos() {
        return treinamentos;
    }

    public void setTreinamentos(List<Treinamento> treinamentos) {
        this.treinamentos = treinamentos;
    }

    public List<Conhecimento> getConhecimentos() {
        return conhecimentos;
    }

    public void setConhecimentos(List<Conhecimento> conhecimentos) {
        this.conhecimentos = conhecimentos;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    /**
     * @return the funcionarios
     */
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    /**
     * @param funcionarios the funcionarios to set
     */
    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}