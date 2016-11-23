package com.adaming.myapp.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IBanqueDao;
import com.adaming.myapp.entities.Banque;

import com.adaming.myapp.exceptions.BanqueExistanteException;



@Transactional
public class BanqueServiceImpl implements IBanqueService{
		
		private IBanqueDao dao;
		
		public void setDao(IBanqueDao dao) {
			LOGGER.info("<--------- dao injected -------->");
			this.dao = dao;
		}

		private final Logger LOGGER  = Logger.getLogger("BanqueServiceImpl");
		

		
	@Override
	public Banque save(Banque b) throws BanqueExistanteException {
		List<Banque> banques = getAll();
		int i = 0;
        for (Banque b1 : banques){
            if(b1.getId()==b.getId()){
                i++;
            }
        }
        if (i==0){
        	LOGGER.info("La banque "+b.getNom()+" a bien été enregistrée.");
        	return dao.save(b);
        }else{
        	throw new BanqueExistanteException("La banque existe déjà."); 
        }
	}

	@Override
	public Banque update(Banque b) throws BanqueExistanteException {
		List<Banque> banques = getAll();
		int i = 0;
        for (Banque b1 : banques){
            if(b1.getId()==b.getId()){
                i++;
            }
        }
        if (i==0){
        	throw new BanqueExistanteException("La banque n'existe pas"); 
        }else{
        	LOGGER.info("La banque "+b.getNom()+" a bien été mise-à-jour");
        	return dao.update(b);
        }
	}

	@Override
	public Banque getOne(Long id) throws BanqueExistanteException {
		List<Banque> banques = getAll();
		int i = 0;
        for (Banque b1 : banques){
            if(b1.getId()==id){
                i++;
            }
        }
        if (i==0){
            throw new BanqueExistanteException("La banque n'existe pas");
        }else{
        	LOGGER.info("La banque ayant pour identidiant "+id+" est la suivante :");
            return dao.getOne(id);
        }
	}

	@Override
	public List<Banque> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public Banque remove(Long id) {
		// TODO Auto-generated method stub
		return dao.remove(id);
	}

}
