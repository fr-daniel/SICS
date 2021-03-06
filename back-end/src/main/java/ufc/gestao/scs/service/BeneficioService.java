package ufc.gestao.scs.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import ufc.gestao.scs.model.Beneficio;
import ufc.gestao.scs.model.Treinamento;

public interface BeneficioService {

    List<Map<String, Object>> buscarBeneficios();
    List<Map<String, Object>> findAllCargosBeneficios(Integer id);

    void excluirBeneficio(Integer id);

    Beneficio salvarBeneficio(Beneficio b);

    Optional<Beneficio> findById(Integer id);
    
    Map<String, Object> findBeneficioById(Integer id);
}