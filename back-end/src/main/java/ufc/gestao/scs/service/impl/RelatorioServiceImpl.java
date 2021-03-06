package ufc.gestao.scs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ufc.gestao.scs.model.Cargo;
import ufc.gestao.scs.repository.CargoRepository;
import ufc.gestao.scs.service.RelatorioService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class RelatorioServiceImpl implements RelatorioService {

	@Autowired
	private CargoRepository cargoRepository;
	 
	@Override
	public List<Map<String, Object>> buscarInfoCargos() {
		List<Cargo> cargos = cargoRepository.findAll();
		
		for (Cargo cargo : cargos) {
			System.out.println(cargoRepository.findBeneficiosByCargoId(cargo.getId()).size());
		}
		
		return null;
	}

}
