package com.stm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.stm.data.entity.Agente;

public interface AgenteService {

    Iterable<Agente> listAllAgentes();

    Agente getAgenteById(Integer id);

    Agente saveAgente(Agente agente);

    void deleteAgente(Integer id);

    Page<Agente> findAll(Pageable pageable);

}
